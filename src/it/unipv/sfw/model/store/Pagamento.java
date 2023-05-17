package it.unipv.sfw.model.store;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Pagamento {
	final String MITTENTE = "StadiumSystem@gmail.com";

	private ArrayList <Merchandising> ordini;
	private Carta metodoPagamento;
	
	public Pagamento(Carta metodoPagamento, Merchandising merch) {
		ordini = new ArrayList<Merchandising>();
		ordini.add(merch);
		this.metodoPagamento = metodoPagamento;
	}
	
	public Carta getMetodoPagamento() {
		return metodoPagamento;
	}
	
	public void setMetodoPagamento(Carta metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	
	public void addOrdine(Merchandising merch) {
		ordini.add(merch);
	}
	
	public void sendMail(String destinatario) throws MessagingException{
		
		String messaggio = "";
		messaggio += "ID          NOME        PREZZO      \n";
		
		for(int i=0; i<ordini.size(); i++) {
			messaggio += ordini.get(i).toString();
		}
		
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.example.com");
	 
	    Session session = Session.getDefaultInstance(props, null);
	    Message msg = new MimeMessage(session);
	 
	    InternetAddress addressFrom = new InternetAddress(MITTENTE);
	    msg.setFrom(addressFrom);
	    InternetAddress addressTo = new InternetAddress(destinatario); 
	  
	    msg.setSubject("Ordine StadiumSystem");
	    msg.setContent(messaggio, "text/plain");
	  
	    Transport.send(msg);
	}

}
