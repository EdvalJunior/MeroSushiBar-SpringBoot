package com.spring.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.br.models.Prato;
import com.spring.br.service.PratoService;

@Controller
@RequestMapping("/prato")
public class PratoController {

	@Autowired
	private PratoService ps;
	
	@RequestMapping("/formPrato")
	public ModelAndView retornarForm() {
		ModelAndView mv = new ModelAndView("pratoCadastro");
		mv.addObject(new Prato());
		return mv;
	}

	//value="/CadastrarPrato", method= RequestMethod.GET
	@RequestMapping("/salvarPrato")
	public ModelAndView cadastrarPrato(@Validated Prato prato, BindingResult result, @RequestParam(value = "imagem") MultipartFile imagem) {
		ModelAndView mv = new ModelAndView("pratoCadastro");
		
		if(result.hasErrors()) {
			return mv;
		}
		
		mv.addObject("mensagem", "Prato Cadastrada com sucesso");
		ps.cadastrarPrato(prato, imagem);
		return mv;
	}
	
	@RequestMapping("/listarPratos")
	public ModelAndView listar() {
		List<Prato> pratos = ps.listarPratos();
		ModelAndView mv = new ModelAndView("pratoListar");
		mv.addObject("listaPratos", pratos);
		return mv;
	}
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable Long id) {
		ps.excluirPrato(id);
		ModelAndView mv= new ModelAndView("redirect:/prato/listarPratos");
		return mv;
	}
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id) {
		Prato prato = ps.buscarPrato(id);
		ModelAndView mv= new ModelAndView("pratoCadastro");
		mv.addObject("prato", prato);
		return mv;
	}
	
	
}
