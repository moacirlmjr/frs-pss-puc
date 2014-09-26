package br.com.frs.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.frs.agents.IniciarAgentes;

@ManagedBean
@RequestScoped
public class AgentBean {
	
	
	public void iniciarAgentesRBI(){
		System.out.println("Iniciando os Agentes");		
		IniciarAgentes.initAgentInteresse();
		System.out.println("Agentes Criados");		
	}
	
	public void iniciarAgentesRBU(){
		System.out.println("Iniciando os Agentes");		
		IniciarAgentes.initAgentUsuario();
		System.out.println("Agentes Criados");		
	}
	
	public void iniciarAgentesRUSI(){
		System.out.println("Iniciando os Agentes de EMAIL");		
		IniciarAgentes.initAgentUsuarioSI();
		System.out.println("Agentes Criados");		
	}
	
}