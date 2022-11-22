package fr.eni.EnchereEtEnOs.dal;

public abstract class DAOFactory {
	
	public static ListeCourseDAO getListeCourseDAO()
	{
		return new ListeCourseDAOJdbcImpl();
	}
}
	