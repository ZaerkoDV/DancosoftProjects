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
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

/**
 * User entity describe base characteristics and behavior of user enity.This
 * class is basic for all user in system (user may not have account but must
 * have information about yoursalfe).This class contain base information about
 * user such as first name, last name, middle name, gender.Class user have
 * relations(or forigen key which refer on this class): one-to-one with account,
 * one-to-one with UserSecurity, one-to-many with UserCorespodence, one-to-one
 * with UserPhoto,one-to-one with UserAutobiography,one-to-one with
 * UserLocation. All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description User
 * entity. Class implements interface Serializable. For creating User model use
 * Hibernate technology (anatations). Class contains exclusively no-static
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
@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 5034826449908765931L;

	/**
	 * Unique identification number of user for entity user.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long idUser;

	/**
	 * User first name for entity user..
	 * 
	 * @type String
	 */
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "first_name")
	private String firstName;

	/**
	 * User last name for entity user.
	 * 
	 * @type String
	 */
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "last_name")
	private String lastName;

	/**
	 * User middle name for entity user(colume:middle_name type:text).
	 * 
	 * @type String
	 */
	@Size(min = 0, max = 25)
	@Column(name = "middle_name")
	private String middleName;

	/**
	 * User gender for entity user.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "sex")
	@Type(type = "org.hibernate.type.StringType")//, nullable = false,columnDefinition = "VARCHAR(1)"
	private String sex;

	/**
	 * Empty constructor(default) of User class.
	 */
	public User() {
	}

	/**
	 * Overloaded constructor of User class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idUser
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param sex
	 */
	public User(Long idUser, String firstName, String lastName,
			String middleName, String sex) {
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.sex = sex;
	}

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the gender
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return User entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUser.equals(null)) {
			return this.idUser.toString() + " " + this.firstName + " "
					+ this.lastName + " " + this.middleName + " " + this.sex;
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
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to User or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		return true;
	}

}
