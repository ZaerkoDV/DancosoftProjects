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
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dancosoft.socialcommunity.controller.support.UserExtended;
import com.dancosoft.socialcommunity.controller.support.UserExtendedData;
import com.dancosoft.socialcommunity.controller.support.UserParlorData;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserCorespondence;
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
import com.dancosoft.socialcommunity.service.ForumMessageService;
import com.dancosoft.socialcommunity.service.ForumService;
import com.dancosoft.socialcommunity.service.ForumTopicService;
import com.dancosoft.socialcommunity.service.LanguageService;
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
@Controller(value = "userController")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
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



	@RequestMapping(value="/views/profile/user/parlor/accountdata.json", method = RequestMethod.POST)
	public @ResponseBody UserParlorData loadUserAccount(@RequestBody Long id) {
	
		logger.info("UserController: Load data for user account.");
		//data for user account
		UserParlorData userParlorData=new UserParlorData();
		
		User user =userService.getUserById(id);
		userParlorData.setUser(user);
		
		UserAutobiography userAutobiography=userAutobiographyService.getUserAutobiographyByIdUser(id);
		userParlorData.setUserAutobiography(userAutobiography);
		
		List<UserEmail> listUserEmail=userEmailService.getListEmailByIdUser(id);
		userParlorData.setUserEmail(listUserEmail.get(0));
		
		UserPhoto userPhoto=userPhotoService.getUserPhotoByIdUser(id);
		userParlorData.setUserPhoto(userPhoto);
		
		UserLocation userLocation= userLocationService.getUserLocationByIdUser(id);
		userParlorData.setUserLocation(userLocation);
		
		//history last visit account
		logger.info("UserController: Create date last visit account.");
		List<Account> listUserAccount=userService.getListAccountByUserId(id);
		AccountHistory accountHistory =accountHistoryService
				.getAccountHistoryByIdAccount(listUserAccount.get(0).getIdAccount());
		accountHistory.setLastVisit(LocalDateTime.now());
		accountHistoryService.updateAccountHistory(accountHistory);	
		
		return userParlorData;
	}
	
	@RequestMapping(value="/views/profile/user/parlor/listaccountgroup.json", method = RequestMethod.POST)
	public @ResponseBody List<AccountGroup> getListAccountGroup(@RequestBody Long id) {
		
		logger.info("UserController: Load list of user account groups.");
		List<Account> listUserAccount=userService.getListAccountByUserId(id);
		List<AccountGroup> listAccountGroup=accountGroupService
				.getListAccountGroupWithBlockStatusByIdAccount(listUserAccount.get(0).getIdAccount(), "unblock");
		
		return listAccountGroup;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/user/parlor/listforum.json", method = RequestMethod.POST)
	public @ResponseBody List<Forum> getListForum(@RequestBody Long id) {
		
		logger.info("UserController: Load list forum for user account");
		List<Forum> listForum;	
		Boolean isUserAdult=userAutobiographyService.isUserAdult(id, (long)18);
		
		if(isUserAdult){
			logger.info("UserController: Check user on adult. User is adult.");
			listForum= (List) forumService.getListForum();
			
		}else{
			logger.info("UserController: Check user on adult. User is not adult.");
			listForum= (List)forumService.getListForumWithStatus("public");
		}
		return listForum;
	}
	
											//edit user profile
	
	@RequestMapping(value="/views/profile/user/parlor/commonuserprofile.json", method = RequestMethod.POST)
	public @ResponseBody User loadCommonUserProfile (@RequestBody Long id) {
		
		logger.info("UserController: load common user profile.");
		User user =userService.getUserById(id);
		return user;
	}
	
	@RequestMapping(value="/views/profile/user/parlor/{id}/editcommonprofile.json", method = RequestMethod.POST)
	public @ResponseBody Long editCommonUserProfile (@RequestBody User user, @PathVariable("id") Long id) {
		
		logger.info("UserController: update user common profile.");
		userService.updateUser(user);
		return id;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/views/profile/user/parlor/extendeduserprofile.json", method = RequestMethod.POST)
	public @ResponseBody UserExtendedData loadExtendedUserProfile (@RequestBody Long id) {
		
		logger.info("UserController: load extended user profile.");
		UserExtendedData userExtendedData =new UserExtendedData();
		
		logger.info("UserController: load user email to update");
		List<UserEmail> userEmailList=(List) userEmailService.getListEmailByIdUser(id);
		userExtendedData.setUserEmail(userEmailList.get(0));
		
		logger.info("UserController: load user social network to update");
		List<UserSocialNetwork> userSocialNetworkList=(List) userSocialNetworkService
				.getListSocialNetworkWithStatusByIdUser(id, "private");
		if(userSocialNetworkList.size()>0){
			userExtendedData.setUserSocialNetwork(userSocialNetworkList.get(0));
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
		
		Language language= userLocationService.getUserLanguageByIdUser(id);
		userLocation.setLanguage(language);
		Country country= userLocationService.getUserCountryByIdUser(id);
		City city =userLocationService.getUserCityByIdUser(id);
		city.setCountry(country);		
		userLocation.setCity(city);
			
		userExtendedData.setUserLocation(userLocation);
		
		return userExtendedData;
	}
	
	@RequestMapping(value="/views/profile/user/parlor/{id}/editextendedprofile.json", method = RequestMethod.POST)
	public @ResponseBody Long editExtendedUserProfile(@RequestBody String userExtendedDataJson, @PathVariable("id") Long id) {
		
		logger.info("UserController: update user extended profile.");
		UserExtendedData userExtendedData =null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			userExtendedData = mapper.readValue(userExtendedDataJson, UserExtendedData.class);
			
		} catch (JsonParseException e) {
			logger.info("UserController: error when json parse class UserExtendedData "+e);
			
		} catch (JsonMappingException e) {
			logger.info("IndexController: error in json mapping for class UserExtendedData "+e);
			
		} catch (IOException e) {
			logger.info("IndexController: input output exeption when read json value of object"
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
		List<UserSocialNetwork> userSocialNetworkList=userSocialNetworkService
				.getListSocialNetworkWithStatusByIdUser(id, "private");

		if(userSocialNetworkList.size()>0){
			userSocialNetwork=userSocialNetworkList.get(0);
			
		}else{
			userSocialNetwork= new UserSocialNetwork();
		}
		userSocialNetwork.setFacebookAddress(userExtendedData.getUserSocialNetwork().getFacebookAddress());
		userSocialNetwork.setSkypeAddress(userExtendedData.getUserSocialNetwork().getSkypeAddress());
		userSocialNetwork.setUserCorespondence(newUserEmail.getUserCorespondence());
		userSocialNetworkService.saveUserSocialNetwork(userSocialNetwork);
		
		logger.info("UserController:Get language for update.");
		Long idNewLanguage=userExtendedData.getUserLocation().getLanguage().getIdLanguage();
		Language newLanguage=languageService.getLanguageById(idNewLanguage); 
		
		logger.info("UserController:Get city and country for update.");
		Long idNewCity=userExtendedData.getUserLocation().getCity().getIdCity();
		City newCity=cityService.getCityById(idNewCity);
		
		logger.info("UserController:Create new user location(or update old if exist) and update his language, country, city.");
		UserLocation newUserLocation=userLocationService.getUserLocationByIdUser(id);
		if(newUserLocation==null){
			newUserLocation=new UserLocation();
		}
		newUserLocation.setLanguage(newLanguage);
		newUserLocation.setCity(newCity);
		newUserLocation.setUser(user);
		userLocationService.updateUserLocation(newUserLocation);
		
		return id;
	}
	
	
	@RequestMapping(value="/views/profile/user/parlor/userautobiographyprofile.json", method = RequestMethod.POST)
	public @ResponseBody UserAutobiography loadUserAutobiographyProfile (@RequestBody Long id) {
		
		logger.info("UserController: load user autobiography to update.");
		UserAutobiography userAutobiography=userAutobiographyService.getUserAutobiographyByIdUser(id);
		
		userAutobiography.setBirth(null);
		
		return userAutobiography;
	}
	
	@RequestMapping(value="/views/profile/user/parlor/{id}/editautobiographyprofile.json", method = RequestMethod.POST)
	public @ResponseBody Long editUserAutobiographyProfile(@RequestBody String userAutobiographyJson, @PathVariable("id") Long id) {
		
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
		
		userAutobiography.setBirth(LocalDateTime.of(1990, 12, 30, 0, 0));
		logger.info("UserController:Update user Autobiography.");
		userAutobiographyService.updateUserAutobiography(userAutobiography);
			
		return id;
	}
		
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/listlanguage.json", method = RequestMethod.GET)
	public @ResponseBody List<Language> loadListLanguage() {
		
		logger.info("UserController: load list language.");
		List<Language> listlanguage=(List)languageService.getListLanguage();
		
		return listlanguage;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/listcountry.json", method = RequestMethod.GET)
	public @ResponseBody List<Country> loadListCountry() {
		
		logger.info("UserController: load list country.");
		List<Country>  listCountry= (List)countryService.getListCountry();
		
		return listCountry;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/listcity.json", method = RequestMethod.POST)
	public @ResponseBody List<City> loadListCity(@RequestBody Long idCountry) {
		
		logger.info("UserController: load list city by id country.");
		List<City>  listCity= (List)cityService.getListCityByIdCountry(idCountry);
		
		return listCity;
	}
	
	@RequestMapping(value="/views/profile/user/forum/listforumtopic.json", method = RequestMethod.POST)
	public @ResponseBody List<ForumTopic> loadListForumTopic(@RequestBody Long idForum) {
		
		logger.info("UserController: load list forum topic by id forum.");
		List<ForumTopic> listForumTopic= forumTopicService.getListForumTopicByIdForum(idForum);
		
		return listForumTopic;
	}
	
	@RequestMapping(value="/views/profile/user/forum/{id}/savenewforumtopic.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewForumTopic(@RequestBody ForumTopic forumTopic, @PathVariable("id") Long id) {
		
		logger.info("UserController: Save new forum topic for forum.");
		List<Account> listUserAccount=userService.getListAccountByUserId(id);
		Long idForum=forumTopic.getForum().getIdForum();
		Forum forum = forumService.getForumById(idForum);
		
		forumTopic.setAuthorAccount(listUserAccount.get(0));
		forumTopic.setForum(forum);
		forumTopic.setDateCreateForumTopic(LocalDateTime.now());
		forumTopicService.saveForumTopic(forumTopic);
		
		return idForum;
	}
	
	@RequestMapping(value="/views/profile/user/forum/{idForumTopic}/listForumMessages.json", method = RequestMethod.GET)
	public @ResponseBody List<ForumMessage> listTopicMessages(@PathVariable("idForumTopic") Long idForumTopic) {
		
		logger.info("UserController: Load topic messages from last week");
		//load topic messages from last week
		LocalDateTime minDateLDT=LocalDateTime.now().minusDays(7);
		LocalDateTime maxDateLDT=LocalDateTime.now();
		List<ForumMessage> listTopicMessages=forumMessageService
				.getListForumMessageBetweenDateByIdForumTopic(idForumTopic, minDateLDT, maxDateLDT);
		
		return listTopicMessages;
	}
	
	@RequestMapping(value="/views/profile/user/forum/saveForumMessages.json", method = RequestMethod.POST)
	public @ResponseBody Long saveNewForumMessages(@RequestBody ForumMessage newForumMessage) {
		
		logger.info("UserController: Save new forum messages.");
		Long idForumTopic=newForumMessage.getForumTopic().getIdForumTopic();
		ForumTopic forumTopic= forumTopicService.getForumTopicById(idForumTopic);
		Long idUser=newForumMessage.getAuthorAccount().getUser().getIdUser();
		List<Account> listAccount= userService.getListAccountByUserId(idUser);
		
		newForumMessage.setForumTopic(forumTopic);
		newForumMessage.setAuthorAccount(listAccount.get(0));
		newForumMessage.setDateCreateForumMessage(LocalDateTime.now());
		forumMessageService.saveForumMessage(newForumMessage);
		
		return idForumTopic;
	}

	@RequestMapping(value="/views/profile/user/forum/{idForumTopic}/deleteForumMessages.json", method = RequestMethod.POST)
	public @ResponseBody Long deleteForumMessages(@RequestBody Long idForumMessage, @PathVariable("idForumTopic") Long idForumTopic) {
		
		logger.info("UserController: Delete forum message by id");
		forumMessageService.deleteForumMessageById(idForumMessage);
		
		return idForumTopic;
	}
		
	//group message
	
	
	
	
	
	
	
	
	
	
	
	
	
}
