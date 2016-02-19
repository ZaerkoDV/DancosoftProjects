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

import org.apache.commons.codec.digest.DigestUtils;

/**
 * UserSecurity entity describe special characteristics and behavior of User
 * enity.This class contain information about user such as login and password.
 * Login and password encrypted with md5 algoritm. Class UserSecurity have
 * relations (or forigen key which refer on this class): one-to-one with User,
 * one-to-one with SecurityPrompt, one-to-one with UserRole. All communication
 * is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * UserSecurity entity. Class implements interface Serializable. For creating
 * UserSecurity model use Hibernate technology (anatations). Class contains
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
@Entity(name = "UserSecurity")
@Table(name = "user_security")
public class UserSecurity implements Serializable {

	private static final long serialVersionUID = -6295821116790196788L;

	/**
	 * Unique identification number of UserSecurity for entity UserSecurity.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_security")
	private Long idUserSecurity;

	/**
	 * Login for entity User.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "user_login")
	private String userLogin;

	/**
	 * Password for entity User.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "user_password")
	private String userPassword;

	/**
	 * User which belong login and password.
	 * 
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * UserRole which have user in system.
	 * 
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;

	/**
	 * Empty constructor(default) of UserSecurity class.
	 */
	public UserSecurity() {
	}

	/**
	 * Overloaded constructor of UserSecurity class.
	 * 
	 * @type Long
	 * @type String
	 * @type User
	 * @type UserRole
	 * 
	 * @param idUserSecurity
	 * @param userLogin
	 * @param userPassword
	 * @param user
	 * @param userRole
	 */
	public UserSecurity(Long idUserSecurity, String userLogin,String userPassword, User user, UserRole userRole) {
		this.idUserSecurity = idUserSecurity;
		this.userLogin = userLogin;
		this.userPassword = userPassword;
		this.user = user;
		this.userRole = userRole;
	}

	/**
	 * @return the idUserSecurity
	 */
	public Long getIdUserSecurity() {
		return idUserSecurity;
	}

	/**
	 * @param idUserSecurity
	 *            the idUserSecurity to set
	 */
	public void setIdUserSecurity(Long idUserSecurity) {
		this.idUserSecurity = idUserSecurity;
	}

	/**
	 * @return the userLogin
	 */
	public String getUserLogin() {
		return userLogin;
	}

	/**
	 * @param userLogin
	 *            the userLogin to set
	 */
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword
	 *            the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		//this.userPassword= DigestUtils.md5Hex(userPassword);
		this.userPassword = userPassword;
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
	 * @return the userRole
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return UserSecurity entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserSecurity.equals(null)) {
			return this.idUserSecurity.toString() + " "
					+ this.userLogin.toString() + " "
					+ this.userPassword.toString() + " " + this.user.toString()
					+ " " + this.userRole.toString();
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
				+ ((idUserSecurity == null) ? 0 : idUserSecurity.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((userLogin == null) ? 0 : userLogin.hashCode());
		result = prime * result
				+ ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result
				+ ((userRole == null) ? 0 : userRole.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to UserSecurity or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSecurity other = (UserSecurity) obj;
		if (idUserSecurity == null) {
			if (other.idUserSecurity != null)
				return false;
		} else if (!idUserSecurity.equals(other.idUserSecurity))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userLogin == null) {
			if (other.userLogin != null)
				return false;
		} else if (!userLogin.equals(other.userLogin))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}
	
	/**
	 * Calculates the MD5 digest and returns the value as a 32 character hex string.
	 * 
	 * @type String
	 * @param unconfirm
	 * @return Calculates the MD5 digest and returns the value as a 32 character hex string. 
	 */
	public String convertToMD5(String unconfirm){
		return DigestUtils.md5Hex(unconfirm);
	}

}
