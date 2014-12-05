package br.com.frs.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.frs.modelo.interfaces.Generic;

@Entity
public class Gravadora implements Generic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	public Gravadora(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Gravadora(String nome) {
		super();
		this.nome = nome;
	}

	public Gravadora() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
