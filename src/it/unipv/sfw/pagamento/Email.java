package it.unipv.sfw.pagamento;

import java.io.FileInputStream;
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
	private static Properties props;
	private Session session;
	private static boolean isInit = false;
	
	public Email() {
		if (!isInit)
			init();
		openConnection();
	}
	
	private static void init() {
		props = new Properties();
		try {
			props.load(new FileInputStream("properties/mail_properties"));
			isInit = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void openConnection() {
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(props.getProperty("MITTENTE"), props.getProperty("PASSWORD"));
			}
		});
	}
	
	public void emailStore() throws MessagingException{
		String messaggio = "";
		messaggio += "ID" + spaziatura("ID") + "NOME" + spaziatura("NOME") + "PREZZO" + "          " + "QUANTITÀ\n";
		messaggio += "------------------------------------------------------------------------------------------\n";
		HashMap<Merchandising, Integer> carrello =  Sessione.getIstance().getCarrello();
		
		for(Map.Entry<Merchandising, Integer> entry: carrello.entrySet()) {
			messaggio += entry.getKey().getId()+ spaziatura(Integer.toString(entry.getKey().getId()));
			messaggio += entry.getKey().getNome()+ spaziatura(entry.getKey().getNome());
			messaggio += entry.getKey().getPrezzo()+ spaziatura(Double.toString(entry.getKey().getPrezzo()));
			messaggio += entry.getValue() + "\n";
		}
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("MITTENTE")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Sessione.getIstance().getCurrentUtente().getEmail()));
			message.setSubject("Pagamento store StadiumSystem");
			message.setContent(messaggio, "text/plain"); Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public String spaziatura(String stringa) {
		String spazi = "";
		for(int i=0; i<(21 - stringa.length()); i++) {
			spazi += " ";
		}
		return spazi;
	}

}
