package com.acym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.IglesiaDao;
import com.acym.entity.Iglesia;

@Service
public class CIglesiaService implements IIglesiaService{
	@Autowired
	private IglesiaDao iglesiaDao;
	
	@Override
	public List<Iglesia> getIglesias() {
		return (List<Iglesia>)iglesiaDao.findAll();
	}

	@Override
	public Iglesia getIglesiaById(Long id) {
		return iglesiaDao.findById(id).orElse(null);
	}

	@Override
	public Iglesia registrarIglesia(Iglesia iglesia) {
		return iglesiaDao.save(iglesia);
	}

	@Override
	public Iglesia modficarIglesia(Iglesia iglesia, Long id) {
		Optional<Iglesia> iglesiaOptinal = iglesiaDao.findById(id);
		if(!iglesiaOptinal.isPresent())
			return null;
		iglesia.setIdIglesia(id);
		return iglesiaDao.save(iglesia);
	}

}
