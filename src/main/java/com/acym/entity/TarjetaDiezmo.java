package com.acym.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tarjeta_diezmo")
public class TarjetaDiezmo implements Serializable{
	

	private static final long serialVersionUID = 16864108560768483L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_diezmo")
	private long idDiezmo;
	private int numeroTarjeta;
	private int estado;
	
	/*@OneToOne(mappedBy = "tarjetaDiezmo")
	private Miembro miembro;*/
	
	public long getIdDiezmo() {
		return idDiezmo;
	}
	public void setIdDiezmo(long idDiezmo) {
		this.idDiezmo = idDiezmo;
	}
	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
