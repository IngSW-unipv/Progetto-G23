package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import it.unipv.sfw.dao.mysql.PartitaDAO;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.view.PartiteView;
import it.unipv.sfw.view.buttons.UtenteButton;



/**
 * Controller che si occupa della PartiteView.
 * 
 * @author Gabriele Invernizzi,Jacopo Piccoli
 * @see AController 
 * @see it.unipv.sfw.view.PartiteView
 */
public class PartiteController extends AController {
	
	private Partita[] p;
	
	@Override
	public void initialize(Dimension dim) {
		ArrayList<Partita> p_arrlist = new PartitaDAO().selectAll();
		
		p = new Partita[p_arrlist.size()];
		
		PartiteView v = new PartiteView(p_arrlist.toArray(p), dim);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int iPartita = ((UtenteButton)e.getSource()).getCode();
				Partita p_selected = p[iPartita];
				Sessione s = Sessione.getIstance();
				s.setCurrentPartita(p_selected);
				ControllerManager.getInstance().loadController(2);
			}
		};
		
		Collection<UtenteButton> btns = v.getButtons();
		for (UtenteButton b : btns)
			b.addActionListener(a);
		
		v.getStoreButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(7);
			}
		});
		v.getProfiloPersonaleButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(8);
			}
		});
		
		v.getMuseoButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(10);
			}
		});
		
		v.getExit().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().resetScelte();
				ControllerManager.getInstance().loadController(0);
			}
		});
		
		view = v;
	}

	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
		Utente u = Sessione.getIstance().getCurrentUtente();
		System.out.println("Al momento loggato come: " + u.getEmail() + ".");
		view.onWindowResized(dim);
	}
}

