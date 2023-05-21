package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.pagamento.Carta;
import it.unipv.sfw.view.elements.CartItemPanel;

public class PagamentoView extends AView{
	
	private Carta carta;
	private JButton backBtn, okBtn;
	private JTextField nCartaTxt, cvvTxt;
	private JCheckBox salvaCb;
	private JOptionPane meseOp, annoOp;
	private JPanel topPanel, centralPanel, bottomPanel;
	
	
	public PagamentoView(Dimension dim) {
		// Fonts
		Font largeFont = new Font("Arial", 1, 18);
		Font veryLargeFont = new Font("Arial", 1, 24);
		
		// Top panel
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel topPanelLabel = new JPanel();
		topPanelLabel.setBackground(Color.BLUE);
		topPanelLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		JLabel title = new JLabel("PAGAMENTO");
		title.setFont(veryLargeFont);
		title.setBackground(Color.BLUE);
		title.setOpaque(true);
		
		topPanelLabel.add(title);
		topPanel.add(topPanelLabel, BorderLayout.CENTER);
		
		// Center panel
		centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JLabel utente = new JLabel("Utente: " + Sessione.getIstance().getCurrentUtente().getNome() + " " + Sessione.getIstance().getCurrentUtente().getCognome());
		title.setFont(veryLargeFont);
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		centralPanel.add(title, BorderLayout.NORTH);
		
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}

	@Override
	public Type getType() {
		return null;
	}

}
