package br.com.frs.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import br.com.frs.modelo.interfaces.Categorizable;
import br.com.frs.modelo.interfaces.Generic;

@Entity
@NamedQuery(name = "CategoriaMusica.findAllCategoriaMusicasOrdenadas", query = "select p from CategoriaMusica p order by categoria asc")
public class CategoriaMusica implements Generic, Categorizable {

	private static final long serialVersionUID = 1L;

	public static final String findAllCategoriaMusicaOrdenadas = "CategoriaMusica.findAllCategoriaMusicasOrdenadas";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categoria;

	public CategoriaMusica(String categoria) {
		super();
		this.categoria = categoria;
	}

	public CategoriaMusica() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
