package it.unipv.sfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.partita.Blocco;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.BloccoView;
import it.unipv.sfw.view.buttons.BloccoButton;


/**
 * Controller che si occupa della BloccoView.
 * @author Gabriele Invernizzi
 * @see IController
 * @see it.unipv.sfw.view.BloccoView
 */
public class BloccoController implements IController {
	
	private BloccoView v;
	
	public BloccoController() {
		v = new BloccoView(2500);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((BloccoButton)e.getSource()).getCode();
				Sessione.getIstance().setinfoScelte("B" + code);
				ControllerManager.getInstance().loadController(4);
			}
		};
		
		Collection<BloccoButton> btns = v.getAllBloccoButton();
		for (BloccoButton b : btns)
			b.addActionListener(a);
	}
	

	@Override
	public AView getView() {
		return v;
	}


	@Override
	public void onLoad() {}
}
