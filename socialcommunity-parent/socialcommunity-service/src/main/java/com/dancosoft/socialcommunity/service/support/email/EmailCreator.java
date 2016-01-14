/**
 * @package com.dancosoft.socialcommunity.service.support.email
 * 
 * Package com.dancosoft.socialcommunity.service.support contain set of classes which use
 * for support classes in service layer of SocialCommunity project.This project based on
 * MVC architecture.Service layer defines the boundary of the application and a set of
 * permitted operations. It encapsulates the business logic of the application and controls
 * the answers in the implementation of operations. Also this package user support classes:
 * for generate new passworl and login,for sending email to user and other.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service.support.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>The class EmailCreator use for create email. Class user class Mail as pattern
 * of letter and add same special content, address. After creating email use bean
 * EmailSender for send. Class contain public method createSecurityEmail with paramerers
 * for create security email For logging use fasade slf4j and framework log4j. Class
 * contain also private, static variable logger, which use to call log message. Class
 * use Spring framework anatations to work with service layer.
 * 
 * @see slf4j framework
 * @see log4j framework
 * @java.util.Random
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
public class EmailCreator {

//	@Autowired
//	@Qualifier(value="emailSender")
//	private EmailSender emailSender;
//	
//	public void setEmailSender(EmailSender emailSender) {
//		this.emailSender = emailSender;
//	}
	
	public void createSecurityEmail(String fromeEmail, String toEmail, String content){
			
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/service-config.xml");
		EmailSender emailSender = (EmailSender) context.getBean("emailSender");
		try {
			Email email = new Email();
			email.setEmailFrom(fromeEmail);
			email.setEmailTo(toEmail);
			email.setEmailSubject("SocialCommunity Security Litter.");
			email.setEmailContent(content);
			email.setTemplateName("emailtemplate.vm");
			emailSender.sendEmail(email);
			
		} catch (NullPointerException e) {
			throw new RuntimeException("EmailCreator: Bean EmailSender not found! "+e);
		}
	}
}
