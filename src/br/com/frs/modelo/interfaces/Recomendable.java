package br.com.frs.modelo.interfaces;

import br.com.frs.modelo.Usuario;

public interface Recomendable {
	
	public Integer getId();
	public void setId(Integer id);

	public String getNome();

	public void setNome(String nome);

	public Usuario getDono();

	public void setDono(Usuario dono);
}