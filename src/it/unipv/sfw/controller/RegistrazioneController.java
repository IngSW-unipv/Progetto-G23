package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import it.unipv.sfw.exceptions.AccountAlreadyExistsException;
import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.RegistrazioneView;

/**
 * Controller che si occupa della RegistrazioneView.
 *
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.RegistrazioneView
 */
public class RegistrazioneController extends AController {

	@Override
	public Type getType() {
		return Type.REGISTRAZIONE;
	}

	@Override
	public void initialize(Dimension dim) {
		RegistrazioneView v = new RegistrazioneView(dim);

		v.getPassword().setFocusTraversalKeysEnabled(false);
		v.getPassword().addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					registrati();
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});

		v.getRegistratiBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registrati();
			}
		});

		v.getToLoginBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.LOGIN);
			}
		});

		view = v;
	}

	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

	private void registrati() {
		RegistrazioneView v = (RegistrazioneView) view;

		Calendar cal = null;
		LocalDate inputDate = v.getData();
		if (inputDate != null) {
			Date date = Date.from(inputDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			cal = Calendar.getInstance();
			cal.setTime(date);
		}

		// Login into session
		Cliente u = new Cliente(v.getNome().getText(), v.getCognome().getText(), v.getEmail().getText().toLowerCase(),
				new String(v.getPassword().getPassword()), cal);
		try {
			Sessione.getIstance().register(u);
		} catch (EmptyFieldException err) {
			v.onEmptyField();
			return;
		} catch (WrongEmailFormatException err) {
			v.onWrongEmailFormat();
			return;
		} catch (AccountAlreadyExistsException err) {
			v.onAccountAlreadyExisting(err.getAccountEmail());
			return;
		}

		ControllerManager.getInstance().loadController(Type.PARTITE);
	}
}
