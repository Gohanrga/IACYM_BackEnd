package com.acym.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="iglesia")
public class Iglesia implements Serializable{
	
	private static final long serialVersionUID = -7055016512327023973L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_iglesia")
	private long idIglesia;
	private String sigla;
	private String nombre;
	public long getIdIglesia() {
		return idIglesia;
	}
	public void setIdIglesia(long idIglesia) {
		this.idIglesia = idIglesia;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
