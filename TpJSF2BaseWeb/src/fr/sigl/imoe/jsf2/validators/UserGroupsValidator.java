package fr.sigl.imoe.jsf2.validators;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import fr.sigl.imoe.jsf2.dto.Groupe;

@FacesValidator(value="userGroupsValidator")
public class UserGroupsValidator implements Validator 
{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException 
	{
		if (arg2 != null)
		{
			@SuppressWarnings("unchecked")
			List<Groupe> grps = (List<Groupe>)arg2;
			
			if (grps.isEmpty())
			{
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Groupes utilisateur incorrect", "L'utilisateur doit appartenir à au moins un groupe.");
	            throw new ValidatorException(message);					
			}
		}
		else
		{
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Groupes utilisateur incorrect", "L'utilisateur doit appartenir à au moins un groupe.");
            throw new ValidatorException(message);			
		}

	}

}
