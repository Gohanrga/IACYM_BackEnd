package com.acym.service;

import java.util.Date;
import java.util.List;

import com.acym.entity.IngresoEgreso;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.TransaccionNoExiste;

public interface IIngresoEgresoService {
	public List<IngresoEgreso> getIngresosEgresosByFecha(Date fechaInicio, Date fechaFin, String tipoCuenta);
	public IngresoEgreso getIngresoEgresoById(Long id);
	public IngresoEgreso registraIngresoEgreso(IngresoEgreso transaccion) throws CampoVacio;
	public IngresoEgreso modificacionIngresoEgreso(IngresoEgreso transaccion) throws CampoVacio, TransaccionNoExiste;
	public boolean eliminacionIngresoEgreso(Long id);
	public boolean inactivaEstado(Long id);
}
