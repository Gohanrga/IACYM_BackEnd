package com.acym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.TipoConceptoDao;
import com.acym.entity.TipoConcepto;

@Service
public class CTipoConceptoService implements ITipoConceptoService{
	@Autowired
	private TipoConceptoDao tipoConceptoDao;
	
	@Override
	public List<TipoConcepto> getTiposConcepto() {
		return (List<TipoConcepto>)tipoConceptoDao.findAll();
	}

	@Override
	public TipoConcepto getTipoConcepto(Long id) {
		return tipoConceptoDao.findById(id).orElse(null);
	}

	@Override
	public TipoConcepto registroConcepto(TipoConcepto tipoConcepto) {
		return tipoConceptoDao.save(tipoConcepto);
	}

	@Override
	public TipoConcepto modificaConcepto(TipoConcepto tipoConcepto, Long id) {
		Optional<TipoConcepto> tipoConceptoOptional = tipoConceptoDao.findById(id);
		if(!tipoConceptoOptional.isPresent())
			return null;
		tipoConcepto.setIdTipoConcepto(id);
		return tipoConceptoDao.save(tipoConcepto);
	}

	@Override
	public boolean eliminaTipoConcepto(Long id) {
		Optional<TipoConcepto> tipoConceptoOptional = tipoConceptoDao.findById(id);
		if(!tipoConceptoOptional.isPresent())
			return false;
		tipoConceptoDao.deleteById(id);
		return true;
	}

}
