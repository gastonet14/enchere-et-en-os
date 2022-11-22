package fr.eni.EnchereEtEnOs.dal;

import fr.eni.EnchereEtEnOs.dal.jdbc.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
}
	