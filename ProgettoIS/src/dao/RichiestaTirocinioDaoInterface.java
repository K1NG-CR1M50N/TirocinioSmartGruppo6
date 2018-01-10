package dao;

import java.util.ArrayList;

import bean.RichiestaTirocinio;

public interface RichiestaTirocinioDaoInterface {
	
	/**
	 *	Invia una richiesta di tirocinio
	 * 
	 * @param richiestaTirocinio: la Richiesta di Tirocinio da inviare
	 * 
	 * @return true se la richiesta di tirocinio � stata inviata con successo, false altrimenti
	 */
	
	public boolean invioRichiestaTirocinio( RichiestaTirocinio richiestaTirocinio);
	
	/**
	 *  *  Approva una richiesta di tirocinio
	 * 
	 * @param richiestaTirocinio:
	 * @return true se la richiesta � stata approvata con successo, false altrimenti
	 */
	
	public boolean approvazioneRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio);
	
	public ArrayList<RichiestaTirocinio> getRichiesteTirocinio();

	boolean getRichTirocinio(String matricola);

}
