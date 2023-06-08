package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.mail.MessagingException;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.exceptions.EmptyNameException;
import it.unipv.sfw.exceptions.WrongCvvException;
import it.unipv.sfw.exceptions.WrongNumberException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.model.biglietti.Biglietto;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.pagamento.Carta;
import it.unipv.sfw.pagamento.Email;
import it.unipv.sfw.view.PagamentoView;

public class PagamentoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		PagamentoView v = new PagamentoView(dim);
		
		v.getBackBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (Sessione.getIstance().getCurrentPagamento()) {
				case 1: ControllerManager.getInstance().loadController(Type.CARRELLO); break;
				case 2: ControllerManager.getInstance().loadController(Type.BIGLIETTO_MUSEO); break;
				case 3: ControllerManager.getInstance().loadController(Type.PARTITE); break;
				default: ControllerManager.getInstance().loadController(Type.PROFILO);
				}
			}
		});
		
		v.getOkBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Email a = new Email();
					String messaggio = "";
					
					v.checkEnteredName();
					v.checkEnteredNumber();
					v.checkEnteredCvv();
					
					if(Sessione.getIstance().getCurrentPagamento() == 1) messaggio = a.messaggioStore();
					else if (Sessione.getIstance().getCurrentPagamento() == 2) messaggio = a.messaggioMuseo();
					else if (Sessione.getIstance().getCurrentPagamento() == 3) messaggio = a.messaggioPartita();
					else messaggio = a.messaggioAbbonamento();
					try {
						if (Sessione.getIstance().getCurrentPagamento() == 2) a.sendEmail(messaggio, Sessione.getIstance().getCurrentBiglietto().getEmail());
						else a.sendEmail(messaggio);
					} catch (MessagingException e1) {
						e1.printStackTrace();
					}
					
					if (v.getsalvaCB().isSelected()) DAOFactory.createICartaPagamentoDAO().insertCarta(new Carta(v.getNome(), v.getCognome(), v.getNCarta(), v.getMese(), v.getAnno(), 0));
					ControllerManager.getInstance().loadController(Type.PARTITE);
					Sessione.getIstance().resetScelte();
				}catch (EmptyNameException e2) {
					
					return;
				}catch (WrongNumberException e3) {
					
					return;
				}catch(WrongCvvException e4) {
					
					return;
				}
			}
		});
		view = v;
	}
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

	@Override
	public Type getType() {
		return Type.PAGAMENTO;
	}

}
