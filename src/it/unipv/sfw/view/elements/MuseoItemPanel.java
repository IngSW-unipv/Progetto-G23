package it.unipv.sfw.view.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;

public class MuseoItemPanel extends JPanel {

	public MuseoItemPanel(Riconoscimento r) {
		
		JLabel titolo_pezzo = new JLabel(r.getTipo() + " " + r.getAnno());
		titolo_pezzo.setFont(new java.awt.Font("Arial", 1, 18));
		
		JTextArea descr_pezzo = new JTextArea(5, 30); 
		descr_pezzo.setEditable(false);
		descr_pezzo.setLineWrap(true);
		descr_pezzo.setWrapStyleWord(true);
		descr_pezzo.setFont(new java.awt.Font("Arial", 1, 14));
		descr_pezzo.setBorder(BorderFactory.createTitledBorder("Descrizione:"));
		descr_pezzo.setOpaque(false);
		descr_pezzo.setText(r.getDescrizione());
		
		JPanel column_pezzo = new JPanel();
		column_pezzo.setLayout(new GridLayout(2, 1));
		column_pezzo.setPreferredSize(new Dimension(500, 200));
		column_pezzo.add(titolo_pezzo);
		column_pezzo.add(descr_pezzo);
		
		ImageIcon image_pezzo = new ImageIcon(getClass().getResource("/" + r.getImgid() + ".png"));
		image_pezzo = new ImageIcon(image_pezzo.getImage().getScaledInstance(100, 180, java.awt.Image.SCALE_SMOOTH));
		JLabel image = new JLabel();
		image.setIcon(image_pezzo);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(image);
		this.add(column_pezzo);
	}
	
	public MuseoItemPanel(Cimelio c) {
		
		JLabel titolo_pezzo = new JLabel(c.getTipo() + " " + c.getAnno());
		titolo_pezzo.setFont(new java.awt.Font("Arial", 1, 18));
		
		JTextArea descr_pezzo = new JTextArea(5, 30); 
		descr_pezzo.setEditable(false);
		descr_pezzo.setLineWrap(true);
		descr_pezzo.setFont(new java.awt.Font("Arial", 1, 14));
		descr_pezzo.setBorder(BorderFactory.createTitledBorder("Descrizione:"));
		descr_pezzo.setOpaque(false);
		descr_pezzo.setText(c.getDescrizione());
		
		JPanel column_pezzo = new JPanel();
		column_pezzo.setLayout(new GridLayout(2, 1));
		column_pezzo.setPreferredSize(new Dimension(500, 200));
		column_pezzo.add(titolo_pezzo);
		column_pezzo.add(descr_pezzo);
		
		ImageIcon image_pezzo = new ImageIcon(getClass().getResource("/" + c.getImgid() + ".png"));
		image_pezzo = new ImageIcon(image_pezzo.getImage().getScaledInstance(100, 180, java.awt.Image.SCALE_SMOOTH));
		JLabel image = new JLabel();
		image.setIcon(image_pezzo);
		
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.add(image);
		this.add(column_pezzo);
	}
	
}
