package com.acym.resource.exceptions;

public class LoginIncorrecto extends Exception{
	private static final long serialVersionUID = -3021765825987141753L;
	public static final String DESCRIPTION = "Usuario o contraseña incorrectos";
	
	public LoginIncorrecto() {
		super(DESCRIPTION);
	}
	
	public LoginIncorrecto(String detalle) {
		super(DESCRIPTION + " "+detalle);
	}
}
