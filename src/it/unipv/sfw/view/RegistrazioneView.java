package it.unipv.sfw.view;

import javax.swing.*;
import java.awt.*;

/** 
 * Classe che rappresenta la schermata di registrazione
 * dell'utente. 
 *  
 * @author Simone Platano
 * @see AView
 */
public class RegistrazioneView extends AView {

	private static final long serialVersionUID = 1L;
	private JPanel Total, bottone, testo, titolo, CampoNome, CampoCognome, CampoMail, CampoData, CampoPassword, accedi,
			vuoto;
	private JLabel n, c, d, e, pw, r, StringaVuota, icona, spazio, log;
	private JButton button, buttonLogin;
	private JTextField nome, cognome, data, email;
	private JPasswordField password;
	private Image img;

	public RegistrazioneView() {
		setLayout(new BorderLayout());

		Total = new JPanel();
		vuoto = new JPanel();
		accedi = new JPanel();
		bottone = new JPanel();
		testo = new JPanel();
		titolo = new JPanel();
		CampoNome = new JPanel();
		CampoCognome = new JPanel();
		CampoMail = new JPanel();
		CampoData = new JPanel();
		CampoPassword = new JPanel();

		spazio = new JLabel("                        ");
		n = new JLabel("                " + "nome:");
		c = new JLabel("          " + "cognome:");
		d = new JLabel("data di nascita:");
		e = new JLabel("                 " + "email:");
		pw = new JLabel("        " + "password:");
		r = new JLabel("         REGISTRAZIONE");
		icona = new JLabel();
		StringaVuota = new JLabel("");
		log = new JLabel("Hai già un account?");
		r.setFont(new java.awt.Font("Arial", 1, 26));
		r.setHorizontalAlignment(JLabel.CENTER);

		nome = new JTextField();
		cognome = new JTextField();
		email = new JTextField();
		data = new JTextField();

		button = new JButton("Registrati");
		buttonLogin = new JButton("Login");

		password = new JPasswordField();

		CampoNome.add(n);
		nome.setColumns(20);
		CampoNome.add(nome);

		CampoCognome.add(c);
		cognome.setColumns(20);
		CampoCognome.add(cognome);

		CampoMail.add(e);
		email.setColumns(20);
		CampoMail.add(email);

		CampoPassword.add(pw);
		password.setColumns(20);
		CampoPassword.add(password);

		titolo.setLayout(new GridLayout(2, 1));
		titolo.add(StringaVuota);
		titolo.add(r);

		CampoData.add(d);
		data.setColumns(20);
		CampoData.add(data);

		// accedi.setLayout(new GridLayout(3,2));
		accedi.add(log);
		accedi.add(buttonLogin);

		testo.setLayout(new GridLayout(5, 1));
		testo.add(CampoNome);
		testo.add(CampoCognome);
		testo.add(CampoData);
		testo.add(CampoMail);
		testo.add(CampoPassword);

		bottone.add(spazio);
		bottone.add(button);

		img = new ImageIcon(this.getClass().getResource("/stadium_icon.png")).getImage();
		icona.setIcon(new ImageIcon(img));

		Total.setLayout(new GridLayout(4, 1));
		Total.add(titolo);
		Total.add(testo);
		Total.add(bottone);
		Total.add(accedi);

		this.add(icona, BorderLayout.WEST);
		this.add(Total, BorderLayout.CENTER);

	}

	public JButton getRegistratiBtn() {
		return button;
	}

	public JButton getToLoginBtn() {
		return buttonLogin;
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

}
