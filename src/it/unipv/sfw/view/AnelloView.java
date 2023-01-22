package it.unipv.sfw.view;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import it.unipv.sfw.view.buttons.AnelloButton;

public class AnelloView extends AView {

	private final int n_anelli = 3;
	private JPanel anelli;
	private ArrayList<AnelloButton> a;
	private Icon img;

	public AnelloView() {

		anelli = new JPanel();
		anelli.setLayout(new GridLayout(3, 1));

		img = new ImageIcon(getClass().getResource("/Spalti.gif"));

		a = new ArrayList<>();

		for (int i = 0; i < n_anelli; i++) {
			a.add(new AnelloButton(i + 1, img, true));
			a.get(i).setSize(500, 110);
			anelli.add(a.get(i));
		}

		this.add(anelli, BorderLayout.CENTER);

	}

	public Collection<AnelloButton> getButtons() {
		return a;
	}

	@Override
	public Type getType() {
		return AView.Type.ANELLO;
	}

}
