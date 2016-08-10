package br.com.triadworks.bugtracker.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtil;


//@ViewScoped
@ManagedBean
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios;
	
	@ManagedProperty("#{usuarioDao}")
	private UsuarioDao dao;
	
	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public void adiciona(){
		//UsuarioDao dao = new UsuarioDao();
		dao.adiciona(this.usuario);
		this.usuario = new Usuario();
		new FacesUtil().adicionaMensagemDeSucesso("Usuário adicionado com sucesso!!");
	}
	
	public void lista(){
		//UsuarioDao dao = new UsuarioDao();
		this.usuarios = dao.lista();
		//new FacesUtil().adicionaMensagemDeSucesso("Usuário adicionado com sucesso!!");
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios){
		this.usuarios = usuarios;
	}
	
	public void remove(Usuario usuario){
		//UsuarioDao dao = new UsuarioDao();
		dao.remove(usuario);
		this.usuarios = dao.lista();
		new FacesUtil().adicionaMensagemDeSucesso("Usuário removido com sucesso!!");
	}
	
	public void altera(){
		//UsuarioDao dao = new UsuarioDao();
		dao.atualiza(this.usuario);
		new FacesUtil().adicionaMensagemDeSucesso("Usuário atualizado com sucesso!!");
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

}
 