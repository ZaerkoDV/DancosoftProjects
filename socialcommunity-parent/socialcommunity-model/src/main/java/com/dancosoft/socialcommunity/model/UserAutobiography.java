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
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * UserAutobiography entity describe special characteristics and behavior of
 * User enity.This class contain information about user autobiography such as
 * date birth hobby, short autobiography. Class UserAutobiography have relations
 * (or forigen key which refer on this class): one-to-one with User. All
 * communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * UserAutobiography entity. Class implements interface Serializable. For
 * creating UserCorespondence model use Hibernate technology (anatations). Class
 * contains exclusively no-static public methods that return fields of entity.
 * Methods intended to access object fields.Class also contain overload methods
 * toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * @see LocalDateTime
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "UserAutobiography")
@Table(name = "user_autobiography")
public class UserAutobiography implements Serializable {

	private static final long serialVersionUID = 112441433314630004L;

	/**
	 * Unique identification number of UserAutobiography for entity
	 * UserAutobiography.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_autobiography")
	private Long idUserAutobiography;

	/**
	 * User date birth in formate dd/mm/yyyy. This date must in past.
	 * 
	 * @type Date
	 */
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "birth")
	private Date birth;

	/**
	 * User hobby.
	 * 
	 * @type String
	 */
	@Column(name = "hobby")
	private String hobby;

	/**
	 * User autobiography.
	 * 
	 * @type String
	 */
	@Column(name = "autobiography")
	private String autobiography;

	/**
	 * User which have autobiography.
	 * 
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * Empty constructor(default) of UserAutobiography class.
	 */
	public UserAutobiography() {
	}

	/**
	 * Overloaded constructor of UserAutobiography class.
	 * 
	 * @type Long
	 * @type String
	 * @type LocalDateTime
	 * @type User
	 * 
	 * @param idUserAutobiography
	 * @param birth
	 * @param hobby
	 * @param autobiography
	 * @param user
	 */
	public UserAutobiography(Long idUserAutobiography, Date birth,
			String hobby, String autobiography, User user) {
		this.idUserAutobiography = idUserAutobiography;
		this.birth = birth;
		this.hobby = hobby;
		this.autobiography = autobiography;
		this.user = user;
	}	
	
	/**
	 * @return the idUserAutobiography
	 */
	public Long getIdUserAutobiography() {
		return idUserAutobiography;
	}

	/**
	 * @param idUserAutobiography
	 *            the idUserAutobiography to set
	 */
	public void setIdUserAutobiography(Long idUserAutobiography) {
		this.idUserAutobiography = idUserAutobiography;
	}

	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}
	
	/**
	 * @param birth
	 *            the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
//	public LocalDateTime getBirth() {
//		Instant instant = Instant.ofEpochMilli(birth.getTime());
//		return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
//	}
//	
//	public void setBirth(LocalDateTime birth) {
//		Instant instant = birth.toInstant(ZoneOffset.UTC);		
//		this.birth = Date.from(instant);
//	}

	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * @param hobby
	 *            the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/**
	 * @return the autobiography
	 */
	public String getAutobiography() {
		return autobiography;
	}

	/**
	 * @param autobiography
	 *            the autobiography to set
	 */
	public void setAutobiography(String autobiography) {
		this.autobiography = autobiography;
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
	 * @return UserAutoboigraphy entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserAutobiography.equals(null)) {
			return this.idUserAutobiography.toString() + " "
					+ this.birth.toString() + " " + this.hobby.toString() + " "
					+ this.autobiography.toString() + " "
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
		result = prime * result
				+ ((autobiography == null) ? 0 : autobiography.hashCode());
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime
				* result
				+ ((idUserAutobiography == null) ? 0 : idUserAutobiography
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
	 * @return Boolean true if object belong to UserAutobiography or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserAutobiography))
			return false;
		UserAutobiography other = (UserAutobiography) obj;
		if (autobiography == null) {
			if (other.autobiography != null)
				return false;
		} else if (!autobiography.equals(other.autobiography))
			return false;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (idUserAutobiography == null) {
			if (other.idUserAutobiography != null)
				return false;
		} else if (!idUserAutobiography.equals(other.idUserAutobiography))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
