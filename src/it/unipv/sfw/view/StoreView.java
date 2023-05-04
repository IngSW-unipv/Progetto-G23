package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		
		
		JPanel item_list = new JPanel();
		buyBtns = new AcquistaButton[merch.size()];
		for (int i = 0; i < merch.size(); i++) {
			Merchandising m = merch.get(i);
			JLabel item_name = new JLabel(m.getTipoMerch().toString());
			item_name.setFont(new java.awt.Font("Arial", 1, 18));
			buyBtns[i] = new AcquistaButton(m.getId());
			
			JPanel item_panel = new JPanel();
			item_panel.add(item_name);
			item_panel.add(buyBtns[i]);
			item_panel.setBorder(BorderFactory.createLineBorder(Color.black));
			
			item_list.add(item_panel);
		}
		
		item_list.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (65*merch.size())));
		item_list.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		JScrollPane item_scroll_pane = new JScrollPane(item_list);
		
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
