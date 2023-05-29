package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.unipv.sfw.exceptions.AccountNotFoundException;
import it.unipv.sfw.exceptions.WrongPasswordException;
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
		
		v.getPasswordField().setFocusTraversalKeysEnabled(false);
		v.getPasswordField().addKeyListener(new KeyListener() {		
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					accedi();
			}
			
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
		});
		
		v.getAccediButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accedi();
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
	
	
	private void accedi() {
		LoginView v = (LoginView)view;
		
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
		ControllerManager.getInstance().loadController(6);
		
		
	}
	
	@Override
	public void onLoad(Dimension dim) {
		view.onWindowResized(dim);
		((LoginView)view).onLoad();
	}
}
