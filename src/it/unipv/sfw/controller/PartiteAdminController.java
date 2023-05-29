package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.util.ArrayList;

import it.unipv.sfw.dao.DAOFactory;
import it.unipv.sfw.model.partita.Partita;
import it.unipv.sfw.view.PartiteAdminView;

public class PartiteAdminController extends AController{
	
	private Partita[] p;
	
	@Override
	public void initialize(Dimension dim) {
		ArrayList<Partita> p_arrlist = DAOFactory.createIPartitaDAO().selectAll();
		
		p = new Partita[p_arrlist.size()];
		PartiteAdminView v = new PartiteAdminView(p_arrlist.toArray(p), dim);
		
		view=v;
}
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

	
}
