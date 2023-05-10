package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.exceptions.AccountNotFoundException;
import it.unipv.sfw.exceptions.WrongPasswordException;
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
	
	@Override
	public void initialize(Dimension dim) {
		LoginView v = new LoginView(dim);
		
		v.getAccediButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Try to login into session
				try {
					Sessione.getIstance().login(
							v.getUsernameField().getText(),
							v.getPasswordField().getPassword()
					);
				} catch (AccountNotFoundException err) {
					v.upError();
					return;
				} catch (WrongPasswordException err) {
					v.upError();
					return;
				}
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
	
	@Override
	public void onLoad(Dimension dim) {
		view.onWindowResized(dim);
		((LoginView)view).onLoad();
	}
}
