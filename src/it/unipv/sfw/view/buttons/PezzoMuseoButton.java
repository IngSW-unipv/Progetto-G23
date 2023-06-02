package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;

public class PezzoMuseoButton extends JButton {
	
	private int id;
	private int nPanel;

	public PezzoMuseoButton(String string, Riconoscimento r) {
		super(string);
		this.id = r.getId();
	}
	
	public PezzoMuseoButton(String string, Cimelio c) {
		super(string);
		this.id = c.getId();
	}

	public int getId() {
		return id;
	}
}
