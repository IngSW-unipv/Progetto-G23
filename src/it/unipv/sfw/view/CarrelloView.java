package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Cliente;
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
	private JPanel centralPanel, itemList, emptyCartPanel;
	private JScrollPane itemScrollPanel;
	private HashMap<Merchandising, CartItemPanel> itemPanels;
	private JButton acquistaBtn;
	
	public CarrelloView(HashMap<Merchandising, Integer> carrello, Cliente c, Dimension dim) {
		merch_n = carrello.size();
		
		// Fonts
		Font largeFont = new Font("Arial", 1, 18);
		Font veryLargeFont = new Font("Arial", 1, 24);
		
		// Top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel topPanelBtns = new JPanel();
		topPanelBtns.setBackground(Color.BLUE);
		topPanelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		storeBtn = new JButton("SHOP");
		storeBtn.setBackground(Color.WHITE);
		storeBtn.setFont(largeFont);
		
		topPanelBtns.add(storeBtn);
		
		topPanel.add(topPanelBtns, BorderLayout.CENTER);
		
		// Center panel
		centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		emptyCartPanel = new JPanel();
		emptyCartPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		JLabel emptyCartLabel = new JLabel("Il carrello è vuoto.");
		emptyCartLabel.setFont(largeFont);
		emptyCartPanel.add(emptyCartLabel);
		
		
		JLabel title = new JLabel("Carrello:");
		title.setFont(veryLargeFont);
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		centralPanel.add(title, BorderLayout.NORTH);
		
		acquistaBtn = new JButton("ACQUISTA");
		acquistaBtn.setFont(largeFont);
		
		itemPanels = new HashMap<>(merch_n);
		// Caso in cui il carrello sia vuoto
		if (merch_n == 0) {
			centralPanel.add(emptyCartPanel, BorderLayout.CENTER);
			
			// Main panel
			this.setLayout(new BorderLayout());
			this.add(topPanel, BorderLayout.NORTH);
			this.add(centralPanel, BorderLayout.CENTER);
			return;
		}
		
		// Item list
		float total_price = 0;
		itemList = new JPanel();
		for (Merchandising m : carrello.keySet()) {
			int q = carrello.get(m);
			total_price += m.getPrezzo() * q;
			CartItemPanel panel = new CartItemPanel(m, q);
			itemPanels.put(m, panel);
			itemList.add(panel);
		}
		double discount = c.getAbb().getSconto();
		float discounted_price = (float) (total_price * discount);
		float discount_diff = total_price - discounted_price;
		String totalSring = "TOTALE: " + String.format("%.2f", total_price) + " €";
		if (discount < 1.0)
			totalSring += " - " + String.format("%.2f", discount_diff) + " € = " +
					String.format("%.2f", discounted_price) + " €";
		// Buy panel
		JLabel priceTot = new JLabel(totalSring);
		priceTot.setFont(largeFont);
		
		JPanel buy_panel = new JPanel();
		buy_panel.setLayout(new GridLayout(1, 2, 100, 0));
		buy_panel.add(priceTot);
		buy_panel.add(acquistaBtn);
		
		itemList.add(buy_panel);
		
		itemList.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (250*merch_n)));
		itemList.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		itemScrollPanel = new JScrollPane(itemList);
		itemScrollPanel.getVerticalScrollBar().setUnitIncrement(20);
		
		centralPanel.add(itemScrollPanel, BorderLayout.CENTER);
		
		
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}
	
	/**
	 * @return Bottone dello store.
	 */
	public JButton getStoreBtn() {
		return storeBtn;
	}
	
	/**
	 * @return Bottone "ACQUISTA"
	 */
	public JButton getAcquistaBtn() {
		return acquistaBtn;
	}
	
	/**
	 * @return Collection di bottini "RIMUOVI".
	 */
	public Collection<StoreButton> getRemBtns() {
		return itemPanels.values()
				.stream()
				.map(panel -> panel.getRemBtn())
				.collect(Collectors.toList());
	}
	
	/**
	 * Funzione chiamata quando degli item vengono rimossi dal carrello.
	 * @param m Item rimosso.
	 */
	public void onItemRemove(Merchandising m) {
		merch_n--;
		
		itemList.remove(itemPanels.remove(m));
		if (!itemPanels.isEmpty()) {
			itemList.setPreferredSize(new Dimension(itemList.getWidth(), (250*merch_n)));
			
			itemList.revalidate();
			itemList.repaint();
		} else {
			centralPanel.remove(itemScrollPanel);	
			centralPanel.add(emptyCartPanel, BorderLayout.CENTER);
			
			centralPanel.revalidate();
			centralPanel.repaint();
		}
	}
}
