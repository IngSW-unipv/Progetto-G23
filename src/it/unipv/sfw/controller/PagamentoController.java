package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.PagamentoView;

public class PagamentoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		PagamentoView v = new PagamentoView(dim);
		
		v.getCarrelloBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(9);	
			}
		});
		
		v.getOkBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
				Sessione.getIstance().resetCarrello();
			}
		});
		
		view = v;
	}
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
