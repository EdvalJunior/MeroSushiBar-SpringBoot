package com.spring.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.br.models.Pedido;
import com.spring.br.repository.PedidoRepository;


@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
		
	public void salvarPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();
	}
	
	public List<Pedido> listarPedidosPessoa(Long idPessoa) {
		return pedidoRepository.findAll();
	}

	public String excluirPedido(Long codigo) {
		Pedido pedido = buscarPedidoPorId(codigo);

		if (pedido == null)
			return "Não Foi Possivel Remover o Pedido.";

		pedidoRepository.deleteById(codigo);

		return "Pedido Removido.";
	}

	public Pedido buscarPedidoPorId(Long codigo) {

		Pedido pedido = pedidoRepository.getOne(codigo);

		if (pedido == null)
			return null;

		return pedido;
	}

}
