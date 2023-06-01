package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.view.AdminModifyStoreView;

public class AdminModifyStoreController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		AdminModifyStoreView v = new AdminModifyStoreView();
		
		view = v;
		
	}

}
