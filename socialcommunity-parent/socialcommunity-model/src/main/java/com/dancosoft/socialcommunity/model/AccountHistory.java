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
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * AccountHistory entity describe user account. This class contain information about
 * accont such as date create acount,date last visit.Class AccontHistory have
 * relations (or forigen key which refer on this class): one-to-one with
 * Account. All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description AccountHistory
 * entity. Class implements interface Serializable. For creating AccountHistory model
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
@Entity(name = "AccountHistory")
@Table(name = "account_history")
public class AccountHistory implements Serializable {

	private static final long serialVersionUID = -1239075034223092109L;

	/**
	 * Unique identification number of AccountHistory for entity AccountHistory.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account_history")
	private Long idAccountHistory;

	/**
	 * Date when accont create.
	 * 
	 * @type Date
	 */
	@NotNull
	@Column(name = "date_creat_account")
	private Date dateCreateAccount;

	/**
	 * Date last visit account.
	 * 
	 * @type LocalDateTime
	 */
	@Column(name = "last_visit")
	private Date lastVisit;

	/**
	 * Account which have this history
	 * 
	 * @type Account
	 */
	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;

	/**
	 * Empty constructor(default) of AccountHistory class.
	 */
	public AccountHistory() {
	}

	/**
	 * Overloaded constructor of AccountHistory class.
	 * 
	 * @type Long
	 * @type Date
	 * @type Account
	 * 
	 * @param idAccountHistory
	 * @param dateCreateAccount
	 * @param lastVisit
	 * @param account
	 */
	public AccountHistory(Long idAccountHistory, Date dateCreateAccount,
			Date lastVisit, Account account) {
		this.idAccountHistory = idAccountHistory;
		this.dateCreateAccount = dateCreateAccount;
		this.lastVisit = lastVisit;
		this.account = account;
	}

	/**
	 * @return the idAccountHistory
	 */
	public Long getIdAccountHistory() {
		return idAccountHistory;
	}

	/**
	 * @param idAccountHistory
	 *            the idAccountHistory to set
	 */
	public void setIdAccountHistory(Long idAccountHistory) {
		this.idAccountHistory = idAccountHistory;
	}

//	/**
//	 * @return the dateCreateAccount
//	 */
//	public Date getDateCreateAccount() {
//		return dateCreateAccount;
//	}
//
//	/**
//	 * @param dateCreateAccount
//	 *            the dateCreateAccount to set
//	 */
//	public void setDateCreateAccount(Date dateCreateAccount) {
//		this.dateCreateAccount = dateCreateAccount;
//	}
	
	public LocalDateTime getDateCreateAccount() {
		Instant instant = Instant.ofEpochMilli(dateCreateAccount.getTime());
		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
	}
	
	public void setDateCreateAccount(LocalDateTime dateCreateAccount) {
		Instant instant = dateCreateAccount.toInstant(ZoneOffset.UTC);		
		this.dateCreateAccount = Date.from(instant);
	}

//	/**
//	 * @return the dateLastVisit
//	 */
//	public Date getLastVisit() {
//		return lastVisit;
//	}
//
//	/**
//	 * @param dateLastVisit
//	 *            the dateLastVisit to set
//	 */
//	public void setLastVisit(Date lastVisit) {
//		this.lastVisit = lastVisit;
//	}

	public LocalDateTime getLastVisit() {
		Instant instant = Instant.ofEpochMilli(lastVisit.getTime());
		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
	}
	
	public void setLastVisit(LocalDateTime lastVisit) {
		Instant instant = lastVisit.toInstant(ZoneOffset.UTC);		
		this.lastVisit = Date.from(instant);
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
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return AccountHistory entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idAccountHistory.equals(null)) {
			return this.idAccountHistory.toString() + " "
					+ this.dateCreateAccount.toString() + " "
					+ this.lastVisit.toString() + " "
					+ this.account.toString();
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
		result = prime
				* result
				+ ((dateCreateAccount == null) ? 0 : dateCreateAccount
						.hashCode());
		result = prime * result
				+ ((lastVisit == null) ? 0 : lastVisit.hashCode());
		result = prime
				* result
				+ ((idAccountHistory == null) ? 0 : idAccountHistory.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to AccountHistory or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccountHistory))
			return false;
		AccountHistory other = (AccountHistory) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (dateCreateAccount == null) {
			if (other.dateCreateAccount != null)
				return false;
		} else if (!dateCreateAccount.equals(other.dateCreateAccount))
			return false;
		if (lastVisit == null) {
			if (other.lastVisit != null)
				return false;
		} else if (!lastVisit.equals(other.lastVisit))
			return false;
		if (idAccountHistory == null) {
			if (other.idAccountHistory != null)
				return false;
		} else if (!idAccountHistory.equals(other.idAccountHistory))
			return false;
		return true;
	}

}
