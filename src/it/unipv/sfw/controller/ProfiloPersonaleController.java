package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import it.unipv.sfw.exceptions.EmptyFieldException;
import it.unipv.sfw.exceptions.OldPasswordReused;
import it.unipv.sfw.exceptions.PasswordPrecedenteErrata;
import it.unipv.sfw.model.utente.Cliente;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.model.utente.Utente;
import it.unipv.sfw.view.ProfiloPersonaleView;

public class ProfiloPersonaleController extends AController{
	
	private Cliente c; 

	@Override
	public void initialize(Dimension dim) {
		try {
			c=(Cliente)Sessione.getIstance().getCurrentUtente();
		}catch (Exception e) {
		      System.out.println("Errore");
	    }
		
		ProfiloPersonaleView v = new ProfiloPersonaleView(dim,c);
		
		v.getHome().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		v.getInfo().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				v.setInfoAbb(false);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				v.setInfoAbb(true);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		v.getCambiaPassword().addActionListener(new ActionListener() {	
			
					
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(v.getVecchiaPassword().getPassword().length==0&&v.getNuovaPassword().getPassword().length==0&&v.getConfermaNuovaPassword().getPassword().length==0) {
					v.onEmptyField();
					return 
;				}
				
				if(!(new String(v.getNuovaPassword().getPassword()) 
						.equals(new String(v.getConfermaNuovaPassword().getPassword())))){
					v.onConfirmPassword();
					return;
				}
				
				
				try {
					Sessione.getIstance().commutaPassword(c,new String(v.getVecchiaPassword().getPassword()),new String(v.getNuovaPassword().getPassword()));
				} catch(PasswordPrecedenteErrata err) {
					v.ErroreVecchiaPassword();
					return;
					
				} catch(OldPasswordReused err) {
					v.oldPasswordReused();
					return;
					
				}
					
				
				/*String pass=Sessione.getIstance().CommutaPassword(v.getVecchiaPassword().getPassword());
				if(v.getVecchiaPassword().getPassword().length!=0&&v.getNuovaPassword().getPassword().length!=0&&v.getConfermaNuovaPassword().getPassword().length!=0) {
					if(c.getPassword().equals(pass)){
						String p1=Sessione.getIstance().CommutaPassword(v.getNuovaPassword().getPassword());
						String p2=Sessione.getIstance().CommutaPassword(v.getConfermaNuovaPassword().getPassword());
						if(p1.equals(p2)) {
							pass=Sessione.getIstance().CommutaPassword(v.getNuovaPassword().getPassword());
							
							c.changePassword(pass);
						}else{v.onConfirmPassword();}
					}else{v.ErroreVecchiaPassword();}
				}else {v.onEmptyField();}			
				*/
			}
		});
		
		view=v;
		
	}

}
