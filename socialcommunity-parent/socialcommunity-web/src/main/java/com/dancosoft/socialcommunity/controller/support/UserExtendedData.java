package com.dancosoft.socialcommunity.controller.support;

import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.model.UserPhoto;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;

public class UserExtendedData {
	
	private UserAutobiography userAutobiography;
	
	private UserEmail userEmail;
	
	private UserSocialNetwork userSocialNetwork;
	
	private UserPhoto userPhoto;
	
	private UserLocation userLocation;
	
	public UserExtendedData(){
	}
	
	public UserExtendedData(UserAutobiography userAutobiography,UserEmail userEmail,UserSocialNetwork userSocialNetwork,
			UserPhoto userPhoto,UserLocation userLocation){
		
		this.userAutobiography=userAutobiography;
		this.userEmail=userEmail;
		this.userSocialNetwork=userSocialNetwork;
		this.userPhoto=userPhoto;
		this.userLocation=userLocation;
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
	
	public UserPhoto getUserPhoto() {
		return userPhoto;
	}
	
	public void setUserPhoto(UserPhoto userPhoto) {
		this.userPhoto = userPhoto;
	}

	public UserLocation getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(UserLocation userLocation) {
		this.userLocation = userLocation;
	}
	
}
