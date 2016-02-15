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
 * The enum ViewStatus use for set view status addeses other social community, user post address.
 * Also view status use whan creating forum topic, forum. For example forum have view status private
 * when have same specail contents. If group have view status public each member of group may add
 * new account to tis group. If grou have private status add new member to group may only group ovner.
 * Default value of view status public.Enum have two states public,private. Each status return overload
 * method toString which return string value of status.
 * 
 * @see enum
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
public enum ViewStatus {

	PUBLIC {
	      public String toString() {
	          return "public";
	      }
	  },

   PRIVATE {
	      public String toString() {
	          return "private";
	      }
	  } 	  
}
