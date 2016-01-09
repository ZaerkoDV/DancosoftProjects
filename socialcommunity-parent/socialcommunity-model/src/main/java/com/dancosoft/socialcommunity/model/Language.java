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

/**
 * Language entity describe special characteristics and behavior of UserLocation
 * enity.This class contain information about user location such as language
 * which user use to speak.Here are most popular language. User must have only
 * one language.
 * 
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description Language
 * entity. Class implements interface Serializable. For creating Language model
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
@Entity(name = "Language")
@Table(name = "language")
public class Language implements Serializable {

	private static final long serialVersionUID = 7484950127297064081L;

	/**
	 * Unique identification number of Language for entityLanguage.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_language")
	private Long idLanguage;

	/**
	 * Language which user use to speak.
	 * 
	 * @type String
	 */
	@NotNull
	@Column(name = "language")
	private String languageName;

	/**
	 * Empty constructor(default) of Language class.
	 */
	public Language() {
	}

	/**
	 * Overloaded constructor of Language class.
	 * 
	 * @type Long
	 * @type String
	 * 
	 * @param idLanguage
	 * @param language
	 */
	public Language(Long idLanguage, String languageName) {
		this.idLanguage = idLanguage;
		this.languageName = languageName;
	}

	/**
	 * @return the idLanguage
	 */
	public Long getIdLanguage() {
		return idLanguage;
	}

	/**
	 * @param idLanguage
	 *            the idLanguage to set
	 */
	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}

	/**
	 * @return the language
	 */
	public String getLanguageName() {
		return languageName;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return Language entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idLanguage.equals(null)) {
			return this.idLanguage.toString() + " " + this.languageName.toString();
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
				+ ((idLanguage == null) ? 0 : idLanguage.hashCode());
		result = prime * result
				+ ((languageName == null) ? 0 : languageName.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to Language or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Language))
			return false;
		Language other = (Language) obj;
		if (idLanguage == null) {
			if (other.idLanguage != null)
				return false;
		} else if (!idLanguage.equals(other.idLanguage))
			return false;
		if (languageName == null) {
			if (other.languageName != null)
				return false;
		} else if (!languageName.equals(other.languageName))
			return false;
		return true;
	}

}
