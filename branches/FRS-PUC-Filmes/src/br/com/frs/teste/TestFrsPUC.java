package br.com.frs.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import jade.util.Logger;

import java.util.Calendar;

import org.junit.Test;

import br.com.frs.dao.DAO;
import br.com.frs.modelo.CategoriaFilme;
import br.com.frs.modelo.CategoriaMusica;
import br.com.frs.modelo.Estudio;
import br.com.frs.modelo.Filme;
import br.com.frs.modelo.Gravadora;
import br.com.frs.modelo.Musica;
import br.com.frs.modelo.Usuario;

public class TestFrsPUC {

	Usuario dono;
	Gravadora g;
	Estudio e;
	CategoriaFilme cf;
	CategoriaMusica cm;
	Musica m;
	Filme f;
	private static Logger logger = null;
	
	static {
		try {
			logger = Logger.getMyLogger("TestFrsPUC");
		} catch (Exception e) {
			System.out.println("Não foi possível criar o mecanismo de log.");
		}
	}

	@Test
	public void testGravadora() {
		logger.info("Iniciando Teste da Gravadora");
		g = new Gravadora("Line Records");
		g = new DAO<Gravadora>(Gravadora.class).adiciona(g);
		logger.info("Gravadora Line Records Cadastrada com sucesso");
		
		assertEquals(g,
				new DAO<Gravadora>(Gravadora.class).buscaPorId(g.getId()));
		logger.info("Gravadora Line Records buscada com sucesso");

		g.setNome("Line Records 2");
		new DAO<Gravadora>(Gravadora.class).atualiza(g);
		assertEquals(g,
				new DAO<Gravadora>(Gravadora.class).buscaPorId(g.getId()));
		logger.info("Gravadora Line Records atualizada com sucesso");

		new DAO<Gravadora>(Gravadora.class).remove(g);
		assertNull(new DAO<Gravadora>(Gravadora.class).buscaPorId(g.getId()));
		logger.info("Gravadora Line Records removida com sucesso");
	}
	
	@Test
	public void testEstudio() {
		logger.info("Iniciando Teste da Estudio");
		e = new Estudio("Globo Records");
		e = new DAO<Estudio>(Estudio.class).adiciona(e);
		assertEquals(e,
				new DAO<Estudio>(Estudio.class).buscaPorId(e.getId()));
		logger.info("Estudio Globo Records Cadastrado com sucesso");

		e.setNome("Globo Records 2");
		new DAO<Estudio>(Estudio.class).atualiza(e);
		assertEquals(e,
				new DAO<Estudio>(Estudio.class).buscaPorId(e.getId()));
		logger.info("Estudio Globo Records atualizado com sucesso");

		new DAO<Estudio>(Estudio.class).remove(e);
		assertNull(new DAO<Estudio>(Estudio.class).buscaPorId(e.getId()));
		logger.info("Estudio Globo Records removido com sucesso");
	}

	@Test
	public void testCategoriaMusica() {
		logger.info("Iniciando Teste da CAtegoria Musica");
		cm = new CategoriaMusica("Pop");
		cm = new DAO<CategoriaMusica>(CategoriaMusica.class).adiciona(cm);
		assertEquals(cm,
				new DAO<CategoriaMusica>(CategoriaMusica.class).buscaPorId(cm
						.getId()));
		logger.info("Categoria Musica POP Cadastrado com sucesso");
		
		cm.setCategoria("Pop 2");
		new DAO<CategoriaMusica>(CategoriaMusica.class).atualiza(cm);
		assertEquals(cm,
				new DAO<CategoriaMusica>(CategoriaMusica.class).buscaPorId(cm
						.getId()));
		logger.info("Categoria Musica POP atualizada com sucesso");

		new DAO<CategoriaMusica>(CategoriaMusica.class).remove(cm);
		assertNull(new DAO<CategoriaMusica>(CategoriaMusica.class)
				.buscaPorId(cm.getId()));
		logger.info("Categoria Musica POP removida com sucesso");
	}
	
	@Test
	public void testCategoriaFilme() {
		logger.info("Iniciando Teste da CAtegoria Filme");
		cf = new CategoriaFilme("Thrash");
		cf = new DAO<CategoriaFilme>(CategoriaFilme.class).adiciona(cf);
		assertEquals(cf,
				new DAO<CategoriaFilme>(CategoriaFilme.class).buscaPorId(cf
						.getId()));
		logger.info("Categoria Filme Thrash Cadastrado com sucesso");

		cf.setCategoria("Thrash 2");
		new DAO<CategoriaFilme>(CategoriaFilme.class).atualiza(cf);
		assertEquals(cf,
				new DAO<CategoriaFilme>(CategoriaFilme.class).buscaPorId(cf
						.getId()));
		logger.info("Categoria Filme Thrash atualizado com sucesso");

		new DAO<CategoriaFilme>(CategoriaFilme.class).remove(cf);
		assertNull(new DAO<CategoriaFilme>(CategoriaFilme.class)
				.buscaPorId(cf.getId()));
		logger.info("Categoria Filme Thrash removido com sucesso");
	}

