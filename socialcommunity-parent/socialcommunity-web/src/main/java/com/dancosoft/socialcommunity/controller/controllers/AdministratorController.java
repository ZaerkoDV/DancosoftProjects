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
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dancosoft.socialcommunity.controller.support.UserExtendedData;
import com.dancosoft.socialcommunity.controller.support.UserParlorData;
import com.dancosoft.socialcommunity.controller.support.constants.FriendStatus;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.EventPattern;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.model.GroupMessage;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.SingleMessage;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.model.UserPhoto;
import com.dancosoft.socialcommunity.service.AccountForumService;
import com.dancosoft.socialcommunity.service.AccountGroupHistoryService;
import com.dancosoft.socialcommunity.service.AccountGroupService;
import com.dancosoft.socialcommunity.service.AccountHistoryService;
import com.dancosoft.socialcommunity.service.AccountService;
import com.dancosoft.socialcommunity.service.CityService;
import com.dancosoft.socialcommunity.service.CountryService;
import com.dancosoft.socialcommunity.service.EventPatternService;
import com.dancosoft.socialcommunity.service.ForumMessageService;
import com.dancosoft.socialcommunity.service.ForumService;
import com.dancosoft.socialcommunity.service.ForumTopicService;
import com.dancosoft.socialcommunity.service.GroupEventService;
import com.dancosoft.socialcommunity.service.GroupMemberService;
import com.dancosoft.socialcommunity.service.GroupMessageService;
import com.dancosoft.socialcommunity.service.LanguageService;
import com.dancosoft.socialcommunity.service.SingleMessageService;
import com.dancosoft.socialcommunity.service.UserAutobiographyService;
import com.dancosoft.socialcommunity.service.UserCorespondenceService;
import com.dancosoft.socialcommunity.service.UserEmailService;
import com.dancosoft.socialcommunity.service.UserLocationService;
import com.dancosoft.socialcommunity.service.UserPhotoService;
import com.dancosoft.socialcommunity.service.UserService;
import com.dancosoft.socialcommunity.service.UserSocialNetworkService;

import edu.emory.mathcs.backport.java.util.Collections;

/**
 * Class AdministratorController use technologe IoC for work with other layer in
 * application. All methods are public in class. For logging use framework shell
 * slf4j and framework log4j.Class contain also private, static variable logger,
 * which use to call log message.Controller use spring framework for organize
 * request/response mappling. The class AdministratorController contain methods
 * which prepares date for sending in ui service layer. The main task of
 * AdministratorController class is operation which performs user with role
 * administrator. Administrator have extended right which give chance even
 * delete user and account. Class contain method which describe work with data
 * as administrator(role) for user account, account group, forum, single message,
 * edit event pattern and edit profile Also class use enums from package in this module:
 * com.dancosoft.socialcommunity.controller.support.constants for literals. There
 * are: BlockStatus(block, unblock),UserRoleName (admin/user),ViewStatus(public/private).
 * 
 * @version 1.0 12.02.2016
 * 
 * @see org.codehaus.jackson.map.ObjectMapper
 * @see org.springframework.web
 * @see org.springframework.stereotype
 * 
 * @author Denis Zaerko
 */
@Controller(value="administratorController")
public class AdministratorController {

