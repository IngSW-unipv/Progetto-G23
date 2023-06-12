package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.model.partita.Stadio;
import it.unipv.sfw.view.buttons.BloccoButton;
import it.unipv.sfw.view.buttons.PostoButton;
/**
 * Classe che crea la view dei vari blocchi di un anello. 
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.BloccoButton
 */
public class BloccoView extends AView {

	private JPanel tabellone;
	private ArrayList<BloccoButton> blocco;
	private ArrayList<JLabel> idBlocco;
	private ArrayList<JPanel> gruppo;
	private  ImageIcon img;

	public BloccoView(Dimension dim, Stadio stadio, int n_settore, int n_anello) {
		
		tabellone = new JPanel();
		tabellone.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		blocco = new ArrayList<BloccoButton>(Stadio.BLOCCHI_PER_ANELLO);
		idBlocco=new ArrayList<JLabel>(Stadio.BLOCCHI_PER_ANELLO);
		gruppo=new ArrayList<JPanel>(Stadio.BLOCCHI_PER_ANELLO);
		
		for (int i = 0; i < Stadio.BLOCCHI_PER_ANELLO; i++) {
			gruppo.add(null);
			blocco.add(null);
			idBlocco.add(null);
		}

		img=new ImageIcon(this.getClass().getResource("/blocco.jpg"));
		img=new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/10,(int)(dim.height-50)/5,java.awt.Image.SCALE_SMOOTH));

		for (int i = 0; i < Stadio.BLOCCHI_PER_ANELLO; i++) {
			int n_blocco = Stadio.BLOCCHI_PER_ANELLO - i - 1;
			boolean isLibero = stadio.isLibero(n_settore, n_anello, n_blocco+1);
			blocco.set(n_blocco, new BloccoButton(n_blocco+1, img, true, isLibero));
			idBlocco.set(n_blocco, new JLabel("" + (n_blocco+1)));
			idBlocco.get(n_blocco).setBackground(Color.red);
			gruppo.set(n_blocco, new JPanel());
			
			gruppo.get(n_blocco).setLayout(new BorderLayout());
			gruppo.get(n_blocco).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			gruppo.get(n_blocco).add(blocco.get(n_blocco), BorderLayout.CENTER);
			gruppo.get(n_blocco).add(idBlocco.get(n_blocco), BorderLayout.SOUTH);
			idBlocco.get(n_blocco).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			if (isLibero)
				gruppo.get(n_blocco).setBackground(Color.GREEN);
			else
				gruppo.get(n_blocco).setBackground(Color.RED);
			gruppo.get(n_blocco).setOpaque(true);
		}
		

		tabellone.setLayout(new GridLayout((int) (Stadio.BLOCCHI_PER_ANELLO / 10),10));

		for (JPanel j : gruppo) {
			j.setSize(50, 30);
			tabellone.add(j);

		}
		
		this.add(tabellone);
	}

	public Collection<BloccoButton> getAllBloccoButton() {
		return blocco;
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		img=new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/10,(int)(dim.height-50)/5,java.awt.Image.SCALE_SMOOTH));

		tabellone.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));

		for(int i=0;i<Stadio.BLOCCHI_PER_ANELLO;i++) {
			blocco.get(i).modificaImg(img);
			blocco.get(i).revalidate();
			gruppo.get(i).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			gruppo.get(i).revalidate();
			blocco.get(i).revalidate();
			gruppo.get(i).repaint();
		}
		
		tabellone.revalidate();
		tabellone.repaint();
	}
}
