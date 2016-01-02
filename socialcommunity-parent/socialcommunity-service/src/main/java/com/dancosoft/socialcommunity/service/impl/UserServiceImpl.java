package com.dancosoft.socialcommunity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("UserService: Accounts by user id load.");
		return userDAO.getListAccountByUserId(idUser);
	}
	
	public List<User> getListUserBySex(String sex) {
		logger.info("UserService:List user loaded by sex");
		return userDAO.getListUserBySex(sex);
	}
	
	public List<User> searchUserByFirstLastMiddleName(String firstName,String lastName,String middleName) {
		logger.info("UserService:List user loaded by first name, last name, middle name.");
		return userDAO.searchUserByFirstLastMiddleName(firstName, lastName, middleName);
	}
}
