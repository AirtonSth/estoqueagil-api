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

import com.aplicacao.estoqueagil.dto.CoresDto;
import com.aplicacao.estoqueagil.model.Cor;
import com.aplicacao.estoqueagil.model.Estoque;
import com.aplicacao.estoqueagil.model.Produto;
import com.aplicacao.estoqueagil.repository.CorRepository;
import com.aplicacao.estoqueagil.repository.EstoqueRepository;
import com.aplicacao.estoqueagil.repository.ProdutoRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/cores")
public class CorController {

	@Autowired
	CorRepository corRepository;

	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/")
	public List<Cor> getAllCores(){
		return corRepository.findAll();
	}
	
	@GetMapping("/por-id/{id}")
	public Cor getCorById(@PathVariable Long id) {
		return corRepository.getOne(id);
	}
	
	@PostMapping(path = "/salvar")
	public Cor salvar(@RequestBody Cor cor){
		return corRepository.save(cor);
	}
	
	@GetMapping("/cores-disponiveis-por-id-modelo/{idModelo}/e-id-tipo-produto/{idTipoProduto}")
	public List<CoresDto> getCoresDisponiveis(@PathVariable Long idModelo, @PathVariable Long idTipoProduto){
		
		List<CoresDto> cores = new ArrayList<CoresDto>();
		
		List<CoresDto> coresTemp = new ArrayList<CoresDto>();
		
		List<Produto> produtos = produtoRepository.findByIdModeloAndIdTipoProduto(idModelo, idTipoProduto);
		
		List<Estoque> estoque = new ArrayList<Estoque>();
		
		for(Produto p : produtos){
			estoque.addAll(estoqueRepository.findByQuantidadeNotNullAndIdProduto(p.getId()));
		}
		
		
		for(Estoque e : estoque){
			if(e.getIdProduto()!=null){
				CoresDto corDto = new CoresDto();
				CoresDto corDtoTemp = new CoresDto();
				Produto produto = produtoRepository.getOne(e.getIdProduto());
				
				Cor cor = corRepository.getOne(produto.getIdCor());
				
				corDtoTemp.setDescricaoCor(cor.getDescricao());
				
				if(!coresTemp.contains(corDtoTemp)){
					corDto.setId(produto.getIdCor());
					corDto.setDescricaoCor(cor.getDescricao());
					corDto.setQuantidadeCor(e.getQuantidade());
					
					cores.add(corDto);
					
					coresTemp.add(corDtoTemp);
				}else{
					for(CoresDto c : cores){
						if(c.getDescricaoCor().equals(corDtoTemp.getDescricaoCor())){
							c.setQuantidadeCor(c.getQuantidadeCor()+e.getQuantidade());
						}
					}
				}
				
			}
		}
		
	
		return cores;
	}
}
