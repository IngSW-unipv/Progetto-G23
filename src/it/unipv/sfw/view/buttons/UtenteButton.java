package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

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
