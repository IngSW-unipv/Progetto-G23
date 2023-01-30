package it.unipv.sfw.view;



import javax.swing.JPanel;

public abstract class AView extends JPanel {
	public enum Type {
		LOGIN,
		REGISTRAZIONE,
		PARTITE,
		SETTORE,
		ANELLO,
		POSTO,
		BLOCCO
	}
	
	public abstract Type getType();
}
