package com.spring.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.br.models.Cliente;
import com.spring.br.repository.ClienteRepository;
import com.spring.br.util.AulaFileUtils;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clr;
	
	public void cadastrarCliente(Cliente cliente, MultipartFile imagem) {
		cliente.setSenha(new BCryptPasswordEncoder().encode(cliente.getSenha()));
		
		String caminho = "images/" + cliente.getNome_cliente() + ".png";
		AulaFileUtils.salvarImagem(caminho, imagem);
		clr.save(cliente);
	}
	
	public List<Cliente> listarClientes(){
		return clr.findAll();
	}
	
	public void excluirCliente(Long codigo) {
		clr.deleteById(codigo);
	}
	
	public Cliente buscarCliente(Long codigo) {
		return clr.getOne(codigo);
	}
	
	public Cliente buscaPorLogin(String username) {
		Cliente cliente = clr.findByEmail(username);

		if (cliente == null)
			return null;

		return cliente;
	}
	
}
