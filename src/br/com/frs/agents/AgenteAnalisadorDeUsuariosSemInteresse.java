package br.com.frs.agents;

import jade.core.Agent;

public class AgenteAnalisadorDeUsuariosSemInteresse extends Agent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6776055151529992525L;
	private AgenteAnalisadorDeUsuariosSemInteresseBehavior aem = new AgenteAnalisadorDeUsuariosSemInteresseBehavior(
			this, 5000);

	protected void setup() {

		super.setup();

		addBehaviour(aem);
	}

}
