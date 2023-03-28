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


/**
 * Classe che crea la view della pagina di login usata 
 * dagli utenti per accedere al sistema. 
 *
 * @author Jacopo Piccoli
 */
public class LoginView extends AView {
	
	JPanel tutto,testo, bottoni, titolo,pagina, b,ba;
	JTextField username;
	JPasswordField password;
	JLabel u, p,l, icona, stringa;
	JButton accedi, registrati;
	Image img;

	public LoginView() {
		this.setLayout(new BorderLayout());

		tutto=new JPanel();
		testo = new JPanel();
		bottoni = new JPanel();
		titolo = new JPanel();
		pagina = new JPanel();
		b = new JPanel();

		
		
		username=new JTextField();
		username.setColumns(15);

		password = new JPasswordField();
		password.setColumns(15);

		u = new JLabel("Username");
		u.setFont(new java.awt.Font("Arial", 1, 16));
		p = new JLabel("Password");
		p.setFont(new java.awt.Font("Arial", 1, 16));
		l = new JLabel("LOGIN");
		stringa = new JLabel("<html>Non hai un account?? &nbsp  &nbsp  &nbsp  </html>");
		icona = new JLabel();

		l.setFont(new java.awt.Font("Arial", 1, 24));

		accedi = new JButton("Login");
		registrati = new JButton("Registrati");

		img = new ImageIcon(this.getClass().getResource("/icona.jpg")).getImage();
		icona.setIcon(new ImageIcon(img));

		titolo.setLayout(new GridLayout(1, 1));
		titolo.add(l);

		l.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel testi=new JPanel();
		JPanel text=new JPanel();
		
		testi.setLayout(new GridLayout(2,1));
		
		testi.add(u);
		testi.add(p);
		
		text.setLayout(new GridLayout(2,1));
		text.add(username);
		text.add(password);
		
		
		testo.add(testi);
		testo.add(text);
		
		ba = new JPanel();
		ba.add(accedi);
		

		b.setLayout(new BorderLayout());
		b.add(ba,BorderLayout.NORTH);
		b.add(stringa,BorderLayout.WEST);
		b.add(registrati,BorderLayout.EAST);

		bottoni.add(b);

		tutto.setLayout(new GridLayout(3, 1));
		tutto.add(titolo);
		tutto.add(testo);
		tutto.add(bottoni);
		
		pagina.setLayout(new BorderLayout());
		pagina.add(tutto,BorderLayout.CENTER);

		this.add(icona, BorderLayout.WEST);
		this.add(pagina, BorderLayout.CENTER);

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
