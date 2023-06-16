package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.unipv.sfw.model.partita.Stadio;
import it.unipv.sfw.view.buttons.AnelloButton;

/**
 * Classe che crea la view deli 3 anelli di ogni settore.
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.AnelloButton
 */
public class AnelloView extends AView {

	private JPanel contenitore;
	private ArrayList<AnelloButton> anello;
	private JButton homeBtn;
	private ArrayList<JLabel> idAnello;
	private ArrayList<JPanel> gruppo;
	private ImageIcon img;

	public AnelloView(Dimension dim, Stadio stadio, int n_settore) {

		Font largeFont = new Font("Arial", 1, 32);

		JLabel titolo = new JLabel("SELEZIONA UN ANELLO");
		titolo.setFont(largeFont);
		titolo.setHorizontalAlignment(SwingConstants.CENTER);
		titolo.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));

		homeBtn = new JButton();
		homeBtn.setIcon(new ImageIcon(getClass().getResource("/home.png")));

		JPanel title = new JPanel();
		title.setLayout(new BorderLayout());
		title.add(titolo, BorderLayout.CENTER);
		title.add(homeBtn, BorderLayout.EAST);

		anello = new ArrayList<>(Stadio.ANELLI_PER_SETTORE);
		idAnello = new ArrayList<>(Stadio.ANELLI_PER_SETTORE);
		gruppo = new ArrayList<>(Stadio.ANELLI_PER_SETTORE);

		for (int i = 0; i < Stadio.ANELLI_PER_SETTORE; i++) {
			gruppo.add(null);
			idAnello.add(null);
			anello.add(null);
		}

		img = new ImageIcon(this.getClass().getResource("/Spalti.JPG"));
		img = new ImageIcon(img.getImage().getScaledInstance((dim.width), (dim.height - 60) / 3,
				java.awt.Image.SCALE_SMOOTH));

		for (int i = 0; i < Stadio.ANELLI_PER_SETTORE; i++) {
			int n_anello = Stadio.ANELLI_PER_SETTORE - i - 1;
			boolean isLibero = stadio.isLibero(n_settore, n_anello + 1);
			anello.set(n_anello, new AnelloButton(n_anello + 1, img, true, isLibero));
			idAnello.set(n_anello, new JLabel("A" + (n_anello + 1)));
			idAnello.get(n_anello).setBackground(Color.red);
			gruppo.set(n_anello, new JPanel());

			gruppo.get(n_anello).setLayout(new BorderLayout());
			gruppo.get(n_anello).setPreferredSize(new Dimension((dim.width) / 10, (dim.height - 45) / 5));
			gruppo.get(n_anello).add(anello.get(n_anello), BorderLayout.CENTER);
			gruppo.get(n_anello).add(idAnello.get(n_anello), BorderLayout.SOUTH);
			idAnello.get(n_anello).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			if (isLibero)
				gruppo.get(n_anello).setBackground(Color.GREEN);
			else
				gruppo.get(n_anello).setBackground(Color.RED);
			gruppo.get(n_anello).setOpaque(true);
		}

		contenitore = new JPanel();
		contenitore.setPreferredSize(new Dimension(dim.width, (dim.height - 45)));
		contenitore.setLayout(new GridLayout(3, 1));

		for (JPanel j : gruppo) {
			contenitore.add(j);

		}

		this.setLayout(new BorderLayout());
		this.add(title, BorderLayout.NORTH);
		this.add(contenitore, BorderLayout.CENTER);

	}

	/**
	 * @return Bottoni selezione anello.
	 */
	public Collection<AnelloButton> getButtons() {
		return anello;
	}

	/**
	 * @return Bottone della Home.
	 */
	public JButton getHomeButton() {
		return homeBtn;
	}

	@Override
	public void onWindowResized(Dimension dim) {
		img = new ImageIcon(img.getImage().getScaledInstance((dim.width), (dim.height - 60) / 3,
				java.awt.Image.SCALE_SMOOTH));

		contenitore.setPreferredSize(new Dimension(dim.width, (dim.height - 45)));

		for (int i = 0; i < Stadio.ANELLI_PER_SETTORE; i++) {
			anello.get(i).modificaImg(img);
			anello.get(i).revalidate();
			gruppo.get(i).setPreferredSize(new Dimension((dim.width) / 10, (dim.height - 45) / 5));
			gruppo.get(i).revalidate();
			gruppo.get(i).revalidate();
			gruppo.get(i).repaint();
		}

		contenitore.revalidate();
		contenitore.repaint();
	}
}
