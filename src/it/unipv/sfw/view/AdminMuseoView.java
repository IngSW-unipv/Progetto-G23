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
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.view.AView.Type;
import it.unipv.sfw.view.elements.MenuUtente;
import it.unipv.sfw.view.elements.MuseoItemPanel;

public class AdminMuseoView extends AView {

	private JButton partiteButton, storeButton, utenteButton;
	private MenuUtente utente;
	private JButton inserisciButton;
	private JPanel pezzimuseo;
	
	public AdminMuseoView(Museo museum, Dimension dim) {
	
		ArrayList<Cimelio> cimeli = museum.getCimeli();
		int ncim = cimeli.size();
		ArrayList<Riconoscimento> riconoscimenti = museum.getRiconoscimenti();
		int nric = riconoscimenti.size();
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBackground(Color.gray);
		
		JPanel topPanelButtons = new JPanel();
		topPanelButtons.setBackground(Color.BLUE);
		topPanelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		partiteButton = new JButton("PARTITE");
		partiteButton.setBackground(Color.WHITE);
		partiteButton.setFont(new java.awt.Font("Arial", 1, 18));
		
		storeButton = new JButton("SHOP");
		storeButton.setBackground(Color.WHITE);
		storeButton.setFont(new java.awt.Font("Arial", 1, 18));
		
		topPanelButtons.add(partiteButton);
		topPanelButtons.add(storeButton);
		
		utente = new MenuUtente();
		
		topPanel.add(topPanelButtons, BorderLayout.CENTER);
		topPanel.add(utente, BorderLayout.EAST);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Controllo Museo:");
		title.setFont(new java.awt.Font("Arial", 1, 24));
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		centralPanel.add(title, BorderLayout.NORTH);
		
		JPanel centralMiddlePanel = new JPanel();
		centralMiddlePanel.setLayout(new BorderLayout());
		
		JPanel bigliettoPanel = new JPanel();
		inserisciButton = new JButton("INSERISCI TROFEO O CIMELIO");
		inserisciButton.setBackground(Color.WHITE);
		inserisciButton.setPreferredSize(new Dimension(200, 30));
		bigliettoPanel.setPreferredSize(new Dimension(100, 40));
		bigliettoPanel.setBackground(Color.YELLOW);
		bigliettoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bigliettoPanel.setOpaque(true);
		bigliettoPanel.add(inserisciButton);
		centralMiddlePanel.add(bigliettoPanel, BorderLayout.NORTH);
		
		pezzimuseo = new JPanel();
		
		for(Cimelio c : cimeli) {
			MuseoItemPanel pezzo = new MuseoItemPanel(c);
			pezzimuseo.add(pezzo);
		}
		
		for(Riconoscimento r : riconoscimenti) {
			MuseoItemPanel pezzo = new MuseoItemPanel(r);
			pezzimuseo.add(pezzo);
		}
		
		pezzimuseo.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (240*nric)));
		pezzimuseo.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		JScrollPane scrollTrofei = new JScrollPane(pezzimuseo); 
		scrollTrofei.getVerticalScrollBar().setUnitIncrement(20);
		centralMiddlePanel.add(scrollTrofei, BorderLayout.CENTER);
		
		centralPanel.add(centralMiddlePanel, BorderLayout.CENTER);
		
	
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}
	
	public JButton getPartiteButton() {
		return partiteButton;
	}
	
	public JButton getStoreButton() {
		return storeButton;
	}
	
	public JButton getUtenteButton() {
		return utenteButton;
	}
		
	public JButton getInserisciButton() {
		return inserisciButton;
	}
	
	public JMenuItem getProfiloPersonaleButton() {
		return utente.getProfiloPersonale();
	}
	
	public JMenuItem getExit() {
		return utente.getExit();
	}
	
	public void menu(boolean stato) {
		utente.getMenuButton().setPopupMenuVisible(stato);
	}
	
	@Override
	public Type getType() {
		return AView.Type.MUSEO;
	}

}
