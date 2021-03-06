package org.portalser.sistrad.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_livro")
@XmlRootElement
public class Livro implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="id_livro")
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;
	
	@Column(name="livro")
	private String nome;
	
	@Column(name="capitulo")
	private Long capitulo;
	
	@Column(name="versiculo")
	private Long versiculo;
	
	@Column(name="texto_grego")
	private String original;
	
	@Column(name="traducao")
	private String traduzido;
	
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

	public Livro() {
		super();
	}
	
	public Livro(String nome, Long capitulo, Long versiculo) {
		this.nome = nome;
		this.capitulo = capitulo;
		this.versiculo = versiculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Long capitulo) {
		this.capitulo = capitulo;
	}

	public Long getVersiculo() {
		return versiculo;
	}

	public void setVersiculo(Long versiculo) {
		this.versiculo = versiculo;
	}
	
	
}
