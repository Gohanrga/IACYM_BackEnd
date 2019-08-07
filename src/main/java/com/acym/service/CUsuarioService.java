package com.acym.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.UsuarioDao;
import com.acym.entity.Usuarios;
import com.acym.util.Util;
@Service
public class CUsuarioService implements IUsuarioService{
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public List<Usuarios> getUsuarios() {
		return (List<Usuarios>)usuarioDao.findAll();
	}

	@Override
	public Usuarios getUsuario(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public Usuarios registraUsuario(Usuarios usuario) {
		//encryptamos la contraseña
		usuario.setPassword(Util.getMD5(usuario.getPassword()));
		usuario.setEstado(1);//1 es activo
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuarios modificaUsuario(Usuarios usuario, Long id) {
		Optional<Usuarios> usuarioOptional = usuarioDao.findById(id);
		if(!usuarioOptional.isPresent())
			return null;
		usuario.setIdUsuario(id);
		usuarioDao.save(usuario);
		return usuario;
	}

	@Override
	public boolean eliminaUsuario(Long id) {
		Optional<Usuarios> usuarioOptional = usuarioDao.findById(id);
		if(!usuarioOptional.isPresent())
			return false;
		usuarioDao.deleteById(id);
		return true;
	}

	@Override
	public boolean verificaUsuario(Usuarios paUsuario) {
		String passwordAux = Util.getMD5(paUsuario.getPassword());
		Usuarios usuarioAux = usuarioDao.verificaUsuario(paUsuario.getUsuario(), passwordAux);
		if(usuarioAux!=null)
			return true;
		return false;
	}

}
