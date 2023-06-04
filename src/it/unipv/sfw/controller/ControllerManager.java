package it.unipv.sfw.controller;

import java.util.HashMap;

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
		m.loadController(AController.Type.LOGIN);
	}
	
	private static ControllerManager instance = null;
	private Frame f;
	private AController currentController;
	private HashMap<AController.Type, ControllerCache> controllers;
	
	private ControllerManager() {
		// init DAOFactory
		DAOFactory.createInstance(DAOFactory.DBType.MYSQL);
		
		// init look and feel
		FlatLightLaf.setup();
		
		// init frame
		f = new Frame(900, 600);
	
		// init controllers
		controllers = new HashMap<>(AController.Type.values().length);
		this.addController(new LoginController());
		this.addController(new RegistrazioneController());
		this.addController(new SectorController());
		this.addController(new AnelloController());
		this.addController(new BloccoController());
		this.addController(new PostoController());
		this.addController(new PartiteController());
		this.addController(new StoreController());
		this.addController(new ProfiloPersonaleController());
		this.addController(new CarrelloController());
		this.addController(new MuseoController());
		this.addController(new BigliettoMuseoController());
		this.addController(new PagamentoController());
		this.addController(new AdminStoreController());
		this.addController(new AdminPartiteController());
		this.addController(new AdminMuseoController());
		this.addController(new AdminAddOggettoController());
		this.addController(new AdminModifyStoreController());
		this.addController(new RegistroBigliettiMuseoController());
		
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
	 * Aggiunge un controller a "controllers" dopo averlo inserito in un ControllerCache.
	 * @param contr Controller da inserire.
	 */
	private void addController(AController contr) {
		AController.Type t = contr.getType();
		if (!controllers.containsKey(t))
			controllers.put(t, new ControllerCache(contr));
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
	 * @param contr Controller type
	 * @throws RuntimeException se il controller richiesto non esiste.
	 * @see AController
	 * @see it.unipv.sfw.view.AView
	 * @see Frame
	 */
	public void loadController(AController.Type contr) {
		if (!controllers.containsKey(contr))
			throw new RuntimeException("Il controller :\"" + contr + "\" non esiste.");
		currentController = controllers.get(contr).loadController(f.getCurrentSize());
		f.loadView(currentController.getView());
	}
	
}
