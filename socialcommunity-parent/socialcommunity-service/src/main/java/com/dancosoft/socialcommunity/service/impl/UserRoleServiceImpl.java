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
		
		List<User> list=Collections.emptyList();
		if (userRoleName.equals(null) || userRoleName.equals("")) {
			throw new RuntimeException("UserRoleService:Name of user role must not null and empty.");
			
		} else{
			try {
				logger.info("UserRoleService:List user with role "+userRoleName+" loaded successfully.");
				list= userRoleDAO.getListUserByRole(userRoleName);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserRoleService: List of user with role "+userRoleName+" load, but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public int getCountUserByRole(String userRoleName) {
		
		int count=0;
		if (userRoleName.equals(null) || userRoleName.equals("")) {
			throw new RuntimeException("UserRoleService:Name of user role must not null and empty.");
			
		} else{
			try {
				logger.info("UserRoleService:Count of user with role " + userRoleName + " loaded successfully.");
				count= userRoleDAO.getCountUserByRole(userRoleName);
				
			} catch (DataAccessException da) {
				logger.error("UserRoleService:Exeption connect with data base or other error= "+da);
			}
		}
		return count;
	}
}
