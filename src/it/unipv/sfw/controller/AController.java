package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.view.AView;

/**
 * Classe astratta di un generico controller, viene usata da
 * {@link ControllerManager}.
 *
 * @author Gabriele Invernizzi
 * @see ControllerManager
 */
public abstract class AController {
	/**
	 * Enumerazione che rappresenta ogni tipo di controller.
	 */
	public enum Type {
		REGISTRAZIONE, LOGIN, PARTITE, SETTORE, BLOCCO, ANELLO, POSTO, STORE, CARRELLO, MUSEO, BIGLIETTO_MUSEO,
		PAGAMENTO, PROFILO, APARTITE, AADDOGGETTO, AMODIFYSTORE, AMUSEO, ASTORE, BREGISTRO, AADDPARTITA
	}

	/**
	 * {@link it.unipv.sfw.view.AView} utilizzata dalle sottoclassi.
	 */
	protected AView view = null;

	/**
	 * @return Il tipo del controller.
	 */
	public abstract Type getType();

	/**
	 * @return Una {@link it.unipv.sfw.view.AView} inizializzata dal controller.
	 * @see it.unipv.sfw.view.AView
	 */
	public AView getView() {
		return view;
	}

	/**
	 * Funzione chiamata durante l'inizializzazione del controller. Normalmente è
	 * chiamata solo una volta durante la vita dell'applicazione.
	 *
	 * @param dim La dimensione corrente del frame.
	 */
	public abstract void initialize(Dimension dim);

	/**
	 * onLoad viene chiamata da {@link ControllerManager} appena dopo aver caricato
	 * l'istanza di {@link AController}.
	 *
	 * @param dim Dimensione corrente della finestra.
	 * @see ControllerManager
	 */
	public void onLoad(Dimension dim) {
		view.onLoad();
		this.onWindowResized(dim);
	}

	/**
	 * Fuzione chiamata quando viene attivato l'evento di window resize.
	 * Implementazione semplice, per comportamenti diversi bisogna sovrascriverla
	 * nelle sottoclassi.
	 *
	 * @param dim Nuova dimensione della finestra.
	 */
	public void onWindowResized(Dimension dim) {
		view.onWindowResized(dim);
	}
}
