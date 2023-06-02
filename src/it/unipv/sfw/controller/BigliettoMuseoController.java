package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import it.unipv.sfw.controller.AController.Type;
import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.exceptions.AccountNotFoundException;
import it.unipv.sfw.exceptions.EmptyDateException;
import it.unipv.sfw.exceptions.EmptyTimeException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.exceptions.WrongPasswordException;
import it.unipv.sfw.model.biglietti.Biglietto;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.view.BigliettoMuseoView;
import it.unipv.sfw.view.LoginView;

public class BigliettoMuseoController extends AController {
	
	@Override
	public void initialize(Dimension dim) {
		
		Utente cliente = Sessione.getIstance().getCurrentUtente();
		
		BigliettoMuseoView bview = new BigliettoMuseoView(dim);
		
		
		bview.getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.MUSEO);
			}
			
		});
		
		bview.getTotalPeople().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bview.setPrice((int) bview.getTotalPeople().getSelectedItem() * bview.getHeadPrice());
			}
			
		});
		
		bview.getAcquistaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					Utente.checkEmail(bview.getEnteredEmail());
					bview.checkEnteredDate();
					bview.checkEnteredTime();
					
					Date date = Date.from(bview.getEnteredDateAndTime().atZone(ZoneId.systemDefault()).toInstant());
					Calendar calendarDate = Calendar.getInstance();
					calendarDate.setTime(date);
					calendarDate.set(Calendar.HOUR, bview.getEnteredTime().getHour());
					calendarDate.set(Calendar.MINUTE, bview.getEnteredTime().getMinute());
					
					DAOFactory.createIBigliettoMuseoDAO().insertBigliettiMuseo(
							new Biglietto(
								Sessione.getIstance().getCurrentUtente().getEmail(),
								bview.getPrice(),
								calendarDate,
								Time.valueOf(bview.getEnteredTime())),
							(int) bview.getTotalPeople().getSelectedItem(),
							bview.getEnteredEmail());
				}
				catch (WrongEmailFormatException err) {
					bview.upEmailError();
					return;
				}
				catch (EmptyDateException err) {
					bview.upDateError();
					return;
				}
				catch (EmptyTimeException err) {
					bview.upTimeError();
					return;
				}

				// Load new page
				ControllerManager.getInstance().loadController(Type.PAGAMENTO);
			}
		});
			
		view = bview;	
	}
	
	@Override
	public void onLoad(Dimension dim) {
		view.onWindowResized(dim);
		view.onLoad();
		Sessione.getIstance().setCurrentPagamento(2);
	}

	@Override
	public Type getType() {
		return Type.BIGLIETTO_MUSEO;
	}

}
