package com.acym.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.CuentaContableDao;
import com.acym.entity.CuentaContable;
import com.acym.entity.IngresoEgreso;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.CuentaExistente;
import com.acym.resource.exceptions.CuentaNoExiste;
import com.acym.resource.exceptions.CuentaRelacionada;

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
		return cuentaContableDao.buscaCuenta(codigo);
	}

	@Override
	public CuentaContable registraCuentaContable(CuentaContable cuentaContable) throws CampoVacio, CuentaExistente {
		if(cuentaContable.getCodigo().equals(""))
			throw new CampoVacio("codigo");
		if(cuentaContable.getTipoCuenta().equals(""))
			throw new CampoVacio("tipo");
		if(cuentaContable.getDescripcion().equals(""))
			throw new CampoVacio("descripcion");
		
		CuentaContable cuentaContableAux = cuentaContableDao.buscaCuenta(cuentaContable.getCodigo());
		if(cuentaContableAux!=null)
			throw new CuentaExistente(cuentaContable.getCodigo());
		
		//TODO pasar el usuario de creacion
		//cuentaContable.setUsuarioCreacion("RGONZALES");
		cuentaContable.setFechaCreacion(new Date());
		return cuentaContableDao.save(cuentaContable);
	}

	@Override
	public CuentaContable modificaCuentaContable(CuentaContable cuentaContable) throws CampoVacio, CuentaNoExiste {
		if(cuentaContable.getCodigo().equals(""))
			throw new CampoVacio("codigo");
		if(cuentaContable.getTipoCuenta().equals(""))
			throw new CampoVacio("tipo");
		if(cuentaContable.getDescripcion().equals(""))
			throw new CampoVacio("descripcion");
		
		CuentaContable cuentaContableAux = cuentaContableDao.buscaCuenta(cuentaContable.getCodigo());
		if(cuentaContableAux == null)
			throw new CuentaNoExiste();

		cuentaContableAux.setTipoCuenta(cuentaContable.getTipoCuenta());
		cuentaContableAux.setDescripcion(cuentaContable.getDescripcion());
		cuentaContableAux.setUsuarioModificacion(cuentaContable.getUsuarioModificacion());
		cuentaContableAux.setFechaModificacion(new Date());
		//TODO pasar el usuario de creacion
		//cuentaContableAux.setUsuarioModificacion("RGONZALES");
		return cuentaContableDao.save(cuentaContableAux);
	}

	@Override
	public boolean eliminaCuentaContable(String codigo) throws CuentaRelacionada, CuentaNoExiste {
		CuentaContable cuentaContableAux = cuentaContableDao.buscaCuenta(codigo.trim());
		if(cuentaContableAux == null)
			throw new CuentaNoExiste();
		IngresoEgreso ingresoEgreso = cuentaContableDao.buscaEnIngresoEgreso(codigo);
		if(ingresoEgreso!=null)
			throw new CuentaRelacionada();
		cuentaContableDao.eliminaCuenta(codigo);
		return true;
	}

	@Override
	public List<CuentaContable> getCuentaByTipo(String tipo) {
		return cuentaContableDao.obtieneCuentasByTipo(tipo);
	}

}
