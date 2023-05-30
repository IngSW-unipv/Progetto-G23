package it.unipv.sfw.view.elements;

import javax.swing.JMenu;

public class JInfoMenu extends JMenu{
	
	private int code;
	
	
	public JInfoMenu(String nome, int code) {
		super(nome);
		this.code=code;
		
	}

}
