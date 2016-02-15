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

import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;

/**
 * <p>The class UserExtended contain series of classes. This class is class wrapper
 * other classes. Class wrapper include next entity UserAutobiography,UserEmail,
 * UserSocialNetwork. Also class contain set of get/set methods for object access.
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
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
