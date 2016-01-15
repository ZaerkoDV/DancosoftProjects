package com.dancosoft.socialcommunity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.service.AccountForumService;
import com.dancosoft.socialcommunity.service.UserService;

@Controller(value="indexController")
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	@Qualifier(value="userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	@Qualifier(value="accountForumService")
	private AccountForumService accountForumServive;

	public void setAccountForumService(AccountForumService accountForumService) {
		this.accountForumServive = accountForumService;
	}
	
	
//	@RequestMapping(value ="/", method = RequestMethod.GET)
//	public String getIndexPage() {
//		logger.info("IndexController");
//		return "/";
//	}
	
//	@RequestMapping(value ="/crateCommonUser/", method = RequestMethod.POST)
//	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
//		
//		logger.info("IndexController: create new common user");
//  
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//      userService.saveUser(user);
  
//      HttpHeaders headers = new HttpHeaders();
//		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
//        return null;// new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
		
	
	
	
	
	
}
