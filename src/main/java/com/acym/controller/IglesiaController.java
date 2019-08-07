package com.acym.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acym.entity.Iglesia;
import com.acym.service.IIglesiaService;
@RestController
@RequestMapping("/api")
public class IglesiaController {
	private IIglesiaService iglesiaService;
	
	@GetMapping("/listarIglesias")
	public List<Iglesia> obtieneIglesias(){
		return iglesiaService.getIglesias();
	}
	
	@GetMapping("/getIglesia/{id}")
	public Iglesia obtieneIglesia(@PathVariable Long id) {
		return iglesiaService.getIglesiaById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registroIglesia")
	public Iglesia registraIglesia(@RequestBody  Iglesia iglesia) {
		return iglesiaService.registrarIglesia(iglesia);
	}
	
	@PutMapping("/modificaIglesia/{id}")
	public Iglesia modificaIglesia (Iglesia iglesia, @PathVariable Long id) {
		return iglesiaService.modficarIglesia(iglesia, id);
	}
}
