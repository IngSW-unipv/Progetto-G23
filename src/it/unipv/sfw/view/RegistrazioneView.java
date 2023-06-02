package it.unipv.sfw.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;

import java.awt.*;
import java.time.LocalDate;

/**
 * Classe che rappresenta la schermata di registrazione dell'utente.
 * 
 * @author Simone Platano,Jacopo Piccoli, Gabriele Invernizzi
 * @see AView
 */
public class RegistrazioneView extends AView {

	private JPanel destraPanel, contenitore;
	private JTextField email, nome, cognome;
	private DatePicker data;
	private JPasswordField password;
	private JLabel imgLabel, errorLabel;
	private JButton loginBtn, registratiBtn;
	

	public RegistrazioneView(Dimension dim) {

		// Fonts
		Font smallFont = new Font("Arial", 1, 12);
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 24);

		// Inizializzazione bottoni
		loginBtn = new JButton("Login");
		registratiBtn = new JButton("Registrati");

		// Inizializzazione immagine di sinistra
		ImageIcon img = new ImageIcon(this.getClass().getResource("/stadio.jpg"));

		img = new ImageIcon(img.getImage().getScaledInstance((int) (dim.width) / 2, (int) (dim.height - 45) / 2,
				Image.SCALE_SMOOTH));
		imgLabel = new JLabel(img);
		imgLabel.setPreferredSize(new Dimension(dim.width / 2, ((int) (dim.height - 45))));

		// Inizializzazione panel contenitore
		contenitore = new JPanel();
		contenitore.setPreferredSize(new Dimension(dim.width, ((int) (dim.height - 45))));

		// Panel a destra, delle info
		destraPanel = new JPanel();
		destraPanel.setLayout(new GridLayout(3, 1));
		destraPanel.setPreferredSize(new Dimension(dim.width / 2, ((int) (dim.height - 45))));
		
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new GridLayout(1, 1));
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(smallFont);
		errorLabel.setHorizontalAlignment(JLabel.CENTER);
		

		JPanel titoloPanel = new JPanel();
		titoloPanel.setLayout(new GridLayout(1, 1));
		JLabel regLabel = new JLabel("REGISTRAZIONE");
		regLabel.setHorizontalAlignment(JLabel.CENTER);
		regLabel.setFont(largeFont);
		titoloPanel.add(regLabel);

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridBagLayout());
		
		int destraPanelInset = dim.width / 12;
		destraPanel.setBorder(new EmptyBorder(0, destraPanelInset, 0, destraPanelInset));

		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(mediumFont);
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(mediumFont);
		JLabel nomeLabel = new JLabel("Nome");
		nomeLabel.setFont(mediumFont);
		JLabel cognomeLabel = new JLabel("Cognome");
		cognomeLabel.setFont(mediumFont);
		JLabel dataLabel = new JLabel("Data di nascita");
		dataLabel.setFont(mediumFont);
		JLabel accountGiaEsistenteLabel = new JLabel("<html>Hai già un account? &nbsp  &nbsp  &nbsp  </html>");
		
		email = new JTextField();
		nome = new JTextField();
		cognome = new JTextField();
		data = new DatePicker();
		password = new JPasswordField();
		
		// Creazione della griglia
		GridBagConstraints infoConstraints = new GridBagConstraints();
		infoConstraints.fill = GridBagConstraints.HORIZONTAL;
		infoConstraints.insets = new Insets(5, 2, 0, 15);
		
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 0;
		infoConstraints.gridwidth = 2;
		infoPanel.add(errorLabel, infoConstraints);
		infoConstraints.gridwidth = GridBagConstraints.RELATIVE;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 1;
		infoPanel.add(nomeLabel, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 1;
		infoPanel.add(nome, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 2;
		infoPanel.add(cognomeLabel, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 2;
		infoPanel.add(cognome, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 3;
		infoPanel.add(dataLabel, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 3;
		infoPanel.add(data, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 4;
		infoPanel.add(emailLabel, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 4;
		infoPanel.add(email, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 5;
		infoPanel.add(passwordLabel, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 5;
		infoPanel.add(password, infoConstraints);

		JPanel bottoniContainerPanel = new JPanel();
		
		JPanel bottoniPanel = new JPanel();
		bottoniPanel.setLayout(new BorderLayout());
		
		JPanel regPanel = new JPanel();
		regPanel.add(registratiBtn);

		bottoniPanel.add(regPanel, BorderLayout.NORTH);
		bottoniPanel.add(accountGiaEsistenteLabel, BorderLayout.WEST);
		bottoniPanel.add(loginBtn, BorderLayout.EAST);
		
		bottoniContainerPanel.add(bottoniPanel);

		
		destraPanel.add(titoloPanel);
		destraPanel.add(infoPanel);
		destraPanel.add(bottoniContainerPanel);

		contenitore.setLayout(new GridLayout(1, 2));
		contenitore.add(imgLabel);
		contenitore.add(destraPanel);

		this.add(contenitore);

	}

	public JButton getRegistratiBtn() {
		return registratiBtn;
	}

	public JButton getToLoginBtn() {
		return loginBtn;
	}

	public JTextField getNome() {
		return nome;
	}

	public JTextField getCognome() {
		return cognome;
	}

	public LocalDate getData() {
		return data.getDate();
	}

	public JTextField getEmail() {
		return email;
	}

	public JPasswordField getPassword() {
		return password;
	}
	
	public void onEmptyField() {
		errorLabel.setText("Non tutti i campi sono stati riempiti!");
	}
	
	public void onWrongEmailFormat() {
		errorLabel.setText("Il formato dell'email non è valido!");
	}
	
	public void onAccountAlreadyExisting(String accEmail) {
		errorLabel.setText("L'account: \"" + accEmail + "\" esiste già.");
	}

	@Override
	public void onWindowResized(Dimension dim) {

		contenitore.setPreferredSize(new Dimension(dim.width, ((int) (dim.height - 45))));
		destraPanel.setPreferredSize(new Dimension(dim.width / 2, ((int) (dim.height - 45))));
		int destraPanelInset = dim.width / 12;
		destraPanel.setBorder(new EmptyBorder(0, destraPanelInset, 0, destraPanelInset));
		
		imgLabel.setPreferredSize(new Dimension(dim.width / 2, ((int) (dim.height - 45))));
		ImageIcon img = new ImageIcon(((ImageIcon) imgLabel.getIcon()).getImage()
				.getScaledInstance((int) (dim.width) / 2, (int) (dim.height - 45) / 2, Image.SCALE_SMOOTH));
		imgLabel.setIcon(img);

		contenitore.revalidate();
		contenitore.repaint();
	}
}
