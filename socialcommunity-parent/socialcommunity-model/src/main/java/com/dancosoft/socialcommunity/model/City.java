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

/**
 * City entity describe special characteristics and behavior of UserLocation
 * enity.This class contain name city in which user lives. Class City have
 * relations (or forigen key which refer on this class): one-to-one with Country
 * All communication is one-way.
 * The class is located in the com.dancosoft.socialcommunity.model and describes
 * part of model in MVC architecture. This class includes a description City
 * entity. Class implements interface Serializable. For creating City model
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
@Entity(name = "City")
@Table(name = "city")
public class City implements Serializable {

	private static final long serialVersionUID = 3040006023145410666L;

	/**
	 * Unique identification number of City for entity City.
	 * 
	 * @type Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_city")
	private Long idCity;
	
	/**
	 * City in which user live.
	 * 
	 * @type String
	 */
	@NotNull 
	@Column(name = "city")
	private String cityName;
	
	/**
	 * Each city belong to same country
	 * 
	 * @type Country
	 */
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	/**
	 * Empty constructor(default) of City class.
	 */
	public City(){
	}
	
	/**
	 * Overloaded constructor of City class.
	 * 
	 * @type Long
	 * @type City
	 * @type Country
	 * 
	 * @param idCity
	 * @param city
	 * @param country
	 */
	public City(Long idCity,String cityName,Country country){
		this.idCity=idCity;
		this.cityName=cityName;
		this.country=country;
	}

	/**
	 * @return the idCity
	 */
	public Long getIdCity() {
		return idCity;
	}

	/**
	 * @param idCity the idCity to set
	 */
	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

	/**
	 * @return the city
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param city the city to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the country
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(Country country) {
		this.country = country;
	}
	
	/**
	 * Overload basic method toString()
	 * 
	 * @type String
	 * @return City entity as string.
	 */
	@Override
	public String toString() {
		if (!this.idCity.equals(null)) {
			return this.idCity.toString() + " "
					+this.cityName.toString()+" "
					+ this.country.toString();
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
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((idCity == null) ? 0 : idCity.hashCode());
		return result;
	}

	/**
	 * Overload basic method equals()
	 * 
	 * @type Boolean
	 * @type Object
	 * @param obj
	 * @return Boolean true if object belong to City or false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof City))
			return false;
		City other = (City) obj;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (idCity == null) {
			if (other.idCity != null)
				return false;
		} else if (!idCity.equals(other.idCity))
			return false;
		return true;
	}
	
}
