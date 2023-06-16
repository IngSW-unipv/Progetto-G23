package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.exceptions.OldPasswordReusedException;
import it.unipv.sfw.exceptions.PasswordPrecedenteErrataException;
import it.unipv.sfw.model.abbonamento.TipoAbb;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.view.ProfiloPersonaleView;
import it.unipv.sfw.view.buttons.UtenteButton;


/**
 * Controller che si occupa della ProfiloPersonaleView.
 * @author Jacopo Piccoli
 * @see AController
 * @see it.unipv.sfw.view.ProfiloPersonaleView
 */
public class ProfiloPersonaleController extends AController{
	
	private Utente u; 
	private int biglietti;

	@Override
	public void initialize(Dimension dim) {
		try {
			
			u = Sessione.getIstance().getCurrentUtente();
		} catch (Exception e) {
		      System.out.println("Errore");
	    }
		biglietti=DAOFactory.createIPostoDAO().selectCount(u.getEmail());
		ProfiloPersonaleView v = new ProfiloPersonaleView(dim,u,biglietti);
		
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(Type.PAGAMENTO);
				switch(((UtenteButton) e.getSource()).getCode()) {
				case 0:
					Sessione.getIstance().setAbbToUpdate(TipoAbb.LIV1);
					break;
				case 1:
					Sessione.getIstance().setAbbToUpdate(TipoAbb.LIV2);
					break;
				default:
					Sessione.getIstance().setAbbToUpdate(TipoAbb.LIV3);
					break;
				}
			}
		};
		
		Collection<UtenteButton> btns = v.getButtons();
		if(u.getType()==it.unipv.sfw.model.utente.Utente.Type.CLIENTE) {
			for (UtenteButton b : btns){
				b.addActionListener(a);
			}
		}
			
		
		v.getHome().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(u.getType()==it.unipv.sfw.model.utente.Utente.Type.ADMIN) {
					ControllerManager.getInstance().loadController(Type.APARTITE);
					
				}else {
					ControllerManager.getInstance().loadController(Type.PARTITE);
				}
			}
		});
		
		
		v.getInfo().addMouseListener(new MouseListener() {		
			@Override
			public void mouseReleased(MouseEvent e) {}		
			@Override
			public void mousePressed(MouseEvent e) {}	
			@Override
			public void mouseExited(MouseEvent e) {
				v.setInfoAbb(false);	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				v.setInfoAbb(true);	
			}		
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		v.getCambiaPassword().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {			
				if (v.getVecchiaPassword().getPassword().length == 0 && 
					v.getNuovaPassword().getPassword().length == 0 &&
					v.getConfermaNuovaPassword().getPassword().length == 0) 
				{
					v.onEmptyField();
					return ;
				}
				
				if (!(new String(v.getNuovaPassword().getPassword()) 
						.equals(new String(v.getConfermaNuovaPassword().getPassword())))){
					v.onConfirmPassword();
					return;
				}
						
				try {
					Sessione.getIstance().commutaPassword(
								u,
								new String(v.getVecchiaPassword().getPassword()),
								new String(v.getNuovaPassword().getPassword())
							);
					ControllerManager.getInstance().loadController(Type.PARTITE);
					
				} catch(PasswordPrecedenteErrataException err) {
					v.ErroreVecchiaPassword();			
				} catch(OldPasswordReusedException err) {
					v.oldPasswordReused();
				}
			}
		});
		
		view=v;
		
	}
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
		Sessione.getIstance().setCurrentPagamento(4);
	}

	@Override
	public Type getType() {
		return Type.PROFILO;
	}

}
