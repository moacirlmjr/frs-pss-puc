package br.com.frs.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Estudio;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class EstudioBean {
	
	private Estudio estudio;
	
	public EstudioBean(){
		estudio= new Estudio();
	}

		
	public Estudio getEstudio() {
		return estudio;
	}


	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}


	public List<Estudio> getEstudios() {
		return new DAO<Estudio>(Estudio.class).listaTodos();
	}
	
	
	public void gravar() {
		System.out.println("Gravando Estudio " + this.estudio.getNome());
		new DAO<Estudio>(Estudio.class).adiciona(estudio);
		JSFMessageUtil.sendInfoMessageToUser("Estudio cadastrado com sucesso!!!");
	}	

}




