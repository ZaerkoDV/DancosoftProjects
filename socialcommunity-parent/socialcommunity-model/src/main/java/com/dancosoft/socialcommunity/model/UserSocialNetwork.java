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

/**
 * UserSocialNetwork entity describe special characteristics and behavior of
 * UserCorespondence enity.This class contain information about user
 * corespondence such as skype address and facebook address. Class
 * UserSocialNetwork have relations (or forigen key which refer on this class):
 * one-to-one with UserCorspondence. All communication is one-way.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description
 * UserSocialNetwork entity. Class implements interface Serializable. For
 * creating UserSocialNetwork model use Hibernate technology (anatations). Class
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
@Entity(name = "UserSocialNetwork")
@Table(name = "user_social_network")
public class UserSocialNetwork implements Serializable {

	private static final long serialVersionUID = -3300071014183871745L;

	/**
	 * Unique identification number of UserSocialNetwork for entity
	 * UserSocialNetwork.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_social_network")
	private Long idUserSocialNetwork;

	/**
	 * Facebook address for User
	 * 
	 * @type String
	 */
	@Column(name = "facebook_address")
	private String facebookAddress;

	/**
	 * Skype address for User
	 * 
	 * @type String
	 */
	@Column(name = "skype_address")
	private String skypeAddress;

	/**
	 * User corespondence which contain skype and facebook address as part of
	 * corespondence.
	 * 
	 * @type UserCorespondence
	 */
	@OneToOne
	@JoinColumn(name = "user_corespondence_id")
	private UserCorespondence userCorespondence;

	/**
	 * Empty constructor(default) of UserSocialNetwork class.
	 */
	public UserSocialNetwork() {
	}

	/**
	 * Overloaded constructor of UserSocialNetwork class.
	 * 
	 * @type Long
	 * @type String
	 * @type UserCorespondence
	 * 
	 * @param idUserSocialNetwork
	 * @param facebookAddress
	 * @param skypeAddress
	 * @param userCorespondence
	 */
	public UserSocialNetwork(Long idUserSocialNetwork, String facebookAddress,
			String skypeAddress, UserCorespondence userCorespondence) {
		this.idUserSocialNetwork = idUserSocialNetwork;
		this.skypeAddress = skypeAddress;
		this.facebookAddress = facebookAddress;
		this.userCorespondence = userCorespondence;
	}

	/**
	 * @return the idUserSocialNetwork
	 */
	public Long getIdUserSocialNetwork() {
		return idUserSocialNetwork;
	}

	/**
	 * @param idUserSocialNetwork
	 *            the idUserSocialNetwork to set
	 */
	public void setIdUserSocialNetwork(Long idUserSocialNetwork) {
		this.idUserSocialNetwork = idUserSocialNetwork;
	}

	/**
	 * @return the skypeAddress
	 */
	public String getSkypeAddress() {
		return skypeAddress;
	}

	/**
	 * @param skypeAddress
	 *            the skypeAddress to set
	 */
	public void setSkypeAddress(String skypeAddress) {
		this.skypeAddress = skypeAddress;
	}

	/**
	 * @return the facebookAddress
	 */
	public String getFacebookAddress() {
		return facebookAddress;
	}

	/**
	 * @param facebookAddress
	 *            the facebookAddress to set
	 */
	public void setFacebookAddress(String facebookAddress) {
		this.facebookAddress = facebookAddress;
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
	 * @return UserSocialNetwork entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idUserSocialNetwork.equals(null)) {
			return this.idUserSocialNetwork.toString() + " "
					+ this.skypeAddress.toString() + " "
					+ this.facebookAddress.toString() + " "
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
				+ ((facebookAddress == null) ? 0 : facebookAddress.hashCode());
		result = prime
				* result
				+ ((idUserSocialNetwork == null) ? 0 : idUserSocialNetwork
						.hashCode());
		result = prime * result
				+ ((skypeAddress == null) ? 0 : skypeAddress.hashCode());
		result = prime
				* result
				+ ((userCorespondence == null) ? 0 : userCorespondence
						.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to UserSocialNetwork or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserSocialNetwork))
			return false;
		UserSocialNetwork other = (UserSocialNetwork) obj;
		if (facebookAddress == null) {
			if (other.facebookAddress != null)
				return false;
		} else if (!facebookAddress.equals(other.facebookAddress))
			return false;
		if (idUserSocialNetwork == null) {
			if (other.idUserSocialNetwork != null)
				return false;
		} else if (!idUserSocialNetwork.equals(other.idUserSocialNetwork))
			return false;
		if (skypeAddress == null) {
			if (other.skypeAddress != null)
				return false;
		} else if (!skypeAddress.equals(other.skypeAddress))
			return false;
		if (userCorespondence == null) {
			if (other.userCorespondence != null)
				return false;
		} else if (!userCorespondence.equals(other.userCorespondence))
			return false;
		return true;
	}

}
