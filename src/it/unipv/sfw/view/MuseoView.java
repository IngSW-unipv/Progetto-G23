package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.view.elements.MenuUtente;
import it.unipv.sfw.view.elements.MuseoItemPanel;


public class MuseoView extends AView {
	
	private JButton partiteButton, storeButton, utenteButton;
	private MenuUtente utente;
	private JButton acquistaBiglietto;
	private JPanel pezzimuseo;
	
	public MuseoView(Museo museum, Dimension dim) {
	
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
		
		JLabel title = new JLabel("Museo:");
		title.setFont(new java.awt.Font("Arial", 1, 24));
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		centralPanel.add(title, BorderLayout.NORTH);
		
		JPanel centralMiddlePanel = new JPanel();
		centralMiddlePanel.setLayout(new BorderLayout());
		
		JPanel bigliettoPanel = new JPanel();
		acquistaBiglietto = new JButton("ACQUISTA BIGLIETTO");
		acquistaBiglietto.setBackground(Color.WHITE);
		acquistaBiglietto.setPreferredSize(new Dimension(200, 30));
		bigliettoPanel.setPreferredSize(new Dimension(100, 40));
		bigliettoPanel.setBackground(Color.BLUE);
		bigliettoPanel.setOpaque(true);
		bigliettoPanel.add(acquistaBiglietto);
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
		
		ImageIcon scudettosx = new ImageIcon(getClass().getResource("/scudettointer.png"));
		scudettosx = new ImageIcon(scudettosx.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		JLabel scudetto = new JLabel();
		scudetto.setBackground(Color.BLUE);
		scudetto.setOpaque(true);
		scudetto.setIcon(scudettosx);
		centralMiddlePanel.add(scudetto, BorderLayout.WEST);
		
		JLabel blue_label_dx = new JLabel();
		blue_label_dx.setBackground(Color.BLUE);
		blue_label_dx.setOpaque(true);
		blue_label_dx.setIcon(scudettosx);
		centralMiddlePanel.add(blue_label_dx, BorderLayout.EAST);
		
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
		
	public JButton getAcquistaButton() {
		return acquistaBiglietto;
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