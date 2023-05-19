package it.unipv.sfw.pagamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import it.unipv.sfw.model.utente.Sessione;

public class Pagamento {
	private Carta metodoPagamento;
	
	public Pagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	public Carta getMetodoPagamento() {
		return metodoPagamento;
	}
	
	public void setMetodoPagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

}
