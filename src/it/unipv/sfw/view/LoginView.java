package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	
	private JPanel tutto,testo, bottoni, titolo, b,ba,contenitore,testi,text,errore,campilogin;
	private JTextField username;
	private JPasswordField password;
	private JLabel u, p,l, icona, stringa,e;
	private JButton login, registrati;
	private ImageIcon img;

	public LoginView(Dimension dim) {
		
		//Inizializzazione JPanel
		contenitore=new JPanel();
		tutto=new JPanel();
		testo = new JPanel();
		bottoni = new JPanel();
		titolo = new JPanel();
		b = new JPanel();
		testi=new JPanel();
		text=new JPanel();
		ba = new JPanel();
		errore=new JPanel();
		campilogin=new JPanel();
		
		//Inizializzazione JLabel
		u = new JLabel("Username");
		p = new JLabel("Password");
		l = new JLabel("LOGIN");
		icona = new JLabel();
		stringa = new JLabel("<html>Non hai un account? &nbsp  &nbsp  &nbsp  </html>");
		e=new JLabel("Username o Password errati!");
		e.setForeground(Color.red);
		
		//Inizializzazione JTextField
		username=new JTextField();
		
		//Iniziallizzazione JPasswordField
		password = new JPasswordField();
		
		//Inizializzazione JButton
		login = new JButton("Login");
		registrati = new JButton("Registrati");
		
		//inizializzazione ImageIcon
		img = new ImageIcon(this.getClass().getResource("/icona.jpg"));
		
		//Specifiche, Layout e Font
		contenitore.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		tutto.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		icona.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		img = new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/2,(int)(dim.height-45)/2,  java.awt.Image.SCALE_SMOOTH)); 
		
		username.setColumns(15);
		password.setColumns(15);
		
		u.setFont(new java.awt.Font("Arial", 1, 16));
		p.setFont(new java.awt.Font("Arial", 1, 16));
		l.setFont(new java.awt.Font("Arial", 1, 24));

		titolo.setLayout(new GridLayout(1, 1));
		titolo.add(l);
		l.setHorizontalAlignment(JLabel.CENTER);

		testi.setLayout(new GridLayout(2,1));
		testi.add(u);
		testi.add(p);
		
		text.setLayout(new GridLayout(2,1));
		text.add(username);
		text.add(password);
		
		testo.add(testi);
		testo.add(text);
		
		icona.setIcon(img);

		ba.add(login);
		
		b.setLayout(new BorderLayout());
		b.add(ba,BorderLayout.NORTH);
		b.add(stringa,BorderLayout.WEST);
		b.add(registrati,BorderLayout.EAST);
		
		bottoni.add(b);
		errore.add(e);
		
		campilogin.setLayout(new GridLayout(3,1));
		campilogin.add(testo);
		campilogin.add(errore);
		errore.setVisible(false);
		
		tutto.setLayout(new GridLayout(3, 1));
		tutto.add(titolo);
		tutto.add(campilogin);
		tutto.add(bottoni);
				
		contenitore .setLayout(new GridLayout(1,2));
		contenitore.add(icona);
		contenitore.add(tutto);
		
		this.add(contenitore);

	}

	@Override
	public Type getType() {
		return AView.Type.LOGIN;
	}

	public JButton getAccediButton() {
		return login;
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
	
	public void upError() {
		errore.setVisible(true);
		
		contenitore.repaint();
	}
	
	public void onLoad() {
		username.setText("");
		password.setText("");
	}
}
