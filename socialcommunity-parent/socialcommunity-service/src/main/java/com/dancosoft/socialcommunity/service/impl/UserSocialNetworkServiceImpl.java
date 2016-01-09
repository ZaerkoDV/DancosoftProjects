/**
 * @package com.dancosoft.socialcommunity.service.impl
 * 
 * Package com.dancosoft.socialcommunity.service.impl contain set of class which description
 * service layer(modul) in SocialCommunity project. This project based on MVC architecture.
 * This class is part of service layer in MVC architecture.This layer defines the boundary
 * of the application and a set of permitted operations. It encapsulates the business logic
 * of the application and controls the answers in the implementation of operations.All classes
 * which contain postfix “Service” provide to work Service for SocialCommunity application.
 * Also this package user support classes: for generate new passworl and login,for sending
 * email to user and other from com.dancosoft.socialcommunity.service.support package.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.Collections;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserSocialNetworkDAO;
import com.dancosoft.socialcommunity.model.UserSocialNetwork;
import com.dancosoft.socialcommunity.service.UserSocialNetworkService;

/**
 * <p>The class UserSocialNetworkServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(UserSocialNetworkDAO).This layer is
 * the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for UserSocialNetwork.This class perform service layer to
 * UserSocialNetwork.Class extend base class CommonEntityServiceImpl and
 * implement UserSocialNetworkService interface which perform all methods of
 * this class. For logging use fasade slf4j and framework log4j. Class contain
 * also private, static variable logger, which use to call log message. Class
 * use Spring framework anatations to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="userSocialNetworkService")
public class UserSocialNetworkServiceImpl extends CommonEntityServiceImpl implements UserSocialNetworkService{

	private static final Logger logger = LoggerFactory.getLogger(UserSocialNetworkServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userSocialNetworkDAO")
	private UserSocialNetworkDAO userSocialNetworkDAO;

	public void setUserSocialNetworkDAO(UserSocialNetworkDAO userSocialNetworkDAO) {
		this.userSocialNetworkDAO = userSocialNetworkDAO;
	}
	
	/**
	 * Method return list of social community with wiev status which use user.
	 * If social community not exist return empty list
	 * 
	 * @type Long
	 * @type String
	 * @param idUser
	 * @param viewStatus
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException 
	 * 
	 * @return List<UserSocialNetwork>
	 */
	public List<UserSocialNetwork> getListSocialNetworkWithStatusByIdUser(Long idUser,String viewStatus){
		
		List<UserSocialNetwork> list= Collections.emptyList();
		if (idUser.equals(null)) {
			throw new RuntimeException("UserSocialNetworkService:Id user must not null");
			
		}else if(viewStatus.equals(null) && viewStatus.equals("")){
			throw new RuntimeException("UserSocialNetworkService:View status must not null or empty.");
			
		}else{
			try {
				logger.info("UserSocialNetworkService:List user social network with status loaded.");
				list= userSocialNetworkDAO.getListSocialNetworkWithStatusByIdUser(idUser, viewStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserSocialNetworkService: List of user social network with view"
						+ " status"+viewStatus+" load, but list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserSocialNetworkService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	/**
	 * Method cheak user skype address on uniqule value. If user
	 * skype have unique value return true else return false.
	 * 
	 * @type String
	 * @param skypeAddress
	 * 
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqueSkype(String skypeAddress){
		
		Boolean isUnique=false;
		if(skypeAddress.equals(null) && skypeAddress.equals("")){
			throw new RuntimeException("UserSocialNetworkService:Skype address must not null or empty.");
		}else{
			try {
				logger.info("UserSocialNetworkService: Check user skype address on unique value.");
				isUnique= userSocialNetworkDAO.isUniqueSkype(skypeAddress);
				
			} catch (DataAccessException da) {
				logger.error("UserSocialNetworkService:Exeption connect with data base or other error= "+da);
			}
		}
		return isUnique;
	}
	
	/**
	 * Method cheak user facebook address on uniqule value. If user
	 * facebook have unique value return true else return false.
	 * 
	 * @type String
	 * @param facebookAddress
	 * 
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isUniqualFaceBook(String facebookAddress){
		
		Boolean isUnique=false;
		if(facebookAddress.equals(null) && facebookAddress.equals("")){
			throw new RuntimeException("UserSocialNetworkService:Facebook address must not null or empty.");
		}else{
			try {
				logger.info("UserSocialNetworkService: Check user facebook address on unique value.");
				isUnique= userSocialNetworkDAO.isUniqualFaceBook(facebookAddress);	
			} catch (DataAccessException da) {
				logger.error("UserSocialNetworkService:Exeption connect with data base or other error= "+da);
			}
		}
		return isUnique;	
	}
	
	/**
	 * Method return id user by user face book address. If user
	 * is not exist return null.
	 * 
	 * @type String
	 * @param facebookAddress
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Long
	 */
	public Long getIdUserByFacebookAddress(String facebookAddress){
		
		Long idUser=null;
		if(facebookAddress.equals(null) && facebookAddress.equals("")){
			throw new RuntimeException("UserSocialNetworkService:Facebook address must not null or empty.");
		}else{
			try {
				logger.info("UserSocialNetworkService:User id load by facebook address.");
				idUser=userSocialNetworkDAO.getIdUserByFacebookAddress(facebookAddress);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupHistoryService:Id user which use facebook"
						+ " "+facebookAddress+" not exist" + rf);
				
			}catch (NonUniqueResultException nu) {
				logger.error("AccountGroupHistoryService:This facebook address use several user."
						+ " Facebook address is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupHistoryService: Exeption connect with data base or other error= "+da);
			}
		}
		return idUser;
	}
}
