package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.util.HashMap;

import it.unipv.sfw.dao.DAOFactory;
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
		
		HashMap<Merchandising, Integer> acquisti = DAOFactory.createIAcquistiStoreDAO()
				.selectAllWithPrice();
		
		AdminStoreView v = new AdminStoreView(s.getMerch(), acquisti, dim);
		
		view = v;
	}
	
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
