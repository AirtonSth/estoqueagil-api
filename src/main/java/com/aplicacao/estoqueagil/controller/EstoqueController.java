package com.aplicacao.estoqueagil.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.dto.ProdutosDto;
import com.aplicacao.estoqueagil.model.Estoque;
import com.aplicacao.estoqueagil.model.Marca;
import com.aplicacao.estoqueagil.model.Modelo;
import com.aplicacao.estoqueagil.model.Produto;
import com.aplicacao.estoqueagil.repository.CorRepository;
import com.aplicacao.estoqueagil.repository.EstoqueRepository;
import com.aplicacao.estoqueagil.repository.MarcaRepository;
import com.aplicacao.estoqueagil.repository.ModeloRepository;
import com.aplicacao.estoqueagil.repository.ProdutoRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	CorRepository corRepository;	
	
	@Autowired
	EstoqueRepository estoqueRepository;

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ModeloRepository modeloRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	
	
	@GetMapping("/")
	public List<Estoque> getAllEstoque(){
		return estoqueRepository.findAll();
	}
	
	@GetMapping("/por-id-produto/{id}")
	public Estoque getEstoqueByIdProduto(@PathVariable Long id) {
		return estoqueRepository.findByIdProduto(id);
	}
	
	@GetMapping("estoque-em-falta-por-id-tipo/{tipoProduto}")
	public List<ProdutosDto> getEstoquePorIdTipo(@PathVariable Long tipoProduto){
		
		List<ProdutosDto> listaProdutos = new ArrayList<ProdutosDto>();
		List<ProdutosDto> produtosTemp = new ArrayList<ProdutosDto>();
		
		List<Produto> produtos = produtoRepository.findByIdTipoProduto(tipoProduto);
		
		List<Estoque> estoque = new ArrayList<Estoque>();
		
		for(Produto p : produtos){
			estoque.addAll(estoqueRepository.findByQuantidadeNotNullAndIdProduto(p.getId()));
		}
		
		for(Estoque e : estoque){
			if(e.getIdProduto()!=null){
				ProdutosDto produtoDto = new ProdutosDto();
				ProdutosDto produtoTemp = new ProdutosDto();
				
				Produto produto = produtoRepository.getOne(e.getIdProduto());
				Modelo modelo = modeloRepository.getOne(produto.getIdModelo());
				Marca marca = marcaRepository.getOne(modelo.getIdMarca());
				
				produtoTemp.setModeloProduto(modelo.getDescricao());
				
				if(!produtosTemp.contains(produtoTemp)){
					
					
					produtoDto.setIdProduto(e.getIdProduto());
					produtoDto.setModeloProduto(modelo.getDescricao());
					produtoDto.setMarcaProduto(marca.getDescricao());
					produtoDto.setQuantidadeProduto(e.getQuantidade());
					
					listaProdutos.add(produtoDto);
				
					produtosTemp.add(produtoTemp);
				}else{
					for(ProdutosDto p : listaProdutos) {
						if(p.getModeloProduto().equals(produtoTemp.getModeloProduto())) {
							p.setQuantidadeProduto(p.getQuantidadeProduto()+e.getQuantidade());
						}
					}
				}
				
			}
		}
	
		Collections.sort(listaProdutos, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				ProdutosDto p1 = (ProdutosDto) o1;
				ProdutosDto p2 = (ProdutosDto) o2;
				return p1.getQuantidadeProduto() < p2.getQuantidadeProduto()? -1 : (p1.getQuantidadeProduto() > p1.getQuantidadeProduto() ? +1: 0);
			}
		});
		
		
		return listaProdutos;
	}	
}















