package fr.eni.EnchereEtEnOs.dal;

import fr.eni.EnchereEtEnOs.BusinessException;
import fr.eni.EnchereEtEnOs.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public Utilisateur getUtilisateurByPseudo(String pseudo) throws BusinessException;
	public Utilisateur getUtilisateurByMail(String mail) throws BusinessException;
}
