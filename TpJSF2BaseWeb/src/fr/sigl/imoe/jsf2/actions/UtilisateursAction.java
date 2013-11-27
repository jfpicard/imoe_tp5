package fr.sigl.imoe.jsf2.actions;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.sigl.imoe.jsf2.delegate.UtilisateurServiceDelegate;
import fr.sigl.imoe.jsf2.dto.Utilisateur;

@SessionScoped
@Named("utilisateursAction")
public class UtilisateursAction implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UtilisateurServiceDelegate service;
	
	private List<Utilisateur> utilisateurs;
	
	private Utilisateur utilisateurEnEdition;
	
	private Utilisateur utilisateurEnAddition;
	
	@PostConstruct
	public void init()
	{
		utilisateurs = service.ListerTousUtilisateurs();
	}

	public String edit(Integer id)
	{
		utilisateurEnAddition = null;
		utilisateurEnEdition = service.retrouverUtilisateurParId(id);
		return null;
	}
	
	public String validerEdition()
	{
		service.sauvegarderUtilisateur(utilisateurEnEdition);
		utilisateurs = service.ListerTousUtilisateurs();
		utilisateurEnEdition = null;
		return null;
	}
	
	public String annulerEdition()
	{
		utilisateurs = service.ListerTousUtilisateurs();
		utilisateurEnEdition = null;
		return null;
	}
	
	public String add()
	{
		utilisateurEnEdition = null;
		utilisateurEnAddition = new Utilisateur();
		return null;
	}
	
	public String validerAdd()
	{
		service.sauvegarderUtilisateur(utilisateurEnAddition);
		utilisateurs = service.ListerTousUtilisateurs();
		utilisateurEnAddition = null;
		return null;
	}
	
	public String annulerAdd()
	{
		utilisateurs = service.ListerTousUtilisateurs();
		utilisateurEnAddition = null;
		return null;
	}
	
	public List<Utilisateur> getUtilisateurs() 
	{
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) 
	{
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur getUtilisateurEnEdition() 
	{
		return utilisateurEnEdition;
	}

	public void setUtilisateurEnEdition(Utilisateur utilisateurEnEdition) 
	{
		this.utilisateurEnEdition = utilisateurEnEdition;
	}

	public Utilisateur getUtilisateurEnAddition() 
	{
		return utilisateurEnAddition;
	}

	public void setUtilisateurEnAddition(Utilisateur utilisateurEnAddition) 
	{
		this.utilisateurEnAddition = utilisateurEnAddition;
	}

}
