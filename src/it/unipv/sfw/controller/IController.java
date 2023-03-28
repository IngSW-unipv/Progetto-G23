package it.unipv.sfw.controller;

import java.awt.Dimension;

import it.unipv.sfw.view.AView;


/**
 * Interfaccia di un generico controller,
 * viene usata da {@link ControllerManager}.
 * 
 * @author Gabriele Invernizzi
 * @see ControllerManager
 */
public interface IController {
	/**
	 * @return Una {@link it.unipv.sfw.view.AView} inizializzata dal controller.
	 * @see it.unipv.sfw.view.AView
	 */
	public AView getView();
	
	/**
	 * onLoad viene chiamata da {@link ControllerManager} appena dopo
	 * aver caricato l'istanza di {@link IController}.
	 * @see ControllerManager
	 */
	public void onLoad(Dimension dim);
	
	/**
	 * Fuzione chiamata quando viene attivato l'evento di window resize.
	 * @param dim Nuova dimensione della finestra.
	 */
	public void onWindowResized(Dimension dim);
}
