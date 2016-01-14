package com.dancosoft.socialcommunity.service.testsupport;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dancosoft.socialcommunity.dao.CommonEntityDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountForum;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.model.AccountHistory;
import com.dancosoft.socialcommunity.model.City;
import com.dancosoft.socialcommunity.model.Country;
import com.dancosoft.socialcommunity.model.EventPattern;
import com.dancosoft.socialcommunity.model.Forum;
import com.dancosoft.socialcommunity.model.ForumMessage;
import com.dancosoft.socialcommunity.model.ForumTopic;
import com.dancosoft.socialcommunity.model.GroupEvent;
import com.dancosoft.socialcommunity.model.GroupMember;
import com.dancosoft.socialcommunity.model.GroupMessage;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.model.SecurityPrompt;
import com.dancosoft.socialcommunity.model.SingleMessage;
import com.dancosoft.socialcommunity.model.User;
import com.dancosoft.socialcommunity.model.UserAutobiography;
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.model.UserLocation;
import com.dancosoft.socialcommunity.model.UserPhoto;
import com.dancosoft.socialcommunity.model.UserRole;
import com.dancosoft.socialcommunity.model.UserSecurity;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;

@Component(value="testObjectServiceCreator")
public class TestObjectServiceCreator {
	
//	@Autowired
//	@Qualifier("commonEntityDAO")
//	private CommonEntityDAO commonEntityDAO;
//
//	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO) {
//		this.commonEntityDAO = commonEntityDAO;
//	}
//
//	TimeConverter converter= new TimeConverter();
//
//	public User createUserForTest() {
//
//		User testUser = new User();
//		testUser.setFirstName("testFirstName");
//		testUser.setLastName("testLastName");
//		testUser.setMiddleName("testMiddleName");
//		testUser.setSex("F");
//		commonEntityDAO.saveEntity(testUser);
//
//		return testUser;
//	}
//
//	public void deleteUserAfterTest(Long idUser) {
//		commonEntityDAO.deleteEntityById(User.class,idUser);
//	}
//
//	public UserRole createUserRoleForTest() {
//		UserRole testUserRole = new UserRole();
//		testUserRole.setUserRoleName("User");
//		commonEntityDAO.saveEntity(testUserRole);
//		return testUserRole;
//	}
//
//	public void deleteUserRoleAfterTest(Long idUserRole) {
//		commonEntityDAO.deleteEntityById(User.class, idUserRole);
//	}
//
//	public UserRole createAdminRoleForTest() {
//		UserRole testAdminRole = new UserRole();
//		testAdminRole.setUserRoleName("Admin");
//		commonEntityDAO.saveEntity(testAdminRole);
//		return testAdminRole;
//	}
//
//	public void deleteAdminRoleAfterTest(Long idAdminRole) {
//		commonEntityDAO.deleteEntityById(User.class, idAdminRole);
//	}
//
//	public UserSecurity createUserSecurityForTest() {
//
//		User testUser = createUserForTest();
//		UserRole userRole = createUserRoleForTest();
//		UserSecurity testUserSecurity = new UserSecurity();
//
//		testUserSecurity.setUserLogin("testLogin");
//		testUserSecurity.setUserPassword("testPassword");
//		testUserSecurity.setUser(testUser);
//		testUserSecurity.setUserRole(userRole);
//		commonEntityDAO.saveEntity(testUserSecurity);
//
//		return testUserSecurity;
//	}
//
//	public void deleteUserSecurityAfterTest(Long idUserSecurity) {
//
//		UserSecurity testUserSecurity = (UserSecurity) commonEntityDAO
//				.getEntityById(UserSecurity.class, idUserSecurity);
//		User testUser = (User) commonEntityDAO.getEntityById(User.class,
//				testUserSecurity.getUser().getIdUser());
//		UserRole testUserRole = (UserRole) commonEntityDAO.getEntityById(
//				UserRole.class, testUserSecurity.getUserRole().getIdUserRole());
//
//		commonEntityDAO.deleteEntity(testUserSecurity);
//		deleteUserAfterTest(testUser.getIdUser());
//		deleteUserRoleAfterTest(testUserRole.getIdUserRole());
//	}
//	
//	public SecurityPrompt createSecurityPromptForTest() {
//
//		UserSecurity testUserSecurity = createUserSecurityForTest();
//		SecurityPrompt testSecurityPrompt = new SecurityPrompt();
//
//		testSecurityPrompt.setSecurityPrompt("My test prompt");
//		testSecurityPrompt.setUserAnswer("Prompt answer");
//		testSecurityPrompt.setUserSecurity(testUserSecurity);
//		commonEntityDAO.saveEntity(testSecurityPrompt);
//
//		return testSecurityPrompt;
//	}
//
//	public void deleteSecurityPromptAfterTest(Long idSecurityPrompt) {
//
//		SecurityPrompt testSecurityPrompt = (SecurityPrompt) commonEntityDAO
//				.getEntityById(SecurityPrompt.class, idSecurityPrompt);
//
//		UserSecurity testUserSecurity = (UserSecurity) commonEntityDAO
//				.getEntityById(UserSecurity.class, testSecurityPrompt
//						.getUserSecurity().getIdUserSecurity());
//
//		commonEntityDAO.deleteEntity(testSecurityPrompt);
//		deleteUserSecurityAfterTest(testUserSecurity.getIdUserSecurity());
//	}
//
//	// / convert name to uniqual name and save file with
//	// / digit name on disk and save name file in db
//	public UserPhoto createUserPhotoForTest() {
//
//		User testUser = createUserForTest();
//		UserPhoto testUserPhoto = new UserPhoto();
//		String idUser=testUser.getIdUser().toString();
//		
//		testUserPhoto.setPhotoName(idUser+".jsp");
//		testUserPhoto.setPhotoNote("testPhoto");
//		testUserPhoto.setUser(testUser);
//		commonEntityDAO.saveEntity(testUserPhoto);
//		
//		return testUserPhoto;
//	}
//
//	public void deleteUserPhotoAfterTest(Long idUserPhoto) {
//
//		UserPhoto testUserPhoto = (UserPhoto) commonEntityDAO.getEntityById(
//				UserPhoto.class, idUserPhoto);
//		User testUser = (User) commonEntityDAO.getEntityById(User.class,
//				testUserPhoto.getUser().getIdUser());
//		commonEntityDAO.deleteEntity(testUserPhoto);
//		deleteUserAfterTest(testUser.getIdUser());
//	}
//
//	public UserCorespondence createUserCorespondenceForTest() {
//
//		User testUser = createUserForTest();
//		UserCorespondence testUserCorespondence = new UserCorespondence();
//		testUserCorespondence.setCorespondenceViewStatus("public");
//		testUserCorespondence.setUser(testUser);
//		commonEntityDAO.saveEntity(testUserCorespondence);
//
//		return testUserCorespondence;
//	}
//
//	public void deleteUserCorespondenceAfterTest(Long idUserCorespondence) {
//
//		UserCorespondence testUserCorespondence = (UserCorespondence) commonEntityDAO
//				.getEntityById(UserCorespondence.class, idUserCorespondence);
//		User testUser = (User) commonEntityDAO.getEntityById(User.class,
//				testUserCorespondence.getUser().getIdUser());
//
//		commonEntityDAO.deleteEntity(testUserCorespondence);
//		deleteUserAfterTest(testUser.getIdUser());
//	}
//
//	public UserEmail createUserEmailForTest() {
//
//		UserCorespondence testUserCorespondence = createUserCorespondenceForTest();
//		UserEmail testUserEmail = new UserEmail();
//
//		testUserEmail.setUserEmail("zaerko1991@gmail.com");//test@gmail.com
//		testUserEmail.setUserCorespondence(testUserCorespondence);
//		commonEntityDAO.saveEntity(testUserEmail);
//
//		return testUserEmail;
//	}
//
//	public void deleteUserEmailAfterTest(Long idUserEmail) {
//
//		UserEmail testUserEmail = (UserEmail) commonEntityDAO.getEntityById(UserEmail.class, idUserEmail);
//		UserCorespondence testUserCorespondence = (UserCorespondence) commonEntityDAO
//				.getEntityById(UserCorespondence.class, testUserEmail.getUserCorespondence().getIdUserCorespondence());
//
//		commonEntityDAO.deleteEntity(testUserEmail);
//		deleteUserCorespondenceAfterTest(testUserCorespondence.getIdUserCorespondence());
//	}
//
//	public UserSocialNetwork createUserSocialNetworkForTest() {
//
//		UserCorespondence testUserCorespondence = createUserCorespondenceForTest();
//		UserSocialNetwork testUserSocialNetwork = new UserSocialNetwork();
//
//		testUserSocialNetwork.setSkypeAddress("test.skype");
//		testUserSocialNetwork.setFacebookAddress("Test User");
//		testUserSocialNetwork.setUserCorespondence(testUserCorespondence);
//		commonEntityDAO.saveEntity(testUserSocialNetwork);
//
//		return testUserSocialNetwork;
//	}
//
//	public void deleteUserSocialNetworkAfterTest(Long idUserSocialNetwork) {
//
//		UserSocialNetwork testUserSocialNetwork = (UserSocialNetwork) commonEntityDAO
//				.getEntityById(UserSocialNetwork.class, idUserSocialNetwork);
//
//		UserCorespondence testUserCorespondence = (UserCorespondence) commonEntityDAO
//				.getEntityById(UserCorespondence.class, testUserSocialNetwork
//						.getUserCorespondence().getIdUserCorespondence());
//
//		commonEntityDAO.deleteEntity(testUserSocialNetwork);
//		deleteUserCorespondenceAfterTest(testUserCorespondence
//				.getIdUserCorespondence());
//	}
//
//	public UserAutobiography createUserAutobiographyForTest() {
//
//		User testUser = createUserForTest();
//		UserAutobiography testUserAutobiography = new UserAutobiography();
//		
//		Date birth=converter.convertLocalDateTimeToDate(LocalDateTime.of(1990, 12, 31, 0, 0));
//		testUserAutobiography.setBirth(birth);
//		testUserAutobiography.setHobby("Test Hobby");
//		testUserAutobiography.setAutobiography("Test User Autobiography");
//		testUserAutobiography.setUser(testUser);
//		commonEntityDAO.saveEntity(testUserAutobiography);
//
//		return testUserAutobiography;
//	}
//
//	public void deleteUserAutobiographyAfterTest(Long idUserAutobiography) {
//
//		UserAutobiography testUserAutobiography = (UserAutobiography) commonEntityDAO
//				.getEntityById(UserAutobiography.class, idUserAutobiography);
//		User testUser = (User) commonEntityDAO.getEntityById(User.class,
//				testUserAutobiography.getUser().getIdUser());
//
//		commonEntityDAO.deleteEntity(testUserAutobiography);
//		deleteUserAfterTest(testUser.getIdUser());
//	}
//
//	public Language createLanguageForTest() {
//
//		Language testLanguage = new Language();
//		testLanguage.setLanguageName("English");
//		commonEntityDAO.saveEntity(testLanguage);
//		return testLanguage;
//	}
//
//	public void deleteLanguageAfterTest(Long idLanguage) {
//		commonEntityDAO.deleteEntityById(Language.class, idLanguage);
//	}
//
//	public Country createCountryForTest() {
//
//		Country testCountry = new Country();
//		testCountry.setCountryName("UK");
//		commonEntityDAO.saveEntity(testCountry);
//
//		return testCountry;
//	}
//
//	public void deleteCountryAfterTest(Long idCountry) {
//		commonEntityDAO.deleteEntityById(Country.class, idCountry);
//	}
//
//	public City createCityForTest() {
//
//		Country testCountry = createCountryForTest();
//		City testCity = new City();
//
//		testCity.setCityName("London");
//		testCity.setCountry(testCountry);
//		commonEntityDAO.saveEntity(testCity);
//
//		return testCity;
//	}
//
//	public void deleteCityAfterTest(Long idCity) {
//
//		City testCity = (City) commonEntityDAO
//				.getEntityById(City.class, idCity);
//		Country testCountry = (Country) commonEntityDAO.getEntityById(
//				Country.class, testCity.getCountry().getIdCountry());
//
//		commonEntityDAO.deleteEntity(testCity);
//		deleteCountryAfterTest(testCountry.getIdCountry());
//	}
//
//	public UserLocation createUserLocationForTest() {
//
//		User testUser = createUserForTest();
//		Language testLanguage = createLanguageForTest();
//		City testCity = createCityForTest();
//		UserLocation testUserLocation = new UserLocation();
//
//		testUserLocation.setUser(testUser);
//		testUserLocation.setLanguage(testLanguage);
//		testUserLocation.setCity(testCity);
//
//		commonEntityDAO.saveEntity(testUserLocation);
//
//		return testUserLocation;
//	}
//
//	public void deleteUserLocationAfterTest(Long idUserLocation) {
//
//		UserLocation testUserLocation = (UserLocation) commonEntityDAO
//				.getEntityById(UserLocation.class, idUserLocation);
//		Language testLanguage = (Language) commonEntityDAO.getEntityById(
//				Language.class, testUserLocation.getLanguage().getIdLanguage());
//		City testCity = (City) commonEntityDAO.getEntityById(City.class,
//				testUserLocation.getCity().getIdCity());
//
//		commonEntityDAO.deleteEntity(testUserLocation);
//		deleteLanguageAfterTest(testLanguage.getIdLanguage());
//		deleteCityAfterTest(testCity.getIdCity());
//		deleteCountryAfterTest(testCity.getCountry().getIdCountry());
//	}
//
//	public Account createAccountForTest() {
//
//		User testUser = createUserForTest();
//		Account testAccount = new Account();
//
//		testAccount.setAccountName("TestAccount");
//		testAccount.setAccountBlockStatus("unblock");
//		testAccount.setUser(testUser);
//		commonEntityDAO.saveEntity(testAccount);
//
//		return testAccount;
//	}
//
//	public void deleteAccountAfterTest(Long idAccount) {
//
//		Account account = (Account) commonEntityDAO.getEntityById(
//				Account.class, idAccount);
//		User user = (User) commonEntityDAO.getEntityById(User.class, account
//				.getUser().getIdUser());
//
//		commonEntityDAO.deleteEntity(account);
//		deleteUserAfterTest(user.getIdUser());
//	}
//
//	public AccountHistory createAccountHistoryForTest() {
//
//		Account testAccount = createAccountForTest();
//		AccountHistory testAccountHistory = new AccountHistory();
//		
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 16,00, 00));
//		testAccountHistory.setDateCreateAccount(dateCreate);
//		Date dateVisit=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17, 00, 00));
//		testAccountHistory.setLastVisit(dateVisit);
//		testAccountHistory.setAccount(testAccount);
//		commonEntityDAO.saveEntity(testAccountHistory);
//
//		return testAccountHistory;
//	}
//
//	public void deleteAccountHistoryAfterTest(Long idAccountHistory) {
//
//		AccountHistory testAccountHistory = (AccountHistory) commonEntityDAO
//				.getEntityById(AccountHistory.class, idAccountHistory);
//		Account testAccount = (Account) commonEntityDAO.getEntityById(
//				Account.class, testAccountHistory.getAccount().getIdAccount());
//
//		commonEntityDAO.deleteEntity(testAccountHistory);
//		deleteUserAfterTest(testAccount.getIdAccount());
//	}
//
//	public SingleMessage createSingleMessageForTest() {
//
//		Account testAccount = createAccountForTest();
//		SingleMessage testSingleMessage = new SingleMessage();
//
//		testSingleMessage.setSingleMessage("Same test message");
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12,	17, 00, 00));
//		testSingleMessage.setDateCreateSingleMessage(dateCreate);
//		testSingleMessage.setAccount(testAccount);
//		testSingleMessage.setInterlocutorAccount(testAccount);
//		commonEntityDAO.saveEntity(testSingleMessage);
//
//		return testSingleMessage;
//	}
//
//	public void deleteSingleMessageAfterTest(Long idSingleMessage) {
//
//		SingleMessage testSingleMessage = (SingleMessage) commonEntityDAO
//				.getEntityById(SingleMessage.class, idSingleMessage);
//		Account testAccount = (Account) commonEntityDAO.getEntityById(
//				Account.class, testSingleMessage.getAccount().getIdAccount());
//
//		commonEntityDAO.deleteEntity(testSingleMessage);
//		deleteUserAfterTest(testAccount.getIdAccount());
//	}
//
//	public AccountGroup createAccountGroupForTest() {
//
//		Account testAccount = createAccountForTest();
//		AccountGroup testAccountGroup = new AccountGroup();
//
//		testAccountGroup.setGroupName("TestAccountGroup");
//		testAccountGroup.setViewStatus("private");
//		testAccountGroup.setAccountGroupBlockStatus("unblock");
//		testAccountGroup.setAccount(testAccount);
//		commonEntityDAO.saveEntity(testAccountGroup);
//
//		return testAccountGroup;
//	}
//
//	public void deleteAccountGroupAfterTest(Long idAccountGroup) {
//
//		AccountGroup testAccountGroup = (AccountGroup) commonEntityDAO
//				.getEntityById(AccountGroup.class, idAccountGroup);
//		Account testAccount = (Account) commonEntityDAO.getEntityById(
//				Account.class, testAccountGroup.getAccount().getIdAccount());
//
//		commonEntityDAO.deleteEntity(testAccountGroup);
//		deleteAccountAfterTest(testAccount.getIdAccount());
//	}
//
//	public AccountGroupHistory createAccountGroupHistoryForTest() {
//
//		AccountGroup testAccountGroup = createAccountGroupForTest();
//		AccountGroupHistory testAccountGroupHistory = new AccountGroupHistory();
//		
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12,16, 00, 00));
//		testAccountGroupHistory.setDateCreateGroup(dateCreate);
//		Date dateVisit=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17, 00, 00));
//		testAccountGroupHistory.setLastVisit(dateVisit);
//		testAccountGroupHistory.setAccountGroup(testAccountGroup);
//		commonEntityDAO.saveEntity(testAccountGroupHistory);
//
//		return testAccountGroupHistory;
//	}
//
//	public void deleteAccountGroupHistoryAfterTest(Long idAccountGroupHistory) {
//
//		AccountGroupHistory testAccountGroupHistory = (AccountGroupHistory) commonEntityDAO
//				.getEntityById(AccountGroupHistory.class, idAccountGroupHistory);
//		AccountGroup testAccountGroup = (AccountGroup) commonEntityDAO
//				.getEntityById(AccountGroup.class, testAccountGroupHistory
//						.getAccountGroup().getIdAccountGroup());
//
//		commonEntityDAO.deleteEntity(testAccountGroup);
//		deleteAccountGroupAfterTest(testAccountGroup.getIdAccountGroup());
//	}
//
//	public EventPattern createEventPatternForTest() {
//
//		EventPattern testEventPattern = new EventPattern();
//		testEventPattern.setEventPattern("TestEventPattern");
//		commonEntityDAO.saveEntity(testEventPattern);
//
//		return testEventPattern;
//	}
//
//	public void deleteEventPatternAfterTest(Long idEventPattern) {
//		commonEntityDAO.deleteEntityById(EventPattern.class, idEventPattern);
//	}
//
//	public GroupMember createGroupMemberForTest() {
//
//		AccountGroup testAccountGroup = createAccountGroupForTest();
//		GroupMember testGroupMember = new GroupMember();
//
//		testGroupMember.setMemberAccount(testAccountGroup.getAccount());
//		testGroupMember.setGroupMemberStatus("friend");
//		testGroupMember.setAccountGroup(testAccountGroup);
//		commonEntityDAO.saveEntity(testGroupMember);
//
//		return testGroupMember;
//	}
//
//	public void deleteGroupMemberAfterTest(Long idGroupMember) {
//
//		GroupMember testGroupMember = (GroupMember) commonEntityDAO
//				.getEntityById(GroupMember.class, idGroupMember);
//		AccountGroup testAccountGroup = (AccountGroup) commonEntityDAO
//				.getEntityById(AccountGroup.class, testGroupMember
//						.getAccountGroup().getIdAccountGroup());
//
//		commonEntityDAO.deleteEntity(testGroupMember);
//		deleteAccountGroupAfterTest(testAccountGroup.getIdAccountGroup());
//	}
//
//	public GroupEvent createGroupEventForTest() {
//
//		GroupMember testGroupMember = createGroupMemberForTest();
//		EventPattern testEventPattern = createEventPatternForTest();
//		GroupEvent testGroupEvent = new GroupEvent();
//
//		testGroupEvent.setEventPattern(testEventPattern);
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00));
//		testGroupEvent.setDateCreateGroupEvent(dateCreate);
//		testGroupEvent.setGroupMember(testGroupMember);
//		commonEntityDAO.saveEntity(testGroupEvent);
//
//		return testGroupEvent;
//	}
//
//	public void deleteGroupEventAfterTest(Long idGroupEvent) {
//
//		GroupEvent testGroupEvent = (GroupEvent) commonEntityDAO.getEntityById(
//				GroupEvent.class, idGroupEvent);
//		EventPattern testEventPattern = (EventPattern) commonEntityDAO
//				.getEntityById(EventPattern.class, testGroupEvent
//						.getEventPattern().getIdEventPattern());
//		GroupMember testGroupMember = (GroupMember) commonEntityDAO
//				.getEntityById(GroupMember.class, testGroupEvent
//						.getGroupMember().getIdGroupMember());
//
//		commonEntityDAO.deleteEntity(testGroupEvent);
//		deleteEventPatternAfterTest(testEventPattern.getIdEventPattern());
//		deleteGroupMemberAfterTest(testGroupMember.getIdGroupMember());
//	}
//
//	public GroupMessage createGroupMessageForTest() {
//
//		GroupMember testGroupMember = createGroupMemberForTest();
//		GroupMessage testGroupMessage = new GroupMessage();
//
//		testGroupMessage.setGroupMessage("Test Group Message");
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00));
//		testGroupMessage.setDateCreateGroupMessage(dateCreate);
//		testGroupMessage.setGroupMember(testGroupMember);
//		commonEntityDAO.saveEntity(testGroupMessage);
//
//		return testGroupMessage;
//	}
//
//	public void deleteGroupMessageAfterTest(Long idGroupMessage) {
//
//		GroupMessage testGroupMessage = (GroupMessage) commonEntityDAO
//				.getEntityById(GroupMessage.class, idGroupMessage);
//		GroupMember testGroupMember = (GroupMember) commonEntityDAO
//				.getEntityById(GroupMember.class, testGroupMessage
//						.getGroupMember().getIdGroupMember());
//
//		commonEntityDAO.deleteEntity(testGroupMessage);
//		deleteGroupMemberAfterTest(testGroupMember.getIdGroupMember());
//	}
//
//	public Forum createForumForTest() {
//
//		Forum testForum = new Forum();
//		testForum.setForumName("TestForum");
//		testForum.setViewStatus("public");
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00));
//		testForum.setDateCreateForum(dateCreate);
//		commonEntityDAO.saveEntity(testForum);
//
//		return testForum;
//	}
//
//	public void deleteForumAfterTest(Long idForum) {
//		commonEntityDAO.deleteEntityById(Forum.class, idForum);
//	}
//
//	public ForumTopic createForumTopicForTest() {
//
//		Forum testForum = createForumForTest();
//		Account testAuthorTopicAccount = createAccountForTest();
//		ForumTopic testForumTopic = new ForumTopic();
//
//		testForumTopic.setForumTopic("TestForumTopic");
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00));
//		testForumTopic.setDateCreateForumTopic(dateCreate);
//		testForumTopic.setForum(testForum);
//		testForumTopic.setAuthorAccount(testAuthorTopicAccount);
//		commonEntityDAO.saveEntity(testForumTopic);
//
//		return testForumTopic;
//	}
//
//	public void deleteForumTopicAfterTest(Long idForumTopic) {
//
//		ForumTopic testForumTopic = (ForumTopic) commonEntityDAO.getEntityById(
//				ForumTopic.class, idForumTopic);
//		Forum testForum = (Forum) commonEntityDAO.getEntityById(Forum.class,
//				testForumTopic.getForum().getIdForum());
//		Account testAuthorTopicAccount = (Account) commonEntityDAO
//				.getEntityById(Account.class, testForumTopic.getAuthorAccount()
//						.getIdAccount());
//
//		commonEntityDAO.deleteEntity(testForumTopic);
//		deleteForumAfterTest(testForum.getIdForum());
//		deleteAccountAfterTest(testAuthorTopicAccount.getIdAccount());
//	}
//
//	public ForumMessage createForumMessageForTest() {
//		
//		ForumTopic testForumTopic = createForumTopicForTest();
//		Account testAuthorAccount = createAccountForTest();
//		ForumMessage testForumMessage = new ForumMessage();
//		
//		testForumMessage.setForumMessage("TestForum Message");
//		Date dateCreate=converter.convertLocalDateTimeToDate(LocalDateTime.of(2015, 12, 17,00, 00));
//		testForumMessage.setDateCreateForumMessage(dateCreate);
//		testForumMessage.setForumTopic(testForumTopic);
//		testForumMessage.setAuthorAccount(testAuthorAccount);
//		commonEntityDAO.saveEntity(testForumMessage);
//		
//		return testForumMessage;
//	}
//	
//	public void deleteForumMessageAfterTest(Long idForumMessage) {
//		
//		ForumMessage testForumMessage = (ForumMessage) commonEntityDAO.getEntityById(
//				ForumMessage.class, idForumMessage);
//		ForumTopic testForumTopic = (ForumTopic) commonEntityDAO.getEntityById(ForumTopic.class,
//				testForumMessage.getForumTopic().getIdForumTopic());
//		Account testAuthorAccount = (Account) commonEntityDAO
//				.getEntityById(Account.class, testForumMessage.getAuthorAccount().getIdAccount());
//	
//		commonEntityDAO.deleteEntity(testForumMessage);
//		deleteForumTopicAfterTest(testForumTopic.getIdForumTopic());		
//		deleteAccountAfterTest(testAuthorAccount.getIdAccount());
//	}
//	
//	public AccountForum createAccountForumForTest() {
//		
//		Account testAccount = createAccountForTest();
//		Forum testForum = createForumForTest();
//		AccountForum testAccountForum = new AccountForum();
//		
//		testAccountForum.setAccount(testAccount);
//		testAccountForum.setForum(testForum);
//		commonEntityDAO.saveEntity(testAccountForum);
//		
//		return testAccountForum;
//	}
//	
//	public void deleteAccountForumAfterTest(Long idAccountForum) {
//		
//		AccountForum testAccountForum = (AccountForum) commonEntityDAO.getEntityById(
//				AccountForum.class, idAccountForum);
//		Account testAccount = (Account) commonEntityDAO.getEntityById(Account.class,testAccountForum.getAccount().getIdAccount());
//		Forum testForum = (Forum) commonEntityDAO.getEntityById(Forum.class,testAccountForum.getForum().getIdForum());	
//		
//		commonEntityDAO.deleteEntity(testAccountForum);
//		deleteAccountAfterTest(testAccount.getIdAccount());
//		deleteForumAfterTest(testForum.getIdForum());
//	}
}
