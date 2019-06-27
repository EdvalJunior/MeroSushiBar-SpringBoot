package com.spring.br.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.br.models.Pedido;
import com.spring.br.models.PedidoManager;
import com.spring.br.repository.PedidoManagerRepository;

@Service
public class PedidoManagerService {

	@Autowired
	private PedidoManagerRepository pedMR;
	
	public String salvarItem(List<PedidoManager> itens) {
		pedMR.saveAll(itens);
		return "Item Cadastrado.";
	}

	public List<PedidoManager> listarItens() {
		return pedMR.findAll();
	}

	public List<PedidoManager> listarItensPorPedido(Long idPedido) {
		return pedMR.findAll();
	}
	
	public String excluirPrato(Long id) {
		PedidoManager pm = this.buscarItemPorId(id);
		
		if( pm == null)
			return "Não foi possivel remover o item.";
		pedMR.deleteById(id);
		return "Item Removido.";
	}

	public PedidoManager buscarItemPorId(Long codigo) {
		PedidoManager item = pedMR.getOne(codigo);

		if (item == null)
			return null;

		return item;
	}
	

	public List<PedidoManager> addIdPedido(Pedido pedido, List<PedidoManager> itens) {
		List<PedidoManager> itensNovo = new ArrayList<>();
		for (PedidoManager item : itens) {
			item.setPedido(pedido);
			itensNovo.add(item);
		}
		
		return itensNovo;
}
	
}
