package model;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	
	
	
	
	public Email (){
		
	}
	
	public void sendEmail(String assunto,String mensagem, String fromEmail,String nomeTo) {
	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");
	      props.put("mail.debug", "true");
	      String[] ls = util.Facade.lerArquivoEmail();
	      
	      Session session = Session.getInstance(props,
	  		  new Authenticator() {
	  			protected PasswordAuthentication getPasswordAuthentication() {
	  				return new PasswordAuthentication(ls[0], ls[1]);
	  			}
	  		  });
	      try {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(ls[0]));
	        msg.setRecipients(Message.RecipientType.TO, fromEmail);
	        msg.setSubject(assunto);
	        msg.setSentDate(new Date());
	        msg.setText(mensagem);
	        Transport.send(msg);
		System.out.println("---Done---");
	      } catch (MessagingException mex) {
	    	mex.printStackTrace();
	      }
	}
} 