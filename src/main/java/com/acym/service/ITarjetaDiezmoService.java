package com.acym.service;

import java.util.List;

import com.acym.entity.TarjetaDiezmo;

public interface ITarjetaDiezmoService {
	public List<TarjetaDiezmo> getTarjetasDiezmo();
	public TarjetaDiezmo getTarjetaDiezmo(Long id);
}
