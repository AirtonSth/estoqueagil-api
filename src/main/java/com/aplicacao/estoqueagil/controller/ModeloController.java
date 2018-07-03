package com.aplicacao.estoqueagil.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.model.Estoque;
import com.aplicacao.estoqueagil.model.Modelo;
import com.aplicacao.estoqueagil.model.Produto;
import com.aplicacao.estoqueagil.repository.EstoqueRepository;
import com.aplicacao.estoqueagil.repository.ModeloRepository;
import com.aplicacao.estoqueagil.repository.ProdutoRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/modelos")
public class ModeloController {

	@Autowired
	ModeloRepository modeloRepository;

	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/")
	public List<Modelo> getAllModelos(){
		return modeloRepository.findAll();
	}

	@GetMapping("/por-id/{id}")
	public Modelo getModeloById(@PathVariable Long id) {
		return modeloRepository.getOne(id);
	}
	
	@GetMapping("/por-id-marca/{id}")
	public List<Modelo> getModeloByIdMarca(@PathVariable Long id) {
		return modeloRepository.findByIdMarca(id);
	}	
	@PostMapping(path = "/salvar")
	public Modelo salvar(@RequestBody Modelo modelo){
		return modeloRepository.save(modelo);
	}
	@GetMapping("/disponivel-por-id-marca/{idMarca}/e-id-tipo-produto/{idTipoProduto}")
	public List<Modelo> getModeloDisponivelByIdMarca(@PathVariable Long idMarca, @PathVariable Long idTipoProduto) {
		List<Modelo> listaModelosDisponiveis = new ArrayList<Modelo>();
		
		List<Modelo> listaModelos = modeloRepository.findByIdMarca(idMarca);
		List<Produto> listaProdutos = new ArrayList<Produto>();
		for(Modelo modelo: listaModelos) {
			listaProdutos.addAll(produtoRepository.findByIdModeloAndIdTipoProduto(modelo.getId(), idTipoProduto));
		}
		
		List<Estoque> estoque = new ArrayList<Estoque>();
		for(Produto p : listaProdutos){
			estoque.addAll(estoqueRepository.findByQuantidadeNotNullAndIdProduto(p.getId()));
		}
		for(Estoque e : estoque){
			if(e.getIdProduto()!=null){
				Modelo modelo = new Modelo();

				Produto produto = produtoRepository.getOne(e.getIdProduto());
				
				modelo = modeloRepository.getOne(produto.getIdModelo());
				
				if(!listaModelosDisponiveis.contains(modelo)) {
					listaModelosDisponiveis.add(modelo);
				}
				
			}
		}
		return listaModelosDisponiveis;
	}	
}
