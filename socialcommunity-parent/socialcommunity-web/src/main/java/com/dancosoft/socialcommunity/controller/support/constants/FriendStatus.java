/**
 * @package com.dancosoft.socialcommunity.controller.support.constants
 * 
 * Package com.dancosoft.socialcommunity.controller.support.constants contain set of enum
 * which use for support controller logic in SocialCommunity project. This project is based
 * on MVC architecture.This class is part of controller in MVC architecture. Controller
 * provides communication between the user and the system: controls user input and uses
 * models and views to implement the necessary response. This package contain set of enum
 * which use in controllers and other support classes.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.dancosoft.socialcommunity.controller.support.constants;

/**
 * The enum FriendStatus use for set user status relative to the group owner.Default value status
 * 'notfrinet'.User may change status when add other user to group or when edit list group members.
 * Enum have two states friend and notfriend. Each status return overload method toString which return
 * string value of status.
 * 
 * @see enum
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
public enum FriendStatus {

	FRIEND {
	      public String toString() {
	          return "friend";
	      }
	  },

	NOTFRIEND {
	      public String toString() {
	          return "notfriend";
	      }
	  }		
}
