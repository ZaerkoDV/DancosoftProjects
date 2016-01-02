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

import com.dancosoft.socialcommunity.dao.UserSecurityDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.service.UserSecurityService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userSecurityService")
public class UserSecurityServiceImpl extends CommonEntityServiceImpl implements UserSecurityService {

	private static final Logger logger = LoggerFactory.getLogger(UserSecurityServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userSecurityDAO")
	private UserSecurityDAO userSecurityDAO;

	public void setUserSecurityDAO(UserSecurityDAO userSecurityDAO) {
		this.userSecurityDAO = userSecurityDAO;
	}
	
	public User getUserByLoginPassword(String userLogin,String userPassword) {
		logger.info("UserSecurityService: User loaded by login and password.");
		return userSecurityDAO.getUserByLoginPassword(userLogin, userPassword);
	}
	
	public Long getIdUserByLoginPassword(String userLogin,String userPassword){
		logger.info("UserSecurityService:User id loaded sucessfully by his login and password.");
		return userSecurityDAO.getIdUserByLoginPassword(userLogin, userPassword);
	}
	
	public Boolean signInUserByLoginPassword(String userLogin, String userPassword){
		logger.info("UserSecurityService:User sign in in system sucessfully");
		return userSecurityDAO.signInUserByLoginPassword(userLogin, userPassword);
	}
	
	public Boolean isUniqueLogin(String userLogin){
		logger.info("UserSecurityService:Check login on unique value.");
		return userSecurityDAO.isUniqueLogin(userLogin);
	}
	
	public Boolean isUniquePassword(String userPassword){
		logger.info("UserSecurityService:Check password on unique value.");
		return userSecurityDAO.isUniquePassword(userPassword);
	}
	
	public String getUserRoleByIdUser(Long idUser){
		logger.info("UserSecurityService:User role loaded by id user.");
		return userSecurityDAO.getUserRoleByIdUser(idUser);
	}
	
	public List<User> getListUserWithUserRole(){
		logger.info("UserSecurityService:List user loaded successfully.");
		return userSecurityDAO.getListUserWithUserRole();
	}
	
	public List<User> getListUserWithAdminRole(){
		logger.info("UserSecurityService:List administrators loaded successfully.");
		return userSecurityDAO.getListUserWithAdminRole();
	}
	
	public Boolean updateLoginPasswordByIdUser(Long idUser){
		logger.info("UserSecurityService:Login and password update by id user.");
		return userSecurityDAO.updateLoginPasswordByIdUser(idUser);
	}
	
	public UserSecurity getLoginPasswordByIdUser(Long idUser){
		logger.info("UserSecurityService:Login and password loaded by id user.");
		return userSecurityDAO.getLoginPasswordByIdUser(idUser);
	}
}
