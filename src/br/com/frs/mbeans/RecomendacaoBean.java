package br.com.frs.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.EmailException;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Filme;
import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Livro;
import br.com.frs.modelo.Musica;
import br.com.frs.modelo.Recomendacao;
import br.com.frs.modelo.Usuario;
import br.com.frs.modelo.enumerator.InteresseStatus;
import br.com.frs.modelo.enumerator.RecomendacaoStatus;
import br.com.frs.util.CalendarUtil;
import br.com.frs.util.JSFMessageUtil;
import br.com.frs.util.LoginUtil;
import br.com.frs.util.MailUtil;

@ManagedBean
@RequestScoped
public class RecomendacaoBean {

	private Recomendacao recomendacao;
	private Integer interesseID;
	private Integer livroID;
	private Integer filmeID;
	private Integer musicaID;

	public RecomendacaoBean() {
		recomendacao = new Recomendacao();
	}

	public Recomendacao getRecomendacao() {
		return recomendacao;
	}

	public void setRecomendacao(Recomendacao recomendacao) {
		this.recomendacao = recomendacao;
	}

	public Integer getInteresseID() {
		return interesseID;
	}

	public void setInteresseID(Integer interesseID) {
		this.interesseID = interesseID;
	}

	public List<Recomendacao> getRecomendacoes() {
		return new DAO<Recomendacao>(Recomendacao.class).listaTodos();
	}

	public List<Recomendacao> getRecomendacoesAtivas() {
		return new DAO<Recomendacao>(Recomendacao.class)
				.findListResults(Recomendacao.findAllRecomendacaoesAtivas);
	}

	public List<Recomendacao> getRecomendacoesInativas() {
		return new DAO<Recomendacao>(Recomendacao.class)
				.findListResults(Recomendacao.findAllRecomendacaoesInativas);
	}

	public List<Recomendacao> getRecomendacoesConfirmadas() {
		return new DAO<Recomendacao>(Recomendacao.class)
				.findListResults(Recomendacao.findAllRecomendacaoesConfirmadas);
	}

