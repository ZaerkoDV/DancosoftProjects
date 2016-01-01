/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.CityDAO;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.service.CityService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="cityService")
public class CityServiceImpl extends CommonEntityServiceImpl implements CityService {

	private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	@Qualifier(value="cityDAO")
	private CityDAO cityDAO;

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}
	
	public List<City> getListCityByIdCountry(Long idCountry) {
		logger.info("CityService: List city load by id country.");
		return cityDAO.getListCityByIdCountry(idCountry);	
	}
	
	public Country getCountryByIdCity(Long idCity) {
		logger.info("CityService: Country load by id city");
		return cityDAO.getCountryByIdCity(idCity);
	}
	
	public City searchCityByCityName(String cityName) {
		logger.info("CityService: City load by city name.");
		return cityDAO.searchCityByCityName(cityName);
	}
}
