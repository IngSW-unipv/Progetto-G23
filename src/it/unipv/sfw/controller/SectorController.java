package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.SectorView;
import it.unipv.sfw.view.buttons.SectorButton;


/**
 * Controller che si occupa della SectorView.
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.SectorView
 */
public class SectorController extends AController {
	
	public SectorController() {
		view = new SectorView();
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((SectorButton)e.getSource()).getCode();
				Sessione.getIstance().setSettore(code);;
				ControllerManager.getInstance().loadController(3);
			}
		};
		
		Collection<SectorButton> btns = ((SectorView)view).getSectorButtons();
		for (SectorButton b : btns)
			b.addActionListener(a);
	}
}
