package com.spring.br.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Papel implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	private String papel;

	@ManyToMany(mappedBy = "papeis")
	private List<Cliente> clientes;

	@Override
	public String getAuthority() {
		return this.papel;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
