package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.view.PartiteAdminView;
import it.unipv.sfw.view.buttons.UtenteButton;
import it.unipv.sfw.view.elements.InfoMenu;

public class PartiteAdminController extends AController{
	
	private Partita[] p;
	
	@Override
	public void initialize(Dimension dim) {
		ArrayList<Partita> p_arrlist = DAOFactory.createIPartitaDAO().selectAll();
		
		p = new Partita[p_arrlist.size()];
		PartiteAdminView v = new PartiteAdminView(p_arrlist.toArray(p), dim);
		
		view=v;
		
		v.getProfiloPersonaleButton().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				//ControllerManager.getInstance().loadController(8);
			}
		});
		
		v.getExit().addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Sessione.getIstance().resetScelte();
				ControllerManager.getInstance().loadController(0);
			}
		});
		
		MouseListener a=new MouseListener() {
					
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
				int code = ((InfoMenu)e.getComponent()).getCode();
				v.setInfoPartita(false,code);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				int code = ((InfoMenu)e.getComponent()).getCode();
				v.setInfoPartita(true,code);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
	};
		Collection<InfoMenu> info=v.getInfo();
		for(InfoMenu i:info) {
			i.addMouseListener(a);
		}
}
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

	
}
