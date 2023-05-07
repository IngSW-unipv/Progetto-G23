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
 * JPanel relativo ad uno store item presente nel carrello. 
 * Utilizzato nella CarrelloView.
 * 
 * @author Gabriele Invernizzi
 */
public class CartItemPanel extends JPanel {

	private StoreButton btn;
	
	public CartItemPanel(Merchandising m, int quantity) {	
		JLabel item_name = new JLabel(m.getTipoMerch().toString());
		item_name.setFont(new java.awt.Font("Arial", 1, 18));
		
		JTextArea item_desc = new JTextArea(5, 30);
		item_desc.setEditable(false);
		item_desc.setLineWrap(true);
		item_desc.setFont(new java.awt.Font("Arial", 1, 16));
		item_desc.setOpaque(false);
		item_desc.setText(m.getDescrizione());
		
		String price_str = "Prezzo: " + String.format("%.2f", m.getPrezzo()) + " € x "
				+ quantity + " = " + String.format("%.2f", m.getPrezzo() * quantity) + " €";
		JLabel item_price = new JLabel(price_str);
		item_price.setFont(new java.awt.Font("Arial", 1, 16));
		
		JPanel item_data = new JPanel();
		item_data.setLayout(new GridLayout(3, 1));
		item_data.setPreferredSize(new Dimension(600, 170));
		item_data.add(item_name);
		item_data.add(item_desc);
		item_data.add(item_price);
		
		btn = new StoreButton("RIMUOVI", m, quantity);
		
		JPanel remPanel = new JPanel();
		remPanel.setBorder(new EmptyBorder(0, 0, 0, 20));
		remPanel.setLayout(new BoxLayout(remPanel, BoxLayout.Y_AXIS));
		remPanel.add(btn);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));	
		this.add(item_data);
		this.add(remPanel);
	}
	
	/**
	 * @return Bottone "RIMUOVI".
	 */
	public StoreButton getRemBtn() {
		return btn;
	}
}
