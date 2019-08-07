package com.acym.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.MiembroDao;
import com.acym.entity.Miembro;

@Service
public class CMiembroService implements IMiembroService{
	@Autowired
	private MiembroDao miembroDao;
	
	@Override
	public List<Miembro> getMiembros() {
		return (List<Miembro>)miembroDao.findAll();
	}

	@Override
	public List<Miembro> buscaMiembros(String nombre, int codigoDiezmo) {
		return (List<Miembro>)miembroDao.buscaMiembros(nombre, codigoDiezmo);
	}

	@Override
	public Miembro getMiembroById(Long id) {
		return miembroDao.findById(id).orElse(null);
	}

	@Override
	public Miembro registraMiembro(Miembro miembro) {
		miembro.setEstado(1);//activo
		miembro.setFechaCreacion(new Date());
		return miembroDao.save(miembro);
	}

	@Override
	public Miembro modificaMiembro(Miembro miembro, Long id) {
		Optional<Miembro> miembroOptional = miembroDao.findById(id);
		miembro.setFechaModificacion(new Date());
		if(!miembroOptional.isPresent())
			return null;
		miembro.setIdMiembro(id);
		return miembroDao.save(miembro);
	}

	@Override
	public boolean cambiaEstado(Long id) {
		Optional<Miembro> miembroOptional = miembroDao.findById(id);
		if(!miembroOptional.isPresent())
			return false;
		Miembro aux = miembroOptional.get();
		//activa o desactiva al usuario 0 inactivo 1 activo
		aux.setEstado((-1)*(aux.getEstado()-1));
		return true;
	}

}
