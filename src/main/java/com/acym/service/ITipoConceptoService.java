package com.acym.service;

import java.util.List;

import com.acym.entity.TipoConcepto;

public interface ITipoConceptoService {
	public List<TipoConcepto> getTiposConcepto();
	public TipoConcepto getTipoConcepto(Long id);
	public TipoConcepto registroConcepto(TipoConcepto tipoConcepto);
	public TipoConcepto modificaConcepto(TipoConcepto tipoConcepto, Long id);
	public boolean eliminaTipoConcepto(Long id);
}
