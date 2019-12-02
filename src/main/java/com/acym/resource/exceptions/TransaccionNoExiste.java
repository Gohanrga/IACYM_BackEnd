package com.acym.resource.exceptions;

public class TransaccionNoExiste extends Exception{
	private static final long serialVersionUID = -3381765825987141753L;
	public static final String DESCRIPTION = "La transacción no existe";
	
	public TransaccionNoExiste() {
		super(DESCRIPTION);
	}
	
	public TransaccionNoExiste(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
