package it.unipv.sfw.view.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni
 * con caratteristiche ulteriori chiamati AnelloButton.
 *
 * @author Jacopo Piccoli
 */
public class SquadraButton extends JButton {
	private int uso;

	public SquadraButton(ImageIcon img) {
		super(img);
	}

	
	public void modificaImg(ImageIcon img) {
		this.setIcon(img);
	}

	public int getUso() {
		return uso;
	}

	public void setUso(int uso) {
		this.uso = uso;
	}

}
