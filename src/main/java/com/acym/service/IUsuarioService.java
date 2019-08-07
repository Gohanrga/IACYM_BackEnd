package com.acym.service;

import java.util.List;

import com.acym.entity.Usuarios;

public interface IUsuarioService {
	public List<Usuarios> getUsuarios();
	public Usuarios getUsuario(Long id);
	public Usuarios registraUsuario(Usuarios usuario);
	public Usuarios modificaUsuario(Usuarios usuario, Long id);
	public boolean eliminaUsuario(Long id);
	public boolean verificaUsuario(Usuarios usuario);
}
