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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Country entity describe special characteristics and behavior of UserLocation
 * enity.This class contain name country in which user lives.  
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description Country
 * entity. Class implements interface Serializable. For creating Country model
 * use Hibernate technology (anatations). Class contains exclusively no-static
 * public methods that return fields of entity. Methods intended to access object
 * fields.Class also contain overload methods toString(), hashCode(), equals().
 *
 * @see Hibernate annotations
 * @see Serializable
 * 
 * @version 1.0 13.12.2015
 * @author Denis Zaerko
 */
@Entity(name = "Country")
@Table(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = 4274838529152003050L;

	/**
	 * Unique identification number of Country for entity Country.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_country")
	private Long idCountry;
	
	/**
	 * Country in which user lives.
	 * 
	 * @type String
	 */
	@NotNull 
	@Column(name = "country")
	private String countryName;
	
	/**
	 * Empty constructor(default) of Country class.
	 */
	public Country(){
	}
	
	/**
	 * Overloaded constructor of Country class.
	 * 
	 * @type Long
	 * @type Country
	 * 
	 * @param idCity
	 * @param country
	 */
	public Country(Long idCountry,String countryName){
		this.idCountry=idCountry;
		this.countryName=countryName;
	}

	/**
	 * @return the idCountry
	 */
	public Long getIdCountry() {
		return idCountry;
	}

	/**
	 * @param idCountry the idCountry to set
	 */
	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	/**
	 * @return the country
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return Country entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idCountry.equals(null)) {
			return this.idCountry.toString() + " "
					+ this.countryName.toString();
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
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		result = prime * result
				+ ((idCountry == null) ? 0 : idCountry.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to Country or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		if (idCountry == null) {
			if (other.idCountry != null)
				return false;
		} else if (!idCountry.equals(other.idCountry))
			return false;
		return true;
	}
	
}
