package com.acym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.CuentaContableDao;
import com.acym.entity.CuentaContable;

@Service
public class CCuentaContableService implements ICuentaContableService{
	@Autowired
	private CuentaContableDao cuentaContableDao;
	
	@Override
	public List<CuentaContable> getCuentasContables() {
		return (List<CuentaContable>)cuentaContableDao.findAll();
	}

	@Override
	public CuentaContable getCuentaContableById(String codigo) {
		return cuentaContableDao.findById(codigo).orElse(null);
	}

	@Override
	public CuentaContable registraCuentaContable(CuentaContable cuentaContable) {
		return cuentaContableDao.save(cuentaContable);
	}

	@Override
	public CuentaContable modificaCuentaContable(CuentaContable cuentaContable) {
		return cuentaContableDao.save(cuentaContable);
	}

	@Override
	public boolean eliminaCuentaContable(String codigo) {
		cuentaContableDao.deleteById(codigo);
		return true;
	}

}
