package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.view.ProfiloPersonaleView;

public class ProfiloPersonaleController extends AController{
	
	private Cliente c; 

	@Override
	public void initialize(Dimension dim) {
		try {
			c=(Cliente)Sessione.getIstance().getCurrentUtente();
		}catch (Exception e) {
		      System.out.println("Errore");
	    }
		
		ProfiloPersonaleView v = new ProfiloPersonaleView(dim,c);
		
		v.getHome().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		v.getInfo().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				v.setInfoAbb(false);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				v.setInfoAbb(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		view=v;
		
	}

}
