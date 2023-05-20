package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.RegistrazioneView;


/**
 * Controller che si occupa della RegistrazioneView.
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.RegistrazioneView
 */
public class RegistrazioneController extends AController {

	@Override
	public void initialize(Dimension dim) {
		RegistrazioneView v = new RegistrazioneView(dim);
		
		v.getRegistratiBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = Date.from(v.getData().atStartOfDay(ZoneId.systemDefault()).toInstant());
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				// Login into session
				Cliente u = new Cliente(
						v.getNome().getText(),
						v.getCognome().getText(),
						v.getEmail().getText(),
						new String(v.getPassword().getPassword()),
						cal);
				try {	
					Sessione.getIstance().register(u);
				} catch(Exception err) {
					err.printStackTrace();
				}

				ControllerManager.getInstance().loadController(6);
			}
		});
		
		v.getToLoginBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(0);
			}
		});
		
		view = v;
	}
}
