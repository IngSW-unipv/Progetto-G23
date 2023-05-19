package it.unipv.sfw.pagamento;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Sessione;

public class Email {
	private final String MITTENTE = "StadiumSystem@gmail.com";
	
	private String destinatario;
	private Properties props;
	private Session session;
	
	public Email() {
		destinatario = Sessione.getIstance().getCurrentUtente().getEmail();
		props = new Properties();
	    props.put("mail.smtp.host", "smtp.example.com");
	    session = Session.getDefaultInstance(props, null);
	}
	
	public void emailStore() throws MessagingException{
		String messaggio = "";
		messaggio += "ID          NOME        PREZZO      QUANTITÀ\n";
		messaggio += "--------------------------------------------\n";
		HashMap<Merchandising, Integer> carrello =  Sessione.getIstance().getCarrello();
		
		for(Map.Entry<Merchandising, Integer> entry: carrello.entrySet()) {
			messaggio += entry.getKey().getId()+ spaziatura(Integer.toString(entry.getKey().getId()));
			messaggio += entry.getKey().getNome()+ spaziatura(entry.getKey().getNome());
			messaggio += entry.getKey().getPrezzo()+ spaziatura(Double.toString(entry.getKey().getPrezzo()));
			messaggio += entry.getValue() + "\n";
		}
		
	    Message msg = new MimeMessage(session);
	 
	    InternetAddress addressFrom = new InternetAddress(MITTENTE);
	    msg.setFrom(addressFrom);
	    InternetAddress addressTo = new InternetAddress(destinatario); 
	  
	    msg.setSubject("Pagamento store StadiumSystem");
	    msg.setContent(messaggio, "text/plain");
	  
	    Transport.send(msg);
	}
	
	public String spaziatura(String stringa) {
		String spazi = "";
		for(int i=0; i<(12-stringa.length()); i++) {
			spazi += " ";
		}
		return spazi;
	}

}
