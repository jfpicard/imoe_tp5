package fr.sigl.imoe.jsf2.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="differentLoginPasswordValidator")
public class DifferentLoginPasswordValidator implements Validator 
{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException 
	{
		String login = arg2.toString();

		UIInput uiInputUserPassword = null;
		
		if (arg1.getAttributes().get("userPassword") != null)
		{
			uiInputUserPassword = (UIInput) arg1.getAttributes().get("userPassword");
		}
		if (arg1.getAttributes().get("userToAddPassword") != null)
		{
			uiInputUserPassword = (UIInput) arg1.getAttributes().get("userToAddPassword");
		}		

		String userPassword = uiInputUserPassword.getSubmittedValue().toString();

		if (login.equals(userPassword)) 
		{
			uiInputUserPassword.setValid(false);
			throw new ValidatorException(new FacesMessage("Le login et le mot de passe doivent être différents."));
		}
	 
	}

}
