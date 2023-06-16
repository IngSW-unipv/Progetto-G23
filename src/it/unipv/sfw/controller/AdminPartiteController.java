package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.abbonamento.Abbonamento;
import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.AdminPartiteView;
import it.unipv.sfw.view.elements.InfoMenu;

/**
 * Controller che si occupa della AdminPartiteView.
 *
 * @author Gabriele Invernizzi
 * @see AController
 * @see it.unipv.sfw.view.AdminPartiteController
 */
public class AdminPartiteController extends AController {

	private Partita[] p;
	private int postioccupati;
	private int clientipresenti, liv1, liv2, liv3, abbonatipresenti;
	private double ricavi;

	@Override
	public Type getType() {
		return Type.APARTITE;
	}

	@Override
	public void initialize(Dimension dim) {
		ArrayList<Partita> p_arrlist = DAOFactory.createIPartitaDAO().selectAllOrdered();

		p = new Partita[p_arrlist.size()];
		AdminPartiteView v = new AdminPartiteView(p_arrlist.toArray(p), dim);

		view = v;

		v.getProfiloPersonaleButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ControllerManager.getInstance().loadController(8);
			}
		});

		v.getProfiloPersonaleButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.PROFILO);
			}
		});

		v.getExit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().resetScelte();
				ControllerManager.getInstance().loadController(Type.LOGIN);
			}
		});

		v.getMuseoButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.AMUSEO);
			}
		});

		v.getStoreButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.ASTORE);
			}
		});

		v.getAddPartitaButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.AADDPARTITA);
			}
		});

		MouseListener a = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				int code = ((InfoMenu) e.getComponent()).getCode();
				Date data = p[code].getCalendarDate().getTime();
				Calendar cal = Calendar.getInstance();
				cal.setTime(data);
				postioccupati = DAOFactory.createIPostoDAO().selectCount(cal);
				clientipresenti = DAOFactory.createIPostoDAO().clientipresenti(cal, "LIV0");
				liv1 = DAOFactory.createIPostoDAO().clientipresenti(cal, "LIV1");
				liv2 = DAOFactory.createIPostoDAO().clientipresenti(cal, "LIV2");
				liv3 = DAOFactory.createIPostoDAO().clientipresenti(cal, "LIV3");
				abbonatipresenti = liv1 + liv2 + liv3;
				Abbonamento l1 = new Abbonamento(TipoAbb.LIV1);
				Abbonamento l2 = new Abbonamento(TipoAbb.LIV2);
				Abbonamento l3 = new Abbonamento(TipoAbb.LIV3);

				ricavi = clientipresenti * (Partita.PREZZO) + liv1 * (Partita.PREZZO * l1.getSconto())
						+ liv2 * (Partita.PREZZO * l2.getSconto()) + liv3 * (Partita.PREZZO * l3.getSconto());

				v.OpenInfoPartita(true, code, postioccupati, clientipresenti, abbonatipresenti, ricavi);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				int code = ((InfoMenu) e.getComponent()).getCode();
				v.CloseInfoPartita(false, code);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		};
		Collection<InfoMenu> info = v.getInfo();
		for (InfoMenu i : info) {
			i.addMouseListener(a);
		}
	}

	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
