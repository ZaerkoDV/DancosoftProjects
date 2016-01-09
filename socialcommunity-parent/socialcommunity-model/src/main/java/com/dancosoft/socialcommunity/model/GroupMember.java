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
 * GroupMember entity describe group member(account) which belong to special
 * account group. This class contain information about accont group such as id
 * account which belog to this group, member status(with respect to the creator
 * of the group).Class Groupmember have relations (or forigen key which refer on
 * this class): meny-to-one with AccountGroup, meny-to-one with Account. All
 * communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * GroupMember entity. Class implements interface Serializable. For creating
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
@Entity(name = "GroupMember")
@Table(name = "group_member")
public class GroupMember implements Serializable {

	private static final long serialVersionUID = -4058616864381015496L;

	/**
	 * Unique identification number of GroupMember for entity GroupMember.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_group_member")
	private Long idGroupMember;

	/**
	 * Member of group status(friend/no friend)
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "group_members_status")
	@Type(type = "org.hibernate.type.StringType")//columnDefinition = "varchar(45)
	@ColumnDefault("notfriend")					 //default 'notfriend'"
	private String groupMemberStatus;

	/**
	 * Group which contain this member(account)
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "group_id")
	private AccountGroup accountGroup;

	/**
	 * Member(account) which belong to group
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "member_account_id")
	private Account memberAccount;

	/**
	 * Empty constructor(default) of GroupMember class.
	 */
	public GroupMember() {
	}

	/**
	 * Overloaded constructor of GroupMember class.
	 * 
	 * @type Long
	 * @type String
	 * @type Account
	 * 
	 * @param idGroupMember
	 * @param groupMemberStatus
	 * @param accountGroup
	 * @param memberAccount
	 */
	public GroupMember(Long idGroupMember, String groupMemberStatus,
			AccountGroup accountGroup, Account memberAccount) {
		this.idGroupMember = idGroupMember;
		this.groupMemberStatus = groupMemberStatus;
		this.accountGroup = accountGroup;
		this.memberAccount = memberAccount;
	}

	/**
	 * @return the idGroupMember
	 */
	public Long getIdGroupMember() {
		return idGroupMember;
	}

	/**
	 * @param idGroupMember
	 *            the idGroupMember to set
	 */
	public void setIdGroupMember(Long idGroupMember) {
		this.idGroupMember = idGroupMember;
	}

	/**
	 * @return the groupMemberStatus
	 */
	public String getGroupMemberStatus() {
		return groupMemberStatus;
	}

	/**
	 * @param groupMemberStatus
	 *            the groupMemberStatus to set
	 */
	public void setGroupMemberStatus(String groupMemberStatus) {
		this.groupMemberStatus = groupMemberStatus;
	}

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
	 * @return the account
	 */
	public Account getMemberAccount() {
		return memberAccount;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setMemberAccount(Account memberAccount) {
		this.memberAccount = memberAccount;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return GroupMember entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idGroupMember.equals(null)) {
			return this.idGroupMember.toString() + " "
					+ this.groupMemberStatus.toString() + " "
					+ this.accountGroup.toString() + " "
					+ this.memberAccount.toString();
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
				+ ((memberAccount == null) ? 0 : memberAccount.hashCode());
		result = prime * result
				+ ((accountGroup == null) ? 0 : accountGroup.hashCode());
		result = prime
				* result
				+ ((groupMemberStatus == null) ? 0 : groupMemberStatus
						.hashCode());
		result = prime * result
				+ ((idGroupMember == null) ? 0 : idGroupMember.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to GroupMember or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GroupMember))
			return false;
		GroupMember other = (GroupMember) obj;
		if (memberAccount == null) {
			if (other.memberAccount != null)
				return false;
		} else if (!memberAccount.equals(other.memberAccount))
			return false;
		if (accountGroup == null) {
			if (other.accountGroup != null)
				return false;
		} else if (!accountGroup.equals(other.accountGroup))
			return false;
		if (groupMemberStatus == null) {
			if (other.groupMemberStatus != null)
				return false;
		} else if (!groupMemberStatus.equals(other.groupMemberStatus))
			return false;
		if (idGroupMember == null) {
			if (other.idGroupMember != null)
				return false;
		} else if (!idGroupMember.equals(other.idGroupMember))
			return false;
		return true;
	}

}
