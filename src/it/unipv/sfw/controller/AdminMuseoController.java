package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AdminMuseoView;
import it.unipv.sfw.view.buttons.PezzoMuseoButton;

public class AdminMuseoController extends AController{

	String storia = new String("L'inter è una squadra di calcio rappresentante la città di Milano.");
	
	@Override
	public void initialize(Dimension dim) {
		
		Museo museum = new Museo(storia, 14, 30, 18, 30);
		
		ArrayList<Riconoscimento> ric_arraylist = DAOFactory.createIRiconoscimentoDAO().selectAllOrderByData();
		
		museum.setRiconsocimenti(ric_arraylist);
		
		AdminMuseoView mview = new AdminMuseoView(museum, dim);
		
		mview.getPartiteButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.APARTITE);
			}
		});
		
		mview.getStoreButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.ASTORE);
			}
		});
		
		mview.getInserisciButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.AADDOGGETTO);
			}
			
		});
		
		for(PezzoMuseoButton button : mview.getRimuoviButtons()) {
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//delete
					if (DAOFactory.createIRiconoscimentoDAO().deleteById(button.getId())) {
						mview.removeMuseoItemPanel(button.getId());
					}
					else {
						System.out.println("QUALCOSA E' ANDATO STORTO CON DELETE");
					}
				}
			});
		}
		
		mview.getProfiloPersonaleButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.PROFILO);
			}
		});
		
		mview.getExit().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().resetScelte();
				ControllerManager.getInstance().loadController(Type.LOGIN);
			}
		});
		
		view = mview;
		
	}

	@Override
	public Type getType() {
		return Type.AMUSEO;
	}

}
