package it.unipv.sfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AView;
import it.unipv.sfw.view.RegistrazioneView;

public class RegistrazioneController implements IController {
	
	private RegistrazioneView v;

	public RegistrazioneController() {
		v = new RegistrazioneView();
		
		v.getRegistratiBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Login into session
				Cliente u = new Cliente(
						v.getNome().getText(),
						v.getCognome().getText(),
						v.getEmail().getText(),
						v.getPassword().getPassword().toString());
				Sessione.getIstance().setCurrentUtente(u);

				ControllerManager.getInstance().loadController(6);
			}
		});
		
		v.getToLoginBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(0);
			}
		});
	}

	@Override
	public AView getView() {
		return v;
	}

	@Override
	public void onLoad() {}

}
