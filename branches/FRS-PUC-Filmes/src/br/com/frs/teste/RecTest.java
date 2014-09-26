package br.com.frs.teste;

import java.util.ArrayList;

import br.com.frs.mbeans.UsuarioBean;
import br.com.frs.modelo.Usuario;

/**
 * @author OPUS
 *
 */
public class RecTest { 
	public static void main(String[] args) {
		ArrayList<Usuario> usuariosSI;
		UsuarioBean ub = new UsuarioBean();
		usuariosSI = (ArrayList<Usuario>) ub.getUsuariosSemInteresse();
		
		for (Usuario u : usuariosSI){
			System.out.println(u.getNome());
		}
	}
 }
