package com.dancosoft.socialcommunity.controller.support;

import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;


public class UserExtended {

	private UserAutobiography userAutobiography;
	private UserEmail userEmail;
	private UserSocialNetwork userSocialNetwork;
	
	public UserExtended(){
	}
		
	
	public UserExtended(UserAutobiography userAutobiography,UserEmail userEmail, UserSocialNetwork userSocialNetwork) {
		this.userAutobiography = userAutobiography;
		this.userEmail = userEmail;
		this.userSocialNetwork = userSocialNetwork;
	}
	
	public UserAutobiography getUserAutobiography() {
		return userAutobiography;
	}

	public void setUserAutobiography(UserAutobiography userAutobiography) {
		this.userAutobiography = userAutobiography;
	}

	public UserEmail getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(UserEmail userEmail) {
		this.userEmail = userEmail;
	}
	
	public UserSocialNetwork getUserSocialNetwork() {
		return userSocialNetwork;
	}
	
	public void setUserSocialNetwork(UserSocialNetwork userSocialNetwork) {
		this.userSocialNetwork = userSocialNetwork;
	}
	
	@Override
	public String toString() {
			return this.userAutobiography + " "+ this.userEmail + " " + this.userSocialNetwork;
	}
	
}
