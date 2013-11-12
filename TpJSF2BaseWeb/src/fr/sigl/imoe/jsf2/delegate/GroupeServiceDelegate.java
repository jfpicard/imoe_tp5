package fr.sigl.imoe.jsf2.delegate;

import java.io.Serializable;
import java.util.List;

import fr.sigl.imoe.jsf2.dto.Groupe;

public interface GroupeServiceDelegate extends Serializable 
{
	List<Groupe> listerTousGroupe();
	
	Groupe retrouverGroupePParId(Integer Id);
	
	Groupe retrouverGroupeParNom(String nom);
	
	Groupe sauvegarderGroupe(Groupe groupe);
}
