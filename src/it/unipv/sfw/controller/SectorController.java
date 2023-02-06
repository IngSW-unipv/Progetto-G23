package it.unipv.sfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import it.unipv.sfw.model.partita.Settore;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.SectorView;
import it.unipv.sfw.view.buttons.SectorButton;


/**
 * Controller che si occupa della SectorView.
 * @author Gabriele Invernizzi
 * @see IController
 * @see it.unipv.sfw.view.SectorView
 */
public class SectorController implements IController {
	
	private SectorView v;
	
	public SectorController() {
		v = new SectorView();
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int code = ((SectorButton)e.getSource()).getCode();
				Sessione.getIstance().setinfoScelte("S" + code);
				ControllerManager.getInstance().loadController(3);
			}
		};
		
		Collection<SectorButton> btns = v.getSectorButtons();
		for (SectorButton b : btns)
			b.addActionListener(a);
	}
	

	@Override
	public AView getView() {
		return v;
	}


	@Override
	public void onLoad() {}

}
