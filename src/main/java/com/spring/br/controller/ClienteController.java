package com.spring.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.br.models.Cliente;
import com.spring.br.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteS;
	
	@RequestMapping("/formCliente")
	public ModelAndView retornarForm() {
		ModelAndView mv = new ModelAndView("clienteCadastro");
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping("/cadastrarCliente")
	public ModelAndView cadastrarCliente(@Validated Cliente cliente, BindingResult result, @RequestParam(value = "imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView("clienteCadastro");
		
		if(result.hasErrors()) {
			return mv;
		}
		
		mv.addObject("mensagem", "Pessoa Cadastrada com sucesso");
		clienteS.cadastrarCliente(cliente, imagem);
		return mv;
	}
	
	@RequestMapping("/listarClientes")
	public ModelAndView listar() {
		List<Cliente> clientes = clienteS.listarClientes();
		ModelAndView mv = new ModelAndView("clienteListar");
		mv.addObject("listaCliente", clientes);
		return mv;
	}
	
	@RequestMapping("/excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Long codigo) {
		clienteS.excluirCliente(codigo);
		ModelAndView mv= new ModelAndView("redirect:/cliente/listarClientes");
		return mv;
	}
	
	@RequestMapping("/alterar/{codigo}")
	public ModelAndView alterar(@PathVariable Long codigo) {
		Cliente cliente= clienteS.buscarCliente(codigo);
		ModelAndView mv= new ModelAndView("clienteCadastro");
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@RequestMapping("/logar")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
}
