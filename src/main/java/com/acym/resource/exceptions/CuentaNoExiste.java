package com.acym.resource.exceptions;

public class CuentaNoExiste extends Exception{
	private static final long serialVersionUID = -3381765825987141753L;
	public static final String DESCRIPTION = "La cuenta contable no existe";
	
	public CuentaNoExiste() {
		super(DESCRIPTION);
	}
	
	public CuentaNoExiste(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
