package it.unipv.sfw.view.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni con
 * caratteristiche ulteriori chiamati AnelloButton.
 *
 * @author Jacopo Piccoli
 */
public class AnelloButton extends JButton {
	private int code;
	private boolean stato;

	public AnelloButton(int code, ImageIcon img, boolean stato, boolean isEnabled) {
		super(img);
		this.code = code;
		this.stato = stato;
		this.setEnabled(isEnabled);
	}

	public int getCode() {
		return code;
	}

	public void modificaImg(ImageIcon img) {
		this.setIcon(img);
	}
}
