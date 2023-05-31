package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.view.AdminAddOggettoView;
import it.unipv.sfw.view.AdminModifyStoreView;
import it.unipv.sfw.view.AdminMuseoView;

public class AdminModifyStoreController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		AdminModifyStoreView v = new AdminModifyStoreView();
		
		view = v;
		
	}

}
