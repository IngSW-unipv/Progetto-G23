package it.unipv.sfw.pagamento;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import it.unipv.sfw.model.biglietti.Biglietto;
import it.unipv.sfw.model.store.Merchandising;
import it.unipv.sfw.model.utente.Sessione;

public class Email {
	private static Properties props;
	private static boolean isInit = false;

	private static void init() {
		props = new Properties();
		try {
			props.load(Email.class.getClassLoader().getResourceAsStream("mail_properties"));
			isInit = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Session session;

	public Email() {
		if (!isInit)
			init();
		openConnection();
	}

	public String messaggioAbbonamento() {
		String messaggio = "";

		messaggio += "Pagamento effettuato. Nuovo livello di abbonamento: "
				+ Sessione.getIstance().getCurrentAbb().getTipoAbb();

		return messaggio;
	}

	public String messaggioMuseo() {
		String messaggio = "";
		Biglietto b = Sessione.getIstance().getCurrentBiglietto();
		int n = Sessione.getIstance().getNBiglietti();

		String giorno = "" + (b.getData().get(Calendar.DAY_OF_MONTH) - 1) + "-" + (b.getData().get(Calendar.MONTH) + 1)
				+ "-" + b.getData().get(Calendar.YEAR);

		if (n == 1)
			messaggio += "Il pagamento del biglietto per il museo è avvenuto correttamente.\n";
		else
			messaggio += "Il pagamento dei " + n + " biglietti per il museo è avvenuto correttamente.\n";
		messaggio += "Puoi accedere il giorno " + giorno + ".";

		return messaggio;
	}

	public String messaggioPartita() {
		String messaggio = "";
		Sessione s = Sessione.getIstance();
		String posto = "Settore " + s.getSettore() + ", Blocco " + s.getBlocco() + ", Anello " + s.getAnello()
				+ ", Posto " + s.getPosto() + ".";

		messaggio += "Il pagamento per la partita " + Sessione.getIstance().getCurrentPartita().getCasa() + "-"
				+ Sessione.getIstance().getCurrentPartita().getOspiti() + " è avvenuto nel modo corretto.\n";
		messaggio += "Il tuo posto è: " + posto;

		return messaggio;
	}

	public String messaggioStore() {
		String messaggio = "";

		messaggio += "ID" + spaziatura("ID") + "NOME" + spaziatura("NOME") + "PREZZO" + "          " + "QUANTITÀ\n";
		messaggio += "------------------------------------------------------------------------------------------\n";
		HashMap<Merchandising, Integer> carrello = Sessione.getIstance().getCarrello();

		for (Map.Entry<Merchandising, Integer> entry : carrello.entrySet()) {
			messaggio += entry.getKey().getId() + spaziatura(Integer.toString(entry.getKey().getId()));
			messaggio += entry.getKey().getNome() + spaziatura(entry.getKey().getNome());
			messaggio += entry.getKey().getPrezzo() + spaziatura(Double.toString(entry.getKey().getPrezzo()));
			messaggio += entry.getValue() + "\n";
		}

		return messaggio;
	}

	private void openConnection() {
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(props.getProperty("MITTENTE"),
						props.getProperty("PASSWORD"));
			}
		});
	}

	public void sendEmail(String messaggio) throws MessagingException {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("MITTENTE")));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Sessione.getIstance().getCurrentUtente().getEmail()));
			if (Sessione.getIstance().getCurrentPagamento() == 1)
				message.setSubject("Pagamento store StadiumSystem");
			else if (Sessione.getIstance().getCurrentPagamento() == 2)
				message.setSubject("Pagamento biglietto museo StadiumSystem");
			else if (Sessione.getIstance().getCurrentPagamento() == 3)
				message.setSubject("Pagamento biglietto partita StadiumSystem");
			message.setContent(messaggio, "text/plain");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new MessagingException();
		}
	}

	public void sendEmail(String messaggio, String destinatario) throws MessagingException {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(props.getProperty("MITTENTE")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			if (Sessione.getIstance().getCurrentPagamento() == 1)
				message.setSubject("Pagamento store StadiumSystem");
			else if (Sessione.getIstance().getCurrentPagamento() == 2)
				message.setSubject("Pagamento biglietto museo StadiumSystem");
			else if (Sessione.getIstance().getCurrentPagamento() == 3)
				message.setSubject("Pagamento biglietto partita StadiumSystem");
			else
				message.setSubject("Pagamento abbonamento");
			message.setContent(messaggio, "text/plain");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new MessagingException();
		}
	}

	public String spaziatura(String stringa) {
		String spazi = "";
		for (int i = 0; i < (21 - stringa.length()); i++) {
			spazi += " ";
		}
		return spazi;
	}

}
