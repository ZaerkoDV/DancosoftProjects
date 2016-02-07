package com.dancosoft.socialcommunity.controller.support;

import java.util.Date;

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
