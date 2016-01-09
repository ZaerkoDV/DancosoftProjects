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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EventPattern entity describe event pattern which use in group event. This
 * class contain information about event pattern(special message).Event mean
 * often use message. Class EventPattern have relations (or forigen key which
 * refer on this class): one-to-meny with GroupEvent. All communication is
 * one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * EventPattern entity. Class implements interface Serializable. For creating
 * EventPattern model use Hibernate technology (anatations). Class contains
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
@Entity(name = "EventPattern")
@Table(name = "event_pattern")
public class EventPattern implements Serializable {

	private static final long serialVersionUID = 6888569018693283549L;

	/**
	 * Unique identification number of EventPattern for entity EventPattern.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_event_pattern")
	private Long idEventPattern;

	/**
	 * Context event(Message which often use in dialoges)
	 * 
	 * @type String
	 */
	@Column(name = "event_pattern")
	private String eventPattern;

	/**
	 * Empty constructor(default) of EventPattern class.
	 */
	public EventPattern() {
	}

	/**
	 * Overloaded constructor of PatternEvent class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idEventPattern
	 * @param eventPattern
	 */
	public EventPattern(Long idEventPattern, String eventPattern) {
		this.idEventPattern = idEventPattern;
		this.eventPattern = eventPattern;
	}

	/**
	 * @return the idEventPattern
	 */
	public Long getIdEventPattern() {
		return idEventPattern;
	}

	/**
	 * @param idEventPattern
	 *            the idEventPattern to set
	 */
	public void setIdEventPattern(Long idEventPattern) {
		this.idEventPattern = idEventPattern;
	}

	/**
	 * @return the event_pattern
	 */
	public String getEventPattern() {
		return eventPattern;
	}

	/**
	 * @param event_pattern
	 *            the event_pattern to set
	 */
	public void setEventPattern(String eventPattern) {
		this.eventPattern = eventPattern;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return EventPattern entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idEventPattern.equals(null)) {
			return this.idEventPattern.toString() + " "
					+ this.eventPattern.toString();
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
		result = prime * result
				+ ((eventPattern == null) ? 0 : eventPattern.hashCode());
		result = prime * result
				+ ((idEventPattern == null) ? 0 : idEventPattern.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to EventPattern or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EventPattern))
			return false;
		EventPattern other = (EventPattern) obj;
		if (eventPattern == null) {
			if (other.eventPattern != null)
				return false;
		} else if (!eventPattern.equals(other.eventPattern))
			return false;
		if (idEventPattern == null) {
			if (other.idEventPattern != null)
				return false;
		} else if (!idEventPattern.equals(other.idEventPattern))
			return false;
		return true;
	}

}
