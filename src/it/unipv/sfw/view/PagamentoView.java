package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayoutInfo;
import java.awt.GridLayout;
import java.awt.geom.Dimension2D;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.pagamento.Carta;
import it.unipv.sfw.view.elements.CartItemPanel;

public class PagamentoView extends AView{
	
	private Carta carta;
	private JButton carrelloBtn, okBtn;
	private JTextField scadenzaTxt, nomeTxt, cognomeTxt, nCartaTxt, cvvTxt;
	private JCheckBox salvaCb;
	private JOptionPane meseOp, annoOp;
	private JPanel centerPanel, centralPanel, infoPanel;
	
	public PagamentoView(Dimension dim) {
		// Fonts
		Font mediumFont = new Font("Arial", 1, 16);
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
				
				// Info panel
				infoPanel = new JPanel();
				
				JLabel nome = new JLabel("Nome:");
				nome.setFont(largeFont);
				JLabel cognome = new JLabel("Cognome:");
				cognome.setFont(largeFont);
				JLabel numero = new JLabel("Numero:");
				numero.setFont(largeFont);
				JLabel scadenza = new JLabel("Scadenza:");
				scadenza.setFont(largeFont);
				JLabel cvv = new JLabel("CVV:");
				cvv.setFont(largeFont);
				
				
				nomeTxt = new JTextField(Sessione.getIstance().getCurrentUtente().getCognome());
				cognomeTxt = new JTextField(Sessione.getIstance().getCurrentUtente().getCognome());
				nCartaTxt = new JTextField();
				scadenzaTxt = new JTextField();
				cvvTxt = new JTextField();
				
				infoPanel.setLayout(new GridLayout(5, 2, dim.width/12, 0));
				infoPanel.add(nome);
				infoPanel.add(nomeTxt);
				infoPanel.add(cognome);
				infoPanel.add(cognomeTxt);
				infoPanel.add(numero);
				infoPanel.add(nCartaTxt);
				infoPanel.add(scadenza);
				infoPanel.add(scadenzaTxt);
				infoPanel.add(cvv);
				infoPanel.add(cvvTxt);

				infoPanel.setBorder(new EmptyBorder(dim.height/5, dim.width/12, dim.height/5,  dim.width/12));
				
				centralPanel.setLayout(new BorderLayout());
				centralPanel.add(title, BorderLayout.NORTH);
				centralPanel.add(infoPanel, BorderLayout.CENTER);

				JPanel centerPanelBtns = new JPanel();
				centerPanelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
				
				carrelloBtn = new JButton("Carrello");
				carrelloBtn.setBackground(Color.WHITE);
				carrelloBtn.setFont(mediumFont);
				okBtn = new JButton("Conferma");
				okBtn.setBackground(Color.WHITE);
				okBtn.setFont(mediumFont);
				
				centerPanelBtns.add(carrelloBtn);
				centerPanelBtns.add(okBtn);
				
				centralPanel.add(centerPanelBtns, BorderLayout.SOUTH);
				
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
		
	}

	@Override
	public void onWindowResized(Dimension dim) {

		infoPanel.setBorder(new EmptyBorder(dim.height/5, 0, dim.height/5,  0));
	
		infoPanel.revalidate();
		infoPanel.repaint();
	}
	
	@Override
	public Type getType() {
		return null;
	}

}
