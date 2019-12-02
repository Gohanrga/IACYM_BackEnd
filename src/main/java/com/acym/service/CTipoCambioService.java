package com.acym.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.TipoCambioDao;
import com.acym.entity.TipoCambio;
import com.acym.resource.exceptions.TipoCambioExiste;

@Service
public class CTipoCambioService implements ITipoCambioService{

	@Autowired
	private TipoCambioDao tipoCambioDao;
	
	@Override
	public List<TipoCambio> obtieneTiposCambio() {
		return (List<TipoCambio>)tipoCambioDao.findAll();
	}

	@Override
	public TipoCambio registraTipoCambio(TipoCambio tipoCambio) throws TipoCambioExiste {
		// TODO Auto-generated method stub
		if(tipoCambioDao.verificaExistencia(tipoCambio.getFecha())!=null)
			throw new TipoCambioExiste();
		tipoCambio.setFechaCreacion(new Date());
		return tipoCambioDao.save(tipoCambio);
	}

	@Override
	public TipoCambio modificaTipoCambio(TipoCambio tipoCambio) {
		Optional<TipoCambio> optinalTipoCambio = tipoCambioDao.findById(tipoCambio.getIdTipoCambio());
		if(!optinalTipoCambio.isPresent())
			return null;
		TipoCambio tipoCambioAux = optinalTipoCambio.get();
		tipoCambioAux.setFecha(tipoCambio.getFecha());
		tipoCambioAux.setValor(tipoCambio.getValor());
		tipoCambioAux.setUsuarioModificacion(tipoCambio.getUsuarioModificacion());
		tipoCambioAux.setFechaModificacion(new Date());
		
		return tipoCambioDao.save(tipoCambioAux);
	}

	@Override
	public String verificaExistenciaTipoCambio(Date fecha) {
		String respuesta = "NoExiste";
		if(tipoCambioDao.verificaExistencia(fecha)!=null)
			respuesta = "Existe";
		return respuesta;
	}

}
