package fr.sigl.imoe.jsf2.actions;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.sigl.imoe.jsf2.delegate.GroupeServiceDelegate;
import fr.sigl.imoe.jsf2.dto.Groupe;

@SessionScoped
@Named("groupesAction")
public class GroupesAction implements Serializable
{

	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private GroupeServiceDelegate service;
	
	private List<Groupe> groupes;
	
	private Groupe groupeEdition;
	
	public Groupe getGroupeEdition() {
		return groupeEdition;
	}

	public void setGroupeEdition(Groupe groupeEdition) {
		this.groupeEdition = groupeEdition;
	}

	@PostConstruct
	public void init()
	{
		groupes = service.listerTousGroupe();
	}
	
	public List<Groupe> getGroupe()
	{
		return groupes;
	}
	
	public String edit(Integer id)
	{
		groupeEdition = service.retrouverGroupePParId(id);
		return null;
	}
	
	public String validerEdition()
	{
		service.sauvegarderGroupe(groupeEdition);
		groupes = service.listerTousGroupe();
		groupeEdition = null;
		return null;
	}
	
	public String annulerEdition()
	{
		groupes = service.listerTousGroupe();
		groupeEdition = null;
		return null;
	}
}
