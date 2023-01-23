package it.unipv.sfw.controller;

import it.unipv.sfw.frame.Frame;

public class ControllerManager {
	
	public static void main(String[] args) {
		ControllerManager m = ControllerManager.getInstance();
		m.loadController(0);
	}
	
	private static ControllerManager instance = null;
	private Frame f;
	private IController currentController;
	private final IController[] controllers;
	
	private ControllerManager() {
		// init controllers
		controllers = new IController[7];
		controllers[0] = new LoginController();
		controllers[1] = new RegistrazioneController();
		controllers[2] = new SectorController();
		controllers[3] = new BloccoController();
		controllers[4] = new AnelloController();
		controllers[5] = new PostoController();
		controllers[6] = new PartiteController();
		
		currentController = null;
		
		// init frame
		f = new Frame(900, 600);
	}
	
	public static ControllerManager getInstance() {
		if (instance == null)
			instance = new ControllerManager();
		return instance;
	}
	
	public void loadController(int id) {
		// TODO: check if id is valid
		currentController = controllers[id];
		f.loadView(currentController.getView());
		currentController.onLoad();
	}
}
