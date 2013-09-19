package org.portalser.sistrad.dto;

import java.io.Serializable;
import java.util.List;

public class LivroDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	public LivroDTO(Long id, String nome) {
		this.nome = nome;
		this.id = id;
	}

	public LivroDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private List<CapituloDTO> capitulos;

	public List<CapituloDTO> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<CapituloDTO> capitulos) {
		this.capitulos = capitulos;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
