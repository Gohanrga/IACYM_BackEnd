package com.acym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acym.entity.TarjetaDiezmo;
import com.acym.service.ITarjetaDiezmoService;

@RestController
@RequestMapping("/api")
public class TarjetaDiezmoController {
	@Autowired
	private ITarjetaDiezmoService tarjetaDiezmoService;
	
	@GetMapping("/listarTarjetas")
	public List<TarjetaDiezmo> obtieneTarjetas(){
		return tarjetaDiezmoService.getTarjetasDiezmo();
	}
	
	@GetMapping("/getTarjeta/{id}")
	public TarjetaDiezmo obtieneTarjeta(@PathVariable Long id) {
		return tarjetaDiezmoService.getTarjetaDiezmo(id);
	}
}
