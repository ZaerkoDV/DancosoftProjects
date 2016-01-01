/**
 * @package com.dancosoft.socialcommunity.model
 * 
 * The package com.dancosoft.socialcommunity.model contain set of class which description
 * basic essence in SocialCommunity  project.The project is based on MVC architecture.
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

import org.hibernate.validator.constraints.Email;

/**
 * UserEmail entity describe special characteristics and behavior of
 * UserCorespondence enity.This class contain information about user
 * corespondence such as email address. Class UserEmail have relations (or
 * forigen key which refer on this class): one-to-one with UserCorespondence.
 * All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * UserEmail entity. Class implements interface Serializable. For creating
 * UserEmail model use Hibernate technology (anatations). Class contains
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
@Entity(name = "UserEmail")
@Table(name = "user_email")
public class UserEmail implements Serializable {

	private static final long serialVersionUID = -2940143093943583365L;

	/**
	 * Unique identification number of UserEmail for entity UserEmail.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_email")
	private Long idUserEmail;

	/**
	 * Email address for User
	 * 
	 * @type String
	 */
	@NotNull
	@Email
	@Column(name = "user_email")
	private String userEmail;

	/**
	 * User corespondence which contain email as part of corespondence.
	 * 
	 * @type UserCorespondence
	 */
	@OneToOne
	@JoinColumn(name = "user_corespondence_id")
	private UserCorespondence userCorespondence;

	/**
	 * Empty constructor(default) of UserEmail class.
	 */
	public UserEmail() {
	}

	/**
	 * Overloaded constructor of UserEmail class.
	 * 
	 * @type Long
	 * @type String
	 * @type UserCorespondence
	 * 
	 * @param idUserEmail
	 * @param userEmail
	 * @param userCorespondence
	 */
	public UserEmail(Long idUserEmail, String userEmail,
			UserCorespondence userCorespondence) {
		this.idUserEmail = idUserEmail;
		this.userEmail = userEmail;
		this.userCorespondence = userCorespondence;
	}

	/**
	 * @return the idUserEmail
	 */
	public Long getIdUserEmail() {
		return idUserEmail;
	}

	/**
	 * @param idUserEmail
	 *            the idUserEmail to set
	 */
	public void setIdUserEmail(Long idUserEmail) {
		this.idUserEmail = idUserEmail;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userCorespondence
	 */
	public UserCorespondence getUserCorespondence() {
		return userCorespondence;
	}

	/**
	 * @param userCorespondence
	 *            the userCorespondence to set
	 */
	public void setUserCorespondence(UserCorespondence userCorespondence) {
		this.userCorespondence = userCorespondence;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return UserEmail entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserEmail.equals(null)) {
			return this.idUserEmail.toString() + " "
					+ this.userEmail.toString() + " "
					+ this.userCorespondence.toString();
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
				+ ((idUserEmail == null) ? 0 : idUserEmail.hashCode());
		result = prime
				* result
				+ ((userCorespondence == null) ? 0 : userCorespondence
						.hashCode());
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to UserEmail or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEmail other = (UserEmail) obj;
		if (idUserEmail == null) {
			if (other.idUserEmail != null)
				return false;
		} else if (!idUserEmail.equals(other.idUserEmail))
			return false;
		if (userCorespondence == null) {
			if (other.userCorespondence != null)
				return false;
		} else if (!userCorespondence.equals(other.userCorespondence))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		return true;
	}

}
