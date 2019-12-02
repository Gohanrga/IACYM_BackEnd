package com.acym.resource.exceptions;

public class CampoVacio extends Exception{
	private static final long serialVersionUID = -3291765825987141753L;
	public static final String DESCRIPTION = "Se requiere del campo";
	
	public CampoVacio() {
		super(DESCRIPTION);
	}
	
	public CampoVacio(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
