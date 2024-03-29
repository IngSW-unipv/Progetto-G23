package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.view.elements.MenuUtente;
import it.unipv.sfw.view.elements.MuseoItemPanel;
import it.unipv.sfw.view.elements.MuseoStoryPanel;

/**
 * View per il museo.
 *
 * @author Federico Romano
 */
public class MuseoView extends AView {

	ArrayList<Cimelio> cimeli = new ArrayList<>();
	ArrayList<Riconoscimento> riconoscimenti = new ArrayList<>();
	private JButton partiteButton, storeButton, utenteButton;
	private MenuUtente utente;
	private JButton acquistaBiglietto;
	private JPanel pezzimuseo;
	int npezzi;

	public MuseoView(Museo museum, Dimension dim) {

		cimeli = museum.getCimeli();
		int ncim = cimeli.size();
		riconoscimenti = museum.getRiconoscimenti();
		int nric = riconoscimenti.size();

		npezzi = ncim + nric;

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBackground(Color.gray);

		JPanel topPanelButtons = new JPanel();
		topPanelButtons.setBackground(Color.BLUE);
		topPanelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		partiteButton = new JButton("PARTITE");
		partiteButton.setBackground(Color.WHITE);
		partiteButton.setFont(new java.awt.Font("Arial", 1, 18));

		storeButton = new JButton("STORE");
		storeButton.setBackground(Color.WHITE);
		storeButton.setFont(new java.awt.Font("Arial", 1, 18));

		topPanelButtons.add(partiteButton);
		topPanelButtons.add(storeButton);

		utente = new MenuUtente();

		topPanel.add(topPanelButtons, BorderLayout.CENTER);
		topPanel.add(utente, BorderLayout.EAST);

		JPanel centralPanel = new JPanel();
		centralPanel.setLayout(new BorderLayout());

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setBackground(Color.BLACK);

		JLabel title = new JLabel("MUSEO");
		title.setForeground(Color.WHITE);
		title.setFont(new java.awt.Font("Arial", 1, 24));
		title.setBackground(Color.BLACK);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.black));

		titlePanel.add(title);

		centralPanel.add(titlePanel, BorderLayout.NORTH);

		JPanel centralMiddlePanel = new JPanel();
		centralMiddlePanel.setLayout(new BorderLayout());

		JPanel bigliettoPanel = new JPanel();
		acquistaBiglietto = new JButton("ACQUISTA BIGLIETTO");
		acquistaBiglietto.setBackground(Color.WHITE);
		acquistaBiglietto.setPreferredSize(new Dimension(200, 30));
		bigliettoPanel.setPreferredSize(new Dimension(100, 40));
		bigliettoPanel.setBackground(Color.BLUE);
		bigliettoPanel.setOpaque(true);
		bigliettoPanel.add(acquistaBiglietto);
		centralMiddlePanel.add(bigliettoPanel, BorderLayout.NORTH);

		pezzimuseo = new JPanel();

		pezzimuseo.add(new MuseoStoryPanel(dim, museum.getStoria()));

		for (Cimelio c : cimeli) {
			MuseoItemPanel pezzo = new MuseoItemPanel(c, false);
			pezzimuseo.add(pezzo);
		}

		for (Riconoscimento r : riconoscimenti) {
			MuseoItemPanel pezzo = new MuseoItemPanel(r, false);
			pezzimuseo.add(pezzo);
		}

		pezzimuseo.setPreferredSize(new Dimension((int) ((dim.width - 20) * 0.8), (240 * (npezzi) + 510)));
		pezzimuseo.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 25));

		JScrollPane scrollTrofei = new JScrollPane(pezzimuseo);
		scrollTrofei.getVerticalScrollBar().setUnitIncrement(20);

		centralMiddlePanel.add(scrollTrofei, BorderLayout.CENTER);

		ImageIcon scudettosx = new ImageIcon(getClass().getResource("/scudettointer.png"));
		scudettosx = new ImageIcon(scudettosx.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		JLabel scudetto = new JLabel();
		scudetto.setBackground(Color.BLUE);
		scudetto.setOpaque(true);
		scudetto.setIcon(scudettosx);
		centralMiddlePanel.add(scudetto, BorderLayout.WEST);

		JLabel blue_label_dx = new JLabel();
		blue_label_dx.setBackground(Color.BLUE);
		blue_label_dx.setOpaque(true);
		blue_label_dx.setIcon(scudettosx);
		centralMiddlePanel.add(blue_label_dx, BorderLayout.EAST);

		centralPanel.add(centralMiddlePanel, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centralPanel, BorderLayout.CENTER);
	}

	/**
	 * @return Il bottone "ACQUISTA BIGLIETTO".
	 */
	public JButton getAcquistaButton() {
		return acquistaBiglietto;
	}

	/**
	 * @return Il tasto "esci".
	 */
	public JMenuItem getExit() {
		return utente.getExit();
	}

	/**
	 * @return Il bottone "PARTITE".
	 */
	public JButton getPartiteButton() {
		return partiteButton;
	}

	/**
	 * @return Il tasto "profilo personale".
	 */
	public JMenuItem getProfiloPersonaleButton() {
		return utente.getProfiloPersonale();
	}

	/**
	 * @return Il bottone "STORE".
	 */
	public JButton getStoreButton() {
		return storeButton;
	}

	/**
	 * @return Il bottone utente.
	 */
	public JButton getUtenteButton() {
		return utenteButton;
	}

}