package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente;

public class ProfiloPersonaleView extends AView {
	
	JPanel Panel;
	private JPanel titolo,dati,valori,campi,bottoni,contenitore;
	private JLabel t,n,nome,c,cognome,d,datanascita,
				   e,email,cl,tipocliente,b,bigliettiacquistati;
	private JButton cp, abbonamento,home;
	private Icon img;
	private String tc;
	
	
	
	public ProfiloPersonaleView(Dimension dim,Cliente cliente) {
		
		titolo=new JPanel();
		dati=new JPanel();
		campi=new JPanel();
		valori=new JPanel();
		bottoni=new JPanel();
		contenitore=new JPanel();
		home=new JButton();
		
		t=new JLabel("PROFILO PERSONALE");
		t.setBackground(Color.CYAN);
		t.setOpaque(true);
		t.setFont(new java.awt.Font("Arial", 1, 24));
		
		n=new JLabel("Nome:");
		n.setFont(new java.awt.Font("Arial", 1, 16));
		nome=new JLabel(cliente.getNome());
		nome.setFont(new java.awt.Font("Arial", 1, 16));
		
		c=new JLabel("Cognome:");
		c.setFont(new java.awt.Font("Arial", 1, 16));
		cognome=new JLabel(cliente.getCognome());
		cognome.setFont(new java.awt.Font("Arial", 1, 16));
		
		e=new JLabel("Email:");
		e.setFont(new java.awt.Font("Arial", 1, 16));
		email=new JLabel(cliente.getEmail());
		email.setFont(new java.awt.Font("Arial", 1, 16));
		
		d=new JLabel("Data di nascita:");
		d.setFont(new java.awt.Font("Arial", 1, 16));
		datanascita=new JLabel(cliente.getDataNascita());
		datanascita.setFont(new java.awt.Font("Arial", 1, 16));
		
		cl=new JLabel("Tipo di Utente:");
		cl.setFont(new java.awt.Font("Arial", 1, 16));
		
		if(cliente.getAbb()==null) {
			tc="Cliente";
		}else {
			if(cliente.getAbb().getTipoAbb()==TipoAbb.TESSERA) {
				tc="Tesserato";
			}else {
				if(cliente.getAbb().getTipoAbb()==TipoAbb.LIV1) {
					tc="Abbonato di livello 1";
				}else {
					if(cliente.getAbb().getTipoAbb()==TipoAbb.LIV2) {
						tc="Abbonato di livello 2";
					}else {
						if(cliente.getAbb().getTipoAbb()==TipoAbb.LIV3) {
							tc="Abbonato di livello 3";
						}
					}
				}
			}
		}
		
		tipocliente=new JLabel(tc);
		tipocliente.setFont(new java.awt.Font("Arial", 1, 16));
		
		b=new JLabel("Numero di Biglietti acquistati:");
		b.setFont(new java.awt.Font("Calibri Corpo", 1, 16));
		bigliettiacquistati=new JLabel("0");
		bigliettiacquistati.setFont(new java.awt.Font("Arial", 1, 16));
		
		
		cp=new JButton("Cambia Password");
		abbonamento=new JButton("Abbonati");
		
		img = new ImageIcon(getClass().getResource("/home.png"));
		

		home.setIcon(img);
		home.setBackground(Color.BLUE);
		home.setOpaque(true);
		
		titolo.setLayout(new BorderLayout());
		t.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE,10));
		titolo.add(t,BorderLayout.CENTER);
		titolo.add(home,BorderLayout.EAST);
		
		
		campi.setLayout(new GridLayout(6,1));
		campi.add(n);
		campi.add(c);
		campi.add(e);
		campi.add(d);
		campi.add(cl);
		campi.add(b);
		campi.setBackground(Color.WHITE);
		campi.setOpaque(true);
		campi.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE,10));
		
		
		
		valori.setLayout(new GridLayout(6,1));
		valori.add(nome);
		valori.add(cognome);
		valori.add(email);
		valori.add(datanascita);
		valori.add(tipocliente);
		valori.add(bigliettiacquistati);
		valori.setBackground(Color.WHITE);
		valori.setOpaque(true);
		valori.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE,10));
		
		
		bottoni.setLayout(new FlowLayout());
		bottoni.add(cp);
		bottoni.add(abbonamento);
		bottoni.setBackground(Color.WHITE);
		bottoni.setOpaque(true);
		
		
		dati.setLayout(new BorderLayout());
		dati.add(campi,BorderLayout.WEST);
		dati.add(valori,BorderLayout.CENTER);
		dati.add(bottoni,BorderLayout.SOUTH);
		
		contenitore.setLayout(new GridLayout(2,1));
		contenitore.add(dati);
		contenitore.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE,10));
		contenitore.setBackground(Color.WHITE);
		contenitore.setOpaque(true);
		
		this.setLayout(new BorderLayout());
		this.add(titolo,BorderLayout.NORTH);		
		this.add(contenitore,BorderLayout.CENTER);
		
		
	}
	
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public JButton getHome() {
		return home;
	}

}
