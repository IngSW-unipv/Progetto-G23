package it.unipv.sfw.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;

import javax.swing.BorderFactory;
import javax.swing.Icon;
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
import it.unipv.sfw.view.elements.MenuUtente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * Classe che crea la view della sezione partite nella pagina
 * principale dell'utente.
 *
 * @author Jacopo Piccoli, Gabriele Invernizzi
 * @see it.unipv.sfw.view.buttons.UtenteButton
 */
public class PartiteView extends AView {
	
	private int righe;
	
	// variabili del top
	private JButton bmuseo, bshop;
	private MenuUtente u;
	private ImageIcon img2;

	// variabili del middle
	private JPanel partitePanel;
	private ArrayList<JLabel> partite;
	private ArrayList<UtenteButton> acquista;
	private ArrayList<JPanel> tabellone;
	private ArrayList<JLabel> immagini;

	public PartiteView(Partita[] par, Dimension dim) {

		righe = par.length;
		u=new MenuUtente();
		
		Font medium=new Font("Arial", 1, 18);
		Font large=new Font("Arial",1,24);
		
		bmuseo = new JButton("MUSEO");
		bmuseo.setBackground(Color.WHITE);
		bmuseo.setFont(medium);
		bshop = new JButton("STORE");
		bshop.setBackground(Color.WHITE);
		bshop.setFont(medium);

		JPanel bottoni=new JPanel();
		bottoni.setBackground(Color.BLUE);
		bottoni.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		bottoni.add(bmuseo);
		bottoni.add(bshop);
		
		JPanel top=new JPanel();

		top.setLayout(new BorderLayout());
		top.add(bottoni, BorderLayout.CENTER);
		top.add(u, BorderLayout.EAST);

		top.setBorder(BorderFactory.createLineBorder(Color.black));
		top.setBackground(Color.gray);

		// configurazione del middle
		

		

		JPanel titlePanel = new JPanel(); 
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setBackground(Color.BLACK);
		
		JLabel titolo=new JLabel();
		titolo = new JLabel("PARTITE");
		titolo.setForeground(Color.WHITE);
		titolo.setFont(large);
		titolo.setBackground(Color.BLACK);
		titolo.setOpaque(true);
		titolo.setBorder(BorderFactory.createEmptyBorder(0,0,0,40));
		titolo.setHorizontalAlignment(JLabel.CENTER);
		
		titlePanel.add(titolo);

		partite = new ArrayList<JLabel>();
		acquista = new ArrayList<UtenteButton>();
		tabellone = new ArrayList<JPanel>();
		immagini=new ArrayList<JLabel>();

		Calendar d=new GregorianCalendar();
		

		for (int i = 0; i < righe; i++) {
			d=par[i].getCalendarDate();
			partite.add(new JLabel("<html>	Inter - " + par[i].getOspiti() + "<br><br>" + par[i].getDataPerPartita()+"<br><br></html>"));
			partite.get(i).setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
			
			
			immagini.add(new JLabel(""));
			img2 = new ImageIcon(this.getClass().getResource("/Stemma_"+par[i].getOspiti()+".png"));
			img2=new ImageIcon(img2.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));
			immagini.get(i).setIcon(img2);
			immagini.get(i).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			acquista.add(new UtenteButton("Acquista", i));
			acquista.get(i).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			
			tabellone.add(new JPanel());
			tabellone.get(i).setPreferredSize(new Dimension(500,150));
			tabellone.get(i).setLayout(new BorderLayout());
			
			tabellone.get(i).add(partite.get(i),BorderLayout.CENTER);
			tabellone.get(i).add(acquista.get(i),BorderLayout.SOUTH);
			tabellone.get(i).add(immagini.get(i),BorderLayout.WEST);
			tabellone.get(i).setBorder(BorderFactory.createLineBorder(Color.black));
			partite.get(i).setFont(medium);
			if(d.getTime().before(Calendar.getInstance().getTime())) {
				acquista.get(i).setEnabled(false);
			}
		}
		partitePanel=new JPanel();
		partitePanel.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (175*righe)));

		partitePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));

		for (JPanel t : tabellone) {
			partitePanel.add(t);
		}
		
		JScrollPane pane = new JScrollPane(partitePanel);

		pane.getVerticalScrollBar().setUnitIncrement(10);
		
		JPanel middle = new JPanel();
		middle.setLayout(new BorderLayout());
		middle.add(titlePanel, BorderLayout.NORTH);
		middle.add(pane, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
	}

	public Collection<UtenteButton> getButtons() {
		return acquista;
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
		partitePanel.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (175 * righe)));		
		partitePanel.revalidate();
		partitePanel.repaint();	
	}
	
	public JMenuItem getExit() {
		return u.getExit();
	}
}
