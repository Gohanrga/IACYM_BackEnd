package com.acym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acym.entity.Usuarios;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.LoginIncorrecto;
import com.acym.resource.exceptions.UsuarioIdNoEncontrado;
import com.acym.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/listarUsuario")
	public List<Usuarios> obtieneUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	@GetMapping("/getUsuario/{id}")
	public Usuarios obtieneUsuario(@PathVariable Long id) {
		return usuarioService.getUsuario(id);
	}
	 
	@RequestMapping(method=RequestMethod.POST, value="/registroUsuario")
	public Usuarios registraUsuario(@RequestBody Usuarios usuario) throws CampoVacio {
		return usuarioService.registraUsuario(usuario);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/logueo")
	public Usuarios verificaUsuario(@RequestBody Usuarios usuario) throws LoginIncorrecto {
		return usuarioService.verificaUsuario(usuario);
	}
	
	@PutMapping("/modificaUsuario")
	public Usuarios modificaUsuario(@RequestBody  Usuarios usuario) throws CampoVacio, UsuarioIdNoEncontrado {
		return usuarioService.modificaUsuario(usuario);
	}
	
	@DeleteMapping("/eliminaUsuario/{id}")
	public boolean eliminaUsuario(@PathVariable Long id) throws UsuarioIdNoEncontrado {
		return usuarioService.eliminaUsuario(id);
	}
	
	
}
