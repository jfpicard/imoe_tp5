package fr.sigl.imoe.jsf2.delegate.mock;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import fr.sigl.imoe.jsf2.delegate.UtilisateurServiceDelegate;
import fr.sigl.imoe.jsf2.dto.Utilisateur;

@ApplicationScoped
@Alternative
public class UtilisateurServiceDelegateMock implements UtilisateurServiceDelegate 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	private int identifiant = 0;

	@PostConstruct
	public void init()
	{
		Utilisateur user = new Utilisateur();
		user.setId(identifiant++);
		user.setLogin("admin");
		user.setPassword("password");
		user.setEmail("admin@imoe.fr");
		utilisateurs.add(user);	
	}
	
	@Override
	public List<Utilisateur> ListerTousUtilisateurs() 
	{
		return utilisateurs;
	}

	@Override
	public Utilisateur retrouverUtilisateurParId(Integer Id) 
	{
		for (Utilisateur user : utilisateurs) 
		{
			if (user.getId().equals(Id))
			{
				return user;
			}
		}
		return null;
	}
	
	@Override
	public Utilisateur retrouverUtilisateurParLogin(String login) 
	{
		for (Utilisateur u : utilisateurs)
		{
			if (u.getLogin().equals(login))
			{
				return u;
			}
		}
		return null;
	}

	@Override
	public Utilisateur sauvegarderUtilisateur(Utilisateur utilisateur) 
	{
		boolean inCreation = false;
		Utilisateur userToSave = null;
		if (utilisateur.getId() != null)
		{
			userToSave = retrouverUtilisateurParId(utilisateur.getId());
			if (userToSave == null)
			{
				throw new IllegalStateException("Edition d'un utilisateur inexistant dans le bouchon");
			}
		}
		else
		{
			inCreation = true;
			userToSave = new Utilisateur();
			userToSave.setId(identifiant++);
		}
		userToSave.setLogin(utilisateur.getLogin());
		userToSave.setPassword(utilisateur.getPassword());
		userToSave.setEmail(utilisateur.getEmail());
		userToSave.setGroupes(utilisateur.getGroupes());
		if (inCreation)
		{
			utilisateurs.add(userToSave);
		}
		
		return userToSave;
	}
}
