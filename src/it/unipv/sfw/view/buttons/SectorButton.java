package it.unipv.sfw.view.buttons;

import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * Classe che utilizza i JButton per creare dei nuovi bottoni
 * con caratteristiche ulteriori chiamati SectorButton.
 *
 * @author Jacopo Piccoli
 */

public class SectorButton extends JButton {
	private int code;
	private boolean stato;  // sarà false se non ha posti disponibili in nessun blocco di nessun anello,
							// sarà true se non tutti i posti sono stati occupati

	
	public SectorButton(String string, int code, boolean stato,ImageIcon img, boolean isEnabled) {
		super(string,img);
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
