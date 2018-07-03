package com.aplicacao.estoqueagil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.model.Produto;
import com.aplicacao.estoqueagil.repository.ProdutoRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/")
	public List<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}

	@GetMapping("/por-id/{id}")
	public Produto getProdutoById(@PathVariable Long id) {
		return produtoRepository.getOne(id);
	}
	
	@GetMapping("/por-id-modelo/{id}")
	public List<Produto> getProdutosByIdModelo(@PathVariable Long id) {
		return produtoRepository.findByIdModelo(id);
	}
	@GetMapping("/por-id-tipo-produto/{id}")
	public List<Produto> getProdutosByIdTipoProduto(@PathVariable Long id) {
		return produtoRepository.findByIdTipoProduto(id);
	}	
	@PostMapping(path = "/salvar")
	public Produto salvar(@RequestBody Produto produto){
		return produtoRepository.save(produto);
	}
}
