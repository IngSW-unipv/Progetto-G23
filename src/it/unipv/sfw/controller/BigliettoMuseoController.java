package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.exceptions.AccountNotFoundException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.exceptions.WrongPasswordException;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.view.BigliettoMuseoView;

public class BigliettoMuseoController extends AController {
	
	@Override
	public void initialize(Dimension dim) {
		
		Utente cliente = Sessione.getIstance().getCurrentUtente();
		
		BigliettoMuseoView bview = new BigliettoMuseoView(dim);
		
		
		bview.getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(10);
			}
			
		});
		
		bview.getAcquistaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Sessione.getIstance().enterEmail(bview.getEnteredEmail());
				} catch (WrongEmailFormatException err) {
					bview.upError();
					return;
				}
				// Load new page
				ControllerManager.getInstance().loadController(10);
			}
		});
			
		
		view = bview;
		
	}

}
