/**
 * 
 */
package com.dancosoft.socialcommunity.service.support;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Zaerko_DV
 *
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
