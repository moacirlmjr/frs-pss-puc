package br.com.frs.util;

import java.text.SimpleDateFormat;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.frs.modelo.Filme;
import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Livro;
import br.com.frs.modelo.Musica;
import br.com.frs.modelo.Recomendacao;
import br.com.frs.modelo.Usuario;

public class MailUtil {

	private static final String ACOOUNT_USER = "freerecommendationsystem";
	private static final String MAIL_USER = "freerecommendationsystem@gmail.com";
	private static final String MAIL_PWD = "freerspuc";
	private static final String MAIL_OWNER = "FRS - PUC";

	// Corrigido
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
			email.setMsg("Olá, "
					+ user.getNome()
					+ "\n"
					+ "Seja muito bem vindo ao FRS!!!"
					+ "\n"
					+ "Será uma grande satisfação sugerir alguns de nossos livros."
					+ "\n"
					+ "A partir de agora cadastre seus interesses e verifique sua conta periodicamente."
					+ "\n"
					+ "Qualquer dúvida, sugestão ou reclamação, entre em contato conosco."
					+ "\n" + "Até Breve!");
			email.send();

		} catch (EmailException e) {

			System.out.println(e.getMessage());

		}
	}

	// Corrigido
	@SuppressWarnings("deprecation")
	public static void enviaEmailInteresse(Interesse interesse)
			throws EmailException {

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
			email.setSubject("Cadastro de Interesse" + " - "
					+ MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ user.getNome()
					+ "\n"
					+ "Informamos que seu interesse na categoria "
					+ (interesse.getCategoriaDeInteresse() != null ? interesse
							.getCategoriaDeInteresse().getCategoria()
							: interesse.getCategoriaFilmeDeInteresse() != null ? interesse
									.getCategoriaFilmeDeInteresse()
									.getCategoria() : interesse
									.getCategoriaMusicaDeInteresse()
									.getCategoria())
					+ " foi cadastrado com sucesso em nossa base de dados!"
					+ "\n"
					+ "Em breve estaremos enviando algumas sugestões com base na sua preferência."
					+ "\n"
					+ "Qualquer dúvida, sugestão ou reclamação, entre em contato conosco."
					+ "\n" + "Até Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	// corrigido
	@SuppressWarnings("deprecation")
	public static void enviaEmailusuarioSemInteresse(Usuario u)
			throws EmailException {

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
			email.setSubject("Não Vimos nenhum Interesse" + " - "
					+ MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ u.getNome()
					+ "\n"
					+ "Verificamos que seu cadastro foi realizado com sucesso!!!"
					+ "\n"
					+ "Contudo até agora não verificamos nenhum cadastro de interesse!!!"
					+ "\n"
					+ "Qualquer dúvida, sugestão ou reclamação, entre em contato conosco."
					+ "\n" + "Até Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	// corrigido
	@SuppressWarnings("deprecation")
	public static void enviaEmailRecomendacao(Recomendacao rec)
			throws EmailException {

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
			email.setSubject("Recomendação " + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ user.getNome()
					+ "\n"
					+ "Temos uma recomendação que pode ser do seu interesse! "
					+ "\n"
					+ "Categoria: "
					+ (rec.getInteresse().getCategoriaDeInteresse() != null ? rec
							.getInteresse().getCategoriaDeInteresse()
							.getCategoria()
							: rec.getInteresse().getCategoriaFilmeDeInteresse() != null ? rec
									.getInteresse()
									.getCategoriaFilmeDeInteresse()
									.getCategoria()
									: rec.getInteresse()
											.getCategoriaMusicaDeInteresse()
											.getCategoria())
					+ "\n"
					+ (rec.getLivro() != null ? "Livro: "
							+ rec.getLivro().getNome()
							: rec.getFilme() != null ? "Filme: "
									+ rec.getFilme().getNome() : "Musica: "
									+ rec.getMusica().getNome())
					+ "\n"
					+ "\n"
					+ "Abaixo segue os dados do dono do Livro: "
					+ "\n"
					+ "Nome: "
					+ (rec.getLivro() != null ? rec.getLivro().getDono()
							.getNome() : rec.getFilme() != null ? rec
							.getFilme().getDono().getNome() : rec.getMusica()
							.getDono().getNome())
					+ "\n"
					+ "Telefone: "
					+ (rec.getLivro() != null ? rec.getLivro().getDono()
							.getTelefone() : rec.getFilme() != null ? rec
							.getFilme().getDono().getTelefone() : rec
							.getMusica().getDono().getTelefone())
					+ "\n"
					+ "Email: "
					+ (rec.getLivro() != null ? rec.getLivro().getDono()
							.getEmail() : rec.getFilme() != null ? rec
							.getFilme().getDono().getEmail() : rec.getMusica()
							.getDono().getEmail())
					+ "\n \n"
					+ "Gostou da Recomendação?"
					+ "\n"
					+ "Entre em contato com o dono para os acertos finais!!!"
					+ "\n"
					+ "Qualquer dúvida, sugestão ou reclamação, entre em contato conosco."
					+ "\n" + "Até Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static void enviaEmailRecomendacaoVendedorParaComprador(
			Interesse in, Livro liv) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = in.getUsuario();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail());
			email.setFrom(MailUtil.MAIL_USER);
			email.setSubject("Recomendação de livro" + " - "
					+ MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ user.getNome()
					+ "\n"
					+ "Eu possuo um livro que pode ser do seu interesse! "
					+ "\n"
					+ "Livro: "
					+ liv.getNome()
					+ "\n"
					+ "Categoria: "
					+ liv.getCategoria().getCategoria()
					+ "\n"
					+ "Editora: "
					+ liv.getEditora().getNome()
					+ "\n"
					+ "Observacao: "
					+ liv.getObservacao()
					+ "\n"
					+ "Abaixo segue os meus dados: "
					+ "\n"
					+ "Nome: "
					+ liv.getDono().getNome()
					+ "\n"
					+ "Telefone: "
					+ liv.getDono().getTelefone()
					+ "\n"
					+ "Email: "
					+ liv.getDono().getEmail()
					+ "\n \n"
					+ "Gostou do Livro? entre em comigo para os acertos finais!!!"
					+ "\n" + "Qualquer dúvida, retorne o email!" + "\n"
					+ "Aguardo retorno!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static void enviaEmailRecomendacaoVendedorParaCompradorFilme(
			Interesse in, Filme liv) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = in.getUsuario();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail());
			email.setFrom(MailUtil.MAIL_USER);
			email.setSubject("Recomendação de Filme" + " - "
					+ MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ user.getNome()
					+ "\n"
					+ "Eu possuo um Filme que pode ser do seu interesse! "
					+ "\n"
					+ "Filme: "
					+ liv.getNome()
					+ "\n"
					+ "Categoria: "
					+ liv.getCategoriaFilme().getCategoria()
					+ "\n"
					+ "Estudio: "
					+ liv.getEstudio().getNome()
					+ "\n"
					+ "Observacao: "
					+ liv.getObservacao()
					+ "\n"
					+ "Abaixo segue os meus dados: "
					+ "\n"
					+ "Nome: "
					+ liv.getDono().getNome()
					+ "\n"
					+ "Telefone: "
					+ liv.getDono().getTelefone()
					+ "\n"
					+ "Email: "
					+ liv.getDono().getEmail()
					+ "\n \n"
					+ "Gostou do Filme? entre em comigo para os acertos finais!!!"
					+ "\n" + "Qualquer dúvida, retorne o email!" + "\n"
					+ "Aguardo retorno!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static void enviaEmailRecomendacaoVendedorParaCompradorMusica(
			Interesse in, Musica liv) throws EmailException {

		SimpleEmail email = new SimpleEmail();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Usuario user = in.getUsuario();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(user.getEmail());
			email.setFrom(MailUtil.MAIL_USER);
			email.setSubject("Recomendação de Música" + " - "
					+ MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ user.getNome()
					+ "\n"
					+ "Eu possuo uma Música que pode ser do seu interesse! "
					+ "\n"
					+ "Música: "
					+ liv.getNome()
					+ "\n"
					+ "Categoria: "
					+ liv.getCategoriaMusica().getCategoria()
					+ "\n"
					+ "Estudio: "
					+ liv.getGravadora().getNome()
					+ "\n"
					+ "Observacao: "
					+ liv.getObservacao()
					+ "\n"
					+ "Abaixo segue os meus dados: "
					+ "\n"
					+ "Nome: "
					+ liv.getDono().getNome()
					+ "\n"
					+ "Telefone: "
					+ liv.getDono().getTelefone()
					+ "\n"
					+ "Email: "
					+ liv.getDono().getEmail()
					+ "\n \n"
					+ "Gostou da Música? entre em comigo para os acertos finais!!!"
					+ "\n" + "Qualquer dúvida, retorne o email!" + "\n"
					+ "Aguardo retorno!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static void enviaEmailAvisoAoDono(Recomendacao rec)
			throws EmailException {

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
			email.setSubject("Interesse em Livro" + " - " + MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ user.getNome()
					+ "\n"
					+ "Estou interesado em seu Livro: "
					+ "\n"
					+ "Nome: "
					+ (rec.getLivro() != null ? rec.getLivro().getNome() : rec
							.getFilme() != null ? rec.getFilme().getNome()
							: rec.getMusica().getNome())
					+ "\n"
					+ "Categoria: "
					+ (rec.getLivro() != null ? rec.getLivro().getCategoria()
							.getCategoria() : rec.getFilme() != null ? rec
							.getFilme().getCategoriaFilme().getCategoria()
							: rec.getMusica().getCategoriaMusica()
									.getCategoria()) + "\n" + "\n"
					+ "Abaixo segue meus dados para contato: " + "\n"
					+ "Nome: " + rec.getInteresse().getUsuario().getNome()
					+ "\n" + "Telefone: "
					+ rec.getInteresse().getUsuario().getTelefone() + "\n"
					+ "Email: " + rec.getInteresse().getUsuario().getEmail()
					+ "\n \n" + "Entre em contato comigo assim que possível!!!"
					+ "\n" + "Muito grato pela atenção." + "\n" + "Até Breve!");
			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void enviaEmailExecucao(Recomendacao rec)
			throws EmailException {
		MailUtil.enviaEmailExecucaoComprador(rec);
		MailUtil.enviaEmailExecucaoVendedor(rec);
	}

	private static void enviaEmailExecucaoVendedor(Recomendacao rec) {

		SimpleEmail email = new SimpleEmail();
		Usuario usuarioComprador = (rec.getLivro() != null ? rec.getLivro().getDono()
				: rec.getFilme() != null ? rec.getFilme().getDono() : rec
						.getMusica().getDono());
		Usuario usuarioVendedor = rec.getInteresse().getUsuario();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(usuarioComprador.getEmail());
			email.setFrom(MailUtil.MAIL_USER);
			email.setSubject("Recomendação Executada" + " - "
					+ MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ usuarioComprador.getNome()
					+ "\n"
					+ "Fechamos Negocio no Livro: "
					+ "\n"
					+ "Nome: "
					+ (rec.getLivro() != null ? rec.getLivro().getNome() : rec
							.getFilme() != null ? rec.getFilme().getNome()
							: rec.getMusica().getNome())
					+ "\n"
					+ "Categoria: "
					+ (rec.getLivro() != null ? rec.getLivro().getCategoria()
							.getCategoria() : rec.getFilme() != null ? rec
							.getFilme().getCategoriaFilme().getCategoria()
							: rec.getMusica().getCategoriaMusica()
									.getCategoria()) + "\n" + "\n"
					+ "Abaixo segue meus dados para contato: " + "\n"
					+ "Nome: " + usuarioVendedor.getNome() + "\n"
					+ "Telefone: " + usuarioVendedor.getTelefone() + "\n"
					+ "Email: " + usuarioVendedor.getEmail() + "\n \n"
					+ "Vamos fazer os acertos do pagamento!!!" + "\n"
					+ "Muito grato pela atenção." + "\n" + "Até Breve!");

			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void enviaEmailExecucaoComprador(Recomendacao rec) {

		SimpleEmail email = new SimpleEmail();
		Usuario usuarioComprador = (rec.getLivro() != null ? rec.getLivro()
				.getDono() : rec.getFilme() != null ? rec.getFilme().getDono()
				: rec.getMusica().getDono());
		Usuario usuarioVendedor = rec.getInteresse().getUsuario();

		try {
			@SuppressWarnings("unused")
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication(MailUtil.ACOOUNT_USER, MailUtil.MAIL_PWD);
			email.setSSL(true);
			email.addTo(usuarioVendedor.getEmail());
			email.setFrom(MailUtil.MAIL_USER);
			email.setSubject("Recomendação Executada" + " - "
					+ MailUtil.MAIL_OWNER);
			email.setMsg("Olá,  "
					+ usuarioVendedor.getNome()
					+ "\n"
					+ "Fechamos Negocio no Livro: "
					+ "\n"
					+ "Nome: "
					+ (rec.getLivro() != null ? rec.getLivro().getNome() : rec
							.getFilme() != null ? rec.getFilme().getNome()
							: rec.getMusica().getNome())
					+ "\n"
					+ "Categoria: "
					+ (rec.getLivro() != null ? rec.getLivro().getCategoria()
							.getCategoria() : rec.getFilme() != null ? rec
							.getFilme().getCategoriaFilme().getCategoria()
							: rec.getMusica().getCategoriaMusica()
									.getCategoria())
					+ "\n"
					+ "\n"
					+ "Abaixo segue meus dados para contato: "
					+ "\n"
					+ "Nome: "
					+ usuarioVendedor.getNome()
					+ "\n"
					+ "Telefone: "
					+ usuarioVendedor.getTelefone()
					+ "\n"
					+ "Email: "
					+ usuarioVendedor.getEmail()
					+ "\n \n"
					+ "Vou retirar o livro do FRS assim que confirmar o PGTO!!!"
					+ "\n" + "Muito grato pela atenção." + "\n" + "Até Breve!");

			email.send();

		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}

	}

}