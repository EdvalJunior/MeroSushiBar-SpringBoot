package com.spring.br.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.br.models.Prato;
import com.spring.br.repository.PratoRepository;
import com.spring.br.util.AulaFileUtils;


@Service
public class PratoService {

	@Autowired
	private PratoRepository pr ;
	
	public void cadastrarPrato(Prato prato, MultipartFile imagem) {
		String caminho = "images/" + prato.getNome_prato() + ".png";
		AulaFileUtils.salvarImagem(caminho, imagem);
		pr.save(prato);
	}
	
	public List<Prato> listarPratos(){
		return pr.findAll();
	}
	
	public void excluirPrato(Long id) {
		pr.deleteById(id);
	}
	
	public Prato buscarPrato(Long id) {
		return pr.getOne(id);
	}
	
	


	
	
}
