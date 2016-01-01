/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.dao.CommonEntityDAO;

/**
 * @author Zaerko_DV
 *
 */
public interface CommonEntityService {

	public void setCommonEntityDAO(CommonEntityDAO commonEntityDAO);

	public <T> Object getEntityById(Class<T> entityClass, Long idEntity);

	public void saveEntity(Object entity);

	public void updateEntity(Object entity);

	public <T> void deleteEntityById(Class<T> entityClass, Long idEntity);

	public void deleteEntity(Object entity);

	public <T> List<Object> getListEntity(Class<T> entityClass);

}
