package it.unipv.sfw.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

/**
 * Classe che rappresenta la schermata di registrazione dell'utente.
 * 
 * @author Simone Platano,Jacopo Piccoli, Gabriele Invernizzi
 * @see AView
 */
public class RegistrazioneView extends AView {

	private JPanel destraPanel, contenitore;
	private JTextField email, nome, cognome, data;
	private JPasswordField password;
	private JLabel imgLabel;
	private JButton loginBtn, registratiBtn;

	private final int textFieldsColumns = 15;

	public RegistrazioneView(Dimension dim) {

		// Fonts
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

		JPanel titoloPanel = new JPanel();
		titoloPanel.setLayout(new GridLayout(1, 1));
		JLabel regLabel = new JLabel("REGISTRAZIONE");
		regLabel.setHorizontalAlignment(JLabel.CENTER);
		regLabel.setFont(largeFont);
		titoloPanel.add(regLabel);

		JPanel infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(5, 2, 0, 3));
		int destraPanelInset = dim.width / 12;
		destraPanel.setBorder(new EmptyBorder(0, destraPanelInset, 0, destraPanelInset));

		JLabel emailLabel = new JLabel("Email");
		JLabel passwordLabel = new JLabel("Password");
		JLabel nomeLabel = new JLabel("Nome");
		JLabel cognomeLabel = new JLabel("Cognome");
		JLabel dataLabel = new JLabel("Data di nascita");
		JLabel accountGiaEsistenteLabel = new JLabel("<html>Hai già un account? &nbsp  &nbsp  &nbsp  </html>");

		email = new JTextField();
		nome = new JTextField();
		cognome = new JTextField();
		data = new JTextField();
		email.setColumns(textFieldsColumns);
		nome.setColumns(textFieldsColumns);
		cognome.setColumns(textFieldsColumns);
		data.setColumns(textFieldsColumns);

		password = new JPasswordField();
		password.setColumns(textFieldsColumns);

		infoPanel.add(nomeLabel);
		infoPanel.add(nome);
		infoPanel.add(cognomeLabel);
		infoPanel.add(cognome);
		infoPanel.add(dataLabel);
		infoPanel.add(data);
		infoPanel.add(emailLabel);
		infoPanel.add(email);
		infoPanel.add(passwordLabel);
		infoPanel.add(password);

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

	public JTextField getData() {
		return data;
	}

	public JTextField getEmail() {
		return email;
	}

	public JPasswordField getPassword() {
		return password;
	}

	@Override
	public Type getType() {
		return AView.Type.REGISTRAZIONE;
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
