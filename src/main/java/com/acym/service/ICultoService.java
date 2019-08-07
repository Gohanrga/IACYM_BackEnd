package com.acym.service;

import java.util.List;

import com.acym.entity.Culto;

public interface ICultoService {
	public List<Culto> getCultos();
	public Culto getCultoById(Long id);
}
