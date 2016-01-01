/**
 * @package com.dancosoft.socialcommunity.model
 * 
 * The package com.dancosoft.socialcommunity.model contain set of class which description
 * basic essence in Reducer Links project.The project is based on MVC architecture.
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

/**
 * UserLocation entity describe special characteristics and behavior of User
 * enity.This class contain information about user location such as language
 * which user use to speak,city and countrty where he live. Class UserLocation
 * have following (forigen key)fields which refer on this class: one-to-one with
 * User. All communication is one-way. User must have only one location.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * UserLocation entity. Class implements interface Serializable. For creating
 * UserLocation model use Hibernate technology (anatations). Class contains
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
@Entity(name = "UserLocation")
@Table(name = "user_location")
public class UserLocation implements Serializable {

	private static final long serialVersionUID = 8103248379411542237L;

	/**
	 * Unique identification number of UserLocation for entity UserLocation.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_location")
	private Long idUserLocation;

	/**
	 * User which have this location.
	 * 
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * User city.
	 * 
	 * @type City
	 */
	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	/**
	 * User language(default endlish).
	 * 
	 * @type Language
	 */
	@OneToOne
	@JoinColumn(name = "language_id")
	private Language language;

	/**
	 * Empty constructor(default) of UserLocation class.
	 */
	public UserLocation() {
	}

	/**
	 * Overloaded constructor of UserLocation class.
	 * 
	 * @type Long
	 * @type User
	 * @type City
	 * @type Language
	 * 
	 * @param idUserLocation
	 * @param user
	 * @param city
	 * @param language
	 */
	public UserLocation(Long idUserLocation, User user, City city,
			Language language) {
		this.idUserLocation = idUserLocation;
		this.user = user;
		this.city = city;
		this.language = language;
	}

	/**
	 * @return the idUserLocation
	 */
	public Long getIdUserLocation() {
		return idUserLocation;
	}

	/**
	 * @param idUserLocation
	 *            the idUserLocation to set
	 */
	public void setIdUserLocation(Long idUserLocation) {
		this.idUserLocation = idUserLocation;
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
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return UserLocation entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserLocation.equals(null)) {
			return this.idUserLocation.toString() + " " + this.user.toString()
					+ " " + this.city.toString() + " "
					+ this.language.toString();
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((idUserLocation == null) ? 0 : idUserLocation.hashCode());
		result = prime * result
				+ ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to UserLocation or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserLocation))
			return false;
		UserLocation other = (UserLocation) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (idUserLocation == null) {
			if (other.idUserLocation != null)
				return false;
		} else if (!idUserLocation.equals(other.idUserLocation))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
