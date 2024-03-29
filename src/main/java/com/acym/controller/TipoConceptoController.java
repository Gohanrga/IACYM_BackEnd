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

import com.acym.entity.TipoConcepto;
import com.acym.resource.exceptions.ClasificadorNoEncontrado;
import com.acym.service.ITipoConceptoService;
@RestController
@RequestMapping("/api")
public class TipoConceptoController {
	@Autowired
	private ITipoConceptoService tipoConceptoService;
	
	@GetMapping("/listarConceptos")
	public List<TipoConcepto> obtieneConceptos(){
		return tipoConceptoService.getTiposConcepto();
	}
	
	@GetMapping("/getConcepto/{id}")
	public TipoConcepto obtieneConcepto(@PathVariable Long id) {
		return tipoConceptoService.getTipoConcepto(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/registroConcepto")
	public TipoConcepto registraConcepto(@RequestBody TipoConcepto tipoConcepto){
		return tipoConceptoService.registroConcepto(tipoConcepto);
	}
	
	@PutMapping("/modificaConcepto")
	public TipoConcepto modificaConcepto(@RequestBody TipoConcepto tipoConcepto) throws ClasificadorNoEncontrado{
		return tipoConceptoService.modificaConcepto(tipoConcepto);
	}
	
	@DeleteMapping("/eliminaConcepto/{id}")
	public boolean eliminaConcepto(@PathVariable Long id) {
		return tipoConceptoService.eliminaTipoConcepto(id);
	}
}
