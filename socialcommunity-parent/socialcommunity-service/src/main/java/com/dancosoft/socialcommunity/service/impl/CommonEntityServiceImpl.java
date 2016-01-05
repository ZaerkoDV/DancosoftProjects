/**
 * 
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
 * @author Zaerko_DV
 *
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
	
	//EntityAlreadyExistsException
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
