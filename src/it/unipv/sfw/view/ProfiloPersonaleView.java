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
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.model.utente.Utente.Type;
import it.unipv.sfw.view.buttons.UtenteButton;

/**
 * Classe che rappresenta la schermata del profilo personale dell'utente e
 * dell'admin.
 *
 * @author Jacopo Piccoli
 * @see AView
 */
public class ProfiloPersonaleView extends AView {

	private JPanel contenitore;
	private JLabel errorLabel;
	private JButton cambioPassBtn, homeBtn;
	private ArrayList<UtenteButton> acquista;
	private JPasswordField vecchiaPass, nuovaPass, confermaPass;
	private JMenuBar i, abb;
	private JMenu abbBtn, info;

	public ProfiloPersonaleView(Dimension dim, Utente u, int biglietti) {

		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 24);

		JLabel titoloLabel = new JLabel("PROFILO PERSONALE");
		titoloLabel.setBackground(Color.BLUE);
		titoloLabel.setOpaque(true);
		titoloLabel.setFont(largeFont);

		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(mediumFont);
		JLabel nome = new JLabel(u.getNome());
		nome.setFont(mediumFont);

		JLabel cognomeLabel = new JLabel("Cognome:");
		cognomeLabel.setFont(mediumFont);
		JLabel cognome = new JLabel(u.getCognome());
		cognome.setFont(mediumFont);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(mediumFont);
		JLabel email = new JLabel(u.getEmail());
		email.setFont(mediumFont);

		JLabel dataLabel = new JLabel("Data di nascita:");
		dataLabel.setFont(mediumFont);
		JLabel datanascita = new JLabel("" + u.getDataNascita());
		datanascita.setFont(mediumFont);

		JLabel clienteLabel = new JLabel("Tipo di Utente:");
		clienteLabel.setFont(mediumFont);

		String tipoUtente = null;
		if (u.getType() == Type.CLIENTE) {
			if (((Cliente) u).getAbb() == null) {
				tipoUtente = "Cliente";
			} else {
				switch (Sessione.getIstance().getTipoAbb()) {
				case LIV0:
					tipoUtente = "Nessun abbonamento";
					break;
				case LIV1:
					tipoUtente = "Abbonato di livello 1";
					break;
				case LIV2:
					tipoUtente = "Abbonato di livello 2";
					break;
				case LIV3:
					tipoUtente = "Abbonato di livello 3";
					break;
				}
			}
		} else {
			tipoUtente = "Amministratore";
		}

		JLabel tipocliente = new JLabel(tipoUtente);
		tipocliente.setFont(mediumFont);

		JLabel bigliettiLabel = new JLabel("Numero di Biglietti acquistati:");
		bigliettiLabel.setFont(mediumFont);
		JLabel bigliettiacquistati = new JLabel("" + biglietti);
		bigliettiacquistati.setFont(mediumFont);

		i = new JMenuBar();
		info = new JMenu("i");
		JLabel infoAbb = new JLabel("<html> Un abbonato avrà a disposizione tre livelli <br>"
				+ " di abbonamento che gli daranno diversi vantaggi <br> "
				+ " nello store, nelle partite e nel museo.</html>");
		info.add(infoAbb);
		i.add(info);

		cambioPassBtn = new JButton("Cambia Password");

		abb = new JMenuBar();
		abbBtn = new JMenu("Abbonati");
		Dimension d = new Dimension(395, 100);
		// Create the "cards".
		JPanel abb1 = new JPanel();
		abb1.setPreferredSize(d);
		abb1.setLayout(new BorderLayout());

		JPanel abb2 = new JPanel();
		abb2.setPreferredSize(d);
		abb2.setLayout(new BorderLayout());

		JPanel abb3 = new JPanel();
		abb3.setPreferredSize(d);
		abb3.setLayout(new BorderLayout());

		JPanel bottoni = new JPanel();

		if (u.getType() == Type.CLIENTE) {
			acquista = new ArrayList<>();

			acquista.add(new UtenteButton("Acquista", 0));
			acquista.add(new UtenteButton("Acquista", 1));
			acquista.add(new UtenteButton("Acquista", 2));

			JLabel abb1Label = new JLabel(
					"<html>Il primo livello include sconti del 25% per i biglietti delle partite,del museo e dello store.<br> </html>");

			JLabel abb2Label = new JLabel(
					"<html>Il primo livello include sconti del 50% per i biglietti delle partite,del museo e dello store.</html>");

			JLabel abb3Label = new JLabel(
					"<html>Il primo livello include sconti del 75% per i biglietti delle partite,del museo e dello store.<html>");

			if (((Cliente) u).getAbb() != null) {
				switch (Sessione.getIstance().getTipoAbb()) {
				case LIV3:
					acquista.get(2).setEnabled(false);
				case LIV2:
					acquista.get(1).setEnabled(false);
				case LIV1:
					acquista.get(0).setEnabled(false);
				}
			}

			abb1.add(abb1Label, BorderLayout.CENTER);
			abb1.add(acquista.get(0), BorderLayout.SOUTH);
			abb2.add(abb2Label, BorderLayout.CENTER);
			abb2.add(acquista.get(1), BorderLayout.SOUTH);
			abb3.add(abb3Label, BorderLayout.CENTER);
			abb3.add(acquista.get(2), BorderLayout.SOUTH);

			JTabbedPane tabbedPane = new JTabbedPane();
			tabbedPane.addTab("Abbonamento Liv. 1", abb1);
			tabbedPane.addTab("Abbonamento Liv. 2", abb2);
			tabbedPane.addTab("Abbonamento Liv. 3", abb3);

			abbBtn.add(tabbedPane);
			abb.add(abbBtn);

			JPanel abbPanel = new JPanel();
			abbPanel.setLayout(new BorderLayout());
			abbPanel.add(abb, BorderLayout.CENTER);
			abbPanel.add(i, BorderLayout.EAST);

			bottoni.setLayout(new FlowLayout());
			bottoni.add(cambioPassBtn);
			bottoni.add(abbPanel);
			bottoni.setOpaque(true);
		} else {

			bottoni.setLayout(new FlowLayout());
			bottoni.add(cambioPassBtn);
			bottoni.setOpaque(true);
		}

