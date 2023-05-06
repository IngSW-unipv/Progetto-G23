package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.view.buttons.StoreButton;
import it.unipv.sfw.view.elements.CartItemPanel;


/**
 * View relativa al carrello dello store.
 * 
 * @author Gabriele Invernizzi
 */
public class CarrelloView extends AView {
	
	private int merch_n;
	// top
	private JButton storeBtn;
	// center
	private JPanel item_list;
	private StoreButton[] remBtns;
	private JButton acquistaBtn;
	
	public CarrelloView(ArrayList<Merchandising> carrello, Dimension dim) {
		merch_n = carrello.size();
		
		// Top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBackground(Color.gray);
		
		JPanel topPanelBtns = new JPanel();
		topPanelBtns.setBackground(Color.BLUE);
		topPanelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		storeBtn = new JButton("SHOP");
		storeBtn.setBackground(Color.WHITE);
		storeBtn.setFont(new java.awt.Font("Arial", 1, 18));
		
		topPanelBtns.add(storeBtn);
		
		topPanel.add(topPanelBtns, BorderLayout.CENTER);
		
		// Center panel
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Carrello:");
		title.setFont(new java.awt.Font("Arial", 1, 24));
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		centralPanel.add(title, BorderLayout.NORTH);
		
		// Caso in cui il carrello sia vuoto
		if (merch_n == 0) {
			remBtns = new StoreButton[0];
			JPanel carrello_vuoto_panel = new JPanel();
			carrello_vuoto_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
			
			JLabel carrello_vuoto_label = new JLabel("Il carrello è vuoto.");
			carrello_vuoto_label.setFont(new java.awt.Font("Arial", 1, 22));
			carrello_vuoto_panel.add(carrello_vuoto_label);
			
			centralPanel.add(carrello_vuoto_panel, BorderLayout.CENTER);
			
			// Main panel
			this.setLayout(new BorderLayout());
			this.add(topPanel, BorderLayout.NORTH);
			this.add(centralPanel, BorderLayout.CENTER);
			return;
		}
		
		// Item list
		float total_price = 0;
		item_list = new JPanel();
		remBtns = new StoreButton[merch_n];
		for (int i = 0; i < merch_n; i++) {
			Merchandising m = carrello.get(i);
			total_price += m.getPrezzo() * m.getQuantita();
			CartItemPanel panel = new CartItemPanel(m);
			remBtns[i] = panel.getRemBtn();
			item_list.add(panel);
		}
		
		// Buy panel
		acquistaBtn = new JButton("ACQUISTA");
		acquistaBtn.setFont(new java.awt.Font("Arial", 1, 18));
		JLabel priceTot = new JLabel("TOTALE: " + String.format("%.2f", total_price) + " €");
		priceTot.setFont(new java.awt.Font("Arial", 1, 18));
		
		JPanel buy_panel = new JPanel();
		buy_panel.setLayout(new GridLayout(1, 2, 100, 0));
		buy_panel.add(priceTot);
		buy_panel.add(acquistaBtn);
		
		item_list.add(buy_panel);
		
		item_list.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (250*merch_n)));
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
	public Type getType() {
		return null;
	}

	public JButton getStoreBtn() {
		return storeBtn;
	}
	
	public JButton getAcquistaBtn() {
		return acquistaBtn;
	}
	
	public StoreButton[] getRemBtns() {
		return remBtns;
	}
}
