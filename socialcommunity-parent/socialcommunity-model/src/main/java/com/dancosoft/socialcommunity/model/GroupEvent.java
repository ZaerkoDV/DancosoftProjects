/**
 * @package com.dancosoft.socialcommunity.model
 * 
 * The package com.dancosoft.socialcommunity.model contain set of class which description
 * basic essence in SocialCommunity project.The project is based on MVC architecture.
 * This class is part of model in MVC architecture.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.
 */
package com.dancosoft.socialcommunity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GroupEvent entity describe event which send one of group members. This class
 * contain information about event(special message) group such as date when
 * event create, date when event create.Class GroupEvent have relations (or
 * forigen key which refer on this class): meny-to-one with GroupMember and
 * meny-to-one with event pattern. All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * GroupEvent entity. Class implements interface Serializable. For creating
 * GroupEvent model use Hibernate technology (anatations). Class contains
 * exclusively no-static public methods that return fields of entity. Methods
 * intended to access object fields.Class also contain overload methods
 * toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "GroupEvent")
@Table(name = "group_event")
public class GroupEvent implements Serializable {

	private static final long serialVersionUID = -2813438273739211518L;

	/**
	 * Unique identification number of GroupEvent for entity GroupEvent.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_group_event")
	private Long idGroupEvent;

	/**
	 * Date when event create.
	 * 
	 * @type Date
	 */
	@Column(name = "date_create_group_event")
	private Date dateCreateGroupEvent;

	/**
	 * Event pattern which use in this event.
	 * 
	 * @type EventPattern
	 */
	@ManyToOne
	@JoinColumn(name = "event_pattern_id")
	private EventPattern eventPattern;

	/**
	 * Member which send this event.
	 * 
	 * @type EventPattern
	 */
	@ManyToOne
	@JoinColumn(name = "group_member_id")
	private GroupMember groupMember;

	/**
	 * Empty constructor(default) of GroupEvent class.
	 */
	public GroupEvent() {
	}

	/**
	 * Overloaded constructor of GroupEvent class.
	 * 
	 * @type Long
	 * @type String
	 * @type Date 
	 * @type EventPattern
	 * @type GroupMember 
	 * 
	 * @param idGroupEvent
	 * @param dateCreateGroupEvent
	 * @param eventPattern
	 * @param groupMember
	 */
	public GroupEvent(Long idGroupEvent, Date dateCreateGroupEvent,
			EventPattern eventPattern, GroupMember groupMember) {
		this.idGroupEvent = idGroupEvent;
		this.dateCreateGroupEvent = dateCreateGroupEvent;
		this.eventPattern = eventPattern;
		this.groupMember = groupMember;
	}

	/**
	 * @return the idGroupEvent
	 */
	public Long getIdGroupEvent() {
		return idGroupEvent;
	}

	/**
	 * @param idGroupEvent
	 *            the idGroupEvent to set
	 */
	public void setIdGroupEvent(Long idGroupEvent) {
		this.idGroupEvent = idGroupEvent;
	}

	/**
	 * @return the dateCreateGroupEvent
	 */
	public Date getDateCreateGroupEvent() {
		return dateCreateGroupEvent;
	}

	/**
	 * @param dateCreateGroupEvent
	 *            the dateCreateGroupEvent to set
	 */
	public void setDateCreateGroupEvent(Date dateCreateGroupEvent) {
		this.dateCreateGroupEvent = dateCreateGroupEvent;
	}
	
//	public LocalDateTime getDateCreateGroupEvent() {
//		Instant instant = Instant.ofEpochMilli(dateCreateGroupEvent.getTime());
//		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
//	}
//	
//	public void setDateCreateGroupEvent(LocalDateTime dateCreateGroupEvent) {
//		Instant instant = dateCreateGroupEvent.toInstant(ZoneOffset.UTC);		
//		this.dateCreateGroupEvent = Date.from(instant);
//	}

	/**
	 * @return the eventPattern
	 */
	public EventPattern getEventPattern() {
		return eventPattern;
	}

	/**
	 * @param eventPattern
	 *            the eventPattern to set
	 */
	public void setEventPattern(EventPattern eventPattern) {
		this.eventPattern = eventPattern;
	}

	/**
	 * @return the groupMember
	 */
	public GroupMember getGroupMember() {
		return groupMember;
	}

	/**
	 * @param groupMember
	 *            the groupMember to set
	 */
	public void setGroupMember(GroupMember groupMember) {
		this.groupMember = groupMember;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return GroupEvent entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idGroupEvent.equals(null)) {
			return this.idGroupEvent.toString() + " "
					+ this.dateCreateGroupEvent.toString() + " "
					+ this.eventPattern.toString() + " "
					+ this.groupMember.toString();
		}
		return super.toString();
	}

	/**
	 * Overload basic method hashCode()
	 * 
	 * @type Integer
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dateCreateGroupEvent == null) ? 0 : dateCreateGroupEvent
						.hashCode());
		result = prime * result
				+ ((eventPattern == null) ? 0 : eventPattern.hashCode());
		result = prime * result
				+ ((groupMember == null) ? 0 : groupMember.hashCode());
		result = prime * result
				+ ((idGroupEvent == null) ? 0 : idGroupEvent.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to GroupEvent or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GroupEvent))
			return false;
		GroupEvent other = (GroupEvent) obj;
		if (dateCreateGroupEvent == null) {
			if (other.dateCreateGroupEvent != null)
				return false;
		} else if (!dateCreateGroupEvent.equals(other.dateCreateGroupEvent))
			return false;
		if (eventPattern == null) {
			if (other.eventPattern != null)
				return false;
		} else if (!eventPattern.equals(other.eventPattern))
			return false;
		if (groupMember == null) {
			if (other.groupMember != null)
				return false;
		} else if (!groupMember.equals(other.groupMember))
			return false;
		if (idGroupEvent == null) {
			if (other.idGroupEvent != null)
				return false;
		} else if (!idGroupEvent.equals(other.idGroupEvent))
			return false;
		return true;
	}

}
