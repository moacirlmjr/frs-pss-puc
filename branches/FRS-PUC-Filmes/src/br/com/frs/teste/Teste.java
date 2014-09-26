package br.com.frs.teste;

import org.apache.commons.mail.EmailException;

import br.com.frs.modelo.Usuario;
import br.com.frs.util.MailUtil;

public class Teste {
	
	public static void main(String[] args) {
		 Usuario u = new Usuario("Danyllo", "danyllo_wagner@hotmail.com", "33333333", "dd", "ddd");
		 try {
			MailUtil.enviaEmailBoasVindas(u);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