		Icon img = new ImageIcon(getClass().getResource("/home.png"));

		homeBtn = new JButton();
		homeBtn.setIcon(img);
		homeBtn.setBackground(Color.BLUE);
		homeBtn.setOpaque(true);

		JPanel titolo = new JPanel();
		titolo.setLayout(new BorderLayout());
		titoloLabel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK, 10));
		titolo.add(titoloLabel, BorderLayout.CENTER);
		titolo.add(homeBtn, BorderLayout.EAST);

		JPanel dati = new JPanel();

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
		if (u.getType() == Type.CLIENTE) {
			dati.add(bigliettiLabel);
			dati.add(bigliettiacquistati);
		}

		dati.setPreferredSize(new Dimension(dim.width / 2, 200));
		dati.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, dim.width / 5));

		JPanel cambiaPass = new JPanel();
		JLabel cambiaPassword = new JLabel("Cambia Password");
		JLabel vecchiaPassword = new JLabel("Vecchia Password*:");
		JLabel nuovaPassword = new JLabel("Nuova Password*:");
		JLabel confermaPassword = new JLabel("Conferma nuova password*:");
		errorLabel = new JLabel("");
		errorLabel.setFont(mediumFont);
		errorLabel.setForeground(Color.red);

		vecchiaPass = new JPasswordField();
		nuovaPass = new JPasswordField();
		confermaPass = new JPasswordField();

		cambiaPassword.setFont(largeFont);
		vecchiaPassword.setFont(mediumFont);
		nuovaPassword.setFont(mediumFont);
		confermaPassword.setFont(mediumFont);

		cambiaPass.setSize(d.width / 3, dim.height / 3);
		cambiaPass.setLayout(new GridBagLayout());

		GridBagConstraints infoConstraints = new GridBagConstraints();

		infoConstraints.fill = GridBagConstraints.HORIZONTAL;
		infoConstraints.insets = new Insets(7, 1, 5, 15);

		infoConstraints.gridx = 0;
		infoConstraints.gridy = 0;
		cambiaPass.add(cambiaPassword, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 0;
		cambiaPass.add(errorLabel, infoConstraints);
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
		cambiaPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

		contenitore = new JPanel();
		contenitore.setLayout(new BorderLayout());
		contenitore.add(dati, BorderLayout.NORTH);
		contenitore.add(cambiaPass, BorderLayout.WEST);
		contenitore.add(bottoni, BorderLayout.SOUTH);
		contenitore.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

		contenitore.setOpaque(true);

		this.setLayout(new BorderLayout());
		this.add(titolo, BorderLayout.NORTH);
		this.add(contenitore, BorderLayout.CENTER);

	}

	/**
	 * Funzione utilizzata quando la password precedente errata.
	 */
	public void ErroreVecchiaPassword() {
		errorLabel.setText("Password precedente errata");
	}

	/**
	 * @return Bottoni acquista abbonamento.
	 */
	public Collection<UtenteButton> getButtons() {
		return acquista;
	}

	/**
	 * @return Bottone del cambio password.
	 */
	public JButton getCambiaPassword() {
		return cambioPassBtn;
	}

	/**
	 * @return Campodella conferma password.
	 */
	public JPasswordField getConfermaNuovaPassword() {
		return confermaPass;
	}

	/**
	 * @return Bottone della Home.
	 */
	public JButton getHome() {
		return homeBtn;
	}

	/**
	 * @return Bottone delle informazioni.
	 */
	public JMenu getInfo() {
		return info;
	}

	/**
	 * @return Campo della nuova password.
	 */
	public JPasswordField getNuovaPassword() {
		return nuovaPass;
	}

	/**
	 * @return Campo della vecchia password.
	 */
	public JPasswordField getVecchiaPassword() {
		return vecchiaPass;
	}

	/**
	 * Funzione utilizzata quando la nuova password e quella precedente sono uguali.
	 */
	public void oldPasswordReused() {
		errorLabel.setText("La nuova password e quella precedente sono uguali");
	}

	/**
	 * Funzione utilizzata quando la nuova password e la conferma sono diverse.
	 */
	public void onConfirmPassword() {
		errorLabel.setText("La nuova password e la conferma sono diverse");
	}

	/**
	 * Funzione utilizzata quando non vengono riempiti tutti i campi.
	 */
	public void onEmptyField() {
		errorLabel.setText("Non tutti i campi sono stati riempiti!");
	}

	@Override
	public void onWindowResized(Dimension dim) {
		contenitore.setPreferredSize(new Dimension(dim.width, ((dim.height))));

		contenitore.revalidate();
		contenitore.repaint();
	}

	/**
	 * @param stato lo stato del menu di informazioni.
	 */
	public void setInfoAbb(boolean stato) {
		info.setPopupMenuVisible(stato);
	}
}