	private static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);
	
	@Autowired
	@Qualifier(value = "userService")
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
	
	public void setUserCorespondenceService(UserCorespondenceService userCorespondenceService) {
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
	
	public void setUserSocialNetworkService(UserSocialNetworkService userSocialNetworkService) {
		this.userSocialNetworkService = userSocialNetworkService;
	}

	@Autowired
	@Qualifier(value="userPhotoService")
	private UserPhotoService userPhotoService;

	public void setUserPhotoService(UserPhotoService userPhotoService) {
		this.userPhotoService = userPhotoService;
	}

	@Autowired
	@Qualifier(value="userLocationService")
	private UserLocationService userLocationService;

	public void setUserLocationService(UserLocationService userLocationService) {
		this.userLocationService = userLocationService;
	}	
	
	@Autowired
	@Qualifier(value="languageService")
	private LanguageService languageService;

	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}

	@Autowired
	@Qualifier(value="countryService")
	private CountryService countryService;

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	@Autowired
	@Qualifier(value="cityService")
	private CityService cityService;
	
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
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
	@Qualifier(value="singleMessageService")
	private SingleMessageService singleMessageService;
	
	public void setSingleMessageService(SingleMessageService singleMessageService) {
		this.singleMessageService = singleMessageService;
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

	@Autowired
	@Qualifier(value="groupMessageService")
	private GroupMessageService groupMessageService;
	
	public void setGroupMessageService(GroupMessageService groupMessageService) {
		this.groupMessageService = groupMessageService;
	}

	@Autowired
	@Qualifier(value="groupEventService")
	private GroupEventService groupEventService;

	public void setGroupEventService(GroupEventService groupEventService) {
		this.groupEventService = groupEventService;
	}
	
	@Autowired
	@Qualifier(value="eventPatternService")
	private EventPatternService eventPatternService;

	public void setEventPatternService(EventPatternService eventPatternService) {
		this.eventPatternService = eventPatternService;
	}
																	
	@Autowired
	@Qualifier(value="accountForumService")
	private AccountForumService accountForumService;
	
	public void setAccountForumService(AccountForumService accountForumService) {
		this.accountForumService = accountForumService;
	}

	@Autowired
	@Qualifier(value="forumService")
	private ForumService forumService;
	
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}
	
	@Autowired
	@Qualifier(value="forumTopicService")
	private ForumTopicService forumTopicService;
	
	public void setForumTopicService(ForumTopicService forumTopicService) {
		this.forumTopicService = forumTopicService;
	}
	
	@Autowired
	@Qualifier(value="forumMessageService")
	private ForumMessageService forumMessageService;
	
	public void setForumMessageService(ForumMessageService forumMessageService) {
		this.forumMessageService = forumMessageService;
	}

	
	/**
	 * Method prepares object UserParlorData (data) for sending in ui service layer.
	 * This object is wapper for other object.
	 * 
	 * @type Long
	 * @param idAdmin
	 * 
	 * @return UserParlorData
	 */
	@RequestMapping(value="/views/profile/admin/{idAdmin}/parlor/accountdata.json", method = RequestMethod.GET)
	public @ResponseBody UserParlorData loadAdminData(@PathVariable("idAdmin") Long idAdmin) {
		
		logger.info("AdministratorController: Load data for admin account.");
		//data for user account
		UserParlorData userParlorData=new UserParlorData();
		
		User user =userService.getUserById(idAdmin);
		userParlorData.setUser(user);
		
		UserAutobiography userAutobiography=userAutobiographyService.getUserAutobiographyByIdUser(idAdmin);
		userParlorData.setUserAutobiography(userAutobiography);
		
		UserEmail userEmail=userEmailService.getEmailByIdUser(idAdmin);
		userParlorData.setUserEmail(userEmail);
		
//		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(idAdmin);
//		userPhoto.setPhotoName(userPhotoService.loadPathToUserPhoto(idAdmin));
//		userParlorData.setUserPhoto(userPhoto);
		
		UserLocation userLocation= userLocationService.getUserLocationByIdUser(idAdmin);
		userParlorData.setUserLocation(userLocation);
		
		//history last visit account
		logger.info("AdministratorController: Create date last visit account.");
		Account userAccount=userService.getAccountByUserId(idAdmin);
		AccountHistory accountHistory =accountHistoryService.getAccountHistoryByIdAccount(userAccount.getIdAccount());
		accountHistory.setLastVisit(LocalDateTime.now());
		accountHistoryService.updateAccountHistory(accountHistory);	
		
		return userParlorData;
	}
										// edit common profile
	/**
	 * Method prepares User (data) for sending in ui service layer.
	 * User contain data for user common profile. 
	 * 
	 * @type Long
	 * @param idAdmin
	 * 
	 * @return User
	 */
	@RequestMapping(value = "/views/profile/admin/{idAdmin}/parlor/commonadminprofile.json", method = RequestMethod.GET)
	public @ResponseBody User loadCommonAdminProfileData(@PathVariable("idAdmin") Long idAdmin) {
		logger.info("AdministratorController: load common admin profile.");
		User user = userService.getUserById(idAdmin);
		return user;
	}
	
	/**
	 * Method update data about user common profile.
	 * 
	 * @type User
	 * @param admin
	 * 
	 * @return idAdmin(Long)
	 */
	@RequestMapping(value="/views/profile/admin/parlor/editcommonadminprofile.json", method = RequestMethod.PUT)
	public @ResponseBody Long editCommonAdminProfile (@RequestBody User admin) {
		logger.info("AdministratorController: update admin common profile.");
		userService.updateUser(admin);
		return admin.getIdUser();
	}
	
									// edit extended profile
	/**
	 * Method prepares UserExtendedData (data) for sending in ui service layer.
	 * UserExtendedData contain data for user extended profile. This class is
	 * class wapper other objects. 
	 * 
	 * @type Long
	 * @param idAdmin
	 * 
	 * @return UserExtendedData
	 */
	@RequestMapping(value="/views/profile/admin/{idAdmin}/parlor/extendedadminprofile.json", method = RequestMethod.GET)
	public @ResponseBody UserExtendedData loadExtendedAdminProfileData(@PathVariable("idAdmin") Long idAdmin) {
		
		logger.info("AdministratorController: load extended admin profile.");
		UserExtendedData userExtendedData = new UserExtendedData();
		
		logger.info("AdministratorController: load admin email to update");
		UserEmail userEmail=userEmailService.getEmailByIdUser(idAdmin);
		userExtendedData.setUserEmail(userEmail);
		
		logger.info("AdministratorController: load admin autobiography");
		UserAutobiography userAutobiography = userAutobiographyService.getUserAutobiographyByIdUser(idAdmin);
		userExtendedData.setUserAutobiography(userAutobiography);
		
		logger.info("AdministratorController: load admin photo to update");
		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(idAdmin);
//		String pathToPhoto=userPhotoService.loadPathToUserPhoto(id);
//		
//		if(pathToPhoto==null){
//			pathToPhoto="resources/bootstrap/img/default-avatar.png";
//		}
//		userPhoto.setPhotoName(pathToPhoto);
		userExtendedData.setUserPhoto(userPhoto);
		
		logger.info("AdministratorController: load admin location to update");
		UserLocation userLocation=userLocationService.getUserLocationByIdUser(idAdmin);
		
		if(userLocation!=null){
			Language language= userLocationService.getUserLanguageByIdUser(idAdmin);
			userLocation.setLanguage(language);
			Country country= userLocationService.getUserCountryByIdUser(idAdmin);
			City city =userLocationService.getUserCityByIdUser(idAdmin);
			city.setCountry(country);		
			userLocation.setCity(city);
		}
		userExtendedData.setUserLocation(userLocation);
		
		return userExtendedData;
	}

	/**
	 * Method update administrator extended profile(data). For converting json
	 * format object to object use ObjectMapper. If convering failed thow exeption.
	 * 
	 * @type Long
	 * @type String
	 * @param idAdmin
	 * @param adminExtendedDataJson
	 * 
	 * @exception JsonParseException
	 * @exception JsonMappingException
	 * @exception IOException
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/admin/parlor/{idAdmin}/editextendedadminprofile.json", method = RequestMethod.PUT)
	public @ResponseBody Long editExtendedAdminProfile(@RequestBody String adminExtendedDataJson,@PathVariable("idAdmin") Long idAdmin) {
		
		logger.info("AdministratorController: update user extended profile.");
		UserExtendedData adminExtendedData =null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			adminExtendedData = mapper.readValue(adminExtendedDataJson, UserExtendedData.class);
			
		} catch (JsonParseException e) {
			logger.info("AdministratorController: error when json parse class UserExtendedData "+e);
			
		} catch (JsonMappingException e) {
			logger.info("AdministratorController: error in json mapping for class UserExtendedData "+e);
			
		} catch (IOException e) {
			logger.info("AdministratorController: input output exeption when read json value of object"
					+ " userExtendedDataJson "+e);
		}

		logger.info("AdministratorController:Get user for update coresponding field.");
		User user=userService.getUserById(idAdmin);
		
//		logger.info("AdministratorController:Save(or update) new admin photo.");
//		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(idAdmin);
//		if(userPhoto==null){
//			userPhoto=new UserPhoto();	
//		}
//		userPhoto.setPhotoNote(adminExtendedData.getUserPhoto().getPhotoNote());
//		userPhoto.setUser(user);
//		userPhotoService.updateUserPhoto(userPhoto);
//		logger.info("AdministratorController:Save new admin photo(on hird drive and name photo to data base).");
//		userPhotoService.savePhotoAsFormat(idAdmin, "jpg", adminExtendedData.getUserPhoto().getPhotoName());
		
		logger.info("AdministratorController:Get email and update.");
		UserEmail newAdminEmail= adminExtendedData.getUserEmail();
		userEmailService.updateUserEmail(newAdminEmail);	
	
		logger.info("AdministratorController:Update admin Autobiography.");
		UserAutobiography userAutobiography=adminExtendedData.getUserAutobiography();
		userAutobiographyService.updateUserAutobiography(userAutobiography);
			
		logger.info("AdministratorController:Create new admin location(or update old if exist) and update"
				+ " his language, country, city.");
		UserLocation newAdminLocation=userLocationService.getUserLocationByIdUser(idAdmin);
		if(newAdminLocation==null){
			newAdminLocation=new UserLocation();
		}
		
		Language newLanguage = null;
		City newCity=null;
		if(adminExtendedData.getUserLocation()!=null){
			if(adminExtendedData.getUserLocation().getLanguage()!=null){
				logger.info("AdministratorController:Get language for update.");
				Long idNewLanguage=adminExtendedData.getUserLocation().getLanguage().getIdLanguage();
				newLanguage=languageService.getLanguageById(idNewLanguage); 	
				newAdminLocation.setLanguage(newLanguage);
			}
			
			if(adminExtendedData.getUserLocation().getCity()!=null){
				logger.info("AdministratorController:Get city and country for update.");
				Long idNewCity=adminExtendedData.getUserLocation().getCity().getIdCity();
				newCity=cityService.getCityById(idNewCity);
				newAdminLocation.setCity(newCity);
			}
		}
		newAdminLocation.setUser(user);
		userLocationService.updateUserLocation(newAdminLocation);
			
		return idAdmin;
	}
												//event pattern
	/**
	 * Method save new event pattern.
	 * 
	 * @type EventPattern
	 * @param eventPattern
	 */
	@RequestMapping(value="/views/profile/admin/event/neweventpattern.json", method = RequestMethod.POST)
	public @ResponseBody void saveEventPattern(@RequestBody EventPattern eventPattern) {
		logger.info("AdministratorController: save new event pattern");
		eventPatternService.saveEventPattern(eventPattern);
	}
	
	/**
	 * Method delete event patttern by idEventPattern. 
	 * 
	 * @type Long
	 * @param idEventPattern
	 */
	@RequestMapping(value="/views/profile/admin/event/{idEventPattern}/deletedeventpattern", method = RequestMethod.DELETE)
	public @ResponseBody void deleteEventPattern(@PathVariable("idEventPattern") Long idEventPattern) {
		logger.info("AdministratorController: delete event pattern by id event pattern");
		eventPatternService.deleteEventPatternById(idEventPattern);
	}
	
	/**
	 * Method update event patttern by idEventPattern. 
	 * 
	 * @type Long
	 * @param idEventPattern
	 */
	@RequestMapping(value="/views/profile/admin/event/updatedeventpattern.json", method = RequestMethod.PUT)
	public @ResponseBody void updateEventPattern(@RequestBody EventPattern eventPattern) {
		logger.info("AdministratorController: update event pattern");
		eventPatternService.updateEventPattern(eventPattern);
	}
													//forum
	/**
	 * Method prepares List<Forum> (data) for sending in ui service layer.
	 * This List contain list forum. If List<Forum> is empty
	 * return empty list else return list with objects.
	 * 
	 * @return List<Forum>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/admin/parlor/listforum.json", method = RequestMethod.GET)
	public @ResponseBody List<Forum> getListForum() {
		logger.info("AdministratorController: Load list forum for admin account");
		List<Forum> listForum= (List) forumService.getListForum();
		
		return listForum;
	}
	
	/**
	 * Method save new forum.
	 * 
	 * @type Forum
	 * @param forum
	 */
	@RequestMapping(value="/views/profile/admin/forum/newforum.json", method = RequestMethod.POST)
	public @ResponseBody void saveNewForum(@RequestBody Forum forum) {
		logger.info("AdministratorController: save new forum");
		forum.setDateCreateForum(LocalDateTime.now());
		forumService.saveForum(forum);
	}
	
	/**
	 * Method delete forum by idForum
	 * 
	 * @type Long
	 * @param idForum
	 */
	@RequestMapping(value="/views/profile/admin/forum/{idForum}/deletedforum.json", method = RequestMethod.DELETE)
	public @ResponseBody void deleteForum(@PathVariable Long idForum) {
		logger.info("AdministratorController: Load list forum for admin account");
		forumService.deleteForumById(idForum);
	}
	
	/**
	 * Method update forum by idForum
	 * 
	 * @type Long
	 * @param idForum
	 */
	@RequestMapping(value="/views/profile/admin/forum/editforum.json", method = RequestMethod.PUT)
	public @ResponseBody void updateForum(@RequestBody Forum forum) {
		logger.info("AdministratorController: update forum");
		forumService.updateForum(forum);
	}
	
	/**
	 * Method save new forum topic.
	 * 
	 * @type ForumTopic
	 * @param forumTopic
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/admin/forum/newtopic.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewForumTopic(@RequestBody ForumTopic forumTopic) {
		
		logger.info("AdministratorController: Save new forum topic for forum.");
		Long idUser=forumTopic.getAuthorAccount().getUser().getIdUser();
		Account userAccount=userService.getAccountByUserId(idUser);
		
		Long idForum=forumTopic.getForum().getIdForum();
		Forum forum = forumService.getForumById(idForum);
		
		forumTopic.setAuthorAccount(userAccount);
		forumTopic.setForum(forum);
		forumTopic.setDateCreateForumTopic(LocalDateTime.now());
		forumTopicService.saveForumTopic(forumTopic);
		
		return idForum;
	}
	
	/**
	 * Method delete new forum topic by idForumTopic
	 * 
	 * @type ForumTopic
	 * @param idForumTopic
	 */
	@RequestMapping(value="/views/profile/admin/forum/deleteforumtopic/{idForumTopic}/forumtopic.json", method = RequestMethod.DELETE)
	public @ResponseBody void deleteForumTopic(@PathVariable("idForumTopic") Long idForumTopic) {
		logger.info("AdministratorController: Delete forum topic by id");
		forumTopicService.deleteForumTopicById(idForumTopic);
	}
	
	/**
	 * Method update new forum topic by idForumTopic
	 * 
	 * @type ForumTopic
	 * @param idForumTopic
	 */
	@RequestMapping(value="/views/profile/admin/forum/updateforumtopic.json", method = RequestMethod.PUT)
	public @ResponseBody void updateForumTopic(@RequestBody ForumTopic forumTopic) {
		logger.info("AdministratorController: Update forum topic.");
		forumTopicService.updateForumTopic(forumTopic);
	}
	
	/**
	 * Method prepares List<ForumMessage> (data) for sending in ui service layer
	 * by id forumTopic.This List contain list forum messages. If List is empty
	 * return empty list else return list with objects.  
	 * 
	 * @return List<ForumMessage>
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/profile/admin/forum/{idForumTopic}/{fromDate}/{toDate}/topicmessages.json", method = RequestMethod.GET)
	public @ResponseBody List<ForumMessage> loadForumTopicMessages(@PathVariable("idForumTopic") Long idForumTopic,
			@PathVariable("fromDate") Date fromDate,@PathVariable("toDate") Date toDate) {
		logger.info("AdministratorController: Load Forum Messages which created between date.");
		TimeConverter converter = new TimeConverter();
		LocalDateTime fromLDT = converter.convertDateToLocalDateTime(fromDate);
		LocalDateTime toLDT = converter.convertDateToLocalDateTime(toDate);
		
		List<ForumMessage> listTopicMessages = forumMessageService
				.getListForumMessageBetweenDateByIdForumTopic(idForumTopic, fromLDT,toLDT);
		if(fromLDT.isAfter(toLDT)){
			listTopicMessages=Collections.emptyList();
		}
		return listTopicMessages;
	}
	
	/**
	 * Method prepares List<Account>(data) for sending in ui service layer
	 * This list contain list account by account name. If List is empty
	 * return empty list else return list with objects.
	 * 
	 * @type Account
	 * @param account
	 * 
	 * @return List<Account> 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/admin/account/searchaccount.json", method = RequestMethod.POST)
	public @ResponseBody List<Account> searchAccount(@RequestBody Account account) {
		logger.info("AdministratorController: search account by account name");
		List<Account> accountList;
		if(account.getAccountName().equals("")){
			accountList=(List)accountService.getListAccount();
		}else{
			accountList=accountService.searchAccountByAccountNameUserLastName(account.getAccountName(), "");
		}
		return accountList;
	}
	
	/**
	 * Method change account block status and after return account.
	 * 
	 * @type Account
	 * @type String
	 * @param account
	 * @param blockStatus
	 * 
	 * @return Account
	 */
	@RequestMapping(value="/views/profile/admin/account/{blockStatus}/newblockstatus.json", method = RequestMethod.PUT)
	public @ResponseBody Account changeAccountBlockStatus(@RequestBody Account account,
			@PathVariable("blockStatus") String blockStatus) {
		logger.info("AdministratorController: change account block status.");
		account.setAccountBlockStatus(blockStatus);
		accountService.updateAccount(account);
				
		return account;
	}
	
	/**
	 * Method delete account and user by id account.
	 * 
	 * @type Long
	 * @param idAccount
	 * 
	 * @return Account
	 */
	@RequestMapping(value="/views/profile/admin/account/{idAccount}/deleteaccount.json", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAccount(@PathVariable("idAccount") Long idAccount) {
		Account account= accountService.getAccountById(idAccount);
		Long idUser= account.getUser().getIdUser();
		logger.info("AdministratorController: delete user account="+idAccount);
		accountService.deleteAccountById(idAccount);
		logger.info("AdministratorController: delete user= "+idUser);
		userService.deleteUserById(idUser);
	}
	
	/**
	 * Method prepares List<SingleMessage>(data) for sending in ui service layer
	 * This list contain list single messages which created between date.If List
	 * is empty return empty list else return list with objects.
	 * 
	 * @type Long
	 * @type Date
	 * @param searchIdAccount
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return List<SingleMessage> 
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/profile/admin/account/{searchIdAccount}/{fromDate}/{toDate}/singlemessages.json", method = RequestMethod.GET)
	public @ResponseBody List<SingleMessage> loadUserAccountSingleMessages(@PathVariable("searchIdAccount") Long searchIdAccount,
			@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate) {
		
		logger.info("AdministratorController:Load user account single messages.");
		TimeConverter converter = new TimeConverter();
		LocalDateTime fromLDT = converter.convertDateToLocalDateTime(fromDate);
		LocalDateTime toLDT = converter.convertDateToLocalDateTime(toDate);
		
		List<SingleMessage> listSingleMessages = singleMessageService
				.getListSingleMessageBeetweenDateByIdAccount(searchIdAccount, fromLDT, toLDT);	
		if(fromLDT.isAfter(toLDT)){
			listSingleMessages=Collections.emptyList();
		}
		return listSingleMessages;		
	}
	
	/**
	 * Method prepares List<AccountGroup>(data) for sending in ui service layer.Method
	 * return result search account group by group name and by account name. This list
	 * contain list account group by group name and account name.
	 * 
	 * @type String
	 * @param groupName
	 * @param accountName
	 * 
	 * @return List<AccountGroup> 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/admin/group/{groupName}/{accountName}/searchAccountGroup.json", method = RequestMethod.GET)
	public @ResponseBody List<AccountGroup> searchAccountGroup(@PathVariable("groupName") String groupName,
			@PathVariable("accountName") String accountName) {
		
		logger.info("AdministratorController: search account group.");

		if(groupName.equals("undefined")){
			groupName=null;
		}
		if(accountName.equals("undefined")){
			accountName=null;
		}
		
		List<AccountGroup> listAccountGroup;	
		if(groupName!=null || accountName!=null){
			listAccountGroup=accountGroupService.searchAccountGroupByGroupNameAccountName(groupName, accountName);	
		}else{
			listAccountGroup=(List)accountGroupService.getListAccountGroup();
		}
		return listAccountGroup;
	}
	
	/**
	 * Method change account group block status and after return account group.
	 * 
	 * @type AccountGroup
	 * @type String
	 * @param accountGroup
	 * @param blockStatus
	 * 
	 * @return AccountGroup
	 */
	@RequestMapping(value="/views/profile/admin/group/{blockStatus}/newblockstatus.json", method = RequestMethod.PUT)
	public @ResponseBody AccountGroup changeAccountGroupBlockStatus(@RequestBody AccountGroup accountGroup,
			@PathVariable("blockStatus") String blockStatus) {
		logger.info("AdministratorController: change account group block status.");
		accountGroup.setAccountGroupBlockStatus(blockStatus);
		accountGroupService.updateAccountGroup(accountGroup);
				
		return accountGroup;
	}
	
	/**
	 * Method delete account group by idAccountGroup
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return AccountGroup
	 */
	@RequestMapping(value="/views/profile/admin/group/{idAccountGroup}/deleteaccountgroup.json", method = RequestMethod.DELETE)
	public @ResponseBody void deleteAccountGroup(@PathVariable("idAccountGroup") Long idAccountGroup) {
		logger.info("AdministratorController: delete user account group="+idAccountGroup);
		accountGroupService.deleteAccountGroupById(idAccountGroup);
	}

	/**
	 * Method prepares List<GroupMessage> (data) for sending in ui service layer
	 * This List contain list group messages which create between date. If List
	 * is empty return empty list else return list with objects.  
	 * 
	 * @type Long
	 * @type Date
	 * @param idAccountGroup
	 * @param fromDate
	 * @param toDate
	 * 
	 * @return List<GroupMessage>
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/profile/admin/group/{idAccountGroup}/{fromDate}/{toDate}/groupmessages.json", method = RequestMethod.GET)
	public @ResponseBody List<GroupMessage> loadAccounrGroupMessages(@PathVariable("idAccountGroup") Long idAccountGroup,
			@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate) {
		
		logger.info("AdministratorController:Load account group messages.");
		TimeConverter converter = new TimeConverter();
		LocalDateTime fromLDT = converter.convertDateToLocalDateTime(fromDate);
		LocalDateTime toLDT = converter.convertDateToLocalDateTime(toDate);
		
		List<GroupMessage> listGroupMessages = groupMessageService
					.getListGroupMessageBeetweenDateByIdAccountGroup(idAccountGroup, fromLDT, toLDT);
		if(fromLDT.isAfter(toLDT)){
			listGroupMessages=Collections.emptyList();
		}
		return listGroupMessages;		
	}
	
	/**
	 * Method save new account group messages. 
	 * 
	 * @type Long
	 * @type GroupMessage
	 * @param idAdmin
	 * @param idAccountGroup
	 * @param newGroupMessage
	 */
	@RequestMapping(value="/views/profile/admin/{idAdmin}/group/{idAccountGroup}/saveAccountGroupMessage.json", method = RequestMethod.POST)
	public @ResponseBody void saveNewAccountGroupMessages(@RequestBody GroupMessage newAccountGroupMessage,
			@PathVariable("idAdmin") Long idAdmin, @PathVariable("idAccountGroup") Long idAccountGroup) {
		
		logger.info("AdministratorController: Create new group message.");
		Account account= userService.getAccountByUserId(idAdmin);
		GroupMember groupMember= groupMemberService.getGroupMemberInAccountGroupByIdAccount(idAccountGroup,
				account.getIdAccount());
		
		if(groupMember==null){	
			logger.info("AdministratorController: Save admin account as group member account,"
					+ " becouse admin create messages never before");
			groupMember= new GroupMember();
			groupMember.setGroupMemberStatus(FriendStatus.NOTFRIEND.toString());
			AccountGroup accountGroup= accountGroupService.getAccountGroupById(idAccountGroup);
			groupMember.setAccountGroup(accountGroup);
			groupMember.setMemberAccount(account);
			groupMemberService.saveGroupMember(groupMember);
		}
		logger.info("AdministratorController: Create new group message.");
		newAccountGroupMessage.setDateCreateGroupMessage(LocalDateTime.now());
		newAccountGroupMessage.setGroupMember(groupMember);
		groupMessageService.saveGroupMessage(newAccountGroupMessage);
	}
	
	/**
	 * Method prepares List<GroupMember>(data) for sending in ui service layer
	 * This List contain list group members. If List is empty return empty list
	 * else return list with objects.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupMember>
	 */
	@RequestMapping(value="/views/profile/admin/group/{idAccountGroup}/listgroupmembers.json", method = RequestMethod.GET)
	public @ResponseBody List<GroupMember> loadListGroupMembers(@PathVariable("idAccountGroup") Long idAccountGroup) {
		logger.info("AdministratorController: load list group members for account group="+idAccountGroup);
		List<GroupMember> listGroupMembers=groupMemberService.getListGroupMemberByIdAccountGroup(idAccountGroup);
		
		return listGroupMembers;
	}	
}
