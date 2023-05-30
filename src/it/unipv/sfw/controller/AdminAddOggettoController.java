package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.view.AdminAddOggettoView;
import it.unipv.sfw.view.AdminMuseoView;

public class AdminAddOggettoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		AdminAddOggettoView mview = new AdminAddOggettoView();
		
		mview.getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(15);
			}
			
		});
		
		view = mview;
		
	}

}
