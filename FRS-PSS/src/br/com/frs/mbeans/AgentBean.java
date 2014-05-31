package br.com.frs.mbeans;

import br.com.frs.agents.IniciarAgentes;

public class AgentBean {
	

	public void iniciarAgentes(){
		System.out.println("Iniciando os Agentes");		
		IniciarAgentes.init();
		System.out.println("Agentes Criados");		
	}
	
	

}
