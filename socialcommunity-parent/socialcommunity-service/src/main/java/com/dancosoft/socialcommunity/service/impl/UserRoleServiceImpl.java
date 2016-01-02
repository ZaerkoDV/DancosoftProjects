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

import com.dancosoft.socialcommunity.dao.UserRoleDAO;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.UserRoleService;


/**
 * @author Zaerko_DV
 *
 */
@Service(value="userRoleService")
public class UserRoleServiceImpl extends CommonEntityServiceImpl implements UserRoleService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userRoleDAO")
	private UserRoleDAO userRoleDAO;

	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}
	
	public List<User> getListUserByRole(String userRoleName) {
		logger.info("UserRoleService:List user with role "+userRoleName+" loaded successfully.");
		return userRoleDAO.getListUserByRole(userRoleName);
	}
	
	public int getCountUserByRole(String userRoleName) {
		logger.info("UserRoleService:User count with role " + userRoleName + " loaded successfully.");
		return userRoleDAO.getCountUserByRole(userRoleName);
	}
}
