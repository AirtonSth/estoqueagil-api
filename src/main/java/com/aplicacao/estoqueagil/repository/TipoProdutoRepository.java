package com.aplicacao.estoqueagil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacao.estoqueagil.model.TipoProduto;

/**
 * 
 * @author airton.junior
 *
 */
public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {

}
