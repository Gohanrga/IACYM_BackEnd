package com.acym.resource.exceptions;

public class UsuarioIdNoEncontrado extends Exception{
	private static final long serialVersionUID = -3191765825987141753L;
	public static final String DESCRIPTION = "Usuario no encontrado";
	
	public UsuarioIdNoEncontrado() {
		super(DESCRIPTION);
	}
	
	public UsuarioIdNoEncontrado(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
