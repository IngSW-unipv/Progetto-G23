package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.view.AnelloView;
import it.unipv.sfw.view.ProfiloPersonaleView;

public class ProfiloPersonaleController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		view = new ProfiloPersonaleView(dim);
		
	}

}
