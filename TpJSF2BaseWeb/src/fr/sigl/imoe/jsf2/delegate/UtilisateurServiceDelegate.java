package fr.sigl.imoe.jsf2.delegate;

import java.io.Serializable;
import java.util.List;

import fr.sigl.imoe.jsf2.dto.Utilisateur;

public interface UtilisateurServiceDelegate extends Serializable
{
	List<Utilisateur> ListerTousUtilisateurs();
	
	Utilisateur retrouverUtilisateurParLogin(String login);
	
	Utilisateur sauvegarderUtilisateur(Utilisateur utilisateur);
}
