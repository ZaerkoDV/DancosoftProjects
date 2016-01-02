/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserPhotoDAO;
import com.dancosoft.socialcommunity.model.UserPhoto;
import com.dancosoft.socialcommunity.service.UserPhotoService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userPhotoService")
public class UserPhotoServiceImpl extends CommonEntityServiceImpl implements UserPhotoService {

	private static final Logger logger = LoggerFactory.getLogger(UserPhotoServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userPhotoDAO")
	private UserPhotoDAO userPhotoDAO;
	
	public UserPhoto getUserPhotoByIdUser(Long idUser) {
		logger.info("UserPhotoService: User photo load by id user");
		return userPhotoDAO.getUserPhotoByIdUser(idUser);
	}
	
	public String getPhotoNameByIdUser(Long idUser) {
		logger.info("UserPhotoService: Name user photo load by id user");
		return userPhotoDAO.getPhotoNameByIdUser(idUser);
	}
	
	//load photo frome disk(idUser)
	
	//save photo on disk (idUser)
}
