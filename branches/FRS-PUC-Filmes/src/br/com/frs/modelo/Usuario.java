package br.com.frs.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import br.com.frs.modelo.enumerator.Sexo;
import br.com.frs.modelo.interfaces.Generic;
import br.com.frs.modelo.interfaces.PersonNegotiable;

@Entity
@NamedQuery(name = "User.findUserByLogin", query = "select u from Usuario u where u.login = :login")
public class Usuario implements Generic, PersonNegotiable {

	public static final String FIND_BY_LOGIN = "User.findUserByLogin";

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String telefone;
	private String Twitter;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private String login;
	private String senha;

	@OneToOne
	private Role role;

	public Usuario() {

	}

	public Usuario(String nome, String email, String telefone, String twitter,
			Sexo sexo, String login, String senha, Role role) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.Twitter = twitter;
		this.sexo = sexo;
		this.login = login;
		this.senha = senha;
		this.role = role;
	}

	public Usuario(String nome, String email, String telefone, String login,
			String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTwitter() {
		return Twitter;
	}

	public void setTwitter(String twitter) {
		Twitter = twitter;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isAdmin() {
		return (this.role.getRole() == "Admin" || this.role.getId() == 1);
	}

	public boolean isUserReceptor() {
		return (this.role.getRole() == "UsuarioReceptor" || this.role.getId() == 2);
	}

	public boolean isUserDoador() {
		return (this.role.getRole() == "UsuarioDoador" || this.role.getId() == 3);
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof Usuario) && ((Usuario) obj).getId().equals(this.getId())) { 
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return this.id.hashCode();
		
	}
	
	

}