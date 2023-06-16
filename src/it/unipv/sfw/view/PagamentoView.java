package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.pagamento.Carta;

public class PagamentoView extends AView {

	private final int ANNO = 2023;

	private JPanel infoPanel, btnsPanel;
	private JButton backBtn, okBtn, carteBtn;
	private JCheckBox salvaCb;
	private JTextField nomeTxt, cognomeTxt, nCartaTxt, cvvTxt;
	private JComboBox<Integer> meseOp, annoOp;
	private JLabel nomeErr, cognomeErr, numeroErr, scadenzaErr, cvvErr;
	private int tipoErr; // 0 - nome, 1 - cognome, 2 - entrambi
	private ArrayList<Carta> carteDisp = new ArrayList<>();
	private JComboBox<String> cartaOp;
	private Utente u;

	public PagamentoView(Dimension dim, Utente u, int tipoPagamento, double prezzo) {
		this.u = u;
		// Fonts
		Font shortFont = new Font("Arial", 1, 14);
		Font mediumFont = new Font("Arial", 1, 16);
		Font largeFont = new Font("Arial", 1, 18);
		Font veryLargeFont = new Font("Arial", 1, 24);

		// Top panel
		JPanel topPanel = new JPanel();
		JPanel topPanelLbl = new JPanel();

		JLabel utente = new JLabel("Utente loggato:   " + u.getNome() + " " + u.getCognome());
		utente.setFont(veryLargeFont);
		utente.setBackground(Color.BLUE);
		utente.setOpaque(true);

		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanelLbl.setBackground(Color.BLUE);
		topPanelLbl.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		topPanelLbl.add(utente);
		topPanel.add(topPanelLbl, BorderLayout.CENTER);

		// Center panel
		JPanel centralPanel = new JPanel();
		JPanel selectScadenza = new JPanel();
		JPanel centerPanelBtns = new JPanel();
		JPanel btnsPanel1 = new JPanel();
		JPanel btnsPanel2 = new JPanel();
		JPanel nomePanel = new JPanel();
		JPanel cognomePanel = new JPanel();
		JPanel numeroPanel = new JPanel();
		JPanel scadenzaPanel = new JPanel();
		JPanel cvvPanel = new JPanel();
		btnsPanel = new JPanel();
		infoPanel = new JPanel();

		centralPanel.setLayout(new BorderLayout());
		selectScadenza.setLayout(new GridLayout(1, 2));
		nomePanel.setLayout(new GridLayout(2, 1));
		cognomePanel.setLayout(new GridLayout(2, 1));
		numeroPanel.setLayout(new GridLayout(2, 1));
		scadenzaPanel.setLayout(new GridLayout(2, 1));
		cvvPanel.setLayout(new GridLayout(2, 1));

		JLabel title = new JLabel("Totale: " + String.format("%.2f", prezzo) + " €");
		title.setFont(veryLargeFont);
		title.setBackground(Color.CYAN);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel nome = new JLabel("Nome:");
		nome.setFont(largeFont);
		nomeErr = new JLabel("Il nome inserito non è valido!");
		nomeErr.setFont(shortFont);
		nomeErr.setVisible(false);
		nomeErr.setSize(0, dim.height / 14);
		nomeErr.setForeground(Color.RED);
		JLabel cognome = new JLabel("Cognome:");
		cognome.setFont(largeFont);
		cognomeErr = new JLabel("Il cognome inserito non è valido!");
		cognomeErr.setFont(shortFont);
		cognomeErr.setVisible(false);
		cognomeErr.setForeground(Color.RED);
		JLabel numero = new JLabel("Numero:");
		numero.setFont(largeFont);
		numeroErr = new JLabel("Il numero inserito non è valido!");
		numeroErr.setFont(shortFont);
		numeroErr.setVisible(false);
		numeroErr.setForeground(Color.RED);
		JLabel scadenza = new JLabel("Scadenza (mm/aaaa):");
		scadenza.setFont(largeFont);
		scadenzaErr = new JLabel("");
		scadenzaErr.setFont(shortFont);
		scadenzaErr.setVisible(false);
		scadenzaErr.setForeground(Color.RED);
		JLabel cvv = new JLabel("CVV:");
		cvv.setFont(largeFont);
		cvvErr = new JLabel("Il CVV inserito non è valido!");
		cvvErr.setFont(shortFont);
		cvvErr.setVisible(false);
		cvvErr.setForeground(Color.RED);

		Integer[] monthToChoose = new Integer[12];
		Integer[] yearToChoose = new Integer[11];

		for (int i = 0; i < 12; i++) {
			monthToChoose[i] = i + 1;
		}
		for (int i = 0; i < 2; i++) {
			for (int i2 = 0; i2 < 5; i2++) {
				if (i == 0)
					yearToChoose[i2] = ANNO - (5 - i2);
				else
					yearToChoose[10 - i2] = ANNO + (5 - i2);
			}
		}
		yearToChoose[5] = ANNO;

		nomeTxt = new JTextField(u.getNome());
		cognomeTxt = new JTextField(u.getCognome());
		nCartaTxt = new JTextField();
		cvvTxt = new JTextField();
		meseOp = new JComboBox<>(monthToChoose);
		annoOp = new JComboBox<>(yearToChoose);
		salvaCb = new JCheckBox("Salva metodo di pagamento");
		okBtn = new JButton("Conferma");
		if (tipoPagamento == 1)
			backBtn = new JButton("Carrello");
		else if (tipoPagamento == 2)
			backBtn = new JButton("Museo");
		else if (tipoPagamento == 3)
			backBtn = new JButton("Home");
		else
			backBtn = new JButton("Profilo personale");

		meseOp.setSelectedIndex(0);
		annoOp.setSelectedIndex(5);
		salvaCb.setFont(shortFont);

		selectScadenza.add(meseOp);
		selectScadenza.add(annoOp);

		backBtn.setBackground(Color.WHITE);
		backBtn.setFont(mediumFont);
		okBtn.setBackground(Color.WHITE);
		okBtn.setFont(mediumFont);

		nomePanel.add(nome);
		nomePanel.add(nomeErr);
		cognomePanel.add(cognome);
		cognomePanel.add(cognomeErr);
		numeroPanel.add(numero);
		numeroPanel.add(numeroErr);
		scadenzaPanel.add(scadenza);
		scadenzaPanel.add(scadenzaErr);
		cvvPanel.add(cvv);
		cvvPanel.add(cvvErr);

		infoPanel.setLayout(new GridLayout(7, 2, dim.width / 192, 1));
		infoPanel.setBorder(new EmptyBorder(dim.height / 10, dim.width / 7, dim.height / 10, dim.width / 7));
		infoPanel.add(nomePanel);
		infoPanel.add(nomeTxt);
		infoPanel.add(cognomePanel);
		infoPanel.add(cognomeTxt);
		infoPanel.add(numeroPanel);
		infoPanel.add(nCartaTxt);
		infoPanel.add(scadenzaPanel);
		infoPanel.add(selectScadenza);
		infoPanel.add(cvvPanel);
		infoPanel.add(cvvTxt);
		if (riempiCarte()) {
			String[] numeri = new String[99];
			for (int i = 0; i < carteDisp.size(); i++) {
				numeri[i] = "" + carteDisp.get(i).getnCartaCredito();
			}
			cartaOp = new JComboBox<>(numeri);
			JLabel carteSalvate = new JLabel("Carte salvate:");
			carteBtn = new JButton("Usa carta");
			JPanel cartePanel = new JPanel();
			cartePanel.add(carteSalvate);
			cartePanel.add(carteBtn);
			cartePanel.setLayout(new GridLayout(2, 1));
			numeroPanel.add(numero);
			numeroPanel.add(numeroErr);
			carteSalvate.setFont(largeFont);
			infoPanel.add(cartePanel);
			infoPanel.add(cartaOp);
		}
		infoPanel.add(salvaCb);

		btnsPanel1.add(new JLabel("N.B. continuando riceverai una mail di conferma."));
		btnsPanel2.setLayout(new GridLayout(1, 2));
		btnsPanel2.add(backBtn);
		btnsPanel2.add(okBtn);

		btnsPanel.setLayout(new GridLayout(2, 1, dim.width / 192, 3));
		btnsPanel.setBorder(new EmptyBorder(0, dim.width / 7, 0, dim.width / 7));
		btnsPanel.add(btnsPanel1);
		btnsPanel.add(btnsPanel2);

		centerPanelBtns.setLayout(new BorderLayout());
		centerPanelBtns.add(btnsPanel);

		centralPanel.setLayout(new BorderLayout());
		centralPanel.add(title, BorderLayout.NORTH);
		centralPanel.add(infoPanel, BorderLayout.CENTER);
		centralPanel.add(centerPanelBtns, BorderLayout.SOUTH);

		// Main panel
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}