	@Test
	public void testUsuario() {
		logger.info("Iniciando Teste da Usuario");
		dono = new Usuario("teste", "teste@email.com", "12354789", "teste",
				"teste");
		dono = new DAO<Usuario>(Usuario.class).adiciona(dono);
		assertEquals(dono,
				new DAO<Usuario>(Usuario.class).buscaPorId(dono.getId()));
		logger.info("Usuario teste Cadastrado com sucesso");

		dono.setNome("dono 2");
		new DAO<Usuario>(Usuario.class).atualiza(dono);
		assertEquals(dono,
				new DAO<Usuario>(Usuario.class).buscaPorId(dono.getId()));
		logger.info("Usuario teste atualizado com sucesso");

		new DAO<Usuario>(Usuario.class).remove(dono);
		assertNull(new DAO<Usuario>(Usuario.class).buscaPorId(dono.getId()));
		logger.info("Usuario teste removido com sucesso");
	}

	@Test
	public void testCrudMusica() {
		logger.info("Iniciando Teste da Musica");
		g = new Gravadora("Line Records");
		g = new DAO<Gravadora>(Gravadora.class).adiciona(g);
		logger.info("gravadora Cadastrado com sucesso");

		cm = new CategoriaMusica("Pop");
		cm = new DAO<CategoriaMusica>(CategoriaMusica.class).adiciona(cm);
		logger.info("categoriamusica Cadastrado com sucesso");

		dono = new Usuario("teste", "teste@email.com", "12354789", "teste",
				"teste");
		dono = new DAO<Usuario>(Usuario.class).adiciona(dono);
		logger.info("usuario Cadastrado com sucesso");

		m = new Musica("teste", "teste", 10d, cm, dono, Calendar.getInstance(),
				"", g);
		m = new DAO<Musica>(Musica.class).adiciona(m);
		assertEquals(m, new DAO<Musica>(Musica.class).buscaPorId(m.getId()));
		logger.info("musica teste cadastrado com sucesso");

		m.setNome("teste 2");
		new DAO<Musica>(Musica.class).atualiza(m);
		assertEquals(m, new DAO<Musica>(Musica.class).buscaPorId(m.getId()));
		logger.info("musica teste atualizado com sucesso");

		new DAO<Musica>(Musica.class).remove(m);
		assertNull(new DAO<Musica>(Musica.class).buscaPorId(m.getId()));
		logger.info("musica teste removida com sucesso");

		new DAO<Gravadora>(Gravadora.class).remove(g);
		logger.info("gravadora removida com sucesso");
		new DAO<CategoriaMusica>(CategoriaMusica.class).remove(cm);
		logger.info("categoriamusica removida com sucesso");
		new DAO<Usuario>(Usuario.class).remove(dono);
		logger.info("usuario removida com sucesso");
	}
	
	@Test
	public void testCrudFilme() {
		logger.info("Iniciando Teste da Filme");
		e = new Estudio("New Line");
		e = new DAO<Estudio>(Estudio.class).adiciona(e);
		logger.info("estudio Cadastrado com sucesso");

		cf = new CategoriaFilme("Thrash");
		cf = new DAO<CategoriaFilme>(CategoriaFilme.class).adiciona(cf);
		logger.info("categoriafilme Cadastrado com sucesso");

		dono = new Usuario("teste", "teste@email.com", "12354789", "teste",
				"teste");
		dono = new DAO<Usuario>(Usuario.class).adiciona(dono);
		logger.info("usuario Cadastrado com sucesso");
		
		f = new Filme("teste", "teste", 10d, cf, dono, Calendar.getInstance(),
				"", e);
		f = new DAO<Filme>(Filme.class).adiciona(f);
		assertEquals(f, new DAO<Filme>(Filme.class).buscaPorId(f.getId()));
		logger.info("filme teste Cadastrado com sucesso");

		f.setNome("teste 2");
		new DAO<Filme>(Filme.class).atualiza(f);
		assertEquals(f, new DAO<Filme>(Filme.class).buscaPorId(f.getId()));
		logger.info("filme teste atualizado com sucesso");

		new DAO<Filme>(Filme.class).remove(f);
		assertNull(new DAO<Filme>(Filme.class).buscaPorId(f.getId()));
		logger.info("filme teste removido com sucesso");

		new DAO<Estudio>(Estudio.class).remove(e);
		logger.info("estudio removido com sucesso");
		new DAO<CategoriaFilme>(CategoriaFilme.class).remove(cf);
		logger.info("categoriafilme removido com sucesso");
		new DAO<Usuario>(Usuario.class).remove(dono);
		logger.info("usuario removido com sucesso");
	}
}
