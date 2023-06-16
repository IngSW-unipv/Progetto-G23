package it.unipv.sfw.controller;

import java.awt.Dimension;

/**
 * Classe utilizzata per assicurare che ogni controller venga inizializzato solo
 * una volta.
 *
 * @author Gabriele Invernizzi
 */
public class ControllerCache {

	private AController controller;
	private boolean isInit;

	/**
	 * @param controller Controller di cui si vuole mantenere la cache.
	 */
	public ControllerCache(AController controller) {
		this.controller = controller;
		this.isInit = false;
	}

	/**
	 * Funzione che esegue l'onLoad del controller dopo aver controllato che esso
	 * sia già stato inizializzato.
	 *
	 * @param dim Dimensione corrente del frame.
	 * @return Controller inizializzato e caricato.
	 */
	public AController loadController(Dimension dim) {
		if (!isInit) {
			controller.initialize(dim);
			isInit = true;
		}

		controller.onLoad(dim);
		return controller;
	}
}
