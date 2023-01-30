package it.unipv.sfw.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.view.buttons.SectorButton;


/**
 * Classe che crea la view degli 8 settori del campo. 
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.SectorButton
 */

public class SectorView extends AView {

	private JPanel middle, north, east, south, west, prova, settori;
	private JLabel campo;
	private Image img;
	private ArrayList<SectorButton> s;

	public SectorView() {

		middle = new JPanel();
		campo = new JLabel();
		north = new JPanel();
		east = new JPanel();
		south = new JPanel();
		west = new JPanel();
		prova = new JPanel();
		settori = new JPanel();

		s = new ArrayList<SectorButton>();

		for (int i = 0; i < 8; i++) {
			if (i == 0 || i == 1 || i == 4 || i == 5) {
				s.add(new SectorButton("<html>SETTORE " + (i + 1) + "</html>", i + 1, true));
			} else {
				s.add(new SectorButton(
						"<html> S <br> E <br> T <br> T< <br> O <br> R <br> E <br><br> " + (i + 1) + " </html>", i + 1,
						true));
			}

		}

		img = new ImageIcon(this.getClass().getResource("/Campo2.jpg")).getImage();
		campo.setIcon(new ImageIcon(img));

		middle.add(campo);

		north.setLayout(new GridLayout(1, 2));
		s.get(0).setBackground(Color.red);
		s.get(0).setOpaque(true);
		north.add(s.get(0));

		s.get(1).setBackground(Color.lightGray);
		s.get(1).setOpaque(true);
		north.add(s.get(1));

		east.setLayout(new GridLayout(2, 1));
		s.get(2).setBackground(Color.blue);
		s.get(2).setOpaque(true);
		east.add(s.get(2));

		s.get(3).setBackground(Color.cyan);
		s.get(3).setOpaque(true);
		east.add(s.get(3));

		south.setLayout(new GridLayout(1, 2));
		s.get(5).setBackground(Color.pink);
		s.get(5).setOpaque(true);
		south.add(s.get(5));

		s.get(4).setBackground(Color.magenta);
		s.get(4).setOpaque(true);
		south.add(s.get(4));

		west.setLayout(new GridLayout(2, 1));
		s.get(7).setBackground(Color.yellow);
		s.get(7).setOpaque(true);
		west.add(s.get(7));

		s.get(6).setBackground(Color.green);
		s.get(6).setOpaque(true);
		west.add(s.get(6));

		prova.setLayout(new BorderLayout());
		prova.add(north, BorderLayout.NORTH);
		prova.add(campo, BorderLayout.CENTER);
		prova.add(south, BorderLayout.SOUTH);

		settori.setLayout(new BorderLayout());
		settori.add(west, BorderLayout.WEST);
		settori.add(prova, BorderLayout.CENTER);
		settori.add(east, BorderLayout.EAST);

		this.add(settori);

	}

	public Collection<SectorButton> getSectorButtons() {
		return s;
	}

	@Override
	public Type getType() {
		return AView.Type.SETTORE;
	}

}
