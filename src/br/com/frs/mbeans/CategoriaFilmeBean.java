package br.com.frs.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.CategoriaFilme;
import br.com.frs.modelo.CategoriaFilmeDataModel;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class CategoriaFilmeBean {

	private CategoriaFilme categoriaFilme;
	private CategoriaFilmeDataModel cdm;
	private List<CategoriaFilme> categorias;

	public CategoriaFilmeBean() {
		categorias = new DAO<CategoriaFilme>(CategoriaFilme.class).listaTodos();
		categoriaFilme = new CategoriaFilme();
		cdm = new CategoriaFilmeDataModel((ArrayList<CategoriaFilme>) getCategorias());
	}

	
	public List<CategoriaFilme> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<CategoriaFilme> categorias) {
		this.categorias = categorias;
	}


	public CategoriaFilmeDataModel getCdm() {
		return cdm;
	}

	public void setCdm(CategoriaFilmeDataModel cdm) {
		this.cdm = cdm;
	}

	public CategoriaFilme getCategoriaFilme() {
		return categoriaFilme;
	}

	public void setCategoriaFilme(CategoriaFilme categoriaFilme) {
		this.categoriaFilme = categoriaFilme;
	}

	public void gravar() {
		System.out.println("Gravando CategoriaFilme " + this.categoriaFilme.getCategoria());
		new DAO<CategoriaFilme>(CategoriaFilme.class).adiciona(this.categoriaFilme);
		JSFMessageUtil.sendInfoMessageToUser("CategoriaFilme cadastrado com sucesso!!!");
	}

}
