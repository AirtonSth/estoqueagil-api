package com.aplicacao.estoqueagil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author airton.junior
 *
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ID_MODELO")
	private Long idModelo;

	@Column(name = "ID_COR")
	private Long idCor;
	
	@Column(name = "ID_TIPO_PRODUTO")
	private Long idTipoProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}

	public Long getIdCor() {
		return idCor;
	}

	public void setIdCor(Long idCor) {
		this.idCor = idCor;
	}

	public Long getIdTipoProduto() {
		return idTipoProduto;
	}

	public void setIdTipoProduto(Long idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idCor == null) ? 0 : idCor.hashCode());
		result = prime * result + ((idModelo == null) ? 0 : idModelo.hashCode());
		result = prime * result + ((idTipoProduto == null) ? 0 : idTipoProduto.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCor == null) {
			if (other.idCor != null)
				return false;
		} else if (!idCor.equals(other.idCor))
			return false;
		if (idModelo == null) {
			if (other.idModelo != null)
				return false;
		} else if (!idModelo.equals(other.idModelo))
			return false;
		if (idTipoProduto == null) {
			if (other.idTipoProduto != null)
				return false;
		} else if (!idTipoProduto.equals(other.idTipoProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", idModelo=" + idModelo + ", idCor=" + idCor + ", idTipoProduto=" + idTipoProduto
				+ "]";
	}


}
