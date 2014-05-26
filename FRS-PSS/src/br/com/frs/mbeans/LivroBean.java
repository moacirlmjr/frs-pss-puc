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
import br.com.frs.modelo.Livro;
import br.com.frs.modelo.Usuario;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class LivroBean {

	private Livro livro;
	private Integer livroID;

	public LivroBean() {
		livro = new Livro();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setlivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getLivroID() {
		return livroID;
	}

	public void setLivroID(Integer racaID) {
		this.livroID = racaID;
	}

	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}

	
	public void validaDataNascimento(FacesContext context, UIComponent component,
			Object value) {

		Date dataInicio = (Date) value;

		Date hoje = (Date) Calendar.getInstance().getTime();
		if (hoje.after(dataInicio)) {
			Calendar c = Calendar.getInstance();
			c.setTimeInMillis(dataInicio.getTime());
			c.add(Calendar.DAY_OF_YEAR, 1);
			this.livro.setDataCadastro(c);
		} else {
			throw new ValidatorException(new FacesMessage(
					"Data de cadastro eh maior ou igual a hoje"));
		}
	}

	public List<Livro> getLivrosUsuario() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", doador.getId());
		return new DAO<Livro>(Livro.class).findListResults(Livro.findAllLivrosDono, params);
	}

	public void gravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		Usuario doador = (Usuario) request.getSession().getAttribute("usuario");
		//Categoria r = new DAO<Raca>(Raca.class).buscaPorId(racaID);
		this.livro.setDono(doador);
		//this.livro.setRaca(r);
		System.out.println("adicionando o cachorro" + this.livro.getNome()
				+ "do doador" + this.livro.getDono().getNome());
		new DAO<Livro>(Livro.class).adiciona(livro);
		JSFMessageUtil.sendInfoMessageToUser(this.livro.getNome() + " adicionado com sucesso!!!");

	}

}
