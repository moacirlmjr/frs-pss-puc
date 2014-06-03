package br.com.frs.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import br.com.frs.modelo.interfaces.Categorizable;
import br.com.frs.modelo.interfaces.Generic;

@Entity
@NamedQuery(name = "Categoria.findAllCategoriasOrdenadas", query = "select p from Categoria p order by categoria asc")
public class Categoria implements Generic, Categorizable {

	private static final long serialVersionUID = 1L;

	public static final String findAllCategoriaOrdenadas = "Categoria.findAllCategoriasOrdenadas";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categoria;

	public Categoria(String categoria) {
		super();
		this.categoria = categoria;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
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
