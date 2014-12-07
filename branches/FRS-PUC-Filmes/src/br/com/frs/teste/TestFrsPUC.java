package br.com.frs.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

	@Test
	public void testGravadora() {
		g = new Gravadora("Line Records");
		g = new DAO<Gravadora>(Gravadora.class).adiciona(g);
		System.out.println("Gravadora - "+g.getId());
		assertEquals(g,
				new DAO<Gravadora>(Gravadora.class).buscaPorId(g.getId()));

		g.setNome("Line Records 2");
		new DAO<Gravadora>(Gravadora.class).atualiza(g);
		assertEquals(g,
				new DAO<Gravadora>(Gravadora.class).buscaPorId(g.getId()));

		new DAO<Gravadora>(Gravadora.class).remove(g);
		assertNull(new DAO<Gravadora>(Gravadora.class).buscaPorId(g.getId()));
	}
	
	@Test
	public void testEstudio() {
		e = new Estudio("Globo Records");
		e = new DAO<Estudio>(Estudio.class).adiciona(e);
		System.out.println("Estudio - "+e.getId());
		assertEquals(e,
				new DAO<Estudio>(Estudio.class).buscaPorId(e.getId()));

		e.setNome("Line Records 2");
		new DAO<Estudio>(Estudio.class).atualiza(e);
		assertEquals(e,
				new DAO<Estudio>(Estudio.class).buscaPorId(e.getId()));

		new DAO<Estudio>(Estudio.class).remove(e);
		assertNull(new DAO<Estudio>(Estudio.class).buscaPorId(e.getId()));
	}

	@Test
	public void testCategoriaMusica() {
		cm = new CategoriaMusica("Pop");
		cm = new DAO<CategoriaMusica>(CategoriaMusica.class).adiciona(cm);
		System.out.println("CAtegoriaMusica - "+cm.getId());
		assertEquals(cm,
				new DAO<CategoriaMusica>(CategoriaMusica.class).buscaPorId(cm
						.getId()));

		cm.setCategoria("Pop 2");
		new DAO<CategoriaMusica>(CategoriaMusica.class).atualiza(cm);
		assertEquals(cm,
				new DAO<CategoriaMusica>(CategoriaMusica.class).buscaPorId(cm
						.getId()));

		new DAO<CategoriaMusica>(CategoriaMusica.class).remove(cm);
		assertNull(new DAO<CategoriaMusica>(CategoriaMusica.class)
				.buscaPorId(cm.getId()));
	}
	
	@Test
	public void testCategoriaFilme() {
		cf = new CategoriaFilme("Trash");
		cf = new DAO<CategoriaFilme>(CategoriaFilme.class).adiciona(cf);
		System.out.println("CAtegoriaFilme - "+cf.getId());
		assertEquals(cf,
				new DAO<CategoriaFilme>(CategoriaFilme.class).buscaPorId(cf
						.getId()));

		cf.setCategoria("Pop 2");
		new DAO<CategoriaFilme>(CategoriaFilme.class).atualiza(cf);
		assertEquals(cf,
				new DAO<CategoriaFilme>(CategoriaFilme.class).buscaPorId(cf
						.getId()));

		new DAO<CategoriaFilme>(CategoriaFilme.class).remove(cf);
		assertNull(new DAO<CategoriaFilme>(CategoriaFilme.class)
				.buscaPorId(cf.getId()));
	}

	@Test
	public void testUsuario() {
		dono = new Usuario("teste", "teste@email.com", "12354789", "teste",
				"teste");
		dono = new DAO<Usuario>(Usuario.class).adiciona(dono);
		System.out.println("Usuario - "+dono.getId());
		assertEquals(dono,
				new DAO<Usuario>(Usuario.class).buscaPorId(dono.getId()));

		dono.setNome("dono 2");
		new DAO<Usuario>(Usuario.class).atualiza(dono);
		assertEquals(dono,
				new DAO<Usuario>(Usuario.class).buscaPorId(dono.getId()));

		new DAO<Usuario>(Usuario.class).remove(dono);
		assertNull(new DAO<Usuario>(Usuario.class).buscaPorId(dono.getId()));
	}

	@Test
	public void testCrudMusica() {
		g = new Gravadora("Line Records");
		g = new DAO<Gravadora>(Gravadora.class).adiciona(g);

		cm = new CategoriaMusica("Pop");
		cm = new DAO<CategoriaMusica>(CategoriaMusica.class).adiciona(cm);

		dono = new Usuario("teste", "teste@email.com", "12354789", "teste",
				"teste");
		dono = new DAO<Usuario>(Usuario.class).adiciona(dono);

		m = new Musica("teste", "teste", 10d, cm, dono, Calendar.getInstance(),
				"", g);
		m = new DAO<Musica>(Musica.class).adiciona(m);
		assertEquals(m, new DAO<Musica>(Musica.class).buscaPorId(m.getId()));

		m.setNome("teste 2");
		new DAO<Musica>(Musica.class).atualiza(m);
		assertEquals(m, new DAO<Musica>(Musica.class).buscaPorId(m.getId()));

		new DAO<Musica>(Musica.class).remove(m);
		assertNull(new DAO<Musica>(Musica.class).buscaPorId(m.getId()));

		new DAO<Gravadora>(Gravadora.class).remove(g);
		new DAO<CategoriaMusica>(CategoriaMusica.class).remove(cm);
		new DAO<Usuario>(Usuario.class).remove(dono);
	}
	
	@Test
	public void testCrudFilme() {
		e = new Estudio("New Line");
		e = new DAO<Estudio>(Estudio.class).adiciona(e);

		cf = new CategoriaFilme("Trash");
		cf = new DAO<CategoriaFilme>(CategoriaFilme.class).adiciona(cf);

		dono = new Usuario("teste", "teste@email.com", "12354789", "teste",
				"teste");
		dono = new DAO<Usuario>(Usuario.class).adiciona(dono);

		f = new Filme("teste", "teste", 10d, cf, dono, Calendar.getInstance(),
				"", e);
		f = new DAO<Filme>(Filme.class).adiciona(f);
		assertEquals(f, new DAO<Filme>(Filme.class).buscaPorId(f.getId()));

		f.setNome("teste 2");
		new DAO<Filme>(Filme.class).atualiza(f);
		assertEquals(f, new DAO<Filme>(Filme.class).buscaPorId(f.getId()));

		new DAO<Filme>(Filme.class).remove(f);
		assertNull(new DAO<Filme>(Filme.class).buscaPorId(f.getId()));

		new DAO<Estudio>(Estudio.class).remove(e);
		new DAO<CategoriaFilme>(CategoriaFilme.class).remove(cf);
		new DAO<Usuario>(Usuario.class).remove(dono);
	}
}
