package com.spring.br.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Carrinho {

	private static List<PedidoManager> itens = new ArrayList<PedidoManager>();
	private static Double total = 0.0;
	
	public List<PedidoManager> getItens() {
		return itens;
	}
	
	public void setItens(List<PedidoManager> item) {
		itens = item;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double valorTotal) {
		total = valorTotal;
	}
	
	public void addItem(PedidoManager item) {
		itens.add(item);
		setTotal(getTotal() + item.getPrecoTotal());
	}
	
	public void deleteItem(int index) {
		setTotal(getTotal() - itens.get(index).getPrecoTotal());
		itens.remove(index);
	}

	public static void clearCarrinho() {
		total = 0.0;
		itens.clear();
	}

}
