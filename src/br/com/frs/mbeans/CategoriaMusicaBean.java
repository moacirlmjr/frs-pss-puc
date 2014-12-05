package br.com.frs.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.CategoriaMusica;
import br.com.frs.modelo.CategoriaMusicaDataModel;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class CategoriaMusicaBean {

	private CategoriaMusica categoria;
	private CategoriaMusicaDataModel cdm;
	private List<CategoriaMusica> categorias;

	public CategoriaMusicaBean() {
		categorias = new DAO<CategoriaMusica>(CategoriaMusica.class).listaTodos();
		categoria = new CategoriaMusica();
		cdm = new CategoriaMusicaDataModel((ArrayList<CategoriaMusica>) getCategorias());
	}

	
	public List<CategoriaMusica> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<CategoriaMusica> categorias) {
		this.categorias = categorias;
	}


	public CategoriaMusicaDataModel getCdm() {
		return cdm;
	}

	public void setCdm(CategoriaMusicaDataModel cdm) {
		this.cdm = cdm;
	}

	public CategoriaMusica getCategoriaMusica() {
		return categoria;
	}

	public void setCategoriaMusica(CategoriaMusica categoria) {
		this.categoria = categoria;
	}

	public void gravar() {
		System.out.println("Gravando CategoriaMusica " + this.categoria.getCategoria());
		new DAO<CategoriaMusica>(CategoriaMusica.class).adiciona(this.categoria);
		JSFMessageUtil.sendInfoMessageToUser("CategoriaMusica cadastrado com sucesso!!!");
	}

}
