package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


/**
 * Classe che crea la view della pagina di login usata 
 * dagli utenti per accedere al sistema. 
 *
 * @author Jacopo Piccoli
 */
public class LoginView extends AView {
	
	private JPanel destraPanel, contenitore,errorPanel;
	private JTextField username;
	private JPasswordField password;
	private JLabel  imgLabel;
	private JButton loginBtn, registratiBtn;
	private ImageIcon img;

	public LoginView(Dimension dim) {
		
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 24);
		
		//Inizializzazione JPanel
		contenitore=new JPanel();
		destraPanel=new JPanel();
		errorPanel=new JPanel();
		
		//Inizializzazione JLabel
		imgLabel = new JLabel();
		JLabel userLabel = new JLabel("Username");
		JLabel passLabel = new JLabel("Password");
		JLabel logLabel = new JLabel("LOGIN");
		
		JLabel accountNuovo = new JLabel("<html>Non hai un account? &nbsp  &nbsp  &nbsp  </html>");
		JLabel errLabel=new JLabel("Username o Password errati!");
		errLabel.setForeground(Color.red);
		
		//Inizializzazione JTextField
		username=new JTextField();
		
		//Iniziallizzazione JPasswordField
		password = new JPasswordField();
		
		//Inizializzazione JButton
		loginBtn = new JButton("Login");
		registratiBtn = new JButton("Registrati");
		
		//inizializzazione ImageIcon
		img = new ImageIcon(this.getClass().getResource("/stadio.jpg"));
		
		//Specifiche, Layout e Font
		contenitore.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		destraPanel.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		imgLabel.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		img = new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/2,(int)(dim.height-45)/2,  java.awt.Image.SCALE_SMOOTH)); 
		
		username.setColumns(15);
		password.setColumns(15);
		
		userLabel.setFont(mediumFont);
		passLabel.setFont(mediumFont);
		logLabel.setFont(largeFont);
		
		JPanel titoloPanel=new JPanel();
		titoloPanel.setLayout(new GridLayout(1, 1));
		titoloPanel.add(logLabel);
		logLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel infoPanel=new JPanel();
		infoPanel.setLayout(new GridBagLayout());		
		GridBagConstraints infoConstraints = new GridBagConstraints();
		infoConstraints.fill = GridBagConstraints.HORIZONTAL;
		infoConstraints.insets = new Insets(2, 2, 0, 15);
		
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 0;
		infoPanel.add(userLabel, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 0;
		infoPanel.add(username, infoConstraints);
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 1;
		infoPanel.add(passLabel, infoConstraints);
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 1;
		infoPanel.add(password, infoConstraints);
		
		imgLabel.setIcon(img);

		JPanel accPanel=new JPanel();
		accPanel.add(loginBtn);		
		
		JPanel bottoniPanel=new JPanel();
		bottoniPanel.setLayout(new BorderLayout());
		bottoniPanel.add(accPanel,BorderLayout.NORTH);
		bottoniPanel.add(accountNuovo,BorderLayout.WEST);
		bottoniPanel.add(registratiBtn,BorderLayout.EAST);		
		
		JPanel bottoniContainerPanel=new JPanel();
		bottoniContainerPanel.add(bottoniPanel);
		
		errorPanel.add(errLabel);
				
		JPanel campiLoginPanel=new JPanel();
		campiLoginPanel.setLayout(new GridLayout(3,1));
		campiLoginPanel.add(infoPanel);
		campiLoginPanel.add(errorPanel);
		errorPanel.setVisible(false);
		
		destraPanel.setBorder(new EmptyBorder(0, dim.width / 12, 0, dim.width / 12));

		destraPanel.setLayout(new GridLayout(3, 1));
		destraPanel.add(titoloPanel);
		destraPanel.add(campiLoginPanel);
		destraPanel.add(bottoniContainerPanel);
				
		contenitore .setLayout(new GridLayout(1,2));
		contenitore.add(imgLabel);
		contenitore.add(destraPanel);
		
		this.add(contenitore);

	}

	@Override
	public Type getType() {
		return AView.Type.LOGIN;
	}

	public JButton getAccediButton() {
		return loginBtn;
	}

	public JButton getRegistratiButton() {
		return registratiBtn;
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
		destraPanel.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		imgLabel.setPreferredSize(new Dimension(dim.width/2,((int) (dim.height-45))));
		img = new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/2,(int)(dim.height-45)/2,  java.awt.Image.SCALE_SMOOTH));
		imgLabel.setIcon(img);
	
		contenitore.revalidate();
		contenitore.repaint();
	}
	
	public void upError() {
		errorPanel.setVisible(true);
		contenitore.repaint();
	}
	
	public void onLoad() {
		username.setText("");
		password.setText("");
	}
}
