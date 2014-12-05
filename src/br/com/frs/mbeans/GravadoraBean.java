package br.com.frs.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Gravadora;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class GravadoraBean {
	
	private Gravadora gravadora;
	
	public GravadoraBean(){
		gravadora= new Gravadora();
	}

		
	public Gravadora getGravadora() {
		return gravadora;
	}


	public void setGravadora(Gravadora gravadora) {
		this.gravadora = gravadora;
	}


	public List<Gravadora> getGravadoras() {
		return new DAO<Gravadora>(Gravadora.class).listaTodos();
	}
	
	
	public void gravar() {
		System.out.println("Gravando Gravadora " + this.gravadora.getNome());
		new DAO<Gravadora>(Gravadora.class).adiciona(gravadora);
		JSFMessageUtil.sendInfoMessageToUser("Gravadora cadastrado com sucesso!!!");
	}	

}




