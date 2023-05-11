package it.unipv.sfw.view.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

	private int item_qantity;
	private StoreButton btn;
	private JLabel item_in_cart;
	
	public StoreItemPanel(Merchandising m, int quantity, int qInCart) {
		this.item_qantity = quantity;
		
		// Fonts
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 18);
		Font smallFont = new Font("Arial", 1, 11);
				
		JLabel item_name = new JLabel(m.getTipoMerch().toString());
		item_name.setFont(largeFont);
		
		JTextArea item_desc = new JTextArea(5, 30);
		item_desc.setEditable(false);
		item_desc.setLineWrap(true);
		item_desc.setFont(mediumFont);
		item_desc.setOpaque(false);
		item_desc.setText(m.getDescrizione());
		
		JLabel item_price = new JLabel("Prezzo: " + String.format("%.2f", m.getPrezzo()) + " €");
		item_price.setFont(mediumFont);
		
		JPanel item_data = new JPanel();
		item_data.setLayout(new GridLayout(3, 1));
		item_data.setPreferredSize(new Dimension(600, 170));
		item_data.add(item_name);
		item_data.add(item_desc);
		item_data.add(item_price);
		
		btn = new StoreButton("ACQUISTA", m, item_qantity);
		if (quantity == qInCart) 
			btn.setEnabled(false);
		else 
			btn.setEnabled(true);
		
		JLabel item_quantity = new JLabel("Rimanenti: " + item_qantity);
		item_quantity.setFont(smallFont);
		item_quantity.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		item_in_cart = new JLabel("Nel carrello: " + qInCart);
		item_in_cart.setFont(smallFont);
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
		
		if (item_qantity == q) 
			btn.setEnabled(false);
		else 
			btn.setEnabled(true);
		
		this.revalidate();
		this.repaint();
	}
}
