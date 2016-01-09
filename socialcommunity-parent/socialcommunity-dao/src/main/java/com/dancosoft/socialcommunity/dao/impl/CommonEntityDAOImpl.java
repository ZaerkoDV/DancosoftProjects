/**
 * @package com.dancosoft.socialcommunity.dao.impl
 * 
 * Package com.dancosoft.socialcommunity.dao.impl contain set of class which description
 * layer of data access object of SocialCommunity project. This project is based on MVC
 * architecture.This class is part of dao layer(DAL pattern) in MVC architecture. This
 * layer offer abstract interface for work with any type data base. This pattern give a
 * right work with DAO (data-access-object) without matter what kind of storage engine
 * is used and without need for a special way to match this storage engine. All classes
 * which contain word �DAO� provide to work DAL for Reducer links application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.dancosoft.socialcommunity.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dancosoft.socialcommunity.dao.CommonEntityDAO;

/**
 * <p>
 * The class CommonEntityDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object
 * models. This class contain methods which intended to access to set of CRUD
 * (create, read, update, delete) operation with objects.Class provide operation
 * to any object(entity).This class extend HibernateDaoSupport class which
 * create own HibernateTemplate instance if a SessionFactory is passed in. The
 * "allowCreate" flag on that HibernateTemplate will be "true" by default. A
 * custom HibernateTemplate instance can be used through overriding
 * createHibernateTemplate. Class implements interface name as �ommonEntityDAO
 * and located in package which have name com.dancosoft.socialcommunity.dao. All
 * methods are public in class. For logging use framework shell slf4j and
 * framework log4j.Class contain also private, static variable logger, which use
 * to call log message. Class use Spring framework to work whith ORM. In
 * particular often use HibernateTemplate for integration Hibernate and Spring
 * technologys.
 * 
 * @see org.springframework.stereotype
 * @see org.springframework.orm
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
@Repository(value = "commonEntityDAO")
public class CommonEntityDAOImpl extends HibernateDaoSupport implements CommonEntityDAO {

	private static final Logger logger = LoggerFactory.getLogger(CommonEntityDAOImpl.class);

//	@SuppressWarnings({ "rawtypes"})
//	private Class entityClass;
//	
//	@SuppressWarnings({ "rawtypes"})
//	public CommonEntityDAOImpl(Class entityClass){
//		this.entityClass=entityClass;
//	}
	
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
	 * @return Object
	 */
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity) {
		logger.info("EntityDAO:Entity"+entityClass.getName()+" loaded successfully id="+idEntity);
		
		return this.getHibernateTemplate().get(entityClass, idEntity);
	}

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void saveEntity(Object entity) {
		this.getHibernateTemplate().save(entity);
		logger.info("EntityDAO:Entity save successfully");
	}

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void updateEntity(Object entity) {
		this.getHibernateTemplate().update(entity);
		logger.info("EntityDAO:Entity update successfully");
	}

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @type Object
	 * @param entityClass
	 * @param idEntity
	 */
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity) {
		
		logger.info("EntityDAO:Entity" + entityClass.getName()+ " delete successfully,id=" + idEntity);
		Object entity = this.getHibernateTemplate().get(entityClass, idEntity);
		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void deleteEntity(Object entity) {
		logger.info("EntityDAO:Entity " + entity + " delete successfully");
		this.getHibernateTemplate().delete(entity);
	}
	
	/**
	 * This method is basic for all entities. Method return list of entity. If entyty
	 * list not load return empty list.
	 * 
	 * @type Class<T> 
	 * @param entityClass
	 * 
	 * @return List<Object>
	 */
	@SuppressWarnings("unchecked")
	public <T> List<Object> getListEntity(Class<T> entityClass) {

		Criteria criteria = this.getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createCriteria(entityClass);
		criteria.setMaxResults(20);
		criteria.setFirstResult(0);

		logger.info("EntityDAO:List entity loaded successfully.");
		return criteria.list();
	}
}
