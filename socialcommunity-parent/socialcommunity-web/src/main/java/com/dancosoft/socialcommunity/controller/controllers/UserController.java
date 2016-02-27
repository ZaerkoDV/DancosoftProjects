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

import com.dancosoft.socialcommunity.controller.support.SearchPatternData;
import com.dancosoft.socialcommunity.controller.support.UserExtendedData;
import com.dancosoft.socialcommunity.controller.support.UserParlorData;
import com.dancosoft.socialcommunity.controller.support.constants.BlockStatus;
import com.dancosoft.socialcommunity.controller.support.constants.FriendStatus;
import com.dancosoft.socialcommunity.controller.support.constants.ViewStatus;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
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
 * Class UserController use technologe IoC for work with other layer in application. All methods
 * are public in class. For logging use framework shell slf4j and framework log4j.Class contain
 * also private, static variable logger, which use to call log message.Controller use spring
 * framework for organize request/response mappling. 
 * The class UserController contain methods which prepares date for sending in ui service layer.
 * The main task of UserController class is operation which performs user with role user. Class contain
 * method which describe work with data as user(role) for user account, account group, forum,
 * single message and edit profile. Also class use enums from package in this module:
 * com.dancosoft.socialcommunity.controller.support.constants for literals. Ther are:
 * BlockStatus(block, unblock),UserRoleName (admin/user), ViewStatus(public/private).
 * 
 * @version 1.0 12.02.2016
 * 
 * @see org.codehaus.jackson.map.ObjectMapper
 * @see org.springframework.web
 * @see org.springframework.stereotype
 * 
 * @author Denis Zaerko
 */
