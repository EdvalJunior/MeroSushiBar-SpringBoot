package com.spring.br.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping("/")
	public ModelAndView principal() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
}
