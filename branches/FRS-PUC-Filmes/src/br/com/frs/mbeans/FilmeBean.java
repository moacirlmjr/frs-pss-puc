package br.com.frs.mbeans;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.CategoriaFilme;
import br.com.frs.modelo.Estudio;
import br.com.frs.modelo.Filme;
import br.com.frs.modelo.Usuario;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class FilmeBean {

	private Filme filme;
	private Integer filmeID;
	private Integer categoriaID;
	private Integer estudioID;

	public FilmeBean() {
		filme = new Filme();
	}

	public Integer getCategoriaID() {
		return categoriaID;
	}

	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}

	public Integer getEstudioID() {
		return estudioID;
	}

	public void setEstudioID(Integer estudioID) {
		this.estudioID = estudioID;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setfilme(Filme filme) {
		this.filme = filme;
	}

	public Integer getFilmeID() {
		return filmeID;
	}

	public void setFilmeID(Integer filmeID) {
		this.filmeID = filmeID;
	}

	public List<Filme> getFilmes() {
		return new DAO<Filme>(Filme.class).listaTodos();
	}

	public void validaDataNascimento(FacesContext context,
			UIComponent component, Object value) {

		Date dataInicio = (Date) value;

		Date hoje = (Date) Calendar.getInstance().getTime();
		if (hoje.after(dataInicio)) {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(dataInicio.getTime());
			c.add(Calendar.DAY_OF_YEAR, 1);
			this.filme.setDataCadastro(c);
		} else {
			throw new ValidatorException(new FacesMessage(
					"Data de cadastro eh maior ou igual a hoje"));
		}
	}

	public List<Filme> getFilmesUsuario() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", doador.getId());
		return new DAO<Filme>(Filme.class).findListResults(Filme.findAllFilmesDono, params);
	}
	
	public List<Filme> getFilmesUsuario(Usuario u) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", u.getId());
		return new DAO<Filme>(Filme.class).findListResults(Filme.findAllFilmesDono, params);
	}

	public void gravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		CategoriaFilme cat = new DAO<CategoriaFilme>(CategoriaFilme.class).buscaPorId(categoriaID);
		Estudio ed = new DAO<Estudio>(Estudio.class).buscaPorId(estudioID);
		
		this.filme.setDono(doador);
		this.filme.setEstudio(ed);
		this.filme.setCategoriaFilme(cat);
		System.out.println("adicionando o filme" + this.filme.getNome()
				+ "do vendedor" + this.filme.getDono().getNome());
		new DAO<Filme>(Filme.class).adiciona(filme);
		JSFMessageUtil.sendInfoMessageToUser(this.filme.getNome()
				+ " adicionado com sucesso!!!");
	}

}
