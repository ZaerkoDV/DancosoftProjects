/**
 * 
 */
package com.dancosoft.socialcommunity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.dancosoft.socialcommunity.service.UserService;

/**
 * @author Zaerko_DV
 *
 */
@Controller(value = "userController")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	@Qualifier(value = "userService")
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	
	
}
