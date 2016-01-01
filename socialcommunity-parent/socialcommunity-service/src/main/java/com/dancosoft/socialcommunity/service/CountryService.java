/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import com.dancosoft.socialcommunity.model.Country;

/**
 * @author Zaerko_DV
 *
 */
public interface CountryService extends CommonEntityService {

	public Country searchCountryByCountryName(String countryName);
}
