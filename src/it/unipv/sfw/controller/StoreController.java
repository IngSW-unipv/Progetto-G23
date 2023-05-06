package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.store.StoreOnline;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.StoreView;
import it.unipv.sfw.view.buttons.AcquistaButton;
import it.unipv.sfw.view.buttons.UtenteButton;


/**
 * Controller che si occupa della StoreView.
 * 
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.StoreView
 */
public class StoreController extends AController {
	
	private StoreOnline s;

	@Override
	public void initialize(Dimension dim) {
		s = new StoreOnline();
		
		StoreView v = new StoreView(s, dim);
		
		v.getPartiteBtn().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int merch_code = ((AcquistaButton)e.getSource()).getMerchCode();
				int merch_index = merch_code - 1;
				Merchandising merch = s.getMerch().get(merch_index);
				merch.setQuantita(1);
				s.addMerchToCart(merch);
			}
		};
		
		for (AcquistaButton b : v.getBuyBtns()) {
			b.addActionListener(a);
		}
		
		view = v;
	}

}
