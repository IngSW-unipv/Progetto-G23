package it.unipv.sfw.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.view.buttons.UtenteButton;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Classe che crea la view della sezione partite nella pagina
 * principale dell'utente.
 *
 * @author Jacopo Piccoli, Gabriele Invernizzi
 * @see it.unipv.sfw.view.buttons.UtenteButton
 */
public class PartiteView extends AView {
	
	private int righe;

	JPanel panel;
	// variabili del top
	private JPanel top, bottoni;
	private JLabel icona;
	private JButton bpart, bmuseo, bshop, butente;
	private Icon img;
	private Image img2;

	// variabili del middle
	private JPanel middle, p;
	private JLabel titolo;
	private ArrayList<JLabel> partite;
	private ArrayList<UtenteButton> acquista;
	private ArrayList<JPanel> tabellone;
	private JScrollPane pane;

	public PartiteView(Partita[] par, Dimension dim) {

		righe = par.length;
		panel = new JPanel();
		top = new JPanel();
		bottoni = new JPanel();

		icona = new JLabel();

		bpart = new JButton("PARTITE");
		bpart.setBackground(Color.WHITE);
		bpart.setFont(new java.awt.Font("Arial", 1, 18));
		bmuseo = new JButton("MUSEO");
		bmuseo.setBackground(Color.WHITE);
		bmuseo.setFont(new java.awt.Font("Arial", 1, 18));
		bshop = new JButton("SHOP");
		bshop.setBackground(Color.WHITE);
		bshop.setFont(new java.awt.Font("Arial", 1, 18));

		img = new ImageIcon(getClass().getResource("/utente.gif"));

		butente = new JButton("", img);
		butente.setBackground(Color.BLUE);

		bottoni.setBackground(Color.BLUE);
		bottoni.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		bottoni.add(bpart);
		bottoni.add(bmuseo);
		bottoni.add(bshop);

		top.setLayout(new BorderLayout());
		top.add(butente, BorderLayout.WEST);
		top.add(bottoni, BorderLayout.CENTER);

		top.setBorder(BorderFactory.createLineBorder(Color.black));
		top.setBackground(Color.gray);

		// configurazione del middle
		middle = new JPanel();

		p = new JPanel();

		titolo = new JLabel("Elenco Partite:");
		titolo.setFont(new java.awt.Font("Arial", 1, 24));
		titolo.setBackground(Color.CYAN);
		titolo.setOpaque(true);

		partite = new ArrayList<JLabel>();
		acquista = new ArrayList<UtenteButton>();
		tabellone = new ArrayList<JPanel>();

		titolo.setBorder(BorderFactory.createLineBorder(Color.black));

		img2 = new ImageIcon(this.getClass().getResource("/stemma.jpg")).getImage();
		for (int i = 0; i < righe; i++) {
			partite.add(new JLabel("<html> " + par[i].getOspiti() + "<br><br>" + par[i].getData()
					+ "&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <br><b<br><br></html>"));
			acquista.add(new UtenteButton("Acquista", i));

			tabellone.add(new JPanel());
		}

		for (int i = 0; i < righe; i++) {
			tabellone.get(i).add(partite.get(i));
			tabellone.get(i).add(acquista.get(i));
			partite.get(i).setIcon(new ImageIcon(img2));
			tabellone.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
			partite.get(i).setFont(new java.awt.Font("Arial", 1, 18));
		}

		p.setPreferredSize(new Dimension((int)(dim.width * 0.8), (150 * righe)));

		p.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));

		for (JPanel t : tabellone) {
			p.add(t);
		}

		pane = new JScrollPane(p);
		pane.setPreferredSize(new Dimension(dim.width, dim.height - 150));

		middle.setLayout(new BorderLayout());
		middle.add(titolo, BorderLayout.NORTH);
		middle.add(pane, BorderLayout.CENTER);

		panel.setLayout(new BorderLayout());
		panel.add(top, BorderLayout.NORTH);
		panel.add(middle, BorderLayout.CENTER);

		this.add(panel);

	}

	public Collection<UtenteButton> getButtons() {
		return acquista;
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		p.setPreferredSize(new Dimension((int)(dim.width * 0.8), (150 * righe)));
		pane.setPreferredSize(new Dimension(dim.width, dim.height - 150));
		
		pane.revalidate();
		pane.repaint();	
	}

	@Override
	public Type getType() {
		return AView.Type.PARTITE;
	}

}
