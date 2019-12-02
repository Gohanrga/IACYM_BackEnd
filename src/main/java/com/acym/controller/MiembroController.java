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

import com.acym.entity.Miembro;
import com.acym.resource.exceptions.CampoVacio;
import com.acym.resource.exceptions.MiembroNoExiste;
import com.acym.resource.exceptions.TarjetaDiezmoRelacionada;
import com.acym.service.IMiembroService;

@RestController
@RequestMapping("/api")
public class MiembroController {
	@Autowired
	private IMiembroService miembroService;
	
	@GetMapping("/listarMiembros")
	public List<Miembro> obtieneMiembros(){
		return miembroService.getMiembros();
	}
	
	@GetMapping("/getMiembro/{id}")
	public Miembro obtieneMiembro(@PathVariable Long id) {
		return miembroService.getMiembroById(id);
	}
	
	@GetMapping("/buscaMiembro/{nombre}/{codigoDiezmo}")
	public List<Miembro> buscaMiembros(@PathVariable String nombre,@PathVariable int codigoDiezmo){
		return miembroService.buscaMiembros(nombre, codigoDiezmo);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registroMiembro")
	public Miembro registraMiembro(@RequestBody Miembro miembro) throws CampoVacio, TarjetaDiezmoRelacionada {
		return miembroService.registraMiembro(miembro);
	}
	
	@PutMapping("/modificaMiembro")
	public Miembro modificaMiembro(@RequestBody Miembro miembro) throws CampoVacio, MiembroNoExiste {
		return miembroService.modificaMiembro(miembro);
	}
	
	@GetMapping("/estadoMiembro/{id}")
	public boolean eliminaMiembro(@PathVariable Long id) throws MiembroNoExiste {
		return miembroService.cambiaEstado(id);
	}
}
