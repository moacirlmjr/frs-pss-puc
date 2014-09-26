package br.com.frs.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.frs.modelo.Usuario;

public class LoginUtil {

	public static Usuario retornaUsuarioLogado(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		return u;
	}
}
