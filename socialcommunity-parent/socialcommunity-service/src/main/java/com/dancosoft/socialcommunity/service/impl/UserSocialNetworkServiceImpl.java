/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
		logger.info("UserSocialNetworkService:List user social network with status loaded.");
		return userSocialNetworkDAO.getListSocialNetworkWithStatusByIdUser(idUser, viewStatus);
	}
	
	public Boolean isUniqueSkype(String skypeAddress){
		logger.info("UserSocialNetworkService: Check user skype address on unique value.");
		return userSocialNetworkDAO.isUniqueSkype(skypeAddress);
	}
	
	public Boolean isUniqualFaceBook(String facebookAddress){
		logger.info("UserSocialNetworkService: Check user facebook address on unique value.");
		return userSocialNetworkDAO.isUniqualFaceBook(facebookAddress);		
	}
	
	public Long getIdUserByFacebookAddress(String facebookAddress){
		logger.info("UserSocialNetworkService:User id load by facebook address.");
		return userSocialNetworkDAO.getIdUserByFacebookAddress(facebookAddress);
	}
}
