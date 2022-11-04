package br.com.devicesControl.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public abstract class AbstractFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public void addMessageInfo(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public void addMessageWarn(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,mensagem,null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public void addMessageError(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	public ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public String redirecionaPagina(String nomePagina){
		return nomePagina + "?faces-redirect=true";
	}
}
