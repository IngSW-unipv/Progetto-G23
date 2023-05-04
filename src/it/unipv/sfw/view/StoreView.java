package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

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
import it.unipv.sfw.view.buttons.AcquistaButton;


/**
 * View dello store nel quale si potranno acquistare i prodotti di 
 * merchandising.
 * 
 * @author Gabriele Invernizzi
 */
public class StoreView extends AView {
	
	// top
	private JButton partiteButton, museoButton, utenteButton;
	// center
	private AcquistaButton[] buyBtns;
	
	public StoreView(StoreOnline store, Dimension dim) {
		ArrayList<Merchandising> merch = store.getMerch();
		
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
		utenteButton = new JButton("", utenteImg);
		utenteButton.setBackground(Color.BLUE);
		
		topPanel.add(utenteButton, BorderLayout.WEST);
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
		JPanel item_list = new JPanel();
		buyBtns = new AcquistaButton[merch.size()];
		for (int i = 0; i < merch.size(); i++) {
			Merchandising m = merch.get(i);
			
			JLabel item_name = new JLabel(m.getTipoMerch().toString());
			item_name.setFont(new java.awt.Font("Arial", 1, 18));
			
			JTextArea item_desc = new JTextArea(5, 30);
			item_desc.setEditable(false);
			item_desc.setLineWrap(true);
			item_desc.setFont(new java.awt.Font("Arial", 1, 16));
			item_desc.setOpaque(false);
			item_desc.setText(m.getDescrizione());
			
			JLabel item_price = new JLabel("Prezzo: " + String.format("%.2f", m.getPrezzo()) + " €");
			item_price.setFont(new java.awt.Font("Arial", 1, 16));
			
			JPanel item_data = new JPanel();
			item_data.setLayout(new GridLayout(3, 1));
			item_data.setPreferredSize(new Dimension(600, 200));
			item_data.add(item_name);
			item_data.add(item_desc);
			item_data.add(item_price);
			
			buyBtns[i] = new AcquistaButton(m.getId());
			JLabel item_quantity = new JLabel("Rimanenti: " + m.getQuantita());
			item_quantity.setFont(new java.awt.Font("Arial", 1, 11));
			item_quantity.setBorder(new EmptyBorder(10, 0, 0, 0));
			
			JPanel buyPanel = new JPanel();
			buyPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
			buyPanel.setLayout(new BoxLayout(buyPanel, BoxLayout.Y_AXIS));
			buyPanel.add(buyBtns[i]);
			buyPanel.add(item_quantity);
			
			JPanel item_panel = new JPanel();
			item_panel.setBorder(BorderFactory.createLineBorder(Color.black));	
			item_panel.add(item_data);
			item_panel.add(buyPanel);
			
			item_list.add(item_panel);
		}
		
		item_list.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (250*merch.size())));
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
		return AView.Type.STORE;
	}
	
	public JButton getPartiteBtn() {
		return partiteButton;
	}
	
	public AcquistaButton[] getBuyBtns() {
		return buyBtns;
	}
}
