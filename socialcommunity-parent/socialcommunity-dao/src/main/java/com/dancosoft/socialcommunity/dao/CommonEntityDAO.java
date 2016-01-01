/**
 * Package com.dancosoft.socialcommunity.dao contain set of classes and interfaces which description
 * layer of data access object of SocialCommunity project. This project is based on MVC architecture.
 * This class is part of dao layer in MVC architecture. This layer offer abstract interface for work
 * with any type data base. This pattern give a chance work with DAO (data-access-object) without matter
 * what kind of storage engine is used and without need for a special way to match this storage engine.
 * All classes which contain word"DAO"provide to work DAL for ReducerLinks application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.dao;

import java.util.List;

/**
 * <p>
 * The interface CommonEntityDAO contain methods ads which realize in class
 * CommonEntityDAOImpl. Class CommonEntityDAO use DAO pattern which describes
 * layer of data access to object.This class contain general operation to all
 * model.This interface contain ads methods which intended to access to
 * operation with objects.Class use Spring framework to work whith ORM. In
 * particular often use HibernateTemplate for integration Hibernate and Spring
 * technologys. For work with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface CommonEntityDAO {

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
	public <T> Object getEntityById(Class<T> entityClass,Long idEntity);

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method save entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void saveEntity(Object entity);

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method update entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void updateEntity(Object entity);

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity by id if entity not null.
	 * 
	 * @type Long
	 * @type Object
	 * @param entityClass
	 * @param idEntity
	 */
	public <T> void deleteEntityById(Class<T> entityClass,Long idEntity);

	/**
	 * This method is basic for all entities.The method is one of CRUD methods.
	 * Method delete entity if entity not null.
	 * 
	 * @type Object
	 * @param entity
	 */
	public void deleteEntity(Object entity);

	/**
	 * This method is basic for all entities. Method return list of entity. If
	 * entyty list not load return empty list.
	 * 
	 * @type Class<T>
	 * @param entityClass
	 * 
	 * @return List<Object>
	 */
	public <T> List<Object> getListEntity(Class<T> entityClass);
}
