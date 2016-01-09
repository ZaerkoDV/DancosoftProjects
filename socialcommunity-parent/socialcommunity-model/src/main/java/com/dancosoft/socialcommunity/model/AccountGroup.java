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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

/**
 * AccountGroup entity describe account group. This class contain information
 * about accont group such as group name, view status, group block status.Class
 * AccontGroup have relations (or forigen key which refer on this class):
 * one-to-one with AccountGroupHistory, meny-to-one with Account, one-to-meny
 * with GroupMember. All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * Accountgroup entity. Class implements interface Serializable. For creating
 * AccountGroup model use Hibernate technology (anatations). Class contains
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
@Entity(name = "AccountGroup")
@Table(name = "account_group")
public class AccountGroup implements Serializable {

	private static final long serialVersionUID = -8020917819030526925L;

	/**
	 * Unique identification number of AccountGroup for entity AccountGroup.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_group")
	private Long idAccountGroup;

	/**
	 * Account group name
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "group_name")
	private String groupName;

	/**
	 * Account group view status(public/private).
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "view_status")
	@Type(type = "org.hibernate.type.StringType")//columnDefinition = "varchar(45)
	@ColumnDefault("public")					 //default 'public'"
	private String viewStatus;

	/**
	 * Account group block status.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "account_group_block_status")
	@Type(type = "org.hibernate.type.StringType")//columnDefinition = "varchar(45)
	@ColumnDefault("unblock")					//default 'unblock'"
	private String accountGroupBlockStatus;

	/**
	 * Date last visit account.
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	/**
	 * Empty constructor(default) of AccountGroup class.
	 */
	public AccountGroup() {
	}

	/**
	 * Overloaded constructor of AccountGroup class.
	 * 
	 * @type Long
	 * @type String
	 * @type Account
	 * 
	 * @param idAccountGroup
	 * @param groupName
	 * @param viewStatus
	 * @param accountGroupBlockStatus
	 * @param account
	 */
	public AccountGroup(Long idAccountGroup, String groupName,
			String viewStatus, String accountGroupBlockStatus, Account account) {
		this.idAccountGroup = idAccountGroup;
		this.groupName = groupName;
		this.accountGroupBlockStatus = accountGroupBlockStatus;
		this.account = account;
	}

	/**
	 * @return the idAccountGroup
	 */
	public Long getIdAccountGroup() {
		return idAccountGroup;
	}

	/**
	 * @param idAccountGroup
	 *            the idAccountGroup to set
	 */
	public void setIdAccountGroup(Long idAccountGroup) {
		this.idAccountGroup = idAccountGroup;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the viewStatus
	 */
	public String getViewStatus() {
		return viewStatus;
	}

	/**
	 * @param viewStatus
	 *            the viewStatus to set
	 */
	public void setViewStatus(String viewStatus) {
		this.viewStatus = viewStatus;
	}

	/**
	 * @return the accountGroupBlockStatus
	 */
	public String getAccountGroupBlockStatus() {
		return accountGroupBlockStatus;
	}

	/**
	 * @param accountGroupBlockStatus
	 *            the accountGroupBlockStatus to set
	 */
	public void setAccountGroupBlockStatus(String accountGroupBlockStatus) {
		this.accountGroupBlockStatus = accountGroupBlockStatus;
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
	 * @return AccountGroup entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idAccountGroup.equals(null)) {
			return this.idAccountGroup.toString() + " "
					+ this.groupName.toString() + " "
					+ this.viewStatus.toString() + " "
					+ this.accountGroupBlockStatus.toString() + " "
					+ this.account;
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
				+ ((accountGroupBlockStatus == null) ? 0
						: accountGroupBlockStatus.hashCode());
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result
				+ ((idAccountGroup == null) ? 0 : idAccountGroup.hashCode());
		result = prime * result
				+ ((viewStatus == null) ? 0 : viewStatus.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to AccountGroup or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AccountGroup))
			return false;
		AccountGroup other = (AccountGroup) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (accountGroupBlockStatus == null) {
			if (other.accountGroupBlockStatus != null)
				return false;
		} else if (!accountGroupBlockStatus
				.equals(other.accountGroupBlockStatus))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (idAccountGroup == null) {
			if (other.idAccountGroup != null)
				return false;
		} else if (!idAccountGroup.equals(other.idAccountGroup))
			return false;
		if (viewStatus == null) {
			if (other.viewStatus != null)
				return false;
		} else if (!viewStatus.equals(other.viewStatus))
			return false;
		return true;
	}

}
