/**
 * 
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
		
		UserAutobiography userAutobiography=null;
		if (idUser.equals(null) || idUser.equals("")) {
			throw new RuntimeException("UserAutobiographyService:Id user must not null or empty.");
		} else{
			try {
				logger.info("UserAutobiographyService: User autobiography load by id user.");
				userAutobiography= userAutobiographyDAO.getUserAutobiographyByIdUser(idUser);	
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService: User with id "+idUser+" not exist." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
		return userAutobiography;
	}
	
	public List<User> getListUserByHobby(String hobby) {
		
		List<User> list=Collections.emptyList();
		if (hobby.equals(null) || hobby.equals("")) {
			throw new RuntimeException("ForumMessageService:Hobby must not null and empty.");
		} else{
			try {
				logger.info("UserAutobiographyService:List user loaded by hobby.");
				list= userAutobiographyDAO.getListUserByHobby(hobby);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService:List of user with hobby "+hobby+""
						+ " load but is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public Boolean isUserAdult(Long idUser,Long yearAdult) {
		
		Boolean isUserAdult=false;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserAutobiographyService:Id user must not null.");
			
		} else if(yearAdult.equals(null) || yearAdult<0){
			throw new RuntimeException("UserAutobiographyService: Adult year must nor null and less then zero.");
			
		}else{
			try {
				logger.info("UserAutobiographyService:Check user on adult");
				isUserAdult= userAutobiographyDAO.isUserAdult(idUser, yearAdult);
		
			} catch (DataAccessException da) {
				logger.error("ForumMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return isUserAdult;
	}
	
	public List<User> getListAdultUser(Long yearAdult) {
		
		List<User> list=Collections.emptyList();
		if(yearAdult.equals(null) || yearAdult<0){
			throw new RuntimeException("UserAutobiographyService: Adult year must nor null and less then zero.");
			
		}else{
			try {
				logger.info("UserAutobiographyService:List adult user loaded");
				list= userAutobiographyDAO.getListAdultUser(yearAdult);
				 
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserAutobiographyService:List of adult user load but list is empty" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserAutobiographyService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
}
