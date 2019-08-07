package com.acym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.TarjetaDiezmoDao;
import com.acym.entity.TarjetaDiezmo;

@Service
public class CTarjetaDiezmoService implements ITarjetaDiezmoService{
	@Autowired
	private TarjetaDiezmoDao tarjetaDiezmoDao;
	
	@Override
	public List<TarjetaDiezmo> getTarjetasDiezmo() {
		return (List<TarjetaDiezmo>)tarjetaDiezmoDao.findAll();
	}

	@Override
	public TarjetaDiezmo getTarjetaDiezmo(Long id) {
		return tarjetaDiezmoDao.findById(id).orElse(null);
	}

}
