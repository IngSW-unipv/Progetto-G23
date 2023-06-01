package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.store.AcquistoStore;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.view.buttons.StoreButton;
import it.unipv.sfw.view.elements.AdminStoreAcquistoPanel;
import it.unipv.sfw.view.elements.AdminStoreItemPanel;
import it.unipv.sfw.view.elements.StoreItemPanel;


/**
 * View dello store per l'admin.
 * 
 * @author Gabriele Invernizzi
 */
public class AdminStoreView extends AView {
	
	private int merch_n, acquisti_n;
	// top
	private JButton partiteButton, museoButton, cartButton, aggiungiItem;
	// center
	private JPanel itemList;
	private HashMap<Merchandising, AdminStoreItemPanel> itemPanels;
	private ArrayList<AdminStoreAcquistoPanel> acquistiPanels;
	
	public AdminStoreView(
			HashMap<Merchandising, Integer> merch,
			ArrayList<AcquistoStore> acquisti,
			Dimension dim) {
		merch_n = merch.size();
		acquisti_n = acquisti.size();
		
		// Fonts
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 18);
		Font veryLargeFont = new Font("Arial", 1, 24);
		
		// Top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel topPanelBtns = new JPanel();
		topPanelBtns.setBackground(Color.BLUE);
		topPanelBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		
		partiteButton = new JButton("PARTITE");
		partiteButton.setBackground(Color.WHITE);
		partiteButton.setFont(largeFont);
		
		museoButton = new JButton("MUSEO");
		museoButton.setBackground(Color.WHITE);
		museoButton.setFont(largeFont);
		
		topPanelBtns.add(partiteButton);
		topPanelBtns.add(museoButton);
		
		ImageIcon utenteImg = new ImageIcon(getClass().getResource("/carrello.png"));
		cartButton = new JButton("", utenteImg);
		cartButton.setBackground(Color.BLUE);
		
		topPanel.add(cartButton, BorderLayout.EAST);
		topPanel.add(topPanelBtns, BorderLayout.CENTER);
		
		// Center panel
		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Merchandising:");
		title.setFont(veryLargeFont);
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		centralPanel.add(title, BorderLayout.NORTH);
		
		JPanel centralGrid = new JPanel();
		centralGrid.setLayout(new GridLayout(1, 2, 10, 0));
		
		// Item list
		itemList = new JPanel();
		JLabel itemListLabel = new JLabel("STORE");
		itemListLabel.setFont(largeFont);
		itemList.add(itemListLabel);
		aggiungiItem = new JButton("AGGIUNGI ITEM");
		aggiungiItem.setFont(mediumFont);
		itemList.add(aggiungiItem);
		
		if (merch_n > 0) {
			itemPanels = new HashMap<>(merch_n);
			for (Map.Entry<Merchandising, Integer> e : merch.entrySet()) {
				Merchandising m = e.getKey();
				int q = e.getValue();
				
				AdminStoreItemPanel panel = new AdminStoreItemPanel(m, q);
				itemPanels.put(m, panel);
				itemList.add(panel);
			}
			itemList.setPreferredSize(new Dimension((int)((dim.width-20)*0.8 * 0.5), (220*merch_n)));
		} else {
			JLabel noItemsLabel = new JLabel("Non sono presenti items nello store.");
			noItemsLabel.setFont(largeFont);
			itemList.add(noItemsLabel);
		}
		
		itemList.setPreferredSize(new Dimension((int)((dim.width-20)*0.8 * 0.5), (220*merch_n)));
		itemList.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		JScrollPane itemScrollPane = new JScrollPane(itemList);
		itemScrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		centralGrid.add(itemScrollPane);
		
		// Acquisti list
		JPanel acquistiList = new JPanel();
		JLabel acquistiListLabel = new JLabel("ACQUISTATI");
		acquistiListLabel.setFont(largeFont);
		acquistiList.add(acquistiListLabel);
		if (acquisti_n > 0) {
			double tot_ricavi = 0.0;
			acquistiPanels = new ArrayList<>(acquisti_n);
			for (AcquistoStore a : acquisti) {
				AdminStoreAcquistoPanel panel = new AdminStoreAcquistoPanel(a);
				acquistiPanels.add(panel);
				acquistiList.add(panel);
				tot_ricavi += a.getItem().getPrezzo() * a.getQuantita();
			}
			JLabel ricaviLabel = new JLabel("Ricavi totali = " + String.format("%.2f", tot_ricavi) + " €");
			ricaviLabel.setFont(mediumFont);
			acquistiList.add(ricaviLabel);
		} else {
			JLabel noItemsLabel = new JLabel("Non è stato acquistato ancora niente.");
			noItemsLabel.setFont(largeFont);
			acquistiList.add(noItemsLabel);
		}

		acquistiList.setPreferredSize(new Dimension((int) ((dim.width - 20) * 0.8 * 0.5), (220 * acquisti_n)));
		acquistiList.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));

		JScrollPane acquistiScrollPane = new JScrollPane(acquistiList);
		acquistiScrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		centralGrid.add(acquistiScrollPane);
		
		centralPanel.add(centralGrid, BorderLayout.CENTER);
		
		
		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		itemList.setPreferredSize(new Dimension((int)((dim.width-20)*0.8 * 0.5), (220*merch_n)));
		
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
	
	/**
	 * @return Bottone del museo.
	 */
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
	 * @return Bottone per aggiungere items.
	 */
	public JButton getAggiungiItemButton() {
		return aggiungiItem;
	}
	
	/**
	 * @return Array dei bottoni "ACQUISTA".
	 */
	public Collection<StoreButton> getModifyBtns() {
		return itemPanels.values()
				.stream()
				.map(panel -> panel.getModifyBtn())
				.collect(Collectors.toList());
	}
	
}
