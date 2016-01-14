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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.TypeMismatchDataAccessException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.LanguageDAO;
import com.dancosoft.socialcommunity.model.Language;
import com.dancosoft.socialcommunity.service.LanguageService;

/**
 * <p>The class LanguageServiceImpl use Service pattern which describes business
 * logic SocialCommunity application. Service layer perform link between,
 * presentation layer and DAO layer(LanguageDAO).This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes specific
 * operation for Language.This class perform service layer to Language.Class
 * extend base class CommonEntityServiceImpl and implement LanguageService
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
@Service(value="languageService")
public class LanguageServiceImpl implements LanguageService {

	private static final Logger logger = LoggerFactory.getLogger(LanguageServiceImpl.class);
	
	@Autowired
	@Qualifier(value="languageDAO")
	private LanguageDAO languageDAO;

	public void setLanguageDAO(LanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @param idLanguage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Language
	 */
	public Language getEntityById(Long idLanguage) {
		
		Language language = null;
		if (idLanguage.equals(null) || idLanguage.equals("")) {
			throw new RuntimeException("LanguageService:Id entity is null");
		} else {
			try {
				language = (Language) languageDAO.getEntityById(idLanguage);
				logger.info("LanguageService:Entity loaded successfully id=" + idLanguage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("LanguageService:Not found entity in data base=" + rf);
			
			} catch (DataAccessException da) {
				logger.error("LanguageService:Exeption connect with data base or other error= "+da);
			}
		}
		return language;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type Language
	 * @param language
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveLanguage(Language language) {
		
		if(language.equals(null)){
			throw new RuntimeException("LanguageService: Entity not save becouse entity is null.");
		} else {
			try {
				languageDAO.saveEntity(language);
				logger.info("LanguageService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("LanguageService:New entity not save becouse mismatch field type "+tm);
				
			}catch (DataAccessException da) {
				logger.error("LanguageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type Language
	 * @param language
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateLanguage(Language language) {
		
		if (language.equals(null)) {
			throw new RuntimeException("LanguageService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("LanguageService:Entity update successfully");
				languageDAO.updateEntity(language);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("LanguageService:New entity not update becouse mismatch field type "+ tm);
				
			} catch (DataAccessException da) {
				logger.error("LanguageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @param idLanguage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public void deleteLanguageById(Long idLanguage) {
		
		if (idLanguage.equals(null) || idLanguage.equals("")) {
			throw new RuntimeException("LanguageService:Id entity is null");
		} else{
			try {
				logger.info("LanguageService:Entity  delete successfully,id=" + idLanguage);
				languageDAO.deleteEntityById(idLanguage);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("LanguageService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("LanguageService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type Language
	 * @param language
	 * 
	 * @exception DataAccessException
	 */
	public void deleteLanguage(Language language) {
		
		if (language.equals(null)) {
			throw new RuntimeException("LanguageService: Object is "+language+ " yet and not delete again.");
		}else{
			try {
				logger.info("LanguageService:Entity " + language + " delete successfully");
				languageDAO.deleteEntity(language);
				
			} catch (DataAccessException da) {
				logger.error("LanguageService:Exeption connect with data base or other error= "+da);
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
	public List<Object> getListLanguage() {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("LanguageService: List of entity load");
			list=languageDAO.getListEntity();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("LanguageService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("LanguageService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
