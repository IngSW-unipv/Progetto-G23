package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.view.AView.Type;
import it.unipv.sfw.view.buttons.UtenteButton;
import it.unipv.sfw.view.elements.JInfoMenu;
import it.unipv.sfw.view.elements.MenuUtente;

public class PartiteAdminView extends AView {
private int righe;
	
	// variabili del top
	private JPanel top, bottoni;
	private JButton bmuseo, bshop;
	private MenuUtente u;
	private Image img2;

	// variabili del middle
	private JPanel middle, p;
	private JLabel titolo;
	private ArrayList<JLabel> partite;
	private ArrayList<JMenuBar> i;
	private ArrayList<JInfoMenu>info;
	ArrayList<JLabel>infoPartita;
	private ArrayList<JPanel> tabellone;
	private JScrollPane pane;

	public PartiteAdminView(Partita[] par, Dimension dim) {

		righe = par.length;
		top = new JPanel();
		bottoni = new JPanel();
		u=new MenuUtente();
		
		bmuseo = new JButton("MUSEO");
		bmuseo.setBackground(Color.WHITE);
		bmuseo.setFont(new java.awt.Font("Arial", 1, 18));
		bshop = new JButton("SHOP");
		bshop.setBackground(Color.WHITE);
		bshop.setFont(new java.awt.Font("Arial", 1, 18));

		bottoni.setBackground(Color.BLUE);
		bottoni.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		bottoni.add(bmuseo);
		bottoni.add(bshop);

		top.setLayout(new BorderLayout());
		top.add(bottoni, BorderLayout.CENTER);
		top.add(u, BorderLayout.EAST);

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
		i=new ArrayList<JMenuBar>();
		info=new ArrayList<JInfoMenu>();
		tabellone = new ArrayList<JPanel>();
		infoPartita=new ArrayList<JLabel>();

		titolo.setBorder(BorderFactory.createLineBorder(Color.black));

		img2 = new ImageIcon(this.getClass().getResource("/stemma.jpg")).getImage();
		for (int j = 0; j < righe; j++) {
			partite.add(new JLabel("<html> " + par[j].getOspiti() + "<br><br>" + par[j].getData()
					+ "&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <br><b<br><br></html>"));
			i.add(new JMenuBar());
			info.add(new JInfoMenu("informazioni",j));
			infoPartita.add(new JLabel(""));
			
			info.get(j).add(infoPartita.get(j));
			i.get(j).add(info.get(j));
			tabellone.add(new JPanel());
			tabellone.get(j).add(partite.get(j));
			tabellone.get(j).add(i.get(j)); 
			partite.get(j).setIcon(new ImageIcon(img2));
			tabellone.get(j).setBorder(BorderFactory.createLineBorder(Color.black));
			partite.get(j).setFont(new java.awt.Font("Arial", 1, 18));
		}

		p.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (150*righe)));

		p.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));

		for (JPanel t : tabellone) {
			p.add(t);
		}

		pane = new JScrollPane(p);

		pane.getVerticalScrollBar().setUnitIncrement(10);

		middle.setLayout(new BorderLayout());
		middle.add(titolo, BorderLayout.NORTH);
		middle.add(pane, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
	}


	@Override
	public Type getType() {
		return AView.Type.PARTITE;
	}

}