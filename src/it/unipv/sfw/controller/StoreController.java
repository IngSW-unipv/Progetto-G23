package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.store.StoreOnline;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.StoreView;
import it.unipv.sfw.view.buttons.StoreButton;


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
		s = new StoreOnline(Sessione.getIstance().getCarrello());
		
		StoreView v = new StoreView(s, dim);
		
		v.getPartiteBtn().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		v.getCartButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().setCarrello(s.getCart());
				ControllerManager.getInstance().loadController(9);
			}
		});
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int merch_code = ((StoreButton)e.getSource()).getMerchCode();
				int merch_index = merch_code - 1;
				s.addMerchToCart(s.getMerch().get(merch_index));
			}
		};
		
		for (StoreButton b : v.getBuyBtns()) {
			b.addActionListener(a);
		}
		
		view = v;
	}

}
