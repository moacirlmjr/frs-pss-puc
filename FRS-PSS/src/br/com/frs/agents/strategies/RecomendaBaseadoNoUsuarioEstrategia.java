package br.com.frs.agents.strategies;

import br.com.frs.mbeans.InteresseBean;
import br.com.frs.mbeans.RecomendacaoBean;
import br.com.frs.mbeans.UsuarioBean;
import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Usuario;
import br.com.frs.util.AgentComunicator;

public class RecomendaBaseadoNoUsuarioEstrategia implements Estrategia {

	@Override
	public void execute() {
		System.out.println("Recomenda Baseado no usuario");
		UsuarioBean ub = new UsuarioBean();
		InteresseBean ib = new InteresseBean();
		AgentComunicator.setListaDeInteresseSR(ib.getInteressesAtivos());
		AgentComunicator.setListaUsuarioSI(ub.getUsuariosSemRecomendacao());
		RecomendacaoBean rb = new RecomendacaoBean();
		for (Usuario u : AgentComunicator.getListaUsuarioSI()) {

			for (Interesse i : AgentComunicator.getListaDeInteresseSR()) {
				if(i.getUsuario().equals(u)){
				rb.recomendaInteresse(i);
				System.out.println("Recomendando Baseado no Usuario para "
						+ i.getUsuario().getNome());
				}
			}
		}

	}
}
