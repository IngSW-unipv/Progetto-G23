package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.CarrelloView;
import it.unipv.sfw.view.buttons.StoreButton;

/**
 * Controller che si occupa della CarrelloView.
 *
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.CarrelloView
 */
public class CarrelloController extends AController {

	private HashMap<Merchandising, Integer> carrello;

	@Override
	public Type getType() {
		return Type.CARRELLO;
	}

	@Override
	public void initialize(Dimension dim) {
		Sessione s = Sessione.getIstance();
		
		carrello = s.getCarrello();

		CarrelloView v = new CarrelloView(carrello, (Cliente) s.getCurrentUtente(), dim);

		v.getStoreBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.STORE);
			}
		});

		v.getAcquistaBtn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.PAGAMENTO);
			}
		});

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Merchandising m = ((StoreButton) e.getSource()).getMerch();

				((CarrelloView) view).onItemRemove(m);

				carrello.remove(m);
				Sessione.getIstance().setCarrello(carrello);
			}
		};

		for (StoreButton b : v.getRemBtns()) {
			b.addActionListener(a);
		}

		view = v;
	}

	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
		Sessione.getIstance().setCurrentPagamento(1);
	}

}
