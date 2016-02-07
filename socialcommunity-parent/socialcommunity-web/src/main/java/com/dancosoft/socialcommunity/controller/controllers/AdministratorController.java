/**
 * 
 */
package com.dancosoft.socialcommunity.controller.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
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
	public @ResponseBody Long editExtendedAdminProfile(@RequestBody String adminExtendedDataJson,
			@PathVariable("idAdmin") Long idAdmin) {
		
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
	
	@RequestMapping(value="/views/profile/admin/forum/updateforumtopic.json", method = RequestMethod.POST)
	public @ResponseBody void updateForumTopic(@RequestBody ForumTopic forumTopic) {
		logger.info("AdminController: Update forum topic.");
		forumTopicService.updateForumTopic(forumTopic);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/profile/admin/forum/{idForumTopic}/{fromDate}/{toDate}/topicmessages.json", method = RequestMethod.GET)
	public @ResponseBody List<ForumMessage> loadForumTopicMessages(@PathVariable("idForumTopic") Long idForumTopic,
			@PathVariable("fromDate") Date fromDate,@PathVariable("toDate") Date toDate) {
		
		logger.info("AdminController: Load Forum Messages which created between date.");
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
	
	@RequestMapping(value="/views/profile/admin/account/searchaccount.json", method = RequestMethod.POST)
	public @ResponseBody List<Account> searchAccount(@RequestBody Account account) {
		logger.info("AdminController: search account by account name");
		List<Account> accountList=accountService.searchAccountByAccountNameUserLastName(account.getAccountName(), "");
		
		return accountList;
	}
	
	@RequestMapping(value="/views/profile/admin/account/{blockStatus}/newblockstatus.json", method = RequestMethod.POST)
	public @ResponseBody Account changeAccountBlockStatus(@RequestBody Account account,
			@PathVariable("blockStatus") String blockStatus) {
		
		logger.info("AdminController: change account block status.");
		account.setAccountBlockStatus(blockStatus);
		accountService.updateAccount(account);
				
		return account;
	}
	
	@RequestMapping(value="/views/profile/admin/account/{idAccount}/deleteaccount.json", method = RequestMethod.GET)
	public @ResponseBody void deleteAccount(@PathVariable("idAccount") Long idAccount) {
		
		Account account= accountService.getAccountById(idAccount);
		Long idUser= account.getUser().getIdUser();
		logger.info("AdminController: delete user account="+idAccount);
		accountService.deleteAccountById(idAccount);
		logger.info("AdminController: delete user= "+idUser);
		userService.deleteUserById(idUser);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/profile/admin/account/{searchIdAccount}/{fromDate}/{toDate}/singlemessages.json", method = RequestMethod.GET)
	public @ResponseBody List<SingleMessage> loadUserAccountSingleMessages(@PathVariable("searchIdAccount") Long searchIdAccount,
			@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate) {
		
		logger.info("AdminController:Load user account single messages.");
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
	
	@RequestMapping(value="/views/profile/admin/group/{groupName}/{accountName}/searchAccountGroup.json", method = RequestMethod.GET)
	public @ResponseBody List<AccountGroup> searchAccountGroup(@PathVariable("groupName") String groupName,
			@PathVariable("accountName") String accountName) {
		
		logger.info("AdminController: search account group.");
		if(groupName.equals("undefined")){
			groupName=null;
		}
		if(accountName.equals("undefined")){
			accountName=null;
		}
		List<AccountGroup> listAccountGroup=accountGroupService
				.searchAccountGroupByGroupNameAccountName(groupName, accountName);	
		return listAccountGroup;
	}
	
	@RequestMapping(value="/views/profile/admin/group/{blockStatus}/newblockstatus.json", method = RequestMethod.POST)
	public @ResponseBody AccountGroup changeAccountBlockStatus(@RequestBody AccountGroup accountGroup,
			@PathVariable("blockStatus") String blockStatus) {
		logger.info("AdminController: change account group block status.");
		accountGroup.setAccountGroupBlockStatus(blockStatus);
		accountGroupService.updateAccountGroup(accountGroup);
				
		return accountGroup;
	}
	
	@RequestMapping(value="/views/profile/admin/group/{idAccountGroup}/deleteaccountgroup.json", method = RequestMethod.GET)
	public @ResponseBody void deleteAccountGroup(@PathVariable("idAccountGroup") Long idAccountGroup) {
		logger.info("AdminController: delete user account group="+idAccountGroup);
		accountGroupService.deleteAccountGroupById(idAccountGroup);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value="/views/profile/admin/group/{idAccountGroup}/{fromDate}/{toDate}/groupmessages.json", method = RequestMethod.GET)
	public @ResponseBody List<GroupMessage> loadAccounrGroupMessages(@PathVariable("idAccountGroup") Long idAccountGroup,
			@PathVariable("fromDate") Date fromDate, @PathVariable("toDate") Date toDate) {
		
		logger.info("AdminController:Load account group messages.");
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
	
	@RequestMapping(value="/views/profile/admin/{idAdmin}/group/{idAccountGroup}/saveAccountGroupMessage.json", method = RequestMethod.POST)
	public @ResponseBody void saveNewAccountGroupMessages(@RequestBody GroupMessage newAccountGroupMessage,
			@PathVariable("idAdmin") Long idAdmin, @PathVariable("idAccountGroup") Long idAccountGroup) {
		
		logger.info("AdminController: Create new group message.");
		Account account= userService.getAccountByUserId(idAdmin);
		GroupMember groupMember= groupMemberService.getGroupMemberInAccountGroupByIdAccount(idAccountGroup,
				account.getIdAccount());
		
		if(groupMember==null){	
			logger.info("AdminController: Save admin account as group member account,"
					+ " becouse admin create messages never before");
			groupMember= new GroupMember();
			groupMember.setGroupMemberStatus(FriendStatus.NOTFRIEND.toString());
			AccountGroup accountGroup= accountGroupService.getAccountGroupById(idAccountGroup);
			groupMember.setAccountGroup(accountGroup);
			groupMember.setMemberAccount(account);
			groupMemberService.saveGroupMember(groupMember);
		}
		
		logger.info("AdminController: Create new group message.");
		newAccountGroupMessage.setDateCreateGroupMessage(LocalDateTime.now());
		newAccountGroupMessage.setGroupMember(groupMember);
		groupMessageService.saveGroupMessage(newAccountGroupMessage);
	}
	
	@RequestMapping(value="/views/profile/admin/group/{idAccountGroup}/listgroupmembers.json", method = RequestMethod.GET)
	public @ResponseBody List<GroupMember> loadListGroupMembers(@PathVariable("idAccountGroup") Long idAccountGroup) {
		
		logger.info("AdminController: load list group members for account group="+idAccountGroup);
		List<GroupMember> listGroupMembers=groupMemberService.getListGroupMemberByIdAccountGroup(idAccountGroup);
		
		return listGroupMembers;
	}
	
	
	
	
	
}
