package com.acym.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.IngresoEgresoDao;
import com.acym.entity.IngresoEgreso;

@Service
public class CIngresoEgresoService implements IIngresoEgresoService{
	@Autowired
	private IngresoEgresoDao ingresoEgresoDao;
	
	@Override
	public List<IngresoEgreso> getIngresosEgresosByFecha(Date fechaInicio, Date fechaFin) {
		return (List<IngresoEgreso>) ingresoEgresoDao.getIngresosEgresosByFecha(fechaInicio, fechaFin);
	}

	@Override
	public IngresoEgreso getIngresoEgresoById(Long id) {
		return ingresoEgresoDao.findById(id).orElse(null);
	}

	@Override
	public IngresoEgreso registraIngresoEgreso(IngresoEgreso transaccion) {
		transaccion.setFechaRegistro(new Date());
		return ingresoEgresoDao.save(transaccion);
	}

	@Override
	public IngresoEgreso modificacionIngresoEgreso(IngresoEgreso transaccion, Long id) {
		Optional<IngresoEgreso> optionalIngresoEgreso = ingresoEgresoDao.findById(id);
		if(!optionalIngresoEgreso.isPresent())
			return null;
		transaccion.setFechaModificacion(new Date());
		transaccion.setIdIngresoEgreso(id);
		return ingresoEgresoDao.save(transaccion);
	}

	@Override
	public boolean eliminacionIngresoEgreso(Long id) {
		Optional<IngresoEgreso> optionalIngresoEgreso = ingresoEgresoDao.findById(id);
		if(!optionalIngresoEgreso.isPresent())
			return false;
		ingresoEgresoDao.deleteById(id);
		return true;
	}

}
