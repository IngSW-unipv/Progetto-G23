package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.controller.AController.Type;
import it.unipv.sfw.model.partita.Stadio;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.SectorView;
import it.unipv.sfw.view.buttons.SectorButton;


/**
 * Controller che si occupa della SectorView.
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.SectorView
 */
public class SectorController extends AController {
	
	@Override
	public void initialize(Dimension d) {
		Stadio stadio = new Stadio(Sessione.getIstance().getCurrentPartita().getCalendarDate());
		SectorView v = new SectorView(d, stadio);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((SectorButton)e.getSource()).getCode();
				Sessione.getIstance().setSettore(code);
				ControllerManager.getInstance().loadController(Type.ANELLO);
			}
		};
		
		Collection<SectorButton> btns = v.getSectorButtons();
		for (SectorButton b : btns)
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
		return Type.SETTORE;
	}
}
