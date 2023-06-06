package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	private JPanel selezionesquadra;
	private JLabel titolo;
	
	public AdminAddPartiteView(Dimension dim) {
		
		Font medium=new Font("Arial", 1, 18);
		Font large=new Font("Arial",1,24);
		
		nomesquadra=new ArrayList<JLabel>();
		squadra=new ArrayList<JPanel>();
		img=new ArrayList<ImageIcon>();
		sceltasquadra=new ArrayList<SquadraButton>();
		selezionesquadra=new JPanel();
		
		for(Squadre s: Squadre.values()) {
			if(s!=Squadre.Inter) {
				nomesquadra.add(new JLabel(""+s));
				img2=new ImageIcon(getClass().getResource("/Stemma_"+s+".png"));
				img.add(new ImageIcon(img2.getImage().getScaledInstance(dim.width/12, dim.height/12, java.awt.Image.SCALE_SMOOTH)));
			}
		}
		
		for(int i=0;i<19;i++) {
			nomesquadra.get(i).setFont(medium);
			nomesquadra.get(i).setHorizontalAlignment((int) CENTER_ALIGNMENT);
			sceltasquadra.add(new SquadraButton(img.get(i)));
			squadra.add(new JPanel());
			squadra.get(i).setLayout(new BorderLayout());
			squadra.get(i).add(sceltasquadra.get(i),BorderLayout.CENTER);
			squadra.get(i).add(nomesquadra.get(i),BorderLayout.SOUTH);
			squadra.get(i).setBorder(BorderFactory.createLineBorder(Color.black,5));
		}
		selezionesquadra.setPreferredSize(new Dimension(dim.width,dim.height/3));
		selezionesquadra.setLayout(new GridLayout(2,10));
		selezionesquadra.add(squadra.get(0));
		selezionesquadra.add(squadra.get(1));
		selezionesquadra.add(squadra.get(2));
		selezionesquadra.add(squadra.get(3));
		selezionesquadra.add(squadra.get(4));
		selezionesquadra.add(squadra.get(5));
		selezionesquadra.add(squadra.get(6));
		selezionesquadra.add(squadra.get(7));
		selezionesquadra.add(squadra.get(8));
		selezionesquadra.add(squadra.get(9));
		selezionesquadra.add(squadra.get(10));
		selezionesquadra.add(squadra.get(11));
		selezionesquadra.add(squadra.get(12));
		selezionesquadra.add(squadra.get(13));
		selezionesquadra.add(squadra.get(14));
		selezionesquadra.add(squadra.get(15));
		selezionesquadra.add(squadra.get(16));
		selezionesquadra.add(squadra.get(17));
		selezionesquadra.add(squadra.get(18));
		//selezionesquadra.setBackground(Color.BLUE);
		//selezionesquadra.setOpaque(true);
		
		
		titolo=new JLabel("AGGIUNGI UNA PARTITA");
		titolo.setFont(large);
		//titolo.setBackground(Color.BLUE);
		//titolo.setOpaque(true);
		titolo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		//this.setBackground(Color.BLUE);
		this.add(titolo,BorderLayout.NORTH);
		this.add(selezionesquadra,BorderLayout.CENTER);
	}

}
