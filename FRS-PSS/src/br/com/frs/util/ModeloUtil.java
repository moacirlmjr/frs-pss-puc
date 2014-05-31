package br.com.frs.util;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.frs.modelo.Categoria;
import br.com.frs.modelo.Editora;
import br.com.frs.modelo.Interesse;
import br.com.frs.modelo.Livro;
import br.com.frs.modelo.Recomendacao;
import br.com.frs.modelo.Role;
import br.com.frs.modelo.Usuario;
import br.com.frs.modelo.enumerator.Sexo;

public class ModeloUtil {

	public static ArrayList<Role> roles = new ArrayList<Role>();
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public static ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	public static ArrayList<Editora> editoras = new ArrayList<Editora>();
	public static ArrayList<Livro> livros = new ArrayList<Livro>();
	public static ArrayList<Interesse> interesses = new ArrayList<Interesse>();
	public static ArrayList<Recomendacao> recomendacoes = new ArrayList<Recomendacao>();

	static {

		Role roleAdmin = new Role("Admin");
		Role roleUserVendedor = new Role("UsuarioVendedor");
		Role roleUserComprador = new Role("UsuarioComprador");

		roles.add(roleAdmin);
		roles.add(roleUserComprador);
		roles.add(roleUserVendedor);

		Usuario admin = new Usuario("Administrador", "administrador@frs.com",
				"77665544", "@AdminFRS", Sexo.Masculino, "admin", "admin123",
				roleAdmin);
		Usuario userR = new Usuario("Usuario Comprador", "comprador@frs.com",
				"77665544", "@ReceptorFRS", Sexo.Masculino, "userC",
				"userC123", roleUserComprador);
		Usuario userD = new Usuario("Usuario Vendedor", "doador@frs.com",
				"77665544", "@DoadorFRS", Sexo.Masculino, "userV", "userV123",
				roleUserVendedor);
		Usuario danyllo = new Usuario("Danyllo Wagner",
				"danyllo_wagner@hotmail.com", "79009677", "@DanylloWagner",
				Sexo.Masculino, "danyllo", "danyllo123", roleUserComprador);
		Usuario maroca = new Usuario("Maria Trigo", "maria@hotmail.com",
				"80339677", "@Maria Trigo", Sexo.Feminino, "mariaT", "mariaT123",
				roleUserComprador);
		Usuario roberto = new Usuario("Roberto Felicio",
				"prof.roberto.posse@hotmail.com", "81214567",
				"@Roberto_Felicio", Sexo.Masculino, "roberto", "roberto123",
				roleUserComprador);
		Usuario maria = new Usuario("Maria Joaquina",
				"maria_joaquina@gmail.com", "99887766", "@Maria-Joaquina",
				Sexo.Feminino, "maria", "maria123", roleUserComprador);
		Usuario joao = new Usuario("Joao Santos", "joaozito@gmail.com",
				"88776655", "@JoaozitoJP", Sexo.Masculino, "joao", "joao123",
				roleUserComprador);

		Usuario roberta = new Usuario("Roberta Albuquerque",
				"betabahia@gmail.com", "98765432", "@BetinhaBA", Sexo.Feminino,
				"roberta", "roberta123", roleUserVendedor);
		Usuario marcos = new Usuario("Marcos Vinicius",
				"marcus_vinicius@yahoo.com.br", "87654321", "@MarcusNiteroi",
				Sexo.Masculino, "marcos", "marcos123", roleUserVendedor);
		Usuario patricia = new Usuario("Patricia Maia",
				"patricinharj@yahoo.com.br", "87654321", "@PatyGataRJ",
				Sexo.Feminino, "patricia", "patricia123", roleUserVendedor);
		Usuario edson = new Usuario("Edson Lisboa",
				"edson_lisboa@yahoo.com.br", "65569887", "@EdinhoBH",
				Sexo.Masculino, "edson", "edson123", roleUserVendedor);
		Usuario dorgival = new Usuario("Dorgival Junior",
				"dorgivaljunior@golnaweb.com.br", "65569887", "@JuninhoGol",
				Sexo.Masculino, "dorgival", "dorgival123", roleUserVendedor);
		Usuario jairo = new Usuario("Jairo Albuquerque",
				"jairoconstrutor@ig.com.br", "32325454", "@JairoCimentoCG",
				Sexo.Masculino, "jairo", "jairo123", roleUserVendedor);
		Usuario josefa = new Usuario("Josefa Leite", "zelita-leite@otmail.com",
				"32325454", "@ZeliaCG", Sexo.Feminino, "josefa", "josefa123",
				roleUserVendedor);
		Usuario virginia = new Usuario("Maria Virginia", "vininha@hotmail.com",
				"33310100", "@Vininha85", Sexo.Feminino, "virginia",
				"virginia123", roleUserVendedor);
		Usuario antonio = new Usuario("Antonio Carlos", "acarloscid@uol.com",
				"32478110", "@ACarlosCID", Sexo.Masculino, "antonio",
				"antonio123", roleUserVendedor);
		Usuario mauro = new Usuario("Mauro Cesar", "maurinho2000@uol.com",
				"33294532", "@MaurinhoSurf", Sexo.Masculino, "mauro",
				"mauro123", roleUserVendedor);
		Usuario emanuele = new Usuario("Emmanuele Marie",
				"manu1985@hotmail.com", "88456776", "@ManuEnfermeira",
				Sexo.Feminino, "emanuele", "emanuele123", roleUserVendedor);
		Usuario rodrigo = new Usuario("Rodrigo Maia",
				"rodrigo_maia@hotmail.com", "88776655", "@RodrigoMaromba",
				Sexo.Masculino, "rodrigo", "rodrigo123", roleUserVendedor);
		Usuario hadson = new Usuario("Hadson Barbosa",
				"hadson-ipira@hotmail.com", "88776655", "@HadsonIpira",
				Sexo.Masculino, "hadson", "hadson123", roleUserVendedor);
		Usuario larissa = new Usuario("Larissa Leôncio",
				"lalinhajp@hotmail.com", "88776655", "@Lalinha-jampa",
				Sexo.Feminino, "larissa", "larissa123", roleUserVendedor);
		Usuario mauricio = new Usuario("Mauricio Linhares",
				"mauricio-linhares-jp@gmail.com", "88776655", "@MauricioTI",
				Sexo.Masculino, "mauricio", "mauricio123", roleUserVendedor);
		Usuario aliandro = new Usuario("Aiandro Dantas", "aliandro@gmail.com",
				"76544567", "@AliandroDataprev", Sexo.Masculino, "aliandro",
				"aliandro123", roleUserVendedor);
		Usuario joselia = new Usuario("Joselia Albuquerque",
				"jojo55@hotmail.com", "33310100", "@Jojo55CG", Sexo.Feminino,
				"joselia", "joselia123", roleUserVendedor);
		Usuario teresa = new Usuario("Theresa gaiao", "teka2000@yahoo.com",
				"98987676", "@Tekinha2000", Sexo.Feminino, "teresa",
				"teresa123", roleUserVendedor);
		Usuario elizabet = new Usuario("Elizabet Medeiros",
				"betty@virtual.ufpb.br", "23456789", "@BettyUFPB",
				Sexo.Feminino, "elizabet", "elizabet123", roleUserVendedor);
		Usuario felipe = new Usuario("Felipe Brasileiro",
				"felipebr@hotmail.com", "34325456", "@FilipeComSoc",
				Sexo.Masculino, "felipe", "felipe123", roleUserVendedor);
		Usuario luis = new Usuario("Luis Claudio", "cyrillocav@hotmail.com",
				"33310100", "@cyrillocav", Sexo.Masculino, "luis", "luis123",
				roleUserVendedor);
		Usuario nilton = new Usuario("Nilton Batista", "nbmj@hotmail.com",
				"32321000", "@NiltonMoreno", Sexo.Masculino, "nilton",
				"nilton123", roleUserVendedor);
		Usuario flavio = new Usuario("Flavio Mota", "flavio_motaj@hotmail.com",
				"87655678", "@FlavioNikiti", Sexo.Masculino, "flavio",
				"flavio123", roleUserVendedor);
		Usuario joaozao = new Usuario("Joao Loureiro",
				"joaozitocg@hotmail.com", "99887766", "@Joao1990",
				Sexo.Masculino, "joao", "joao123", roleUserVendedor);
		Usuario monique = new Usuario("Monique Nascimento",
				"moniquedf@hotmail.com", "88777788", "@NikiDF1984",
				Sexo.Feminino, "monique", "monique123", roleUserVendedor);
		Usuario gabriela = new Usuario("Gabriela Albuquerque",
				"gabyalbuquerqie@hotmail.com", "33359609", "@Gaby2000",
				Sexo.Feminino, "gabriela", "gabriela123", roleUserVendedor);

		usuarios.add(admin);
		usuarios.add(userR);
		usuarios.add(userD);
		usuarios.add(danyllo);
		usuarios.add(maroca);
		usuarios.add(roberto);
		usuarios.add(maria);
		usuarios.add(joao);
		usuarios.add(roberta);
		usuarios.add(marcos);
		usuarios.add(patricia);
		usuarios.add(edson);
		usuarios.add(dorgival);
		usuarios.add(jairo);
		usuarios.add(josefa);
		usuarios.add(virginia);
		usuarios.add(antonio);
		usuarios.add(mauro);
		usuarios.add(emanuele);
		usuarios.add(rodrigo);
		usuarios.add(hadson);
		usuarios.add(mauricio);
		usuarios.add(aliandro);
		usuarios.add(larissa);
		usuarios.add(joselia);
		usuarios.add(teresa);
		usuarios.add(elizabet);
		usuarios.add(felipe);
		usuarios.add(luis);
		usuarios.add(nilton);
		usuarios.add(flavio);
		usuarios.add(joaozao);
		usuarios.add(monique);
		usuarios.add(gabriela);

		Categoria romance = new Categoria("Romance");
		Categoria autoAjuda = new Categoria("Auto ajuda");
		Categoria culinaria = new Categoria("Culinaria");
		Categoria suspense = new Categoria("Suspense");
		Categoria terror = new Categoria("Terror");
		Categoria infantil = new Categoria("Infantil");
		Categoria adolescente = new Categoria("Adolescente");
		Categoria erotico = new Categoria("erotico");
		Categoria informatica = new Categoria("informatica");

		categorias.add(romance);
		categorias.add(autoAjuda);
		categorias.add(culinaria);
		categorias.add(suspense);
		categorias.add(terror);
		categorias.add(infantil);
		categorias.add(adolescente);
		categorias.add(erotico);
		categorias.add(informatica);

		Editora moderna = new Editora("Moderna");
		Editora milLuas = new Editora("Mil Luas");
		Editora Elsevier = new Editora("Elsevier");
		Editora Rtc = new Editora("RTC");

		editoras.add(moderna);
		editoras.add(Elsevier);
		editoras.add(milLuas);
		editoras.add(Rtc);

		Calendar dataDeHoje = Calendar.getInstance();

		Livro l1 = new Livro("Amor eterno", "Robert Garcia", 35.00, romance,
				roberta, dataDeHoje, "Livro pouco usado!!!", moderna);
		Livro l2 = new Livro("Para sempre ao teu lado", "Marco Mansur", 63.00,
				romance, marcos, dataDeHoje, "Imperdível", milLuas);
		Livro l3 = new Livro("Vem pro meu lado", "Antonio Bragança", 12.00,
				romance, patricia, dataDeHoje, "Bom livro de cabeceira",
				moderna);
		Livro l4 = new Livro("Deus é maior", "Padre Ibiapina", 11.00,
				autoAjuda, edson, dataDeHoje, "Receba essa benção meu irmão",
				milLuas);
		Livro l5 = new Livro("Espirito de Luz", "Joaquim Nesta", 15.00,
				autoAjuda, dorgival, dataDeHoje, "promoção", moderna);
		Livro l6 = new Livro("Sexo selvagem", "Madalena Sourret", 19.00,
				erotico, jairo, dataDeHoje, "Livro pouco usado!!!", moderna);
		Livro l7 = new Livro("Redes de Computadores", "Andrew Tanenbaun",
				87.00, informatica, josefa, dataDeHoje,
				"Melhor livro de redes de computadores", Elsevier);
		Livro l8 = new Livro("Amor eterno", "Robert Garcia", 35.00, terror,
				virginia, dataDeHoje, "Livro pouco usado!!!", moderna);
		Livro l9 = new Livro("Amor eterno", "Robert Garcia", 35.00, infantil,
				antonio, dataDeHoje, "Livro pouco usado!!!", moderna);
		Livro l10 = new Livro("Amor eterno", "Robert Garcia", 35.00,
				adolescente, mauro, dataDeHoje, "Livro pouco usado!!!", moderna);

		livros.add(l1);
		livros.add(l2);
		livros.add(l3);
		livros.add(l4);
		livros.add(l5);
		livros.add(l6);
		livros.add(l7);
		livros.add(l8);
		livros.add(l9);
		livros.add(l10);

		Interesse i1 = new Interesse(roberto, erotico);
		Interesse i2 = new Interesse(roberto, informatica);
		Interesse i3 = new Interesse(roberto, autoAjuda);
		Interesse i4 = new Interesse(danyllo, erotico);
		Interesse i5 = new Interesse(danyllo, informatica);
		Interesse i6 = new Interesse(danyllo, autoAjuda);

		
		interesses.add(i1);
		interesses.add(i2);
		interesses.add(i3);
		interesses.add(i4);
		interesses.add(i5);
		interesses.add(i6);

		Recomendacao r1 = new Recomendacao(i1, l6);
		Recomendacao r2 = new Recomendacao(i2, l7);
		Recomendacao r3 = new Recomendacao(i3, l4);

		recomendacoes.add(r1);
		recomendacoes.add(r2);
		recomendacoes.add(r3);

	}

}
