package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.CarrelloView;
import it.unipv.sfw.view.buttons.StoreButton;

public class CarrelloController extends AController {
	
	private HashMap<Merchandising, Integer> carrello;
	
	@Override
	public void initialize(Dimension dim) {
		Sessione s = Sessione.getIstance();
		carrello = s.getCarrello();
		
		CarrelloView v = new CarrelloView(s.getCarrelloList(), dim);
		
		v.getStoreBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(7);		
			}
		});
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int merch_code = ((StoreButton)e.getSource()).getMerchCode();
				
				carrello.remove(new Merchandising(null, 0, merch_code, 0, null));
				
				Sessione.getIstance().setCarrello(carrello);
			}
		};
		
		for (StoreButton b : v.getRemBtns()) {
			b.addActionListener(a);
		}
		
		view = v;
	}
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
