package br.com.frs.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Categoria;
import br.com.frs.modelo.CategoriaDataModel;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class CategoriaBean {

	private Categoria categoria;
	private CategoriaDataModel cdm;
	private List<Categoria> categorias;

	public CategoriaBean() {
		categorias = new DAO<Categoria>(Categoria.class).listaTodos();
		categoria = new Categoria();
		cdm = new CategoriaDataModel((ArrayList<Categoria>) getCategorias());
	}

	
	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public CategoriaDataModel getCdm() {
		return cdm;
	}

	public void setCdm(CategoriaDataModel cdm) {
		this.cdm = cdm;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void gravar() {
		System.out.println("Gravando Categoria " + this.categoria.getCategoria());
		new DAO<Categoria>(Categoria.class).adiciona(this.categoria);
		JSFMessageUtil.sendInfoMessageToUser("Categoria cadastrado com sucesso!!!");
	}

}
