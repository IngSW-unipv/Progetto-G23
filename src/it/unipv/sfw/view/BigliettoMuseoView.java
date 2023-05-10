package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DateTimePicker;


public class BigliettoMuseoView extends AView {

	JButton acquistaButton;
	JButton backButton;
	
	public BigliettoMuseoView(Dimension dim) {
		
		this.setLayout(new BorderLayout());
		
		JPanel contenitore = new JPanel();
		contenitore.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 35));
		//contenitore.setLayout(new GridLayout(3, 1));
		
		JPanel emailPanel = new JPanel();
		emailPanel.setPreferredSize(new Dimension(400, 75));
		emailPanel.setLayout(new GridLayout(2, 1));
		JLabel email_label = new JLabel("Inserire email:");
		email_label.setFont(new java.awt.Font("Arial", 1, 16));
		email_label.setOpaque(true);
		JTextField email_box = new JTextField();
		emailPanel.add(email_label);
		emailPanel.add(email_box);
		
		JPanel visitaPanel = new JPanel();
		visitaPanel.setPreferredSize(new Dimension(400, 75));
		visitaPanel.setLayout(new GridLayout(2, 1));
		JLabel visita_label = new JLabel("Inserire data e ora di visita:");
		visita_label.setFont(new java.awt.Font("Arial", 1, 16));
		visita_label.setOpaque(true);
		DateTimePicker chDate = new DateTimePicker();
		visitaPanel.add(visita_label);
		visitaPanel.add(chDate);
		
		acquistaButton = new JButton("ACQUISTA BIGLIETTO");
		acquistaButton.setBackground(Color.WHITE);
		acquistaButton.setPreferredSize(new Dimension(300,50));
		acquistaButton.setFont(new java.awt.Font("Arial", 2, 13));
		
		contenitore.add(emailPanel);
		contenitore.add(visitaPanel);
		contenitore.add(acquistaButton);	
		
		this.add(contenitore, BorderLayout.CENTER);
		
		ImageIcon scudettobasso = new ImageIcon(getClass().getResource("/scudettointer.png"));
		scudettobasso = new ImageIcon(scudettobasso.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		JLabel scudetto = new JLabel();
		scudetto.setPreferredSize(new Dimension(100,125));
		scudetto.setBackground(Color.BLUE);
		scudetto.setOpaque(true);
		scudetto.setHorizontalAlignment(JLabel.CENTER);
		scudetto.setIcon(scudettobasso);
		
		this.add(scudetto, BorderLayout.SOUTH);
		
		JLabel blue_label_dx = new JLabel();
		blue_label_dx.setPreferredSize(new Dimension(200,200));
		blue_label_dx.setBackground(Color.BLACK);
		blue_label_dx.setOpaque(true);
		
		JLabel blue_label_sx= new JLabel();
		blue_label_sx.setPreferredSize(new Dimension(200,200));
		blue_label_sx.setBackground(Color.BLACK);
		blue_label_sx.setOpaque(true);
		
		this.add(blue_label_sx, BorderLayout.WEST);
		this.add(blue_label_dx, BorderLayout.EAST);
		
		JLabel blue_label_up = new JLabel();
		blue_label_up.setLayout(new BorderLayout());
		blue_label_up.setPreferredSize(new Dimension(100,100));
		blue_label_up.setBackground(Color.BLUE);
		blue_label_up.setOpaque(true);
		blue_label_up.setHorizontalAlignment(JLabel.CENTER);
		
		ImageIcon backpage = new ImageIcon(getClass().getResource("/backpage1.png"));
		backpage = new ImageIcon(backpage.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		backButton = new JButton("", backpage);
		backButton.setBackground(Color.BLUE);
		
		JLabel title = new JLabel("  MUSEUM TICKET STORE");
		title.setFont(new java.awt.Font("Arial", 1, 26));
		title.setBackground(Color.BLUE);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		blue_label_up.add(backButton, BorderLayout.WEST);
		blue_label_up.add(title, BorderLayout.CENTER);
		
		this.add(blue_label_up, BorderLayout.NORTH);	
		
	}
	
	public JButton getAcquistaButton() {
		return acquistaButton;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	@Override
	public Type getType() {
		return Type.BIGLIETTOMUSEO;
	}

}
