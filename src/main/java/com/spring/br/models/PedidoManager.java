package com.spring.br.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class PedidoManager{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPedidoM;
	
	@NotNull
	private Long quantidade;
	
	@ManyToOne
    @JoinColumn(name = "codPrato", referencedColumnName = "id")
	private Prato prato;
	
	@NotNull
	private Double precoTotal;
	
	@ManyToOne
    @JoinColumn(name = "codPedido")
	private Pedido pedido;
	
	// GETTERS AND SETTERS

	public Long getIdPedidoM() {
		return idPedidoM;
	}

	public void setIdPedidoM(Long idPedidoM) {
		this.idPedidoM = idPedidoM;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
}
