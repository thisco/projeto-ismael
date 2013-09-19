package org.portalser.sistrad.dto;

import java.io.Serializable;
import java.util.List;

public class CapituloDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Long numero;
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	private List<VersiculoDTO> versiculos;

	public List<VersiculoDTO> getVersiculos() {
		return versiculos;
	}

	public void setVersiculos(List<VersiculoDTO> versiculos) {
		this.versiculos = versiculos;
	}
	
}