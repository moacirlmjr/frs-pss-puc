package br.com.frs.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.frs.agents.IniciarAgentes;

@ManagedBean
@RequestScoped
public class AgentBean {
	
	
	public void iniciarAgentes(){
		System.out.println("Iniciando os Agentes");		
		IniciarAgentes.init();
		System.out.println("Agentes Criados");		
	}
	
	public void iniciarAgenteDeEmail(){
		System.out.println("Iniciando os Agentes de EMAIL");		
		IniciarAgentes.init2();
		System.out.println("Agentes Criados");		
	}
	
}