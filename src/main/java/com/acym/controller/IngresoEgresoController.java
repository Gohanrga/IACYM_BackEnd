package com.acym.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acym.entity.IngresoEgreso;
import com.acym.service.IIngresoEgresoService;
@RestController
@RequestMapping("/api")
public class IngresoEgresoController {
	@Autowired
	private IIngresoEgresoService ingresoEgresoService;
	
	@GetMapping("/getTransacciones/{fechaInicio}/{fechaFin}")
	public List<IngresoEgreso> obtieneTransaccionesPorFecha(@PathVariable Date fechaInicio,@PathVariable Date fechaFin){
		return ingresoEgresoService.getIngresosEgresosByFecha(fechaInicio, fechaFin);
	}
	
	@GetMapping("/getTransaccion/{id}")
	public IngresoEgreso obtieneTransaccion(@PathVariable Long id) {
		return ingresoEgresoService.getIngresoEgresoById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registroTransaccion")
	public IngresoEgreso registraTransaccion(@RequestBody IngresoEgreso transaccion) {
		return ingresoEgresoService.registraIngresoEgreso(transaccion);
	}
	
	@PutMapping("/modificaTransaccion/{id}")
	public IngresoEgreso modificaTransaccion(@RequestBody IngresoEgreso transaccion,@PathVariable Long id) {
		return ingresoEgresoService.modificacionIngresoEgreso(transaccion, id);
	}
	
	@GetMapping("/eliminaTransaccion/{id}")
	public boolean eliminaTransaccion(@PathVariable Long id) {
		return ingresoEgresoService.eliminacionIngresoEgreso(id);
	}
}
