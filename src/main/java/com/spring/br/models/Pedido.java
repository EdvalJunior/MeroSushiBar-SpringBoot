package com.spring.br.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {
	

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long idPedido;
		
		@ManyToOne
		@JoinColumn(name = "codPessoa", referencedColumnName = "codigo")
		private Cliente cliente;
		
		private Double totalPedido;
		
		@NotNull
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		@Temporal(TemporalType.DATE)
		private Date dataPedido;
			
		@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
		private List<PedidoManager> pedidosM;
		
		// GETTERS AND SETTERS

		public Long getIdPedido() {
			return idPedido;
		}

		public void setIdPedido(Long idPedido) {
			this.idPedido = idPedido;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Double getTotalPedido() {
			return totalPedido;
		}

		public void setTotalPedido(Double totalPedido) {
			this.totalPedido = totalPedido;
		}

		public Date getDataPedido() {
			return dataPedido;
		}

		public void setDataPedido(Date dataPedido) {
			this.dataPedido = dataPedido;
		}

		public List<PedidoManager> getPedidosM() {
			return pedidosM;
		}

		public void setPedidosM(List<PedidoManager> pedidosM) {
			this.pedidosM = pedidosM;
		}
}
	
		