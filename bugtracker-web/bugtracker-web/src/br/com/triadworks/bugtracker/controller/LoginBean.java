package br.com.triadworks.bugtracker.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.service.Autenticador;
import br.com.triadworks.bugtracker.service.AutenticadorImpl;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String login;
	private String senha;
	@ManagedProperty("#{usuarioWeb}")
	private UsuarioWeb usuarioWeb;
	
	
	@ManagedProperty("#{autenticador}")
	private Autenticador autenticador;
	
	public void setAutenticador(Autenticador autenticador) {
		this.autenticador = autenticador;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public String logar() {
	//	Autenticador autenticador = new AutenticadorImpl();
		Usuario usuario = autenticador.autentica(login, senha);
		if (usuario != null) {
			usuarioWeb.loga(usuario);
			return "/pages/usuario/lista?faces-redirect=true";
		}
		return null;

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

}
