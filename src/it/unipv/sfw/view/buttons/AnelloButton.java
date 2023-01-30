package it.unipv.sfw.view.buttons;

import javax.swing.Icon;
import javax.swing.JButton;

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
