package br.com.frs.teste;

import java.util.ArrayList;

import br.com.frs.mbeans.InteresseBean;
import br.com.frs.mbeans.RecomendacaoBean;
import br.com.frs.modelo.Interesse;

public class TestaRec {
	
	public static void main(String[] args) {
		RecomendacaoBean rb = new RecomendacaoBean();
		InteresseBean ib = new InteresseBean();
		
		ArrayList<Interesse> interesses = (ArrayList<Interesse>) ib.getInteresses();
		
		for(Interesse i : interesses){
			if(i.getUsuario().getId() == 4){
				rb.recomendaInteresse(i);
			}
		}
	}

}
