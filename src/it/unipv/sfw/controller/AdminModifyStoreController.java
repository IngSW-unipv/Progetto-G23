package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.view.AdminModifyStoreView;

public class AdminModifyStoreController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		AdminModifyStoreView v = new AdminModifyStoreView();
		
		v.getBackBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(13);
			}
		});
		
		view = v;
		
	}

	@Override
	public void onLoad(Dimension dim) {
		((AdminModifyStoreView)view).onLoad();
		view.onWindowResized(dim);
	}
}
