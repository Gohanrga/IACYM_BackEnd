package com.acym.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acym.entity.TipoCambio;
import com.acym.resource.exceptions.TipoCambioExiste;
import com.acym.service.ITipoCambioService;

@RestController
@RequestMapping("/api")
public class TipoCambioController {
	@Autowired
	private ITipoCambioService tipoCambioService;
	
	@GetMapping("/listarTipoCambio")
	public List<TipoCambio> obtieneTiposCambio(){
		return tipoCambioService.obtieneTiposCambio();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registroTipoCuenta")
	public TipoCambio registraTipoCambio(@RequestBody TipoCambio tipoCambio) throws TipoCambioExiste {
		return tipoCambioService.registraTipoCambio(tipoCambio);
	}
	
	@PutMapping("/modificaTipoCuenta")
	public TipoCambio modificaTipoCambio(@RequestBody TipoCambio tipoCambio) {
		return tipoCambioService.modificaTipoCambio(tipoCambio);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/verifica")
	public String VerificaExistenciaTipoCambio(@RequestBody HashMap<String, String> parametros) throws ParseException {
		String fecha = parametros.get("fecha");
		return tipoCambioService.verificaExistenciaTipoCambio(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
	}
}
