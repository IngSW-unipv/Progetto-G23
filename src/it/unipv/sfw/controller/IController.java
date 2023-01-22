package it.unipv.sfw.controller;

import it.unipv.sfw.view.AView;

public interface IController {
	public AView getView();
	
	public void onLoad();
}
