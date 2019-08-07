package com.acym.service;

import java.util.List;

import com.acym.entity.Iglesia;

public interface IIglesiaService {
	public List<Iglesia> getIglesias();
	public Iglesia getIglesiaById(Long id);
	public Iglesia registrarIglesia(Iglesia iglesia);
	public Iglesia modficarIglesia(Iglesia iglesia, Long id);
}
