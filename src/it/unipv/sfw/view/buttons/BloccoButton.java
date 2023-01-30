package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni
 * con caratteristiche ulteriori chiamati BloccoButton.
 *
 * @author Jacopo Piccoli
 */

public class BloccoButton extends JButton {
	private int code;
	private boolean stato;

	public BloccoButton(String string, int code, boolean stato) {
		super(string);
		this.code = code;
		this.stato = stato;
	}

	public int getCode() {
		return code;
	}

}
