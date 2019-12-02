package com.acym.service;

import java.util.List;

import com.acym.entity.TipoConcepto;
import com.acym.resource.exceptions.ClasificadorNoEncontrado;

public interface ITipoConceptoService {
	public List<TipoConcepto> getTiposConcepto();
	public TipoConcepto getTipoConcepto(Long id);
	public TipoConcepto registroConcepto(TipoConcepto tipoConcepto);
	public TipoConcepto modificaConcepto(TipoConcepto tipoConcepto) throws ClasificadorNoEncontrado;
	public boolean eliminaTipoConcepto(Long id);
}
