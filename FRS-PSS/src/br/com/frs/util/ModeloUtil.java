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
		
		Calendar dataHoje = Calendar.getInstance();

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

		Usuario gilsantos = new Usuario("Gil Santos Oliveira",
				"givanilde.santos@hotmail.com", "79004554", "@GilSantosPosse",
				Sexo.Masculino, "gil", "gil123", roleUserComprador);
		Usuario roberto = new Usuario("Roberto Felicio",
				"prof.roberto.posse@hotmail.com", "81214567",
				"@Roberto_Felicio", Sexo.Masculino, "roberto", "roberto123",
				roleUserComprador);
		Usuario danyllo = new Usuario("Danyllo Wagner",
				"danyllo_wagner@hotmail.com", "79009677", "@DanylloWagner",
				Sexo.Masculino, "danyllo", "danyllo123", roleUserComprador);
		Usuario joana = new Usuario("Joana Trigo", "maria@hotmail.com",
				"80339677", "@Joana_Trigo", Sexo.Feminino, "joana", "joana123",
				roleUserComprador);
		Usuario maria = new Usuario("Maria Joaquina",
				"maria_joaquina@gmail.com", "99887766", "@Maria-Joaquina",
				Sexo.Feminino, "maria", "maria123", roleUserComprador);
		Usuario joao = new Usuario("Joao Santos", "joaozito@gmail.com",
				"88776655", "@JoaozitoJP", Sexo.Masculino, "joao", "joao123",
				roleUserComprador);
		Usuario rose = new Usuario("Rose Oliveira", "roseoliveira@hotmail.com",
				"18181818", "@Rose1980", Sexo.Feminino, "rose", "rose123",
				roleUserComprador);
		Usuario clarisse = new Usuario("Clarisse Oliveira",
				"claholiveira@hotmail.com", "98765432", "@ClaAracatuba",
				Sexo.Feminino, "clarisse", "clarisse123", roleUserComprador);
		Usuario marcelo = new Usuario("Marcelo Ravena", "marcelo@gmail.com",
				"62345986", "@MarcelaoDasMeninas", Sexo.Masculino, "marcelo",
				"marcelo123", roleUserComprador);
		Usuario cleonice = new Usuario("Cleonice de Assis",
				"cleonice@gmail.com", "56382910", "@CleoPosse", Sexo.Feminino,
				"cleonice", "cleonice123", roleUserComprador);
		Usuario geovane = new Usuario("Geovane do Santos", "geovane@gmail.com",
				"91238345", "@GeovanePosse", Sexo.Masculino, "geovane",
				"geovane123", roleUserComprador);
		Usuario antonio = new Usuario("Antonio Bento", "ab@gmail.com",
				"76293756", "@TonhaoBento", Sexo.Masculino, "geovane",
				"geovane123", roleUserComprador);
		Usuario jaciara = new Usuario("Jaciara Macumbeira",
				"geovane@gmail.com", "91238345", "@GeovanePosse",
				Sexo.Feminino, "jaciara", "jaciara123", roleUserComprador);
		Usuario marco = new Usuario("Marco Pollo", "marco_polloe@gmail.com",
				"91238345", "@Marco_PolloBR", Sexo.Masculino, "marco",
				"marco123", roleUserComprador);

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
		Usuario carlos = new Usuario("Carlos finoquio", "acarloscid@uol.com",
				"32478110", "@ACarlos", Sexo.Masculino, "carlos", "carlos123",
				roleUserVendedor);
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

		usuarios.add(gilsantos);
		usuarios.add(roberto);
		usuarios.add(danyllo);
		usuarios.add(joana);
		usuarios.add(rose);
		usuarios.add(clarisse);
		usuarios.add(marcelo);
		usuarios.add(cleonice);
		usuarios.add(geovane);
		usuarios.add(antonio);
		usuarios.add(jaciara);
		usuarios.add(marco);

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
		usuarios.add(carlos);
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
		Categoria administracao = new Categoria("administracao");
		Categoria historia = new Categoria("historia");
		Categoria medicina = new Categoria("medicina");
		Categoria veterinaria = new Categoria("veterinaria");
		Categoria geografia = new Categoria("geografia");
		Categoria ciencias = new Categoria("ciencias");
		Categoria matematica = new Categoria("matematica");
		Categoria biologia = new Categoria("biologia");
		Categoria contabilidade = new Categoria("contabilidade");
		Categoria quimica = new Categoria("quimica");
		Categoria fisica = new Categoria("fisica");

		categorias.add(romance);
		categorias.add(autoAjuda);
		categorias.add(culinaria);
		categorias.add(suspense);
		categorias.add(terror);
		categorias.add(infantil);
		categorias.add(adolescente);
		categorias.add(erotico);
		categorias.add(informatica);
		categorias.add(administracao);
		categorias.add(historia);
		categorias.add(medicina);
		categorias.add(veterinaria);
		categorias.add(geografia);
		categorias.add(ciencias);
		categorias.add(matematica);
		categorias.add(biologia);
		categorias.add(contabilidade);
		categorias.add(quimica);
		categorias.add(fisica);

		Editora moderna = new Editora("Moderna");
		Editora milLuas = new Editora("Mil Luas");
		Editora Elsevier = new Editora("Elsevier");
		Editora Rtc = new Editora("RTC");
		Editora campus = new Editora("Campus");
		Editora wesley = new Editora("Wesley");
		Editora scipione = new Editora("Scipione");
		Editora ftd = new Editora("FTD");
		Editora puc = new Editora("PUC-Rio");
		Editora globo = new Editora("Globo");

		editoras.add(moderna);
		editoras.add(Elsevier);
		editoras.add(milLuas);
		editoras.add(Rtc);
		editoras.add(campus);
		editoras.add(wesley);
		editoras.add(scipione);
		editoras.add(ftd);
		editoras.add(puc);
		editoras.add(globo);

		Livro l1 = new Livro("Amor eterno", "Robert Garcia", 35.00, romance,
				roberta, dataHoje,
				"Livro pouco usado!!!", moderna);
		Livro l2 = new Livro("Para sempre ao teu lado", "Marco Mansur", 63.00,
				romance, marcos, dataHoje, "Imperdível",
				milLuas);
		Livro l3 = new Livro("Vem pro meu lado", "Antonio Bragança", 12.00,
				romance, patricia, dataHoje,
				"Bom livro de cabeceira", moderna);
		Livro l4 = new Livro("Deus é maior", "Padre Ibiapina", 11.00,
				autoAjuda, edson, dataHoje,
				"Receba essa benção meu irmão", milLuas);
		Livro l5 = new Livro("Espirito de Luz", "Joaquim Nesta", 15.00,
				autoAjuda, dorgival, dataHoje,
				"promoção", moderna);
		Livro l6 = new Livro("Sexo selvagem", "Madalena Sourret", 19.00,
				erotico, jairo, dataHoje,
				"Livro pouco usado!!!", moderna);
		Livro l7 = new Livro("Redes de Computadores", "Andrew Tanenbaun",
				87.00, informatica, josefa, dataHoje,
				"Melhor livro de redes de computadores", Elsevier);
		Livro l8 = new Livro("Amor eterno", "Robert Garcia", 35.00, terror,
				virginia, dataHoje,
				"Livro pouco usado!!!", moderna);
		Livro l9 = new Livro("Amor eterno", "Robert Garcia", 35.00, infantil,
				antonio, dataHoje,
				"Livro pouco usado!!!", moderna);
		Livro l10 = new Livro("Amor eterno", "Robert Garcia", 35.00,
				adolescente, mauro, dataHoje,
				"Livro pouco usado!!!", moderna);
		Livro l11 = new Livro("Matematica Geral", "Bonjornoe  Giovani", 115.00,
				matematica, emanuele, dataHoje,
				"Excelente livro de matematica!!!", scipione);
		Livro l12 = new Livro("Contabilidade Fácil", "Jorge Sabrini", 78.00,
				contabilidade, rodrigo, dataHoje,
				"Livro pouco usado!!!", moderna);
		Livro l13 = new Livro("Os Seres Vivos", "Marjoli Stein", 78.00,
				contabilidade, monique, dataHoje,
				"Livro usado no ensino médio!!!", ftd);
		Livro l14 = new Livro("Fisica Quantica", "Souto Maior", 65.00,
				contabilidade, gabriela, dataHoje,
				"Livro para pós-graduação", moderna);
		Livro l15 = new Livro("Qumica orgânical", "Maria Saquarema", 91.00,
				quimica, elizabet, dataHoje,
				"Esta com pequenas avarias...", scipione);
		Livro l16 = new Livro("Game Of Thrones I", "Hamiflier ForWaves", 34.00,
				adolescente, felipe, dataHoje,
				"Livro pouco usado!!!", moderna);
		Livro l17 = new Livro("Historia Moderna", "Jorge Vicentini", 78.00,
				historia, luis, dataHoje,
				"Melhor livro de historia para ensino medio", campus);
		Livro l18 = new Livro("Fisica Quantica", "Souto Maior", 65.00,
				contabilidade, gabriela, dataHoje,
				"Livro para pós-graduação", moderna);
		Livro l19 = new Livro("Caras e Bocas", "Carlos Drummond", 91.00,
				adolescente, larissa, dataHoje,
				"Inspirado na melhor novela da globo", globo);
		Livro l20 = new Livro("O Livro das Ciências", "Jorge Michaels", 67.00,
				ciencias, mauricio, dataHoje,
				"Livro de exoterismoe ciencias ocultas", moderna);
		Livro l21 = new Livro("Veterinaria Geral - Grande porte",
				"Alexsandra firmino", 123.00, veterinaria, aliandro,
				dataHoje,
				"Abrange desde caprinos até bovinos e equinos", wesley);
		Livro l22 = new Livro("Administração - A biblia", "Chiaventto", 65.00,
				administracao, felipe, dataHoje,
				"Bom livro sobre os conceitos de administração", wesley);
		Livro l23 = new Livro("Sistemas Operacionais", "Deitel", 65.00,
				informatica, jairo, dataHoje,
				"Muito simple o entendimento desse livro", wesley);

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
		livros.add(l11);
		livros.add(l12);
		livros.add(l13);
		livros.add(l14);
		livros.add(l15);
		livros.add(l16);
		livros.add(l17);
		livros.add(l18);
		livros.add(l19);
		livros.add(l20);
		livros.add(l21);
		livros.add(l22);
		livros.add(l23);

		Interesse i1 = new Interesse(roberto, erotico);
		Interesse i2 = new Interesse(roberto, informatica);
		Interesse i3 = new Interesse(roberto, autoAjuda);
		Interesse i4 = new Interesse(danyllo, erotico);
		Interesse i5 = new Interesse(danyllo, informatica);
		Interesse i6 = new Interesse(danyllo, autoAjuda);
		Interesse i7 = new Interesse(gilsantos, administracao);
		Interesse i8 = new Interesse(gilsantos, informatica);
		Interesse i9 = new Interesse(gilsantos, romance);
		Interesse i10 = new Interesse(rose, autoAjuda);
		Interesse i11 = new Interesse(rose, erotico);
		Interesse i12 = new Interesse(rose, romance);
		Interesse i13 = new Interesse(clarisse, autoAjuda);
		Interesse i14 = new Interesse(rose, ciencias);
		Interesse i15 = new Interesse(rose, quimica);

		interesses.add(i1);
		interesses.add(i2);
		interesses.add(i3);
		interesses.add(i4);
		interesses.add(i5);
		interesses.add(i6);
		interesses.add(i7);
		interesses.add(i8);
		interesses.add(i9);
		interesses.add(i10);
		interesses.add(i11);
		interesses.add(i12);
		interesses.add(i13);
		interesses.add(i14);
		interesses.add(i15);

		Recomendacao r1 = new Recomendacao(i1, l6);
		Recomendacao r2 = new Recomendacao(i2, l7);
		Recomendacao r3 = new Recomendacao(i3, l4);
		Recomendacao r4 = new Recomendacao(i7, l22);
		Recomendacao r5 = new Recomendacao(i8, l23);
		Recomendacao r6 = new Recomendacao(i9, l2);

		recomendacoes.add(r1);
		recomendacoes.add(r2);
		recomendacoes.add(r3);
		recomendacoes.add(r4);
		recomendacoes.add(r5);
		recomendacoes.add(r6);

	}

}
