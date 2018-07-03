package com.aplicacao.estoqueagil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.model.TipoProduto;
import com.aplicacao.estoqueagil.repository.TipoProdutoRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/tiposProduto")
public class TiposProdutoController {
	
	@Autowired
	TipoProdutoRepository tipoProdutoRepository;
	
	@GetMapping("/")
	public List<TipoProduto> getAllTiposProduto(){
		return tipoProdutoRepository.findAll();
	}
}
