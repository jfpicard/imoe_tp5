package fr.sigl.imoe.jsf2.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="mailValidator")
public class MailValidator implements Validator 
{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException 
	{
		String email = String.valueOf(arg2);
        boolean valid = true;
        if (arg2 == null) 
        {
            valid = false;
        } 
        else if (!email.contains("@")) 
        {
            valid = false;
        } 
        else if (!email.contains(".")) 
        {
            valid = false;
        } 
        else if (email.contains(" ")) 
        {
            valid = false;
        }
        if (!valid) 
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Adresse mail invalide", "L'adresse email indiquée n'est pas valide.");
            throw new ValidatorException(message);
        }
	}

}
