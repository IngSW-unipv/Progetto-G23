package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.PostoView;
import it.unipv.sfw.view.buttons.PostoButton;


/**
 * Controller che si occupa della PostoView.
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.PostoView
 */
public class PostoController extends AController {
	
	public PostoController(Dimension dim) {
		PostoView v = new PostoView(50,dim);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((PostoButton)e.getSource()).getCode();
				Sessione s = Sessione.getIstance();
				s.setPosto(code);;
				// temp stampa acquisto
				System.out.println("Posto selezionato: S" +
						s.getSettore() +
						", B" + s.getBlocco() +
						", A" + s.getAnello() +
						", P" + s.getPosto() );
				
				ControllerManager.getInstance().loadController(6);
			}
		};
		
		Collection<PostoButton> btns = v.getAllButtons();
		for (PostoButton b : btns)
			b.addActionListener(a);
		
		view = v;
	}
	public void onWindowResized(Dimension dim) {
		view.onWindowResized(dim);	
	}
}
