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
 * ForumTopic entity describe special part of forum. This class contain
 * information about forum topic such as topic name, date create forum topic and
 * account who create this topic. Class ForumTopic have relations (or forigen
 * key which refer on this class): one-to-meny with ForumMessage, meny-to-one
 * with Account(creator topic), meny-to-one with forum. All communication is
 * one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * ForumTopic entity. Class implements interface Serializable. For creating
 * ForumTopic model use Hibernate technology (anatations). Class contains
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
@Entity(name = "ForumTopic")
@Table(name = "forum_topic")
public class ForumTopic implements Serializable {

	private static final long serialVersionUID = 4418088470737613046L;

	/**
	 * Unique identification number of ForumTopic entity.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_forum_topic")
	private Long idForumTopic;

	/**
	 * Forum topic(name)
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "forum_topic")
	private String forumTopic;

	/**
	 * Date when topic create.
	 * 
	 * @type Date
	 */
	@NotNull
	@Column(name = "date_create_forum_topic")
	private Date dateCreateForumTopic;

	/**
	 * Author of topic
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "author_account_id")
	private Account authorAccount;

	/**
	 * Forum which contain this topic.
	 * 
	 * @type Forum
	 */
	@ManyToOne
	@JoinColumn(name = "forum_id")
	private Forum forum;

	/**
	 * Empty constructor(default) of ForumTopic class.
	 */
	public ForumTopic() {
	}

	/**
	 * Overloaded constructor of ForumTopic class.
	 * 
	 * @type Long
	 * @type Date
	 * @type String
	 * @type Account
	 * @type Forum
	 * 
	 * @param idForumTopic
	 * @param forumTopic
	 * @param dateCreateForumTopic
	 * @param authorAccount
	 * @param forum
	 */
	public ForumTopic(Long idForumTopic, String forumTopic,
			Date dateCreateForumTopic, Account authorAccount, Forum forum) {
		this.idForumTopic = idForumTopic;
		this.forumTopic = forumTopic;
		this.dateCreateForumTopic = dateCreateForumTopic;
		this.authorAccount = authorAccount;
		this.forum = forum;
	}

	/**
	 * @return the idForumTopic
	 */
	public Long getIdForumTopic() {
		return idForumTopic;
	}

	/**
	 * @param idForumTopic
	 *            the idForumTopic to set
	 */
	public void setIdForumTopic(Long idForumTopic) {
		this.idForumTopic = idForumTopic;
	}

	/**
	 * @return the forumTopic
	 */
	public String getForumTopic() {
		return forumTopic;
	}

	/**
	 * @param forumTopic
	 *            the forumTopic to set
	 */
	public void setForumTopic(String forumTopic) {
		this.forumTopic = forumTopic;
	}

	/**
	 * @return the dateCreateForumTopic
	 */
	public Date getDateCreateForumTopic() {
		return dateCreateForumTopic;
	}

	/**
	 * @param dateCreateForumTopic
	 *            the dateCreateForumTopic to set
	 */
	public void setDateCreateForumTopic(Date dateCreateForumTopic) {
		this.dateCreateForumTopic = dateCreateForumTopic;
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
	 * @return the forum
	 */
	public Forum getForum() {
		return forum;
	}

	/**
	 * @param forum
	 *            the forum to set
	 */
	public void setForum(Forum forum) {
		this.forum = forum;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return ForumTopic entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idForumTopic.equals(null)) {
			return this.idForumTopic.toString() + " "
					+ this.dateCreateForumTopic.toString() + " "
					+ this.forumTopic.toString() + " "
					+ this.authorAccount.toString() + " "
					+ this.forum.toString();
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
				+ ((dateCreateForumTopic == null) ? 0 : dateCreateForumTopic
						.hashCode());
		result = prime * result + ((forum == null) ? 0 : forum.hashCode());
		result = prime * result
				+ ((forumTopic == null) ? 0 : forumTopic.hashCode());
		result = prime * result
				+ ((idForumTopic == null) ? 0 : idForumTopic.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to ForumTopic or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ForumTopic))
			return false;
		ForumTopic other = (ForumTopic) obj;
		if (authorAccount == null) {
			if (other.authorAccount != null)
				return false;
		} else if (!authorAccount.equals(other.authorAccount))
			return false;
		if (dateCreateForumTopic == null) {
			if (other.dateCreateForumTopic != null)
				return false;
		} else if (!dateCreateForumTopic.equals(other.dateCreateForumTopic))
			return false;
		if (forum == null) {
			if (other.forum != null)
				return false;
		} else if (!forum.equals(other.forum))
			return false;
		if (forumTopic == null) {
			if (other.forumTopic != null)
				return false;
		} else if (!forumTopic.equals(other.forumTopic))
			return false;
		if (idForumTopic == null) {
			if (other.idForumTopic != null)
				return false;
		} else if (!idForumTopic.equals(other.idForumTopic))
			return false;
		return true;
	}

}
