package com.acym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acym.entity.CuentaContable;
import com.acym.service.ICuentaContableService;

@RestController
@RequestMapping("/api")
public class CuentaContableController {
	@Autowired
	private ICuentaContableService cuentaContableService;
	
	@GetMapping("/listarCuentas")
	public List<CuentaContable> getCuentasContables(){
		return cuentaContableService.getCuentasContables();
	}
	
	@GetMapping("/getCuenta/{codigo}")
	public CuentaContable obtieneCuentaContable(@PathVariable String codigo) {
		return cuentaContableService.getCuentaContableById(codigo);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registroCuenta")
	public CuentaContable registraCuentaContable(@RequestBody CuentaContable cuenta) {
		return cuentaContableService.registraCuentaContable(cuenta);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/modificaCuenta")
	public CuentaContable modificaCuentaContable(CuentaContable cuenta) {
		return cuentaContableService.modificaCuentaContable(cuenta);
	}
	
	@DeleteMapping("/eliminaCuenta/{codigo}")
	public boolean eliminaCuentaContable(@PathVariable String codigo) {
		return cuentaContableService.eliminaCuentaContable(codigo);
	}
}
