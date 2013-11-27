package fr.sigl.imoe.jsf2.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO représentation d'un utilisateur
 * 
 * @author JP
 */
public class Utilisateur implements Serializable 
{

	/**
	 * Generated serial UID.
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String login;
	
	private String password;
	
	private String email;
	
	private List<Groupe> groupes;
	
	public Integer getId() 
	{
		return id;
	}

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public List<Groupe> getGroupes() 
	{
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) 
	{
		this.groupes = groupes;
	}

	public static long getSerialversionuid() 
	{
		return serialVersionUID;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (login == null) 
		{
			if (other.login != null)
				return false;
		} 
		else if (!login.equals(other.login))
			return false;
		return true;
	}
	
	
}
