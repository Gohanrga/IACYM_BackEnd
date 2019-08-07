package com.acym.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_concepto")
public class TipoConcepto implements Serializable{

	private static final long serialVersionUID = -8635680965509349904L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_concepto")
	private long idTipoConcepto;
	private String descripcion;
	public long getIdTipoConcepto() {
		return idTipoConcepto;
	}
	public void setIdTipoConcepto(long idTipoConcepto) {
		this.idTipoConcepto = idTipoConcepto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
