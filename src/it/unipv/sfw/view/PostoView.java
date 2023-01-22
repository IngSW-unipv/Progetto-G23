package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.view.buttons.PostoButton;

public class PostoView extends AView {

	private JPanel blocco;
	private ArrayList<PostoButton> posto;
	private ArrayList<JLabel> nomeposto;
	private ArrayList<JPanel> gruppo;
	private Icon img;

	public PostoView(int posti) {

		blocco = new JPanel();
		gruppo = new ArrayList<JPanel>();
		posto = new ArrayList<PostoButton>();
		nomeposto = new ArrayList<JLabel>();

		img = new ImageIcon(getClass().getResource("/Posto.gif"));

		for (int i = 0; i < posti; i++) {
			posto.add(new PostoButton(i + 1, img, true));
			nomeposto.add(new JLabel("" + (i + 1)));
			nomeposto.get(i).setBackground(Color.red);
			gruppo.add(new JPanel());

		}

		for (int i = 0; i < posti; i++) {
			gruppo.get(i).setLayout(new BorderLayout());
			gruppo.get(i).add(posto.get(i), BorderLayout.CENTER);
			gruppo.get(i).add(nomeposto.get(i), BorderLayout.SOUTH);
			nomeposto.get(i).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			gruppo.get(i).setBackground(Color.GREEN);
			gruppo.get(i).setOpaque(true);

		}

		blocco.setLayout(new GridLayout(5, 10));

		for (JPanel j : gruppo) {
			j.setSize(50, 46);
			blocco.add(j);

		}
		blocco.setBorder(BorderFactory.createLineBorder(Color.black));

		this.add(blocco);

		this.setVisible(true);

	}

	public Collection<PostoButton> getAllButtons() {
		return posto;
	}

	@Override
	public Type getType() {
		return AView.Type.POSTO;
	}

}
