package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		view=v;
		
	}

}
