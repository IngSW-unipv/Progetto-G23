package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.unipv.sfw.exceptions.AccountNotFoundException;
import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.exceptions.WrongPasswordException;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.model.utente.Utente.Type;
import it.unipv.sfw.view.LoginView;

import it.unipv.sfw.model.utente.Admin;


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
				ControllerManager.getInstance().loadController(Type.REGISTRAZIONE);
			}
		});
		
		view = v;
	}
	
	
	private void accedi() {
		LoginView v = (LoginView)view;
		
		// Try to login into session
		
		try {
			Sessione.getIstance().login(
					v.getUsernameField().getText().toLowerCase(), 
					v.getPasswordField().getPassword()
			);
		} catch (WrongPasswordException | AccountNotFoundException err) {
			v.upError();
			return;
		}
		
		
		if (Sessione.getIstance().getCurrentUtente().getType() == Utente.Type.ADMIN) {
			ControllerManager.getInstance().loadController(Type.APARTITE);
		} else {
			ControllerManager.getInstance().loadController(Type.PARTITE);
		}
	}


	@Override
	public Type getType() {
		return Type.LOGIN;
	}
}
