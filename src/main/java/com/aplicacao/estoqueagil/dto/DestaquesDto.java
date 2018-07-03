package com.aplicacao.estoqueagil.dto;

public class DestaquesDto {
	
	private String modeloDoMesCapinhaSaida;
	
	private String modeloDoMesPeliculaSaida;
	
	private String marcaDoMesCapinhaSaida;
	
	private String marcaDoMesPeliculaSaida;
	
	private String funcionarioDoMes;

	public String getModeloDoMesCapinhaSaida() {
		return modeloDoMesCapinhaSaida;
	}

	public void setModeloDoMesCapinhaSaida(String modeloDoMesCapinhaSaida) {
		this.modeloDoMesCapinhaSaida = modeloDoMesCapinhaSaida;
	}

	public String getModeloDoMesPeliculaSaida() {
		return modeloDoMesPeliculaSaida;
	}

	public void setModeloDoMesPeliculaSaida(String modeloDoMesPeliculaSaida) {
		this.modeloDoMesPeliculaSaida = modeloDoMesPeliculaSaida;
	}

	public String getMarcaDoMesCapinhaSaida() {
		return marcaDoMesCapinhaSaida;
	}

	public void setMarcaDoMesCapinhaSaida(String marcaDoMesCapinhaSaida) {
		this.marcaDoMesCapinhaSaida = marcaDoMesCapinhaSaida;
	}

	public String getMarcaDoMesPeliculaSaida() {
		return marcaDoMesPeliculaSaida;
	}

	public void setMarcaDoMesPeliculaSaida(String marcaDoMesPeliculaSaida) {
		this.marcaDoMesPeliculaSaida = marcaDoMesPeliculaSaida;
	}

	public String getFuncionarioDoMes() {
		return funcionarioDoMes;
	}

	public void setFuncionarioDoMes(String funcionarioDoMes) {
		this.funcionarioDoMes = funcionarioDoMes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcionarioDoMes == null) ? 0 : funcionarioDoMes.hashCode());
		result = prime * result + ((marcaDoMesCapinhaSaida == null) ? 0 : marcaDoMesCapinhaSaida.hashCode());
		result = prime * result + ((marcaDoMesPeliculaSaida == null) ? 0 : marcaDoMesPeliculaSaida.hashCode());
		result = prime * result + ((modeloDoMesCapinhaSaida == null) ? 0 : modeloDoMesCapinhaSaida.hashCode());
		result = prime * result + ((modeloDoMesPeliculaSaida == null) ? 0 : modeloDoMesPeliculaSaida.hashCode());
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
		DestaquesDto other = (DestaquesDto) obj;
		if (funcionarioDoMes == null) {
			if (other.funcionarioDoMes != null)
				return false;
		} else if (!funcionarioDoMes.equals(other.funcionarioDoMes))
			return false;
		if (marcaDoMesCapinhaSaida == null) {
			if (other.marcaDoMesCapinhaSaida != null)
				return false;
		} else if (!marcaDoMesCapinhaSaida.equals(other.marcaDoMesCapinhaSaida))
			return false;
		if (marcaDoMesPeliculaSaida == null) {
			if (other.marcaDoMesPeliculaSaida != null)
				return false;
		} else if (!marcaDoMesPeliculaSaida.equals(other.marcaDoMesPeliculaSaida))
			return false;
		if (modeloDoMesCapinhaSaida == null) {
			if (other.modeloDoMesCapinhaSaida != null)
				return false;
		} else if (!modeloDoMesCapinhaSaida.equals(other.modeloDoMesCapinhaSaida))
			return false;
		if (modeloDoMesPeliculaSaida == null) {
			if (other.modeloDoMesPeliculaSaida != null)
				return false;
		} else if (!modeloDoMesPeliculaSaida.equals(other.modeloDoMesPeliculaSaida))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DestaquesDto [modeloDoMesCapinhaSaida=" + modeloDoMesCapinhaSaida + ", modeloDoMesPeliculaSaida="
				+ modeloDoMesPeliculaSaida + ", marcaDoMesCapinhaSaida=" + marcaDoMesCapinhaSaida
				+ ", marcaDoMesPeliculaSaida=" + marcaDoMesPeliculaSaida + ", funcionarioDoMes=" + funcionarioDoMes
				+ "]";
	}
	

}
