package it.unipv.sfw.view.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.view.buttons.PezzoMuseoButton;

/**
 * Classe che rappresenta il pannello contenente le informazioni di un oggetto
 * del museo.
 *
 * @author Federico Romano
 *
 */
public class MuseoItemPanel extends JPanel {

	private PezzoMuseoButton rimuoviButton;

	public MuseoItemPanel(Cimelio c, boolean isAdmin) {

		JLabel titolo_pezzo = new JLabel(c.getTipo() + " " + c.getAnno());
		titolo_pezzo.setFont(new java.awt.Font("Arial", 1, 18));

		JTextArea descr_pezzo = new JTextArea(5, 30);
		descr_pezzo.setEditable(false);
		descr_pezzo.setLineWrap(true);
		descr_pezzo.setWrapStyleWord(true);
		descr_pezzo.setFont(new java.awt.Font("Arial", 1, 15));
		descr_pezzo.setBorder(BorderFactory.createTitledBorder("Descrizione:"));
		descr_pezzo.setOpaque(false);
		descr_pezzo.setText(c.getDescrizione());

		JPanel column_pezzo = new JPanel();
		column_pezzo.setLayout(new GridLayout(2, 1));
		column_pezzo.setPreferredSize(new Dimension(500, 200));

		if (isAdmin) {
			JPanel firstRawPanel = new JPanel();

			rimuoviButton = new PezzoMuseoButton("RIMUOVI", c);
			rimuoviButton.setBackground(Color.WHITE);
			rimuoviButton.setPreferredSize(new Dimension(100, 25));

			firstRawPanel.setLayout(new BorderLayout());
			firstRawPanel.add(titolo_pezzo, BorderLayout.CENTER);
			firstRawPanel.add(rimuoviButton, BorderLayout.EAST);
			column_pezzo.add(firstRawPanel);
		} else {
			column_pezzo.add(titolo_pezzo);
		}
		column_pezzo.add(descr_pezzo);

		ImageIcon image_pezzo = new ImageIcon(getClass().getResource("/museo/" + c.getImgid()));
		image_pezzo = new ImageIcon(image_pezzo.getImage().getScaledInstance(100, 180, java.awt.Image.SCALE_SMOOTH));
		JLabel image = new JLabel();
		image.setIcon(image_pezzo);

		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.add(image);
		this.add(column_pezzo);
	}

	public MuseoItemPanel(Riconoscimento r, boolean isAdmin) {

		JLabel titolo_pezzo = new JLabel(r.getTipo() + " " + r.getAnno());
		titolo_pezzo.setFont(new java.awt.Font("Arial", 1, 18));

		JTextArea descr_pezzo = new JTextArea(5, 30);
		descr_pezzo.setEditable(false);
		descr_pezzo.setLineWrap(true);
		descr_pezzo.setWrapStyleWord(true);
		descr_pezzo.setFont(new java.awt.Font("Arial", 1, 15));
		descr_pezzo.setBorder(BorderFactory.createTitledBorder("Descrizione:"));
		descr_pezzo.setOpaque(false);
		descr_pezzo.setText(r.getDescrizione());

		JPanel column_pezzo = new JPanel();
		column_pezzo.setLayout(new GridLayout(2, 1));
		column_pezzo.setPreferredSize(new Dimension(500, 200));

		if (isAdmin) {
			JPanel firstRawPanel = new JPanel();

			rimuoviButton = new PezzoMuseoButton("RIMUOVI", r);
			rimuoviButton.setBackground(Color.WHITE);
			rimuoviButton.setPreferredSize(new Dimension(100, 25));

			firstRawPanel.setLayout(new BorderLayout());
			firstRawPanel.add(titolo_pezzo, BorderLayout.CENTER);
			firstRawPanel.add(rimuoviButton, BorderLayout.EAST);
			column_pezzo.add(firstRawPanel);
		} else {
			column_pezzo.add(titolo_pezzo);
		}
		column_pezzo.add(descr_pezzo);

		ImageIcon image_pezzo = new ImageIcon(getClass().getResource("/museo/" + r.getImgid()));
		image_pezzo = new ImageIcon(image_pezzo.getImage().getScaledInstance(100, 180, java.awt.Image.SCALE_SMOOTH));
		JLabel image = new JLabel();
		image.setIcon(image_pezzo);

		this.setBorder(BorderFactory.createLineBorder(Color.black));

		this.add(image);
		this.add(column_pezzo);
	}

	/**
	 * @return Il bottone "RIMUOVI".
	 */
	public PezzoMuseoButton getRimuoviButton() {
		return rimuoviButton;
	}

}
