package com.acym.resource.exceptions;

public class TarjetaDiezmoRelacionada extends Exception{
	private static final long serialVersionUID = -3391765825987141753L;
	public static final String DESCRIPTION = "La tarjeta ";
	
	public TarjetaDiezmoRelacionada() {
		super(DESCRIPTION);
	}
	
	public TarjetaDiezmoRelacionada(String detalle) {
		super(DESCRIPTION +detalle+" ya se encuentra relacionada a un miembro");
	}
}
