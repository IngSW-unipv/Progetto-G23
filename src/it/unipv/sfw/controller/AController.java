package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.view.AView;


/**
 * Classe astratta di un generico controller,
 * viene usata da {@link ControllerManager}.
 * 
 * @author Gabriele Invernizzi
 * @see ControllerManager
 */
public abstract class AController {
	/**
	 * {@link it.unipv.sfw.view.AView} utilizzata dalle sottoclassi.
	 */
	protected AView view;
	/**
	 * @return Una {@link it.unipv.sfw.view.AView} inizializzata dal controller.
	 * @see it.unipv.sfw.view.AView
	 */
	public AView getView() { return view; }
	
	/**
	 * onLoad viene chiamata da {@link ControllerManager} appena dopo
	 * aver caricato l'istanza di {@link AController}. 
	 * Implementata vuota, per comportamenti diversi bisogna sovrascriverla nelle sottoclassi.
	 * @param dim Dimensione corrente della finestra.
	 * @see ControllerManager
	 */
	public void onLoad(Dimension dim) {
		this.onWindowResized(dim);
	}
	
	/**
	 * Fuzione chiamata quando viene attivato l'evento di window resize.
	 * Implementazione semplice, per comportamenti diversi bisogna svrascriverla nelle sottoclassi.
	 * @param dim Nuova dimensione della finestra.
	 */
	public void onWindowResized(Dimension dim) {
		view.onWindowResized(dim);
	}
}
