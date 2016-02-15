/**
 * @package com.dancosoft.socialcommunity.controller.support
 * 
 * Package com.dancosoft.socialcommunity.controller.support contain set of classes
 * which use for support controller logic in SocialCommunity project. This project is based
 * on MVC architecture.This class is part of controller in MVC architecture. Controller
 * provides communication between the user and the system: controls user input and uses
 * models and views to implement the necessary response. Classes with postfix Data describe
 * object which use as wrapper of classes.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.dancosoft.socialcommunity.controller.support;

/**
 * <p>The class SearchPatternData contain field which desctibe search pattern. This
 * pattern use for sending two string type field from frond end to back end.
 * Also class contain set of get/set methods for field access.
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
public class SearchPatternData {
	
	private String accountName;
	private String userLastName;
	
	public SearchPatternData(){
		
	}
	
	/**
	 * @param accountName
	 * @param userLastName
	 */
	public SearchPatternData(String accountName, String userLastName) {	
		this.accountName = accountName;
		this.userLastName = userLastName;
	}
	
	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}
	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
}
