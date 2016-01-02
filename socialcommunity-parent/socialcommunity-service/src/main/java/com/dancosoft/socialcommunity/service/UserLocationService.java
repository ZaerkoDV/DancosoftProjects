/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.UserLocation;

/**
 * @author Zaerko_DV
 *
 */
public interface UserLocationService extends CommonEntityService{

	public UserLocation getUserLocationByIdUser(Long idUser);
	
	public Language getUserLanguageByIdUser(Long idUser);
	
	public City getUserCityByIdUser(Long idUser);
	
	public Country getUserCountryByIdUser(Long idUser);
}
