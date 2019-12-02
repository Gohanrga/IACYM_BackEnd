package com.acym.entity;

import java.io.Serializable;
import java.util.Date;

public class Hoja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int nroHoja;
	private Date fechaMaxima;
	public int getNroHoja() {
		return nroHoja;
	}
	public void setNroHoja(int nroHoja) {
		this.nroHoja = nroHoja;
	}
	public Date getFechaMaxima() {
		return fechaMaxima;
	}
	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}
	
}
