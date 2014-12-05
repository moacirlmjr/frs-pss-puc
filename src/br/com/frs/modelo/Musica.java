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
		@NamedQuery(name = "Musica.findAllMusicasOrdenadosCategoriaMusica", query = "select c from Musica c order by nome asc"),
		@NamedQuery(name = "Musica.findAllMusicasDono", query = "select c from Musica c where dono_id = :uid") })
public class Musica implements Generic, Recomendable {

	private static final long serialVersionUID = 1L;
	public static final String findAllMusicasOrdenadosCategoriaMusica = "Musica.findAllMusicasOrdenadosCategoriaMusica";
	public static final String findAllMusicasDono = "Musica.findAllMusicasDono";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String autor;
	private String album;
	private Double preco;

	@OneToOne
	private CategoriaMusica categoriaMusica;

	@OneToOne
	private Usuario dono;

	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;

	private String observacao;

	@OneToOne
	private Gravadora gravadora;

	public Musica(Integer id, String nome, String autor, Double preco,
			CategoriaMusica categoriaMusica, Usuario dono,
			Calendar dataCadastro, String observacao, Gravadora gravadora) {
		super();
		this.id = id;
		this.nome = nome;
		this.autor = autor;
		this.preco = preco;
		this.categoriaMusica = categoriaMusica;
		this.dono = dono;
		this.dataCadastro = dataCadastro;
		this.observacao = observacao;
		this.gravadora = gravadora;
	}

	public Musica(String nome, String autor, Double preco,
			CategoriaMusica categoriaMusica, Usuario dono,
			Calendar dataCadastro, String observacao, Gravadora gravadora) {
		super();
		this.nome = nome;
		this.autor = autor;
		this.preco = preco;
		this.categoriaMusica = categoriaMusica;
		this.dono = dono;
		this.dataCadastro = dataCadastro;
		this.observacao = observacao;
		this.gravadora = gravadora;
	}

	public Musica() {
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

	public CategoriaMusica getCategoriaMusica() {
		return categoriaMusica;
	}

	public void setCategoriaMusica(CategoriaMusica categoriaMusica) {
		this.categoriaMusica = categoriaMusica;
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

	public Gravadora getGravadora() {
		return gravadora;
	}

	public void setGravadora(Gravadora gravadora) {
		this.gravadora = gravadora;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

}
