package com.spring.br.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@NotBlank(message = "Preencha o campo nome")
	private String nome_cliente;
	
	@NotBlank(message = "Preencha o campo cpf")
	@Column(unique = true)
	private String cpf_cliente;
	
	@NotNull(message = "")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data_de_nascimento;
	
	@NotBlank(message = "Preencha o campo endereço")
	private String endereco_cliente;
	
	@NotBlank(message = "Preencha o campo senha")
	private String senha;
	
	@NotBlank(message = "Preencha o campo email")
	@Column(unique = true)
	private String email;
	
	public Cliente() {
		
	}

	public Cliente(String nome_cliente, String cpf_cliente, Date data_de_nascimento, String endereco_cliente,
			String senha, String email) {
		super();
		this.nome_cliente = nome_cliente;
		this.cpf_cliente = cpf_cliente;
		this.data_de_nascimento = data_de_nascimento;
		this.endereco_cliente = endereco_cliente;
		this.senha = senha;
		this.email = email;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public Date getData_de_nascimento() {
		return data_de_nascimento;
	}

	public void setData_de_nascimento(Date data_de_nascimento) {
		this.data_de_nascimento = data_de_nascimento;
	}

	public String getEndereco_cliente() {
		return endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}
