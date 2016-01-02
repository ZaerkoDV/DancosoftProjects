/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("UserLocationService: User location load by id user.");
		return userLocationDAO.getUserLocationByIdUser(idUser);
	}
	
	public Language getUserLanguageByIdUser(Long idUser) {
		logger.info("UserLocationService: User language load by id user.");
		return userLocationDAO.getUserLanguageByIdUser(idUser);
	}
	
	public City getUserCityByIdUser(Long idUser) {
		logger.info("UserLocationService: User city load by id user.");
		return userLocationDAO.getUserCityByIdUser(idUser);
	}
	
	public Country getUserCountryByIdUser(Long idUser) {
		logger.info("UserLocationService: User country load by id user.");
		return userLocationDAO.getUserCountryByIdUser(idUser);
	}
}
