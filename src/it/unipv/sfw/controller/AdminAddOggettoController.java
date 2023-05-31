package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Riconoscimento;
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
		
		mview.getObjectType().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mview.getObjectType().getSelectedItem().equals(Cimelio.class.getSimpleName())) {
					mview.showCimelioSubType();
				}
				else if (mview.getObjectType().getSelectedItem().equals(Riconoscimento.class.getSimpleName())){
					mview.showRiconoscimentoSubType();
				}		
			}
			
		});
		
		view = mview;
		
	}

}
