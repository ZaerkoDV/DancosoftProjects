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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;


/**
 * Account entity describe user account. This class contain information about
 * accont such as account name, block status(block/unblock).Class Accont have
 * relations (or forigen key which refer on this class): one-to-one with
 * AccountHistory, one-to-meny with Single Message(for user role), one-to-meny
 * with Single Message(for interlocutor role),one-to-one with User. All
 * communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description Account
 * entity. Class implements interface Serializable. For creating Account model
 * use Hibernate technology (anatations). Class contains exclusively no-static
 * public methods that return fields of entity. Methods intended to access
 * object fields.Class also contain overload methods toString(), hashCode(),
 * equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "Account")
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1630597814422471782L;

	/**
	 * Unique identification number of Account for entity Account.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private Long idAccount;

	/**
	 * Account name
	 * 
	 * @type String
	 */
	@NotNull
	@Size(min = 5, max = 25)
	@Column(name = "account_name")
	private String accountName;

	/**
	 * Account block status. Admin have right change block status on
	 * (block/unblock)
	 * 
	 * @type String
	 */
	@Column(name = "account_block_status")
	@Type(type = "org.hibernate.type.StringType")//columnDefinition = "varchar(45)
	@ColumnDefault("unblock")					//default 'unblock'"
	private String accountBlockStatus;

	/**
	 * User which have account
	 * 
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * Empty constructor(default) of Account class.
	 */
	public Account() {
	}

	/**
	 * Overloaded constructor of account class.
	 * 
	 * @type Long
	 * @type String
	 * @type User
	 * 
	 * @param idAccount
	 * @param accountName
	 * @param accountBlockStatus
	 * @param user
	 */
	public Account(Long idAccount, String accountName,
			String accountBlockStatus, User user) {
		this.idAccount = idAccount;
		this.accountName = accountName;
		this.accountBlockStatus = accountBlockStatus;
		this.user = user;
	}

	/**
	 * @return the idAccount
	 */
	public Long getIdAccount() {
		return idAccount;
	}

	/**
	 * @param idAccount
	 *            the idAccount to set
	 */
	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the accountBlockStatus
	 */
	public String getAccountBlockStatus() {
		return accountBlockStatus;
	}

	/**
	 * @param accountBlockStatus
	 *            the accountBlockStatus to set
	 */
	public void setAccountBlockStatus(String accountBlockStatus) {
		this.accountBlockStatus = accountBlockStatus;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return Account entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idAccount.equals(null)) {
			return this.idAccount.toString() + " "
					+ this.accountName.toString() + " "
					+ this.accountBlockStatus.toString() + " "
					+ this.user.toString();
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
				+ ((accountBlockStatus == null) ? 0 : accountBlockStatus
						.hashCode());
		result = prime * result
				+ ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result
				+ ((idAccount == null) ? 0 : idAccount.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to Account or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (accountBlockStatus == null) {
			if (other.accountBlockStatus != null)
				return false;
		} else if (!accountBlockStatus.equals(other.accountBlockStatus))
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (idAccount == null) {
			if (other.idAccount != null)
				return false;
		} else if (!idAccount.equals(other.idAccount))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
