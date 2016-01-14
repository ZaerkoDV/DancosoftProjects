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

import com.dancosoft.socialcommunity.dao.UserLocationDAO;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.service.UserLocationService;

/**
 * <p>The class UserLocationServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(UserLocationDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for UserLocation.This class perform service layer to UserLocation.Class
 * extend base class CommonEntityServiceImpl and implement UserLocationService
 * interface which perform all methods of this class. For logging use fasade
 * slf4j and framework log4j. Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatations
 * to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="userLocationService")
public class UserLocationServiceImpl implements UserLocationService{

	private static final Logger logger = LoggerFactory.getLogger(UserLocationServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userLocationDAO")
	private UserLocationDAO userLocationDAO;

	public void setUserLocationDAO(UserLocationDAO userLocationDAO) {
		this.userLocationDAO = userLocationDAO;
	}
	
	/**
	 * Method return user location by id user. If user
	 * location is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserLocation
	 */
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
	
	/**
	 * Method return user language by id user. If user language
	 * not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Language
	 */
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
	
	/**
	 * Method return user city by id user. If user city
	 * not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return City
	 */
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
	
	/**
	 * Method return user country by id user. If user country
	 * not exist return null. User must have city before.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Country
	 */
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
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idUserLocation
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserLocation
	 */
	public UserLocation getUserLocationById(Long idUserLocation) {
		
		UserLocation userLocation = null;
		if (idUserLocation.equals(null) || idUserLocation.equals("")) {
			throw new RuntimeException("UserLocationService:Id entity is null");
		} else {
			try {
				userLocation = (UserLocation) userLocationDAO.getEntityById(idUserLocation);
				logger.info("UserLocationService:Entity loaded successfully id=" + idUserLocation);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserLocationService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("UserLocationService:Exeption connect with data base or other error= "+da);
			}
		}
		return userLocation;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type UserLocation
	 * @param userLocation
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveUserLocation(UserLocation userLocation) {
		
		if(userLocation.equals(null)){
			throw new RuntimeException("UserLocationService: Entity not save becouse entity is null.");
		} else {
			try {
				userLocationDAO.saveEntity(userLocation);
				logger.info("UserLocationService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserLocationService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("UserLocationService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type UserLocation
	 * @param userLocation
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateUserLocation(UserLocation userLocation) {
		
		if (userLocation.equals(null)) {
			throw new RuntimeException("UserLocationService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("UserLocationService:Entity update successfully");
				userLocationDAO.updateEntity(userLocation);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserLocationService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("UserLocationService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idUserLocation
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteUserLocationById(Long idUserLocation) {
		
		if (idUserLocation.equals(null) || idUserLocation.equals("")) {
			throw new RuntimeException("EntityService:Id entity is null");
		} else{
			try {
				logger.info("UserLocationService:Entity  delete successfully,id=" + idUserLocation);
				userLocationDAO.deleteEntityById(idUserLocation);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserLocationService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserLocationService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type UserLocation
	 * @param userLocation
	 * 
	 * @exception DataAccessException
	 */
	public void deleteUserLocation(UserLocation userLocation) {
		
		if (userLocation.equals(null)) {
			throw new RuntimeException("UserLocationService: Object is "+userLocation+ " yet and not delete again.");
		}else{
			try {
				logger.info("UserLocationService:Entity " + userLocation + " delete successfully");
				userLocationDAO.deleteEntity(userLocation);
				
			} catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListLocation() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("UserLocationService: List of entity load");
			list=userLocationDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserLocationService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserLocationService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
