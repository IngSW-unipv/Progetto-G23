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

/**
 * Controller che si occupa della MuseoView.
 * 
 * @author Federico Romano
 * @see AController
 * @see it.unipv.sfw.view.MuseoView
 */
public class MuseoController extends AController {

	String storia = new String("LIl Football Club Internazionale Milano, "
			+ "meglio conosciuto come Internazionale o più semplicemente come Inter, è una società calcistica "
			+ "italiana con sede nella città di Milano.\r\n"
			+ "\r\n"
			+ "Fondato il 9 marzo 1908 da un gruppo di soci dissidenti del Milan,"
			+ " il club ha sempre militato nella massima serie del campionato nazionale a p"
			+ "artire dalla propria prima partita ufficiale, nel 1909, ed è l'unico ad aver "
			+ "partecipato a tutte le edizioni della Serie A, istituita nella stagione 1929-30. "
			+ "Fin dalla fondazione, indossa una divisa a strisce verticali nerazzurre, a parte "
			+ "una breve parentesi nel 1928 quando adottò una maglia bianca rossocrociata.\r\n"
			+ "\r\n"
			+ "Nel suo palmarès annovera 35 titoli nazionali – 19 scudetti, 9 Coppe Italia e "
			+ "7 Supercoppe italiane – che ne fanno il secondo club più titolato alle spalle "
			+ "della Juventus (59). A livello internazionale vanta invece 3 Coppe dei Campioni/Champions League, "
			+ "3 Coppe UEFA, 2 Coppe Intercontinentali e una Coppa del mondo per club FIFA, per un totale di 9 trofei "
			+ "ufficiali che pongono l'Inter dietro il Milan (18) e la Juventus (11) nella classifica dei club italiani"
			+ " per numero di vittorie in competizioni internazionali. Nel 1965 è diventata la prima squadra europea a "
			+ "vincere il campionato, la Coppa dei Campioni e la Coppa Intercontinentale nello stesso anno, detenendo "
			+ "quindi contemporaneamente i titoli di campione nazionale, continentale e mondiale. Il traguardo è stato "
			+ "bissato nel 2010, quando è diventata anche la prima e unica squadra italiana ad essersi aggiudicata le tre "
			+ "competizioni principali disputate nel corso della stagione: la Champions League, il campionato e la Coppa Italia;"
			+ " coi successivi trionfi in Supercoppa italiana e Coppa del mondo per club FIFA è diventata anche la prima e, finora,"
			+ " unica squadra del Paese a vincere cinque trofei nell'arco di un anno solare.\r\n"
			+ "\r\n"
			+ "Alcuni dei suoi calciatori sono stati premiati durante la militanza nel club con i massimi riconoscimenti "
			+ "individuali, come il Pallone d'oro e il FIFA World Player; inoltre, il club ha fornito un contributo rilevante"
			+ " ai successi della nazionale italiana. La squadra può contare su un sostegno numeroso sia a livello nazionale che "
			+ "internazionale. Nel 1998 e nel 2010 l'Inter fu nominata Squadra mondiale dell'anno dall'IFFHS; nel 2009 si "
			+ "piazzò al sesto posto nella lista secolare sui migliori club europei redatta dalla stessa federazione di storia e "
			+ "statistica, e nel 2011 al quinto posto (prima italiana) nella classifica europea delle migliori squadre del "
			+ "decennio 2001-2010.");
	
	@Override
	public void initialize(Dimension dim) {
		
		Museo museum = new Museo(storia, 14, 30, 18, 30);
		
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
