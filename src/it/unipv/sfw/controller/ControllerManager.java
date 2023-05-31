package it.unipv.sfw.controller;

import com.formdev.flatlaf.FlatLightLaf;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.eventlisteners.ComponentResizeEndListener;
import it.unipv.sfw.frame.Frame;



/**
 * Classe Singleton che si occupa della gestione 
 * dei controllers e del caricamento della view corrente nel frame.
 * 
 * @author Gabriele Invernizzi
 * @see AController
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
	private AController currentController;
	private final ControllerCache[] controllers;
	private final int N_CONTROLLERS = 17;
	
	private ControllerManager() {
		// init DAOFactory
		DAOFactory.createInstance(DAOFactory.DBType.MYSQL);
		
		// init look and feel
		FlatLightLaf.setup();
		
		// init frame
		f = new Frame(900, 600);
	
		// init controllers
		controllers = new ControllerCache[N_CONTROLLERS];
		controllers[0] = new ControllerCache(new LoginController());
		controllers[1] = new ControllerCache(new RegistrazioneController());
		controllers[2] = new ControllerCache(new SectorController());
		controllers[3] = new ControllerCache(new AnelloController());
		controllers[4] = new ControllerCache(new BloccoController());
		controllers[5] = new ControllerCache(new PostoController());
		controllers[6] = new ControllerCache(new PartiteController());
		controllers[7] = new ControllerCache(new StoreController());
		controllers[8] = new ControllerCache(new ProfiloPersonaleController());
		controllers[9] = new ControllerCache(new CarrelloController());
		controllers[10] = new ControllerCache(new MuseoController());
		controllers[11] = new ControllerCache(new BigliettoMuseoController());
		controllers[12] = new ControllerCache(new PagamentoController());
		controllers[13] = new ControllerCache(new AdminStoreController());
		controllers[14] = new ControllerCache(new AdminPartiteController());
		controllers[15] = new ControllerCache(new AdminMuseoController());
		controllers[16] = new ControllerCache(new AdminAddOggettoController());
		
		currentController = null;
		
		// add resize event listener
		f.addComponentListener(new ComponentResizeEndListener(100) {
			@Override
			public void onResizedTimedOut() {
				if (currentController != null)
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
	 * Lancia un'eccezione se l'id del controller non è valido.
	 * @param id Controller id
	 * @see AController
	 * @see it.unipv.sfw.view.AView
	 * @see Frame
	 */
	public void loadController(int id) {
		if (id < 0 || id >= N_CONTROLLERS)
			throw new RuntimeException(
					"Invalid controller id \'" + id + "\', the max is \'" + (N_CONTROLLERS - 1) + "\'"
					);
		
		currentController = controllers[id].loadController(f.getCurrentSize());
		f.loadView(currentController.getView());
	}
	
}
