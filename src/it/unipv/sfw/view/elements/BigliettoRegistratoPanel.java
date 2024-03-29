package it.unipv.sfw.view.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.model.biglietto.BigliettoMuseo;

/**
 * Classe che rappresenta il pannello contenente le informazioni di un biglietto
 * per il museo venduto.
 *
 * @author Federico Romano.
 *
 */
public class BigliettoRegistratoPanel extends JPanel {

	public BigliettoRegistratoPanel(BigliettoMuseo b) {

		JPanel tabelPanel = new JPanel();
		tabelPanel.setLayout(new GridLayout(2, 2, 0, 5));
		tabelPanel.setPreferredSize(new Dimension(500, 70));

		// 1.1
		JPanel emailUtentePanel = new JPanel();
		emailUtentePanel.setLayout(new GridLayout(2, 1));

		JLabel email1_label = new JLabel("Email cliente: ");
		JLabel emailUtente1 = new JLabel(b.getEmail());

		emailUtentePanel.add(email1_label);
		emailUtentePanel.add(emailUtente1);

		// 1.2
		JPanel emailBigliettoPanel = new JPanel();
		emailBigliettoPanel.setLayout(new GridLayout(2, 1));

		JLabel email2_label = new JLabel("Email di ricezione conferma: ");
		JLabel emailUtente2 = new JLabel(b.getEmailConferma());

		emailBigliettoPanel.add(email2_label);
		emailBigliettoPanel.add(emailUtente2);

		// 2.1
		// vuoto

		// 2.2
		JLabel ricavoSingolo = new JLabel("Ricavo vendita: €" + b.getPrezzo());

		tabelPanel.add(emailUtentePanel);
		tabelPanel.add(emailBigliettoPanel);
		tabelPanel.add(ricavoSingolo);

		this.add(tabelPanel);

		this.setBorder(BorderFactory.createLineBorder(Color.black));

	}

}
