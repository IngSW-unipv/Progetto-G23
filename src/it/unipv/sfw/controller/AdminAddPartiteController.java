package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.view.AdminAddOggettoView;
import it.unipv.sfw.view.AdminAddPartiteView;

public class AdminAddPartiteController extends AController{

	@Override
	public Type getType() {
		return AController.Type.AADDPARTITA;
	}

	@Override
	public void initialize(Dimension dim) {
		AdminAddPartiteView v=new AdminAddPartiteView(dim);
		view =v;
		
	}
	
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
