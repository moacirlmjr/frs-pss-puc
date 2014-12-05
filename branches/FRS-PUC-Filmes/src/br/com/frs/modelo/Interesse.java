package br.com.frs.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.frs.modelo.enumerator.InteresseStatus;
import br.com.frs.modelo.interfaces.Generic;
import br.com.frs.util.CalendarUtil;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "Interesse.findAllInteresses", query = "select i from Interesse i order by usuario_id"),
		@NamedQuery(name = "Interesse.findAllInteressadosLivros", query = "select i from Interesse i where categoria_id = :cid"),
		@NamedQuery(name = "Interesse.findAllInteressadosMusica", query = "select i from Interesse i where categoriaMusica_id = :cid"),
		@NamedQuery(name = "Interesse.findAllInteressadosFilmes", query = "select i from Interesse i where categoriaFilme_id = :cid"),
		@NamedQuery(name = "Interesse.findAllInteressesUser", query = "select i from Interesse i where usuario_id = :uid"),
		@NamedQuery(name = "Interesse.findAllInteressesAtivos", query = "select i from Interesse i where status = 'ATIVO' order by dataRegistro desc"),
		@NamedQuery(name = "Interesse.findAllInteressesInativos", query = "select i from Interesse i where status = 'INATIVO' order by dataRegistro desc"),
		@NamedQuery(name = "Interesse.findAllInteressesAtendidos", query = "select i from Interesse i where status = 'ATENDIDO' order by dataRegistro desc") })
public class Interesse implements Generic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String findAllInteresses = "Interesse.findAllInteresses";
	public static final String findAllInteressesAtivos = "Interesse.findAllInteressesAtivos";
	public static final String findAllInteressesInativos = "Interesse.findAllInteressesInativos";
	public static final String findAllInteressesAtendidos = "Interesse.findAllInteressesAtendidos";
	public static final String findAllInteressesUser = "Interesse.findAllInteressesUser";
	public static final String findAllInteressadosVendedorLivro = "Interesse.findAllInteressadosLivros";
	public static final String findAllInteressadosVendedorMusica = "Interesse.findAllInteressadosMusica";
	public static final String findAllInteressadosVendedorFilme = "Interesse.findAllInteressadosFilmes";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Calendar dataRegistro;

	@OneToOne
	private Usuario usuario;

	@OneToOne
	private Categoria categoriaDeInteresse;

	@OneToOne
	private CategoriaFilme categoriaFilmeDeInteresse;

	@OneToOne
	private CategoriaMusica categoriaMusicaDeInteresse;

	@Enumerated(EnumType.STRING)
	private InteresseStatus status;

	public Interesse() {
		usuario = new Usuario();
		categoriaDeInteresse = new Categoria();
		categoriaFilmeDeInteresse = new CategoriaFilme();
		categoriaMusicaDeInteresse = new CategoriaMusica();
		dataRegistro = CalendarUtil.retornaDiaDeHoje();
	}

	public Interesse(Usuario usuario, Categoria categoriaDeInteresse, CategoriaFilme categoriaFilmeDeInteresse, CategoriaMusica categoriaMusicaDeInteresse) {
		super();
		this.dataRegistro = CalendarUtil.retornaDiaDeHoje();
		this.usuario = usuario;
		this.categoriaDeInteresse = categoriaDeInteresse;
		this.categoriaFilmeDeInteresse = categoriaFilmeDeInteresse;
		this.categoriaMusicaDeInteresse = categoriaMusicaDeInteresse;
		this.status = InteresseStatus.ATIVO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoriaDeInteresse() {
		return categoriaDeInteresse;
	}

	public void setCategoriaDeInteresse(Categoria categoriaDeInteresse) {
		this.categoriaDeInteresse = categoriaDeInteresse;
	}

	public InteresseStatus getStatus() {
		return status;
	}

	public void setStatus(InteresseStatus status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Interesse)
				&& ((Interesse) obj).getId().equals(this.getId())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();

	}

	public CategoriaFilme getCategoriaFilmeDeInteresse() {
		return categoriaFilmeDeInteresse;
	}

	public void setCategoriaFilmeDeInteresse(
			CategoriaFilme categoriaFilmeDeInteresse) {
		this.categoriaFilmeDeInteresse = categoriaFilmeDeInteresse;
	}

	public CategoriaMusica getCategoriaMusicaDeInteresse() {
		return categoriaMusicaDeInteresse;
	}

	public void setCategoriaMusicaDeInteresse(
			CategoriaMusica categoriaMusicaDeInteresse) {
		this.categoriaMusicaDeInteresse = categoriaMusicaDeInteresse;
	}

}
