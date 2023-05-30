package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unipv.sfw.dao.mysql.RiconoscimentoDAO;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;

public class AdminAddOggettoView extends AView {

	private JPanel centralContainer;
	private JComboBox selectNewObjectType;
	private JTextArea descrizioneField;
	private JButton aggiungiButton, backButton;
	
	public AdminAddOggettoView() {
		
		Font title_font = new java.awt.Font("Arial", 1, 26);
		Font medium_font = new java.awt.Font("Arial", 1, 16);
		
		this.setLayout(new BorderLayout());
		
		JLabel blue_label_up = new JLabel();
		blue_label_up.setLayout(new BorderLayout());
		blue_label_up.setPreferredSize(new Dimension(100,100));
		blue_label_up.setBackground(Color.BLUE);
		blue_label_up.setOpaque(true);
		blue_label_up.setHorizontalAlignment(JLabel.CENTER);
		
		ImageIcon backpage = new ImageIcon(getClass().getResource("/backpage1.png"));
		backpage = new ImageIcon(backpage.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		backButton = new JButton("", backpage);
		backButton.setBackground(Color.BLUE);
		
		JLabel title = new JLabel("  PAGINA DI INSERIMENTO:");
		title.setPreferredSize(new Dimension(200, 50));
		title.setFont(title_font);
		title.setBackground(Color.BLUE);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		blue_label_up.add(backButton, BorderLayout.WEST);
		blue_label_up.add(title, BorderLayout.CENTER);
		
		
		centralContainer = new JPanel();
		centralContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));
		
		// 1
		JPanel tipoPanel = new JPanel();
		tipoPanel.setPreferredSize(new Dimension(400, 75));
		tipoPanel.setLayout(new GridLayout(2, 1)); 
		
		JLabel tipo_label = new JLabel("Selezionare il tipo di oggetto da aggiungere:");
		tipo_label.setFont(medium_font);
		tipo_label.setOpaque(true);
		
		String[] tipiSelezionabili = {"Cimelio", "Riconsocimento"};
		selectNewObjectType = new JComboBox(tipiSelezionabili);
		
		tipoPanel.add(tipo_label);
		tipoPanel.add(selectNewObjectType);
		
		// 2
		JPanel descrizionePanel = new JPanel();
		descrizionePanel.setPreferredSize(new Dimension(400, 100));
		descrizionePanel.setLayout(new BorderLayout());
		//descrizionePanel.setLayout(new GridLayout(2, 1, 0, 20)); 
		
		JLabel descrizione_label = new JLabel("Inserire descrizione del nuovo oggetto:");
		descrizione_label.setFont(medium_font);
		descrizione_label.setOpaque(true);
		
		descrizioneField = new JTextArea(5, 30);
		
		JScrollPane testo = new JScrollPane(descrizioneField);
		testo.setBorder(BorderFactory.createTitledBorder("Descrizione:"));
		//descrizioneField.setColumns(30);
		//descrizioneField.setRows(5);
		descrizioneField.setLineWrap(true);
		descrizioneField.setWrapStyleWord(true);
		
		descrizionePanel.add(descrizione_label, BorderLayout.NORTH);
		descrizionePanel.add(testo, BorderLayout.CENTER);
		
		
		centralContainer.add(tipoPanel);
		centralContainer.add(descrizionePanel);

		
		this.add(blue_label_up, BorderLayout.NORTH);
		this.add(centralContainer, BorderLayout.CENTER);
		
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
