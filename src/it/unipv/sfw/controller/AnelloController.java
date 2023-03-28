package it.unipv.sfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.partita.Anello;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.AnelloView;
import it.unipv.sfw.view.buttons.AnelloButton;


/**
 * Controller che si occupa della AnelloView.
 * @author Gabriele Invernizzi
 * @see IController
 * @see it.unipv.sfw.view.AnelloView
 */
public class AnelloController implements IController {
	
	private AnelloView v;
	
	public AnelloController() {
		v = new AnelloView();
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((AnelloButton)e.getSource()).getCode();
				Sessione.getIstance().setAnello(code);
				ControllerManager.getInstance().loadController(5);
			}
		};
		
		Collection<AnelloButton> btns = v.getButtons();
		for (AnelloButton b : btns)
			b.addActionListener(a);
	}
	

	@Override
	public AView getView() {
		return v;
	}


	@Override
	public void onLoad() {}
}
