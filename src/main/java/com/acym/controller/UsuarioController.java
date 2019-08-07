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
	public Usuarios registraUsuario(Usuarios usuario) {
		return usuarioService.registraUsuario(usuario);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/logueo")
	public boolean verificaUsuario(Usuarios usuario) {
		return usuarioService.verificaUsuario(usuario);
	}
	
	@PutMapping("/modificaUsuario/{id}")
	public Usuarios modificaUsuario(Usuarios usuario, @PathVariable Long id) {
		return usuarioService.modificaUsuario(usuario, id);
	}
	
	@DeleteMapping("/eliminaUsuario/{id}")
	public boolean eliminaUsuario(@PathVariable Long id) {
		return usuarioService.eliminaUsuario(id);
	}
	
	
}
