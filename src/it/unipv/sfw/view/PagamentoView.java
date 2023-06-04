package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayoutInfo;
import java.awt.GridLayout;
import java.awt.geom.Dimension2D;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
	
	private final int ANNO = 2023;
	
	private Carta carta;
	private JPanel infoPanel, btnsPanel;
	private JButton backBtn, okBtn;
	private JCheckBox salvaCb;
	private JTextField nomeTxt, cognomeTxt, nCartaTxt, cvvTxt;
	private JComboBox <Integer> meseOp, annoOp;
	
	public PagamentoView(Dimension dim) {
		// Fonts
		Font shortFont = new Font("Arial", 1, 14);
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 18);
		Font veryLargeFont = new Font("Arial", 1, 24);
		
		// Top panel
		JPanel topPanel = new JPanel();
		JPanel topPanelLbl = new JPanel();
		
		JLabel utente = new JLabel("Utente loggato:   " + Sessione.getIstance().getCurrentUtente().getNome() + " " + Sessione.getIstance().getCurrentUtente().getCognome());
		utente.setFont(veryLargeFont);
		utente.setBackground(Color.BLUE);
		utente.setOpaque(true);
		
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanelLbl.setBackground(Color.BLUE);
		topPanelLbl.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		topPanelLbl.add(utente);
		topPanel.add(topPanelLbl, BorderLayout.CENTER);
				
		// Center panel
		JPanel centralPanel = new JPanel();
		JPanel selectScadenza = new JPanel();
		JPanel centerPanelBtns = new JPanel();
		JPanel btnsPanel1 = new JPanel();
		JPanel btnsPanel2 = new JPanel();
		btnsPanel = new JPanel();
		infoPanel = new JPanel();
		
		centralPanel.setLayout(new BorderLayout());
		selectScadenza.setLayout(new GridLayout(1, 2));
		
		JLabel title = new JLabel("Pagamento:");
		title.setFont(veryLargeFont);
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel nome = new JLabel("Nome:");
		nome.setFont(largeFont);
		JLabel cognome = new JLabel("Cognome:");
		cognome.setFont(largeFont);
		JLabel numero = new JLabel("Numero:");
		numero.setFont(largeFont);
		JLabel scadenza = new JLabel("Scadenza (mm/aaaa):");
		scadenza.setFont(largeFont);
		JLabel cvv = new JLabel("CVV:");
		cvv.setFont(largeFont);
		
		Integer[] monthToChoose = new Integer[12];
		Integer[] yearToChoose = new Integer[11];
		
		for(int i=0; i<12; i++) {
			monthToChoose[i] = i+1;
		}
		for(int i=0; i<2; i++) {
			for(int i2=0; i2<5; i2++){
				if (i==0) yearToChoose[i2] = ANNO - (5 - i2);
				else yearToChoose[10 - i2] = ANNO + (5 - i2);
			}
		}
		yearToChoose[5] = ANNO;
		
		nomeTxt = new JTextField(Sessione.getIstance().getCurrentUtente().getCognome());
		cognomeTxt = new JTextField(Sessione.getIstance().getCurrentUtente().getCognome());
		nCartaTxt = new JTextField();
		cvvTxt = new JTextField();
		meseOp = new JComboBox<>(monthToChoose);
		annoOp = new JComboBox<>(yearToChoose);
		salvaCb = new JCheckBox("Salva metodo di pagamento");
		okBtn = new JButton("Conferma");
		if(Sessione.getIstance().getCurrentPagamento() == 1) backBtn = new JButton("Carrello");
		else if (Sessione.getIstance().getCurrentPagamento() == 2) backBtn = new JButton("Museo");
		else if (Sessione.getIstance().getCurrentPagamento() == 3) backBtn = new JButton("Home");
		else backBtn = new JButton("Profilo personale");
		
		meseOp.setSelectedIndex(0);
		annoOp.setSelectedIndex(5);
		salvaCb.setFont(shortFont);

		selectScadenza.add(meseOp);
		selectScadenza.add(annoOp);
		
		
		backBtn.setBackground(Color.WHITE);
		backBtn.setFont(mediumFont);
		okBtn.setBackground(Color.WHITE);
		okBtn.setFont(mediumFont);
		
		infoPanel.setLayout(new GridLayout(6, 2, dim.width/192, 1));
		infoPanel.add(nome);
		infoPanel.add(nomeTxt);
		infoPanel.add(cognome);
		infoPanel.add(cognomeTxt);
		infoPanel.add(numero);
		infoPanel.add(nCartaTxt);
		infoPanel.add(scadenza);
		infoPanel.add(selectScadenza);
		infoPanel.add(cvv);
		infoPanel.add(cvvTxt);
		infoPanel.add(salvaCb);
		infoPanel.setBorder(new EmptyBorder(dim.height/6, dim.width/7, dim.height/6,  dim.width/7));

		btnsPanel1.add(new JLabel("N.B. continuando riceverai una mail di conferma."));
		btnsPanel2.setLayout(new GridLayout(1, 2));
		btnsPanel2.add(backBtn);
		btnsPanel2.add(okBtn);

		btnsPanel.setLayout(new GridLayout(2, 1, dim.width/192, 3));
		btnsPanel.setBorder(new EmptyBorder(0, dim.width/7, 0,  dim.width/7));
		btnsPanel.add(btnsPanel1);
		btnsPanel.add(btnsPanel2);
		
		centerPanelBtns.setLayout(new BorderLayout());
		centerPanelBtns.add(btnsPanel);
		
		centralPanel.setLayout(new BorderLayout());
		centralPanel.add(title, BorderLayout.NORTH);
		centralPanel.add(infoPanel, BorderLayout.CENTER);
		centralPanel.add(centerPanelBtns, BorderLayout.SOUTH);
				
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
		
	}

	@Override
	public void onWindowResized(Dimension dim) {
		infoPanel.setBorder(new EmptyBorder(dim.height/6, dim.width/7, dim.height/6,  dim.width/7));
		btnsPanel.setBorder(new EmptyBorder(0, dim.width/7, 0,  dim.width/7));
		
		infoPanel.revalidate();
		btnsPanel.revalidate();
		infoPanel.repaint();
		btnsPanel.repaint();
	}
	
	public JButton getBackBtn() {
		return backBtn;
	}
	
	public JButton getOkBtn() {
		return okBtn;
	}
	
	public JCheckBox getsalvaCB() {
		return salvaCb;
	}
	
	public String getNome() {
		return nomeTxt.getText();
	}
	
	public String getCognome() {
		return cognomeTxt.getText();
	}
	
	public int getNCarta() {
		return Integer.parseInt(nCartaTxt.getText());
	}
	
	public int getCvv() {
		return Integer.parseInt(cvvTxt.getText());
	}
	
	public int getMese() {
		return (int) meseOp.getSelectedItem();
	}
	
	public int getAnno() {
		return (int) annoOp.getSelectedItem();
	}
}
