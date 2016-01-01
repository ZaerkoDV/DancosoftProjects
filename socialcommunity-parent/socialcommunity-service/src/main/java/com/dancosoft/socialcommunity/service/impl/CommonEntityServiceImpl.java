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
		logger.info("EntityService:Entity"+entityClass.getName()+" loaded successfully id="+idEntity);
		return commonEntityDAO.getEntityById(entityClass, idEntity);
	}
	
	public void saveEntity(Object entity) {
		logger.info("EntityService:Entity save successfully");
		commonEntityDAO.saveEntity(entity);
	}
	
	public void updateEntity(Object entity) {
		logger.info("EntityService:Entity update successfully");
		commonEntityDAO.updateEntity(entity);
	}
	
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity) {
		logger.info("EntityService:Entity" + entityClass.getName()+ " delete successfully,id=" + idEntity);
		commonEntityDAO.deleteEntityById(entityClass, idEntity);
	}
	
	public void deleteEntity(Object entity) {
		logger.info("EntityService:Entity " + entity + " delete successfully");
		commonEntityDAO.deleteEntity(entity);
	}
	
	public <T> List<Object> getListEntity(Class<T> entityClass) {
		logger.info("EntityService:List entity loaded successfully.");
		return commonEntityDAO.getListEntity(entityClass);
	}
	
}
