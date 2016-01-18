package com.dancosoft.socialcommunity.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dancosoft.socialcommunity.controller.support.UserExtended;
import com.dancosoft.socialcommunity.model.SecurityPrompt;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserRole;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;
import com.dancosoft.socialcommunity.service.AccountForumService;
import com.dancosoft.socialcommunity.service.SecurityPromptService;
import com.dancosoft.socialcommunity.service.UserAutobiographyService;
import com.dancosoft.socialcommunity.service.UserCorespondenceService;
import com.dancosoft.socialcommunity.service.UserEmailService;
import com.dancosoft.socialcommunity.service.UserRoleService;
import com.dancosoft.socialcommunity.service.UserSecurityService;
import com.dancosoft.socialcommunity.service.UserService;
import com.dancosoft.socialcommunity.service.UserSocialNetworkService;

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
	@Qualifier(value="userAutobiographyService")
	private UserAutobiographyService userAutobiographyService;
	
	public void setUserAutobiographyService(UserAutobiographyService userAutobiographyService) {
		this.userAutobiographyService = userAutobiographyService;
	}

	@Autowired
	@Qualifier(value="userCorespondenceService")
	private UserCorespondenceService userCorespondenceService;
	
	public void setUserAutobiographyService(UserCorespondenceService userCorespondenceService) {
		this.userCorespondenceService = userCorespondenceService;
	}
	
	@Autowired
	@Qualifier(value="userEmailService")
	private UserEmailService userEmailService;
	
	public void setUserEmailService(UserEmailService userEmailService) {
		this.userEmailService = userEmailService;
	}
	
	@Autowired
	@Qualifier(value="userSocialNetworkService")
	private UserSocialNetworkService userSocialNetworkService;
	
	public void setUserEmailService(UserSocialNetworkService userSocialNetworkService) {
		this.userSocialNetworkService = userSocialNetworkService;
	}
	
	@Autowired
	@Qualifier(value="userRoleService")
	private UserRoleService userRoleService;

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	@Autowired
	@Qualifier(value="userSecurityService")
	private UserSecurityService userSecurityService;

	public void setUserSecurityService(UserSecurityService userSecurityService) {
		this.userSecurityService = userSecurityService;
	}
	
	@Autowired
	@Qualifier(value="securityPromptService")
	private SecurityPromptService securityPromptService;

	public void setSecurityPromptService(SecurityPromptService securityPromptService) {
		this.securityPromptService = securityPromptService;
	}
	
	@RequestMapping(value="/views/profile/signup/savecommon/user.json", method = RequestMethod.POST)
	public @ResponseBody Long saveCommonUser(@RequestBody User user) {
	
		logger.info("IndexController: create new user with common information");
		//userService.saveUser(user);
		
		Long idUser=null;
//		if(!user.getIdUser().equals(null)){
//			logger.info("IndexController: create new user with common information");
//			idUser=user.getIdUser();
//			
//		}else{
//			idUser=null;
//			logger.info("IndexController: create new user with common information");
//		}
		return idUser;
	}
	
	//	
	@RequestMapping(value="/views/profile/signup/saveextended/{id}/userextended.json", method = RequestMethod.POST)
	public @ResponseBody Long saveExtendedUser(@RequestBody String userExtendedJson, @PathVariable("id") Long id) {
		
		Long idUser= null;
//		UserExtended userExtended=null;
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			logger.info("IndexController: create new user with extended information");
//			userExtended = mapper.readValue(userExtendedJson,UserExtended.class);
//
//		} catch (JsonParseException e) {
//			logger.info("IndexController: error when json parse class UserExtended "+e);
//			
//		} catch (JsonMappingException e) {
//			logger.info("IndexController: error in json mapping for class UserExtended "+e);
//			
//		} catch (IOException e) {
//			logger.info("IndexController: input output exeption when read json value of object userExtendedJson "+e);
//		}
//		
//		Boolean isUniqueEmail=userEmailService.isUniqueEmail(userExtended.getUserEmail().getUserEmail());
//		Boolean isValidEmail=userEmailService.isValidEmail(userExtended.getUserEmail().getUserEmail());
//		
//		if(isUniqueEmail && isValidEmail){
//		
//			User user =userService.getUserById(id);
//			idUser=user.getIdUser();
//			
//			logger.info("IndexController: create new autobiography feature of user");
//			UserAutobiography userAutobiography =new UserAutobiography();
//			userAutobiography.setBirth(userExtended.getUserAutobiography().getBirth());
//			userAutobiography.setUser(user);
//			userAutobiographyService.saveUserAutobiographyService(userAutobiography);
//			
//			logger.info("IndexController: create new user corespondence view status(private)");
//			UserCorespondence userCorespondence=new UserCorespondence();
//			userCorespondence.setCorespondenceViewStatus("private");		
//			userCorespondence.setUser(user);
//			userCorespondenceService.saveUserCorespondence(userCorespondence);
//			
//			logger.info("IndexController: create new post address of user");
//			UserEmail userEmail=new UserEmail();
//			userEmail.setUserEmail(userExtended.getUserEmail().getUserEmail());
//			userEmail.setUserCorespondence(userCorespondence);
//			userEmailService.saveUserEmail(userEmail);
//			
//			if(!userExtended.getSocialNetwork().equals(null)){		
//		
//				logger.info("IndexController: create new social network addresses of user");
//				UserSocialNetwork userSocialNetwork=new UserSocialNetwork();
//				userSocialNetwork.setFacebookAddress(userExtended.getSocialNetwork().getFacebookAddress());
//				userSocialNetwork.setSkypeAddress(userExtended.getSocialNetwork().getSkypeAddress());
//				userSocialNetwork.setUserCorespondence(userCorespondence);
//				userSocialNetworkService.saveUserSocialNetwork(userSocialNetwork);
//			}
//			
//		}else{
//			logger.info("IndexController: falied when save extended information about user becouse id user is null");
//		}
		return idUser;
	}
	
	@RequestMapping(value="/views/profile/signup/savelogin/{id}/userlogin.json", method = RequestMethod.POST)
	public @ResponseBody Long saveSecurityUser(@RequestBody SecurityPrompt prompt, @PathVariable("id") Long id) {
	
		logger.info("IndexController: create new user with sercurity feature");
		Long idUser= null;
		
//		Boolean isUniqueLogin= userSecurityService.isUniqueLogin(prompt.getUserSecurity().getUserLogin());
//		Boolean isUniquePassword= userSecurityService.isUniquePassword(prompt.getUserSecurity().getUserPassword());
//		Boolean isUniquePrompt = securityPromptServive.isUniquePrompt(prompt.getSecurityPrompt(), prompt.getUserAnswer());
//		
//		if(isUniquePrompt && (isUniqueLogin && isUniquePassword)){
//			User user =userService.getUserById(id);
//			idUser=user.getIdUser();
//			
//			logger.info("IndexController: create new user role");
//			UserRole userRole =new UserRole();
//			userRole.setUserRoleName("user");
//			userRoleService.saveUserRole(userRole); 
//			
//			logger.info("IndexController: create new user security login and password");
//			UserSecurity userSecurity =new UserSecurity();
//			userSecurity.setUserLogin(prompt.getUserSecurity().getUserLogin());
//			userSecurity.setUserPassword(prompt.getUserSecurity().getUserPassword());
//			userSecurity.setUser(user);
//			userSecurity.setUserRole(userRole);
//			userSecurityService.saveUserSecurity(userSecurity);
//			
//			logger.info("IndexController: create new user security prompt");
//			SecurityPrompt securityPrompt =new SecurityPrompt();
//			securityPrompt.setSecurityPrompt(prompt.getSecurityPrompt());
//			securityPrompt.setUserAnswer(prompt.getUserAnswer());
//			securityPromptServive.saveSecurityPrompt(securityPrompt);
//			
//		}else{
//			logger.info("IndexController: falied when save security information about user,
//				becouse id is null or information is not unique");
//		}
		return idUser;
	}
	
	//headers="Accept=application/json"
	@RequestMapping(value="/views/profile/signin/userdata.json", method = RequestMethod.POST)
	public @ResponseBody User signIn(@RequestBody SecurityPrompt prompt){
		
		Boolean signin=false;
		User user = null;
		Long idUser=null;
		SecurityPrompt securityPrompt;
		
		logger.info("IndexController: user sign in, check user security information for autorization in system.");
//		String loginOrEmail=prompt.getUserSecurity().getUserLogin();
//		String password=prompt.getUserSecurity().getUserPassword();
//		String answer=prompt.getUserAnswer();
//		
//		//email and password
//		Boolean isValidEmail=userEmailService.isValidEmail(loginOrEmail);
//		if(isValidEmail && !password.equals(null)){
//			
//			logger.info("IndexController: user sign in by user email and user password");
//			idUser=userEmailService.getIdUserByEmail(loginOrEmail);
//			UserSecurity userSecurity=userSecurityService.getLoginPasswordByIdUser(idUser);
//			if(userSecurity.getUserPassword().equals(password)){
//				signin=true;
//			}
//			
//		//email and answer	
//		}else if(isValidEmail && !answer.equals(null)){		
//			
//			logger.info("IndexController: user sign in by user email and user answer on question");
//			idUser=userEmailService.getIdUserByEmail(loginOrEmail);
//			securityPrompt=securityPromptService.getSecurityPromptByIdUser(idUser);
//			signin=securityPromptService.signInUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
//		}	
//		
//		//login and password
//		Boolean isLoginNotExist= userSecurityService.isUniqueLogin(loginOrEmail);
//		if(!isLoginNotExist && !password.equals(null)){
//			
//			logger.info("IndexController: user sign in by user login and password");
//			idUser=userSecurityService.getIdUserByLoginPassword(loginOrEmail, password);
//			signin=userSecurityService.signInUserByLoginPassword(loginOrEmail, password);
//		
//		//login and answer
//		}else if(!isLoginNotExist && !answer.equals(null)){	
//			
//			logger.info("IndexController: user sign in by user login and answer on question.");
//			securityPrompt=securityPromptService.getSecurityPromptByLogin(loginOrEmail);
//			idUser=securityPromptService.getIdUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
//			signin=securityPromptService.signInUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
//		}
//		
//		//return user
//		if(signin && !idUser.equals(null)){
//			user=userService.getUserById(idUser);
//		}	
		return user;
	}
		
	@RequestMapping(value="/views/profile/signin/securityquestion.json", method = RequestMethod.POST)
	public @ResponseBody SecurityPrompt getSecurityQuestion(@RequestBody SecurityPrompt prompt){
		
//		logger.info("IndexController: user sign in, get security answer for autorization.");
//		String loginOrEmail=prompt.getUserSecurity().getUserLogin();
//		SecurityPrompt securityPrompt;
//		
//		//if user enter email
//		Boolean isValidEmail=userEmailService.isValidEmail(loginOrEmail);
//		if(isValidEmail){
//			
//			logger.info("IndexController: user sign in, get security answer for autorization by email");
//			Long idUser=userEmailService.getIdUserByEmail(loginOrEmail);
//			securityPrompt=securityPromptService.getSecurityPromptByIdUser(idUser);
//			prompt.setSecurityPrompt(securityPrompt.getSecurityPrompt());
//		}
//		
//		//if user enter his login isLoginNotExist return false
//		Boolean isLoginNotExist= userSecurityService.isUniqueLogin(loginOrEmail);
//		if(!isLoginNotExist){
//			
//			logger.info("IndexController: user sign in, get security answer for autorization by login");
//			securityPrompt=securityPromptService.getSecurityPromptByLogin(loginOrEmail);
//			prompt.setSecurityPrompt(securityPrompt.getSecurityPrompt());
//		}
//		
//		if(!isValidEmail && isLoginNotExist){
//			logger.info("IndexController: user sign in, get security answer for autorization filed."
//					+ " User input wrong login and email");
//			prompt.setSecurityPrompt("Enter valid email or login.");	
//		}
		prompt.setSecurityPrompt("Enter valid email or login!");
		return prompt;
	}
	
	@RequestMapping(value="/views/profile/signin/userrole.json", method = RequestMethod.POST)
	public @ResponseBody UserRole getUserRole(@RequestBody String userJson){
		
		User user=null;
		logger.info("IndexController: get user role after sign");
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			user = mapper.readValue(userJson,User.class);
//			
//		} catch (JsonParseException e) {
//			logger.info("IndexController: error when json parse class UserRole "+e);
//			
//		} catch (JsonMappingException e) {
//			logger.info("IndexController: error in json mapping for class UserRole"+e);
//			
//		} catch (IOException e) {
//			logger.info("IndexController: input output exeption when read json value of object userJson"+e);
//		}	
		UserRole userRole= userSecurityService.getUserRoleAsObjectByIdUser(user.getIdUser());

		return userRole;
	}	
}
