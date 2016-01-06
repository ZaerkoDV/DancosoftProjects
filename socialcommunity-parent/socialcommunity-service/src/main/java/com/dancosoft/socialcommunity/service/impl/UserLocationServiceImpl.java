/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserLocationDAO;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.service.UserLocationService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userLocationService")
public class UserLocationServiceImpl extends CommonEntityServiceImpl implements UserLocationService{

	private static final Logger logger = LoggerFactory.getLogger(UserLocationServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userLocationDAO")
	private UserLocationDAO userLocationDAO;

	public void setUserLocationDAO(UserLocationDAO userLocationDAO) {
		this.userLocationDAO = userLocationDAO;
	}
	
	public UserLocation getUserLocationByIdUser(Long idUser) {
		
		UserLocation userLocation=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserLocationService:Id user must not null!");
			
		} else{
			try {
				logger.info("UserLocationService: User location load by id user.");
				userLocation= userLocationDAO.getUserLocationByIdUser(idUser);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserLocationService: Location for user with id "+idUser+" not exist " + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserLocationService: Exeption connect with data base or other error= "+da);
			}
		}
		return userLocation;
	}
	
	public Language getUserLanguageByIdUser(Long idUser) {
		
		Language language=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserLocationService:Id user must not null!");
			
		} else{
			try {
				logger.info("UserLocationService: User language load by id user.");
				language= userLocationDAO.getUserLanguageByIdUser(idUser);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserLocationService:Language for user with id "+idUser+" not exist " + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserLocationService: Exeption connect with data base or other error= "+da);
			}
		}
		return language;
	}
	
	public City getUserCityByIdUser(Long idUser) {
		
		City city=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserLocationService:Id user must not null!");
			
		} else{
			try {
				logger.info("UserLocationService: User city load by id user.");
				city= userLocationDAO.getUserCityByIdUser(idUser);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserLocationService:City for user with id "+idUser+" not exist " + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserLocationService: Exeption connect with data base or other error= "+da);
			}
		}
		return city;
	}
	
	public Country getUserCountryByIdUser(Long idUser) {
	
		Country country=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserLocationService:Id user must not null!");
			
		} else{
			try {
				logger.info("UserLocationService: User country load by id user.");
				country= userLocationDAO.getUserCountryByIdUser(idUser);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserLocationService:Country for user with id "+idUser+" not exist " + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserLocationService: Exeption connect with data base or other error= "+da);
			}
		}
	   return country;
	}
}
