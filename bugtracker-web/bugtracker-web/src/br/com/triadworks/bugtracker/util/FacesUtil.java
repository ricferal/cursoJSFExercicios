package br.com.triadworks.bugtracker.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	private FacesContext facesContext;
	
	public FacesUtil() {
		this.facesContext = FacesContext.getCurrentInstance();
	}
	
	public void adicionaMensagemDeErro(String mensagem){
		FacesMessage faceMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,mensagem);
		facesContext.addMessage(null, faceMessage);
	}
	
	public void adicionaMensagemDeSucesso(String mensagem){
		FacesMessage faceMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,mensagem);
		facesContext.addMessage(null, faceMessage);
	}


}
