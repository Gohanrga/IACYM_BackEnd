package com.acym.service;

import java.util.List;

import com.acym.entity.CuentaContable;

public interface ICuentaContableService {
	public List<CuentaContable> getCuentasContables();
	public CuentaContable getCuentaContableById(String codigo);
	public CuentaContable registraCuentaContable(CuentaContable cuentaContable);
	public CuentaContable modificaCuentaContable(CuentaContable cuentaContable);
	public boolean eliminaCuentaContable(String codigo);
}
