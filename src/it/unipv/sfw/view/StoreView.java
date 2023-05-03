package it.unipv.sfw.view;

import java.awt.Dimension;

import it.unipv.sfw.model.store.StoreOnline;

public class StoreView extends AView {
	
	public StoreView(StoreOnline store, Dimension dim) {
		
	}

	@Override
	public Type getType() {
		return AView.Type.STORE;
	}

}
