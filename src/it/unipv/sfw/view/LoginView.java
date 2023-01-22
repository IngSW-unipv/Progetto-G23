package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends AView {
	private static final long serialVersionUID = 1L;
	JPanel testo, bottoni, titolo, nome, codice, login, b, ba;
	JTextField username;
	JPasswordField password;
	JLabel u, p, t, icona, vuota, stringa;
	JButton accedi, registrati;
	Image img;

	public LoginView() {
		this.setLayout(new BorderLayout());

		testo = new JPanel();
		bottoni = new JPanel();
		titolo = new JPanel();
		nome = new JPanel();
		codice = new JPanel();
		login = new JPanel();
		b = new JPanel();

		username = new JTextField();

		username.setColumns(10);

		password = new JPasswordField();
		password.setColumns(10);

		u = new JLabel("Username");
		p = new JLabel("Password");
		t = new JLabel("LOGIN");
		stringa = new JLabel("<html>Se non hai un account &nbsp  &nbsp  &nbsp  </html>");
		vuota = new JLabel("");
		icona = new JLabel();

		t.setFont(new java.awt.Font("Arial", 1, 24));

		accedi = new JButton("Accedi");
		registrati = new JButton("Registrati");

		img = new ImageIcon(this.getClass().getResource("/icona.jpg")).getImage();
		icona.setIcon(new ImageIcon(img));

		titolo.setLayout(new GridLayout(3, 1));
		titolo.add(vuota);
		titolo.add(t);

		t.setHorizontalAlignment(JLabel.CENTER);

		nome.add(u);
		nome.add(username);
		codice.add(p);
		codice.add(password);

		ba = new JPanel();
		ba.add(accedi);

		testo.setLayout(new GridLayout(4, 1));
		testo.add(nome);
		testo.add(codice);
		testo.add(ba);

		b.setLayout(new GridLayout(1, 2));
		b.add(stringa);
		b.add(registrati);

		bottoni.add(b);

		login.setLayout(new GridLayout(3, 1));
		login.add(titolo);
		login.add(testo);
		login.add(bottoni);

		this.add(icona, BorderLayout.WEST);
		this.add(login, BorderLayout.CENTER);

	}

	@Override
	public Type getType() {
		return AView.Type.LOGIN;
	}

	public JButton getAccediButton() {
		return accedi;
	}

	public JButton getRegistratiButton() {
		return registrati;
	}

	public JTextField getUsernameField() {
		return username;
	}

	public JPasswordField getPasswordField() {
		return password;
	}

}
