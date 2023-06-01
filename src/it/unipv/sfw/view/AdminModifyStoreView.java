package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
	private JButton confirmBtn, backBtn, deleteBtn;

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
				
		JPanel fieldsPanel = new JPanel();
		fieldsPanel.setLayout(new GridBagLayout());
		
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
		
		confirmBtn = new JButton("CONFERMA");
		confirmBtn.setFont(mediumFont);
		deleteBtn = new JButton("ELIMINA");
		deleteBtn.setFont(mediumFont);
		backBtn = new JButton("ANNULLA");
		backBtn.setFont(mediumFont);
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.insets = new Insets(5, 2, 0, 15);
		
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 5;
		gridConstraints.weightx = 1.0;
		fieldsPanel.add(errorLabel, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.weightx = 0.5;
		fieldsPanel.add(nomeLabel, gridConstraints);
		gridConstraints.gridx = 4;
		gridConstraints.gridy = 1;
		fieldsPanel.add(nome, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		fieldsPanel.add(prezzoLabel, gridConstraints);
		gridConstraints.gridx = 4;
		gridConstraints.gridy = 2;
		fieldsPanel.add(prezzo, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 3;
		fieldsPanel.add(quantitaLabel, gridConstraints);
		gridConstraints.gridx = 4;
		gridConstraints.gridy = 3;
		fieldsPanel.add(quantita, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 4;
		fieldsPanel.add(descrLabel, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 5;
		gridConstraints.gridheight = 3;
		gridConstraints.gridwidth = 5;
		fieldsPanel.add(descr, gridConstraints);
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 8;
		gridConstraints.gridheight = 1;
		gridConstraints.gridwidth = 1;
		gridConstraints.ipady = 5;
		fieldsPanel.add(backBtn, gridConstraints);
		gridConstraints.gridx = 4;
		fieldsPanel.add(confirmBtn, gridConstraints);
		if (false) {
			gridConstraints.gridx = 2;
			fieldsPanel.add(deleteBtn, gridConstraints);
		}
		
		JPanel container = new JPanel();
		container.add(fieldsPanel);
		
		this.setLayout(new BorderLayout());
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(container, BorderLayout.CENTER);
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
	
	
	public JTextField getNome() {
		return nome;
	}

	public JTextField getPrezzo() {
		return prezzo;
	}

	public JTextField getQuantita() {
		return quantita;
	}

	public JTextArea getDescr() {
		return descr;
	}

	public JButton getConfirmBtn() {
		return confirmBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
