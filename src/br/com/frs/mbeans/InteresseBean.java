package br.com.frs.mbeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.EmailException;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Categoria;
import br.com.frs.modelo.CategoriaFilme;
import br.com.frs.modelo.CategoriaMusica;
import br.com.frs.modelo.Filme;
import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Livro;
import br.com.frs.modelo.Musica;
import br.com.frs.modelo.Usuario;
import br.com.frs.modelo.enumerator.InteresseStatus;
import br.com.frs.util.CalendarUtil;
import br.com.frs.util.JSFMessageUtil;
import br.com.frs.util.LoginUtil;
import br.com.frs.util.MailUtil;

@ManagedBean
@RequestScoped
public class InteresseBean {

	private Interesse interesse;
	private Categoria selectedCategoria;
	private CategoriaFilme selectedCategoriaFilme;
	private CategoriaMusica selectedCategoriaMusica;
	private Integer interesseID;

	public InteresseBean() {
		interesse = new Interesse();
	}

	public Integer getInteresseID() {
		return interesseID;
	}

	public void setInteresseID(Integer interesseID) {
		this.interesseID = interesseID;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public Categoria getSelectedCategoria() {
		return selectedCategoria;
	}

	public void setSelectedCategoria(Categoria selectedCategoria) {
		this.selectedCategoria = selectedCategoria;
	}

	public CategoriaFilme getSelectedCategoriaFilme() {
		return selectedCategoriaFilme;
	}

	public void setSelectedCategoriaFilme(CategoriaFilme selectedCategoriaFilme) {
		this.selectedCategoriaFilme = selectedCategoriaFilme;
	}

	public CategoriaMusica getSelectedCategoriaMusica() {
		return selectedCategoriaMusica;
	}

	public void setSelectedCategoriaMusica(
			CategoriaMusica selectedCategoriaMusica) {
		this.selectedCategoriaMusica = selectedCategoriaMusica;
	}

	public List<Interesse> getInteresses() {
		return new DAO<Interesse>(Interesse.class).listaTodos();
	}

	public List<Interesse> getInteressesAtivos() {
		return new DAO<Interesse>(Interesse.class)
				.findListResults(Interesse.findAllInteressesAtivos);
	}

	public List<Interesse> getInteressesAtendidos() {
		return new DAO<Interesse>(Interesse.class)
				.findListResults(Interesse.findAllInteressesAtendidos);
	}

	public List<Interesse> getInteressesInativos() {
		return new DAO<Interesse>(Interesse.class)
				.findListResults(Interesse.findAllInteressesAtivos);
	}

	public List<Interesse> getInteressesUsuario() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", u.getId());
		return new DAO<Interesse>(Interesse.class).findListResults(
				Interesse.findAllInteressesUser, params);

	}

	public List<Interesse> getInteressesVendedor() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		LivroBean lb = new LivroBean();
		FilmeBean fb = new FilmeBean();
		MusicaBean mb = new MusicaBean();
		List<Livro> livrosUsuario = lb.getLivrosUsuario(u);
		List<Filme> filmesUsuario = fb.getFilmesUsuario(u);
		List<Musica> musicasUsuario = mb.getMusicasUsuario(u);
		List<Interesse> todosInteresses = getInteresses();
		List<Interesse> interessesVendedor = new ArrayList<Interesse>();

		for (Interesse i : todosInteresses) {
			if (i.getCategoriaDeInteresse() != null) {
				for (Livro l : livrosUsuario) {
					if ((i.getCategoriaDeInteresse().getId() == l
							.getCategoria().getId())
							&& ((i.getStatus().equals(InteresseStatus.ATIVO) || (i
									.getStatus()
									.equals(InteresseStatus.EMAIL_VENDEDOR))))) {
						interessesVendedor.add(i);
					}
				}
			}

			if (i.getCategoriaFilmeDeInteresse() != null) {
				for (Filme l : filmesUsuario) {
					if ((i.getCategoriaFilmeDeInteresse().getId() == l
							.getCategoriaFilme().getId())
							&& ((i.getStatus().equals(InteresseStatus.ATIVO) || (i
									.getStatus()
									.equals(InteresseStatus.EMAIL_VENDEDOR))))) {
						interessesVendedor.add(i);
					}
				}
			}

			if (i.getCategoriaMusicaDeInteresse() != null) {
				for (Musica l : musicasUsuario) {
					if ((i.getCategoriaMusicaDeInteresse().getId() == l
							.getCategoriaMusica().getId())
							&& ((i.getStatus().equals(InteresseStatus.ATIVO) || (i
									.getStatus()
									.equals(InteresseStatus.EMAIL_VENDEDOR))))) {
						interessesVendedor.add(i);
					}
				}
			}
		}

