package com.aplicacao.estoqueagil.dto;

import java.io.Serializable;

public class ProdutosDto implements Comparable<ProdutosDto>, Serializable{
	
	private Long idProduto;
	
	private String marcaProduto;
	
	private String modeloProduto;
	
	private Long quantidadeProduto;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getModeloProduto() {
		return modeloProduto;
	}

	public void setModeloProduto(String modeloProduto) {
		this.modeloProduto = modeloProduto;
	}


	public Long getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Long quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
		result = prime * result + ((marcaProduto == null) ? 0 : marcaProduto.hashCode());
		result = prime * result + ((modeloProduto == null) ? 0 : modeloProduto.hashCode());
		result = prime * result + ((quantidadeProduto == null) ? 0 : quantidadeProduto.hashCode());
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
		ProdutosDto other = (ProdutosDto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		if (marcaProduto == null) {
			if (other.marcaProduto != null)
				return false;
		} else if (!marcaProduto.equals(other.marcaProduto))
			return false;
		if (modeloProduto == null) {
			if (other.modeloProduto != null)
				return false;
		} else if (!modeloProduto.equals(other.modeloProduto))
			return false;
		if (quantidadeProduto == null) {
			if (other.quantidadeProduto != null)
				return false;
		} else if (!quantidadeProduto.equals(other.quantidadeProduto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProdutosDto [idProduto=" + idProduto + ", marcaProduto=" + marcaProduto + ", modeloProduto="
				+ modeloProduto + ", quantidadeProduto=" + quantidadeProduto + "]";
	}

	@Override
	public int compareTo(ProdutosDto o) {
		return marcaProduto.compareTo(o.getMarcaProduto());
	}
	

}
