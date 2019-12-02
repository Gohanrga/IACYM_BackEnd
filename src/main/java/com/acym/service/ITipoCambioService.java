package com.acym.service;

import java.util.Date;
import java.util.List;

import com.acym.entity.TipoCambio;
import com.acym.resource.exceptions.TipoCambioExiste;

public interface ITipoCambioService {
	public List<TipoCambio> obtieneTiposCambio();
	public TipoCambio registraTipoCambio(TipoCambio tipoCambio) throws TipoCambioExiste;
	public TipoCambio modificaTipoCambio(TipoCambio tipoCambio);
	public String verificaExistenciaTipoCambio(Date fecha);
}
