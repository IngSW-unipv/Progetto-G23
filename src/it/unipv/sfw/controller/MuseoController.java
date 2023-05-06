package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.view.MuseoView;

public class MuseoController extends AController {

	String storia = new String("L'inter è una squadra di calcio rappresentante la città di Milano.");
	
	@Override
	public void initialize(Dimension dim) {
		
		Museo museum = new Museo(storia, 15, 30, 18, 30);
		
		for(int i=0; i<43; i++) {
			museum.addRiconoscimento(1980+i, "Scudetto", Riconoscimento.TipoRiconoscimento.Trofeo, i);
		}
		
		MuseoView mview = new MuseoView(museum, dim);
		
		mview.getPButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		mview.getSButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(7);
			}
		});
		
		view = mview;
		
	}

}