	public List<Recomendacao> getRecomendacoesUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> aux = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> auxNovo = new ArrayList<Recomendacao>();
		for (Recomendacao r : aux) {
			if (r.getInteresse().getUsuario().equals(u)) {
				auxNovo.add(r);
			}
		}
		System.out.println("Entreeeeeeeeeeeeei: " + auxNovo.size());
		return auxNovo;
	}

	public List<Recomendacao> getRecomendacoesCompradorVendedor() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		// LivroBean livroBean = new LivroBean();
		// List<Livro> livrosVendedor = livroBean.getLivrosUsuario(u);

		ArrayList<Recomendacao> todasRec = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> recVendedor = new ArrayList<Recomendacao>();
		for (Recomendacao r : todasRec) {
			if ((r.getLivro() != null ? r.getLivro().getDono()
					: r.getFilme() != null ? r.getFilme().getDono() : r
							.getMusica().getDono()).equals(u)
					&& (r.getStatus() != RecomendacaoStatus.EXECUTADA)) {
				recVendedor.add(r);
			}
		}

		return recVendedor;
	}

	public List<Recomendacao> getRecomendacoesVendedorExecutadas() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> todasRec = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> recVendedor = new ArrayList<Recomendacao>();
		for (Recomendacao r : todasRec) {
			if ((r.getLivro() != null ? r.getLivro().getDono()
					: r.getFilme() != null ? r.getFilme().getDono() : r
							.getMusica().getDono()).equals(u)
					&& r.getStatus().equals(RecomendacaoStatus.EXECUTADA)) {
				recVendedor.add(r);
			}
		}

		return recVendedor;
	}

	public List<Recomendacao> getRecomendacoesConfirmadasUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> aux = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> auxNovo = new ArrayList<Recomendacao>();
		for (Recomendacao r : aux) {
			if (r.getInteresse().getUsuario().equals(u)) {
				if (r.getStatus() == RecomendacaoStatus.CONFIRMADA) {
					auxNovo.add(r);
				}
			}
		}
		System.out.println("Entreeeeeeeeeeeeei: " + auxNovo.size());
		return auxNovo;
	}

	public List<Recomendacao> getRecomendacoesInativasUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		ArrayList<Recomendacao> aux = (ArrayList<Recomendacao>) new DAO<Recomendacao>(
				Recomendacao.class).listaTodos();
		ArrayList<Recomendacao> auxNovo = new ArrayList<Recomendacao>();
		for (Recomendacao r : aux) {
			if (r.getInteresse().getUsuario().equals(u)) {
				if (r.getStatus() == RecomendacaoStatus.INATIVA) {
					auxNovo.add(r);
				}
			}
		}
		System.out.println("Entreeeeeeeeeeeeei: " + auxNovo.size());
		return auxNovo;
	}

	public void gravar(Recomendacao rec) {
		new DAO<Recomendacao>(Recomendacao.class).adiciona(rec);

	}

	public void tornarConfirmada() {
		this.recomendacao.setStatus(RecomendacaoStatus.CONFIRMADA);
		try {
			MailUtil.enviaEmailAvisoAoDono(this.recomendacao);
		} catch (EmailException e) {
			System.out.println("Erro no envio de email ao dono do livro");
			e.printStackTrace();
		}
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil
				.sendInfoMessageToUser("Recomendacao ao livro "
						+ (this.recomendacao.getLivro() != null ? this.recomendacao
								.getLivro().getNome() : this.recomendacao
								.getFilme() != null ? this.recomendacao
								.getFilme().getNome() : this.recomendacao
								.getMusica().getNome())
						+ " alterado para Confirmada!");
	}

	public void tornarInativa() {
		this.recomendacao.setStatus(RecomendacaoStatus.INATIVA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil
				.sendInfoMessageToUser("Recomendacao ao livro "
						+ (this.recomendacao.getLivro() != null ? this.recomendacao
								.getLivro().getNome() : this.recomendacao
								.getFilme() != null ? this.recomendacao
								.getFilme().getNome() : this.recomendacao
								.getMusica().getNome())
						+ " alterado para Inativa!");
	}

	public void tornarAtiva() {
		this.recomendacao.setStatus(RecomendacaoStatus.ATIVA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil
				.sendInfoMessageToUser("Recomendacao ao livro "
						+ (this.recomendacao.getLivro() != null ? this.recomendacao
								.getLivro().getNome() : this.recomendacao
								.getFilme() != null ? this.recomendacao
								.getFilme().getNome() : this.recomendacao
								.getMusica().getNome())
						+ " alterado para Ativada!");
	}

	public void excluir() {
		new DAO<Recomendacao>(Recomendacao.class).remove(this.recomendacao);
		JSFMessageUtil
				.sendInfoMessageToUser("Recomendacao ao livro "
						+ (this.recomendacao.getLivro() != null ? this.recomendacao
								.getLivro().getNome() : this.recomendacao
								.getFilme() != null ? this.recomendacao
								.getFilme().getNome() : this.recomendacao
								.getMusica().getNome())
						+ " excluido com sucesso!");
	}

	public void executarConfirmacao() {
		this.recomendacao.setStatus(RecomendacaoStatus.EXECUTADA);
		try {
			MailUtil.enviaEmailExecucao(this.recomendacao);
		} catch (EmailException e) {
			System.out.println("Erro no envio de email de execu��o!!!!");
			e.printStackTrace();
		}
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil
				.sendInfoMessageToUser("Recomendacao ao livro "
						+ (this.recomendacao.getLivro() != null ? this.recomendacao
								.getLivro().getNome() : this.recomendacao
								.getFilme() != null ? this.recomendacao
								.getFilme().getNome() : this.recomendacao
								.getMusica().getNome())
						+ " Executada... Email enviado para ambos!!!!");
	}

	public void desfazerConfirmacao() {
		this.recomendacao.setStatus(RecomendacaoStatus.ATIVA);
		new DAO<Recomendacao>(Recomendacao.class).atualiza(this.recomendacao);
		JSFMessageUtil
				.sendInfoMessageToUser("Recomendacao ao livro "
						+ (this.recomendacao.getLivro() != null ? this.recomendacao
								.getLivro().getNome() : this.recomendacao
								.getFilme() != null ? this.recomendacao
								.getFilme().getNome() : this.recomendacao
								.getMusica().getNome()) + " Desfeita!!!!");
	}

	public void recomendaUsuario(Usuario u) {
		InteresseBean ib = new InteresseBean();
		LivroBean cb = new LivroBean();
		FilmeBean fb = new FilmeBean();
		MusicaBean mb = new MusicaBean();
		ArrayList<Interesse> intUser = new ArrayList<Interesse>();
		ArrayList<Interesse> allInt = (ArrayList<Interesse>) ib
				.getInteressesAtivos();
		ArrayList<Livro> livros = (ArrayList<Livro>) cb.getLivros();
		ArrayList<Filme> filmes = (ArrayList<Filme>) fb.getFilmes();
		ArrayList<Musica> musicas = (ArrayList<Musica>) mb.getMusicas();

		for (Interesse i : allInt) {
			if (i.getUsuario().equals(u)) {
				intUser.add(i);
			}
		}

		for (Livro c : livros) {
			for (Interesse i : intUser) {
				if ((c.getCategoria()).equals(i.getCategoriaDeInteresse()
						.getCategoria())) {
					Recomendacao rec = new Recomendacao();
					i.setStatus(InteresseStatus.ATENDIDO);
					new DAO<Interesse>(Interesse.class).atualiza(i);
					rec.setStatus(RecomendacaoStatus.ATIVA);
					rec.setLivro(c);
					rec.setInteresse(i);
					rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
					gravar(rec);
				}
			}
		}

		for (Filme c : filmes) {
			for (Interesse i : intUser) {
				if ((c.getCategoriaFilme()).equals(i
						.getCategoriaFilmeDeInteresse().getCategoria())) {
					Recomendacao rec = new Recomendacao();
					i.setStatus(InteresseStatus.ATENDIDO);
					new DAO<Interesse>(Interesse.class).atualiza(i);
					rec.setStatus(RecomendacaoStatus.ATIVA);
					rec.setFilme(c);
					rec.setInteresse(i);
					rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
					gravar(rec);
				}
			}
		}

		for (Musica c : musicas) {
			for (Interesse i : intUser) {
				if ((c.getCategoriaMusica()).equals(i
						.getCategoriaMusicaDeInteresse().getCategoria())) {
					Recomendacao rec = new Recomendacao();
					i.setStatus(InteresseStatus.ATENDIDO);
					new DAO<Interesse>(Interesse.class).atualiza(i);
					rec.setStatus(RecomendacaoStatus.ATIVA);
					rec.setMusica(c);
					rec.setInteresse(i);
					rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
					gravar(rec);
				}
			}
		}

	}

	public void recomendaInteresse(Interesse i) {
		if (i.getCategoriaDeInteresse() != null) {
			LivroBean cb = new LivroBean();
			ArrayList<Livro> livros = (ArrayList<Livro>) cb.getLivros();
			ArrayList<Livro> livrosRec = new ArrayList<Livro>();

			for (Livro l : livros) {
				if (l.getCategoria().getId() == i.getCategoriaDeInteresse()
						.getId()) {
					livrosRec.add(l);
				}
			}

			for (Livro l : livrosRec) {
				Recomendacao rec = new Recomendacao();
				rec.setLivro(l);
				rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
				rec.setInteresse(i);
				i.setStatus(InteresseStatus.ATENDIDO);
				new DAO<Interesse>(Interesse.class).atualiza(i);
				rec.setStatus(RecomendacaoStatus.ATIVA);
				gravar(rec);
				try {
					MailUtil.enviaEmailRecomendacao(rec);
				} catch (EmailException e) {
					System.out.println("Deu erro no envio da Recomendacao!!!!");
					e.printStackTrace();
				}
				rec = null;

			}
		} else if (i.getCategoriaFilmeDeInteresse() != null) {

			FilmeBean fb = new FilmeBean();
			ArrayList<Filme> filmes = (ArrayList<Filme>) fb.getFilmes();
			ArrayList<Filme> filmesRec = new ArrayList<Filme>();

			for (Filme l : filmes) {
				if (l.getCategoriaFilme().getId() == i
						.getCategoriaFilmeDeInteresse().getId()) {
					filmesRec.add(l);
				}
			}

			for (Filme l : filmesRec) {
				Recomendacao rec = new Recomendacao();
				rec.setFilme(l);
				rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
				rec.setInteresse(i);
				i.setStatus(InteresseStatus.ATENDIDO);
				new DAO<Interesse>(Interesse.class).atualiza(i);
				rec.setStatus(RecomendacaoStatus.ATIVA);
				gravar(rec);
				try {
					MailUtil.enviaEmailRecomendacao(rec);
				} catch (EmailException e) {
					System.out.println("Deu erro no envio da Recomendacao!!!!");
					e.printStackTrace();
				}
				rec = null;

			}
		} else if (i.getCategoriaMusicaDeInteresse() != null) {

			MusicaBean mb = new MusicaBean();
			ArrayList<Musica> musicas = (ArrayList<Musica>) mb.getMusicas();
			ArrayList<Musica> musicasRec = new ArrayList<Musica>();

			for (Musica l : musicas) {
				if (l.getCategoriaMusica().getId() == i
						.getCategoriaMusicaDeInteresse().getId()) {
					musicasRec.add(l);
				}
			}

			for (Musica l : musicasRec) {
				Recomendacao rec = new Recomendacao();
				rec.setMusica(l);
				rec.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
				rec.setInteresse(i);
				i.setStatus(InteresseStatus.ATENDIDO);
				new DAO<Interesse>(Interesse.class).atualiza(i);
				rec.setStatus(RecomendacaoStatus.ATIVA);
				gravar(rec);
				try {
					MailUtil.enviaEmailRecomendacao(rec);
				} catch (EmailException e) {
					System.out.println("Deu erro no envio da Recomendacao!!!!");
					e.printStackTrace();
				}
				rec = null;

			}
		}

	}

}