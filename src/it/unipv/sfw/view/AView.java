package it.unipv.sfw.view;



import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Classe astratta che rapresenta una view generica.
 *
 * @author Jacopo Piccoli, Gabriele Invernizzi
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
		BLOCCO, 
		STORE
	}
	
	/**
	 *@return Tipo della view.
	 */	
	public abstract Type getType();
	
	/**
	 * Fuzione chiamata quando viene attivato l'evento di window resize.
	 * {@link it.unipv.sfw.view.AView} la implementa vuota, per avere un comportamento diverso 
	 * deve essere sovrascritta dalle sottoclassi.
	 * @param dim Nuova dimensione della finestra.
	 */
	public void onWindowResized(Dimension dim) {}
}
