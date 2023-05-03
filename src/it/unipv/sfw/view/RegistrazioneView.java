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


	private JPanel tutto,testo, bottoni, titolo, b, ba,contenitore,text,testi;
	private JTextField ce,cn,cc,cd;//casellaemail,casellanome,casellacognome,caselladata
	private JPasswordField password;
	private JLabel e, p, r, n, c, d, icona, stringa;
	private JButton login, registrati;
	private ImageIcon img;

	public RegistrazioneView(Dimension dim) {
		
		//inizializzazione JPanel
		contenitore=new JPanel();
		tutto=new JPanel();
		testo = new JPanel();
		bottoni = new JPanel();
		titolo = new JPanel();
		b = new JPanel();
		ba = new JPanel();
		testi=new JPanel();
		text=new JPanel();
		
		//Inizializzazione JLabel
		e = new JLabel("email");
		p = new JLabel("Password");
		r = new JLabel("REGISTRAZIONE");
		n=new JLabel("Nome");
		c=new JLabel("Cognome");
		d=new JLabel("Data di nascita");
		icona = new JLabel();
		stringa = new JLabel("<html>Hai già un account?? &nbsp  &nbsp  &nbsp  </html>");
		
		//Inizializzazione JTextField

		ce = new JTextField();
		cn = new JTextField();
		cc = new JTextField();
		cd = new JTextField();
		
		//Inizializzazione JPasswordField
		password = new JPasswordField();
		
		//Inizializzazione JButton
		login = new JButton("Login");
		registrati = new JButton("Registrati");
		
		//Inizializzazione ImageIcon
		img = new ImageIcon(this.getClass().getResource("/icona.jpg"));
		
		//Specifiche, Layout e Font
		contenitore.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		tutto.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		icona.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		img = new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/2,(int)(dim.height-45)/2,  java.awt.Image.SCALE_SMOOTH)); 
		
		ce.setColumns(15);
		cn.setColumns(15);		
		cc.setColumns(15);		
		cd.setColumns(15);
		password.setColumns(15);

		
		e.setFont(new java.awt.Font("Arial", 1, 16));
		p.setFont(new java.awt.Font("Arial", 1, 16));
		n.setFont(new java.awt.Font("Arial", 1, 16));
		c.setFont(new java.awt.Font("Arial", 1, 16));
		d.setFont(new java.awt.Font("Arial", 1, 16));
		r.setFont(new java.awt.Font("Arial", 1, 24));

		titolo.setLayout(new GridLayout(1, 1));
		titolo.add(r);
		r.setHorizontalAlignment(JLabel.CENTER);
		
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
		
		icona.setIcon(img);
		
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
		
		contenitore .setLayout(new GridLayout(1,2));
		contenitore.add(icona);
		contenitore.add(tutto);
		
		this.add(contenitore);

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
	
	@Override
	public void onWindowResized(Dimension dim) {
		
		contenitore.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		tutto.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		icona.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		img = new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/2,(int)(dim.height-45)/2,  java.awt.Image.SCALE_SMOOTH));
		icona.setIcon(img);
		
		contenitore.revalidate();
		contenitore.repaint();
	}
}
