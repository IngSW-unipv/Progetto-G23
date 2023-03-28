package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import it.unipv.sfw.frame.Frame;



/**
 * Classe Singleton che si occupa della gestione 
 * dei controllers e del caricamento della view corrente nel frame.
 * 
 * @author Gabriele Invernizzi
 * @see IController
 * @see Frame
 * @see it.unipv.sfw.view.AView
 */
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
		// init frame
		f = new Frame(900, 600);
	
		// init controllers
		controllers = new IController[7];
		controllers[0] = new LoginController();
		controllers[1] = new RegistrazioneController();
		controllers[2] = new SectorController();
		controllers[3] = new BloccoController();
		controllers[4] = new AnelloController();
		controllers[5] = new PostoController();
		controllers[6] = new PartiteController(f.getCurrentSize());
		
		currentController = null;
		
		// add resize evenet listener
		f.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				currentController.onWindowResized(f.getCurrentSize());
			}
		});
	}
	
	/**
	 * @return L'istanza corrente del {@link ControllerManager} nel caso non esista viene creata.
	 */
	public static ControllerManager getInstance() {
		if (instance == null)
			instance = new ControllerManager();
		return instance;
	}
	
	/**
	 * Funzione utilizzata per caricare un controller e la sua rispettiva view nel {@link Frame}.
	 * @param id Controller id
	 * @see IController
	 * @see it.unipv.sfw.view.AView
	 * @see Frame
	 */
	public void loadController(int id) {
		// TODO: check if id is valid
		currentController = controllers[id];
		f.loadView(currentController.getView());
		currentController.onLoad(f.getCurrentSize());
	}
	
}
