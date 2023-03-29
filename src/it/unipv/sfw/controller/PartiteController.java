package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.GregorianCalendar;

import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.PartiteView;
import it.unipv.sfw.view.buttons.UtenteButton;



/**
 * Controller che si occupa della PartiteView.
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.PartiteView
 */
public class PartiteController extends AController {
	
	public PartiteController(Dimension dim) {
		Partita[] p = new Partita[6];
		p[0] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[1] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[2] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[3] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[4] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[5] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		
		PartiteView v = new PartiteView(p, dim);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int codePartita = ((UtenteButton)e.getSource()).getCode();
				System.out.println("Selezionata partita numero: " + codePartita + ".");
				Sessione.getIstance().resetScelte();
				ControllerManager.getInstance().loadController(2);
			}
		};
		
		Collection<UtenteButton> btns = v.getButtons();
		for (UtenteButton b : btns)
			b.addActionListener(a);
		
		view = v;
	}

	@Override
	public void onLoad(Dimension dim) {
		Utente u = Sessione.getIstance().getCurrentUtente();
		System.out.println("Al momento loggato come: " + u.getEmail() + ".");
		view.onWindowResized(dim);
	}

	@Override
	public void onWindowResized(Dimension dim) {
		view.onWindowResized(dim);	
	}
}

