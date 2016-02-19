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
 * SingleMessage entity describe single message which user send to other users.
 * This class contain information about message such as message context,date
 * when message create, id interlocutor, id user. Class SingleMessage have
 * relations (or forigen key which refer on this class): meny-to-one with
 * Account(for interlocutor role), meny-to-one with Account(for User role). All
 * communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * SingleMessage entity. Class implements interface Serializable. For creating
 * SingleMessage model use Hibernate technology (anatations). Class contains
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
@Entity(name = "SingleMessage")
@Table(name = "single_message")
public class SingleMessage implements Serializable {

	private static final long serialVersionUID = 2653932138631752467L;

	/**
	 * Unique identification number of SingleMessage for entity SingleMessage.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_single_message")
	private Long idSingleMessage;

	/**
	 * Context of message.
	 * 
	 * @type String
	 */
	@Column(name = "single_message")
	private String singleMessage;

	/**
	 * Date when message create.
	 * 
	 * @type Date
	 */
	@NotNull
	@Column(name = "date_create_single_message")
	private Date dateCreateSingleMessage;

	/**
	 * Account user which use interlocutor role in dialoge.
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "interlocutor_account_id")
	private Account interlocutorAccount;

	/**
	 * Account user which use interlocutor role in dialoge.
	 * 
	 * @type Account
	 */
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	/**
	 * Empty constructor(default) of SingleMessage class.
	 */
	public SingleMessage() {
	}

	/**
	 * Overloaded constructor of SingleMessage class.
	 * 
	 * @type Long
	 * @type String
	 * @type Date
	 * @type Account
	 * 
	 * @param idSingleMessage
	 * @param singleMessage
	 * @param dateCreateSingleMessage
	 * @param interlocutorAccount
	 * @param account
	 */
	public SingleMessage(Long idSingleMessage, String singleMessage,
			Date dateCreateSingleMessage, Account interlocutorAccount,
			Account account) {
		this.idSingleMessage = idSingleMessage;
		this.singleMessage = singleMessage;
		this.dateCreateSingleMessage = dateCreateSingleMessage;
		this.interlocutorAccount = interlocutorAccount;
		this.account = account;
	}

	/**
	 * @return the idSingleMessage
	 */
	public Long getIdSingleMessage() {
		return idSingleMessage;
	}

	/**
	 * @param idSingleMessage
	 *            the idSingleMessage to set
	 */
	public void setIdSingleMessage(Long idSingleMessage) {
		this.idSingleMessage = idSingleMessage;
	}

	/**
	 * @return the singleMessage
	 */
	public String getSingleMessage() {
		return singleMessage;
	}

	/**
	 * @param singleMessage
	 *            the singleMessage to set
	 */
	public void setSingleMessage(String singleMessage) {
		this.singleMessage = singleMessage;
	}

	/**
	 * @return the dateCreateSingleMessage
	 */
	public Date getDateCreateSingleMessage() {
		return dateCreateSingleMessage;
	}

	/**
	 * @param dateCreateSingleMessage
	 *            the dateCreateSingleMessage to set
	 */
	public void setDateCreateSingleMessage(Date dateCreateSingleMessage) {
		this.dateCreateSingleMessage = dateCreateSingleMessage;
	}
	
//	public LocalDateTime getDateCreateSingleMessage() {
//		Instant instant = Instant.ofEpochMilli(dateCreateSingleMessage.getTime());
//		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
//	}
//	
//	public void setDateCreateSingleMessage(LocalDateTime dateCreateSingleMessage) {
//		Instant instant = dateCreateSingleMessage.toInstant(ZoneOffset.UTC);		
//		this.dateCreateSingleMessage = Date.from(instant);
//	}
	
	/**
	 * @return the interlocutorAccount
	 */
	public Account getInterlocutorAccount() {
		return interlocutorAccount;
	}

	/**
	 * @param interlocutorAccount
	 *            the interlocutorAccount to set
	 */
	public void setInterlocutorAccount(Account interlocutorAccount) {
		this.interlocutorAccount = interlocutorAccount;
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
	 * @return SingleMessage entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idSingleMessage.equals(null)) {
			return this.idSingleMessage.toString() + " "
					+ this.singleMessage.toString() + " "
					+ this.dateCreateSingleMessage.toString() + " "
					+ this.interlocutorAccount.toString() + " "
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
				+ ((dateCreateSingleMessage == null) ? 0
						: dateCreateSingleMessage.hashCode());
		result = prime * result
				+ ((idSingleMessage == null) ? 0 : idSingleMessage.hashCode());
		result = prime
				* result
				+ ((interlocutorAccount == null) ? 0 : interlocutorAccount
						.hashCode());
		result = prime * result
				+ ((singleMessage == null) ? 0 : singleMessage.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to SingleMessage or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SingleMessage))
			return false;
		SingleMessage other = (SingleMessage) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (dateCreateSingleMessage == null) {
			if (other.dateCreateSingleMessage != null)
				return false;
		} else if (!dateCreateSingleMessage
				.equals(other.dateCreateSingleMessage))
			return false;
		if (idSingleMessage == null) {
			if (other.idSingleMessage != null)
				return false;
		} else if (!idSingleMessage.equals(other.idSingleMessage))
			return false;
		if (interlocutorAccount == null) {
			if (other.interlocutorAccount != null)
				return false;
		} else if (!interlocutorAccount.equals(other.interlocutorAccount))
			return false;
		if (singleMessage == null) {
			if (other.singleMessage != null)
				return false;
		} else if (!singleMessage.equals(other.singleMessage))
			return false;
		return true;
	}

}
