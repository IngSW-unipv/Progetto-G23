package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

public class AcquistaButton extends JButton {
	private int merchCode;
	
	public AcquistaButton(int merchCode) {
		super("ACQUISTA");
		this.merchCode = merchCode;
	}
	
	public int getMerchCode() {
		return merchCode;
	}
}
