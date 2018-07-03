package com.aplicacao.estoqueagil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.model.Marca;
import com.aplicacao.estoqueagil.repository.MarcaRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/marcas")
public class MarcaController {

	@Autowired
	MarcaRepository marcaRepository;
	
	@GetMapping("/")
	public List<Marca> getAllMarcas(){
		return marcaRepository.findAll();
	}
	
	@GetMapping("/por-id/{id}")
	public Marca getMarcaById(@PathVariable Long id) {
		return marcaRepository.getOne(id);
	}
	
	@PostMapping(path = "/salvar")
	public Marca salvar(@RequestBody Marca marca){
		return marcaRepository.save(marca);
	}
}
