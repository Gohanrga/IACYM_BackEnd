package com.acym.service;

import java.util.List;

import com.acym.entity.Usuarios;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.LoginIncorrecto;
import com.acym.resource.exceptions.UsuarioIdNoEncontrado;

public interface IUsuarioService {
	public List<Usuarios> getUsuarios();
	public Usuarios getUsuario(Long id);
	public Usuarios registraUsuario(Usuarios usuario) throws CampoVacio;
	public Usuarios modificaUsuario(Usuarios usuario) throws CampoVacio, UsuarioIdNoEncontrado;
	public boolean eliminaUsuario(Long id) throws UsuarioIdNoEncontrado;
	public Usuarios verificaUsuario(Usuarios usuario) throws LoginIncorrecto;
}
