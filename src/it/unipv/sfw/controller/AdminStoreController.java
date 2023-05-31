package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.store.AcquistoStore;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.store.StoreOnline;
import it.unipv.sfw.view.AdminStoreView;


/**
 * Controller che si occupa della AdminStoreView.
 * 
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.AdminStoreView
 */
public class AdminStoreController extends AController {
	
	private StoreOnline s;

	@Override
	public void initialize(Dimension dim) {
		s = new StoreOnline(null);
		
		ArrayList<AcquistoStore> acquisti = DAOFactory.createIAcquistiStoreDAO()
				.selectAllWithPrice();
		
		AdminStoreView v = new AdminStoreView(s.getMerch(), acquisti, dim);
		
		v.getAggiungiItemButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(17);
			}
		});
		
		view = v;
	}
	
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
