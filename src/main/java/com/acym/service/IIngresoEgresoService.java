package com.acym.service;

import java.util.Date;
import java.util.List;

import com.acym.entity.IngresoEgreso;

public interface IIngresoEgresoService {
	public List<IngresoEgreso> getIngresosEgresosByFecha(Date fechaInicio, Date fechaFin);
	public IngresoEgreso getIngresoEgresoById(Long id);
	public IngresoEgreso registraIngresoEgreso(IngresoEgreso transaccion);
	public IngresoEgreso modificacionIngresoEgreso(IngresoEgreso transaccion, Long id);
	public boolean eliminacionIngresoEgreso(Long id);
}