	public int getAnno() {
		return (int) annoOp.getSelectedItem();
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public JButton getCarte() {
		return carteBtn;
	}

	public String getCognome() {
		return cognomeTxt.getText();
	}

	public JTextField getCognomeTxt() {
		return cognomeTxt;
	}

	public int getCvv() {
		return Integer.parseInt(cvvTxt.getText());
	}

	public JTextField getCvvTxt() {
		return cvvTxt;
	}

	public int getMese() {
		return (int) meseOp.getSelectedItem();
	}

	public long getNCarta() {
		return Long.parseLong(nCartaTxt.getText());
	}

	public JTextField getnCartaTxt() {
		return nCartaTxt;
	}

	public String getNome() {
		return nomeTxt.getText();
	}

	public JTextField getNomeTxt() {
		return nomeTxt;
	}

	public JButton getOkBtn() {
		return okBtn;
	}

	public JCheckBox getsalvaCB() {
		return salvaCb;
	}

	public int getTipoErr() {
		return tipoErr;
	}

	@Override
	public void onWindowResized(Dimension dim) {
		infoPanel.setLayout(new GridLayout(7, 2, dim.width / 192, 1));
		btnsPanel.setBorder(new EmptyBorder(0, dim.width / 7, 0, dim.width / 7));

		infoPanel.revalidate();
		btnsPanel.revalidate();
		infoPanel.repaint();
		btnsPanel.repaint();
	}

	public void reLoad() {
		nomeErr.setVisible(false);
		cognomeErr.setVisible(false);
		numeroErr.setVisible(false);
		cvvErr.setVisible(false);
	}

	public boolean riempiCarte() {
		boolean flag = true;
		carteDisp = DAOFactory.createICartaPagamentoDAO().selectByUtente(u);

		if (carteDisp.isEmpty())
			flag = false;
		return flag;
	}

	public void setCarta() {
		for (Carta element : carteDisp) {
			if (element.getnCartaCreditoStr().equals(cartaOp.getSelectedItem())) {
				nomeTxt.setText(element.getNome());
				cognomeTxt.setText(element.getCognome());
				nCartaTxt.setText("" + element.getnCartaCredito());
				meseOp.setSelectedItem(element.getMeseScadenza());
				annoOp.setSelectedItem(element.getAnnoScadenza());
			}
		}
	}

	public void setTipoErr(int tipoErr) {
		this.tipoErr = tipoErr;
	}

	public void upCvvErr() {
		cvvErr.setVisible(true);
	}

	public void upNameErr() {
		nomeErr.setVisible(true);
	}

	public void upNumberErr() {
		numeroErr.setVisible(true);
	}

	public void upSurnameErr() {
		cognomeErr.setVisible(true);
	}

}
