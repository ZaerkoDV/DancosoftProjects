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

import java.util.Date;

/**
 * <p>The class ForumMessagesData contain two fiels with data type. This class
 * use for sending from frond end to back and date. Also class contain set of
 * get/set methods for field access.
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
public class ForumMessagesData {
	
	private Date from=null;
	private Date to=null;
	
	public ForumMessagesData(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	/**
	 * @return the from
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(Date from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public Date getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(Date to) {
		this.to = to;
	}
}
