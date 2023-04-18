package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.view.buttons.BloccoButton;
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
	private int b;
	private  ImageIcon img;

	public BloccoView(int ptot,Dimension dim) {
		
		tabellone = new JPanel();
		tabellone.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		blocco = new ArrayList<BloccoButton>();
		idBlocco=new ArrayList<JLabel>();
		gruppo=new ArrayList<JPanel>();

		b = ptot / 50;
		img=new ImageIcon(this.getClass().getResource("/blocco.jpg"));
		img=new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/10,(int)(dim.height-50)/5,java.awt.Image.SCALE_SMOOTH));

		for (int i = 0; i < b; i++) {
			blocco.add(new BloccoButton(50-i, img,true));
			idBlocco.add(new JLabel("B"+(50-i)));
			gruppo.add(new JPanel());
			

		}
		
		for(int i=0;i<b;i++) {
			gruppo.get(i).setLayout(new BorderLayout());
			gruppo.get(i).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			gruppo.get(i).add(blocco.get(i), BorderLayout.CENTER);
			gruppo.get(i).add(idBlocco.get(i), BorderLayout.SOUTH);
			idBlocco.get(i).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			gruppo.get(i).setBackground(Color.GREEN);
			gruppo.get(i).setOpaque(true);

		}
		

		tabellone.setLayout(new GridLayout((int) (b / 10),10));

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

		for(int i=0;i<b;i++) {
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

	@Override
	public Type getType() {
		return AView.Type.BLOCCO;
	}
}
