package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.sfw.dao.RiconoscimentoDAO;
import it.unipv.sfw.model.museo.Cimelio;
import it.unipv.sfw.model.museo.Museo;
import it.unipv.sfw.model.museo.Riconoscimento;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.MuseoView;

public class MuseoController extends AController {

	String storia = new String("L'inter è una squadra di calcio rappresentante la città di Milano.");
	Riconoscimento[] ric;
	Cimelio[] cim;
	
	@Override
	public void initialize(Dimension dim) {
		
		Museo museum = new Museo(storia, 15, 30, 18, 30);
		
		ArrayList<Riconoscimento> ric_arraylist = new RiconoscimentoDAO().selectAllOrderByData();
		
		museum.setRiconsocimenti(ric_arraylist);
		
		MuseoView mview = new MuseoView(museum, dim);
		
		mview.getPartiteButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		mview.getStoreButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(7);
			}
		});
		
		mview.getAcquistaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(11);
			}
			
		});
		
		mview.getProfiloPersonaleButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(8);
			}
		});
		
		mview.getExit().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().resetScelte();
				ControllerManager.getInstance().loadController(0);
			}
		});
		
		view = mview;
		
	}

}
