package com.acym.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acym.dao.UsuarioDao;
import com.acym.entity.Usuarios;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.LoginIncorrecto;
import com.acym.resource.exceptions.UsuarioIdNoEncontrado;
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
	public Usuarios registraUsuario(Usuarios usuario) throws CampoVacio {
		if(usuario.getUsuario().equals(""))
			throw new CampoVacio("usuario");
		if(usuario.getPassword().equals(""))
			throw new CampoVacio("password");
		if(usuario.getNombre().equals(""))
			throw new CampoVacio("nombre");
		//encryptamos la contraseña
		usuario.setPassword(Util.getMD5(usuario.getPassword()));
		usuario.setEstado(1);//1 es activo
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuarios modificaUsuario(Usuarios usuario) throws CampoVacio,UsuarioIdNoEncontrado {
		if(usuario.getUsuario().equals(""))
			throw new CampoVacio("usuario");
		if(usuario.getPassword().equals(""))
			throw new CampoVacio("password");
		if(usuario.getNombre().equals(""))
			throw new CampoVacio("nombre");
		
		Optional<Usuarios> usuarioOptional = usuarioDao.findById(usuario.getIdUsuario());
		if(!usuarioOptional.isPresent())
			throw new UsuarioIdNoEncontrado();
		Usuarios usuarioAux = usuarioOptional.get();
		usuarioAux.setUsuario(usuario.getUsuario());
		usuarioAux.setNombre(usuario.getNombre());
		usuarioAux.setApellido(usuario.getApellido());
		usuarioAux.setEstado(usuario.getEstado());
		if(!usuarioAux.getPassword().equals(usuario.getPassword()))
			usuarioAux.setPassword(Util.getMD5(usuario.getPassword()));
		//usuario.setIdUsuario(usuario.getIdUsuario());
		usuarioDao.save(usuarioAux);
		return usuarioAux;
	}

	@Override
	public boolean eliminaUsuario(Long id) throws UsuarioIdNoEncontrado {
		Optional<Usuarios> usuarioOptional = usuarioDao.findById(id);
		if(!usuarioOptional.isPresent())
			throw new UsuarioIdNoEncontrado();
		usuarioDao.deleteById(id);
		return true;
	}

	@Override
	public Usuarios verificaUsuario(Usuarios paUsuario) throws LoginIncorrecto {
		String passwordAux = Util.getMD5(paUsuario.getPassword());
		Usuarios usuarioAux = usuarioDao.verificaUsuario(paUsuario.getUsuario(), passwordAux);
		if(usuarioAux==null)
			throw new LoginIncorrecto();
		return usuarioAux;
	}

}
