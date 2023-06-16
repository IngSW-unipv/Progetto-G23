package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.partita.Partita.Squadre;
import it.unipv.sfw.view.AdminAddPartiteView;
import it.unipv.sfw.view.buttons.SquadraButton;

/**
 * Classe che crea la view della sezione partite nella pagina principale
 * dell'amministratore.
 *
 * @author Jacopo Piccoli, Gabriele Invernizzi
 * @see it.unipv.sfw.view.buttons.UtenteButton
 */
public class AdminAddPartiteController extends AController {

	public void aggiungipartita() {
		AdminAddPartiteView v = (AdminAddPartiteView) view;

		LocalDate inputDate = v.getData();
		try {
			Squadre ospiti = Enum.valueOf(Squadre.class, v.getSquadraScelta());

			String ora = v.getOra();
			String data_ora = "" + inputDate.toString() + " " + ora + ":00";
			Calendar cal;

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ITALY);
			try {
				Date date = sdf.parse(data_ora);
				cal = Calendar.getInstance();
				cal.setTime(date);
				try {
					DAOFactory.createIPartitaDAO().insertPartita(new Partita(cal, ospiti));
					v.success("La partita è stata aggiunta");
				} catch (SQLIntegrityConstraintViolationException e) {
					v.onAddError("Partita già programmata per questa data!");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			v.onSquadError("Non è stata selezionata nessuna squadra");
		}
	}

	@Override
	public Type getType() {
		return AController.Type.AADDPARTITA;
	}

	@Override
	public void initialize(Dimension dim) {
		AdminAddPartiteView v = new AdminAddPartiteView(dim);

		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				v.setUso();
				if (!((SquadraButton) e.getSource()).getUso()) {
					((SquadraButton) e.getSource()).setUso(true);
					v.setSquadra();
				}
			}
		};
		Collection<SquadraButton> btns = v.getButtons();
		for (SquadraButton b : btns) {
			b.addActionListener(a);
		}

		v.getAggiungiButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				aggiungipartita();
			}
		});

		v.getHome().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.APARTITE);
			}
		});

		view = v;
	}

	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
