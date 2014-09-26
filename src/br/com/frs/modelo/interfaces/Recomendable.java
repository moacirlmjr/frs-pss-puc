package br.com.frs.modelo.interfaces;

import br.com.frs.modelo.Categoria;
import br.com.frs.modelo.Usuario;

public interface Recomendable {
	
	public Integer getId();
	public void setId(Integer id);

	public String getNome();

	public void setNome(String nome);

	public Categoria getCategoria();

	public void setCategoria(Categoria categoria);

	public Usuario getDono();

	public void setDono(Usuario dono);
}