/**
 * @package com.dancosoft.socialcommunity.service.impl
 * 
 * Package com.dancosoft.socialcommunity.service.impl contain set of class which description
 * service layer(modul) in SocialCommunity project. This project based on MVC architecture.
 * This class is part of service layer in MVC architecture.This layer defines the boundary
 * of the application and a set of permitted operations. It encapsulates the business logic
 * of the application and controls the answers in the implementation of operations.All classes
 * which contain postfix “Service” provide to work Service for SocialCommunity application.
 * Also this package user support classes: for generate new passworl and login,for sending
 * email to user and other from com.dancosoft.socialcommunity.service.support package.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dancosoft.socialcommunity.dao.CityDAO;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.service.CityService;

/**
 * <p>
 * The class CityServiceImpl use Service pattern which describes business logic
 * SocialCommunity application. Service layer perform link between, presentation
 * layer and DAO layer(CityDAO).This layer is the main role becouse layer
 * contents(set of methods in classes) affect on functionality of all
 * application. This class contain methods which describes specific operation
 * for City.This class perform service layer to City.Class extend base class
 * CommonEntityServiceImpl and implement CityService interface which perform all
 * methods of this class. For logging use fasade slf4j and framework log4j.
 * Class contain also private, static variable logger, which use to call log
 * message. Class use Spring framework anatations to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="cityService")
public class CityServiceImpl implements CityService {

	private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	@Qualifier(value="cityDAO")
	private CityDAO cityDAO;

	public void setCityDAO(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}
	
	/**
	 * Method return list city by id country. This country contain list of city
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<City>
	 */
	@Transactional
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
	
	/**
	 * Method return country by id city. If Country not contain city return null;
	 * 
	 * @type Long
	 * @param idCity
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Country
	 */
	@Transactional
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
	
	/**
	 * Method return city by city name.If city with name not exist return null.
	 * 
	 * @type String
	 * @param cityName
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<City>
	 */
	@Transactional
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
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idCity
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return City
	 */
	@Transactional
	public City getCityById(Long idCity) {
		
		City city = null;
		if (idCity.equals(null) || idCity.equals("")) {
			throw new RuntimeException("CityService:Id entity is null");
		} else {
			try {
				city = (City) cityDAO.getEntityById(idCity);
				logger.info("CityService:Entity loaded successfully id=" + idCity);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("CityService:Not found entity in data base=" + rf);
	
			} catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
		return city;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type City
	 * @param city
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void saveCity(City city) {
		
		if(city.equals(null)){
			throw new RuntimeException("CityService: Entity not save becouse entity is null.");
		} else {
			try {
				cityDAO.saveEntity(city);
				logger.info("CityService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("CityService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type City
	 * @param city
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	@Transactional
	public void updateCity(City city) {
		
		if (city.equals(null)) {
			throw new RuntimeException("CityService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("CityService:Entity update successfully");
				cityDAO.updateEntity(city);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("CityService:New entity not update becouse mismatch field type "+ tm);
			} catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idCity
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteCityById(Long idCity) {
		
		if (idCity.equals(null) || idCity.equals("")) {
			throw new RuntimeException("CityService:Id entity is null");
		} else{
			try {
				logger.info("CityService: Entity delete successfully,id=" + idCity);
				cityDAO.deleteEntityById(idCity);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("CityService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type City
	 * @param city
	 * 
	 * @exception DataAccessException
	 */
	@Transactional
	public void deleteCity(City city) {
		
		if (city.equals(null)) {
			throw new RuntimeException("CityService: Object is yet and not delete again.");
		}else{
			try {
				logger.info("CityService:Entity  delete successfully");
				cityDAO.deleteEntity(city);
				
			} catch (DataAccessException da) {
				logger.error("CityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	@Transactional
	public List<Object> getListCity() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("CityService: List of entity load");
			list=cityDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("CityService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("CityService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
