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

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserPhotoDAO;
import com.dancosoft.socialcommunity.model.UserPhoto;
import com.dancosoft.socialcommunity.service.UserPhotoService;
import com.dancosoft.socialcommunity.service.support.url.UrlChecker;

/**
 * <p>The class UserPhotoServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(UserPhotoDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for UserLocation.This class perform service layer to UserLocation.Class
 * extend base class CommonEntityServiceImpl and implement UserLocationService
 * interface which perform all methods of this class. For logging use fasade
 * slf4j and framework log4j. Class contain also private, static variable
 * logger, which use to call log message. Class use Spring framework anatations
 * to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="userPhotoService")
public class UserPhotoServiceImpl implements UserPhotoService {

	private static final Logger logger = LoggerFactory.getLogger(UserPhotoServiceImpl.class);
	
	UrlChecker urlChecker = new UrlChecker();
	
	private final String systemPath=System.getProperty("user.dir");
	
	private List<String> resultSearchFile = new ArrayList<String>();
	
	@Autowired
	@Qualifier(value="userPhotoDAO")
	private UserPhotoDAO userPhotoDAO;
	
	public void setUserPhotoDAO(UserPhotoDAO userPhotoDAO) {
		this.userPhotoDAO = userPhotoDAO;
	}

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
	public Boolean savePhotoAsFormat(Long idUser,String format, String urlSource){
		
		Boolean localSave=false;
		Boolean dbSave=false;
		if(idUser.equals(null)){
			throw new RuntimeException("UserPhotoService:Id user must not null!");
			
		}else if(urlSource.equals(null)||urlSource.equals("") || !urlChecker.isValidURL(urlSource)){
			throw new RuntimeException("UserPhotoService:Url must not null or empty!");
			
		}else{
			String photoName=idUser+"."+format;
			
			String pathToSave=systemPath+"/src/main/resources/user-image/"+format+"/";
			BufferedImage image = null;
			URL url =null;
	        try {
	            url = new URL(urlSource);
	            image = ImageIO.read(url);
	            ImageIO.write(image, format,new File(pathToSave.trim()+photoName.trim()));
	            logger.info("UserPhotoService:User photo save to disk "+pathToSave+" with name"+photoName);
	            localSave=true;
	            
	        }catch(FileNotFoundException fnf){
	        	logger.error("UserPhotoService: Not found path "+pathToSave+"+to save photo!!"+fnf);        	
	        	
			}catch (IOException e) {
				logger.error("UserPhotoService:Uknow error when save photo on local disk. "+e);
	        }
	        
	        try {
	        	UserPhoto userPhoto=getUserPhotoByIdUser(idUser);
	            userPhoto.setPhotoName(photoName);
	            userPhotoDAO.updateEntity(userPhoto);
	            logger.info("UserPhotoService:User photo save to data base with name"+photoName);
	            dbSave=true;
	            
			}catch (DataRetrievalFailureException rf) {
				logger.warn("UserPhotoService: UserPhoto not load by user id, becouse user have not photo! "
						+ "UserPhoto object must create before save photo(image)!" + rf);
				
			}catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
		
		if(localSave && dbSave){
			logger.info("UserPhotoService:Operation save photo successfully colmpleted.");
			return true;
			
		}else{
			logger.error("UserPhotoService:Operation save photo not colmpleted! Photo"
					+ " not save in local machine or not save photo name in db!");
			return false;
		}
	}
	
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
	public String loadPathToUserPhoto(Long idUser){
		
		String path=null;
		String photoName=getPhotoNameByIdUser(idUser);
		String directoryForSearch=systemPath+"/src/main/resources/user-image/";

	    findFile(photoName,new File(directoryForSearch));
	    
	    if(resultSearchFile.size()>1){
	    	logger.error("UserPhotoService:UserPhotoService:Not unique name photo in directories.");
	    	throw new RuntimeException("UserPhotoService:Not unique name photo in directories."
	    			+ " There are two or more photo with ununiqual name "+photoName+" ");
	    	
	    }else if(resultSearchFile.size()==0){
	    	logger.warn("UserPhotoService: Path for user photo not found by user id"+idUser);
	    	//throw new RuntimeException("Not found photo");    
	    	
	    }else{
	    	path=resultSearchFile.get(0)+"\\"+photoName;
	    	logger.info("UserPhotoService:Path for user photo load by user id"+idUser);
	
	    }
	    return path;
	}
		
	/**
	 * Method add to list path(absolute) to file. If several file
	 * return list pathes
	 * 
	 * @type String
	 * @type File
	 * @param fileName
	 * @param directoryForSearch
	 */
	public void findFile(String fileName,File directoryForSearch){
	
		File[] files = directoryForSearch.listFiles();
		if (!files.equals(null)) {
			for (File file : files) {

				if (file.isDirectory()) {
					findFile(fileName, file);
					
				} else if (fileName.equalsIgnoreCase(file.getName())) {
					logger.info("UserPhotoService:File found with name "+fileName+" in"
							+ " derectory "+directoryForSearch+"! ");
					resultSearchFile.add(file.getParentFile().toString());
				}
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idUserPhoto
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return UserPhoto
	 */
	public UserPhoto getUserPhotoById(Long idUserPhoto) {
		
		UserPhoto userPhoto = null;
		if (idUserPhoto.equals(null) || idUserPhoto.equals("")) {
			throw new RuntimeException("UserPhotoService:Id entity is null");
		} else {
			try {
				userPhoto = (UserPhoto) userPhotoDAO.getEntityById(idUserPhoto);
				logger.info("EntityService:Entity loaded successfully id=" + idUserPhoto);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserPhotoService:Not found entity in data base=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
		return userPhoto;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type UserPhoto
	 * @param userPhoto
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveUserPhoto(UserPhoto userPhoto) {
		
		if(userPhoto.equals(null)){
			throw new RuntimeException("UserPhotoService: Entity not save becouse entity is null.");
		} else {
			try {
				userPhotoDAO.saveEntity(userPhoto);
				logger.info("UserPhotoService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserPhotoService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type UserPhoto
	 * @param userPhoto
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateUserPhoto(UserPhoto userPhoto) {
		
		if (userPhoto.equals(null)) {
			throw new RuntimeException("UserPhotoService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("UserPhotoService:Entity update successfully");
				userPhotoDAO.updateEntity(userPhoto);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("UserPhotoService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idUserPhoto
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteUserPhotoById(Long idUserPhoto) {
		
		if (idUserPhoto.equals(null) || idUserPhoto.equals("")) {
			throw new RuntimeException("UserPhotoService:Id entity is null");
		} else{
			try {
				logger.info("UserPhotoService:Entity  delete successfully,id=" + idUserPhoto);
				userPhotoDAO.deleteEntityById(idUserPhoto);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserPhotoService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type UserPhoto
	 * @param userPhoto
	 * 
	 * @exception DataAccessException
	 */
	public void deleteUserPhoto(UserPhoto userPhoto) {
		
		if (userPhoto.equals(null)) {
			throw new RuntimeException("UserPhotoService: Object is "+userPhoto+ " yet and not delete again.");
		}else{
			try {
				logger.info("UserPhotoService:Entity " + userPhoto + " delete successfully");
				userPhotoDAO.deleteEntity(userPhoto);
				
			} catch (DataAccessException da) {
				logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public <T> List<Object> getListUserPhoto() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("UserPhotoService: List of entity load");
			list=userPhotoDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserPhotoService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("UserPhotoService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
