package com.spring.br.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Prato implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Não permitido valor nulo para código prato")
	private int cod_prato;
	
	@NotBlank(message = "Preencha o nome do prato")
	private String nome_prato;
	
	@NotNull(message = "Não permitido valor nulo para preço prato")
	private float preco_prato;
	
	public Prato() {
	}

	public Prato(int cod_prato, String nome_prato, float preco_prato) {
		this.cod_prato = cod_prato;
		this.nome_prato = nome_prato;
		this.preco_prato = preco_prato;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCod_prato() {
		return cod_prato;
	}
	public void setCod_prato(int cod_prato) {
		this.cod_prato = cod_prato;
	}
	public String getNome_prato() {
		return nome_prato;
	}
	public void setNome_prato(String nome_prato) {
		this.nome_prato = nome_prato;
	}
	public float getPreco_prato() {
		return preco_prato;
	}
	public void setPreco_prato(float preco_prato) {
		this.preco_prato = preco_prato;
	}
}
