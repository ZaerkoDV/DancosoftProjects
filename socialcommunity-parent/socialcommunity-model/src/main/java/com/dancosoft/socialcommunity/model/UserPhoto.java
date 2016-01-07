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
import javax.validation.constraints.Size;

/**
 * UserPhoto entity describe special characteristics and behavior of User
 * enity.This class contain information about user photo such as photo name,
 * photo note. PhotoName is uniqual digit name. Class UserPhoto have relations
 * (or forigen key which refer on this class): one-to-one with User. All
 * communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * UserPhoto entity. Class implements interface Serializable. For creating
 * UserPhoto model use Hibernate technology (anatations). Class contains
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
@Entity(name = "UserPhoto")
@Table(name = "user_photo")
public class UserPhoto implements Serializable {

	private static final long serialVersionUID = -2663147930612935651L;

	/**
	 * Unique identification number of UserPhoto for entity
	 * UserPhoto.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_photo")
	private Long idUserPhoto;

	/**
	 * Uniqual photo digit name which use for find photo.
	 * 
	 * @type String
	 */
	@Column(name = "photo_name")
	private String photoName;

	/**
	 * Note for photo.
	 * 
	 * @type String
	 */
	@Size(min = 0, max = 30)
	@Column(name = "photo_note")
	private String photoNote;

	/**
	 * User which have this photo.
	 * 
	 * @type User
	 */
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * Empty constructor(default) of UserPhoto class.
	 */
	public UserPhoto() {
	}

	/**
	 * Overloaded constructor of UserPhoto class.
	 * 
	 * @type Long
	 * @type String
	 * @type User
	 * 
	 * @param idUserPhoto
	 * @param photoName
	 * @param photoNote
	 * @param user
	 */
	public UserPhoto(Long idUserPhoto, String photoName, String photoNote,
			User user) {
		this.idUserPhoto = idUserPhoto;
		this.photoName = photoName;
		this.photoNote = photoNote;
		this.user = user;
	}

	/**
	 * @return the idUserPhoto
	 */
	public Long getIdUserPhoto() {
		return idUserPhoto;
	}

	/**
	 * @param idUserPhoto
	 *            the idUserPhoto to set
	 */
	public void setIdUserPhoto(Long idUserPhoto) {
		this.idUserPhoto = idUserPhoto;
	}

	/**
	 * @return the photoName
	 */
	public String getPhotoName() {
		return photoName;
	}

	/**
	 * @param photoName
	 *            the photoName to set
	 */
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	/**
	 * @return the photoNote
	 */
	public String getPhotoNote() {
		return photoNote;
	}

	/**
	 * @param photoNote
	 *            the photoNote to set
	 */
	public void setPhotoNote(String photoNote) {
		this.photoNote = photoNote;
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
	 * @return UserPhoto entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserPhoto.equals(null)) {
			return this.idUserPhoto.toString() + " "
					+ this.photoName.toString() + " "
					+ this.photoNote.toString() + " " + this.user.toString();
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
				+ ((idUserPhoto == null) ? 0 : idUserPhoto.hashCode());
		result = prime * result
				+ ((photoName == null) ? 0 : photoName.hashCode());
		result = prime * result
				+ ((photoNote == null) ? 0 : photoNote.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to UserPhoto or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPhoto other = (UserPhoto) obj;
		if (idUserPhoto == null) {
			if (other.idUserPhoto != null)
				return false;
		} else if (!idUserPhoto.equals(other.idUserPhoto))
			return false;
		if (photoName == null) {
			if (other.photoName != null)
				return false;
		} else if (!photoName.equals(other.photoName))
			return false;
		if (photoNote == null) {
			if (other.photoNote != null)
				return false;
		} else if (!photoNote.equals(other.photoNote))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
}
