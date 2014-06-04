package br.com.frs.dao.conf;

import javax.persistence.EntityManager;

import br.com.frs.dao.HibernateUtil;
import br.com.frs.modelo.Categoria;
import br.com.frs.modelo.Editora;
import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Livro;
import br.com.frs.modelo.Recomendacao;
import br.com.frs.modelo.Role;
import br.com.frs.modelo.Usuario;
import br.com.frs.util.ModeloUtil;

public class BancoUtil {

	public static void popula() {
		EntityManager em = new HibernateUtil().getEntityManager();

		// roles
		em.getTransaction().begin();

		for (Role role : ModeloUtil.roles) {
			em.persist(role);
		}
		em.getTransaction().commit();

		// criando usuarios
		em.getTransaction().begin();
		for (Usuario user : ModeloUtil.usuarios) {
			em.persist(user);
		}
		em.getTransaction().commit();

		// criando categorias
		em.getTransaction().begin();
		for (Categoria cat : ModeloUtil.categorias) {
			em.persist(cat);
		}
		em.getTransaction().commit();

		// criando editoras
		em.getTransaction().begin();
		for (Editora ed : ModeloUtil.editoras) {
			em.persist(ed);
		}
		em.getTransaction().commit();

		// criando livros
		em.getTransaction().begin();
		for (Livro l : ModeloUtil.livros) {
			em.persist(l);
		}
		em.getTransaction().commit();

		// criando interesses
		em.getTransaction().begin();
		for (Interesse i : ModeloUtil.interesses) {
			em.persist(i);
		}
		em.getTransaction().commit();

		// criando recomendações
		em.getTransaction().begin();
		for (Recomendacao r : ModeloUtil.recomendacoes) {
			em.persist(r);
		}
		em.getTransaction().commit();
		em.close();

	}

}
