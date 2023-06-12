package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.controller.AController.Type;
import it.unipv.sfw.model.partita.Stadio;
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
	
	@Override
	public void initialize(Dimension dim) {	
		Sessione s = Sessione.getIstance();
		Stadio stadio = new Stadio(s.getCurrentPartita().getCalendarDate());
		BloccoView v = new BloccoView(dim, stadio, s.getSettore(), s.getAnello());
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((BloccoButton)e.getSource()).getCode();
				Sessione.getIstance().setBlocco(code);;
				ControllerManager.getInstance().loadController(Type.POSTO);
			}
		};
		
		Collection<BloccoButton> btns = v.getAllBloccoButton();
		for (BloccoButton b : btns)
			b.addActionListener(a);

		v.getHomeButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControllerManager.getInstance().loadController(Type.PARTITE);
			}
		});
		
		view=v;
	}

	@Override
	public Type getType() {
		return Type.BLOCCO;
	}
}
