package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import it.unipv.sfw.model.store.Merchandising;
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
	private JPanel itemList;
	private HashMap<Merchandising, StoreItemPanel> itemPanels;

	public StoreView(HashMap<Merchandising, Integer> merch, HashMap<Merchandising, Integer> carrello, Dimension dim) {
		merch_n = merch.size();

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

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setBackground(Color.BLACK);

		JLabel title = new JLabel("STORE");
		title.setForeground(Color.WHITE);
		title.setFont(veryLargeFont);
		title.setBackground(Color.BLACK);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));

		titlePanel.add(title);

		centralPanel.add(titlePanel, BorderLayout.NORTH);

		// Item list
		itemList = new JPanel();
		itemPanels = new HashMap<>(merch_n);
		for (Map.Entry<Merchandising, Integer> e : merch.entrySet()) {
			Merchandising m = e.getKey();
			int q = e.getValue();

			int cart_q = 0;
			if (carrello.containsKey(m))
				cart_q = carrello.get(m);

			StoreItemPanel panel = new StoreItemPanel(m, q, cart_q);
			itemPanels.put(m, panel);
			itemList.add(panel);
		}

		itemList.setPreferredSize(new Dimension((int) ((dim.width - 20) * 0.8), (220 * merch_n)));
		itemList.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));

		JScrollPane itemScrollPane = new JScrollPane(itemList);
		itemScrollPane.getVerticalScrollBar().setUnitIncrement(20);

		centralPanel.add(itemScrollPane, BorderLayout.CENTER);

		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
		this.setBackground(Color.WHITE);
	}

	/**
	 * @return Array dei bottoni "ACQUISTA".
	 */
	public Collection<StoreButton> getBuyBtns() {
		return itemPanels.values().stream().map(panel -> panel.getBuyBtn()).collect(Collectors.toList());
	}

	/**
	 * @return Bottone del carrello.
	 */
	public JButton getCartButton() {
		return cartButton;
	}

	/**
	 * @return Bottone del museo.
	 */
	public JButton getMuseoBtn() {
		return museoButton;
	}

	/**
	 * @return Bottone delle partite.
	 */
	public JButton getPartiteBtn() {
		return partiteButton;
	}

	/**
	 * Funzione chiamata nel caso in cui la quantità di un oggetto presente nel
	 * carrello sia cambiata.
	 *
	 * @param carrello Carrello corrente.
	 * @param m        Item la cui quantità è cambiata.
	 */
	public void onCartUpdate(HashMap<Merchandising, Integer> carrello, Merchandising m) {
		int cart_q = 0;
		if (carrello.containsKey(m))
			cart_q = carrello.get(m);

		StoreItemPanel p = itemPanels.get(m);
		p.setCartQuantity(cart_q);
	}

	@Override
	public void onWindowResized(Dimension dim) {
		itemList.setPreferredSize(new Dimension((int) ((dim.width - 20) * 0.8), (220 * merch_n)));

		this.revalidate();
		this.repaint();
	}
}
