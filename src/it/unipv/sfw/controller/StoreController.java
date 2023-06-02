package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.controller.AController.Type;
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
				ControllerManager.getInstance().loadController(Type.PARTITE);
			}
		});
		
		v.getCartButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().setCarrello(s.getCart());
				ControllerManager.getInstance().loadController(Type.CARRELLO);
			}
		});
		
		v.getMuseoBtn().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.MUSEO);
			}
		});
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreButton b = ((StoreButton)e.getSource());
				Merchandising m = b.getMerch();
				// Check if the quantity doesn't exceed existing quantity.
				if (s.getCart().getOrDefault(m, 0) < s.getMerch().get(m)) {
					s.addMerchToCart(m, 1);
					((StoreView)view).onCartUpdate(s.getCart(), m);
				}
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


	@Override
	public Type getType() {
		return Type.STORE;
	}

}
