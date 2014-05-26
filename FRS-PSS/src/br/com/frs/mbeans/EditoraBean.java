package br.com.frs.mbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Editora;
import br.com.frs.util.JSFMessageUtil;

@ManagedBean
@RequestScoped
public class EditoraBean {
	
	private Editora editora;
	
	public EditoraBean(){
		editora= new Editora();
	}

		
	public List<Editora> getEditoras() {
		return new DAO<Editora>(Editora.class).listaTodos();
	}
	
	
	public void gravar() {
		System.out.println("Gravando Editora " + this.editora.getNome());
		new DAO<Editora>(Editora.class).adiciona(editora);
		JSFMessageUtil.sendInfoMessageToUser("Editora cadastrado com sucesso!!!");
	}	

}




