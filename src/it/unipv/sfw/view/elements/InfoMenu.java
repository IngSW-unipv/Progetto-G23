package it.unipv.sfw.view.elements;

import javax.swing.JMenu;

public class InfoMenu extends JMenu {

	private int code;

	public InfoMenu(String nome, int code) {
		super(nome);
		this.code = code;

	}

	public int getCode() {
		return code;
	}

}
