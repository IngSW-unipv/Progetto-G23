package it.unipv.sfw.view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unipv.sfw.model.partita.Stadio;
import it.unipv.sfw.view.buttons.SectorButton;


/**
 * Classe che crea la view degli 8 settori del campo. 
 *
 * @author Jacopo Piccoli
 * @see it.unipv.sfw.view.buttons.SectorButton
 */

public class SectorView extends AView {

	private JPanel north, east, south, west, prova, settori;
	private JLabel campo;
	private Image imgC;
	private ImageIcon imgS1,imgS2,imgS3,imgS4,imgS5,imgS6,imgS7,imgS8;
	private JButton homeBtn;
	private ArrayList<SectorButton> s;

	public SectorView(Dimension dim, Stadio stadio) {
		
		Font largeFont = new Font("Arial", 1, 32);

		s = new ArrayList<SectorButton>();
		
		imgS1 = new ImageIcon(this.getClass().getResource("/Settore1.png"));
		imgS1=new ImageIcon(imgS1.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS2 = new ImageIcon(this.getClass().getResource("/Settore2.png"));
		imgS2=new ImageIcon(imgS2.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS3 = new ImageIcon(this.getClass().getResource("/Settore3.png"));
		imgS3=new ImageIcon(imgS3.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));
		imgS4 = new ImageIcon(this.getClass().getResource("/Settore4.png"));
		imgS4=new ImageIcon(imgS4.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));
		imgS5 = new ImageIcon(this.getClass().getResource("/Settore5.png"));
		imgS5=new ImageIcon(imgS5.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS6 = new ImageIcon(this.getClass().getResource("/Settore6.png"));
		imgS6=new ImageIcon(imgS6.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS7 = new ImageIcon(this.getClass().getResource("/Settore7.png"));
		imgS7=new ImageIcon(imgS7.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));
		imgS8 = new ImageIcon(this.getClass().getResource("/Settore8.png"));
		imgS8=new ImageIcon(imgS8.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));

		s.add(new SectorButton("",1,true,imgS1, stadio.isLibero(1)));
		s.add(new SectorButton("",2,true,imgS2, stadio.isLibero(2)));
		s.add(new SectorButton("",3,true,imgS3, stadio.isLibero(3)));
		s.add(new SectorButton("",4,true,imgS4, stadio.isLibero(4)));
		s.add(new SectorButton("",5,true,imgS5, stadio.isLibero(5)));
		s.add(new SectorButton("",6,true,imgS6, stadio.isLibero(6)));
		s.add(new SectorButton("",7,true,imgS7, stadio.isLibero(7)));
		s.add(new SectorButton("",8,true,imgS8, stadio.isLibero(8)));
		
		
		JLabel titolo=new JLabel("SELEZIONA UN SETTORE");
		titolo.setFont(largeFont);
		titolo.setHorizontalAlignment(JLabel.CENTER);
		titolo.setBorder(BorderFactory.createEmptyBorder(0,50,0,0));
		
		homeBtn=new JButton();
		homeBtn.setIcon(new ImageIcon(getClass().getResource("/home.png")));
		
		JPanel title=new JPanel();
		title.setLayout(new BorderLayout());
		title.add(titolo,BorderLayout.CENTER);
		title.add(homeBtn,BorderLayout.EAST);

		campo = new JLabel();
		imgC = new ImageIcon(this.getClass().getResource("/Campo.png")).getImage();
		campo.setIcon(new ImageIcon(imgC.getScaledInstance(dim.width/2,(dim.height-45)/2, java.awt.Image.SCALE_SMOOTH)));
		
		JPanel middle=new JPanel();
		middle.add(campo);
		

		north = new JPanel();
		north.setLayout(new GridLayout(1, 2));
		s.get(0).setBackground(Color.red);
		s.get(0).setOpaque(true);
		north.add(s.get(0));

		s.get(1).setBackground(Color.blue);
		s.get(1).setOpaque(true);
		north.add(s.get(1));

		east = new JPanel();
		east.setLayout(new GridLayout(2, 1));
		s.get(2).setBackground(Color.yellow);
		s.get(2).setOpaque(true);
		east.add(s.get(2));

		s.get(3).setBackground(Color.MAGENTA);
		s.get(3).setOpaque(true);
		east.add(s.get(3));

		south = new JPanel();
		south.setLayout(new GridLayout(1, 2));
		s.get(5).setBackground(Color.GREEN);
		s.get(5).setOpaque(true);
		south.add(s.get(5));

		s.get(4).setBackground(Color.cyan);
		s.get(4).setOpaque(true);
		south.add(s.get(4));

		west = new JPanel();
		west.setLayout(new GridLayout(2, 1));
		s.get(7).setBackground(Color.orange);
		s.get(7).setOpaque(true);
		west.add(s.get(7));

		s.get(6).setBackground(Color.lightGray);
		s.get(6).setOpaque(true);
		west.add(s.get(6));
		
		
		north.setPreferredSize(new Dimension((int)((dim.width)/2), (dim.height)/4));
		south.setPreferredSize(new Dimension((int)((dim.width)/2), (dim.height)/4));
		west.setPreferredSize(new Dimension((int)((dim.width)/4), (dim.height)));
		east.setPreferredSize(new Dimension((int)((dim.width)/4), (dim.height)));

		prova = new JPanel();
		prova.setLayout(new BorderLayout());
		prova.add(north, BorderLayout.NORTH);
		prova.add(campo, BorderLayout.CENTER);
		prova.add(south, BorderLayout.SOUTH);
		

		settori = new JPanel();
		settori.setPreferredSize(new Dimension((int)((dim.width)), dim.height -45));
		settori.setLayout(new BorderLayout());
		settori.add(west, BorderLayout.WEST);
		settori.add(prova, BorderLayout.CENTER);
		settori.add(east, BorderLayout.EAST);

		this.setLayout(new BorderLayout());
		this.add(title,BorderLayout.NORTH);
		this.add(settori,BorderLayout.CENTER);

	}

