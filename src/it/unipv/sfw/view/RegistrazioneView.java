package it.unipv.sfw.view;

import javax.swing.*;
import java.awt.*;

/** 
 * Classe che rappresenta la schermata di registrazione
 * dell'utente. 
 *  
 * @author Simone Platano,Jacopo Piccoli
 * @see AView
 */
public class RegistrazioneView extends AView {


	JPanel tutto,testo, bottoni, titolo,pagina, b, ba;
	JTextField ce,cn,cc,cd;//casellaemail,casellanome,casellacognome,caselladata
	JPasswordField password;
	JLabel e, p, r, n, c, d, icona, stringa;
	JButton login, registrati;
	Image img;

	public RegistrazioneView() {
		this.setLayout(new BorderLayout());

		tutto=new JPanel();
		testo = new JPanel();
		bottoni = new JPanel();
		titolo = new JPanel();
		pagina = new JPanel();
		b = new JPanel();
		
		ce = new JTextField();
		ce.setColumns(15);
		
		cn = new JTextField();
		cn.setColumns(15);
		
		cc = new JTextField();
		cc.setColumns(15);
		
		cd = new JTextField();
		cd.setColumns(15);

		password = new JPasswordField();
		password.setColumns(15);

		e = new JLabel("email");
		e.setFont(new java.awt.Font("Arial", 1, 16));
		p = new JLabel("Password");
		p.setFont(new java.awt.Font("Arial", 1, 16));
		n=new JLabel("Nome");
		n.setFont(new java.awt.Font("Arial", 1, 16));
		c=new JLabel("Cognome");
		c.setFont(new java.awt.Font("Arial", 1, 16));
		d=new JLabel("Data di nascita");
		d.setFont(new java.awt.Font("Arial", 1, 16));
		r = new JLabel("REGISTRAZIONE");
		stringa = new JLabel("<html>Hai già un account?? &nbsp  &nbsp  &nbsp  </html>");
		icona = new JLabel();

		r.setFont(new java.awt.Font("Arial", 1, 24));

		login = new JButton("Login");
		registrati = new JButton("Registrati");

		img = new ImageIcon(this.getClass().getResource("/icona.jpg")).getImage();
		icona.setIcon(new ImageIcon(img));

		titolo.setLayout(new GridLayout(1, 1));
		titolo.add(r);

		r.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel testi=new JPanel();
		JPanel text=new JPanel();
		
		testi.setLayout(new GridLayout(5,1));
		testi.add(n);
		testi.add(c);
		testi.add(d);
		testi.add(e);
		testi.add(p);
		
		text.setLayout(new GridLayout(5,1));
		text.add(cn);
		text.add(cc);
		text.add(cd);
		text.add(ce);
		text.add(password);
		
		
		testo.add(testi);
		testo.add(text);
		
		
		
		ba = new JPanel();
		ba.add(registrati);

		

		b.setLayout(new BorderLayout());
		b.add(ba,BorderLayout.NORTH);
		b.add(stringa,BorderLayout.WEST);
		b.add(login,BorderLayout.EAST);

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

	public JButton getRegistratiBtn() {
		return registrati;
	}

	public JButton getToLoginBtn() {
		return login;
	}

	public JTextField getNome() {
		return cn;
	}

	public JTextField getCognome() {
		return cc;
	}

	public JTextField getData() {
		return cd;
	}

	public JTextField getEmail() {
		return ce;
	}

	public JPasswordField getPassword() {
		return password;
	}

	@Override
	public Type getType() {
		return AView.Type.REGISTRAZIONE;
	}

}
