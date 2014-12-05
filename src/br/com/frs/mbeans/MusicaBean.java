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
import br.com.frs.modelo.CategoriaMusica;
import br.com.frs.modelo.Gravadora;
import br.com.frs.modelo.Musica;
import br.com.frs.modelo.Usuario;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class MusicaBean {

	private Musica musica;
	private Integer musicaID;
	private Integer categoriaID;
	private Integer gravadoraID;

	public MusicaBean() {
		musica = new Musica();
	}

	public Integer getCategoriaMusicaID() {
		return categoriaID;
	}

	public void setCategoriaMusicaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}

	public Integer getGravadoraID() {
		return gravadoraID;
	}

	public void setGravadoraID(Integer gravadoraID) {
		this.gravadoraID = gravadoraID;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setmusica(Musica musica) {
		this.musica = musica;
	}

	public Integer getMusicaID() {
		return musicaID;
	}

	public void setMusicaID(Integer musicaID) {
		this.musicaID = musicaID;
	}

	public List<Musica> getMusicas() {
		return new DAO<Musica>(Musica.class).listaTodos();
	}

	public void validaDataNascimento(FacesContext context,
			UIComponent component, Object value) {

		Date dataInicio = (Date) value;

		Date hoje = (Date) Calendar.getInstance().getTime();
		if (hoje.after(dataInicio)) {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(dataInicio.getTime());
			c.add(Calendar.DAY_OF_YEAR, 1);
			this.musica.setDataCadastro(c);
		} else {
			throw new ValidatorException(new FacesMessage(
					"Data de cadastro eh maior ou igual a hoje"));
		}
	}

	public List<Musica> getMusicasUsuario() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", doador.getId());
		return new DAO<Musica>(Musica.class).findListResults(Musica.findAllMusicasDono, params);
	}
	
	public List<Musica> getMusicasUsuario(Usuario u) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", u.getId());
		return new DAO<Musica>(Musica.class).findListResults(Musica.findAllMusicasDono, params);
	}

	public void gravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		CategoriaMusica cat = new DAO<CategoriaMusica>(CategoriaMusica.class).buscaPorId(categoriaID);
		Gravadora ed = new DAO<Gravadora>(Gravadora.class).buscaPorId(gravadoraID);
		this.musica.setDono(doador);
		this.musica.setGravadora(ed);
		this.musica.setCategoriaMusica(cat);
		System.out.println("adicionando o musica" + this.musica.getNome()
				+ "do vendedor" + this.musica.getDono().getNome());
		new DAO<Musica>(Musica.class).adiciona(musica);
		JSFMessageUtil.sendInfoMessageToUser(this.musica.getNome()
				+ " adicionado com sucesso!!!");

	}

}
