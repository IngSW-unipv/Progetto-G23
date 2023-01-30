package it.unipv.sfw.view.buttons;

import javax.swing.Icon;
import javax.swing.JButton;
/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni
 * con caratteristiche ulteriori chiamati PostoButton.
 *
 * @author Jacopo Piccoli
 */
public class PostoButton extends JButton {
	private int code;
	private boolean stato;

	public PostoButton(int code, Icon img, boolean stato) {
		this.code = code;
		this.setIcon(img);
	}

	public int getCode() {
		return code;
	}

}
