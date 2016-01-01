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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

/**
 * UserCorespodence entity describe special characteristics and behavior of User
 * enity.This class contain information about user corespondence such as
 * status(private or public) email address and social networks address. Class
 * UserCorespodence have relations (or forigen key which refer on this class):
 * meny-to-one with User, one-to-one UserEmail,one-to-one UserSocialNetwork All
 * communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * UserCorespondence entity. Class implements interface Serializable. For
 * creating UserCorespondence model use Hibernate technology (anatations). Class
 * contains exclusively no-static public methods that return fields of entity.
 * Methods intended to access object fields.Class also contain overload methods
 * toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "UserCorespondence")
@Table(name = "user_corespondence")
public class UserCorespondence implements Serializable {

	private static final long serialVersionUID = 7475285250779929893L;

	/**
	 * Unique identification number of UserCorespondence for entity
	 * UserCorespondence.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_corespondence")
	private Long idUserCorespondence;

	/**
	 * User may change view status his corespondence. Corespondence may view
	 * status public or private
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "corespondence_view_status")
	@Type(type = "org.hibernate.type.StringType")//columnDefinition = "varchar(255)
	@ColumnDefault("public")					 // default 'public'"
	private String corespondenceViewStatus;

	/**
	 * User which have corespondence.
	 * 
	 * @type User
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * Empty constructor(default) of UserCorespondence class.
	 */
	public UserCorespondence() {
	}

	/**
	 * Overloaded constructor of UserCorespondence class.
	 * 
	 * @type Long
	 * @type String
	 * @type User
	 * 
	 * @param idUserCorespondence
	 * @param corespondenceViewStatus
	 * @param user
	 */
	public UserCorespondence(Long idUserCorespondence,
			String corespondenceViewStatus, User user) {
		this.idUserCorespondence = idUserCorespondence;
		this.corespondenceViewStatus = corespondenceViewStatus;
		this.user = user;
	}

	/**
	 * @return the idUserCorespondence
	 */
	public Long getIdUserCorespondence() {
		return idUserCorespondence;
	}

	/**
	 * @param idUserCorespondence
	 *            the idUserCorespondence to set
	 */
	public void setIdUserCorespondence(Long idUserCorespondence) {
		this.idUserCorespondence = idUserCorespondence;
	}

	/**
	 * @return the corespondenceViewStatus
	 */
	public String getCorespondenceViewStatus() {
		return corespondenceViewStatus;
	}

	/**
	 * @param corespondenceViewStatus
	 *            the corespondenceViewStatus to set
	 */
	public void setCorespondenceViewStatus(String corespondenceViewStatus) {
		this.corespondenceViewStatus = corespondenceViewStatus;
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
	 * @return UserCorespondence entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserCorespondence.equals(null)) {
			return this.idUserCorespondence.toString() + " "
					+ this.corespondenceViewStatus.toString() + " "
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
				+ ((corespondenceViewStatus == null) ? 0
						: corespondenceViewStatus.hashCode());
		result = prime
				* result
				+ ((idUserCorespondence == null) ? 0 : idUserCorespondence
						.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to UserCorespondence or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCorespondence other = (UserCorespondence) obj;
		if (corespondenceViewStatus == null) {
			if (other.corespondenceViewStatus != null)
				return false;
		} else if (!corespondenceViewStatus
				.equals(other.corespondenceViewStatus))
			return false;
		if (idUserCorespondence == null) {
			if (other.idUserCorespondence != null)
				return false;
		} else if (!idUserCorespondence.equals(other.idUserCorespondence))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
