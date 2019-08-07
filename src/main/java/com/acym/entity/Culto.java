package com.acym.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="culto")
public class Culto implements Serializable{
	
	private static final long serialVersionUID = 8195314811246672597L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_culto")
	private long idCulto;
	private String descripcion;
	public long getIdCulto() {
		return idCulto;
	}
	public void setIdCulto(long idCulto) {
		this.idCulto = idCulto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
