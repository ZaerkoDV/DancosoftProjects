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

import com.dancosoft.socialcommunity.dao.UserAutobiographyDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.service.UserAutobiographyService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userAutobiographyService")
public class UserAutobiographyServiceImpl extends CommonEntityServiceImpl implements UserAutobiographyService{

	private static final Logger logger = LoggerFactory.getLogger(UserAutobiographyServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userAutobiographyDAO")
	private UserAutobiographyDAO userAutobiographyDAO;

	public void setUserAutobiographyDAO(UserAutobiographyDAO userAutobiographyDAO) {
		this.userAutobiographyDAO = userAutobiographyDAO;
	}
	
	public UserAutobiography getUserAutobiographyByIdUser(Long idUser) {
		logger.info("UserAutobiographyService: User autobiography load by id user.");
		return userAutobiographyDAO.getUserAutobiographyByIdUser(idUser);
	}
	
	public List<User> getListUserByHobby(String hobby) {
		logger.info("UserAutobiographyService:List user loaded by hobby.");
		return userAutobiographyDAO.getListUserByHobby(hobby);
	}
	
	public Boolean isUserAdult(Long idUser,Long yearAdult) {
		logger.info("UserAutobiographyService:Check user on adult");
		return userAutobiographyDAO.isUserAdult(idUser, yearAdult);
	}
	
	public List<User> getListAdultUser(Long yearAdult) {
		 logger.info("UserAutobiographyService:List adult user loaded");
		 return userAutobiographyDAO.getListAdultUser(yearAdult);
	}
}
