package com.dancosoft.socialcommunity.controller.support;

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
