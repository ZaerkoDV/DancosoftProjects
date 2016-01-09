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
import javax.validation.constraints.NotNull;

/**
 * GroupMessage entity describe message which send one of group members. This
 * class contain information about message group such as date when message
 * create, context message.Class GroupMessage have relations (or forigen key
 * which refer on this class): one-to-one with GroupMember. All communication is
 * one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * GroupMessage entity. Class implements interface Serializable. For creating
 * GroupMessage model use Hibernate technology (anatations). Class contains
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
@Entity(name = "GroupMessage")
@Table(name = "group_message")
public class GroupMessage implements Serializable {

	private static final long serialVersionUID = 3159733576771917401L;

	/**
	 * Unique identification number of GroupMessage for entity GroupMessage.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_group_message")
	private Long idGroupMessage;

	/**
	 * Context of group message.
	 * 
	 * @type String
	 */
	@Column(name = "group_message")
	private String groupMessage;

	/**
	 * Date create group message.
	 * 
	 * @type Date
	 */
	@NotNull
	@Column(name = "date_create_group_message")
	private Date dateCreateGroupMessage;

	/**
	 * Member which create this message.
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "group_member_id")
	private GroupMember groupMember;

	/**
	 * Empty constructor(default) of GroupMessage class.
	 */
	public GroupMessage() {
	}

	/**
	 * Overloaded constructor of GroupMessage class.
	 * 
	 * @type Long
	 * @type String
	 * @type GroupMember
	 * @type Date
	 * 
	 * @param idGroupMessage
	 * @param groupMessage
	 * @param dateCreateGroupMessage
	 * @param groupMember
	 */
	public GroupMessage(Long idGroupMessage, String groupMessage,
			Date dateCreateGroupMessage, GroupMember groupMember) {
		this.idGroupMessage = idGroupMessage;
		this.groupMessage = groupMessage;
		this.dateCreateGroupMessage = dateCreateGroupMessage;
		this.groupMember = groupMember;
	}

	/**
	 * @return the idGroupMessage
	 */
	public Long getIdGroupMessage() {
		return idGroupMessage;
	}

	/**
	 * @param idGroupMessage
	 *            the idGroupMessage to set
	 */
	public void setIdGroupMessage(Long idGroupMessage) {
		this.idGroupMessage = idGroupMessage;
	}

	/**
	 * @return the groupMessage
	 */
	public String getGroupMessage() {
		return groupMessage;
	}

	/**
	 * @param groupMessage
	 *            the groupMessage to set
	 */
	public void setGroupMessage(String groupMessage) {
		this.groupMessage = groupMessage;
	}

	/**
	 * @return the dateCreateGroupMessage
	 */
	public Date getDateCreateGroupMessage() {
		return dateCreateGroupMessage;
	}

	/**
	 * @param dateCreateGroupMessage
	 *            the dateCreateGroupMessage to set
	 */
	public void setDateCreateGroupMessage(Date dateCreateGroupMessage) {
		this.dateCreateGroupMessage = dateCreateGroupMessage;
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
	 * @return GroupMessage entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idGroupMessage.equals(null)) {
			return this.idGroupMessage.toString() + " "
					+ this.groupMessage.toString() + " "
					+ this.dateCreateGroupMessage.toString() + " "
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
				+ ((dateCreateGroupMessage == null) ? 0
						: dateCreateGroupMessage.hashCode());
		result = prime * result
				+ ((groupMember == null) ? 0 : groupMember.hashCode());
		result = prime * result
				+ ((groupMessage == null) ? 0 : groupMessage.hashCode());
		result = prime * result
				+ ((idGroupMessage == null) ? 0 : idGroupMessage.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to GroupMessage or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GroupMessage))
			return false;
		GroupMessage other = (GroupMessage) obj;
		if (dateCreateGroupMessage == null) {
			if (other.dateCreateGroupMessage != null)
				return false;
		} else if (!dateCreateGroupMessage.equals(other.dateCreateGroupMessage))
			return false;
		if (groupMember == null) {
			if (other.groupMember != null)
				return false;
		} else if (!groupMember.equals(other.groupMember))
			return false;
		if (groupMessage == null) {
			if (other.groupMessage != null)
				return false;
		} else if (!groupMessage.equals(other.groupMessage))
			return false;
		if (idGroupMessage == null) {
			if (other.idGroupMessage != null)
				return false;
		} else if (!idGroupMessage.equals(other.idGroupMessage))
			return false;
		return true;
	}
}
