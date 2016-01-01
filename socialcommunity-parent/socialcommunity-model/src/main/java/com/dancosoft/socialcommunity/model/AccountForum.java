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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AccountForum class use for system functioning. This is technology class.This
 * class contain information about account and correspond forum. Class
 * AccontForum have relations (or forigen key which refer on this class):
 * meny-to-one with Account, meny-to-one with Forum All communication is
 * one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * AccountForum entity. Class implements interface Serializable. For creating
 * AccountForum model use Hibernate technology (anatations). Class contains
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
@Entity(name = "AccountForum")
@Table(name = "account_forum")
public class AccountForum implements Serializable {

	private static final long serialVersionUID = -7117492929345366771L;

	/**
	 * Unique identification number of connection between account and forum
	 * entity.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account_forum")
	private Long idAccountForum;

	/**
	 * Account which use forum
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	/**
	 * Forum which use account
	 * 
	 * @type Forum
	 */
	@ManyToOne
	@JoinColumn(name = "forum_id")
	private Forum forum;

	/**
	 * Empty constructor(default) of AccountForum class.
	 */
	public AccountForum() {
	}

	/**
	 * Overloaded constructor of AccountForum class.
	 * 
	 * @type Long
	 * @type Account
	 * @type Forum
	 * 
	 * @param idAccountForum
	 * @param account
	 * @param forum
	 */
	public AccountForum(Long idAccountForum, Account account, Forum forum) {
		this.idAccountForum = idAccountForum;
		this.account = account;
		this.forum = forum;
	}

	/**
	 * @return the idAccountForum
	 */
	public Long getIdAccountForum() {
		return idAccountForum;
	}

	/**
	 * @param idAccountForum
	 *            the idAccountForum to set
	 */
	public void setIdAccountForum(Long idAccountForum) {
		this.idAccountForum = idAccountForum;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
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
	 * @return AccountForum entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idAccountForum.equals(null)) {
			return this.idAccountForum.toString() + " "
					+ this.account.toString() + " " + this.forum.toString();
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
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((forum == null) ? 0 : forum.hashCode());
		result = prime * result
				+ ((idAccountForum == null) ? 0 : idAccountForum.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to AccountForum or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccountForum))
			return false;
		AccountForum other = (AccountForum) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (forum == null) {
			if (other.forum != null)
				return false;
		} else if (!forum.equals(other.forum))
			return false;
		if (idAccountForum == null) {
			if (other.idAccountForum != null)
				return false;
		} else if (!idAccountForum.equals(other.idAccountForum))
			return false;
		return true;
	}
}
