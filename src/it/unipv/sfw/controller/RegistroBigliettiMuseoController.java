package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.sfw.controller.AController.Type;
import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.biglietti.Biglietto;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.RegistroBigliettiMuseoView;

public class RegistroBigliettiMuseoController extends AController {

	@Override
	public void initialize(Dimension dim) {
		
		ArrayList<Biglietto> biglietti = DAOFactory.createIBigliettoMuseoDAO().selectAll();
		
		RegistroBigliettiMuseoView rview = new RegistroBigliettiMuseoView(biglietti, dim);
		
		rview.getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(AController.Type.AMUSEO);
			}
			
		});
	
		view = rview;
	}
	
	
	
	@Override
	public void onLoad(Dimension dim) {
		view.onWindowResized(dim);
		view.onLoad();
		Sessione.getIstance().setCurrentPagamento(2);
	}
	
	@Override
	public Type getType() {
		return Type.BREGISTRO;
	}


}
