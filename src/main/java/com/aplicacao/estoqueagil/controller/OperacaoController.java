package com.aplicacao.estoqueagil.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.model.Estoque;
import com.aplicacao.estoqueagil.model.Movimento;
import com.aplicacao.estoqueagil.repository.EstoqueRepository;
import com.aplicacao.estoqueagil.repository.MovimentoRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/operacao")
public class OperacaoController {

	@Autowired
	MovimentoRepository movimentoRepository;
	
	@Autowired
	EstoqueRepository estoqueRepository;
	
	@PostMapping(path = "/salvar")
	public Estoque salvarEstoqueMovimento(@RequestBody Movimento movimento){
		Calendar dataCorrente = Calendar.getInstance();
		movimento.setDataOperacao(dataCorrente);
		movimentoRepository.save(movimento);
		
		Estoque estoque = estoqueRepository.findByIdProduto(movimento.getIdProduto());
		Long novaQuantidade = 0L;
		if(movimento.getTipoOperacao()==0){
			novaQuantidade = estoque.getQuantidade()+movimento.getQuantidadeOperacao();
		}else{
			novaQuantidade = estoque.getQuantidade()-movimento.getQuantidadeOperacao();
		}
		if(novaQuantidade>=0){
			estoque.setQuantidade(novaQuantidade);
			return estoqueRepository.save(estoque);
		} else {
			return null; //neste momento voltar exceção
		}
	}	
}
