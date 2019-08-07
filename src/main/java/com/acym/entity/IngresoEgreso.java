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
@Table(name="ingreso_egreso")
public class IngresoEgreso implements Serializable{

	private static final long serialVersionUID = -280440637055619923L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ingreso_egreso")
	private long idIngresoEgreso;
	@Column(name="tipo_cuenta")
	private String tipocuenta;
	@Column(name="fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	private int hoja;
	@Column(name="monto_bs")
	private Double montoBs;
	@Column(name="monto_usd")
	private Double montoUsd;
	private String descripcion;
	private String codigo;
	@Column(name="id_tipo_concepto")
	private long idTipoConcepto;
	@Column(name="id_culto")
	private long idCulto;
	@Column(name="id_miembro")
	private long idMiembro;
	
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
	public long getIdIngresoEgreso() {
		return idIngresoEgreso;
	}
	public void setIdIngresoEgreso(long idIngresoEgreso) {
		this.idIngresoEgreso = idIngresoEgreso;
	}
	public String getTipocuenta() {
		return tipocuenta;
	}
	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getHoja() {
		return hoja;
	}
	public void setHoja(int hoja) {
		this.hoja = hoja;
	}
	public Double getMontoBs() {
		return montoBs;
	}
	public void setMontoBs(Double montoBs) {
		this.montoBs = montoBs;
	}
	public Double getMontoUsd() {
		return montoUsd;
	}
	public void setMontoUsd(Double montoUsd) {
		this.montoUsd = montoUsd;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public long getIdTipoConcepto() {
		return idTipoConcepto;
	}
	public void setIdTipoConcepto(long idTipoConcepto) {
		this.idTipoConcepto = idTipoConcepto;
	}
	public long getIdCulto() {
		return idCulto;
	}
	public void setIdCulto(long idCulto) {
		this.idCulto = idCulto;
	}
	public long getIdMiembro() {
		return idMiembro;
	}
	public void setIdMiembro(long idMiembro) {
		this.idMiembro = idMiembro;
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
	
}
