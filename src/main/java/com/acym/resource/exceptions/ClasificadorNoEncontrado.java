package com.acym.resource.exceptions;

public class ClasificadorNoEncontrado extends Exception{
	private static final long serialVersionUID = -3291765825987141753L;
	public static final String DESCRIPTION = "Usuario no encontrado";
	
	public ClasificadorNoEncontrado() {
		super(DESCRIPTION);
	}
	
	public ClasificadorNoEncontrado(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
