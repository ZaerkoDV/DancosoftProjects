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

import com.dancosoft.socialcommunity.dao.CommonEntityDAO;
import com.dancosoft.socialcommunity.service.CommonEntityService;

/**
 * <p> The class CommonEntityServiceImpl use Service pattern which describes
 * business logic of application SocialCommunity.Service layer perform link
 * between, presentation layer and DAO layer. This layer is the main role
 * becouse layer contents(set of methods in classes) affect on functionality of
 * all application. This class contain methods which describes base operation
 * with any entity.This class is general for all classes in service layer.All
 * classes in this layer extend this class and expand base operation which
 * contain in. Class implements interface CommonEntityService which perform all
 * methods of this class. For logging use framework shell slf4j and framework
 * log4j.Class contain also private, static variable logger, which use to call
 * log message. Class use Spring framework anatation to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
 */
@Service(value="commonEntityService")
public class CommonEntityServiceImpl implements CommonEntityService {

	private static final Logger logger = LoggerFactory.getLogger(CommonEntityServiceImpl.class);
	
	@Autowired
	@Qualifier("commonEntityDAO")
	private CommonEntityDAO commonEntityDAO;

	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO) {
		this.commonEntityDAO = commonEntityDAO;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method return entity by idEntity. If entity not exist return null(use
	 * hibernateTamplate method get)
	 * 
	 * @type Long
	 * @type Object
	 * @param entityClass
	 * @param idEntity
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Object
	 */
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity) {
		
		Object obj = null;
		if (idEntity.equals(null) || idEntity.equals("")) {
			throw new RuntimeException("EntityService:Id "+entityClass.getName() + " entity is null");
		} else {
			try {
				obj = commonEntityDAO.getEntityById(entityClass, idEntity);
				logger.info("EntityService:Entity" + entityClass.getName()+ " loaded successfully id=" + idEntity);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("EntityService:Not found entity in data base=" + rf);
				// throw new EntityNotFoundException();
			} catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
			}
		}
		return obj;
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 * 
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void saveEntity(Object entity) {
		
		if(entity.equals(null)){
			throw new RuntimeException("EntityService: Entity not save becouse entity is null.");
		} else {
			try {
				commonEntityDAO.saveEntity(entity);
				logger.info("EntityService:Entity save successfully");
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("EntityService:New entity not save becouse mismatch field type "+tm);
			}catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 * @exception TypeMismatchDataAccessException
	 * @exception DataAccessException
	 */
	public void updateEntity(Object entity) {
		
		if (entity.equals(null)) {
			throw new RuntimeException("EntityService: Entity not save becouse entity is null.");
		} else {
			try {
				logger.info("EntityService:Entity update successfully");
				commonEntityDAO.updateEntity(entity);
				
			} catch (TypeMismatchDataAccessException tm) {
				logger.error("EntityService:New entity not update becouse mismatch field type "+ tm);
			} catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @type Object
	 * @param entityClass
	 * @param idEntity
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 */
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity) {
		
		if (idEntity.equals(null) || idEntity.equals("")) {
			throw new RuntimeException("EntityService:Id "+entityClass.getName() + " entity is null");
		} else{
			try {
				logger.info("EntityService:Entity" + entityClass.getName()+ " delete successfully,id=" + idEntity);
				commonEntityDAO.deleteEntityById(entityClass, idEntity);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("EntityService: Operation delete is faled becouse"
						+ " not found entity in data base by id=" + rf);
				
			} catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 * @exception DataAccessException
	 */
	public void deleteEntity(Object entity) {
		
		if (entity.equals(null)) {
			throw new RuntimeException("EntityService: Object is "+entity+ " yet and not delete again.");
		}else{
			try {
				logger.info("EntityService:Entity " + entity + " delete successfully");
				commonEntityDAO.deleteEntity(entity);
				
			} catch (DataAccessException da) {
				logger.error("EntityService:Exeption connect with data base or other error= "+da);
			}
		}
	}
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @type Class<T> 
	 * @param entityClass
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Object>
	 */
	public <T> List<Object> getListEntity(Class<T> entityClass) {
		
		List<Object>list=Collections.emptyList();
		try {
			logger.info("EntityService: List of entity" + entityClass.getName()+ "load");
			list=commonEntityDAO.getListEntity(entityClass);
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("EntityService: List of entity not load becouse list is empty=" + rf);
			
		}catch (DataAccessException da) {
			logger.error("EntityService:Exeption connect with data base or other error= "+da);
		}
		return list;
	}
}
