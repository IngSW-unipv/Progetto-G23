package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.view.buttons.PostoButton;


/**
 * Classe che crea la view dei posti di un blocco.
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.PostoButton
 */
public class PostoView extends AView {

	private JPanel blocco;
	private ArrayList<PostoButton> posto;
	private ArrayList<JLabel> nomeposto;
	private ArrayList<JPanel> gruppo;
	private ImageIcon img;

	public PostoView(int posti,Dimension dim) {

		blocco = new JPanel();
		blocco.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		gruppo = new ArrayList<JPanel>();
		posto = new ArrayList<PostoButton>();
		nomeposto = new ArrayList<JLabel>();

		img = new ImageIcon(getClass().getResource("/Posto.jpg"));
		img=new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/10,(int)(dim.height-100)/5,java.awt.Image.SCALE_SMOOTH));


		for (int i = 0; i < posti; i++) {
			posto.add(new PostoButton(50-i, img, true));
			nomeposto.add(new JLabel("" + (50-i)));
			nomeposto.get(i).setBackground(Color.red);
			gruppo.add(new JPanel());

		}

		for (int i = 0; i < posti; i++) {
			gruppo.get(i).setLayout(new BorderLayout());
			gruppo.get(i).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			gruppo.get(i).add(posto.get(i), BorderLayout.CENTER);
			gruppo.get(i).add(nomeposto.get(i), BorderLayout.SOUTH);
			nomeposto.get(i).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			gruppo.get(i).setBackground(Color.GREEN);
			gruppo.get(i).setOpaque(true);


		}

		blocco.setLayout(new GridLayout(5,10));

		for (JPanel j : gruppo) {
			j.setSize(50, 46);
			blocco.add(j);

		}
		blocco.setBorder(BorderFactory.createLineBorder(Color.black));

		this.add(blocco);

		this.setVisible(true);

	}

	public Collection<PostoButton> getAllButtons() {
		return posto;
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		img=new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/10,(int)(dim.height-100)/5,java.awt.Image.SCALE_SMOOTH));

		blocco.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		
		for(int i=0;i<50;i++) {
			posto.get(i).modificaImg(img);
			posto.get(i).revalidate();
			gruppo.get(i).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			gruppo.get(i).revalidate();
			posto.get(i).revalidate();
			gruppo.get(i).repaint();
		}
		
		blocco.revalidate();
		blocco.repaint();
	}

	@Override
	public Type getType() {
		return AView.Type.POSTO;
	}

}
