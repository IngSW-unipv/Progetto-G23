package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.EventListenerList;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.exceptions.EmptyNameException;
import it.unipv.sfw.exceptions.WrongCvvException;
import it.unipv.sfw.exceptions.WrongNumberException;
import it.unipv.sfw.exceptions.WrongEmailFormatException;
import it.unipv.sfw.model.biglietti.Biglietto;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.partita.Posto;
import it.unipv.sfw.model.store.AcquistoStore;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.pagamento.Carta;
import it.unipv.sfw.pagamento.Email;
import it.unipv.sfw.view.PagamentoView;
import it.unipv.sfw.view.elements.CartItemPanel;

public class PagamentoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		PagamentoView v = new PagamentoView(dim);
		
		
		v.getBackBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (Sessione.getIstance().getCurrentPagamento()) {
				case 1: ControllerManager.getInstance().loadController(Type.CARRELLO); break;
				case 2: 
					DAOFactory.createIBigliettoMuseoDAO().removeLast();
					ControllerManager.getInstance().loadController(Type.BIGLIETTO_MUSEO);
					break;
				case 3: ControllerManager.getInstance().loadController(Type.PARTITE); break;
				default: ControllerManager.getInstance().loadController(Type.PROFILO);
				}
			}
		});
		
		if(v.riempiCarte() == true) {
			
			v.getCarte().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					v.setCarta();
				}
			});
		}
		
		v.getOkBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 3;
				v.reLoad();
				try {
					Email a = new Email();
					String messaggio = "";
					
					v.checkEnteredName();
					v.checkEnteredNumber();
					v.checkEnteredCvv();
					
					switch(Sessione.getIstance().getCurrentPagamento()) {
					case 1: 
						messaggio = a.messaggioStore();
						for(Map.Entry<Merchandising, Integer> entry: Sessione.getIstance().getCarrello().entrySet()) {
							AcquistoStore acquisto = new AcquistoStore(entry.getKey(), Sessione.getIstance().getCurrentUtente(), entry.getValue()) ;
							DAOFactory.createIAcquistiStoreDAO().insertAcquisto(acquisto);
							int quantita = (DAOFactory.createIStoreItemDAO().selectById(entry.getKey()).getValue() - entry.getValue());
							DAOFactory.createIStoreItemDAO().updateQuantitaItem(entry.getKey(), quantita);
						}
						break;
					case 2:
						messaggio = a.messaggioMuseo();
						break;
					case 3:
						messaggio = a.messaggioPartita();
						Posto posto = new Posto(Sessione.getIstance().getSettore(), Sessione.getIstance().getAnello(), Sessione.getIstance().getBlocco(), Sessione.getIstance().getPosto(), Sessione.getIstance().getCurrentPartita().getCalendarDate());
						DAOFactory.createIPostoDAO().insertPosto(posto, Sessione.getIstance().getCurrentUtente());
						DAOFactory.createIPartitaDAO().updatePartita(Sessione.getIstance().getCurrentPartita());
						break;
					default:
						messaggio = a.messaggioAbbonamento();
						Utente utente = Sessione.getIstance().getCurrentUtente();
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						Date date = sdf.parse(utente.getDataNascita());
						Calendar data_nascita = Calendar.getInstance();
						data_nascita.setTime(date);
						Cliente cliente = new Cliente(utente.getNome(), utente.getCognome(), utente.getEmail(), utente.getPassword(), data_nascita);
						cliente.abbona(Sessione.getIstance().getTipoAbb());
						DAOFactory.createIAbbonamentoDAO().updateAbbonamento(cliente, Sessione.getIstance().getAbbToUpdate());
						Sessione.getIstance().setCurrentAbb(Sessione.getIstance().getAbbToUpdate());
						break;
					}
					
					if (v.getsalvaCB().isSelected()) { 
						try{
							DAOFactory.createICartaPagamentoDAO().insertCarta(new Carta(v.getNome(), v.getCognome(), v.getNCarta(), v.getMese(), v.getAnno(), 0), Sessione.getIstance().getCurrentUtente());
						}catch (SQLIntegrityConstraintViolationException err) {
							v.upNumberErr();
							return;
						}
					}
					
					try {
						if (Sessione.getIstance().getCurrentPagamento() == 2) a.sendEmail(messaggio, Sessione.getIstance().getCurrentBiglietto().getEmail());
						else a.sendEmail(messaggio);
					} catch (MessagingException err) {
						System.out.println("Email non valida");
					}
					
					ControllerManager.getInstance().loadController(Type.PARTITE);
					Sessione.getIstance().resetScelte();
				}catch (EmptyNameException err) {
					n = v.getTipoErr();
					if (n == 0) v.upNameErr();
					else if (n == 1) v.upSurnameErr();
					else if (n == 2){
						v.upNameErr();
						v.upSurnameErr();
					}
					return;
				}catch (WrongNumberException err) {
					v.upNumberErr();
					return;
				}catch(WrongCvvException err) {
					v.upCvvErr();
					return;
				} catch (ParseException err) {
					err.printStackTrace();
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
