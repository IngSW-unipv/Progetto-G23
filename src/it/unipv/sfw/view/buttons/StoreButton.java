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
	private int quantity;
	
	public StoreButton(String label, Merchandising merch, int quantity) {
		super(label);
		this.merch = merch;
		this.quantity = quantity;
	}
	
	/**
	 * @return Merch.
	 */
	public Merchandising getMerch() {
		return merch;
	}
	
	/**
	 * @return Merch quantity.
	 */
	public int getMerchQuantity() {
		return quantity;
	}
}
