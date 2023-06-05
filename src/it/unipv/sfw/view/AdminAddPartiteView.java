package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.view.buttons.SquadraButton;
 
public class AdminAddPartiteView extends AView {
	private ArrayList<JLabel> nomesquadra;
	private ArrayList<ImageIcon> img;
	private ImageIcon img2;
	private ArrayList<SquadraButton> sceltasquadra;
	private ArrayList<JPanel>squadra;
	
	public AdminAddPartiteView(Dimension dim) {
		
		nomesquadra=new ArrayList<JLabel>();
		squadra=new ArrayList<JPanel>();
		img=new ArrayList<ImageIcon>();
		sceltasquadra=new ArrayList<SquadraButton>();
		
		for(Squadre s: Squadre.values()) {
			nomesquadra.add(new JLabel(""+s));
			img2=new ImageIcon(getClass().getResource("/Stemma_"+s+".png"));
			img.add(new ImageIcon(img2.getImage().getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH)));
		}
		
		for(int i=0;i<20;i++) {
			nomesquadra.get(i).setFont(new java.awt.Font("Arial", 1, 18));
			nomesquadra.get(i).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			sceltasquadra.add(new SquadraButton(img.get(i)));
			squadra.add(new JPanel());
			squadra.get(i).setLayout(new BorderLayout());
			squadra.get(i).add(sceltasquadra.get(i),BorderLayout.CENTER);
			squadra.get(i).add(nomesquadra.get(i),BorderLayout.SOUTH);
			squadra.get(i).setBorder(BorderFactory.createLineBorder(Color.black,5));
		}
		
		this.setLayout(new GridLayout(2,10));
		this.add(squadra.get(0));
		this.add(squadra.get(1));
		this.add(squadra.get(2));
		this.add(squadra.get(3));
		this.add(squadra.get(4));
		this.add(squadra.get(5));
		this.add(squadra.get(6));
		this.add(squadra.get(7));
		this.add(squadra.get(8));
		this.add(squadra.get(9));
		this.add(squadra.get(10));
		this.add(squadra.get(11));
		this.add(squadra.get(12));
		this.add(squadra.get(13));
		this.add(squadra.get(14));
		this.add(squadra.get(15));
		this.add(squadra.get(16));
		this.add(squadra.get(17));
		this.add(squadra.get(18));
		this.add(squadra.get(19));
	}

}
