package com.acym.resource.exceptions;

public class MiembroNoExiste extends Exception{
	private static final long serialVersionUID = -3381765825983241753L;
	public static final String DESCRIPTION = "El miembro no existe";
	
	public MiembroNoExiste() {
		super(DESCRIPTION);
	}
	
	public MiembroNoExiste(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
