package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayoutInfo;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.pagamento.Carta;
import it.unipv.sfw.view.elements.CartItemPanel;

public class PagamentoView extends AView{
	
	private Carta carta;
	private JButton carrelloBtn, okBtn;
	private JTextField nCartaTxt, cvvTxt;
	private JCheckBox salvaCb;
	private JOptionPane meseOp, annoOp;
	private JPanel centralPanel, infoPanel;
	
	public PagamentoView(Dimension dim) {
		// Fonts
		Font largeFont = new Font("Arial", 1, 18);
		Font veryLargeFont = new Font("Arial", 1, 24);
		
		// Top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel topPanelLbl = new JPanel();
		topPanelLbl.setBackground(Color.BLUE);
		topPanelLbl.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		JLabel utente = new JLabel("Utente loggato:   " + Sessione.getIstance().getCurrentUtente().getNome() + " " + Sessione.getIstance().getCurrentUtente().getCognome());
		utente.setFont(veryLargeFont);
		utente.setBackground(Color.BLUE);
		utente.setOpaque(true);
		
		topPanelLbl.add(utente);
		
		topPanel.add(topPanelLbl, BorderLayout.CENTER);
				
		// Center panel
		centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Pagamento:");
		title.setFont(veryLargeFont);
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		centralPanel.add(title, BorderLayout.NORTH);
				
				// Info panel
				infoPanel = new JPanel();
				
				JLabel numero = new JLabel("Numero:");
				numero.setFont(largeFont);
				JLabel scadenza = new JLabel("Scadenza:");
				scadenza.setFont(largeFont);
				JLabel cvv = new JLabel("CVV:");
				cvv.setFont(largeFont);
				
				nCartaTxt = new JTextField();
				JTextField f = new JTextField();
				cvvTxt = new JTextField();
				
				infoPanel.setLayout(new GridLayout(3, 2, 100, 0));
				infoPanel.add(numero);
				infoPanel.add(nCartaTxt);
				infoPanel.add(scadenza);
				infoPanel.add(f);
				infoPanel.add(cvv);
				infoPanel.add(cvvTxt);
				
				centralPanel.add(infoPanel);
				
		//Bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel bottomPanelBtns = new JPanel();
		bottomPanelBtns.setBackground(Color.BLUE);
		bottomPanelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		carrelloBtn = new JButton("CARRELLO");
		carrelloBtn.setBackground(Color.WHITE);
		carrelloBtn.setFont(largeFont);
		okBtn = new JButton("CONFERMA");
		okBtn.setBackground(Color.WHITE);
		okBtn.setFont(largeFont);
		
		bottomPanelBtns.add(carrelloBtn);
		bottomPanelBtns.add(okBtn);
		
		bottomPanel.add(bottomPanelBtns, BorderLayout.CENTER);
				
				
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}

	@Override
	public Type getType() {
		return null;
	}

}
