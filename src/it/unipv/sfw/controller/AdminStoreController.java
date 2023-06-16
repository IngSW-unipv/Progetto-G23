package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.store.AcquistoStore;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.store.StoreOnline;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.utilities.Pair;
import it.unipv.sfw.view.AdminStoreView;
import it.unipv.sfw.view.buttons.StoreButton;

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
	public Type getType() {
		return Type.ASTORE;
	}

	@Override
	public void initialize(Dimension dim) {
		s = new StoreOnline(null);

		ArrayList<AcquistoStore> acquisti = DAOFactory.createIAcquistiStoreDAO().selectAllWithPrice();

		AdminStoreView v = new AdminStoreView(s.getMerch(), acquisti, dim);

		v.getPartiteBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.APARTITE);
			}
		});

		v.getMuseoBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.AMUSEO);
			}
		});

		v.getAggiungiItemButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.AMODIFYSTORE);
			}
		});

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StoreButton b = ((StoreButton) e.getSource());

				Sessione.getIstance()
						.setMerchAdmin(new Pair<>(b.getMerch(), b.getMerchQuantity()));
				ControllerManager.getInstance().loadController(Type.AMODIFYSTORE);
			}
		};

		for (StoreButton b : v.getModifyBtns())
			b.addActionListener(a);

		view = v;
	}

	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
