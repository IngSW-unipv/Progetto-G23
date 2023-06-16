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

/**
 * Classe che crea la viev dell'admin per le partite. 
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.InfoButton
 */
public class AdminPartiteView extends AView {
private int righe;
	
	// variabili del top
	private JButton bmuseo, bshop, addpartita;
	private MenuUtente u;
	private ImageIcon img2;

	// variabili del middle
	private JPanel  partitePanel;
	private ArrayList<JLabel> partite;
	private ArrayList<JMenuBar> i;
	private ArrayList<InfoMenu>info;
	private ArrayList<JLabel>infoPartita;
	private ArrayList<JPanel> tabellone;
	private JScrollPane pane;
	private ArrayList<JLabel> immagini;

	public AdminPartiteView(Partita[] par, Dimension dim) {

		righe = par.length;
		u=new MenuUtente();
		
		bmuseo = new JButton("MUSEO");
		bmuseo.setBackground(Color.WHITE);
		bmuseo.setFont(new java.awt.Font("Arial", 1, 18));
		bshop = new JButton("STORE");
		bshop.setBackground(Color.WHITE);
		bshop.setFont(new java.awt.Font("Arial", 1, 18));
		addpartita = new JButton("Aggiungi partita");
		addpartita.setBackground(Color.WHITE);
		//addpartita.setFont(new java.awt.Font("Arial", 1, 18));
		
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
		

		partitePanel = new JPanel();

		JPanel titlePanel = new JPanel(); 
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		titlePanel.setBackground(Color.BLACK);
		
		JLabel titolo=new JLabel();
		titolo = new JLabel("PARTITE");
		titolo.setForeground(Color.WHITE);
		titolo.setFont(new java.awt.Font("Arial", 1, 24));
		titolo.setBackground(Color.BLACK);
		titolo.setOpaque(true);
		titolo.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
		titolo.setHorizontalAlignment(JLabel.CENTER);
			
		titlePanel.setLayout(new BorderLayout());
		titlePanel.add(titolo,BorderLayout.CENTER);
		titlePanel.add(addpartita,BorderLayout.EAST);

		partite = new ArrayList<JLabel>();
		i=new ArrayList<JMenuBar>();
		info=new ArrayList<InfoMenu>();
		tabellone = new ArrayList<JPanel>();
		infoPartita=new ArrayList<JLabel>();
		immagini=new ArrayList<JLabel>();
		
		Calendar d=new GregorianCalendar();
		ArrayList<JPanel> bottone=new ArrayList<JPanel>();

		
		for (int j = 0; j < righe; j++) {
			d=par[j].getCalendarDate();
			partite.add(new JLabel("<html> " + par[j].getOspiti() + "<br><br>" + par[j].getDataPerPartita()+"<br><br></html>"));
			i.add(new JMenuBar());
			info.add(new InfoMenu("informazioni",j));
			infoPartita.add(new JLabel("<html>Posti occupati: <br><br>Clienti presenti: <br><br>Abbonati presenti: &nbsp &nbsp<br><br>Totale ricavi: </html> "));
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

		partitePanel.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (175*righe)));
		partitePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 600, 25));

		for (JPanel t : tabellone) {
			partitePanel.add(t);
		}

		pane = new JScrollPane(partitePanel);

		pane.getVerticalScrollBar().setUnitIncrement(10);
		
		JPanel middle=new JPanel();
		middle.setLayout(new BorderLayout());
		middle.add(titlePanel, BorderLayout.NORTH);
		middle.add(pane, BorderLayout.CENTER);

		this.setLayout(new BorderLayout());
		this.add(top, BorderLayout.NORTH);
		this.add(middle, BorderLayout.CENTER);
	}
	
	/**
	 * @return Bottoni di informazione sulla partita.
	 */
	public Collection<InfoMenu> getInfo() {
		return info;
	}
	/**
	 * Metodo chiamato quando si vuole avere informazioni sulla partita.
	 * 
	 * @param stato
	 * @param code
	 * @param postioccupati
	 * @param clientipresenti
	 * @param abbonatipresenti
	 * 
	 */
	public void OpenInfoPartita(boolean stato,int code,int postioccupati, int clientipresenti, int abbonatipresenti) {
		info.get(code).setPopupMenuVisible(stato);
		infoPartita.get(code).setText("<html>Posti occupati: "+postioccupati+"<br><br>Clienti presenti: "+clientipresenti+"<br><br>Abbonati presenti: "+abbonatipresenti+"<br><br>Totale ricavi: </html>");
	}
	
	/**
	 * Metodo chaimato quando si vuoel chiudere il popup ddelle infromazioni sulla partita.
	 * 
	 * @param stato
	 * @param code
	 */
	public void CloseInfoPartita(Boolean stato,int code) {
		info.get(code).setPopupMenuVisible(stato);
	}

	/**
	 * @return Bottone dello store.
	 */
	public JButton getStoreButton() {
		return bshop;
	}
	
	/**
	 * @return Bottone del museo.
	 */
	public JButton getMuseoButton() {
		return bmuseo;
	}
	
	/**
	 * @return Bottone per aggiungere partite.
	 */
	public JButton getAddPartitaButton() {
		return addpartita;
	}	
	
	/**
	 * @return Bottone del profilo personale.
	 */
	public JMenuItem getProfiloPersonaleButton() {
		return  u.getProfiloPersonale();
	}

	/**
	 * @return Bottone di uscita.
	 */
	public JMenuItem getExit() {
		return u.getExit();
	}
	
	public ArrayList<JMenuBar> getJMenuBar() {
		return i;
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		partitePanel.setPreferredSize(new Dimension((int)((dim.width-20)*0.8), (175 * righe)));		
		partitePanel.revalidate();
		partitePanel.repaint();	
	}
	
}