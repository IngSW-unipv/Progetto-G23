package it.unipv.sfw.view.buttons;

import javax.swing.JButton;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;

/**
 * Classe per bottone del museo.
 * 
 * @author Federico Romano
 *
 */
public class PezzoMuseoButton extends JButton {
	
	private int id;
	private int nPanel;

	/**
	 * @param string Nome del bottone
	 * @param r Riconoscimento associato al bottone.
	 */
	public PezzoMuseoButton(String string, Riconoscimento r) {
		super(string);
		this.id = r.getId();
	}
	
	/**
	 * @param string Nome del bottone
	 * @param r Cimelio associato al bottone.
	 */
	public PezzoMuseoButton(String string, Cimelio c) {
		super(string);
		this.id = c.getId();
	}

	/**
	 * @return L'id dell'oggetto asscoiato al bottone.
	 */
	public int getId() {
		return id;
	}
}
