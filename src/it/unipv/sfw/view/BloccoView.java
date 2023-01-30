package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.unipv.sfw.view.buttons.BloccoButton;
/**
 * Classe che crea la view dei vari blocchi di un anello. 
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.BloccoButton
 */
public class BloccoView extends AView {

	private JPanel tabellone;
	private ArrayList<BloccoButton> blocco;
	private int b;

	public BloccoView(int ptot) {

		tabellone = new JPanel();
		blocco = new ArrayList<BloccoButton>();

		b = ptot / 50;

		for (int i = 0; i < b; i++) {
			blocco.add(new BloccoButton("Blocco " + (i + 1), i + 1, true));

		}

		tabellone.setLayout(new GridLayout((int) (b / 5), 5));

		for (JButton j : blocco) {

			j.setSize(40, 40);
			tabellone.add(j);
		}

		this.add(tabellone);
	}

	public Collection<BloccoButton> getAllBloccoButton() {
		return blocco;
	}

	@Override
	public Type getType() {
		return AView.Type.BLOCCO;
	}
}
