package it.unipv.sfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.PostoView;
import it.unipv.sfw.view.buttons.PostoButton;

public class PostoController implements IController {
	
	private PostoView v;
	
	public PostoController() {
		v = new PostoView(50);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((PostoButton)e.getSource()).getCode();
				Sessione s = Sessione.getIstance();
				s.setCurrentPosto(new Posto(code));
				// temp stampa acquisto
				System.out.println("Posto selezionato: S" +
						s.getCurrentSettore().getNSettore() +
						", B" + s.getCurrentBlocco().getNBlocco() +
						", A" + s.getCurrentAnello().getNAnello() +
						", P" + s.getCurrentPosto().getNPosto() + ".");
				
				ControllerManager.getInstance().loadController(6);
			}
		};
		
		Collection<PostoButton> btns = v.getAllButtons();
		for (PostoButton b : btns)
			b.addActionListener(a);
	}
	

	@Override
	public AView getView() {
		return v;
	}


	@Override
	public void onLoad() {}

}
