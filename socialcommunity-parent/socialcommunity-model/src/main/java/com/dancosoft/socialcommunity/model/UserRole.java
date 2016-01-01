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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

/**
 * UserRole entity describe special characteristics and behavior of UserSecurity
 * enity.This class contain information about user such as role in system. User
 * mast have one of roles.There is user or admin Class UserRole have relations
 * (or forigen key which refer on this class): one-to-one with UserSecurity, All
 * communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description UserRole
 * entity. Class implements interface Serializable. For creating UserRole model
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
@Entity(name = "UserRole")
@Table(name = "user_roles")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Unique identification number of UserRole for entity UserRole.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_role")
	private Long idUserRole;

	/**
	 * UserRole for entity User.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "user_role")
	@Type(type = "org.hibernate.type.StringType")//columnDefinition = "varchar(255)
	@ColumnDefault("user")						 //default 'user'"
	private String userRoleName;

	/**
	 * Empty constructor(default) of UserRole class.
	 */
	public UserRole() {
	}

	/**
	 * Overloaded constructor of UserRole class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idUserRole
	 * @param userRole
	 */
	public UserRole(Long idUserRole, String userRoleName) {
		this.idUserRole = idUserRole;
		this.userRoleName = userRoleName;
	}

	/**
	 * @return the idUserRole
	 */
	public Long getIdUserRole() {
		return idUserRole;
	}

	/**
	 * @param idUserRole
	 *            the idUserRole to set
	 */
	public void setIdUserRole(Long idUserRole) {
		this.idUserRole = idUserRole;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return UserRole entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserRole.equals(null)) {
			return this.idUserRole.toString() + " " + this.userRoleName.toString();
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
				+ ((idUserRole == null) ? 0 : idUserRole.hashCode());
		result = prime * result
				+ ((userRoleName == null) ? 0 : userRoleName.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to UserRole or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (idUserRole == null) {
			if (other.idUserRole != null)
				return false;
		} else if (!idUserRole.equals(other.idUserRole))
			return false;
		if (userRoleName == null) {
			if (other.userRoleName != null)
				return false;
		} else if (!userRoleName.equals(other.userRoleName))
			return false;
		return true;
	}

}
