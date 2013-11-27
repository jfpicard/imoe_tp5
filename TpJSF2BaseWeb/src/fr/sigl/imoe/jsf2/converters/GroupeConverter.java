package fr.sigl.imoe.jsf2.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import fr.sigl.imoe.jsf2.actions.GroupesAction;
import fr.sigl.imoe.jsf2.dto.Groupe;

@FacesConverter(value="groupeConverter", forClass=fr.sigl.imoe.jsf2.dto.Groupe.class)
public class GroupeConverter implements Converter 
{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) 
	{
		try
		{
			@SuppressWarnings("deprecation")
			GroupesAction ga = (GroupesAction)arg0.getApplication().getVariableResolver().resolveVariable(arg0, "groupesAction");
			for (Groupe g : ga.getGroupes()) 
			{
				if (g.toString().equals(arg2))
					return g;
			}
			return null;
		}
		catch (Exception e)
		{
			return new ConverterException(e.getMessage());
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) 
	{
		return ((Groupe)arg2).toString();
	}

}
