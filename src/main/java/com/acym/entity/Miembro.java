package com.acym.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="miembro")
public class Miembro implements Serializable{
	
	private static final long serialVersionUID = 6291864322967516957L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_miembro")
	private long idMiembro;
	private String nombre;
	private String apellido;
	@Column(name="id_iglesia")
	private long idIglesia;
	@Column(name="id_diezmo")
	private long idDiezmo;
	private int estado;
	@Column(name="fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	@Column(name="usuario_creacion")
	private String usuarioCreacion;
	@Column(name="fecha_modificacion")
	@Temporal(TemporalType.DATE)
	private Date fechaModificacion;
	@Column(name="usuario_modificacion")
	private String usuarioModificacion;
	public long getIdMiembro() {
		return idMiembro;
	}
	public void setIdMiembro(long idMiembro) {
		this.idMiembro = idMiembro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getIdIglesia() {
		return idIglesia;
	}
	public void setIdIglesia(long idIglesia) {
		this.idIglesia = idIglesia;
	}
	public long getIdDiezmo() {
		return idDiezmo;
	}
	public void setIdDiezmo(long idDiezmo) {
		this.idDiezmo = idDiezmo;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
