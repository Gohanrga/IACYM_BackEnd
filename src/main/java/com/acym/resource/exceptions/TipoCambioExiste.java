package com.acym.resource.exceptions;

public class TipoCambioExiste extends Exception{
	private static final long serialVersionUID = -3391765825987141753L;
	public static final String DESCRIPTION = "El tipo de cambio ya existe";
	
	public TipoCambioExiste() {
		super(DESCRIPTION);
	}
	
	public TipoCambioExiste(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
