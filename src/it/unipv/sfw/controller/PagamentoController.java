package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.view.PagamentoView;

public class PagamentoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		PagamentoView v = new PagamentoView(dim);
		view = v;
	}
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
