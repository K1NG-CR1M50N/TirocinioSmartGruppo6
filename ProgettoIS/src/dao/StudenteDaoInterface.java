package dao;

import bean.Studente;

public interface StudenteDaoInterface {

	/**
	 *  registra uno studente
	 */
	public boolean registerUser(Studente user);
	
	/**
	 * controllo login
	 */
	public boolean loginUser(Studente user);
}