package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.model.utente.Utente;

public class ProfiloPersonaleView extends AView {
	
	JPanel Panel;
	private JPanel titolo,dati,valori,campi,bottoni;
	private JLabel t,n,nome,c,cognome,d,datanascita,
				   e,email,u,tipoutente,b,bigliettiacquistati,cambiapassword;
	private JButton cp, abbonamento;
	
	
	public ProfiloPersonaleView(Dimension dim) {
		
		titolo=new JPanel();
		dati=new JPanel();
		campi=new JPanel();
		valori=new JPanel();
		bottoni=new JPanel();
		
		t=new JLabel("PROFILO PERSONALE");
		
		
		n=new JLabel("Nome:");
		nome=new JLabel();
		
		c=new JLabel("Cognome:");
		cognome=new JLabel();
		
		e=new JLabel("Email:");
		email=new JLabel();
		
		d=new JLabel("Data di nascita:");
		datanascita=new JLabel();
		
		u=new JLabel("Tipo di Utente:");
		tipoutente=new JLabel();
		
		b=new JLabel("Numero di Biglietti acquistati:");
		bigliettiacquistati=new JLabel();
		
		
		cp=new JButton("Cambia Password");
		abbonamento=new JButton("Abbonati");
		
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
		
		dati.add(campi);
		dati.add(valori);
		
		bottoni.add(cp);
		bottoni.add(abbonamento);
		
		
		
		this.add(titolo,BorderLayout.NORTH);
		this.add(dati,BorderLayout.CENTER);
		this.add(bottoni);
		
		
	}
	
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
