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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * AccountGroupHistory entity describe user account group. This class contain
 * information about accont group such as date create acount group,date last
 * visit.Class AccontGroupHistory have relations (or forigen key which refer on
 * this class): one-to-one with AccountGroup. All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * AccountGroupHistory entity. Class implements interface Serializable. For
 * creating AccountGroupHistory model use Hibernate technology (anatations).
 * Class contains exclusively no-static public methods that return fields of
 * entity. Methods intended to access object fields.Class also contain overload
 * methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "AccountGroupHistory")
@Table(name = "account_group_history")
public class AccountGroupHistory implements Serializable {

	private static final long serialVersionUID = -2516386454830585870L;

	/**
	 * Unique identification number of AccountGroupHistory for entity
	 * AccountGroupHistory.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account_group_history")
	private Long idAccountGroupHistory;

	/**
	 * Date when accont group create.
	 * 
	 * @type Date
	 */
	@NotNull
	@Column(name = "date_create_group")
	private Date dateCreateGroup;

	/**
	 * Date last visit account group.
	 * 
	 * @type Date
	 */
	@Column(name = "last_visit")
	private Date lastVisit;

	/**
	 * Group which have this history
	 * 
	 * @type Group
	 */
	@OneToOne
	@JoinColumn(name = "group_id")
	private AccountGroup accountGroup;

	/**
	 * Empty constructor(default) of AccountGroupHistory class.
	 */
	public AccountGroupHistory() {
	}

	/**
	 * Overloaded constructor of AccountGroupHistory class.
	 * 
	 * @type Long
	 * @type LocalDateTime
	 * @type AccountGroup
	 * 
	 * @param idAccountGroupHistory
	 * @param dateCreateGroup
	 * @param lastVisit
	 * @param accountGroup
	 */
	public AccountGroupHistory(Long idAccountGroupHistory,
			Date dateCreateGroup, Date lastVisit, AccountGroup accountGroup) {
		this.idAccountGroupHistory = idAccountGroupHistory;
		this.dateCreateGroup = dateCreateGroup;
		this.lastVisit = lastVisit;
		this.accountGroup = accountGroup;
	}

	/**
	 * @return the idAccountGroupHistory
	 */
	public Long getIdAccountGroupHistory() {
		return idAccountGroupHistory;
	}

	/**
	 * @param idAccountGroupHistory
	 *            the idAccountGroupHistory to set
	 */
	public void setIdAccountGroupHistory(Long idAccountGroupHistory) {
		this.idAccountGroupHistory = idAccountGroupHistory;
	}

	/**
	 * @return the dateCreateGroup
	 */
	public Date getDateCreateGroup() {
		return dateCreateGroup;
	}

	/**
	 * @param dateCreateGroup
	 *            the dateCreateGroup to set
	 */
	public void setDateCreateGroup(Date dateCreateGroup) {
		this.dateCreateGroup = dateCreateGroup;
	}
	
//	public LocalDateTime getDateCreateGroup() {
//		Instant instant = Instant.ofEpochMilli(dateCreateGroup.getTime());
//		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
//	}
//	
//	public void setDateCreateGroup(LocalDateTime dateCreateGroup) {
//		Instant instant = dateCreateGroup.toInstant(ZoneOffset.UTC);		
//		this.dateCreateGroup = Date.from(instant);
//	}

	/**
	 * @return the lastVisit
	 */
	public Date getLastVisit() {
		return lastVisit;
	}

	/**
	 * @param lastVisit
	 *            the lastVisit to set
	 */
	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

//	public LocalDateTime getLastVisit() {
//		Instant instant = Instant.ofEpochMilli(lastVisit.getTime());
//		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
//	}
//	
//	public void setLastVisit(LocalDateTime lastVisit) {
//		Instant instant = lastVisit.toInstant(ZoneOffset.UTC);		
//		this.lastVisit = Date.from(instant);
//	}
	
	/**
	 * @return the accountGroup
	 */
	public AccountGroup getAccountGroup() {
		return accountGroup;
	}

	/**
	 * @param accountGroup
	 *            the accountGroup to set
	 */
	public void setAccountGroup(AccountGroup accountGroup) {
		this.accountGroup = accountGroup;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return AccountGroupHistory entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idAccountGroupHistory.equals(null)) {
			return this.idAccountGroupHistory.toString() + " "
					+ this.dateCreateGroup.toString() + " "
					+ this.lastVisit.toString() + " "
					+ this.accountGroup.toString();
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
				+ ((accountGroup == null) ? 0 : accountGroup.hashCode());
		result = prime * result
				+ ((dateCreateGroup == null) ? 0 : dateCreateGroup.hashCode());
		result = prime
				* result
				+ ((idAccountGroupHistory == null) ? 0 : idAccountGroupHistory
						.hashCode());
		result = prime * result
				+ ((lastVisit == null) ? 0 : lastVisit.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to AccountGroupHistory or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccountGroupHistory))
			return false;
		AccountGroupHistory other = (AccountGroupHistory) obj;
		if (accountGroup == null) {
			if (other.accountGroup != null)
				return false;
		} else if (!accountGroup.equals(other.accountGroup))
			return false;
		if (dateCreateGroup == null) {
			if (other.dateCreateGroup != null)
				return false;
		} else if (!dateCreateGroup.equals(other.dateCreateGroup))
			return false;
		if (idAccountGroupHistory == null) {
			if (other.idAccountGroupHistory != null)
				return false;
		} else if (!idAccountGroupHistory.equals(other.idAccountGroupHistory))
			return false;
		if (lastVisit == null) {
			if (other.lastVisit != null)
				return false;
		} else if (!lastVisit.equals(other.lastVisit))
			return false;
		return true;
	}

}
