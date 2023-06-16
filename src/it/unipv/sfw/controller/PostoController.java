package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.partita.Stadio;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.PostoView;
import it.unipv.sfw.view.buttons.PostoButton;

/**
 * Controller che si occupa della PostoView.
 *
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.PostoView
 */
public class PostoController extends AController {

	@Override
	public Type getType() {
		return Type.POSTO;
	}

	@Override
	public void initialize(Dimension dim) {
		Sessione s = Sessione.getIstance();
		Stadio stadio = new Stadio(s.getCurrentPartita().getCalendarDate());

		PostoView v = new PostoView(dim, stadio, s.getSettore(), s.getAnello(), s.getBlocco());

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((PostoButton) e.getSource()).getCode();
				Sessione s = Sessione.getIstance();
				s.setPosto(code);

				ControllerManager.getInstance().loadController(Type.PAGAMENTO);
			}
		};

		Collection<PostoButton> btns = v.getAllButtons();
		for (PostoButton b : btns)
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
