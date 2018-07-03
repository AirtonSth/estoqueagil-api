package com.aplicacao.estoqueagil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aplicacao.estoqueagil.model.Marca;

/**
 * 
 * @author airton.junior
 *
 */
@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

	Marca findByDescricao(String descricao);
}
