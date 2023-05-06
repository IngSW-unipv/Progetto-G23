package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.store.StoreOnline;
import it.unipv.sfw.view.buttons.StoreButton;
import it.unipv.sfw.view.elements.StoreItemPanel;


/**
 * View dello store nel quale si potranno acquistare i prodotti di 
 * merchandising.
 * 
 * @author Gabriele Invernizzi
 */
public class StoreView extends AView {
	
	private int merch_n;
	// top
	private JButton partiteButton, museoButton, cartButton;
	// center
	private JPanel item_list;
	private StoreButton[] buyBtns;
	
	public StoreView(StoreOnline store, Dimension dim) {
		ArrayList<Merchandising> merch = store.getMerch();
		merch_n = merch.size();
		
		// Top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBackground(Color.gray);
		
		JPanel topPanelBtns = new JPanel();
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
		cartButton = new JButton("", utenteImg);
		cartButton.setBackground(Color.BLUE);
		
		topPanel.add(cartButton, BorderLayout.EAST);
		topPanel.add(topPanelBtns, BorderLayout.CENTER);
		
		// Center panel
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Merchandising:");
		title.setFont(new java.awt.Font("Arial", 1, 24));
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		centralPanel.add(title, BorderLayout.NORTH);
		
		// Item list
		item_list = new JPanel();
		buyBtns = new StoreButton[merch_n];
		for (int i = 0; i < merch_n; i++) {
			StoreItemPanel panel = new StoreItemPanel(merch.get(i));
			buyBtns[i] = panel.getBuyBtn();
			item_list.add(panel);
		}
		
		item_list.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (220*merch_n)));
		item_list.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		JScrollPane item_scroll_pane = new JScrollPane(item_list);
		item_scroll_pane.getVerticalScrollBar().setUnitIncrement(20);
		
		centralPanel.add(item_scroll_pane, BorderLayout.CENTER);
		
		
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		item_list.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (220*merch_n)));
		
		this.revalidate();
		this.repaint();
	}

	@Override
	public Type getType() {
		return AView.Type.STORE;
	}
	
	/**
	 * @return Bottone delle partite.
	 */
	public JButton getPartiteBtn() {
		return partiteButton;
	}
	
	public JButton getMuseoBtn() {
		return museoButton;
	}
	
	/**
	 * @return Bottone del carrello.
	 */
	public JButton getCartButton() {
		return cartButton;
	}
	
	/**
	 * @return Array dei bottoni "ACQUISTA".
	 */
	public StoreButton[] getBuyBtns() {
		return buyBtns;
	}
}
