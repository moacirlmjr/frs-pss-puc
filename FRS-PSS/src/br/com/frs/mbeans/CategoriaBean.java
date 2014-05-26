package br.com.frs.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Categoria;
import br.com.frs.modelo.CategoriaDataModel;
import br.com.frs.modelo.Editora;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class CategoriaBean {

	private Categoria cat;
	private CategoriaDataModel cdm;

	public CategoriaBean() {
		cat = new Categoria();
		cdm = new CategoriaDataModel((ArrayList<Categoria>) getCategorias());
	}

	private List<Categoria> getCategorias() {
		return new DAO<Categoria>(Categoria.class).listaTodos();

	}

	public List<Editora> getEditoras() {
		return new DAO<Editora>(Editora.class).listaTodos();
	}

	public CategoriaDataModel getCdm() {
		return cdm;
	}

	public void setCdm(CategoriaDataModel cdm) {
		this.cdm = cdm;
	}

	public void gravar() {
		System.out.println("Gravando Categoria " + this.cat.getCategoria());
		new DAO<Categoria>(Categoria.class).adiciona(cat);
		JSFMessageUtil
				.sendInfoMessageToUser("Categoria cadastrado com sucesso!!!");
	}

}
