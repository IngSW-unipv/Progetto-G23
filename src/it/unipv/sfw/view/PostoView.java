package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.model.partita.Stadio;
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
	private JButton homeBtn;
	private ArrayList<JLabel> nomeposto;
	private ArrayList<JPanel> gruppo;
	private ImageIcon img;

	public PostoView(Dimension dim, Stadio stadio, int n_settore, int n_anello, int n_blocco) {
		
		Font largeFont = new Font("Arial", 1, 32);
		
		JLabel titolo=new JLabel("SELEZIONA UN POSTO");
		titolo.setFont(largeFont);
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
		
		homeBtn=new JButton();
		homeBtn.setIcon(new ImageIcon(getClass().getResource("/home.png")));
		
		JPanel title=new JPanel();
		title.setLayout(new BorderLayout());
		title.add(titolo,BorderLayout.CENTER);
		title.add(homeBtn,BorderLayout.EAST);

		
		gruppo = new ArrayList<JPanel>(Stadio.POSTI_PER_BLOCCO);
		posto = new ArrayList<PostoButton>(Stadio.POSTI_PER_BLOCCO);
		nomeposto = new ArrayList<JLabel>(Stadio.POSTI_PER_BLOCCO);
		for (int i = 0; i < Stadio.POSTI_PER_BLOCCO; i++) {
			gruppo.add(null);
			posto.add(null);
			nomeposto.add(null);
		}

		img = new ImageIcon(getClass().getResource("/Posto.jpg"));
		img=new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/10,(int)(dim.height-100)/5,java.awt.Image.SCALE_SMOOTH));

		
		for (int i = 0; i < Stadio.POSTI_PER_BLOCCO; i++) {
			int n_posto = Stadio.POSTI_PER_BLOCCO - i - 1;
			boolean isLibero = stadio.isLibero(n_settore, n_anello, n_blocco, n_posto+1);
			posto.set(n_posto, new PostoButton(n_posto+1, img, true, isLibero));
			nomeposto.set(n_posto, new JLabel("" + (n_posto+1)));
			nomeposto.get(n_posto).setBackground(Color.red);
			gruppo.set(n_posto, new JPanel());
			
			gruppo.get(n_posto).setLayout(new BorderLayout());
			gruppo.get(n_posto).setPreferredSize(new Dimension((int)(dim.width)/10,(int)((dim.height-45)/5)));
			gruppo.get(n_posto).add(posto.get(n_posto), BorderLayout.CENTER);
			gruppo.get(n_posto).add(nomeposto.get(n_posto), BorderLayout.SOUTH);
			nomeposto.get(n_posto).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			if (isLibero)
				gruppo.get(n_posto).setBackground(Color.GREEN);
			else
				gruppo.get(n_posto).setBackground(Color.RED);
			gruppo.get(n_posto).setOpaque(true);
		}
		
		blocco = new JPanel();
		blocco.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		blocco.setLayout(new GridLayout(5,10));

		for (JPanel j : gruppo) {
			j.setSize(50, 46);
			blocco.add(j);

		}
		blocco.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.setLayout(new BorderLayout());
		this.add(title,BorderLayout.NORTH);
		this.add(blocco,BorderLayout.CENTER);


	}

	public Collection<PostoButton> getAllButtons() {
		return posto;
	}
	
	public JButton getHomeButton(){
		return homeBtn;
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		img=new ImageIcon(img.getImage().getScaledInstance((int)(dim.width)/10,(int)(dim.height-100)/5,java.awt.Image.SCALE_SMOOTH));

		blocco.setPreferredSize(new Dimension(dim.width,((int) (dim.height-45))));
		
		for(int i=0;i<Stadio.POSTI_PER_BLOCCO;i++) {
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
}
