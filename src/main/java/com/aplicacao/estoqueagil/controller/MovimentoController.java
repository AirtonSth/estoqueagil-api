package com.aplicacao.estoqueagil.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacao.estoqueagil.model.Movimento;
import com.aplicacao.estoqueagil.repository.MovimentoRepository;

/**
 * 
 * @author airton.junior
 *
 */
@RestController
@RequestMapping("/movimentos")
public class MovimentoController {

	@Autowired
	MovimentoRepository movimentoRepository;

	@GetMapping("/")
	public List<Movimento> getAllMovimentos(){
		return movimentoRepository.findAll();
	}

	@GetMapping("/por-id-produto/{id}")
	public List<Movimento> getMovimentosByIdProduto(@PathVariable Long id) {
		return movimentoRepository.findByIdProduto(id);
	}
	
	@GetMapping("/por-tipo-operacao/{tipoOperacao}")
	public List<Movimento> getMovimentosByTipoOperacao(@PathVariable Long tipoOperacao) {
		return movimentoRepository.findByTipoOperacao(tipoOperacao);
	}

	@GetMapping("/por-data-operacao/{dataOperacao}")
	public List<Movimento> getMovimentosByDataOperacao(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Calendar dataOperacao) {
		return movimentoRepository.findByDataOperacao(dataOperacao);
	}
	
	@GetMapping("/teste")
	public List<Movimento> teste() {
		Calendar dataOperacao  = Calendar.getInstance();
		dataOperacao.getTime();
		return movimentoRepository.findteste(dataOperacao);
	}
	
}
