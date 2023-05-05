package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

/**
 * Bottone personalizzato per i pulsanti "ACQUISTA".
 * 
 * @author Gabriele Invernizzi
 */
public class AcquistaButton extends JButton {
	private int merchCode;
	
	public AcquistaButton(int merchCode) {
		super("ACQUISTA");
		this.merchCode = merchCode;
	}
	
	/**
	 * @return ID merch.
	 */
	public int getMerchCode() {
		return merchCode;
	}
}
