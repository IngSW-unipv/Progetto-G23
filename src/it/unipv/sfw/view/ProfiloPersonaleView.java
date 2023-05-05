package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import it.unipv.sfw.model.utente.Utente;

public class ProfiloPersonaleView extends AView {
	
	JPanel Panel;
	private JPanel titolo,dati,valori,campi,bottoni,contenitore;
	private JLabel t,n,nome,c,cognome,d,datanascita,
				   e,email,u,tipoutente,b,bigliettiacquistati;
	private JButton cp, abbonamento;
	
	
	public ProfiloPersonaleView(Dimension dim) {
		
		titolo=new JPanel();
		dati=new JPanel();
		campi=new JPanel();
		valori=new JPanel();
		bottoni=new JPanel();
		contenitore=new JPanel();
		
		t=new JLabel("PROFILO PERSONALE");
		t.setBackground(Color.CYAN);
		t.setOpaque(true);
		
		t.setFont(new java.awt.Font("Arial", 1, 24));
		
		
		n=new JLabel("Nome:");
		n.setFont(new java.awt.Font("Arial", 1, 16));
		nome=new JLabel("0");
		nome.setFont(new java.awt.Font("Arial", 1, 16));
		
		c=new JLabel("Cognome:");
		c.setFont(new java.awt.Font("Arial", 1, 16));
		cognome=new JLabel("0");
		cognome.setFont(new java.awt.Font("Arial", 1, 16));
		
		e=new JLabel("Email:");
		e.setFont(new java.awt.Font("Arial", 1, 16));
		email=new JLabel("0");
		email.setFont(new java.awt.Font("Arial", 1, 16));
		
		d=new JLabel("Data di nascita:");
		d.setFont(new java.awt.Font("Arial", 1, 16));
		datanascita=new JLabel("0");
		datanascita.setFont(new java.awt.Font("Arial", 1, 16));
		
		u=new JLabel("Tipo di Utente:");
		u.setFont(new java.awt.Font("Arial", 1, 16));
		tipoutente=new JLabel("0");
		tipoutente.setFont(new java.awt.Font("Arial", 1, 16));
		
		b=new JLabel("Numero di Biglietti acquistati:");
		b.setFont(new java.awt.Font("Calibri Corpo", 1, 16));
		bigliettiacquistati=new JLabel("0");
		bigliettiacquistati.setFont(new java.awt.Font("Arial", 1, 16));
		
		
		cp=new JButton("Cambia Password");
		abbonamento=new JButton("Abbonati");
		
		
		titolo.setLayout(new GridLayout(2,1));
		t.setAlignmentX(CENTER_ALIGNMENT);
		t.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE,10));
		
		titolo.add(t);
		
		campi.setLayout(new GridLayout(6,1));
		campi.add(n);
		campi.add(c);
		campi.add(e);
		campi.add(d);
		campi.add(u);
		campi.add(b);
		
		valori.setLayout(new GridLayout(6,1));
		valori.add(nome);
		valori.add(cognome);
		valori.add(email);
		valori.add(datanascita);
		valori.add(tipoutente);
		valori.add(bigliettiacquistati);
		
		bottoni.setLayout(new FlowLayout());
		bottoni.add(cp);
		bottoni.add(abbonamento);
		
		dati.setLayout(new BorderLayout());
		dati.add(campi,BorderLayout.WEST);
		dati.add(valori,BorderLayout.CENTER);
		dati.add(bottoni,BorderLayout.SOUTH);
		
		contenitore.setLayout(new GridLayout(2,1));
		contenitore.add(dati);
		
		this.setLayout(new BorderLayout());
		this.add(titolo,BorderLayout.NORTH);		
		this.add(contenitore,BorderLayout.CENTER);
		
		
	}
	
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
