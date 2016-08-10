package br.com.triadworks.bugtracker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Bug;
import br.com.triadworks.bugtracker.modelo.Status;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtil;

@ManagedBean
public class BugBean {
	private Bug bug = new Bug();
	
	private List<Bug> bugs = new ArrayList<Bug>();
	
	private List<Usuario> usuarios;
	
	@ManagedProperty("#{usuarioDao}")
	private UsuarioDao usuarioDao;
	
	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null){
			this.usuarios = usuarioDao.lista();
		}
		return usuarios;
	}
	
	@ManagedProperty("#{bugDao}")
	private BugDao dao;
	
	public void setDao(BugDao dao) {
		this.dao = dao;
	}
	 public List<Bug> getBugs() {
		return bugs;
	}
	 
	 public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}
	
	
	public void lista(){
		this.bugs = dao.lista();
		                        
	}
	
	public void remove(Bug bug){
		dao.remove(bug);
		this.bugs = dao.lista();
		new FacesUtil().adicionaMensagemDeSucesso("Bug removido com sucesso!");
	}
	
	
	public Bug getBug() {
		return bug;
	}
	
	@PostConstruct
	public void init(){
		this.bug.setResponsavel(new Usuario());
	}
	
	public void adiciona(){
		dao.salva(bug);
		this.bug = new Bug();
		new FacesUtil().adicionaMensagemDeSucesso("Bug adicionado com Sucesso!");
	}
	
	public List<Status> getTodosOsStatus(){
		return Arrays.asList(Status.values());
	}
	
	public void setBug(Bug bug) {
		this.bug = bug;
	}
	
	public void altera(){
		dao.atualiza(this.bug);
		new FacesUtil().adicionaMensagemDeSucesso("Bug atualizado com Sucesso!");
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	

}
