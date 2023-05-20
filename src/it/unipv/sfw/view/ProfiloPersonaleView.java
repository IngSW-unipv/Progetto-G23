package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Utente;

public class ProfiloPersonaleView extends AView {
	
	private JPanel titolo,dati,bottoni,contenitore;
	private JButton cambioPassBtn, abbBtn, homeBtn;
	private JMenuBar i;
	private JMenu info;
	private JLabel infoAbb;
	private Icon img;
	private String tipoClinte;
	
	
	
	public ProfiloPersonaleView(Dimension dim,Cliente cliente) {
		
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 24);
		
		titolo=new JPanel();
		dati=new JPanel();
		bottoni=new JPanel();
		contenitore=new JPanel();
		
		JLabel titoloLabel=new JLabel("PROFILO PERSONALE");
		titoloLabel.setBackground(Color.CYAN);
		titoloLabel.setOpaque(true);
		titoloLabel.setFont(largeFont);
		
		JLabel nomeLabel=new JLabel("Nome:");
		nomeLabel.setFont(mediumFont);
		JLabel nome=new JLabel(cliente.getNome());
		nome.setFont(mediumFont);
		
		JLabel cognomeLabel=new JLabel("Cognome:");
		cognomeLabel.setFont(mediumFont);
		JLabel cognome=new JLabel(cliente.getCognome());
		cognome.setFont(mediumFont);
		
		JLabel emailLabel=new JLabel("Email:");
		emailLabel.setFont(mediumFont);
		JLabel email=new JLabel(cliente.getEmail());
		email.setFont(mediumFont);
		
		JLabel dataLabel=new JLabel("Data di nascita:");
		dataLabel.setFont(mediumFont);
		JLabel datanascita=new JLabel(cliente.getDataNascita());
		datanascita.setFont(mediumFont);
		
		JLabel clienteLabel=new JLabel("Tipo di Utente:");
		clienteLabel.setFont(mediumFont);
		
		if(cliente.getAbb()==null) {
			tipoClinte="Cliente";
		}else {
			if(cliente.getAbb().getTipoAbb()==TipoAbb.TESSERA) {
				tipoClinte="Tesserato";
			}else {
				if(cliente.getAbb().getTipoAbb()==TipoAbb.LIV1) {
					tipoClinte="Abbonato di livello 1";
				}else {
					if(cliente.getAbb().getTipoAbb()==TipoAbb.LIV2) {
						tipoClinte="Abbonato di livello 2";
					}else {
						if(cliente.getAbb().getTipoAbb()==TipoAbb.LIV3) {
							tipoClinte="Abbonato di livello 3";
						}
					}
				}
			}
		}
		
		JLabel tipocliente=new JLabel(tipoClinte);
		tipocliente.setFont(mediumFont);
		
		JLabel bigliettiLabel=new JLabel("Numero di Biglietti acquistati:");
		bigliettiLabel.setFont(mediumFont);
		JLabel bigliettiacquistati=new JLabel("0");
		bigliettiacquistati.setFont(mediumFont);
		
		i=new JMenuBar();		
		info=new JMenu("i");
		infoAbb=new JLabel("<html> Un abbonato avrà a disposizione tre livelli <br>"
							+ " di abbonamento che gli daranno diversi vantaggi <br> "
							+ " nello store e nelle partite.<br>");
		info.add(infoAbb);
		i.add(info);
		
		cambioPassBtn=new JButton("Cambia Password");
		abbBtn=new JButton("Abbonati");
			
		JPanel abbPanel=new JPanel();
		abbPanel.setLayout(new BorderLayout());
		abbPanel.add(abbBtn, BorderLayout.CENTER);
		abbPanel.add(i, BorderLayout.EAST);
		
		img = new ImageIcon(getClass().getResource("/home.png"));
		
		homeBtn=new JButton();
		homeBtn.setIcon(img);
		homeBtn.setBackground(Color.BLUE);
		homeBtn.setOpaque(true);
		
		titolo.setLayout(new BorderLayout());
		titoloLabel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLUE,10));
		titolo.add(titoloLabel,BorderLayout.CENTER);
		titolo.add(homeBtn,BorderLayout.EAST);
		
		
		bottoni.setLayout(new FlowLayout());
		bottoni.add(cambioPassBtn);
		bottoni.add(abbPanel);
		bottoni.setBackground(Color.WHITE);
		bottoni.setOpaque(true);
		
		dati.setLayout(new GridLayout(6, 2, 0, 3));
		dati.add(nomeLabel);
		dati.add(nome);
		dati.add(cognomeLabel);
		dati.add(cognome);
		dati.add(emailLabel);
		dati.add(email);
		dati.add(dataLabel);
		dati.add(datanascita);
		dati.add(clienteLabel);
		dati.add(tipocliente);
		dati.add(bigliettiLabel);
		dati.add(bigliettiacquistati);
		dati.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE,10));
		
		
		contenitore.setLayout(new GridLayout(2,1));
		contenitore.add(dati);
		contenitore.add(bottoni);
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
		return homeBtn;
	}
	
	public JMenu getInfo() {
		return info;
	}
	public void setInfoAbb(boolean stato) {
		info.setPopupMenuVisible(stato);
	}
	

}
