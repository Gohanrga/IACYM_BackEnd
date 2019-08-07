package com.acym.service;

import java.util.List;

import com.acym.entity.Miembro;

public interface IMiembroService {
	public List<Miembro> getMiembros();
	public List<Miembro> buscaMiembros(String nombre, int codigoDiezmo);
	public Miembro getMiembroById(Long id);
	public Miembro registraMiembro(Miembro miembro);
	public Miembro modificaMiembro(Miembro miembro, Long id);
	public boolean cambiaEstado(Long id);
}
