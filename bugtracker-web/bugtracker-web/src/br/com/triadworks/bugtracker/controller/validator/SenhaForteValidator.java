package br.com.triadworks.bugtracker.controller.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("senhaForte")
public class SenhaForteValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object o)
			throws ValidatorException {
		// TODO Auto-generated method stub
		
		String valor = o.toString();
        if(!valor.contains("@")){
        	FacesMessage msg = new FacesMessage();
        	msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        	msg.setSummary("Digite senha mais forte");
        	msg.setDetail("Insera caracter @ !!!");
        	throw new ValidatorException(msg);
        }
		
	}
	
	

}
