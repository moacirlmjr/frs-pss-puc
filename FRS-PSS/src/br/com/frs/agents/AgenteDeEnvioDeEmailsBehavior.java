package br.com.frs.agents;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import br.com.frs.agents.strategies.Contexto;
import br.com.frs.agents.strategies.EnviaEmailUsuarioSemInteresseEstrategia;


public class AgenteDeEnvioDeEmailsBehavior extends OneShotBehaviour{

	
	private static final long serialVersionUID = 4468228483805851156L;
	


	public AgenteDeEnvioDeEmailsBehavior(Agent a, long period) {
		super(a);
	}


	@Override
	public void action() {
		 Contexto contexto = new Contexto(new EnviaEmailUsuarioSemInteresseEstrategia());
	     contexto.executeEstrategia();	
		
	}

}
