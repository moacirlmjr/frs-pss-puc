package br.com.frs.util;

import java.text.SimpleDateFormat;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Recomendacao;
import br.com.frs.modelo.Usuario;



public class MailUtil {
	 
	/*private static final String ACOOUNT_USER = "frspuc";
	private static final String MAIL_USER = "frspuc@mail.com";
	private static final String MAIL_PWD = "pucfrs";
	private static final String MAIL_OWNER = "FRS";*/
	
	private static final String ACOOUNT_USER = "sharingdog";
    private static final String MAIL_USER = "sharingdog@gmail.com";
    private static final String MAIL_PWD = "pucsharingdog";
    private static final String MAIL_OWNER = "SharingDog";

	@SuppressWarnings("deprecation")
	public static void enviaEmailBoasVindas(Usuario user) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("Boas Vindas" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Olá, senhor "
					+ user.getNome()
					+ "\n"
					+ "Seja muito bem vindo ao FRS!!!"
					+ "\n" + 
					"Ser� uma grande satisfa��o sugerir alguns de nossos livros." 
					+ "\n" +
					"A partir de agora cadastre seus interesses e verifique sua conta periodicamente." 
					+ "\n" +
					"Qualquer d�vida, sugest�o ou reclama��o, entre em contato conosco."
					+ "\n" +
					"At� Breve!");
			email.send();

		} catch (EmailException e) {

			System.out.println(e.getMessage());

		}
	}
	
	
	@SuppressWarnings("deprecation")
	public static void enviaEmailInteresse(Interesse interesse) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = interesse.getUsuario();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("Cadastro de Interesse" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Ol�, senhor "
					+ user.getNome()
					+ "\n"
					+ "Informamos que seu iteresse na categoria " +  interesse.getCategoriaDeInteresse().getCategoria()
					+ " foi cadastrado com sucesso em nassa base de dados!"
					+ "\n" + 
					"Em breve estaremos enviando algumas sugest�es com base na sua prefer�ncia." 
					+ "\n" +
					"Qualquer d�vida, sugest�o ou reclama��o, entre em contato conosco."
					+ "\n" +
					"At� Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void enviaEmailusuarioSemInteresse(Usuario u) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(u.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("N�o Vimos nenhum Interesse" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Ol�, senhor "
					+ u.getNome()
					+ "\n"
					+ "Verificamos que seu cadastro foi realizado com sucesso!!!" 
					+ "\n" + 
					"Contudo at� agora n�o verificamos nenhum cadastro de interesse!!!" 
					+ "\n" +
					"Qualquer d�vida, sugest�o ou reclama��o, entre em contato conosco."
					+ "\n" +
					"At� Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}
	

	
	
	@SuppressWarnings("deprecation")
	public static void enviaEmailRecomendacao(Recomendacao rec) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = rec.getInteresse().getUsuario();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("Recomenda��o de livro" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Ol�, senhor "
					+ user.getNome()
					+ "\n"
					+ "Temos um livro que pode ser do seu interesse! " 
					+ "\n" + 
					"Categoria: " + rec.getInteresse().getCategoriaDeInteresse().getCategoria() 
					+ "\n" + 
					"Livro: " + rec.getLivro().getNome() 
					+ "\n" + 
					  "\n" + 		
					"Abaixo segue os dados do dono do Livro: "
					+ "\n" + 
					"Nome: " + rec.getLivro().getDono().getNome() 
					+ "\n" +
					"Telefone: " +  rec.getLivro().getDono().getTelefone() 
					+ "\n" +
					"Email: " +  rec.getLivro().getDono().getEmail()
					+ "\n \n" +
					"Gostou do Livro? entre em contato com o dono para os acertos finais!!!"
					+ "\n" +
					"Qualquer d�vida, sugest�o ou reclama��o, entre em contato conosco."
					+ "\n" +
					"At� Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public static void enviaEmailAvisoAoDono(Recomendacao rec) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = rec.getInteresse().getUsuario();
			email.setDebug(true);
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail()); 															
			email.setFrom(MailUtil.MAIL_USER); 
			email.setSubject("Recomenda��o de Livro" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Ol�, senhor "
					+ user.getNome()
					+ "\n"
					+ "Estou interesado em seu Livro: " 
					+ "\n" + 
					"Nome: " + rec.getLivro().getNome() 
					+ "\n" + 
					"Categoria: " + rec.getLivro().getCategoria() 
					+ "\n" + 
					
					  "\n" + 		
					"Abaixo segue meus dados para contato: "
					+ "\n" + 
					"Nome: " + rec.getInteresse().getUsuario().getNome() 
					+ "\n" +
					"Telefone: " + rec.getInteresse().getUsuario().getTelefone()  
					+ "\n" +
					"Email: " + rec.getInteresse().getUsuario().getEmail()
					+ "\n \n" +
					"Entre em contato comigo assim que poss�vel!!!"
					+ "\n" +
					"Muito grato pela aten��o."
					+ "\n" +
					"At� Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}



}