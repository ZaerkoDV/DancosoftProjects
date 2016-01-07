/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
import com.dancosoft.socialcommunity.service.support.UrlChecker;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userPhotoService")
public class UserPhotoServiceImpl extends CommonEntityServiceImpl implements UserPhotoService {

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
	    	
	    }else{
	    	path=resultSearchFile.get(0)+"\\"+photoName;
	    	logger.info("UserPhotoService:Path for user photo load by user id"+idUser);
	    }
	    return path;
	}
		
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

}
