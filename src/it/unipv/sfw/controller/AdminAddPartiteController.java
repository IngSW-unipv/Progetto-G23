package it.unipv.sfw.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.mail.Session;

import it.unipv.sfw.controller.AController.Type;
import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AdminAddOggettoView;
import it.unipv.sfw.view.AdminAddPartiteView;
import it.unipv.sfw.view.buttons.SquadraButton;
import it.unipv.sfw.view.buttons.UtenteButton;

public class AdminAddPartiteController extends AController{
	
	

	@Override
	public Type getType() {
		return AController.Type.AADDPARTITA;
	}

	@Override
	public void initialize(Dimension dim) {
		AdminAddPartiteView v=new AdminAddPartiteView(dim);
		
		
		
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				v.setUso();
				if(((SquadraButton)e.getSource()).getUso()==false) {
					((SquadraButton)e.getSource()).setUso(true);
					v.setSquadra();
				}
			}
		};
		Collection<SquadraButton> btns = v.getButtons();
		for (SquadraButton b : btns) {
			b.addActionListener(a);
		}
		
		
		v.getAggiungi().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aggiungipartita();
			}
		});
		
		v.getHome().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.APARTITE);
			}
		});
		
		view =v;
	}
	
	
	public void aggiungipartita() {
		AdminAddPartiteView v=(AdminAddPartiteView)view;
		
		LocalDate inputDate = v.getData();
		Squadre ospiti= Squadre.valueOf(Squadre.class,v.getSquadraScelta());
		String ora=v.getOra();
		String data_ora=""+inputDate.toString()+" "+ora+":00";
		Calendar cal;
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ITALY);
		try {
			Date date = (Date) sdf.parse(data_ora);
			cal=Calendar.getInstance();
			cal.setTime(date);
			try {
				DAOFactory.createIPartitaDAO().insertPartita(new Partita(cal,ospiti));
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println("Partita già programmata per questa data!");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}
	
	

}
