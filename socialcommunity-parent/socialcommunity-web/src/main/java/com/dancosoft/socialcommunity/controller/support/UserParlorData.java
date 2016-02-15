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

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.model.UserPhoto;

/**
 * <p>The class UserParlorData contain series of classes. This class is class wrapper for
 * other classes. Class wrapper include next entity UserAutobiography,UserEmail,userPhoto
 * UserSocialNetwork,UserLocation. Also class contain set of get/set methods for object access.
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
public class UserParlorData {
	
	private User user;
	
	private UserAutobiography userAutobiography;
	
	private UserEmail userEmail;
	
	private UserPhoto userPhoto;
	
	private UserLocation userLocation;
	
	public UserParlorData(){
	}
	
	public UserParlorData(User user, UserAutobiography userAutobiography,
			UserEmail userEmail,UserPhoto userPhoto,UserLocation userLocation){
		
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
