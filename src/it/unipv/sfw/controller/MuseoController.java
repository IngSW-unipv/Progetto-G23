package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.sfw.controller.AController.Type;
import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.dao.mysql.RiconoscimentoDAO;
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
		
		Museo museum = new Museo(storia, 14, 30, 18, 30);
		
		ArrayList<Riconoscimento> ric_arraylist = DAOFactory.createIRiconoscimentoDAO().selectAllOrderByData();
		ArrayList<Cimelio> cim_arraylist = DAOFactory.createICimelioDAO().selectAllOrderByData();
		
		museum.setRiconsocimenti(ric_arraylist);
		museum.setCimeli(cim_arraylist);
		
		MuseoView mview = new MuseoView(museum, dim);
		
		mview.getPartiteButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.PARTITE);
			}
		});
		
		mview.getStoreButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.STORE);
			}
		});
		
		mview.getAcquistaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.BIGLIETTO_MUSEO);
			}
			
		});
		
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
		return Type.MUSEO;
	}
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
