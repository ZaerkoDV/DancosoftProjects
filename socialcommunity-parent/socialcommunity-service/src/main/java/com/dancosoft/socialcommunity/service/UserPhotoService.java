/**
 * @package com.dancosoft.socialcommunity.service
 * 
 * Package com.dancosoft.socialcommunity.service contain set of interfaces which
 * description service layer of SocialCommunity project.Also this package contain
 * realization of interfaces in package com.dancosoft.socialcommunity.service.impl
 * and support classes in com.dancosoft.socialcommunity.service.support.This project
 * is based on MVC architecture.This inerface perform class which is part of service
 * layer in MVC architecture.This layer defines the boundary of the application and
 * a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which
 * contain postfix “Service” provide to work Service for SocialCommunity application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

import com.dancosoft.socialcommunity.model.UserPhoto;

/**
 * <p>The interface UserPhotoService contain methods ads which realize in class
 * UserPhotoServiceImpl. Class UserPhotoServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface UserPhotoService extends CommonEntityService {

	/**
	 * Method return user photo by id user. If user photo is not exist return null
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserPhoto
	 */
	public UserPhoto getUserPhotoByIdUser(Long idUser); 
	
	/**
	 * Method return return photo name by id user. If photo name
	 * is not exist return null.
	 * 
	 * @type Long
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
	public String getPhotoNameByIdUser(Long idUser);
	
	/**
	 * Save photo in floder (/src/main/resources/user-image/) of project.
	 * And save uniqul photo name in data base. If save successfully return
	 * true else false
	 * 
	 * @type Long
	 * @boolean
	 * @param idUser
	 * @param format
	 * @param urlSource
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * @exception IOException
	 * @exception FileNotFoundException
	 * 
	 * @return Boolean
	 */
	public Boolean savePhotoAsFormat(Long idUser,String format, String path);
	
	/**
	 * Load path to user photo by id user. If photo not found return null;
	 * 
	 * @type Long
	 * @type String 
	 * @param idUser
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
	public String loadPathToUserPhoto(Long idUser);
}
