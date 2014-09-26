-- MySQL dump 10.13  Distrib 5.1.73, for Win32 (ia32)
--
-- Host: localhost    Database: frsdb
-- ------------------------------------------------------
-- Server version	5.1.73-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Romance'),(2,'Auto ajuda'),(3,'Culinaria'),(4,'Suspense'),(5,'Terror'),(6,'Infantil'),(7,'Adolescente'),(8,'erotico'),(9,'informatica'),(10,'administracao'),(11,'historia'),(12,'medicina'),(13,'veterinaria'),(14,'geografia'),(15,'ciencias'),(16,'matematica'),(17,'biologia'),(18,'contabilidade'),(19,'quimica'),(20,'fisica');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editora`
--

DROP TABLE IF EXISTS `editora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editora` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editora`
--

LOCK TABLES `editora` WRITE;
/*!40000 ALTER TABLE `editora` DISABLE KEYS */;
INSERT INTO `editora` VALUES (1,'Moderna'),(2,'Elsevier'),(3,'Mil Luas'),(4,'RTC'),(5,'Campus'),(6,'Wesley'),(7,'Scipione'),(8,'FTD'),(9,'PUC-Rio'),(10,'Globo'),(11,'CanÃ§Ã£o nova');
/*!40000 ALTER TABLE `editora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interesse`
--

DROP TABLE IF EXISTS `interesse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interesse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataRegistro` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `categoriaDeInteresse_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK95675E3C51D506F` (`categoriaDeInteresse_id`),
  KEY `FK95675E3C32A297E4` (`usuario_id`),
  CONSTRAINT `FK95675E3C32A297E4` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK95675E3C51D506F` FOREIGN KEY (`categoriaDeInteresse_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interesse`
--

LOCK TABLES `interesse` WRITE;
/*!40000 ALTER TABLE `interesse` DISABLE KEYS */;
INSERT INTO `interesse` VALUES (1,'2014-06-29','ATIVO',8,5),(2,'2014-06-29','ATIVO',9,5),(3,'2014-06-29','ATIVO',2,5),(4,'2014-06-29','ATIVO',8,6),(5,'2014-06-29','ATIVO',9,6),(6,'2014-06-29','ATIVO',2,6),(7,'2014-06-29','ATIVO',10,4),(8,'2014-06-29','ATIVO',9,4),(9,'2014-06-29','ATENDIDO',1,4),(10,'2014-06-29','ATENDIDO',2,8),(11,'2014-06-29','ATENDIDO',8,8),(12,'2014-06-29','ATENDIDO',1,8),(13,'2014-06-29','ATENDIDO',2,9),(14,'2014-06-29','ATENDIDO',15,8),(15,'2014-06-29','ATENDIDO',19,8),(16,'2014-06-30','ATENDIDO',1,45);
/*!40000 ALTER TABLE `interesse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `livro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `autor` varchar(255) DEFAULT NULL,
  `dataCadastro` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `dono_id` int(11) DEFAULT NULL,
  `editora_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4607E76124522C6` (`dono_id`),
  KEY `FK4607E76DF4E5624` (`editora_id`),
  KEY `FK4607E7651A28B44` (`categoria_id`),
  CONSTRAINT `FK4607E76124522C6` FOREIGN KEY (`dono_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK4607E7651A28B44` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK4607E76DF4E5624` FOREIGN KEY (`editora_id`) REFERENCES `editora` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES (1,'Robert Garcia','2014-06-29','Amor eterno','Livro pouco usado!!!',35,1,18,1),(2,'Marco Mansur','2014-06-29','Para sempre ao teu lado','Imperdível',63,1,19,3),(3,'Antonio Bragança','2014-06-29','Vem pro meu lado','Bom livro de cabeceira',12,1,20,1),(4,'Padre Ibiapina','2014-06-29','Deus é maior','Receba essa benção meu irmão',11,2,21,3),(5,'Joaquim Nesta','2014-06-29','Espirito de Luz','promoção',15,2,22,1),(6,'Madalena Sourret','2014-06-29','Sexo selvagem','Livro pouco usado!!!',19,8,23,1),(7,'Andrew Tanenbaun','2014-06-29','Redes de Computadores','Melhor livro de redes de computadores',87,9,24,2),(8,'Robert Garcia','2014-06-29','Amor eterno','Livro pouco usado!!!',35,5,25,1),(9,'Robert Garcia','2014-06-29','Amor eterno','Livro pouco usado!!!',35,6,13,1),(10,'Robert Garcia','2014-06-29','Amor eterno','Livro pouco usado!!!',35,7,27,1),(11,'Bonjornoe  Giovani','2014-06-29','Matematica Geral','Excelente livro de matematica!!!',115,16,28,7),(12,'Jorge Sabrini','2014-06-29','Contabilidade Fácil','Livro pouco usado!!!',78,18,29,1),(13,'Marjoli Stein','2014-06-29','Os Seres Vivos','Livro usado no ensino médio!!!',78,18,42,8),(14,'Souto Maior','2014-06-29','Fisica Quantica','Livro para pós-graduação',65,18,43,1),(15,'Maria Saquarema','2014-06-29','Qumica orgânical','Esta com pequenas avarias...',91,19,36,7),(16,'Hamiflier ForWaves','2014-06-29','Game Of Thrones I','Livro pouco usado!!!',34,7,37,1),(17,'Jorge Vicentini','2014-06-29','Historia Moderna','Melhor livro de historia para ensino medio',78,11,38,5),(18,'Souto Maior','2014-06-29','Fisica Quantica','Livro para pós-graduação',65,18,43,1),(19,'Carlos Drummond','2014-06-29','Caras e Bocas','Inspirado na melhor novela da globo',91,7,33,10),(20,'Jorge Michaels','2014-06-29','O Livro das Ciências','Livro de exoterismoe ciencias ocultas',67,15,31,1),(21,'Alexsandra firmino','2014-06-29','Veterinaria Geral - Grande porte','Abrange desde caprinos até bovinos e equinos',123,13,32,6),(22,'Chiaventto','2014-06-29','Administração - A biblia','Bom livro sobre os conceitos de administração',65,10,37,6),(23,'Deitel','2014-06-29','Sistemas Operacionais','Muito simple o entendimento desse livro',65,9,23,6),(24,'Cesar Gusmao','2014-06-30','Tudo vai dar certo','Um livro maravilhoso!',20,2,23,3);
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recomendacao`
--

DROP TABLE IF EXISTS `recomendacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recomendacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataRegistro` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `interesse_id` int(11) DEFAULT NULL,
  `livro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD24DB51DE5923164` (`livro_id`),
  KEY `FKD24DB51D37FC0EA4` (`interesse_id`),
  CONSTRAINT `FKD24DB51D37FC0EA4` FOREIGN KEY (`interesse_id`) REFERENCES `interesse` (`id`),
  CONSTRAINT `FKD24DB51DE5923164` FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recomendacao`
--

LOCK TABLES `recomendacao` WRITE;
/*!40000 ALTER TABLE `recomendacao` DISABLE KEYS */;
INSERT INTO `recomendacao` VALUES (1,'2014-06-29','ATIVA',1,6),(2,'2014-06-29','ATIVA',2,7),(3,'2014-06-29','ATIVA',3,4),(4,'2014-06-29','ATIVA',7,22),(5,'2014-06-29','ATIVA',8,23),(6,'2014-06-29','ATIVA',9,2),(7,'2014-06-30','EXECUTADA',16,1),(8,'2014-06-30','ATIVA',16,2),(9,'2014-06-30','ATIVA',16,3),(10,'2014-06-30','ATIVA',15,15),(11,'2014-06-30','ATIVA',14,20),(12,'2014-06-30','ATIVA',13,4),(13,'2014-06-30','ATIVA',13,5),(14,'2014-06-30','ATIVA',13,24),(15,'2014-06-30','ATIVA',12,1),(16,'2014-06-30','ATIVA',12,2),(17,'2014-06-30','ATIVA',12,3),(18,'2014-06-30','ATIVA',11,6),(19,'2014-06-30','ATIVA',10,4),(20,'2014-06-30','ATIVA',10,5),(21,'2014-06-30','ATIVA',10,24),(22,'2014-06-30','ATIVA',9,1),(23,'2014-06-30','ATIVA',9,2);
/*!40000 ALTER TABLE `recomendacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'UsuarioComprador'),(3,'UsuarioVendedor');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Twitter` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5B4D8B0EE31F3150` (`role_id`),
  CONSTRAINT `FK5B4D8B0EE31F3150` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'@AdminFRS','administrador@frs.com','admin','Administrador','admin123','Masculino','77665544',1),(2,'@ReceptorFRS','comprador@frs.com','userC','Usuario Comprador','userC123','Masculino','77665544',2),(3,'@DoadorFRS','doador@frs.com','userV','Usuario Vendedor','userV123','Masculino','77665544',3),(4,'@GilSantosPosse','givanilde.santos@hotmail.com','gil','Gil Santos Oliveira','gil123','Masculino','79004558',2),(5,'@Roberto_Felicio','prof.roberto.posse@hotmail.com','roberto','Roberto Felicio','roberto123','Masculino','81214567',2),(6,'@DanylloWagner','danyllo_wagner@hotmail.com','danyllo','Danyllo Wagner','danyllo123','Masculino','79009677',2),(7,'@Joana_Trigo','maria@hotmail.com','joana','Joana Trigo','joana123','Feminino','80339677',2),(8,'@Rose1980','roseoliveira@hotmail.com','rose','Rose Oliveira','rose123','Feminino','18181818',2),(9,'@ClaAracatuba','claholiveira@hotmail.com','clarisse','Clarisse Oliveira','clarisse123','Feminino','98765432',2),(10,'@MarcelaoDasMeninas','marcelo@gmail.com','marcelo','Marcelo Ravena','marcelo123','Masculino','62345986',2),(11,'@CleoPosse','cleonice@gmail.com','cleonice','Cleonice de Assis','cleonice123','Feminino','56382910',2),(12,'@GeovanePosse','geovane@gmail.com','geovane','Geovane do Santos','geovane123','Masculino','91238345',2),(13,'@TonhaoBento','ab@gmail.com','geovane','Antonio Bento','geovane123','Masculino','76293756',2),(14,'@GeovanePosse','geovane@gmail.com','jaciara','Jaciara Macumbeira','jaciara123','Feminino','91238345',2),(15,'@Marco_PolloBR','marco_polloe@gmail.com','marco','Marco Pollo','marco123','Masculino','91238345',2),(16,'@Maria-Joaquina','maria_joaquina@gmail.com','maria','Maria Joaquina','maria123','Feminino','99887766',2),(17,'@JoaozitoJP','joaozito@gmail.com','joao','Joao Santos','joao123','Masculino','88776655',2),(18,'@BetinhaBA','prof.roberto.posse@gmail.com','roberta','Roberta Albuquerque','roberta123','Feminino','98765432',3),(19,'@MarcusNiteroi','marcus_vinicius@yahoo.com.br','marcos','Marcos Vinicius','marcos123','Masculino','87654321',3),(20,'@PatyGataRJ','patricinharj@yahoo.com.br','patricia','Patricia Maia','patricia123','Feminino','87654321',3),(21,'@EdinhoBH','edson_lisboa@yahoo.com.br','edson','Edson Lisboa','edson123','Masculino','65569887',3),(22,'@JuninhoGol','dorgivaljunior@golnaweb.com.br','dorgival','Dorgival Junior','dorgival123','Masculino','65569887',3),(23,'@JairoCimentoCG','jairoconstrutor@ig.com.br','jairo','Jairo Albuquerque','jairo123','Masculino','32325457',3),(24,'@ZeliaCG','zelita-leite@otmail.com','josefa','Josefa Leite','josefa123','Feminino','32325454',3),(25,'@Vininha85','vininha@hotmail.com','virginia','Maria Virginia','virginia123','Feminino','33310100',3),(26,'@ACarlos','acarloscid@uol.com','carlos','Carlos finoquio','carlos123','Masculino','32478110',3),(27,'@MaurinhoSurf','maurinho2000@uol.com','mauro','Mauro Cesar','mauro123','Masculino','33294532',3),(28,'@ManuEnfermeira','manu1985@hotmail.com','emanuele','Emmanuele Marie','emanuele123','Feminino','88456776',3),(29,'@RodrigoMaromba','rodrigo_maia@hotmail.com','rodrigo','Rodrigo Maia','rodrigo123','Masculino','88776655',3),(30,'@HadsonIpira','hadson-ipira@hotmail.com','hadson','Hadson Barbosa','hadson123','Masculino','88776655',3),(31,'@MauricioTI','mauricio-linhares-jp@gmail.com','mauricio','Mauricio Linhares','mauricio123','Masculino','88776655',3),(32,'@AliandroDataprev','aliandro@gmail.com','aliandro','Aiandro Dantas','aliandro123','Masculino','76544567',3),(33,'@Lalinha-jampa','lalinhajp@hotmail.com','larissa','Larissa Leôncio','larissa123','Feminino','88776655',3),(34,'@Jojo55CG','jojo55@hotmail.com','joselia','Joselia Albuquerque','joselia123','Feminino','33310100',3),(35,'@Tekinha2000','teka2000@yahoo.com','teresa','Theresa gaiao','teresa123','Feminino','98987676',3),(36,'@BettyUFPB','betty@virtual.ufpb.br','elizabet','Elizabet Medeiros','elizabet123','Feminino','23456789',3),(37,'@FilipeComSoc','felipebr@hotmail.com','felipe','Felipe Brasileiro','felipe123','Masculino','34325456',3),(38,'@cyrillocav','cyrillocav@hotmail.com','luis','Luis Claudio','luis123','Masculino','33310100',3),(39,'@NiltonMoreno','nbmj@hotmail.com','nilton','Nilton Batista','nilton123','Masculino','32321000',3),(40,'@FlavioNikiti','flavio_motaj@hotmail.com','flavio','Flavio Mota','flavio123','Masculino','87655678',3),(41,'@Joao1990','joaozitocg@hotmail.com','joao','Joao Loureiro','joao123','Masculino','99887766',3),(42,'@NikiDF1984','moniquedf@hotmail.com','monique','Monique Nascimento','monique123','Feminino','88777788',3),(43,'@Gaby2000','gabyalbuquerqie@hotmail.com','gabriela','Gabriela Albuquerque','gabriela123','Feminino','33359609',3),(44,'@romero','prof.roberto.posse@gmail.com','romero','Romero','romero123','Masculino','(111) 1111-1111',2),(45,'@marx','marxviana@gmail.com','marxviana','Marx Viana','marxv123','Masculino','(222) 2222-2226',2),(46,'@roberto','prof.roberto.posse@gmail.com','robert','Robertinho','robert123','Masculino','(222) 2222-2222',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-06 23:47:59
