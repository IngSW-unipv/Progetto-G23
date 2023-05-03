package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.model.store.StoreOnline;
import it.unipv.sfw.view.StoreView;

public class StoreController extends AController {

	@Override
	public void initialize(Dimension dim) {
		StoreOnline s = new StoreOnline();
		
		StoreView v = new StoreView(s, dim);
		
		view = v;
	}

}
