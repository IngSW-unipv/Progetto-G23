package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.store.StoreOnline;


/**
 * View dello store nel quale si potranno acquistare i prodotti di 
 * merchandising.
 * 
 * @author Gabriele Invernizzi
 */
public class StoreView extends AView {
	
	private JPanel topPanel, topPanelBtns;
	private JButton partiteButton, museoButton, utenteButton;
	
	public StoreView(StoreOnline store, Dimension dim) {
		List<Merchandising> merch = store.getMerch();
		
		// Top panel
		topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBackground(Color.gray);
		
		topPanelBtns = new JPanel();
		topPanelBtns.setBackground(Color.BLUE);
		topPanelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		partiteButton = new JButton("PARTITE");
		partiteButton.setBackground(Color.WHITE);
		partiteButton.setFont(new java.awt.Font("Arial", 1, 18));
		
		museoButton = new JButton("MUSEO");
		museoButton.setBackground(Color.WHITE);
		museoButton.setFont(new java.awt.Font("Arial", 1, 18));
		
		topPanelBtns.add(partiteButton);
		topPanelBtns.add(museoButton);
		
		ImageIcon utenteImg = new ImageIcon(getClass().getResource("/utente.gif"));
		utenteButton = new JButton("", utenteImg);
		utenteButton.setBackground(Color.BLUE);
		
		topPanel.add(utenteButton, BorderLayout.WEST);
		topPanel.add(topPanelBtns, BorderLayout.CENTER);
		
		
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
	}

	@Override
	public Type getType() {
		return AView.Type.STORE;
	}
	
	public JButton getPartiteBtn() {
		return partiteButton;
	}
}
