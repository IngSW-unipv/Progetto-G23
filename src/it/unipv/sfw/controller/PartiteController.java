package it.unipv.sfw.controller;

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

public class PartiteController implements IController {
	
	private PartiteView v;
	
	public PartiteController() {
		Partita[] p = new Partita[6];
		p[0] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[1] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[2] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[3] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[4] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		p[5] = new Partita(new GregorianCalendar(2023, 1, 15, 15, 30), Partita.Squadre.Napoli);
		
		v = new PartiteView(p);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int codePartita = ((UtenteButton)e.getSource()).getCode();
				System.out.println("Selezionata partita numero: " + codePartita + ".");
				Sessione.getIstance().resetAcquistoPartita();
			}
		};
		
		Collection<UtenteButton> btns = v.getButtons();
		for (UtenteButton b : btns)
			b.addActionListener(a);
	}

	@Override
	public AView getView() {
		return v;
	}

	@Override
	public void onLoad() {
		Utente u = Sessione.getIstance().getCurrentUtente();
		System.out.println("Al momento loggato come: " + u.getEmail() + ".");
	}

}

