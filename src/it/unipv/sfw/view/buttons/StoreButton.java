package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

/**
 * Bottone personalizzato per i pulsanti presenti nello store e nel carrello.
 * 
 * @author Gabriele Invernizzi
 */
public class StoreButton extends JButton {
	private int merchCode;
	
	public StoreButton(String label, int merchCode) {
		super(label);
		this.merchCode = merchCode;
	}
	
	/**
	 * @return ID merch.
	 */
	public int getMerchCode() {
		return merchCode;
	}
}
