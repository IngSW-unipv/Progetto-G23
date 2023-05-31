package it.unipv.sfw.view.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unipv.sfw.model.store.AcquistoStore;


/**
 * JPanel relativo ad un acquisto di uno store item dell'admin. 
 * Utilizzato nella AdminStoreView.
 * 
 * @author Gabriele Invernizzi
 */
public class AdminStoreAcquistoPanel extends JPanel {
	
	public AdminStoreAcquistoPanel(AcquistoStore a) {
		
		// Fonts
		Font mediumFont = new Font("Arial", 1, 16);
		//Font largeFont = new Font("Arial", 1, 18);
		Font smallFont = new Font("Arial", 1, 11);
				
		JLabel item_name = new JLabel(a.getItem().getTipoMerch().toString());
		item_name.setFont(mediumFont);
		
		String price_str = "Prezzo: " + String.format("%.2f", a.getItem().getPrezzo()) + " € x "
				+ a.getQuantita() + " = " + String.format("%.2f", a.getItem().getPrezzo() * a.getQuantita()) + " €";
		JLabel item_price = new JLabel(price_str);
		item_price.setFont(smallFont);
		
		JPanel item_data = new JPanel();
		item_data.setLayout(new GridLayout(3, 1));
		item_data.setBorder(new EmptyBorder(0, 3, 0, 0));
		item_data.setPreferredSize(new Dimension(280, 50));
		item_data.setMinimumSize(new Dimension(280, 50));
		item_data.add(item_name);
		item_data.add(item_price);
		
		JPanel accountPanel = new JPanel();
		accountPanel.setLayout(new BoxLayout(accountPanel, BoxLayout.Y_AXIS));
		accountPanel.setBorder(new EmptyBorder(5, 0, 0, 3));
		
		JLabel accountStr = new JLabel("Acquistato da: " + a.getBuyer().getEmail());
		accountStr.setFont(smallFont);
		accountPanel.add(accountStr);
		
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createLineBorder(Color.black));	
		this.add(item_data, BorderLayout.WEST);
		this.add(accountPanel, BorderLayout.EAST);
	}
}
