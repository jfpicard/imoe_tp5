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
	
	private Groupe groupeEnEdition;
	
	private Groupe groupeEnAddition;
	
	public Groupe getGroupeEnAddition() 
	{
		return groupeEnAddition;
	}

	public void setGroupeEnAddition(Groupe groupeEnAddition) 
	{
		this.groupeEnAddition = groupeEnAddition;
	}

	public Groupe getGroupeEnEdition() 
	{
		return groupeEnEdition;
	}

	public void setGroupeEnEdition(Groupe groupeEnEdition) 
	{
		this.groupeEnEdition = groupeEnEdition;
	}

	@PostConstruct
	public void init()
	{
		groupes = service.listerTousGroupe();
	}
	
	public List<Groupe> getGroupes()
	{
		return groupes;
	}
	
	public String add()
	{
		groupeEnEdition = null;
		groupeEnAddition = new Groupe();
		return null;
	}
	
	public String validerAdd()
	{
		service.sauvegarderGroupe(groupeEnAddition);
		groupes = service.listerTousGroupe();
		groupeEnAddition = null;
		return null;
	}
	
	public String annulerAdd()
	{
		groupes = service.listerTousGroupe();
		groupeEnAddition = null;
		return null;
	}
	
	public String edit(Integer id)
	{
		groupeEnAddition = null;
		groupeEnEdition = service.retrouverGroupeParId(id);
		return null;
	}
	
	public String validerEdition()
	{
		service.sauvegarderGroupe(groupeEnEdition);
		groupes = service.listerTousGroupe();
		groupeEnEdition = null;
		return null;
	}
	
	public String annulerEdition()
	{
		groupes = service.listerTousGroupe();
		groupeEnEdition = null;
		return null;
	}
}
