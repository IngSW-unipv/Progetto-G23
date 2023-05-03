package it.unipv.sfw.view.buttons;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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

	public PostoButton(int code, ImageIcon img, boolean stato) {
		super(img);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public void modificaImg(ImageIcon img) {
		this.setIcon(img);
	}

}
