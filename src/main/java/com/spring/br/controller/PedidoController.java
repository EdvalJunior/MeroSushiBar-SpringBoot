package com.spring.br.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.br.models.Carrinho;
import com.spring.br.models.Cliente;
import com.spring.br.models.Pedido;
import com.spring.br.models.PedidoManager;
import com.spring.br.models.Prato;
import com.spring.br.service.ClienteService;
import com.spring.br.service.PedidoManagerService;
import com.spring.br.service.PedidoService;
import com.spring.br.service.PratoService;


@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private Carrinho carrinho;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PratoService pratoService;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private PedidoManagerService itemService;

	@RequestMapping("/inicio")
	public String pedidoIni() {
		return "pedido";
	}
	
	@RequestMapping("/adicionar/carrinho/{codigo}/{quantidade}")
	public ModelAndView addItemCarrinho(@PathVariable Long codigo, @PathVariable Long quantidade,RedirectAttributes redir) {
		PedidoManager item = new PedidoManager();
		Prato prato = pratoService.buscarPrato(codigo);

		item.setPrato(prato);
		item.setQuantidade(quantidade);
		item.setPrecoTotal(prato.getPreco_prato() * quantidade);
		carrinho.addItem(item);

		ModelAndView mv = new ModelAndView("redirect:/");

		redir.addFlashAttribute("listaItems", carrinho.getItens());

		return mv;
	}

	@RequestMapping("/remover/carrinho/{codigo}")
	public ModelAndView removerItemCarrinho(@PathVariable int codigo, RedirectAttributes redir) {

		carrinho.deleteItem(codigo);

		ModelAndView mv = new ModelAndView("redirect:/");

		redir.addFlashAttribute("listaItems", carrinho.getItens());

		return mv;
	}

	@RequestMapping("/realizarPedido/{endereco}")
	public ModelAndView salvarPedido(@PathVariable String idPessoa) throws Exception {
		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails user = (UserDetails) auth;
		Cliente cliente = clienteService.buscaPorLogin(user.getUsername());

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPedidosM(carrinho.getItens());
		pedido.setTotalPedido(carrinho.getTotal());
		pedido.setDataPedido(new Date());
		
		if( cliente.getCodigo() == null)
			throw new Exception("Cliente não encontrado!");
		else
			pedido.getCliente().setEndereco_cliente(cliente.getEndereco_cliente());

		ModelAndView mv = new ModelAndView("redirect:/");

		pedidoService.salvarPedido(pedido);
		carrinho.setItens(itemService.addIdPedido(pedido, carrinho.getItens()));
		itemService.salvarItem(pedido.getPedidosM());

		mv.addObject("message", "Pedido cadastrado!");
		carrinho.getItens().clear();
		return mv;
	}

	@RequestMapping("/clientePedidos")
	public ModelAndView historicoPedido() {

		Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userd = (UserDetails) auth;
		Cliente cliente= clienteService.buscaPorLogin(userd.getUsername()); 

		ModelAndView mv = new ModelAndView("pedidos");

		List<Pedido> pedidos= pedidoService.listarPedidosPessoa(cliente.getCodigo());

		if (pedidos == null) {
			pedidos = new ArrayList<>();
			pedidos.add(new Pedido());
		}

		mv.addObject("pedidos", pedidos);
		return mv;
}
	
	
}
