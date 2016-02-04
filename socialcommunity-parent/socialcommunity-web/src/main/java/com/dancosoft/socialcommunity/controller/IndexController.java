package com.dancosoft.socialcommunity.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.dancosoft.socialcommunity.controller.support.UserExtended;
import com.dancosoft.socialcommunity.controller.support.base.StandartAccountGroup;
import com.dancosoft.socialcommunity.controller.support.constants.BlockStatus;
import com.dancosoft.socialcommunity.controller.support.constants.ViewStatus;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.model.SecurityPrompt;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserRole;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;
import com.dancosoft.socialcommunity.service.AccountGroupHistoryService;
import com.dancosoft.socialcommunity.service.AccountGroupService;
import com.dancosoft.socialcommunity.service.AccountHistoryService;
import com.dancosoft.socialcommunity.service.AccountService;
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
										//user
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

	@Autowired
	@Qualifier(value="accountService")
	private AccountService accountService;
	
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@Autowired
	@Qualifier(value="accountHistoryService")
	private AccountHistoryService accountHistoryService;
	
	public void setAccountHistoryService(AccountHistoryService accountHistoryService) {
		this.accountHistoryService = accountHistoryService;
	}
	
	@Autowired
	@Qualifier(value="accountGroupService")
	private AccountGroupService accountGroupService;
	
	public void setAccountGroupService(AccountGroupService accountGroupService) {
		this.accountGroupService = accountGroupService;
	}
	
	@Autowired
	@Qualifier(value="accountGroupHistoryService")
	private AccountGroupHistoryService accountGroupHistoryService;
	
	public void setAccountGroupHistoryService(AccountGroupHistoryService accountGroupHistoryService) {
		this.accountGroupHistoryService = accountGroupHistoryService;
	}


	@RequestMapping(value="/views/profile/signup/savecommon/user.json", method = RequestMethod.POST)
	public @ResponseBody Long saveCommonUser(@RequestBody User user) {
	
		Long idUser=null;
		logger.info("IndexController: create new user with common information");		
        userService.saveUser(user);
      
		if(!user.getIdUser().equals(null)){
			logger.info("IndexController: create new user with common information");
			idUser=user.getIdUser();
			
		}else{
			idUser=null;
			logger.info("IndexController: create new user with common information");
		}
		return idUser;
	}
		
	@RequestMapping(value="/views/profile/signup/saveextended/{id}/userextended.json", method = RequestMethod.POST)
	public @ResponseBody Long saveExtendedUser(@RequestBody String userExtendedJson, @PathVariable("id") Long id) {
		
		logger.info("IndexController: create new user with extended information");
		Long idUser= null;
		UserExtended userExtended=null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			userExtended = mapper.readValue(userExtendedJson, UserExtended.class);
			
		} catch (JsonParseException e) {
			logger.info("IndexController: error when json parse class UserExtended "+e);
			
		} catch (JsonMappingException e) {
			logger.info("IndexController: error in json mapping for class UserExtended "+e);
			
		} catch (IOException e) {
			logger.info("IndexController: input output exeption when read json value of object userExtendedJson "+e);
		}
		
		Boolean isUniqueEmail=userEmailService.isUniqueEmail(userExtended.getUserEmail().getUserEmail());
		Boolean isValidEmail=userEmailService.isValidEmail(userExtended.getUserEmail().getUserEmail());
		
		if(isUniqueEmail && isValidEmail){
		
			User user =userService.getUserById(id);
			idUser=user.getIdUser();
			
			logger.info("IndexController: create new autobiography feature of user");
			UserAutobiography userAutobiography =new UserAutobiography();
			
			//LocalDateTime birth=userExtended.getUserAutobiography().getBirth();
			userAutobiography.setBirth(LocalDateTime.of(1990, 12, 31, 0, 0));
			
			userAutobiography.setUser(user);
			userAutobiographyService.saveUserAutobiographyService(userAutobiography);
			
			logger.info("IndexController: create new user corespondence view status(private)");
			UserCorespondence userCorespondence=new UserCorespondence();
			userCorespondence.setCorespondenceViewStatus(ViewStatus.PRIVATE.toString());		
			userCorespondence.setUser(user);
			userCorespondenceService.saveUserCorespondence(userCorespondence);
			
			logger.info("IndexController: create new post address of user");
			UserEmail userEmail=new UserEmail();
			userEmail.setUserEmail(userExtended.getUserEmail().getUserEmail());
			userEmail.setUserCorespondence(userCorespondence);
			userEmailService.saveUserEmail(userEmail);
			
			if(!userExtended.getUserSocialNetwork().equals(null)){		
				logger.info("IndexController: create new social network addresses of user");
				UserSocialNetwork userSocialNetwork=new UserSocialNetwork();
				userSocialNetwork.setFacebookAddress(userExtended.getUserSocialNetwork().getFacebookAddress());
				userSocialNetwork.setSkypeAddress(userExtended.getUserSocialNetwork().getSkypeAddress());
				userSocialNetwork.setUserCorespondence(userCorespondence);
				userSocialNetworkService.saveUserSocialNetwork(userSocialNetwork);
			}
			
		}else{
			logger.info("IndexController: falied when save extended information about user becouse id user is null");
		}
		return idUser;
	}
	
	@RequestMapping(value="/views/profile/signup/savelogin/{id}/userlogin.json", method = RequestMethod.POST)
	public @ResponseBody Long saveSecurityUser(@RequestBody SecurityPrompt prompt, @PathVariable("id") Long id) {
	
		logger.info("IndexController: create new user with sercurity feature");
		Long idUser= null;
		
		Boolean isUniqueLogin= userSecurityService.isUniqueLogin(prompt.getUserSecurity().getUserLogin());
		Boolean isUniquePassword= userSecurityService.isUniquePassword(prompt.getUserSecurity().getUserPassword());
		Boolean isUniquePrompt = securityPromptService.isUniquePrompt(prompt.getSecurityPrompt(), prompt.getUserAnswer());
		
		if(isUniquePrompt && (isUniqueLogin && isUniquePassword)){
			User user =userService.getUserById(id);
			idUser=user.getIdUser();
			
			logger.info("IndexController: create new user role");
			UserRole userRole =new UserRole();
			userRole.setUserRoleName("user");
			userRoleService.saveUserRole(userRole); 
			
			logger.info("IndexController: create new user security login and password");
			UserSecurity userSecurity =new UserSecurity();
			userSecurity.setUserLogin(prompt.getUserSecurity().getUserLogin());
			userSecurity.setUserPassword(prompt.getUserSecurity().getUserPassword());
			userSecurity.setUser(user);
			userSecurity.setUserRole(userRole);
			userSecurityService.saveUserSecurity(userSecurity);
			
			logger.info("IndexController: create new user security prompt");
			SecurityPrompt securityPrompt =new SecurityPrompt();
			securityPrompt.setSecurityPrompt(prompt.getSecurityPrompt());
			securityPrompt.setUserAnswer(prompt.getUserAnswer());
			securityPrompt.setUserSecurity(userSecurity);
			securityPromptService.saveSecurityPrompt(securityPrompt);
			
		}else{
			logger.info("IndexController: falied when save security information about user,"
					+ "becouse id is null or information is not unique");
		}
		return idUser;
	}
	
	@RequestMapping(value="/views/profile/signup/createaccount/useraccount.json", method = RequestMethod.POST)
	public @ResponseBody Long createUserAccount(@RequestBody Long idUser){
		
		if(!idUser.equals(null)){
			
			User user=userService.getUserById(idUser);
			UserSecurity userSecurity=userSecurityService.getLoginPasswordByIdUser(idUser);	
			
			logger.info("IndexController: create new user account completed.");
			Account account = new Account();
			account.setAccountBlockStatus(BlockStatus.UNBLOCK.toString());
			account.setAccountName(userSecurity.getUserLogin());
			account.setUser(user);
			accountService.saveAccount(account);

			logger.info("IndexController: create history for new user account.");
			AccountHistory accountHistory = new AccountHistory();
			accountHistory.setDateCreateAccount(LocalDateTime.now());
			accountHistory.setLastVisit(LocalDateTime.now());
			accountHistory.setAccount(account);
			accountHistoryService.saveAccountHistory(accountHistory);

			// create base groups for empty account and group history
			StandartAccountGroup accountGroup = new StandartAccountGroup();
			StandartAccountGroup historyAccountGroup = new StandartAccountGroup();

			logger.info("IndexController: create base group family");
			AccountGroup family = accountGroup.createAccountGroupFamily(account);
			accountGroupService.saveAccountGroup(family);
			AccountGroupHistory familyHistory = historyAccountGroup.createAccountGroupHistoryFamily(family);
			accountGroupHistoryService.saveAccountGroupHistory(familyHistory);

			logger.info("IndexController: create base group friend");
			AccountGroup friend = accountGroup.createAccountGroupFriend(account);
			accountGroupService.saveAccountGroup(friend);
			AccountGroupHistory friendHistory = historyAccountGroup.createAccountGroupHistoryFriend(friend);
			accountGroupHistoryService.saveAccountGroupHistory(friendHistory);

			logger.info("IndexController: create base group work");
			AccountGroup work = accountGroup.createAccountGroupWork(account);
			accountGroupService.saveAccountGroup(work);
			AccountGroupHistory workHistory = historyAccountGroup.createAccountGroupHistoryFriend(work);
			accountGroupHistoryService.saveAccountGroupHistory(workHistory);

		}else{
			logger.info("IndexController: create new account and base groups for account failed! Id user must not null.");
			idUser=null;
		}
		return idUser;
	}
	//headers="Accept=application/json"
	@RequestMapping(value="/views/profile/signin/userdata.json", method = RequestMethod.POST)
	public @ResponseBody Long signIn(@RequestBody SecurityPrompt prompt){
		
		Long idUser=null;
		Boolean signin=false;
		SecurityPrompt securityPrompt;
		
		logger.info("IndexController: user sign in, check user security information for autorization in system.");
		String loginOrEmail=prompt.getUserSecurity().getUserLogin();
		String password=prompt.getUserSecurity().getUserPassword();
		String answer=prompt.getUserAnswer();
		
		//email and password
		Boolean isValidEmail=userEmailService.isValidEmail(loginOrEmail);
		if(isValidEmail && password!=null){
			logger.info("IndexController: user sign in by user email and user password");
			idUser=userEmailService.getIdUserByEmail(loginOrEmail);
			UserSecurity userSecurity=userSecurityService.getLoginPasswordByIdUser(idUser);
			if(userSecurity.getUserPassword().equals(password)){
				signin=true;
			}
			
		//email and answer	
		}else if(isValidEmail && answer!=null){		
			logger.info("IndexController: user sign in by user email and user answer on question");
			idUser=userEmailService.getIdUserByEmail(loginOrEmail);
			securityPrompt=securityPromptService.getSecurityPromptByIdUser(idUser);
			signin=securityPromptService.signInUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
			
			//generate new password with old login which send on email
			//userSecurityService.updateLoginPasswordByIdUser(idUser);
		}	
		
		//login and password
		Boolean isLoginNotExist= userSecurityService.isUniqueLogin(loginOrEmail);
		if(!isLoginNotExist && password!=null){
			logger.info("IndexController: user sign in by user login and password");
			idUser=userSecurityService.getIdUserByLoginPassword(loginOrEmail, password);
			signin=userSecurityService.signInUserByLoginPassword(loginOrEmail, password);
			
		//login and answer	
		} else if(!isLoginNotExist && answer!=null){	
			logger.info("IndexController: user sign in by user login and answer on question.");
			securityPrompt=securityPromptService.getSecurityPromptByLogin(loginOrEmail);
			idUser=securityPromptService.getIdUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
			signin=securityPromptService.signInUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
			
			//generate new password with old login which send on email
			//userSecurityService.updateLoginPasswordByIdUser(idUser);
		}
		
		//result of user autorization
		if(signin && !idUser.equals(null)){
			logger.info("IndexController: user autorization is successfully");
			return idUser;
			
		}else{
			logger.info("IndexController: user autorization is failed");
			return null;
		}	
	}	
		
	@RequestMapping(value="/views/profile/signin/securityquestion.json", method = RequestMethod.POST)
	public @ResponseBody SecurityPrompt getSecurityQuestion(@RequestBody SecurityPrompt prompt){
		
		logger.info("IndexController: user sign in, get security answer for autorization.");
		String loginOrEmail=prompt.getUserSecurity().getUserLogin();
		SecurityPrompt securityPrompt;
		
		//if user enter email
		Boolean isValidEmail=userEmailService.isValidEmail(loginOrEmail);
		if(isValidEmail){
			logger.info("IndexController: user sign in, get security answer for autorization by email");
			Long idUser=userEmailService.getIdUserByEmail(loginOrEmail);
			securityPrompt=securityPromptService.getSecurityPromptByIdUser(idUser);
			prompt.setSecurityPrompt(securityPrompt.getSecurityPrompt());
		}
		
		//if user enter his login isLoginNotExist return false
		Boolean isLoginNotExist= userSecurityService.isUniqueLogin(loginOrEmail);
		if(!isLoginNotExist){
			logger.info("IndexController: user sign in, get security answer for autorization by login");
			securityPrompt=securityPromptService.getSecurityPromptByLogin(loginOrEmail);
			prompt.setSecurityPrompt(securityPrompt.getSecurityPrompt());
		}
		
		if(!isValidEmail && isLoginNotExist){
			logger.info("IndexController: user sign in, get security answer for autorization filed."
					+ " User input wrong login and email");
			prompt.setSecurityPrompt("Enter valid email or login.");	
		}
		return prompt;
	}
	
	@RequestMapping(value="/views/profile/signin/userrole.json", method = RequestMethod.POST)
	public @ResponseBody UserRole getUserRole(@RequestBody Long idUser){
		
		logger.info("IndexController: get user role after sign");
		UserRole userRole= userSecurityService.getUserRoleAsObjectByIdUser(idUser);

		return userRole;
	}	
}
