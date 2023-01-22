package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

public class SectorButton extends JButton {
	private int code;
	private boolean stato;  // sarà false se non ha posti disponibili in nessun blocco di nessun anello,
							// sarà true se non tutti i posti sono stati occupati

	public SectorButton(String string, int code, boolean stato) {
		super(string);
		this.code = code;
		this.stato = stato;
	}

	public int getCode() {
		return code;
	}

}
