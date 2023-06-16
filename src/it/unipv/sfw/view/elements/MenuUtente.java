package it.unipv.sfw.view.elements;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * Classe che rappresenta il menu utente.
 *
 * @author Jacopo Piccoli, Federico Romano
 *
 */
public class MenuUtente extends JMenuBar {

	private JMenu menuutente;
	private JMenuItem esci, pp;

	public MenuUtente() {

		menuutente = new JMenu("");
		esci = new JMenuItem("Esci");
		pp = new JMenuItem("Profilo Personale");

		ImageIcon img = new ImageIcon(getClass().getResource("/utente.gif"));

		menuutente.setIcon(img);
		menuutente.setBackground(Color.BLUE);

		menuutente.add(pp);
		menuutente.add(esci);
		this.add(menuutente);

	}

	/**
	 * @return Il tasto "esci".
	 */
	public JMenuItem getExit() {
		return esci;
	}

	/**
	 * @return Il menu.
	 */
	public JMenu getMenuButton() {
		return menuutente;
	}

	/**
	 * @return Il tasto "profilo personale".
	 */
	public JMenuItem getProfiloPersonale() {
		return pp;
	}
}
