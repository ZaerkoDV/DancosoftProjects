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
 * ForumMessage entity describe special part of forum. This class contain
 * information about forum message such as forum message, date create forum
 * message and account who create this message. Class ForumMessage have
 * relations (or forigen key which refer on this class): meny-to-one with
 * ForumTopic, meny-to-one with Account(creator message). All communication is
 * one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * ForumMessage entity. Class implements interface Serializable. For creating
 * ForumMessage model use Hibernate technology (anatations). Class contains
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
@Entity(name = "ForumMessage")
@Table(name = "forum_message")
public class ForumMessage implements Serializable {

	private static final long serialVersionUID = 8273971263780828665L;

	/**
	 * Unique identification number of ForumMessage entity.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_forum_message")
	private Long idForumMessage;

	/**
	 * Date when message create.
	 * 
	 * @type Date
	 */
	@NotNull
	@Column(name = "date_create_forum_message")
	private Date dateCreateForumMessage;

	/**
	 * Context message.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "forum_message")
	private String forumMessage;

	/**
	 * ForumTopic which contain this message
	 * 
	 * @type ForumTopic
	 */
	@ManyToOne
	@JoinColumn(name = "forum_topic_id")
	private ForumTopic forumTopic;
	
	/**
	 * Author of message
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "author_account_id")
	private Account authorAccount;

	/**
	 * Empty constructor(default) of ForumMessage class.
	 */
	public ForumMessage() {
	}

	/**
	 * Overloaded constructor of ForumMessage class.
	 * 
	 * @type Long
	 * @type Date
	 * @type String
	 * @type Account
	 * @type ForumTopic
	 * 
	 * @param idForumMessage
	 * @param dateCreateForumMessage
	 * @param forumMessage
	 * @param forumTopic
	 * @param authorAccount
	 */
	public ForumMessage(Long idForumMessage, Date dateCreateForumMessage,
			String forumMessage, ForumTopic forumTopic, Account authorAccount) {
		this.idForumMessage = idForumMessage;
		this.dateCreateForumMessage = dateCreateForumMessage;
		this.forumMessage = forumMessage;
		this.forumTopic = forumTopic;
		this.authorAccount = authorAccount;
	}

	/**
	 * @return the idForumMessage
	 */
	public Long getIdForumMessage() {
		return idForumMessage;
	}

	/**
	 * @param idForumMessage
	 *            the idForumMessage to set
	 */
	public void setIdForumMessage(Long idForumMessage) {
		this.idForumMessage = idForumMessage;
	}

	/**
	 * @return the dateCreateForumMessage
	 */
	public Date getDateCreateForumMessage() {
		return dateCreateForumMessage;
	}

	/**
	 * @param dateCreateForumMessage
	 *            the dateCreateForumMessage to set
	 */
	public void setDateCreateForumMessage(Date dateCreateForumMessage) {
		this.dateCreateForumMessage = dateCreateForumMessage;
	}
	
//	public LocalDateTime getDateCreateForumMessage() {
//		Instant instant = Instant.ofEpochMilli(dateCreateForumMessage.getTime());
//		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
//	}
//	
//	public void setDateCreateForumMessage(LocalDateTime dateCreateForumMessage) {
//		Instant instant = dateCreateForumMessage.toInstant(ZoneOffset.UTC);		
//		this.dateCreateForumMessage = Date.from(instant);
//	}

	/**
	 * @return the forumMessage
	 */
	public String getForumMessage() {
		return forumMessage;
	}

	/**
	 * @param forumMessage
	 *            the forumMessage to set
	 */
	public void setForumMessage(String forumMessage) {
		this.forumMessage = forumMessage;
	}

	/**
	 * @return the forumTopic
	 */
	public ForumTopic getForumTopic() {
		return forumTopic;
	}

	/**
	 * @param forumTopic
	 *            the forumTopic to set
	 */
	public void setForumTopic(ForumTopic forumTopic) {
		this.forumTopic = forumTopic;
	}

	/**
	 * @return the authorAccount
	 */
	public Account getAuthorAccount() {
		return authorAccount;
	}

	/**
	 * @param authorAccount
	 *            the authorAccount to set
	 */
	public void setAuthorAccount(Account authorAccount) {
		this.authorAccount = authorAccount;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return ForumMessage entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idForumMessage.equals(null)) {
			return this.idForumMessage.toString() + " "
					+ this.dateCreateForumMessage.toString() + " "
					+ this.forumMessage.toString() + " "
					+ this.forumTopic.toString() + " "
					+ this.authorAccount.toString();
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
				+ ((authorAccount == null) ? 0 : authorAccount.hashCode());
		result = prime
				* result
				+ ((dateCreateForumMessage == null) ? 0
						: dateCreateForumMessage.hashCode());
		result = prime * result
				+ ((forumMessage == null) ? 0 : forumMessage.hashCode());
		result = prime * result
				+ ((forumTopic == null) ? 0 : forumTopic.hashCode());
		result = prime * result
				+ ((idForumMessage == null) ? 0 : idForumMessage.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to ForumMessage or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ForumMessage))
			return false;
		ForumMessage other = (ForumMessage) obj;
		if (authorAccount == null) {
			if (other.authorAccount != null)
				return false;
		} else if (!authorAccount.equals(other.authorAccount))
			return false;
		if (dateCreateForumMessage == null) {
			if (other.dateCreateForumMessage != null)
				return false;
		} else if (!dateCreateForumMessage.equals(other.dateCreateForumMessage))
			return false;
		if (forumMessage == null) {
			if (other.forumMessage != null)
				return false;
		} else if (!forumMessage.equals(other.forumMessage))
			return false;
		if (forumTopic == null) {
			if (other.forumTopic != null)
				return false;
		} else if (!forumTopic.equals(other.forumTopic))
			return false;
		if (idForumMessage == null) {
			if (other.idForumMessage != null)
				return false;
		} else if (!idForumMessage.equals(other.idForumMessage))
			return false;
		return true;
	}

}
