package br.com.frs.agents.strategies;

import java.util.ArrayList;

import org.apache.commons.mail.EmailException;

import br.com.frs.mbeans.UsuarioBean;
import br.com.frs.modelo.Usuario;
import br.com.frs.util.MailUtil;

public class RecomendaVendedorBaseadoNaCategoriaEstrategia implements Estrategia {

	@Override
	public void execute() {

		System.out
				.println("Enviando Email para usuários sem interesse cadastrado");
		UsuarioBean ub = new UsuarioBean();
		ArrayList<Usuario> usuariosSI = (ArrayList<Usuario>) ub
				.getUsuariosSemInteresse();

		for (Usuario u : usuariosSI) {
			try {
				MailUtil.enviaEmailusuarioSemInteresse(u);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
