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

/**
 * <p>
 * The class EventPatternDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class EventPattern. Class extend
 * ÑommonEntityDAOImpl class, which contain base set of operation(CRUD). Class
 * implements interface EventPatternDAO located in package which have name
 * com.dancosoft.socialcommunity.dao.This class use Spring framework to work
 * with ORM.
 * 
 * @see org.springframework.stereotype
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface EventPatternDAO extends CommonEntityDAO {
}
