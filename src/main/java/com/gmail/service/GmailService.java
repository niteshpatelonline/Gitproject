package com.gmail.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.stereotype.Service;

import com.gmail.model.Gmail;

@Service
public class GmailService {

	
	public boolean sendGmail(Gmail gmail) {
       
		boolean flag = false;
		final String user = "singhpatelmn@gmail.com";		
		String message = "Customer Gmail Id is  "+gmail.getSubject()+" \n"
				+ "Customer Message is  "+gmail.getMessage();
		String to = gmail.getTo();
		String subject = gmail.getName();
		
		final String password = "Nitesh@12345";
		
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(user,password);
			}
			
		});
		session.setDebug(true);
		
		MimeMessage m = new MimeMessage(session);
		
		
		try {
			m.setFrom(user);
			m.addRecipient(RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);
			
			Transport.send(m);
			
			System.out.println("Message Sent Successfully...");
			flag=true;
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
		return flag;
		
	}
}
