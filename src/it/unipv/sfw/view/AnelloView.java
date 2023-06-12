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
import it.unipv.sfw.view.buttons.AnelloButton;



/**
 * Classe che crea la view deli 3 anelli di ogni settore.
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.AnelloButton
 */
public class AnelloView extends AView {

	private JPanel contenitore;
	private ArrayList<AnelloButton> a;
	private ArrayList<JLabel>idAnello;
	private ArrayList<JPanel>anello;
	private ImageIcon img;
	
	
	public AnelloView(Dimension dim, Stadio stadio, int n_settore) {
		

		contenitore=new JPanel();
		contenitore.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		a = new ArrayList<AnelloButton>();
		idAnello=new ArrayList<JLabel>();
		anello = new ArrayList<JPanel>();

		
		img = new ImageIcon(this.getClass().getResource("/Spalti.JPG"));
		img = new ImageIcon(img.getImage().getScaledInstance((int)(dim.width),(int)(dim.height-60)/3,  java.awt.Image.SCALE_SMOOTH)); 
				
		for(int i=0;i<Stadio.ANELLI_PER_SETTORE;i++) {
			int n_anello = 3 - i;
			a.add(new AnelloButton(n_anello,img,true, stadio.isLibero(n_settore, n_anello)));
			idAnello.add(new JLabel("A"+n_anello));
			anello.add(new JPanel());
		}
		
		for(int i=0;i<Stadio.ANELLI_PER_SETTORE;i++) {
			anello.get(i).setLayout(new BorderLayout());
			anello.get(i).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			anello.get(i).add(a.get(i), BorderLayout.CENTER);
			anello.get(i).add(idAnello.get(i), BorderLayout.SOUTH);
			idAnello.get(i).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			if (stadio.isLibero(n_settore, i))
				anello.get(i).setBackground(Color.GREEN);
			else
				anello.get(i).setBackground(Color.RED);
			anello.get(i).setOpaque(true);
		}
		
		contenitore.setLayout(new GridLayout((int) 3,1));

		for (JPanel j : anello) {
			contenitore.add(j);

		}
		
		
		
		this.add(contenitore, BorderLayout.CENTER);

	}

	public Collection<AnelloButton> getButtons() {
		return a;
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		img = new ImageIcon(img.getImage().getScaledInstance((int)(dim.width),(int)(dim.height-60)/3,  java.awt.Image.SCALE_SMOOTH)); 
		
		contenitore.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		
		for(int i=0;i<Stadio.ANELLI_PER_SETTORE;i++) {
			a.get(i).modificaImg(img);
			a.get(i).revalidate();
			anello.get(i).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			anello.get(i).revalidate();
			anello.get(i).revalidate();
			anello.get(i).repaint();
		}
		
		contenitore.revalidate();
		contenitore.repaint();
	}
}
