package com.acym.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo", referencedColumnName="codigo")
	private CuentaContable cuentaContable;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tipo_concepto", referencedColumnName="id_tipo_concepto")
	private TipoConcepto tipoConcepto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_culto", referencedColumnName="id_culto")
	private Culto culto;
	
	@OneToOne(cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_miembro", referencedColumnName="id_miembro", nullable=true)
	private Miembro miembro;
	
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
	
	private int estado;
	
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
	
	public CuentaContable getCuentaContable() {
		return cuentaContable;
	}
	public void setCuentaContable(CuentaContable cuentaContable) {
		this.cuentaContable = cuentaContable;
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
	public TipoConcepto getTipoConcepto() {
		return tipoConcepto;
	}
	public void setTipoConcepto(TipoConcepto tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}
	public Culto getCulto() {
		return culto;
	}
	public void setCulto(Culto culto) {
		this.culto = culto;
	}
	public Miembro getMiembro() {
		return miembro;
	}
	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
