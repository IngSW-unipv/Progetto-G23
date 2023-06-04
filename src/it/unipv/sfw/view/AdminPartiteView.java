package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.view.buttons.UtenteButton;
import it.unipv.sfw.view.elements.InfoMenu;
import it.unipv.sfw.view.elements.MenuUtente;

public class AdminPartiteView extends AView {
private int righe;
	
	// variabili del top
	private JPanel top, bottoni;
	private JButton bmuseo, bshop;
	private MenuUtente u;
	private ImageIcon img2;

	// variabili del middle
	private JPanel middle, p;
	private JLabel titolo;
	private ArrayList<JLabel> partite;
	private ArrayList<JMenuBar> i;
	private ArrayList<InfoMenu>info;
	private ArrayList<JLabel>infoPartita;
	private ArrayList<JPanel> tabellone;
	private JScrollPane pane;
	private ArrayList<JLabel> immagini;

	public AdminPartiteView(Partita[] par, Dimension dim) {

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
		info=new ArrayList<InfoMenu>();
		tabellone = new ArrayList<JPanel>();
		infoPartita=new ArrayList<JLabel>();
		immagini=new ArrayList<JLabel>();
		titolo.setBorder(BorderFactory.createLineBorder(Color.black));
		Calendar d=new GregorianCalendar();
		ArrayList<JPanel> bottone=new ArrayList<JPanel>();

		
		for (int j = 0; j < righe; j++) {
			d=par[j].getCalendarDate();
			partite.add(new JLabel("<html> " + par[j].getOspiti() + "<br><br>" + par[j].getData()+"<br><br></html>"));
			i.add(new JMenuBar());
			info.add(new InfoMenu("informazioni",j));
			infoPartita.add(new JLabel(""));
			immagini.add(new JLabel(""));
			img2 = new ImageIcon(this.getClass().getResource("/Stemma_"+par[j].getOspiti()+".png"));
			img2=new ImageIcon(img2.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
			immagini.get(j).setIcon(img2);
			
			
			immagini.get(j).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			info.get(j).add(infoPartita.get(j));
			i.get(j).add(info.get(j));
			bottone.add(new JPanel());
			bottone.get(j).add(i.get(j));
			
			tabellone.add(new JPanel());
			tabellone.get(j).setPreferredSize(new Dimension(500,150));
			tabellone.get(j).setLayout(new BorderLayout());
			
			tabellone.get(j).add(partite.get(j),BorderLayout.CENTER);
			tabellone.get(j).add(bottone.get(j),BorderLayout.EAST);
			tabellone.get(j).add(immagini.get(j),BorderLayout.WEST);
			tabellone.get(j).setBorder(BorderFactory.createLineBorder(Color.black));
			partite.get(j).setFont(new java.awt.Font("Arial", 1, 18));
			if(d.getTime().after(Calendar.getInstance().getTime())) {
				i.get(j).setEnabled(false);
			}
		}

		p.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (175*righe)));
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

	public Collection<InfoMenu> getInfo() {
		return info;
	}
	
	public void setInfoPartita(boolean stato,int code) {
		info.get(code).setPopupMenuVisible(stato);
	}
	public JButton getStoreButton() {
		return bshop;
	}
	
	public JButton getMuseoButton() {
		return bmuseo;
	}
	
	
	public JMenuItem getProfiloPersonaleButton() {
		return  u.getProfiloPersonale();
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		p.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (175 * righe)));		
		p.revalidate();
		p.repaint();	
	}
	
	public JMenuItem getExit() {
		return u.getExit();
	}
}