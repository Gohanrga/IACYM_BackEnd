package com.acym.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.TransaccionNoExiste;
import com.acym.service.IIngresoEgresoService;
@RestController
@RequestMapping("/api")
public class IngresoEgresoController {
	@Autowired
	private IIngresoEgresoService ingresoEgresoService;
	
	/*@GetMapping("/getTransacciones/{fechaInicio}/{fechaFin}")
	public List<IngresoEgreso> obtieneTransaccionesPorFecha(@PathVariable Date fechaInicio,@PathVariable Date fechaFin){
		return ingresoEgresoService.getIngresosEgresosByFecha(fechaInicio, fechaFin);
	}*/
	
	@RequestMapping(method=RequestMethod.POST, value="/getTransacciones")
	public List<IngresoEgreso> obtieneTransaccionesPorFecha(@RequestBody HashMap<String, String> parametros) throws ParseException{
		String fechaInicio = parametros.get("fechaInicio");
		String fechaFin = parametros.get("fechaFin");
		String tipoCuenta = parametros.get("tipoCuenta");
		return ingresoEgresoService.getIngresosEgresosByFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio), 
															  new SimpleDateFormat("yyyy-MM-dd").parse(fechaFin),
															  tipoCuenta);
	}
	
	@GetMapping("/getTransaccion/{id}")
	public IngresoEgreso obtieneTransaccion(@PathVariable Long id) {
		return ingresoEgresoService.getIngresoEgresoById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registroTransaccion")
	public IngresoEgreso registraTransaccion(@RequestBody IngresoEgreso transaccion) throws CampoVacio {
		return ingresoEgresoService.registraIngresoEgreso(transaccion);
	}
	
	@PutMapping("/modificaTransaccion")
	public IngresoEgreso modificaTransaccion(@RequestBody IngresoEgreso transaccion) throws CampoVacio, TransaccionNoExiste {
		return ingresoEgresoService.modificacionIngresoEgreso(transaccion);
	}
	
	@GetMapping("/eliminaTransaccion/{id}")
	public boolean eliminaTransaccion(@PathVariable Long id) {
		return ingresoEgresoService.eliminacionIngresoEgreso(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/inactivarTransaccion")
	public boolean inactivarTransaccion(@RequestBody IngresoEgreso transaccion) {
		return ingresoEgresoService.inactivaEstado(transaccion.getIdIngresoEgreso());
	}
}
