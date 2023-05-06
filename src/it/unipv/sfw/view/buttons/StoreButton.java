package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

import it.unipv.sfw.model.store.Merchandising;

/**
 * Bottone personalizzato per i pulsanti presenti nello store e nel carrello.
 * 
 * @author Gabriele Invernizzi
 */
public class StoreButton extends JButton {
	private Merchandising merch;
	
	public StoreButton(String label, Merchandising merch) {
		super(label);
		this.merch = merch;
	}
	
	/**
	 * @return merch.
	 */
	public Merchandising getMerch() {
		return merch;
	}
}
