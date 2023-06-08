package it.unipv.sfw.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.github.lgooddatepicker.components.DatePicker;

import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.view.buttons.SquadraButton;
 
public class AdminAddPartiteView extends AView {
	
	private String[] opzioni= {"12:30","15:00","18:00","18:30","20:45","21:00"};
	
	private ArrayList<JLabel> nomesquadra;
	private ArrayList<ImageIcon> img;
	private ImageIcon img2;
	private ArrayList<SquadraButton> sceltasquadra;
	private ArrayList<JPanel>squadra;
	private JComboBox<String> orario;
	private JButton aggiungi;
	private JPanel middle;
	private DatePicker data;
	
	public AdminAddPartiteView(Dimension dim) {
		
		Font medium=new Font("Arial", 1, 18);
		Font large=new Font("Arial",1,24);
		
		nomesquadra=new ArrayList<JLabel>();
		squadra=new ArrayList<JPanel>();
		img=new ArrayList<ImageIcon>();
		sceltasquadra=new ArrayList<SquadraButton>();
		JPanel selezionesquadra=new JPanel();
		data=new DatePicker();
		data.setDateToToday();
		orario=new JComboBox<String>(opzioni);
		middle=new JPanel();
		
		JLabel titolo=new JLabel("AGGIUNGI UNA PARTITA");
		titolo.setFont(large);
		titolo.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		for(Squadre s: Squadre.values()) {
			if(s!=Squadre.Inter) {
				nomesquadra.add(new JLabel(""+s));
				img2=new ImageIcon(getClass().getResource("/Stemma_"+s+".png"));
				img.add(new ImageIcon(img2.getImage().getScaledInstance(dim.width/12, dim.height/12, java.awt.Image.SCALE_SMOOTH)));
			}
		}
		
		for(int i=0;i<19;i++) {
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
		selezionesquadra.setBackground(Color.black);
		
		JPanel info=new JPanel();
		
		JLabel d=new JLabel("Data:");
		d.setFont(medium);
		
		JLabel h=new JLabel("Ora:");
		h.setFont(medium);
		
		aggiungi=new JButton("AGGIUNGI");
		aggiungi.setFont(medium);
		
		info.setLayout(new GridBagLayout());		
		GridBagConstraints infoConstraints = new GridBagConstraints();
		infoConstraints.insets = new Insets(3,2,20,15);

		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 0;
		info.add(d, infoConstraints);
		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 0;
		info.add(data, infoConstraints);
		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 1;
		info.add(h, infoConstraints);
		infoConstraints.gridwidth = 1;
		infoConstraints.gridx = 1;
		infoConstraints.gridy = 1;
		info.add(orario, infoConstraints);
		infoConstraints.gridwidth = 2;
		infoConstraints.gridx = 0;
		infoConstraints.gridy = 2;
		info.add(aggiungi, infoConstraints);
		
		info.setBorder(BorderFactory.createLineBorder(Color.black,5));
		//info.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
	
		middle.setPreferredSize(new Dimension(dim.width,dim.height/2));
		middle.setLayout(new GridLayout(2,1));
		middle.add(selezionesquadra);
		middle.add(info);
		
		
		
		this.setLayout(new BorderLayout());
		this.add(titolo,BorderLayout.NORTH);
		this.add(middle,BorderLayout.CENTER);
	}

}