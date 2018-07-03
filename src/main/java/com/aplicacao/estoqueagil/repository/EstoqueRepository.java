package com.aplicacao.estoqueagil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacao.estoqueagil.model.Estoque;

/**
 * 
 * @author airton.junior
 *
 */
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	public Estoque findByIdProduto(Long id);
	
	public List<Estoque> findByQuantidadeNotNullAndIdProduto(Long id);
	
	public List<Estoque> findByQuantidadeNotNull();
	
	public List<Estoque> findByQuantidadeNotNullOrderByQuantidade();
}
