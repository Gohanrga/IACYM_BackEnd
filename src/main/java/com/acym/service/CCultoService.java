package com.acym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.CultoDao;
import com.acym.entity.Culto;

@Service
public class CCultoService implements ICultoService{
	@Autowired
	private CultoDao cultoDao;
	
	@Override
	public List<Culto> getCultos() {
		return (List<Culto>) cultoDao.findAll();
	}

	@Override
	public Culto getCultoById(Long id) {
		return cultoDao.findById(id).orElse(null);
	}

}
