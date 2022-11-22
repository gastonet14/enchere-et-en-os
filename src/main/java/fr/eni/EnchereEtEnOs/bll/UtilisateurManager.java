package fr.eni.EnchereEtEnOs.bll;

import fr.eni.EnchereEtEnOs.BusinessException;
import fr.eni.EnchereEtEnOs.bo.Utilisateur;
import fr.eni.EnchereEtEnOs.dal.DAOFactory;
import fr.eni.EnchereEtEnOs.dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;
	private static UtilisateurManager instance;

	private UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

	public void seConnecter(String identifiant, String mdp) throws BusinessException {
		Utilisateur user = null;
		if (identifiant.contains("@")) user = utilisateurDAO.getUtilisateurByMail(identifiant);
		else user= utilisateurDAO.getUtilisateurByPseudo(identifiant);
		
		if (user == null || !mdp.equals(user.getMot_de_passe())) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.IDENTIFIANT_KO);
			throw be;
		}

	}
}