		return interessesVendedor;
	}

	public void gravar() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		this.interesse.setCategoriaDeInteresse(this.selectedCategoria);
		this.interesse
				.setCategoriaFilmeDeInteresse(this.selectedCategoriaFilme);
		this.interesse
				.setCategoriaMusicaDeInteresse(this.selectedCategoriaMusica);
		this.interesse.setUsuario(u);
		this.interesse.setDataRegistro(CalendarUtil.retornaDiaDeHoje());
		this.interesse.setStatus(InteresseStatus.ATIVO);
		new DAO<Interesse>(Interesse.class).adiciona(this.interesse);
		try {
			MailUtil.enviaEmailInteresse(this.interesse);
		} catch (EmailException e) {
			System.out.println("Erro no cadastramento do interesse!!!");
			e.printStackTrace();
		}
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ (interesse.getCategoriaDeInteresse() != null ? interesse
						.getCategoriaDeInteresse().getCategoria()
						: interesse.getCategoriaFilmeDeInteresse() != null ? interesse
								.getCategoriaFilmeDeInteresse().getCategoria()
								: interesse.getCategoriaMusicaDeInteresse().getCategoria())
				+ " gravado com sucesso!");
	}

	public void atualizar(InteresseStatus status) {
		this.interesse.setStatus(status);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
	}

	public void tornarInativo() {
		this.interesse.setStatus(InteresseStatus.INATIVO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getCategoriaDeInteresse().getCategoria()
				+ " alterado para Inativado!");
	}

	public void tornarAtendido() {
		this.interesse.setStatus(InteresseStatus.ATENDIDO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getCategoriaDeInteresse().getCategoria()
				+ " alterado para Atendido!");

	}

	public void tornarAtivo() {
		this.interesse.setStatus(InteresseStatus.ATIVO);
		new DAO<Interesse>(Interesse.class).atualiza(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getCategoriaDeInteresse().getCategoria()
				+ " alterado para Ativado!");
	}

	public void excluir() {
		new DAO<Interesse>(Interesse.class).remove(this.interesse);
		JSFMessageUtil.sendInfoMessageToUser("Interesse em "
				+ this.interesse.getCategoriaDeInteresse().getCategoria()
				+ " excluido com sucesso!");

	}

	public void enviarEmailComprador() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		LivroBean lb = new LivroBean();
		FilmeBean fb = new FilmeBean();
		MusicaBean mb = new MusicaBean();
		List<Livro> livrosUsuario = lb.getLivrosUsuario(u);
		List<Filme> filmesUsuario = fb.getFilmesUsuario(u);
		List<Musica> musicasUsuario = mb.getMusicasUsuario(u);

		for (Livro l : livrosUsuario) {
			if (l.getCategoria()
					.getCategoria()
					.equalsIgnoreCase(
							this.interesse.getCategoriaDeInteresse()
									.getCategoria())) {

				try {
					atualizar(InteresseStatus.EMAIL_VENDEDOR);
					JSFMessageUtil.sendInfoMessageToUser("Interesse em "
							+ this.interesse.getCategoriaDeInteresse()
									.getCategoria() + " do usuario "
							+ this.interesse.getUsuario().getNome()
							+ " foi alterado para EMAIL_VENDEDOR!");
					MailUtil.enviaEmailRecomendacaoVendedorParaComprador(
							this.interesse, l);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		for (Filme l : filmesUsuario) {
			if (l.getCategoriaFilme()
					.getCategoria()
					.equalsIgnoreCase(
							this.interesse.getCategoriaFilmeDeInteresse()
									.getCategoria())) {

				try {
					atualizar(InteresseStatus.EMAIL_VENDEDOR);
					JSFMessageUtil.sendInfoMessageToUser("Interesse em "
							+ this.interesse.getCategoriaFilmeDeInteresse()
									.getCategoria() + " do usuario "
							+ this.interesse.getUsuario().getNome()
							+ " foi alterado para EMAIL_VENDEDOR!");
					MailUtil.enviaEmailRecomendacaoVendedorParaCompradorFilme(
							this.interesse, l);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		for (Musica l : musicasUsuario) {
			if (l.getCategoriaMusica()
					.getCategoria()
					.equalsIgnoreCase(
							this.interesse.getCategoriaMusicaDeInteresse()
									.getCategoria())) {

				try {
					atualizar(InteresseStatus.EMAIL_VENDEDOR);
					JSFMessageUtil.sendInfoMessageToUser("Interesse em "
							+ this.interesse.getCategoriaMusicaDeInteresse()
									.getCategoria() + " do usuario "
							+ this.interesse.getUsuario().getNome()
							+ " foi alterado para EMAIL_VENDEDOR!");
					MailUtil.enviaEmailRecomendacaoVendedorParaCompradorMusica(
							this.interesse, l);
				} catch (EmailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
