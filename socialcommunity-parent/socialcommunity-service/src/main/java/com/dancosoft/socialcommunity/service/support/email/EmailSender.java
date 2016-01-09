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

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * <p>The class EmailSender use for send email.The Class contain only one method sendEmail.
 * Class user velocityEngine(org.apache.velocity) and mailSender(org.springframework.mail)
 * For logging use fasade slf4j and framework log4j. Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework anatations
 * to work with service layer.
 * 
 * @see slf4j framework
 * @see log4j framework
 * @see org.springframework.mail.MailSender
 * @see org.apache.velocity.app.VelocityEngine
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
public class EmailSender {

	@Autowired
	@Qualifier(value = "mailSender")
	private MailSender mailSender;

	@Autowired
	@Qualifier(value = "velocityEngine")
	private VelocityEngine velocityEngine;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
 
	public void sendEmail(Email email) {
		
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(email.getEmailFrom());
		message.setTo(email.getEmailTo());
		message.setSubject(email.getEmailSubject());

		Template template = velocityEngine.getTemplate("./templates/"+ email.getTemplateName());

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("context",email.getEmailContent() );

		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		message.setText(stringWriter.toString());

		mailSender.send(message);
	}	
}
