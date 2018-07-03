package com.aplicacao.estoqueagil.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aplicacao.estoqueagil.model.Movimento;

/**
 * 
 * @author airton.junior
 *
 */
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

	public List<Movimento> findByIdProduto(Long id);
	
	public List<Movimento> findByTipoOperacao(Long tipoOperacao);
	
	public List<Movimento> findByDataOperacao(Calendar dataOperacao);
	
	@Query("select m from Movimento m where month(m.dataOperacao) = 3 and QUANTIDADE_OPERACAO is  not null order by QUANTIDADE_OPERACAO")
	public List<Movimento> findteste(Calendar dataOperacao);
	
	
}
