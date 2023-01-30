package it.unipv.sfw.view;



import javax.swing.JPanel;

/**
 * Classe astratta che rapresenta una view generica.
 *
 * @author Jacopo Piccoli
 */

public abstract class AView extends JPanel {
	/**
	 * Enumerazione che descrive il tipo di view.
	 */	
	public enum Type {
		LOGIN,
		REGISTRAZIONE,
		PARTITE,
		SETTORE,
		ANELLO,
		POSTO,
		BLOCCO
	}
	
	/**
	 *@return restituisce il tipo della classe
	 */	
	public abstract Type getType();
}
