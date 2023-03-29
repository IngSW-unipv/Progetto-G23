package it.unipv.sfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.BloccoView;
import it.unipv.sfw.view.buttons.BloccoButton;


/**
 * Controller che si occupa della BloccoView.
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.BloccoView
 */
public class BloccoController extends AController {
	
	public BloccoController() {
		view = new BloccoView(2500);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((BloccoButton)e.getSource()).getCode();
				Sessione.getIstance().setBlocco(code);;
				ControllerManager.getInstance().loadController(4);
			}
		};
		
		Collection<BloccoButton> btns = ((BloccoView)view).getAllBloccoButton();
		for (BloccoButton b : btns)
			b.addActionListener(a);
	}
}
