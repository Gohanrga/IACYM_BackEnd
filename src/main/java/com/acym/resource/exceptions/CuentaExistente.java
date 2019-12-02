package com.acym.resource.exceptions;

public class CuentaExistente extends Exception{
	private static final long serialVersionUID = -3391765825987141753L;
	public static final String DESCRIPTION = "Ya existe al cuenta contable";
	
	public CuentaExistente() {
		super(DESCRIPTION);
	}
	
	public CuentaExistente(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
