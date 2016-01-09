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

import java.util.Date;

/**
 * <p> The class Mail use as abstract email model. Class contain field which use 
 * when use for sending email.Class contain set of get/set methods for use private
 * field. Class contain overload method toString which return Mail as string. For
 * logging use fasade slf4j and framework log4j. Class contain also private, static
 * variable logger, which use to call log message. Class use Spring framework
 * anatations to work with service layer.
 * 
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
public class Email {

	private String emailFrom;
	private String emailTo;
	private String emailSubject;
	private String templateName;
	private String emailContent;
	private String contentType;

	public Email() {
		contentType = "text/html";
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public Date getEmailSendDate() {
		return new Date();
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	@Override
	public String toString() {

		StringBuilder lBuilder = new StringBuilder();
		lBuilder.append("Mail From:- ").append(getEmailFrom());
		lBuilder.append("Mail To:- ").append(getEmailTo());
		lBuilder.append("Mail Subject:- ").append(getEmailSubject());
		lBuilder.append("Mail Send Date:- ").append(getEmailSendDate());
		lBuilder.append("Mail Content:- ").append(getEmailContent());

		return lBuilder.toString();
	}

}
