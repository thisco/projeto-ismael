package org.portalser.sistrad.dto;

import java.io.Serializable;

public class VersiculoDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long numero;
	
	private String texto;

	private String original;
	
	private String traduzido;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getTraduzido() {
		return traduzido;
	}

	public void setTraduzido(String traduzido) {
		this.traduzido = traduzido;
	}
	
	
}
