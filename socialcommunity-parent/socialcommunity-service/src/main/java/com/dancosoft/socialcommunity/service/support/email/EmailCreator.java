/**
 * 
 */
package com.dancosoft.socialcommunity.service.support.email;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zaerko_DV
 *
 */
public class EmailCreator {

//	@Autowired
//	@Qualifier(value="emailSender")
//	private EmailSender emailSender;
//
//	public void setEmailSender(EmailSender emailSender) {
//		this.emailSender = emailSender;
//	}

	public void createSecurityMail(String fromeEmail, String toEmail, String content){
			
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/service-config.xml");
		EmailSender emailSender = (EmailSender) context.getBean("emailSender");
		
		if(emailSender.equals(null)){
			throw new RuntimeException("EmailCreator: Bean EmailSender not found!");
			
		}else{
			Mail mail = new Mail();
			mail.setMailFrom(fromeEmail);
			mail.setMailTo(toEmail);
			mail.setMailSubject("SocialCommunity Security Litter.");
			mail.setMailContent(content);
			mail.setTemplateName("emailtemplate.vm");
			emailSender.sendMail(mail);
		}
	}
}
