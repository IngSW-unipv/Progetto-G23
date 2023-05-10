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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.view.elements.MuseoItemPanel;

/*19 scudetti
 * 8 coppe italia
 * 7 supercoppe italiane
 * 3 champions
 * 3 coppe uefa/europa league
 * 2 coppe intercontinentali
 * 1 coppa del mondo per club
*/ 
public class MuseoView extends AView {
	
	private JButton partiteButton, storeButton, utenteButton;
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
		
		storeButton = new JButton("STORE");
		storeButton.setBackground(Color.WHITE);
		storeButton.setFont(new java.awt.Font("Arial", 1, 18));
		
		topPanelButtons.add(partiteButton);
		topPanelButtons.add(storeButton);
		
		ImageIcon utenteImg = new ImageIcon(getClass().getResource("/utente.gif"));
		utenteButton = new JButton("", utenteImg);
		utenteButton.setBackground(Color.BLUE);
		utenteButton.setPreferredSize(new Dimension(50,50));
		
		topPanel.add(topPanelButtons, BorderLayout.CENTER);
		topPanel.add(utenteButton, BorderLayout.EAST);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Museo:");
		title.setFont(new java.awt.Font("Arial", 1, 24));
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		centralPanel.add(title, BorderLayout.NORTH);
		
		//centro contenitore in centralPanel al CENTER
		JPanel centralMiddlePanel = new JPanel();
		centralMiddlePanel.setLayout(new BorderLayout());
		
			//dentro centro contenitore a NORTH
		JPanel bigliettoPanel = new JPanel();
		acquistaBiglietto = new JButton("ACQUISTA BIGLIETTO");
		acquistaBiglietto.setBackground(Color.WHITE);
		acquistaBiglietto.setPreferredSize(new Dimension(200, 30));
		bigliettoPanel.setPreferredSize(new Dimension(100, 40));
		bigliettoPanel.setBackground(Color.BLUE);
		bigliettoPanel.setOpaque(true);
		bigliettoPanel.add(acquistaBiglietto);
		centralMiddlePanel.add(bigliettoPanel, BorderLayout.NORTH);
		
			//dentro scrollpane che è dentro contenitore a CENTER
		pezzimuseo = new JPanel();
		
		int i = 0;
		for(Cimelio c : cimeli) {
			MuseoItemPanel pezzo = new MuseoItemPanel(c);
			pezzimuseo.add(pezzo);
		}
		
		int j = 0;
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
		
		//
		JLabel blue_label_dx = new JLabel();
		blue_label_dx.setBackground(Color.BLUE);
		blue_label_dx.setOpaque(true);
		blue_label_dx.setIcon(scudettosx);
		centralMiddlePanel.add(blue_label_dx, BorderLayout.EAST);
		//
		
		centralPanel.add(centralMiddlePanel, BorderLayout.CENTER);
		
	
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}
	
	public JButton getPButton() {
		return partiteButton;
	}
	
	public JButton getSButton() {
		return storeButton;
	}
		
	public JButton getAcquistaButton() {
		return acquistaBiglietto;
	}
	
	@Override
	public Type getType() {
		return AView.Type.MUSEO;
	}

}