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
		@NamedQuery(name = "Filme.findAllFilmesOrdenadosCategoriaFilme", query = "select c from Filme c order by nome asc"),
		@NamedQuery(name = "Filme.findAllFilmesDono", query = "select c from Filme c where dono_id = :uid") })
public class Filme implements Generic, Recomendable {

	private static final long serialVersionUID = 1L;
	public static final String findAllFilmesOrdenadosCategoriaFilme = "Filme.findAllFilmesOrdenadosCategoriaFilme";
	public static final String findAllFilmesDono = "Filme.findAllFilmesDono";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String diretor;
	private String elenco;

	private Double preco;

	@OneToOne
	private CategoriaFilme categoriaFilme;

	@OneToOne
	private Usuario dono;

	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;

	private String observacao;

	@OneToOne
	private Estudio estudio;

	public Filme(Integer id, String nome, String diretor, Double preco,
			CategoriaFilme categoriaFilme, Usuario dono, Calendar dataCadastro,
			String observacao, Estudio estudio) {
		super();
		this.id = id;
		this.nome = nome;
		this.diretor = diretor;
		this.preco = preco;
		this.categoriaFilme = categoriaFilme;
		this.dono = dono;
		this.dataCadastro = dataCadastro;
		this.observacao = observacao;
		this.estudio = estudio;
	}

	public Filme(String nome, String diretor, Double preco,
			CategoriaFilme categoriaFilme, Usuario dono, Calendar dataCadastro,
			String observacao, Estudio estudio) {
		super();
		this.nome = nome;
		this.diretor = diretor;
		this.preco = preco;
		this.categoriaFilme = categoriaFilme;
		this.dono = dono;
		this.dataCadastro = dataCadastro;
		this.observacao = observacao;
		this.estudio = estudio;
	}

	public Filme() {
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

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public CategoriaFilme getCategoriaFilme() {
		return categoriaFilme;
	}

	public void setCategoriaFilme(CategoriaFilme categoriaFilme) {
		this.categoriaFilme = categoriaFilme;
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

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}

	public String getElenco() {
		return elenco;
	}

	public void setElenco(String elenco) {
		this.elenco = elenco;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Filme)
				&& ((Filme) obj).getId().equals(this.getId())) {
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
