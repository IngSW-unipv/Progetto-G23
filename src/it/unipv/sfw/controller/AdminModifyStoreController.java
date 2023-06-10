package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.exceptions.MerchInvalidFieldFormatException;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.utilities.Pair;
import it.unipv.sfw.view.AdminModifyStoreView;

public class AdminModifyStoreController extends AController {

	@Override
	public void initialize(Dimension dim) {
		AdminModifyStoreView v;
		Pair<Merchandising, Integer> merchToBeUpdated = Sessione.getIstance().getMerchAdmin();
		
		v = new AdminModifyStoreView(merchToBeUpdated);
		
		v.getBackBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().setMerchAdmin(null);
				ControllerManager.getInstance().loadController(AController.Type.ASTORE);
			}
		});
		
		v.getDeleteBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				DAOFactory.createIStoreItemDAO().deleteItem(merchToBeUpdated.getKey());
				Sessione.getIstance().setMerchAdmin(null);
				ControllerManager.getInstance().loadController(AController.Type.ASTORE);
			}
		});
		
		
		v.getConfirmBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				double prezzo;
				int quantita;
				
				String nome = v.getNome().getText();
				String prezzoStr = v.getPrezzo().getText();
				String quantitaStr = v.getQuantita().getText();
				String descr = v.getDescr().getText();
				
				try {
					if (nome.isEmpty() || descr.isEmpty())
						throw new MerchInvalidFieldFormatException();
					prezzo = Double.parseDouble(prezzoStr);
					quantita = Integer.parseInt(quantitaStr);
					if (prezzo < 0.0 || quantita < 0.0)
						throw new MerchInvalidFieldFormatException();
				} catch (MerchInvalidFieldFormatException | NumberFormatException err) {
					v.onInvalidFormat();
					return;
				}

				if (merchToBeUpdated == null) {
					Merchandising m = new Merchandising(nome, prezzo, -1, descr);
					DAOFactory.createIStoreItemDAO().insertStoreItem(m, quantita);
				} else {
					merchToBeUpdated.getKey().setNomeMerch(nome);
					merchToBeUpdated.getKey().setDescrizione(descr);
					merchToBeUpdated.getKey().setPrezzo(prezzo);
					merchToBeUpdated.setValue(quantita);
					
					DAOFactory.createIStoreItemDAO().updateItem(merchToBeUpdated);
					Sessione.getIstance().setMerchAdmin(null);
				}
				
				ControllerManager.getInstance().loadController(AController.Type.ASTORE);
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
		return AController.Type.AMODIFYSTORE;
	}
}
