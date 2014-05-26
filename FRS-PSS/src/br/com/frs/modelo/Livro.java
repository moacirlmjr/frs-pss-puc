package br.com.frs.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.frs.modelo.interfaces.Generic;
import br.com.frs.modelo.interfaces.Recomendable;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Livro.findAllLivrosOrdenadosCategoria", query = "select c from Livro c order by nome asc"),
		@NamedQuery(name = "Livro.findAllLivrosDono", query = "select c from Livro c where dono_id = :uid") })
public class Livro implements Generic, Recomendable {

	private static final long serialVersionUID = 1L;
	public static final String findAllLivrosOrdenadosCategoria = "Livro.findAllLivrosOrdenadosCategoria";
	public static final String findAllLivrosDono = "Livro.findAllLivrosDono";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String autor;
	private Double preco;

	@OneToOne
	private Categoria categoria;

	@OneToOne
	private Usuario dono;

	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;

	private String observacao;

	@OneToOne
	private Editora editora;

	public Livro(Integer id, String nome, String autor, Double preco,
			Categoria categoria, Usuario dono, Calendar dataCadastro,
			String observacao, Editora editora) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.preco = preco;
		this.categoria = categoria;
		this.dono = dono;
		this.dataCadastro = dataCadastro;
		this.observacao = observacao;
		this.editora = editora;
	}

	public Livro(String nome, String autor, Double preco, Categoria categoria,
			Usuario dono, Calendar dataCadastro, String observacao,
			Editora editora) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.preco = preco;
		this.categoria = categoria;
		this.dono = dono;
		this.dataCadastro = dataCadastro;
		this.observacao = observacao;
		this.editora = editora;
	}

	public Livro() {
		super();
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	


}
