/**
 * 
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
 * @author Zaerko_DV
 *
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
