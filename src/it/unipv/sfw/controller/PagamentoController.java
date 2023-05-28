package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.PagamentoView;

public class PagamentoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		PagamentoView v = new PagamentoView(dim);
		
		v.getBackBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Sessione.getIstance().getCurrentPagamento() == 1)ControllerManager.getInstance().loadController(9);
				else if (Sessione.getIstance().getCurrentPagamento() == 2) ControllerManager.getInstance().loadController(11);
				else ControllerManager.getInstance().loadController(6);
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
