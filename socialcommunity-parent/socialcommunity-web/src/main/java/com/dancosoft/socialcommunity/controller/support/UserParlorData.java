package com.dancosoft.socialcommunity.controller.support;

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.model.UserPhoto;

public class UserParlorData {
	
	private User user;
	
	private UserAutobiography userAutobiography;
	
	private UserEmail userEmail;
	
	private UserPhoto userPhoto;
	
	private UserLocation userLocation;
	
	public UserParlorData(){
	}
	
	public UserParlorData(User user, UserAutobiography userAutobiography,UserEmail userEmail,
			UserPhoto userPhoto,UserLocation userLocation){
		
		this.user=user;
		this.userAutobiography=userAutobiography;
		this.userEmail=userEmail;
		this.userPhoto=userPhoto;
		this.userLocation=userLocation;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
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
