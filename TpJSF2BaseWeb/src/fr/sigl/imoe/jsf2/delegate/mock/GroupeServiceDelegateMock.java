package fr.sigl.imoe.jsf2.delegate.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import fr.sigl.imoe.jsf2.delegate.GroupeServiceDelegate;
import fr.sigl.imoe.jsf2.dto.Groupe;

@ApplicationScoped
@Alternative
public class GroupeServiceDelegateMock implements GroupeServiceDelegate 
{
	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Groupe> groupes = new ArrayList<Groupe>();

	private int identifiant = 0;
	
	@PostConstruct
	public void init()
	{
		Groupe groupeAdmin = new Groupe();
		groupeAdmin.setId(identifiant++);
		groupeAdmin.setNom("Administrateur");
		groupeAdmin.setDescription("Le groupe des administrateurs");
		groupes.add(groupeAdmin);
	}
	
	@Override
	public List<Groupe> listerTousGroupe() 
	{
		// TODO Auto-generated method stub
		return groupes;
	}

	@Override
	public Groupe retrouverGroupePParId(Integer Id) 
	{
		for (Groupe groupe : groupes) 
		{
			if (groupe.getId().equals(Id))
			{
				return groupe;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Groupe retrouverGroupeParNom(String nom) 
	{
		for (Groupe groupe : groupes) 
		{
			if (groupe.getNom().equals(nom))
			{
				return groupe;
			}
		}
		return null;
	}

	@Override
	public Groupe sauvegarderGroupe(Groupe groupe) 
	{
		boolean inCreation = false;
		Groupe groupeASauvegarder = null;
		if (groupe.getId() != null)
		{
			groupeASauvegarder = retrouverGroupePParId(groupe.getId());
			if (groupeASauvegarder == null)
			{
				throw new IllegalStateException("Edition d'un groupe inexistant dans le bouchon");
			}
		}
		else
		{
			inCreation = true;
			groupeASauvegarder = new Groupe();
			groupeASauvegarder.setId(identifiant++);
		}
		groupeASauvegarder.setNom(groupe.getNom());
		groupeASauvegarder.setDescription(groupe.getDescription());
		if (inCreation)
		{
			groupes.add(groupeASauvegarder);
		}
		
		return groupeASauvegarder;
	}

}
