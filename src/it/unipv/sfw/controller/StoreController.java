package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.store.StoreOnline;
import it.unipv.sfw.view.StoreView;

public class StoreController extends AController {

	@Override
	public void initialize(Dimension dim) {
		StoreOnline s = new StoreOnline();
		
		StoreView v = new StoreView(s, dim);
		
		v.getPartiteBtn().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		view = v;
	}

}
