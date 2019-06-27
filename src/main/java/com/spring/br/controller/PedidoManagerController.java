package com.spring.br.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.br.service.PedidoManagerService;


@Controller
@RequestMapping("/pedidoM")
public class PedidoManagerController {
	
	@Autowired
	PedidoManagerService manegerService = new PedidoManagerService();
	
}
