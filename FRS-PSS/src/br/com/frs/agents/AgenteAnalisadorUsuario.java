package br.com.frs.agents;

import jade.core.Agent;


public class AgenteAnalisadorUsuario extends Agent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6776055151529992525L;
	private AgenteAnalisadorUsuarioBehavior aaub = new AgenteAnalisadorUsuarioBehavior(this, 5000);

	protected void setup(){
		
		super.setup();
		
		addBehaviour(aaub);
	}

}
