/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
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
		
		List<City> list=Collections.emptyList();
		if (idCountry.equals(null) || idCountry.equals("")) {
			throw new RuntimeException("CityService:Id country most not null");
		} else {
			try {
				logger.info("CityService: List city load by id country.");
				list=cityDAO.getListCityByIdCountry(idCountry);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("CityService: List cities is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public Country getCountryByIdCity(Long idCity) {
		
		Country country=null;
		if (idCity.equals(null) || idCity.equals("")) {
			throw new RuntimeException("CityService:Id country most not null");
		} else {
			try {
				logger.info("CityService: Country load by id city");
				country=cityDAO.getCountryByIdCity(idCity);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("CityService: Country not load by id city"
						+ " becouse city with id"+idCity+" not exist" + rf);
				
			} catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
		return country;
	}
	
	public List<City> searchCityByCityName(String cityName) {
		
		List<City> list=Collections.emptyList();
		
		if (cityName.equals(null) || cityName.equals("")) {
			throw new RuntimeException("CityService:City name most not null");
		} else {
			try {
				logger.info("CityService: City load by city name.");
				list= cityDAO.searchCityByCityName(cityName);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("CityService: Operation search city by city name is completed. List is empty."+ rf);
				
			} catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
}
