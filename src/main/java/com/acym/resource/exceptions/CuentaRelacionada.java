package com.acym.resource.exceptions;

public class CuentaRelacionada extends Exception{
	private static final long serialVersionUID = -3791765825987141753L;
	public static final String DESCRIPTION = "La cuenta tiene movimientos contables.";
	
	public CuentaRelacionada() {
		super(DESCRIPTION);
	}
	
	public CuentaRelacionada(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
