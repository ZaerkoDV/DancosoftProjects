/**
 * 
 */
package com.dancosoft.socialcommunity.controller;

import java.io.IOException;
import java.time.LocalDateTime;
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
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.EventPattern;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.model.UserPhoto;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;
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

/**
 * @author Zaerko_DV
 *
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
	
															//account
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
														//single message
	@Autowired
	@Qualifier(value="singleMessageService")
	private SingleMessageService singleMessageService;
	
	public void setSingleMessageService(SingleMessageService singleMessageService) {
		this.singleMessageService = singleMessageService;
	}
															//group
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
																	//forum
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

	
	
	
	
	@RequestMapping(value="/views/profile/admin/parlor/accountdata.json", method = RequestMethod.POST)
	public @ResponseBody UserParlorData loadAdminAccount(@RequestBody Long idAdmin) {
		
		logger.info("AdminController: Load data for admin account.");
		//data for user account
		UserParlorData userParlorData=new UserParlorData();
		
		User user =userService.getUserById(idAdmin);
		userParlorData.setUser(user);
		
		UserAutobiography userAutobiography=userAutobiographyService.getUserAutobiographyByIdUser(idAdmin);
		userParlorData.setUserAutobiography(userAutobiography);
		
		UserEmail userEmail=userEmailService.getEmailByIdUser(idAdmin);
		userParlorData.setUserEmail(userEmail);
		
		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(idAdmin);
		userParlorData.setUserPhoto(userPhoto);
		
		UserLocation userLocation= userLocationService.getUserLocationByIdUser(idAdmin);
		userParlorData.setUserLocation(userLocation);
		
		//history last visit account
		logger.info("UserController: Create date last visit account.");
		Account userAccount=userService.getAccountByUserId(idAdmin);
		AccountHistory accountHistory =accountHistoryService
				.getAccountHistoryByIdAccount(userAccount.getIdAccount());
		accountHistory.setLastVisit(LocalDateTime.now());
		accountHistoryService.updateAccountHistory(accountHistory);	
		
		return userParlorData;
	}
										// edit common profile

	@RequestMapping(value = "/views/profile/admin/parlor/commonadminprofile.json", method = RequestMethod.POST)
	public @ResponseBody User loadCommonAdminProfile(@RequestBody Long idAdmin) {

		logger.info("AdminController: load common admin profile.");
		User user = userService.getUserById(idAdmin);
		return user;
	}
	
	@RequestMapping(value="/views/profile/admin/parlor/editcommonadminprofile.json", method = RequestMethod.POST)
	public @ResponseBody Long editCommonAdminProfile (@RequestBody User admin) {
		logger.info("AdminController: update admin common profile.");
		userService.updateUser(admin);
		return admin.getIdUser();
	}
	
										// edit extended profile
	
	@RequestMapping(value="/views/profile/admin/parlor/extendedadminprofile.json", method = RequestMethod.POST)
	public @ResponseBody UserExtendedData loadExtendedAdminProfile (@RequestBody Long idAdmin) {
		
		logger.info("AdminController: load extended admin profile.");
		UserExtendedData userExtendedData = new UserExtendedData();
		
		logger.info("AdminController: load admin email to update");
		UserEmail userEmail=userEmailService.getEmailByIdUser(idAdmin);
		userExtendedData.setUserEmail(userEmail);
		
//		logger.info("AdminComtroller: load admin autobiography");
//		UserAutobiography userAutobiography = userAutobiographyService.getUserAutobiographyByIdUser(idAdmin);
//		userExtendedData.setUserAutobiography(userAutobiography);
		
		logger.info("AdminController: load admin photo to update");
		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(idAdmin);
//		String pathToPhoto=userPhotoService.loadPathToUserPhoto(id);
//		
//		if(pathToPhoto==null){
//			pathToPhoto="resources/bootstrap/img/default-avatar.png";
//		}
//		userPhoto.setPhotoName(pathToPhoto);
		userExtendedData.setUserPhoto(userPhoto);
		
		logger.info("AdminController: load admin location to update");
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
	
	@RequestMapping(value="/views/profile/admin/parlor/{idAdmin}/editextendedadminprofile.json", method = RequestMethod.POST)
	public @ResponseBody Long editExtendedAdminProfile(@RequestBody String adminExtendedDataJson, @PathVariable("idAdmin") Long idAdmin) {
		
		logger.info("AdminController: update user extended profile.");
		UserExtendedData adminExtendedData =null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			adminExtendedData = mapper.readValue(adminExtendedDataJson, UserExtendedData.class);
			
		} catch (JsonParseException e) {
			logger.info("AdminController: error when json parse class UserExtendedData "+e);
			
		} catch (JsonMappingException e) {
			logger.info("AdminController: error in json mapping for class UserExtendedData "+e);
			
		} catch (IOException e) {
			logger.info("AdminController: input output exeption when read json value of object"
					+ " userExtendedDataJson "+e);
		}

		logger.info("AdminController:Get user for update coresponding field.");
		User user=userService.getUserById(idAdmin);
		
//		logger.info("AdminController:Save(or update) new admin photo.");
//		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(idAdmin);
//		if(userPhoto==null){
//			userPhoto=new UserPhoto();	
//		}
//		
//		userPhoto.setPhotoNote(adminExtendedData.getUserPhoto().getPhotoNote());
//		userPhoto.setUser(user);
//		userPhotoService.updateUserPhoto(userPhoto);
//		logger.info("AdminController:Save new admin photo(on hird drive and name photo to data base).");
//		userPhotoService.savePhotoAsFormat(idAdmin, "jpg", adminExtendedData.getUserPhoto().getPhotoName());
		
		logger.info("AdminController:Get email and update.");
		UserEmail newAdminEmail= adminExtendedData.getUserEmail();
		userEmailService.updateUserEmail(newAdminEmail);	
	
//		logger.info("AdminController: Update admin birth.");
//		UserAutobiography userAutobiography=adminExtendedData.getUserAutobiography();
//		userAutobiographyService.updateUserAutobiography(userAutobiography);		
		
		logger.info("AdminController:Get language for update.");
		Long idNewLanguage=adminExtendedData.getUserLocation().getLanguage().getIdLanguage();
		Language newLanguage=languageService.getLanguageById(idNewLanguage); 
		
		logger.info("AdminController:Get city and country for update.");
		Long idNewCity=adminExtendedData.getUserLocation().getCity().getIdCity();
		City newCity=cityService.getCityById(idNewCity);
		
		logger.info("AdminController:Create new admin location(or update old if exist) and update"
				+ " his language, country, city.");
		UserLocation newAdminLocation=userLocationService.getUserLocationByIdUser(idAdmin);
		if(newAdminLocation==null){
			newAdminLocation=new UserLocation();
		}
		newAdminLocation.setLanguage(newLanguage);
		newAdminLocation.setCity(newCity);
		newAdminLocation.setUser(user);
		userLocationService.updateUserLocation(newAdminLocation);
			
		return idAdmin;
	}
	
												//event pattern
	
	@RequestMapping(value="/views/profile/admin/event/neweventpattern.json", method = RequestMethod.POST)
	public @ResponseBody void saveEventPattern(@RequestBody EventPattern eventPattern) {
		logger.info("AdminController: save new event pattern");
		eventPatternService.saveEventPattern(eventPattern);
	}
	
	@RequestMapping(value="/views/profile/admin/event/{idEventPattern}/deletedeventpattern", method = RequestMethod.GET)
	public @ResponseBody void deleteEventPattern(@PathVariable("idEventPattern") Long idEventPattern) {
		logger.info("AdminController: delete event pattern by id event pattern");
		eventPatternService.deleteEventPatternById(idEventPattern);
	}
	
	@RequestMapping(value="/views/profile/admin/event/updatedeventpattern.json", method = RequestMethod.POST)
	public @ResponseBody void updateEventPattern(@RequestBody EventPattern eventPattern) {
		logger.info("AdminController: update event pattern");
		eventPatternService.updateEventPattern(eventPattern);
	}
	
													//forum
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/admin/parlor/listforum.json", method = RequestMethod.GET)
	public @ResponseBody List<Forum> getListForum() {
		logger.info("AdminController: Load list forum for admin account");
		List<Forum> listForum= (List) forumService.getListForum();
		
		return listForum;
	}
	
	@RequestMapping(value="/views/profile/admin/forum/newforum.json", method = RequestMethod.POST)
	public @ResponseBody void saveNewForum(@RequestBody Forum forum) {
		logger.info("AdminController: save new forum");
		forum.setDateCreateForum(LocalDateTime.now());
		forumService.saveForum(forum);
	}
	
//not convert date	
	@RequestMapping(value="/views/profile/admin/forum/editforum.json", method = RequestMethod.POST)
	public @ResponseBody void updateForum(@RequestBody Forum forum) {
		logger.info("AdminController: update forum");
		forumService.updateForum(forum);
	}
	
	@RequestMapping(value="/views/profile/admin/forum/{idForum}/deletedforum.json", method = RequestMethod.GET)
	public @ResponseBody void deleteForum(@PathVariable Long idForum) {
		logger.info("AdminController: Load list forum for admin account");
		forumService.deleteForumById(idForum);
	}
	
	@RequestMapping(value="/views/profile/admin/forum/newtopic.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewForumTopic(@RequestBody ForumTopic forumTopic) {
		
		logger.info("AdminController: Save new forum topic for forum.");
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
	
	@RequestMapping(value="/views/profile/admin/forum/deleteforumtopic/{idForumTopic}/forumtopic.json", method = RequestMethod.GET)
	public @ResponseBody void deleteForumTopic(@PathVariable Long idForumTopic) {
		logger.info("AdminController: Delete forum topic by id");
		forumTopicService.deleteForumTopicById(idForumTopic);
	}
	
	
	
	
	
	
	
}
