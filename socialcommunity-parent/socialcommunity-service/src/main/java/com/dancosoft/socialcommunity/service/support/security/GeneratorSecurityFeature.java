/**
 * @package com.dancosoft.socialcommunity.service.support.security
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
package com.dancosoft.socialcommunity.service.support.security;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> The class GeneratorSecurityFeature use for support special operaton in
 * classes of service layer of SocialCommunity project. Class contain only
 * public methods. This methods use for generate rendom string(login and
 * password). Class have empty and overdue constructor. Overdue constuctor get
 * length rendom row as parametr. For logging use fasade slf4j and framework
 * log4j. Class contain also private, static variable logger, which use to call
 * log message. Class use Spring framework anatations to work with service
 * layer.
 * 
 * @see slf4j framework
 * @see log4j framework
 * @java.util.Random
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
public class GeneratorSecurityFeature {

	private static final Logger logger = LoggerFactory.getLogger(GeneratorSecurityFeature.class);
	
	private final Random random = new Random();
	private static final char[] symbols;
	private char[] buf;
	
	public GeneratorSecurityFeature(){
	}
	
	public GeneratorSecurityFeature(int length) {
	    if (length < 1){
	    	logger.warn("GeneratorSecurityFeature:Langth new security row must grether than 1");
	    	throw new IllegalArgumentException("length < 1: " + length);
	    }
	    buf = new char[length];
	 }
	
	static {
		StringBuilder tmp = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			tmp.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch)
			tmp.append(ch);
		symbols = tmp.toString().toCharArray();
	} 

	public String generateNewSecutityRow() {
		for (int idx = 0; idx < buf.length; ++idx) {
			buf[idx] = symbols[random.nextInt(symbols.length)];
		}
		logger.warn("GeneratorSecurityFeature:Generate new security row with langth"+ buf.length);
		return new String(buf);
	}
}
