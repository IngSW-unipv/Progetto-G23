package it.unipv.sfw.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DateTimePicker;



public class BigliettoMuseoView extends AView {

	JButton acquistaButton;
	
	public BigliettoMuseoView(Dimension dim) {
		
		this.setLayout(new GridLayout(3, 1));
		
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new GridLayout(2, 1));
		JLabel email_label = new JLabel("Inserire email:");
		email_label.setOpaque(true);
		JTextField email_box = new JTextField();
		emailPanel.add(email_label);
		emailPanel.add(email_box);
		
		JPanel visitaPanel = new JPanel();
		visitaPanel.setLayout(new GridLayout(2, 1));
		JLabel visita_label = new JLabel("Data e ora visita");
		visita_label.setOpaque(true);
		DateTimePicker chDate = new DateTimePicker();
		visitaPanel.add(visita_label);
		visitaPanel.add(chDate);
		
		acquistaButton = new JButton("ACQUISTA BIGLIETTO");
		acquistaButton.setBackground(Color.WHITE);
		
		this.add(emailPanel);
		this.add(visitaPanel);
		this.add(acquistaButton);	
	}
	
	public JButton getAcquistaButton() {
		return acquistaButton;
	}
	
	@Override
	public Type getType() {
		return Type.BIGLIETTOMUSEO;
	}

}
