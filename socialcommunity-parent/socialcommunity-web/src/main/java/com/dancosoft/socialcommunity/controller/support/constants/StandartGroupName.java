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
 * The enum StandartGroupName use for set name of standart groups when create account. Default group
 * in account crateing regardless user. After user may edit this group or delete. User may add new
 * member in group. Enum have three states Myfamily, MyFriend, MyWork. Each status return overload
 * method toString which return string value of status.
 * 
 * @see enum
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
public enum StandartGroupName {

	MyFamily {
	      public String toString() {
	          return "MyFamily";
	      }
	  },

	MyFriend {
	      public String toString() {
	          return "MyFriend";
	      }
	  },
	  
	MyWork {
	      public String toString() {
	          return "MyWork";
	      }
	  }
}
