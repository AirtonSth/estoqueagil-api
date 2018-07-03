package com.aplicacao.estoqueagil.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author airton.junior
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "movimentos")
public class Movimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TIPO_OPERACAO")
	private Long tipoOperacao;
	
	@Column(name = "ID_PRODUTO")
	private Long idProduto;

	@Column(name = "QUANTIDADE_OPERACAO")
	private Long quantidadeOperacao;
	
	@Column(name = "DT_OPERACAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataOperacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(Long tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getQuantidadeOperacao() {
		return quantidadeOperacao;
	}

	public void setQuantidadeOperacao(Long quantidadeOperacao) {
		this.quantidadeOperacao = quantidadeOperacao;
	}

	public Calendar getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Calendar dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataOperacao == null) ? 0 : dataOperacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		result = prime * result + ((quantidadeOperacao == null) ? 0 : quantidadeOperacao.hashCode());
		result = prime * result + ((tipoOperacao == null) ? 0 : tipoOperacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		if (dataOperacao == null) {
			if (other.dataOperacao != null)
				return false;
		} else if (!dataOperacao.equals(other.dataOperacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		if (quantidadeOperacao == null) {
			if (other.quantidadeOperacao != null)
				return false;
		} else if (!quantidadeOperacao.equals(other.quantidadeOperacao))
			return false;
		if (tipoOperacao == null) {
			if (other.tipoOperacao != null)
				return false;
		} else if (!tipoOperacao.equals(other.tipoOperacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movimento [id=" + id + ", tipoOperacao=" + tipoOperacao + ", idProduto=" + idProduto
				+ ", quantidadeOperacao=" + quantidadeOperacao + ", dataOperacao=" + dataOperacao + "]";
	}
	
}
