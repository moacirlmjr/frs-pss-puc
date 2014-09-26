package br.com.frs.util;

import java.util.List;

import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Usuario;

public class AgentComunicator {

	private static List<Interesse> listaDeInteresseSR;
	private static List<Usuario> listaUsuarioSI;

	public static List<Interesse> getListaDeInteresseSR() {
		return listaDeInteresseSR;
	}

	public static void setListaDeInteresseSR(List<Interesse> listaDeInteresseSR) {
		AgentComunicator.listaDeInteresseSR = listaDeInteresseSR;
	}

	public static List<Usuario> getListaUsuarioSI() {
		return listaUsuarioSI;
	}

	public static void setListaUsuarioSI(List<Usuario> listaUsuarioSI) {
		AgentComunicator.listaUsuarioSI = listaUsuarioSI;
	}

}
