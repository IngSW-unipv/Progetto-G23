package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import it.unipv.sfw.view.ProfiloPersonaleView;

public class ProfiloPersonaleController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		ProfiloPersonaleView v = new ProfiloPersonaleView(dim);
		
		v.getHome().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		view=v;
		
	}

}
