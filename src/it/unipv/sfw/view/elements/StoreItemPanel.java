package it.unipv.sfw.view.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.view.buttons.StoreButton;


/**
 * JPanel relativo ad uno store item. 
 * Utilizzato nella StoreView.
 * 
 * @author Gabriele Invernizzi
 */
public class StoreItemPanel extends JPanel {

	private StoreButton btn;
	private JLabel item_in_cart;
	
	public StoreItemPanel(Merchandising m, int quantity, int qInCart) {	
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
		item_data.setPreferredSize(new Dimension(600, 170));
		item_data.add(item_name);
		item_data.add(item_desc);
		item_data.add(item_price);
		
		btn = new StoreButton("ACQUISTA", m, quantity);
		JLabel item_quantity = new JLabel("Rimanenti: " + quantity);
		item_quantity.setFont(new java.awt.Font("Arial", 1, 11));
		item_quantity.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		item_in_cart = new JLabel("Nel carrello: " + qInCart);
		item_in_cart.setFont(new java.awt.Font("Arial", 1, 11));
		item_in_cart.setBorder(new EmptyBorder(0, 0, 10, 0));
		
		JPanel buyPanel = new JPanel();
		buyPanel.setLayout(new BoxLayout(buyPanel, BoxLayout.Y_AXIS));
		buyPanel.add(item_in_cart);
		buyPanel.add(btn);
		buyPanel.add(item_quantity);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));	
		this.add(item_data);
		this.add(buyPanel);
	}
	
	/**
	 * @return Bottone "ACQUISTA".
	 */
	public StoreButton getBuyBtn() {
		return btn;
	}
	
	/**
	 * @param q Nuova quantità
	 */
	public void setCartQuantity(int q) {
		item_in_cart.setText("Nel carrello: " + q);
		
		this.revalidate();
		this.repaint();
	}
}
