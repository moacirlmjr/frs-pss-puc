package br.com.frs.mbeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.EmailException;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.Categoria;
import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Livro;
import br.com.frs.modelo.Recomendacao;
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

	public InteresseBean() {
		interesse = new Interesse();
		selectedCategoria = new Categoria();
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
		List<Livro> livrosUsuario = lb.getLivrosUsuario(u);
		List<Interesse> todosInteresses = getInteresses();
		List<Interesse> interessesVendedor = new ArrayList<Interesse>();

		for (Interesse i : todosInteresses) {

			for (Livro l : livrosUsuario) {

				if ((i.getCategoriaDeInteresse().getId() == l.getCategoria()
						.getId())
						&& (i.getStatus().equals(InteresseStatus.ATIVO))) {
					interessesVendedor.add(i);
				}
			}
		}
		return interessesVendedor;

	}

	public void gravar() {
		Usuario u = LoginUtil.retornaUsuarioLogado();
		this.interesse.setCategoriaDeInteresse(this.selectedCategoria);
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
				+ this.interesse.getCategoriaDeInteresse().getCategoria()
				+ " gravado com sucesso!");
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

	public void executarConfirmacao() {
		Calendar dataDeHoje = Calendar.getInstance();
		RecomendacaoBean rb = new RecomendacaoBean();
		Recomendacao rec = new Recomendacao();
		rec.setInteresse(this.interesse);

		Usuario u = LoginUtil.retornaUsuarioLogado();
		LivroBean lb = new LivroBean();
		List<Livro> livrosUsuario = lb.getLivrosUsuario(u);

		for (Livro l : livrosUsuario) {
			if (l.getCategoria().getCategoria() == this.interesse
					.getCategoriaDeInteresse().getCategoria()) {
				rec.setLivro(l);
				rec.setDataRegistro(dataDeHoje);
				rb.gravar(rec);
				this.interesse.setStatus(InteresseStatus.ATENDIDO);
			}
		}

	}

}