	public Collection<SectorButton> getSectorButtons() {
		return s;
	}
	public JButton getHomeButton(){
		return homeBtn;
	}
	
	@Override
	public void onWindowResized(Dimension dim) {
		imgS1=new ImageIcon(imgS1.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS2=new ImageIcon(imgS2.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS3=new ImageIcon(imgS3.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));
		imgS4=new ImageIcon(imgS4.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));
		imgS5=new ImageIcon(imgS5.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS6=new ImageIcon(imgS6.getImage().getScaledInstance((int)((dim.width)/4), (dim.height)/4,java.awt.Image.SCALE_SMOOTH ));
		imgS7=new ImageIcon(imgS7.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));
		imgS8=new ImageIcon(imgS8.getImage().getScaledInstance((int)((dim.width)/4), (dim.height-50)/2,java.awt.Image.SCALE_SMOOTH ));
		
		s.get(0).modificaImg(imgS1);
		s.get(1).modificaImg(imgS2);
		s.get(2).modificaImg(imgS3);
		s.get(3).modificaImg(imgS4);
		s.get(4).modificaImg(imgS5);
		s.get(5).modificaImg(imgS6);
		s.get(6).modificaImg(imgS7);
		s.get(7).modificaImg(imgS8);
		
		settori.setPreferredSize(new Dimension((int)((dim.width)), dim.height -45));
		campo.setIcon(new ImageIcon(imgC.getScaledInstance(dim.width/2,(dim.height-45)/2, java.awt.Image.SCALE_SMOOTH)));
		north.setPreferredSize(new Dimension((int)((dim.width)/2), (dim.height)/4));
		south.setPreferredSize(new Dimension((int)((dim.width)/2), (dim.height)/4));
		west.setPreferredSize(new Dimension((int)((dim.width)/4), (dim.height*2)/4));
		east.setPreferredSize(new Dimension((int)((dim.width)/4), (dim.height*2)/4));
		
		
		campo.revalidate();
		campo.repaint();
		north.revalidate();
		north.repaint();
		south.revalidate();
		south.repaint();
		west.revalidate();
		west.repaint();
		east.revalidate();
		east.repaint();
		settori.revalidate();
		settori.repaint();		
	}
}