@Controller(value = "userController")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private final Long adultValue=(long)18;
	
	public TimeConverter converter =new TimeConverter();
	
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
	
	
													//user account
	/**
	 * Method prepares object UserParlorData (data) for sending in ui service layer.
	 * This object is wapper for other object.
	 * 
	 * @type Long
	 * @param id
	 * 
	 * @return UserParlorData
	 */
	@RequestMapping(value="/views/profile/user/{id}/parlor/accountdata.json", method = RequestMethod.GET)
	public @ResponseBody UserParlorData loadUserData(@PathVariable("id") Long id) {
	
		logger.info("UserController: Load data for user account.");
		//data for user account
		UserParlorData userParlorData=new UserParlorData();
		
		User user =userService.getUserById(id);
		userParlorData.setUser(user);
		
		UserAutobiography userAutobiography=userAutobiographyService.getUserAutobiographyByIdUser(id);
		userParlorData.setUserAutobiography(userAutobiography);
		
		UserEmail userEmail=userEmailService.getEmailByIdUser(id);
		userParlorData.setUserEmail(userEmail);
		
//		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(id);
//		userPhoto.setPhotoName(userPhotoService.loadPathToUserPhoto(id));
//		userParlorData.setUserPhoto(userPhoto);
		
		UserLocation userLocation= userLocationService.getUserLocationByIdUser(id);
		userParlorData.setUserLocation(userLocation);
		
		//history last visit account
		logger.info("UserController: Create date last visit account.");
		Account userAccount=userService.getAccountByUserId(id);
		AccountHistory accountHistory =accountHistoryService.getAccountHistoryByIdAccount(userAccount.getIdAccount());
		accountHistory.setLastVisit(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountHistoryService.updateAccountHistory(accountHistory);	
		
		return userParlorData;
	}
	
	/**
	 * Method prepares List<AccountGroup> (data) for sending in ui service layer.
	 * This List contain account group for user by user id. If List<AccountGroup>
	 * is empty return empty list else return list with objects.
	 * 
	 * @type Long
	 * @param id
	 * 
	 * @return List<AccountGroup>
	 */
	@RequestMapping(value="/views/profile/user/{id}/parlor/listaccountgroup.json", method = RequestMethod.GET)
	public @ResponseBody List<AccountGroup> getListAccountGroup(@PathVariable("id") Long id) {
		
		logger.info("UserController: Load list of user account groups.");
		Account userAccount=userService.getAccountByUserId(id);
		List<AccountGroup> listAccountGroup=accountGroupService
				.getListAccountGroupWithBlockStatusByIdAccount(userAccount.getIdAccount(),BlockStatus.UNBLOCK.toString());
		
		return listAccountGroup;
	}
	
	/**
	 * Method prepares List<Forum> (data) for sending in ui service layer.
	 * This List contain forum for user by user id. If List<Forum> is empty
	 * return empty list else return list with objects. Method call other
	 * method to check user on adults value.
	 * 
	 * @type Long
	 * @param id
	 * 
	 * @return List<Forum>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/user/{id}/parlor/listforum.json", method = RequestMethod.GET)
	public @ResponseBody List<Forum> getListForum(@PathVariable("id") Long id) {
		
		logger.info("UserController: Load list forum for user account");
		List<Forum> listForum;	
		Boolean isUserAdult=userAutobiographyService.isUserAdult(id, adultValue);
		
		if(isUserAdult){
			logger.info("UserController: Check user on adult. User is adult.");
			listForum= (List) forumService.getListForum();
			
		}else{
			logger.info("UserController: Check user on adult. User is not adult.");
			listForum= (List)forumService.getListForumWithStatus(ViewStatus.PUBLIC.toString());
		}
		return listForum;
	}
	
											//edit user profile
	/**
	 * Method prepares user data for sending in ui service layer.
	 * If user with id exist return user data else return null.
	 * 
	 * @type Long
	 * @param id
	 * 
	 * @return User
	 */
	@RequestMapping(value="/views/profile/user/{id}/parlor/commonuserprofile.json", method = RequestMethod.GET)
	public @ResponseBody User loadCommonUserProfileData(@PathVariable("id") Long id) {
		logger.info("UserController: load common user profile.");
		User user =userService.getUserById(id);
		return user;
	}
	
	/**
	 * Method update data about user common profile.
	 * 
	 * @type Long
	 * @type User
	 * @param id
	 * @param user
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/user/parlor/{id}/editcommonprofile.json", method = RequestMethod.PUT)
	public @ResponseBody Long editCommonUserProfile(@RequestBody User user, @PathVariable("id") Long id) {
		logger.info("UserController: update user common profile.");
		userService.updateUser(user);
		return id;
	}
	
	/**
	 * Method prepares UserExtendedData (data) for sending in ui service layer.
	 * UserExtendedData contain data for user extended profile. This class is
	 * class wapper other objects. 
	 * 
	 * @type Long
	 * @param id
	 * 
	 * @return UserExtendedData
	 */
	@RequestMapping(value="/views/profile/user/{id}/parlor/extendeduserprofile.json", method = RequestMethod.GET)
	public @ResponseBody UserExtendedData loadExtendedUserProfileData(@PathVariable("id") Long id) {
		
		logger.info("UserController: load extended user profile.");
		UserExtendedData userExtendedData =new UserExtendedData();
		
		logger.info("UserController: load user email to update");
		UserEmail userEmail = userEmailService.getEmailByIdUser(id);
		userExtendedData.setUserEmail(userEmail);
		
		logger.info("UserController: load user social network to update");
		UserSocialNetwork userSocialNetwork=userSocialNetworkService
				.getSocialNetworkWithStatusByIdUser(id,ViewStatus.PRIVATE.toString());
		if(userSocialNetwork!=null){
			userExtendedData.setUserSocialNetwork(userSocialNetwork);
		}
			
		logger.info("UserController: load user photo to update");
		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(id);
//		String pathToPhoto=userPhotoService.loadPathToUserPhoto(id);
//		
//		if(pathToPhoto==null){
//			pathToPhoto="resources/bootstrap/img/default-avatar.png";
//		}
//		userPhoto.setPhotoName(pathToPhoto);
		userExtendedData.setUserPhoto(userPhoto);
		
		logger.info("UserController: load user location to update");
		UserLocation userLocation=userLocationService.getUserLocationByIdUser(id);
		
		if(userLocation!=null){
			Language language= userLocationService.getUserLanguageByIdUser(id);
			userLocation.setLanguage(language);
			Country country= userLocationService.getUserCountryByIdUser(id);
			City city =userLocationService.getUserCityByIdUser(id);
			city.setCountry(country);		
			userLocation.setCity(city);
		}
		userExtendedData.setUserLocation(userLocation);
		
		return userExtendedData;
	}
	
	/**
	 * Method update user extended profile(data). For converting json format object
	 * to object use ObjectMapper. If convering failed thow exeption.
	 * 
	 * @type Long
	 * @type String
	 * @param id
	 * @param userExtendedDataJson
	 * 
	 * @exception JsonParseException
	 * @exception JsonMappingException
	 * @exception IOException
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/user/{id}/parlor/editextendedprofile.json", method = RequestMethod.PUT)
	public @ResponseBody Long editExtendedUserProfile(@RequestBody String userExtendedDataJson, @PathVariable("id") Long id) {
		
		logger.info("UserController: update user extended profile.");
		UserExtendedData userExtendedData =null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			userExtendedData = mapper.readValue(userExtendedDataJson, UserExtendedData.class);
			
		} catch (JsonParseException e) {
			logger.info("UserController: error when json parse class UserExtendedData "+e);
			
		} catch (JsonMappingException e) {
			logger.info("UserController: error in json mapping for class UserExtendedData "+e);
			
		} catch (IOException e) {
			logger.info("UserController: input output exeption when read json value of object"
					+ " userExtendedDataJson "+e);
		}

		logger.info("UserController:Get user for update coresponding field.");
		User user=userService.getUserById(id);
		
//		logger.info("UserController:Save(or update) new user photo.");
//		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(id);
//		if(userPhoto==null){
//			userPhoto=new UserPhoto();	
//		}
//		
//		userPhoto.setPhotoNote(userExtendedData.getUserPhoto().getPhotoNote());
//		userPhoto.setUser(user);
//		userPhotoService.updateUserPhoto(userPhoto);
//		logger.info("UserController:Save new user photo(on hird drive and name photo to data base).");
//		userPhotoService.savePhotoAsFormat(id, "jpg", userExtendedData.getUserPhoto().getPhotoName());
		
		logger.info("UserController:Get email and update.");
		UserEmail newUserEmail= userExtendedData.getUserEmail();
		userEmailService.updateUserEmail(newUserEmail);	
	
		logger.info("UserController:Create new social network (or update old if exist) and"
				+ " update skype and facebook corespondence");
		UserSocialNetwork userSocialNetwork;
		UserSocialNetwork userSocialNetworkOld = userSocialNetworkService.getSocialNetworkWithStatusByIdUser(id,
				ViewStatus.PRIVATE.toString());
		
		//if user have old social address
		if(userSocialNetworkOld !=null){
			userSocialNetwork=userSocialNetworkOld;
			if(userExtendedData.getUserSocialNetwork()!=null){
				if(userExtendedData.getUserSocialNetwork().getFacebookAddress()!=null){
					userSocialNetwork.setFacebookAddress(userExtendedData.getUserSocialNetwork().getFacebookAddress());	
				}
				if(userExtendedData.getUserSocialNetwork().getSkypeAddress()!=null){
					userSocialNetwork.setSkypeAddress(userExtendedData.getUserSocialNetwork().getSkypeAddress());
				}
			}
			userSocialNetwork.setUserCorespondence(newUserEmail.getUserCorespondence());
			userSocialNetworkService.updateUserSocialNetwork(userSocialNetwork);
			
		//if user not have social address before
		}else{
			userSocialNetwork= new UserSocialNetwork();
			if(userExtendedData.getUserSocialNetwork()!=null){
				if(userExtendedData.getUserSocialNetwork().getFacebookAddress()!=null){
					userSocialNetwork.setFacebookAddress(userExtendedData.getUserSocialNetwork().getFacebookAddress());	
				}
				if(userExtendedData.getUserSocialNetwork().getSkypeAddress()!=null){
					userSocialNetwork.setSkypeAddress(userExtendedData.getUserSocialNetwork().getSkypeAddress());
				}
			}
			if(newUserEmail.getUserCorespondence()!=null){
				userSocialNetwork.setUserCorespondence(newUserEmail.getUserCorespondence());
			}
			userSocialNetworkService.saveUserSocialNetwork(userSocialNetwork);
		}
		
		logger.info("UserController:Create new user location(or update old if exist) and update his language, country, city.");
		UserLocation newUserLocation=userLocationService.getUserLocationByIdUser(id);
		if(newUserLocation==null){
			newUserLocation=new UserLocation();
		}
		if(userExtendedData.getUserLocation()!=null){
			if(userExtendedData.getUserLocation().getLanguage()!=null){
				logger.info("UserController:Get language for update.");
				Long idNewLanguage=userExtendedData.getUserLocation().getLanguage().getIdLanguage();
				newUserLocation.setLanguage(languageService.getLanguageById(idNewLanguage));
			}
			
			if(userExtendedData.getUserLocation().getCity()!=null){
				logger.info("UserController:Get city and country for update.");
				Long idNewCity=userExtendedData.getUserLocation().getCity().getIdCity();
				newUserLocation.setCity(cityService.getCityById(idNewCity));
			}	
		}
		newUserLocation.setUser(user);
		userLocationService.updateUserLocation(newUserLocation);
		
		return id;
	}
	
	/**
	 * Method prepares UserAutobiography(data) for sending in ui service layer.
	 * Method contain data for edit autobiography profile.
	 * 
	 * @type Long
	 * @param id
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/user/{id}/parlor/userautobiographyprofile.json", method = RequestMethod.GET)
	public @ResponseBody UserAutobiography loadUserAutobiographyData(@PathVariable("id") Long id) {
		logger.info("UserController: load user autobiography to update.");
		UserAutobiography userAutobiography=userAutobiographyService.getUserAutobiographyByIdUser(id);
		
		return userAutobiography;
	}
	
	/**
	 * Method update user autobiography data. For converting userAutobiography from json
	 * to user use ObjectMapper.
	 * 
	 * @type Long
	 * @type String
	 * @param id
	 * @param userAutobiographyJson
	 * 
	 * @exception JsonParseException
	 * @exception JsonMappingException
	 * @exception IOException 
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/user/{id}/parlor/editautobiographyprofile.json", method = RequestMethod.PUT)
	public @ResponseBody Long editUserAutobiographyProfile(@RequestBody String userAutobiographyJson,@PathVariable("id") Long id) {
		
		logger.info("UserController: update user autobiography.");
		UserAutobiography userAutobiography=null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			userAutobiography = mapper.readValue(userAutobiographyJson, UserAutobiography.class);
			logger.info("UserController:"+userAutobiography.getHobby());
			
		} catch (JsonParseException e) {
			logger.info("UserController: error when json parse class UserExtendedData "+e);
			
		} catch (JsonMappingException e) {
			logger.info("IndexController: error in json mapping for class UserExtendedData "+e);
			
		} catch (IOException e) {
			logger.info("IndexController: input output exeption when read json value of object"
					+ " userExtendedDataJson "+e);
		}
		logger.info("UserController:Update user Autobiography.");
		userAutobiographyService.updateUserAutobiography(userAutobiography);
			
		return id;
	}
		
	/**
	 * Method prepares List<Language> (data) for sending in ui service layer.
	 * This List contain list languages. If List<Language> is empty return empty list
	 * else return list with objects.  
	 * 
	 * @return List<Language>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/listlanguage.json", method = RequestMethod.GET)
	public @ResponseBody List<Language> loadListLanguage() {
		logger.info("UserController: load list language.");
		List<Language> listlanguage=(List)languageService.getListLanguage();
		
		return listlanguage;
	}
	
	/**
	 * Method prepares List<Country>(data) for sending in ui service layer.
	 * This List contain list country. If List<Country> is empty return empty list
	 * else return list with objects.  
	 * 
	 * @return List<Country>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/listcountry.json", method = RequestMethod.GET)
	public @ResponseBody List<Country> loadListCountry() {
		logger.info("UserController: load list country.");
		List<Country>  listCountry= (List)countryService.getListCountry();
		
		return listCountry;
	}
	
	/**
	 * Method prepares List<City>(data)for sending in ui service layer by id country which
	 * contain this city. This List contain list city. If List<City> is empty return empty list
	 * else return list with objects.  
	 * 
	 * @return List<City>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/{idCountry}/listcity.json", method = RequestMethod.GET)
	public @ResponseBody List<City> getListCityByIdCountry(@PathVariable("idCountry") Long idCountry) {
		logger.info("UserController: load list city by id country.");
		List<City>  listCity= (List)cityService.getListCityByIdCountry(idCountry);
		
		return listCity;
	}
														//forum
	
	/**
	 * Method prepares List<ForumTopic> (data) for sending in ui service layer by id forum
	 * This List contain list forum topic. If List is empty return empty list else return
	 * list with objects.  
	 * 
	 * @return List<ForumTopic>
	 */
	@RequestMapping(value="/views/profile/user/forum/{idForum}/listforumtopic.json", method = RequestMethod.GET)
	public @ResponseBody List<ForumTopic> loadListForumTopic(@PathVariable("idForum") Long idForum) {
		logger.info("UserController: load list forum topic by id forum.");
		List<ForumTopic> listForumTopic= forumTopicService.getListForumTopicByIdForum(idForum);
		
		return listForumTopic;
	}
	
	/**
	 * Method save new forum topic.
	 * 
	 * @type Long
	 * @type ForumTopic
	 * @param id
	 * @param forumTopic
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/user/forum/{id}/savenewforumtopic.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewForumTopic(@RequestBody ForumTopic forumTopic, @PathVariable("id") Long id) {
		
		logger.info("UserController: Save new forum topic for forum.");
		Account userAccount=userService.getAccountByUserId(id);
		Long idForum=forumTopic.getForum().getIdForum();
		Forum forum = forumService.getForumById(idForum);
		
		forumTopic.setAuthorAccount(userAccount);
		forumTopic.setForum(forum);
		forumTopic.setDateCreateForumTopic(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		forumTopicService.saveForumTopic(forumTopic);
		
		return idForum;
	}
	
	/**
	 * Method prepares List<ForumMessage> (data) for sending in ui service layer
	 * by id forumTopic.This List contain list forum messages. If List is empty
	 * return empty list else return list with objects.  
	 * 
	 * @return List<ForumMessage>
	 */
	@RequestMapping(value="/views/profile/user/forum/{idForumTopic}/listForumMessages.json", method = RequestMethod.GET)
	public @ResponseBody List<ForumMessage> loadListTopicMessages(@PathVariable("idForumTopic") Long idForumTopic) {
		
		logger.info("UserController: Load topic messages from last week");
		//load topic messages from last week
		Date minDate=converter.convertLocalDateTimeToDate(LocalDateTime.now().minusDays(7));
		Date maxDate=converter.convertLocalDateTimeToDate(LocalDateTime.now());
		List<ForumMessage> listTopicMessages=forumMessageService
				.getListForumMessageBetweenDateByIdForumTopic(idForumTopic, minDate, maxDate);
		
		return listTopicMessages;
	}
	
	/**
	 * Method save new forum messages.
	 * 
	 * @type ForumMessage
	 * @param newForumMessage
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/user/forum/saveForumMessages.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewForumMessages(@RequestBody ForumMessage newForumMessage) {
		
		logger.info("UserController: Save new forum messages.");
		Long idForumTopic=newForumMessage.getForumTopic().getIdForumTopic();
		ForumTopic forumTopic= forumTopicService.getForumTopicById(idForumTopic);
		Long idUser=newForumMessage.getAuthorAccount().getUser().getIdUser();
		Account account= userService.getAccountByUserId(idUser);
		
		newForumMessage.setForumTopic(forumTopic);
		newForumMessage.setAuthorAccount(account);
		newForumMessage.setDateCreateForumMessage(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		forumMessageService.saveForumMessage(newForumMessage);
		
		return idForumTopic;
	}

	/**
	 * Method delete forum message by id message. 
	 * 
	 * @type Long
	 * @param idForumTopic
	 * @param idForumMessage
	 * 
	 * @return Long
	 */
	@RequestMapping(value="/views/profile/user/forum/{idForumTopic}/{idForumMessage}/deleteForumMessages.json", method = RequestMethod.DELETE)
	public @ResponseBody Long deleteForumMessages( @PathVariable("idForumTopic") Long idForumTopic,
			@PathVariable("idForumMessage") Long idForumMessage) {
		logger.info("UserController: Delete forum message by id");
		forumMessageService.deleteForumMessageById(idForumMessage);
		
		return idForumTopic;
	}
													//group
	/**
	 * Method save new account group.
	 * 
	 * @type Long
	 * @type AccountGroup
	 * @param id
	 * @param newAccountGroup
	 * 
	 * @return idUser(Long)
	 */
	@RequestMapping(value="/views/profile/user/group/{id}/saveAccountGroup.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewAccountGroup(@RequestBody AccountGroup newAccountGroup, @PathVariable("id") Long id) {
	
		logger.info("UserController: Save new account group and account group history.");
		Account account= userService.getAccountByUserId(id);
		
		AccountGroup accountGroup =new AccountGroup();
		accountGroup.setAccount(account);
		accountGroup.setAccountGroupBlockStatus(BlockStatus.UNBLOCK.toString());
		accountGroup.setGroupName(newAccountGroup.getGroupName());
		accountGroup.setViewStatus(newAccountGroup.getViewStatus());
		accountGroupService.saveAccountGroup(accountGroup);
		
		AccountGroupHistory accountGroupHistory = new AccountGroupHistory();
		accountGroupHistory.setAccountGroup(accountGroup);
		
		accountGroupHistory.setDateCreateGroup(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistory.setLastVisit(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistoryService.saveAccountGroupHistory(accountGroupHistory);
		
		logger.info("UserController: Author of account group create id member for yourself");
		GroupMember groupMember=new GroupMember();
		groupMember.setMemberAccount(account);
		groupMember.setAccountGroup(accountGroup);
		groupMember.setGroupMemberStatus(FriendStatus.FRIEND.toString());
		groupMemberService.saveGroupMember(groupMember);
		
		return id;
	}
	
	/**
	 * Method return id member in account group by id accountGroup and by id account.
	 * 
	 * @type Long
	 * @param id
	 * @param idAccountGroup
	 * 
	 * @return idGroupMember
	 */
	@RequestMapping(value="/views/profile/user/group/{id}/{idAccountGroup}/accountGroupMember.json", method = RequestMethod.GET)
	public @ResponseBody Long getAccountGroupMember(@PathVariable("id") Long id, @PathVariable("idAccountGroup") Long idAccountGroup){
		logger.info("UserController: Load id group member.");
		Account account= userService.getAccountByUserId(id);
		Long idAccount= account.getIdAccount();
		GroupMember groupMember= groupMemberService.getGroupMemberInAccountGroupByIdAccount(idAccountGroup, idAccount);
		
		return groupMember.getIdGroupMember();
	}
	
	/**
	 * Method prepares List<GroupMessage> (data) for sending in ui service layer
	 * This List contain list group messages. If List is empty return empty list
	 * else return list with objects.  
	 * 
	 * @return List<GroupMessage>
	 */
	@RequestMapping(value="/views/profile/user/group/{idAccountGroup}/listAccountGroupMessages.json", method = RequestMethod.GET)
	public @ResponseBody List<GroupMessage> loadAccountGroupMessages(@PathVariable("idAccountGroup") Long idAccountGroup) {
		logger.info("UserController: Load account group messages from last week");
		List<GroupMessage> listGroupMessages=groupMessageService.getListGroupMessageByIdAccountGroup(idAccountGroup);
		
		return listGroupMessages;
	}
	
	/**
	 * Method save new account group messages. 
	 * 
	 * @type GroupMessage
	 * @param newGroupMessage
	 * 
	 * @return idAccountGroup
	 */
	@RequestMapping(value="/views/profile/user/group/saveAccountGroupMessage.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewAccountGroupMessage(@RequestBody GroupMessage newGroupMessage) {
		
		logger.info("UserController: Save new member message of account group.");
		GroupMessage groupMessage=new GroupMessage();
		GroupMember groupMember= groupMemberService.getGroupMemberById(newGroupMessage.getGroupMember().getIdGroupMember());
		groupMessage.setGroupMember(groupMember);
		groupMessage.setGroupMessage(newGroupMessage.getGroupMessage());
		groupMessage.setDateCreateGroupMessage(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		groupMessageService.saveGroupMessage(groupMessage);
		//not use group member event
		
		logger.info("UserController: Get id account group after save member message.");
		Long idAccountGroup =newGroupMessage.getGroupMember().getAccountGroup().getIdAccountGroup();
		
		return idAccountGroup;
	}

	/**
	 * Method delete account group messages by id  idGroupMessage.
	 * 
	 * @type Long
	 * @param idGroupMessage
	 * @param idAccountGroup
	 * 
	 * @return idAccountGroup
	 */
	@RequestMapping(value="/views/profile/user/group/{idAccountGroup}/{idGroupMessage}/deleteAccountGroupMessage.json", method = RequestMethod.DELETE)
	public @ResponseBody Long deleteAccountGroupMessage(@PathVariable("idGroupMessage") Long idGroupMessage,
			@PathVariable("idAccountGroup") Long idAccountGroup) {
		logger.info("UserController: Delete group message by id");
		groupMessageService.deleteGroupMessageById(idGroupMessage);
		
		return idAccountGroup;
	}
	
	/**
	 * Method prepares List<EventPattern>(data) for sending in ui service layer
	 * This List contain list event pattern. If List is empty return empty list
	 * else return list with objects.  
	 * 
	 * @return List<EventPattern>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/user/group/listEventPattern.json", method = RequestMethod.GET)
	public @ResponseBody List<EventPattern> loadListEventPattern(){
		logger.info("UserController: Load list event pattern.");
		List<EventPattern> listEventPattern=(List)eventPatternService.getListEventPattern();
		
		return listEventPattern;
	}
	
	
	/**
	 * Method prepares AccountGroup (data) by idAccountGroup
	 * for sending in ui service layer.
	 * 
	 *  @type Long
	 *  @param idAccountGroup
	 * 
	 * @return AccountGroup 
	 */
	@RequestMapping(value="/views/profile/user/group/{idAccountGroup}/accountGroup.json", method = RequestMethod.GET)
	public @ResponseBody AccountGroup loadAccountGroupToEdit(@PathVariable("idAccountGroup") Long idAccountGroup){
		logger.info("UserController: Load account group for edit");
		AccountGroup accountGroup= accountGroupService.getAccountGroupById(idAccountGroup);
		
		return accountGroup;
	}
	
	/**
	 * Update account group.
	 * 
	 * @type AccountGroup
	 * @param accountGroup
	 */
	@RequestMapping(value="/views/profile/user/group/editAccountGroup.json", method = RequestMethod.PUT)
	public @ResponseBody void editAccountGroup(@RequestBody AccountGroup accountGroup) {
		logger.info("UserController: update account group.");
		accountGroupService.updateAccountGroup(accountGroup);
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
	@RequestMapping(value="/views/profile/user/group/{idAccountGroup}/listAccountGroupMembers.json", method = RequestMethod.GET)
	public @ResponseBody List<GroupMember> loadListAccountGroupMember(@PathVariable("idAccountGroup") Long idAccountGroup){
		logger.info("UserController: Load group members");
		List<GroupMember> listAccountGroupMember= groupMemberService.getListGroupMemberByIdAccountGroup(idAccountGroup);
		
		return listAccountGroupMember;
	}
	
	/**
	 * Method delete member from account group by idDeleteGroupMember.
	 * 
	 * @type Long
	 * @param idAccountGroupMember
	 * @param idDeleteGroupMember
	 * 
	 * @return idAccountGroupMember
	 */
	@RequestMapping(value="/views/profile/user/group/{idAccountGroupMember}/{idDeleteGroupMember}/deleteAccountGroupMember.json", method = RequestMethod.DELETE)
	public @ResponseBody Long deleteMemberFromAccountGroup(@PathVariable("idAccountGroupMember") Long idAccountGroupMember,
			@PathVariable("idDeleteGroupMember") Long idDeleteGroupMember){
		
		if(idAccountGroupMember.equals(idDeleteGroupMember)){
			logger.warn("UserController:Delete account group member fail, becouse"
					+ " try to delete author of this group!");
		}else{
			logger.info("UserController:Delete account group member from account group");
			groupMemberService.deleteGroupMemberById(idDeleteGroupMember);
		}
		return idAccountGroupMember;
	}

	
	/**
	 * Method chack user right to edit group members
	 * 
	 * @type Long
	 * @param id
	 * @param idAccountGroup
	 * 
	 * @return  If right true user may edit group members(Boolean)
	 */
	@RequestMapping(value="/views/profile/user/{id}/group/{idAccountGroup}/rightToEditGroupMember.json", method = RequestMethod.GET)
	public @ResponseBody Boolean getRightEditGroupMember(@PathVariable("id") Long idUser, @PathVariable("idAccountGroup") Long idAccountGroup){
		logger.info("UserController: Load group members");
		
		Boolean rightToAddNewMember=false;
		AccountGroup accountGroup = accountGroupService.getAccountGroupById(idAccountGroup);
		Long idAuthorGroup=accountGroup.getAccount().getUser().getIdUser();
		
		if(idAuthorGroup==idUser){
			rightToAddNewMember=true;
			logger.info("UserController: user have right to editGroupMembers as creator group");
		}
		if(accountGroup.getViewStatus().equals(ViewStatus.PUBLIC.toString())){
			rightToAddNewMember=true;
			logger.info("UserController: user have right to editGroupMembers becouse view status public");
		}
		
		return rightToAddNewMember;
	}
	
																//add new member
	/**
	 * Method return List<Account> for account group for adding in list group members.
	 * 
	 * @type GroupMessage
	 * @param newGroupMessage
	 * 
	 * @return List<Account>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/user/group/{idAccountGroup}/listaccount.json", method = RequestMethod.POST)
	public @ResponseBody List<Account> searchAccountForAccountGroup(@RequestBody SearchPatternData searchPattern,
			@PathVariable("idAccountGroup") Long idAccountGroup){
		logger.info("UserController: Search account by account name or user last name for include in account group.");
		
		String accountName=null;
		String userLastName=null;
		
		if(searchPattern!=null){
	
			if(searchPattern.getAccountName()!=null && searchPattern.getAccountName()!=""){
				accountName=searchPattern.getAccountName();
			}
			if(searchPattern.getUserLastName()!=null && searchPattern.getUserLastName()!=""){
				userLastName=searchPattern.getUserLastName();
			}
		}
		List<Account> listAccount;
		if(accountName!=null || userLastName!=null){
		    listAccount=accountService.searchAccountByAccountNameUserLastName(accountName,userLastName);
		}else{
			listAccount = (List)accountService.getListAccount();
		}
		return listAccount;
	}
	
	
	/**
	 * Method add new member to account group with friend status.
	 * 
	 * @type String
	 * @type Long
	 * @param friendStatus
	 * @param idAccountGroup
	 * @param idAccountNewMember
	 * 
	 * @return idAccountGroup(Long)
	 */
	@RequestMapping(value="/views/profile/user/group/{idAccountGroup}/{idAccountNewMember}/newmember.json", method = RequestMethod.POST)
	public @ResponseBody Long addNewMemberToAccountGroup(@RequestBody String friendStatus, @PathVariable("idAccountGroup") Long idAccountGroup,
			@PathVariable("idAccountNewMember") Long idAccountNewMember){
		
		GroupMember groupMemberInGroup=groupMemberService.getGroupMemberInAccountGroupByIdAccount(idAccountGroup, idAccountNewMember);
		if(groupMemberInGroup!=null){
			logger.info("UserController: Account exist in group yet. Group may have only unique account.");
		}else{
			logger.info("UserController: Save new account group member.");
			GroupMember groupMember=new GroupMember();
			Account memberAccount= accountService.getAccountById(idAccountNewMember);
			groupMember.setMemberAccount(memberAccount);
			AccountGroup accountGroup=accountGroupService.getAccountGroupById(idAccountGroup);
			groupMember.setAccountGroup(accountGroup);
			
			if(friendStatus.equals("true")){
				groupMember.setGroupMemberStatus(FriendStatus.FRIEND.toString());	
			}else{
				groupMember.setGroupMemberStatus(FriendStatus.NOTFRIEND.toString());	
			}
			groupMemberService.saveGroupMember(groupMember);
		}
		return idAccountGroup;
	}
															//account 
	/**
	 * Method prepares List<AccountGroup>(data) for sending in ui service layer
	 * This list contain list account groups for account. If List is empty return
	 * empty list else return list with objects.
	 * 
	 * @type Long
	 * @param id
	 * 
	 * @return List<AccountGroup> 
	 */
	@RequestMapping(value="/views/profile/user/{id}/account/listaccountgroup.json", method = RequestMethod.GET)
	public @ResponseBody List<AccountGroup> getListAccountGroupForAccount(@PathVariable("id") Long id){
		Account account= userService.getAccountByUserId(id);
		Long idAccount=account.getIdAccount();				
		logger.info("UserController: Load list account group for account.");
		List<AccountGroup> listAccountGroup = accountGroupService
				.getListAccountGroupWithBlockStatusByIdAccount(idAccount,BlockStatus.UNBLOCK.toString());
		
		return listAccountGroup;
	}
	
	/**
	 * Method prepares List<Account>(data) for sending in ui service layer
	 * This list contain list account by account name and by last name. If
	 * List is empty return empty list else return list with objects.
	 * 
	 * @type SearchPatternData
	 * @param searchPattern
	 * 
	 * @return List<Account> 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/views/profile/user/account/searchaccount.json", method = RequestMethod.POST)
	public @ResponseBody List<Account> searchAccountByAccountName(@RequestBody SearchPatternData searchPattern){
		
		logger.info("UserController: Search accounts by name or user last name.");
		String accountName=null;
		String userLastName=null;
		
		if(searchPattern!=null){
	
			if(searchPattern.getAccountName()!=null && searchPattern.getAccountName()!=""){
				accountName=searchPattern.getAccountName();
			}
			if(searchPattern.getUserLastName()!=null && searchPattern.getUserLastName()!=""){
				userLastName=searchPattern.getUserLastName();
			}
		}
		List<Account> listAccount;
		if(accountName!=null || userLastName!=null){
			listAccount = accountService.searchAccountByAccountNameUserLastName(accountName,userLastName);
		}else{
			listAccount = (List)accountService.getListAccount();
		}
		return listAccount;	
	}
	
	/**
	 * Method add new member in account group after search.
	 * 
	 * @type String
	 * @type Long
	 * @param friendStatus
	 * @param idAccount
	 * @param idAccountGroupSelected
	 * 
	 * @return List<Account> 
	 */
	@RequestMapping(value="/views/profile/user/account/{idAccountGroupSelected}/{idAccount}/newaccountgroupmember.json", method = RequestMethod.POST)
	public @ResponseBody void addToAccountGroupAfterSearch(@RequestBody String friendStatus,@PathVariable("idAccount") Long idAccount,
			@PathVariable("idAccountGroupSelected") Long idAccountGroupSelected){
	
		GroupMember groupMemberInGroup=groupMemberService
				.getGroupMemberInAccountGroupByIdAccount(idAccountGroupSelected, idAccount);
		
		if(groupMemberInGroup!=null){
			logger.info("UserController: Account exist in group yet. Group may have only unique account.");
			
		}else{
			logger.info("UserController:Add new member to account group.");
			AccountGroup accountGroup=accountGroupService.getAccountGroupById(idAccountGroupSelected);
			Account memberAccount= accountService.getAccountById(idAccount); 
			GroupMember groupMember=new GroupMember();
			groupMember.setAccountGroup(accountGroup);
			groupMember.setMemberAccount(memberAccount);
			
			if(friendStatus.equals("true")){
				groupMember.setGroupMemberStatus(FriendStatus.FRIEND.toString());	
			}else{
				groupMember.setGroupMemberStatus(FriendStatus.NOTFRIEND.toString());	
			}
			groupMemberService.saveGroupMember(groupMember);
		}
	}
	
	/**
	 * Method prepares UserParlorData(data) for sending in ui service layer
	 * Class UserParlorData is class wapper for other object
	 * 
	 * @type Long
	 * @type UserParlorData
	 * @param searchIdAccount
	 * 
	 * @return UserParlorData
	 */
	@RequestMapping(value="/views/profile/user/account/{searchIdAccount}/accountinfo.json", method = RequestMethod.GET)
	public @ResponseBody UserParlorData getAccountSearchInfo(@PathVariable("searchIdAccount") Long searchIdAccount){
		
		logger.info("UserController: Load info about searching account.");
		//data for user account
		Account accountSearch= accountService.getAccountById(searchIdAccount);
		User user =accountSearch.getUser();
		Long idUserSearch=user.getIdUser();
		
		UserParlorData userParlorData=new UserParlorData();
		userParlorData.setUser(user);
		
		UserAutobiography userAutobiography=userAutobiographyService.getUserAutobiographyByIdUser(idUserSearch);
		userParlorData.setUserAutobiography(userAutobiography);
		
		UserEmail userEmail=userEmailService.getEmailByIdUser(idUserSearch);
		userParlorData.setUserEmail(userEmail);
		
//		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(idUserSearch);
//		userPhoto.setPhotoName(userPhotoService.loadPathToUserPhoto(idUserSearch));
//		userParlorData.setUserPhoto(userPhoto);
		
		UserLocation userLocation= userLocationService.getUserLocationByIdUser(idUserSearch);
		userParlorData.setUserLocation(userLocation);
		
		return userParlorData;
	}
	
	/**
	 * Method return List<SingleMessage> by id account and id Intrlocutor. If list is
	 * empty return empty list else return list objects.
	 * 
	 * @type Long
	 * @type UserParlorData
	 * @param searchIdAccount
	 * 
	 * @return UserParlorData
	 */
	@RequestMapping(value="/views/profile/user/{id}/account/{searchIdAccount}/listAccountSingleMessage.json", method = RequestMethod.GET)
	public @ResponseBody List<SingleMessage> listAccountSingleMessage(@PathVariable("id") Long id,
			@PathVariable("searchIdAccount") Long searchIdAccount){
		
		logger.info("UserControlleer: Load list account single message by id user and id interlocutor account");
		Account account =userService.getAccountByUserId(id);
		Long idAccount= account.getIdAccount();
		Date minDate=converter.convertLocalDateTimeToDate(LocalDateTime.now().minusDays(7));
		Date maxDate=converter.convertLocalDateTimeToDate(LocalDateTime.now());
		
		List<SingleMessage> listSingleMessage=singleMessageService.getListIntrlocutorSingleMessageBeetweenDateByIdAccount(
				idAccount, searchIdAccount, minDate, maxDate);
		
		return listSingleMessage;
	}
	
	/**
	 * Method save new account single message.
	 * 
	 * @type Long
	 * @type SingleMessage
	 * @param SingleMessage
	 * @param id
	 * 
	 * @return idUser(Long)
	 */
	@RequestMapping(value="/views/profile/user/{id}/account/saveAccountSingleMessage.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewAccountSingleMessage(@RequestBody SingleMessage newAccountSingleMessage,
			@PathVariable("id") Long id){
		
		logger.info("UserController:Save new single account message.");
		SingleMessage singleMessage=new SingleMessage();
		
		logger.info("UserController:Load user account for save new single account message.");
		Long idUser=newAccountSingleMessage.getAccount().getUser().getIdUser();
		Account account=userService.getAccountByUserId(idUser);
		singleMessage.setAccount(account);
		
		logger.info("UserController:Load interlocutor account for save new single account message.");
		Long idInterlocutorAccount=newAccountSingleMessage.getInterlocutorAccount().getIdAccount();
		Account interlocutorAccount= accountService.getAccountById(idInterlocutorAccount);
		singleMessage.setInterlocutorAccount(interlocutorAccount);
		
		singleMessage.setDateCreateSingleMessage(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		singleMessage.setSingleMessage(newAccountSingleMessage.getSingleMessage());
		singleMessageService.saveSingleMessage(singleMessage);
		
		return id;
	}
	
	/**
	 * Method delete account single message by idAccountSingleMessage
	 * 
	 * @type Long
	 * @param idAccountSingleMessage
	 * @param id
	 * 
	 * @return idUser(Long)
	 */
	@RequestMapping(value="/views/profile/user/{id}/account/{idAccountSingleMessage}/deleteAccountSingleMessage.json", method = RequestMethod.DELETE)
	public @ResponseBody Long deleteAccountSingleMessage(@PathVariable("idAccountSingleMessage") Long idAccountSingleMessage,
			@PathVariable("id") Long id){
		logger.info("UserController:Delete account single message.");
		singleMessageService.deleteSingleMessageById(idAccountSingleMessage);		
		
		return id;
	}
}
