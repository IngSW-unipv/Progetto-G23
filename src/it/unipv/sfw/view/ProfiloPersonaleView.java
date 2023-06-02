package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.view.buttons.UtenteButton;

public class ProfiloPersonaleView extends AView {
	
	private JPanel titolo,dati,bottoni,contenitore;
	private JLabel errorLabel;
	private JButton cambioPassBtn, homeBtn;
	private ArrayList <UtenteButton> acquista;
	private JPasswordField vecchiaPass,nuovaPass,confermaPass;
	private JMenuBar i,abb;
	private JMenu abbBtn,info;
	private JTabbedPane tabbedPane;
	private Icon img;
	private String tipoClinte;
	
	
	
	public ProfiloPersonaleView(Dimension dim,Cliente cliente) {
		
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 24);
		
		titolo=new JPanel();
		dati=new JPanel();
		bottoni=new JPanel();
		contenitore=new JPanel();
		tabbedPane = new JTabbedPane();
		
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
		
		if(cliente.getAbb() == null) {
			tipoClinte="Cliente";
		} else {
			switch (cliente.getAbb().getTipoAbb()) {
			case TESSERA: tipoClinte="Tesserato"; break;
			case LIV1: tipoClinte = "Abbonato di livello 1"; break;
			case LIV2: tipoClinte = "Abbonato di livello 2"; break;
			case LIV3: tipoClinte = "Abbonato di livello 3"; break;
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
		JLabel infoAbb=new JLabel("<html> Un abbonato avrà a disposizione tre livelli <br>"
							+ " di abbonamento che gli daranno diversi vantaggi <br> "
							+ " nello store, nelle partite e nel museo.</html>");
		info.add(infoAbb);
		i.add(info);
		
		cambioPassBtn=new JButton("Cambia Password");
		
		abb=new JMenuBar();
		abbBtn=new JMenu("Abbonati");
		Dimension d =new Dimension(395,100);
        //Create the "cards".
        JPanel abb1 = new JPanel();
        abb1.setPreferredSize(d);
        abb1.setLayout(new BorderLayout());
        
        JPanel abb2 = new JPanel();
        abb2.setPreferredSize(d);
        abb2.setLayout(new BorderLayout());
        
        JPanel abb3 = new JPanel();
        abb3.setPreferredSize(d);
        abb3.setLayout(new BorderLayout());
        
        acquista=new ArrayList<UtenteButton>();
        
        acquista.add(new UtenteButton("Acquista",0));
        acquista.add(new UtenteButton("Acquista",1));
        acquista.add(new UtenteButton("Acquista",2));
        
        JLabel abb1Label=new JLabel("<html>Il primo livello include tutti i biglietti per le partite giocate in casa,<br> "
        		+ "darà ai clienti una visibilità anticipata per la prenotazione dei biglietti,<br> "
        		+ "e inoltre permetterà loro di prenotare un massimo di quattro biglietti.</html>");
        
        JLabel abb2Label=new JLabel("<html>Il secondo livello oltre ai vantaggi descritti per il primo livello, "
        		+ "include un supplemento di due biglietti prenotabili e permetterà loro di prenotare i biglietti "
        		+ "in un settore riservato solo agli abbonati di livello due e tre.</html>");
        
        JLabel abb3Label=new JLabel("<html>Il livello tre oltre ai vantaggi descritti per il primo e secondo livello, "
        		+ "non limita i biglietti da loro prenotabili per le partite e include uno sconto sugli acquisti effettuabili "
        		+ "sullo store e per l’acquisto di biglietti per il museo.<html>");
        
        abb1.add(abb1Label,BorderLayout.CENTER);
        abb1.add(acquista.get(0),BorderLayout.SOUTH);
        abb2.add(abb2Label,BorderLayout.CENTER);
        abb2.add(acquista.get(1),BorderLayout.SOUTH);
        abb3.add(abb3Label,BorderLayout.CENTER);
        abb3.add(acquista.get(2),BorderLayout.SOUTH);
        
        tabbedPane.addTab("Abbonamento Liv. 1", abb1);
        tabbedPane.addTab("Abbonamento Liv. 2", abb2);
        tabbedPane.addTab("Abbonamento Liv. 3", abb3);
		
		abbBtn.add(tabbedPane);
		abb.add(abbBtn);
			
		JPanel abbPanel=new JPanel();
		abbPanel.setLayout(new BorderLayout());
		abbPanel.add(abb, BorderLayout.CENTER);
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
		dati.setPreferredSize(new Dimension(dim.width/2,200));
		dati.setBorder(javax.swing.BorderFactory.createEmptyBorder(10,10,10,dim.width/5));
		
		JPanel cambiaPass=new JPanel();
		JPanel titoloCambiaPass=new JPanel();
		JPanel valoriCambioPass=new JPanel();
		
		JLabel cambiaPassword=new JLabel("Cambia Password");
		JLabel vecchiaPassword=new JLabel("Vecchia Password*:");
		JLabel nuovaPassword=new JLabel ("Nuova Password*:");
		JLabel confermaPassword=new JLabel("Conferma nuova password*:");
		errorLabel=new JLabel("");
		
		vecchiaPass=new JPasswordField();
		nuovaPass=new JPasswordField();
		confermaPass=new JPasswordField();
		
		cambiaPassword.setFont(largeFont);
		vecchiaPassword.setFont(mediumFont);
		nuovaPassword.setFont(mediumFont);
		confermaPassword.setFont(mediumFont);
		
		cambiaPass.setSize(d.width/3,dim.height/3);
		cambiaPass.setLayout(new GridBagLayout());
		
		GridBagConstraints infoConstraints = new GridBagConstraints();

		infoConstraints.fill = GridBagConstraints.HORIZONTAL;
		infoConstraints.gridwidth = 2;
		infoConstraints.insets = new Insets(7, 1, 5, 15);
		
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 0;
		cambiaPass.add(cambiaPassword, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 1;
		cambiaPass.add(vecchiaPassword, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 2;
		cambiaPass.add(vecchiaPass, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 3;
		cambiaPass.add(nuovaPassword, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 4;
		cambiaPass.add(nuovaPass, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 5;
		cambiaPass.add(confermaPassword, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 6;
		cambiaPass.add(confermaPass, infoConstraints);
		cambiaPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(10,10,10,10));
		
		contenitore.setLayout(new BorderLayout());
		contenitore.add(dati,BorderLayout.NORTH);
		contenitore.add(cambiaPass,BorderLayout.WEST);
		contenitore.add(bottoni,BorderLayout.SOUTH);
		contenitore.setBorder(javax.swing.BorderFactory.createEmptyBorder(10,10,10,10));
		
		contenitore.setOpaque(true);
		
		this.setLayout(new BorderLayout());
		this.add(titolo,BorderLayout.NORTH);		
		this.add(contenitore,BorderLayout.CENTER);
		
		
	}
	
	public Collection<UtenteButton> getButtons() {
		return acquista;
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
	public JButton getCambiaPassword(){
		return cambioPassBtn;
	}
	
	public JPasswordField getVecchiaPassword() {
		return vecchiaPass;
	}

	public JPasswordField getNuovaPassword() {
		return nuovaPass;
	}
	
	public JPasswordField getConfermaNuovaPassword() {
		return confermaPass;
	}
	
	public void onEmptyField() {
		errorLabel.setText("Non tutti i campi sono stati riempiti!");
	}
		
	public void oldPasswordReused() {
		errorLabel.setText("La nuova password e quella precedente sono uguali");
	}
	
	public void onConfirmPassword() {
		errorLabel.setText("La nuova password e la conferma sono diverse");
	}
	
	public void ErroreVecchiaPassword() {
		errorLabel.setText("Password precedente errata");
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		contenitore.setPreferredSize(new Dimension(dim.width,((int) (dim.height))));
	
		contenitore.revalidate();
		contenitore.repaint();
	}
}
