/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;

/**
 * @author Zaerko_DV
 *
 */
public interface CityService extends CommonEntityService {

	public List<City> getListCityByIdCountry(Long idCountry);
	
	public Country getCountryByIdCity(Long idCity);
	
	public List<City> searchCityByCityName(String cityName);
}
