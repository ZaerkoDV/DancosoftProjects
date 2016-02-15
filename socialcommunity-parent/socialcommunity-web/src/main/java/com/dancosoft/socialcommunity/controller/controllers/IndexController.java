/**
 * @package com.dancosoft.socialcommunity.controller.controllers
 * 
 * Package com.dancosoft.socialcommunity.controller.controllers contain set of classes
 * which perform controller pattern in SocialCommunity project. This project is based
 * on MVC architecture.This class is part of controller in MVC architecture. Controller
 * provides communication between the user and the system: controls user input and uses
 * models and views to implement the necessary response. In SocialCommunity define two
 * roles User, Administrator. For each role, define separate back end controller. All
 * classes which contain postfix “Controller” provide to work Controller for SocialCommunity
 * application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.dancosoft.socialcommunity.controller.controllers;

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
import com.dancosoft.socialcommunity.controller.support.constants.UserRoleName;
import com.dancosoft.socialcommunity.controller.support.constants.ViewStatus;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.model.GroupMember;
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
import com.dancosoft.socialcommunity.service.GroupMemberService;
import com.dancosoft.socialcommunity.service.SecurityPromptService;
import com.dancosoft.socialcommunity.service.UserAutobiographyService;
import com.dancosoft.socialcommunity.service.UserCorespondenceService;
import com.dancosoft.socialcommunity.service.UserEmailService;
import com.dancosoft.socialcommunity.service.UserRoleService;
import com.dancosoft.socialcommunity.service.UserSecurityService;
import com.dancosoft.socialcommunity.service.UserService;
import com.dancosoft.socialcommunity.service.UserSocialNetworkService;

/**
 * Class IndexController use technologe IoC for work with other layer in application. All methods
 * are public in class. For logging use framework shell slf4j and framework log4j.Class contain
 * also private, static variable logger, which use to call log message.Controller use spring
 * framework for organize request/response mappling. 
 * 
 * The class IndexController contain methods which prepares date for sending in ui service layer.
 * The main task of IndexController class is basic operation(prepares date for sending) for
 * all users. There are sign up, sign in, get security question and other. Class use when
 * user have not role(not sign in). Class use other classes: StandartAccountGroup for crateing
 * account group when user sign up at the first. Also class use enums from package in this module:
 * com.dancosoft.socialcommunity.controller.support.constants for literals. Ther are: BlockStatus(block,
 * unblock),UserRoleName (admin/user), ViewStatus(public/private).
 * 
 * 
 * @version 1.0 12.02.2016
 * 
 * @see org.springframework.web
 * @see org.springframework.stereotype
 * 
 * @author Denis Zaerko
 */
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
	
	@Autowired
	@Qualifier(value="groupMemberService")
	private GroupMemberService groupMemberService;
	
	public GroupMemberService getGroupMemberService() {
		return groupMemberService;
	}

	
	/**
	 * Method save common user prifile and return id user after save.
	 * If save failed return null. Methods convert json to object.
	 * 
	 * @type User
	 * @param user
	 * 
	 * @return idUser(Long)
	 */
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
			logger.info("IndexController: new user not save");
		}
		return idUser;
	}
		
	/**
	 * Method save extended user prifile and return id user after save.
	 * If save failed return null. Methods convert json to objects using ObjectMapper.
	 * 
	 * @see ObjectMapper 
	 * @type User
	 * @type Long
	 * @param user
	 * @param id
	 * 
	 * @exception JsonParseException
	 * @exception JsonMappingException
	 * @exception IOException
	 * 
	 * @return idUser(Long)
	 */
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
			UserAutobiography userAutobiography = new UserAutobiography();
			userAutobiography.setBirth(userExtended.getUserAutobiography().getBirth());
			
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
	
	/**
	 * Method save security user prifile and return id user after save. If save failed
	 * return null. Methods convert json to objects using ObjectMapper.
	 * 
	 * @see ObjectMapper 
	 * @type SecurityPrompt
	 * @type Long
	 * @param prompt
	 * @param id
	 * 
	 * @return idUser(Long)
	 */
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
			UserRole userRole = new UserRole();
			userRole.setUserRoleName(UserRoleName.USER.toString());
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
	
	/**
	 * Method create new user account and basic group for this group. If
	 * success save return id user else return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @return idUser(Long)
	 */
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
			StandartAccountGroup standartAccountGroup = new StandartAccountGroup();

			logger.info("IndexController: create base group family");
			AccountGroup family = standartAccountGroup.createAccountGroupFamily(account);
			accountGroupService.saveAccountGroup(family);
			AccountGroupHistory familyHistory = standartAccountGroup.createAccountGroupHistoryFamily(family);
			accountGroupHistoryService.saveAccountGroupHistory(familyHistory);
			GroupMember groupMemberInGroupFamily=standartAccountGroup.createGroupMemberForGroup(family, account);
			groupMemberService.saveGroupMember(groupMemberInGroupFamily);
			
				
			logger.info("IndexController: create base group friend");
			AccountGroup friend = standartAccountGroup.createAccountGroupFriend(account);
			accountGroupService.saveAccountGroup(friend);
			AccountGroupHistory friendHistory = standartAccountGroup.createAccountGroupHistoryFriend(friend);
			accountGroupHistoryService.saveAccountGroupHistory(friendHistory);
			GroupMember groupMemberInGroupFriend= standartAccountGroup.createGroupMemberForGroup(friend, account);
			groupMemberService.saveGroupMember(groupMemberInGroupFriend);
			
			
			logger.info("IndexController: create base group work");
			AccountGroup work = standartAccountGroup.createAccountGroupWork(account);
			accountGroupService.saveAccountGroup(work);
			AccountGroupHistory workHistory = standartAccountGroup.createAccountGroupHistoryFriend(work);
			accountGroupHistoryService.saveAccountGroupHistory(workHistory);
			GroupMember groupMemberInGroupWork=standartAccountGroup.createGroupMemberForGroup(work, account);
			groupMemberService.saveGroupMember(groupMemberInGroupWork);

		}else{
			logger.info("IndexController: create new account and base groups"
					+ " for account failed! Id user must not null.");
			idUser=null;
		}
		return idUser;
	}
	
	/**
	 * Method return status of user sign in. If sign in successful return id user else return null.
	 * Method contain methods which call method for validation email.
	 * 
	 * @type String
	 * @param loginOrEmail
	 * @param password
	 * @param answer
	 * 
	 * @return idUser(Long)
	 */
	@RequestMapping(value="/views/profile/signin/{loginOrEmail}/{password}/{answer}/userdata.json", method = RequestMethod.GET)
	public @ResponseBody Long signIn(@PathVariable("loginOrEmail") String loginOrEmail,@PathVariable("password") String password,
			@PathVariable("answer") String answer){
		
		Long idUser=null;
		Boolean signIn=false;
		SecurityPrompt securityPrompt;
		
		logger.info("IndexController: user sign in, check user security information for autorization in system.");
		
		//email and password
		Boolean isValidEmail=userEmailService.isValidEmail(loginOrEmail);
		if(isValidEmail && !password.equals("undefined")){
			logger.info("IndexController: user sign in by user email and user password");
			idUser=userEmailService.getIdUserByEmail(loginOrEmail);
			UserSecurity userSecurity=userSecurityService.getLoginPasswordByIdUser(idUser);
			if(userSecurity.getUserPassword().equals(password)){
				signIn=true;
			}
			
		//email and answer	
		}else if(isValidEmail && !answer.equals("undefined")){		
			logger.info("IndexController: user sign in by user email and user answer on question");
			idUser=userEmailService.getIdUserByEmail(loginOrEmail);
			securityPrompt=securityPromptService.getSecurityPromptByIdUser(idUser);
			signIn=securityPromptService.signInUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
			
			//generate new password with old login which send on email
			userSecurityService.updateLoginPasswordByIdUser(idUser);
		}	
		
		//login and password
		Boolean isLoginNotExist= userSecurityService.isUniqueLogin(loginOrEmail);
		if(!isLoginNotExist && !password.equals("undefined")){
			logger.info("IndexController: user sign in by user login and password");
			idUser=userSecurityService.getIdUserByLoginPassword(loginOrEmail, password);
			signIn=userSecurityService.signInUserByLoginPassword(loginOrEmail, password);
			
		//login and answer	
		} else if(!isLoginNotExist && !answer.equals("undefined")){	
			logger.info("IndexController: user sign in by user login and answer on question.");
			securityPrompt=securityPromptService.getSecurityPromptByLogin(loginOrEmail);
			idUser=securityPromptService.getIdUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
			signIn=securityPromptService.signInUserByPromptAnswer(securityPrompt.getIdSecurityPrompt(), answer);
			
			//generate new password with old login which send on email
			userSecurityService.updateLoginPasswordByIdUser(idUser);
		}
		
		//result of user autorization
		if(signIn && !idUser.equals(null)){
			logger.info("IndexController: user autorization is successfully");
			return idUser;
			
		}else{
			logger.info("IndexController: user autorization is failed");
			return null;
		}	
	}	
		
	/**
	 * Method return security user question for user. If user give right answer(sign in) user autorizaton
	 * successfully else filed. Simultaneously method call other method for sending new user security
	 * password on user past.
	 * 
	 * @type String
	 * @param loginOrEmail
	 * 
	 * @return SecurityPrompt
	 */
	@RequestMapping(value="/views/profile/signin/{loginOrEmail}/securityquestion.json", method = RequestMethod.GET)
	public @ResponseBody SecurityPrompt getSecurityQuestion(@PathVariable("loginOrEmail") String loginOrEmail){
		
		logger.info("IndexController: user sign in, get security answer for autorization.");
		SecurityPrompt securityPrompt;
		
		//save data which send on view
		SecurityPrompt prompt=new SecurityPrompt();
		UserSecurity userSecurity=new UserSecurity();
		userSecurity.setUserLogin(loginOrEmail);
		prompt.setUserSecurity(userSecurity);
		
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
	
	/**
	 * Method return user role by user id. If user id not exist return null else user role.
	 * 
	 * @type long
	 * @param idUser
	 * 
	 * @return UserRole
	 */
	@RequestMapping(value="/views/profile/signin/{idUser}/userrole.json", method = RequestMethod.GET)
	public @ResponseBody UserRole getUserRole(@PathVariable("idUser") Long idUser){
		
		logger.info("IndexController: get user role after sign");
		UserRole userRole= userSecurityService.getUserRoleAsObjectByIdUser(idUser);

		return userRole;
	}	
}
