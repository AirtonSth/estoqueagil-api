package com.aplicacao.estoqueagil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacao.estoqueagil.model.Produto;

/**
 * 
 * @author airton.junior
 *
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findByIdModelo(Long id);
	
	public List<Produto> findByIdTipoProduto(Long id);
	
	public List<Produto> findByIdModeloAndIdTipoProduto(Long idModelo, Long idTipoProduto);
}
