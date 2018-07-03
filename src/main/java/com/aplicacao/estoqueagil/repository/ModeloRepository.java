package com.aplicacao.estoqueagil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacao.estoqueagil.model.Modelo;

/**
 * 
 * @author airton.junior
 *
 */
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	List<Modelo> findByIdMarca(Long idMarca);
}
