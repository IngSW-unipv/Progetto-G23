package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.biglietti.Biglietto;
import it.unipv.sfw.model.biglietti.BigliettoMuseo;
import it.unipv.sfw.view.elements.BigliettoRegistratoPanel;

/**
 * View per il registro vendita dei biglietti del museo.
 * 
 * @author Federico Romano
 */
public class RegistroBigliettiMuseoView extends AView {
	
	private Dimension dim;
	private JButton backButton;
	
	public RegistroBigliettiMuseoView(ArrayList<BigliettoMuseo> biglietti , Dimension dim) {
		
		this.dim = dim;
		
		this.setLayout(new BorderLayout());
		
		ArrayList<BigliettoMuseo> venduti = biglietti;
		int nBiglietti = venduti.size();
		
		JLabel blue_label_up = new JLabel();
		blue_label_up.setLayout(new BorderLayout());
		blue_label_up.setPreferredSize(new Dimension(100,100));
		blue_label_up.setBackground(Color.BLUE);
		blue_label_up.setOpaque(true);
		blue_label_up.setHorizontalAlignment(JLabel.CENTER);
		blue_label_up.setBorder(BorderFactory.createLineBorder(Color.black));
		
		ImageIcon backpage = new ImageIcon(getClass().getResource("/backpage1.png"));
		backpage = new ImageIcon(backpage.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		backButton = new JButton("", backpage);
		backButton.setBackground(Color.BLUE);
		backButton.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		JLabel title = new JLabel("  REGISTRO VENDITE BIGLIETTI:");
		title.setForeground(Color.WHITE);
		title.setPreferredSize(new Dimension(200, 50));
		title.setFont(new java.awt.Font("Arial", 1, 26));
		title.setBackground(Color.BLUE);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		blue_label_up.add(backButton, BorderLayout.WEST);
		blue_label_up.add(title, BorderLayout.CENTER);
		
		JPanel registro = new JPanel();
		
		double ricaviCounter = 0;
		
		for(BigliettoMuseo b : venduti) {
			ricaviCounter += b.getPrezzo();
			BigliettoRegistratoPanel biglietto = new BigliettoRegistratoPanel(b);
			registro.add(biglietto);
		}
		
		JPanel ricavoTot = new JPanel();
		JLabel ricavoTot_label = new JLabel("RICAVO TOTALE: €" + ricaviCounter);
		ricavoTot_label.setFont(new java.awt.Font("Arial", 1, 16));
		ricavoTot.setLayout(new FlowLayout());
		ricavoTot.add(ricavoTot_label);
		
		registro.add(ricavoTot);
		
		registro.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (110*(nBiglietti)+50)));
		registro.setLayout(new FlowLayout(FlowLayout.CENTER, 800, 25));
		
		JScrollPane registroContainer = new JScrollPane(registro);
		registroContainer.getVerticalScrollBar().setUnitIncrement(20);
		
		this.add(blue_label_up, BorderLayout.NORTH);
		this.add(registroContainer, BorderLayout.CENTER);
		
	}
	
	/**
	 * @return Il bottone per tornare alla pagina precedente.
	 */
	public JButton getBackButton() {
		return backButton;
	}
	
}
