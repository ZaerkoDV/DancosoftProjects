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

import com.dancosoft.socialcommunity.dao.UserDAO;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.UserService;

@Service(value="userService")
public class UserServiceImpl extends CommonEntityServiceImpl implements UserService{

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userDAO")
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public List<Account> getListAccountByUserId(Long idUser) {
		
		List<Account> list=Collections.emptyList();
		if (idUser.equals(null)) {
			throw new RuntimeException("UserService:Id user must not null");
			
		} else{
			try {
				logger.info("UserService: Accounts by user id load.");
				list= userDAO.getListAccountByUserId(idUser);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserService:Accounts not belong to user with id "+idUser+".List is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<User> getListUserBySex(String sex) {
		
		List<User> list=Collections.emptyList();
		if (sex.equals(null) || sex.equals("")) {
			throw new RuntimeException("UserService:Sex must not null");
			
		} else{
			try {
				logger.info("UserService:List user loaded by sex");
				list= userDAO.getListUserBySex(sex);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserService:List of user with sex "+sex+" load, but list is empty. " + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<User> searchUserByFirstLastMiddleName(String firstName,String lastName,String middleName) {
		
		List<User> list=Collections.emptyList();
		try {
			logger.info("UserService:List user loaded by first name, last name, middle name.");
			list= userDAO.searchUserByFirstLastMiddleName(firstName, lastName, middleName);
			
		} catch (DataAccessException da) {
			logger.error("UserService: Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
