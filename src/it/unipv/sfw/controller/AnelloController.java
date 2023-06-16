package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.partita.Stadio;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AnelloView;
import it.unipv.sfw.view.buttons.AnelloButton;

/**
 * Controller che si occupa della AnelloView.
 *
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.AnelloView
 */
public class AnelloController extends AController {

	@Override
	public Type getType() {
		return Type.ANELLO;
	}

	@Override
	public void initialize(Dimension dim) {
		Sessione s = Sessione.getIstance();
		Stadio stadio = new Stadio(s.getCurrentPartita().getCalendarDate());
		AnelloView v = new AnelloView(dim, stadio, s.getSettore());

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((AnelloButton) e.getSource()).getCode();
				Sessione.getIstance().setAnello(code);
				ControllerManager.getInstance().loadController(Type.BLOCCO);
			}
		};

		Collection<AnelloButton> btns = v.getButtons();
		for (AnelloButton b : btns)
			b.addActionListener(a);

		v.getHomeButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControllerManager.getInstance().loadController(Type.PARTITE);
			}
		});

		view = v;
	}
}
