package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni con
 * caratteristiche ulteriori chiamati UtenteButton.
 *
 * @author Jacopo Piccoli
 */

public class UtenteButton extends JButton {
	private int code;

	public UtenteButton(String string, int code) {
		super(string);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
