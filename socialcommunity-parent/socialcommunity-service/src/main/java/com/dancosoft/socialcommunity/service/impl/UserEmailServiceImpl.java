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

import com.dancosoft.socialcommunity.dao.UserEmailDAO;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.service.UserEmailService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userEmailService")
public class UserEmailServiceImpl extends CommonEntityServiceImpl implements UserEmailService {

	private static final Logger logger = LoggerFactory.getLogger(UserEmailServiceImpl.class);	
	
	@Autowired
	@Qualifier(value="userEmailDAO")
	private UserEmailDAO userEmailDAO;

	public void setUserEmailDAO(UserEmailDAO userEmailDAO) {
		this.userEmailDAO = userEmailDAO;
	}
	
	public List<UserEmail> getListEmailWithStatusByIdUser(Long idUser,String viewStatus){
		logger.info("UserEmailService:List user email with status loaded.");
		return userEmailDAO.getListEmailWithStatusByIdUser(idUser, viewStatus);
	}
	
	public List<UserEmail> getListEmailByIdUser(Long idUser){
		logger.info("UserEmailService:List user email loaded.");
		return userEmailDAO.getListEmailByIdUser(idUser);
	}
	
	public Boolean isUniqueEmail(String userEmail){
		logger.info("UserEmailService:User email is not unique.");
		return userEmailDAO.isUniqueEmail(userEmail);
	}
	
	public Long getIdUserByEmail(String userEmail){
		logger.info("UserEmailService:User id load by email");
		return userEmailDAO.getIdUserByEmail(userEmail);
	}
}
