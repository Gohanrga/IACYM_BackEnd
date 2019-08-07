package com.acym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acym.entity.Culto;
import com.acym.service.ICultoService;

@RestController
@RequestMapping("/api")
public class CultoController {
	@Autowired
	private ICultoService cultoService;
	
	@GetMapping("/listarCultos")
	public List<Culto> obtieneCultos() {
		return cultoService.getCultos();
	}

	@GetMapping("/getCultos/{id}")
	public Culto obtenerCulto(@PathVariable Long id) {
		return cultoService.getCultoById(id);
	}
}
