package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.ui.FlatTextAreaUI;

import it.unipv.sfw.model.store.Merchandising;

public class AdminModifyStoreView extends AView {
	
	private JLabel errorLabel;
	private JTextField nome, prezzo, quantita;
	private JTextArea descr;

	public AdminModifyStoreView() {
		init();
	}
	
	public AdminModifyStoreView(Map.Entry<Merchandising, Integer> item) {
		
	}
	
	private void init() {
		// Fonts
		Font smallFont = new Font("Arial", 1, 12);
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 24);
				
		JPanel container = new JPanel();
		container.setLayout(new GridBagLayout());
		
		// Titolo
		JPanel titlePanel = new JPanel();		
		JLabel titoloLabel = new JLabel("AGGIUNGI ITEM");
		titoloLabel.setFont(largeFont);
		titoloLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.setBorder(new EmptyBorder(0, 0, 50, 0));
		titlePanel.add(titoloLabel);
		
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setFont(mediumFont);
		JLabel prezzoLabel = new JLabel("Prezzo:");
		prezzoLabel.setFont(mediumFont);
		JLabel quantitaLabel = new JLabel("Quantità:");
		quantitaLabel.setFont(mediumFont);
		JLabel descrLabel = new JLabel("Descizione:");
		descrLabel.setFont(mediumFont);
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(mediumFont);
		errorLabel.setHorizontalAlignment(JLabel.CENTER);
		errorLabel.setBorder(new EmptyBorder(0, 0, 3, 0));;
		
		nome = new JTextField();
		prezzo = new JTextField();
		quantita = new JTextField();
		descr = new JTextArea(5, 40);
		descr.setEditable(true);
		descr.setFocusable(true);
		descr.setWrapStyleWord(true);
		descr.setLineWrap(true);
		descr.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.insets = new Insets(5, 2, 0, 15);
		
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 4;
		gridConstraints.weightx = 1.0;
		container.add(errorLabel, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.weightx = 0.5;
		container.add(nomeLabel, gridConstraints);
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 1;
		container.add(nome, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		container.add(prezzoLabel, gridConstraints);
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 2;
		container.add(prezzo, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 3;
		container.add(quantitaLabel, gridConstraints);
		gridConstraints.gridx = 3;
		gridConstraints.gridy = 3;
		container.add(quantita, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 4;
		container.add(descrLabel, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 5;
		gridConstraints.gridheight = 3;
		gridConstraints.gridwidth = 4;
		container.add(descr, gridConstraints);
		
		this.setLayout(new BorderLayout());
		JPanel a = new JPanel();
		a.add(container);
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(a, BorderLayout.CENTER);
	}
	
	/**
	 *  Funzione chiamata nel caso in cui il formato di alcuni campi sia errato.
	 */
	public void onInvalidFormat() {
		errorLabel.setText("Il formato dei campi è errato.");
	}
	
	/**
	 *  Funzione onLoad chiamata a caricamento della view.
	 */
	public void onLoad() {
		errorLabel.setText("");
		nome.setText("");
		prezzo.setText("");
		quantita.setText("");
		descr.setText("");
	}
	
	
	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
