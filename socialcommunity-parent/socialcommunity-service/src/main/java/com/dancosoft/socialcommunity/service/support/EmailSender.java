/**
 * 
 */
package com.dancosoft.socialcommunity.service.support;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Authenticator;

import com.dancosoft.socialcommunity.model.UserEmail;

/**
 * @author Zaerko_DV
 *
 */
public class EmailSender {

	
	public Boolean sendEmail(List<UserEmail> list,String login, String password)  {
		
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp.mail.ru.");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.class", "javax.net.SocketFactory");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.enable", "false");
		props.put("mail.smtp.starttls.enable", "true");
		
		Session mailSession=Session.getInstance(props,new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return(new PasswordAuthentication("zaerko1991@mail.ru",""));
			}
		});
		
		MimeMessage message=new MimeMessage(mailSession);
		String[] emails={"zaerko1991@mail.ru", "zaerko1991@gmail.com"};
		try {
			InternetAddress dests[] = new InternetAddress[list.size()];
			
			for (int i = 0; i < list.size(); i++) {
				dests[i] = new InternetAddress(emails[i].trim().toLowerCase());
			}
			message.setFrom(new InternetAddress("zaerko1991@mail.ru"));//ot kogo
			message.setRecipients(Message.RecipientType.TO, dests);		//komy
			message.setSubject("Test letter.","KOI8-R");
			
			
			
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
		
		
		Multipart mp=new MimeMultipart();
		MimeBodyPart mbp1=new MimeBodyPart();
		try {
			mbp1.setText(""
			+" Your old password is unsafe.\n"		
			+ "You new login: "+login +"\n  password "+password+"\n "	
			,"KOI8-R");
			mp.addBodyPart(mbp1);
			message.setContent(mp);
			message.setSentDate(new java.util.Date());
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
