package br.com.frs.agents.strategies;

public class Contexto {

	private Estrategia estrategia;

	public Contexto(Estrategia estrategia) {
		this.estrategia = estrategia;
	}

	public void executeEstrategia() {
		estrategia.execute();
	}

}
