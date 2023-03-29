package it.unipv.sfw.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.LoginView;



/**
 * Controller che si occupa della LoginView.
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.LoginView
 */
public class LoginController extends AController {
	
	public LoginController() {
		LoginView v = new LoginView();
		
		v.getAccediButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Login into session
				Cliente u = new Cliente(
						"",
						"",
						v.getUsernameField().getText(),
						v.getPasswordField().getPassword().toString());
				Sessione.getIstance().setCurrentUtente(u);
				// Load new page
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		v.getRegistratiButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(1);
			}
		});
		
		view = v;
	}
}
