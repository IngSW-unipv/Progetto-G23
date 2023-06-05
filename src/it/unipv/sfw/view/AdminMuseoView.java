package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.view.buttons.PezzoMuseoButton;
import it.unipv.sfw.view.elements.MenuUtente;
import it.unipv.sfw.view.elements.MuseoItemPanel;
import it.unipv.sfw.view.elements.MuseoStoryPanel;

public class AdminMuseoView extends AView {

	ArrayList<Cimelio> cimeli = new ArrayList<>();
	ArrayList<Riconoscimento> riconoscimenti = new ArrayList<>();
	private JButton partiteButton, storeButton, utenteButton;
	private MenuUtente utente;
	private JButton inserisciButton;
	private JButton registroButton;
	private JPanel pezzimuseo;
	private HashMap<Integer, MuseoItemPanel> pezzo = new HashMap<>();
	private ArrayList<PezzoMuseoButton> buttons = new ArrayList<>();
	private int npezzi;
	private Dimension dim;
	
	public AdminMuseoView(Museo museum, Dimension dim) {
		
		this.dim = dim;
	
		cimeli = museum.getCimeli();
		int ncim = cimeli.size();
		riconoscimenti = museum.getRiconoscimenti();
		int nric = riconoscimenti.size();
		npezzi = nric + ncim;
		
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
		
		storeButton = new JButton("STORE");
		storeButton.setBackground(Color.WHITE);
		storeButton.setFont(new java.awt.Font("Arial", 1, 18));
		
		topPanelButtons.add(partiteButton);
		topPanelButtons.add(storeButton);
		
		utente = new MenuUtente();
		
		topPanel.add(topPanelButtons, BorderLayout.CENTER);
		topPanel.add(utente, BorderLayout.EAST);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setBackground(Color.BLACK);
		
		JLabel title = new JLabel("GESTIONE MUSEO");
		title.setFont(new java.awt.Font("Arial", 1, 24));
		title.setBackground(Color.BLACK);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		title.setForeground(Color.WHITE);
		
		titlePanel.add(title);
		
		centralPanel.add(titlePanel, BorderLayout.NORTH);
		
		JPanel centralMiddlePanel = new JPanel();
		centralMiddlePanel.setLayout(new BorderLayout());
		
		JPanel bigliettoPanel = new JPanel();
		
		inserisciButton = new JButton("INSERISCI TROFEO O CIMELIO");
		inserisciButton.setBackground(Color.WHITE);
		inserisciButton.setPreferredSize(new Dimension(200, 30));
		
		registroButton = new JButton("REGISTRO VENDITA");
		registroButton.setBackground(Color.WHITE);
		registroButton.setPreferredSize(new Dimension(200, 30));
		
		bigliettoPanel.setPreferredSize(new Dimension(100, 40));
		bigliettoPanel.setBackground(Color.BLUE);
		bigliettoPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bigliettoPanel.setOpaque(true);
		bigliettoPanel.add(inserisciButton);
		bigliettoPanel.add(registroButton);
		
		centralMiddlePanel.add(bigliettoPanel, BorderLayout.NORTH);
		
		pezzimuseo = new JPanel();
		
		pezzimuseo.add(new MuseoStoryPanel(dim, museum.getStoria()));
		
		for(Cimelio c : cimeli) {
			pezzo.put(c.getId(), new MuseoItemPanel(c, true));
			pezzimuseo.add(pezzo.get(c.getId()));
			buttons.add(pezzo.get(c.getId()).getRimuoviButton());
		}
		
		for(Riconoscimento r : riconoscimenti) {
			pezzo.put(r.getId(), new MuseoItemPanel(r, true));
			pezzimuseo.add(pezzo.get(r.getId()));
			buttons.add(pezzo.get(r.getId()).getRimuoviButton());
		}
		
		pezzimuseo.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (240*(npezzi))));
		pezzimuseo.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		JScrollPane scrollTrofei = new JScrollPane(pezzimuseo); 
		scrollTrofei.getVerticalScrollBar().setUnitIncrement(20);
		centralMiddlePanel.add(scrollTrofei, BorderLayout.CENTER);
		
		centralPanel.add(centralMiddlePanel, BorderLayout.CENTER);
		
	
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}
	
	public ArrayList<PezzoMuseoButton> getRimuoviButtons() {
		return buttons;
	}
	
	public void removeMuseoItemPanel(int i) {
		pezzimuseo.remove(pezzo.remove(i));
		npezzi--;
		pezzimuseo.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (240*(npezzi))));
		pezzimuseo.revalidate();
		pezzimuseo.repaint();
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
	
	public JButton getRegistroButton() {
		return registroButton;
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
	
}
