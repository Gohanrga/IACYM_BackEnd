package com.acym.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.MiembroDao;
import com.acym.dao.TarjetaDiezmoDao;
import com.acym.entity.Miembro;
import com.acym.entity.TarjetaDiezmo;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.MiembroNoExiste;
import com.acym.resource.exceptions.TarjetaDiezmoRelacionada;

@Service
public class CMiembroService implements IMiembroService{
	@Autowired
	private MiembroDao miembroDao;
	@Autowired
	private TarjetaDiezmoDao tajetaDiezmoDao;
	
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
	public Miembro registraMiembro(Miembro miembro) throws CampoVacio, TarjetaDiezmoRelacionada {
		if(miembro.getNombre().equals(""))
			throw new CampoVacio("nombre");
		if(miembro.getApellido().equals(""))
			throw new CampoVacio("apellido");
		if(miembro.getTarjetaDiezmo().getIdDiezmo()==0)
			throw new CampoVacio("número de tarjeta");
		
		Optional<TarjetaDiezmo> tarjetaDiezmoOptional = tajetaDiezmoDao.findById(miembro.getTarjetaDiezmo().getIdDiezmo());
		TarjetaDiezmo tarjetaDiezmo = tarjetaDiezmoOptional.get();
		
		
		tajetaDiezmoDao.actualizaEstado(1, tarjetaDiezmo.getIdDiezmo());
		miembro.setTarjetaDiezmo(tarjetaDiezmo);
		
		miembro.setIdIglesia(1);
		miembro.setEstado(1);//activo
		miembro.setFechaCreacion(new Date());
		miembro = miembroDao.save(miembro);
		tajetaDiezmoDao.actualizaEstado(1, tarjetaDiezmo.getIdDiezmo());
		return miembro;
	}

	@Override
	public Miembro modificaMiembro(Miembro miembro) throws CampoVacio, MiembroNoExiste {
		if(miembro.getNombre().equals(""))
			throw new CampoVacio("nombre");
		if(miembro.getApellido().equals(""))
			throw new CampoVacio("apellido");
		
		Optional<Miembro> miembroOptional = miembroDao.findById(miembro.getIdMiembro());
		
		if(!miembroOptional.isPresent())
			throw new MiembroNoExiste();
		Miembro miembroAux = miembroOptional.get();
		miembroAux.setNombre(miembro.getNombre());
		miembroAux.setApellido(miembro.getApellido());
		miembroAux.setEstado(miembro.getEstado());
		miembroAux.setFechaModificacion(new Date());
		miembroAux.setUsuarioModificacion(miembro.getUsuarioModificacion());
		if(miembroAux.getEstado()==0)
			tajetaDiezmoDao.actualizaEstado(0, miembroAux.getTarjetaDiezmo().getIdDiezmo());
		else{
			tajetaDiezmoDao.actualizaEstado(1, miembroAux.getTarjetaDiezmo().getIdDiezmo());
			Optional<TarjetaDiezmo> tarjetaDiezmoOptional = tajetaDiezmoDao.findById(miembro.getTarjetaDiezmo().getIdDiezmo());
			TarjetaDiezmo tarjetaDiezmo = tarjetaDiezmoOptional.get();
			miembroAux.setTarjetaDiezmo(tarjetaDiezmo);
			tajetaDiezmoDao.actualizaEstado(1, tarjetaDiezmo.getIdDiezmo());
		}
		return miembroDao.save(miembroAux);
	}

	@Override
	public boolean cambiaEstado(Long id) throws MiembroNoExiste {
		Optional<Miembro> miembroOptional = miembroDao.findById(id);
		if(!miembroOptional.isPresent())
			throw new MiembroNoExiste();
		Miembro aux = miembroOptional.get();
		//activa o desactiva al usuario 0 inactivo 1 activo
		aux.setEstado((-1)*(aux.getEstado()-1));
		return true;
	}

}
