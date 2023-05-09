package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.store.Merchandising;
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
		
		StoreView v = new StoreView(s.getMerch(), s.getCart(), dim);
		
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
		
		v.getMuseoBtn().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(10);
			}
		});
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreButton b = ((StoreButton)e.getSource());
				s.addMerchToCart(b.getMerch(), 1);
				((StoreView)view).onCartUpdate(s.getCart(), b.getMerch());
			}
		};
		
		for (StoreButton b : v.getBuyBtns()) {
			b.addActionListener(a);
		}
		
		view = v;
	}
	
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}