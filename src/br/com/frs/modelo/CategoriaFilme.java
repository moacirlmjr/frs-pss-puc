package br.com.frs.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import br.com.frs.modelo.interfaces.Categorizable;
import br.com.frs.modelo.interfaces.Generic;

@Entity
@NamedQuery(name = "CategoriaFilme.findAllCategoriaFilmesOrdenadas", query = "select p from CategoriaFilme p order by categoria asc")
public class CategoriaFilme implements Generic, Categorizable {

	private static final long serialVersionUID = 1L;

	public static final String findAllCategoriaFilmeOrdenadas = "CategoriaFilme.findAllCategoriaFilmesOrdenadas";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String categoria;

	public CategoriaFilme(String categoria) {
		super();
		this.categoria = categoria;
	}

	public CategoriaFilme() {
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
	
	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof CategoriaFilme)
				&& ((CategoriaFilme) obj).getId().equals(this.getId())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();

	}

}
