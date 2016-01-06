/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
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
	
	public void setUserPhotoDAO(UserPhotoDAO userPhotoDAO) {
		this.userPhotoDAO = userPhotoDAO;
	}

	public UserPhoto getUserPhotoByIdUser(Long idUser) {
		
		UserPhoto userPhoto=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserPhotoService:Id user must not null!");
		} else{
			try {
				logger.info("UserPhotoService: UserPhoto load by id user");
				userPhoto= userPhotoDAO.getUserPhotoByIdUser(idUser);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserPhotoService: UserPhoto for user with id "+idUser+" not exist." + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
		return userPhoto;
	}
	
	public String getPhotoNameByIdUser(Long idUser) {
		
		String photoName=null;
		if (idUser.equals(null)) {
			throw new RuntimeException("UserPhotoService:Id user must not null!");
		} else{
			try {
				logger.info("UserPhotoService:Name of user photo load by id user");
				photoName= userPhotoDAO.getPhotoNameByIdUser(idUser);
				
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserPhotoService: Name of user photo with user id "+idUser+" not exist." + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
		return photoName;
	}
	
	//load photo frome disk(idUser)
	
	//save photo on disk (idUser)
}
