package com.acym.service;

import java.util.List;

import com.acym.entity.Miembro;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.MiembroNoExiste;
import com.acym.resource.exceptions.TarjetaDiezmoRelacionada;

public interface IMiembroService {
	public List<Miembro> getMiembros();
	public List<Miembro> buscaMiembros(String nombre, int codigoDiezmo);
	public Miembro getMiembroById(Long id);
	public Miembro registraMiembro(Miembro miembro) throws CampoVacio, TarjetaDiezmoRelacionada;
	public Miembro modificaMiembro(Miembro miembro) throws CampoVacio, MiembroNoExiste;
	public boolean cambiaEstado(Long id) throws MiembroNoExiste;
}
