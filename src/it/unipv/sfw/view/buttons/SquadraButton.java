package it.unipv.sfw.view.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni con
 * caratteristiche ulteriori chiamati AnelloButton.
 *
 * @author Jacopo Piccoli
 */
public class SquadraButton extends JButton {
	private boolean stato;

	public SquadraButton(ImageIcon img, boolean stato) {
		super(img);
	}

	public boolean getUso() {
		return stato;
	}

	public void modificaImg(ImageIcon img) {
		this.setIcon(img);
	}

	public void setUso(boolean stato) {
		this.stato = stato;
	}

}
