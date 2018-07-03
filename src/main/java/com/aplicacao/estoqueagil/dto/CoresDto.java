package com.aplicacao.estoqueagil.dto;

public class CoresDto {

	private Long id;
	
	private String descricaoCor;
	
	private Long  quantidadeCor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoCor() {
		return descricaoCor;
	}

	public void setDescricaoCor(String descricaoCor) {
		this.descricaoCor = descricaoCor;
	}

	public Long getQuantidadeCor() {
		return quantidadeCor;
	}

	public void setQuantidadeCor(Long quantidadeCor) {
		this.quantidadeCor = quantidadeCor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoCor == null) ? 0 : descricaoCor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((quantidadeCor == null) ? 0 : quantidadeCor.hashCode());
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
		CoresDto other = (CoresDto) obj;
		if (descricaoCor == null) {
			if (other.descricaoCor != null)
				return false;
		} else if (!descricaoCor.equals(other.descricaoCor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (quantidadeCor == null) {
			if (other.quantidadeCor != null)
				return false;
		} else if (!quantidadeCor.equals(other.quantidadeCor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoresDto [id=" + id + ", descricaoCor=" + descricaoCor + ", quantidadeCor=" + quantidadeCor + "]";
	}

	
	
	

}
