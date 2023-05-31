package it.unipv.sfw.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.mail.MessagingException;
import javax.swing.JButton;

import it.unipv.sfw.model.utente.Sessione;
import it.unipv.sfw.pagamento.Email;
import it.unipv.sfw.view.PagamentoView;

public class PagamentoController extends AController{

	@Override
	public void initialize(Dimension dim) {
		
		PagamentoView v = new PagamentoView(dim);
		
		v.getBackBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Sessione.getIstance().getCurrentPagamento() == 1)ControllerManager.getInstance().loadController(9);
				else if (Sessione.getIstance().getCurrentPagamento() == 2) ControllerManager.getInstance().loadController(11);
				else if (Sessione.getIstance().getCurrentPagamento() == 3) ControllerManager.getInstance().loadController(6);
				else ControllerManager.getInstance().loadController(8);
			}
		});
		
		v.getOkBtn().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Email a = new Email();
				try {
					a.emailStore();
				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
				if(Sessione.getIstance().getCurrentPagamento() == 1) Sessione.getIstance().resetCarrello();
				ControllerManager.getInstance().loadController(6);
			}
		});
		
		view = v;
	}
	
	@Override
	public void onLoad(Dimension dim) {
		this.initialize(dim);
	}

}
