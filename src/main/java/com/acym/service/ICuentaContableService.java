package com.acym.service;

import java.util.List;

import com.acym.entity.CuentaContable;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.CuentaExistente;
import com.acym.resource.exceptions.CuentaNoExiste;
import com.acym.resource.exceptions.CuentaRelacionada;

public interface ICuentaContableService {
	public List<CuentaContable> getCuentasContables();
	public List<CuentaContable> getCuentaByTipo(String tipo);
	public CuentaContable getCuentaContableById(String codigo);
	public CuentaContable registraCuentaContable(CuentaContable cuentaContable) throws CampoVacio, CuentaExistente;
	public CuentaContable modificaCuentaContable(CuentaContable cuentaContable) throws CampoVacio, CuentaNoExiste;
	public boolean eliminaCuentaContable(String codigo) throws CuentaRelacionada, CuentaNoExiste;
}
