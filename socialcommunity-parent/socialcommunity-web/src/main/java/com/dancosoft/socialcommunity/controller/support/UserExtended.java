package com.dancosoft.socialcommunity.controller.support;

import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;


public class UserExtended {

	private UserAutobiography userAutobiography;
	private UserEmail userEmail;
	private UserSocialNetwork socialNetwork;
	
	public UserExtended(){
	}
		
	
	public UserExtended(UserAutobiography userAutobiography,UserEmail userEmail, UserSocialNetwork socialNetwork) {
		this.userAutobiography = userAutobiography;
		this.userEmail = userEmail;
		this.socialNetwork = socialNetwork;
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
	
	public UserSocialNetwork getSocialNetwork() {
		return socialNetwork;
	}
	
	public void setSocialNetwork(UserSocialNetwork socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

//	@Override
//	public String toString() {
//		return "UserExtended [userAutobiography=" + userAutobiography
//				+ ", userEmail=" + userEmail + ", socialNetwork="
//				+ socialNetwork + "]";
//	}
	
	@Override
	public String toString() {
			return this.userAutobiography + " "+ this.userEmail + " " + this.socialNetwork;
	}
	
}
