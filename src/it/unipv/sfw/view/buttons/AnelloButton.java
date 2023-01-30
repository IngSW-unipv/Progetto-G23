package it.unipv.sfw.view.buttons;

import javax.swing.Icon;
import javax.swing.JButton;


/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni
 * con caratteristiche ulteriori chiamati AnelloButton.
 *
 * @author Jacopo Piccoli
 */
public class AnelloButton extends JButton {
	private int code;
	private boolean stato;

	public AnelloButton(int code, Icon img, boolean stato) {
		this.code = code;
		this.setIcon(img);
		this.stato = stato;
	}

	public int getCode() {
		return code;
	}

}
