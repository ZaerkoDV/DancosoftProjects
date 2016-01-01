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

import java.util.Date;
import java.util.List;

import com.dancosoft.socialcommunity.model.Forum;

/**
 * <p>
 * The interface ForumDAO contain methods ads which realize in class
 * ForumDAOImpl.Class ForumDAOImpl use DAO pattern which describes layer of data
 * access to object. DAO layer perform link between relational and object model.
 * Model for this dao layer describied in class Forum. This interface contain
 * ads methods which intended to access operation with object. Interface produce
 * special operation with object.Base operation (for any object) include as
 * separate interface CommonEntityDAO which extend to this interface.Class use
 * Spring framework to work with ORM.In particular often use HibernateTemplate
 * for integration Hibernate and Spring technologys. For work with data base use
 * hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface ForumDAO extends CommonEntityDAO {

	/**
	 * Method return list forum which crated between dates. If forums are not
	 * exist return empty list.
	 * 
	 * @type Date
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<Forum>
	 */
	public List<Forum> getListForumCreatedBetweenDateByIdForum(Date minDate,
			Date maxDate);

	/**
	 * Method return list forum by forum name. If forums are not exist return
	 * empty list
	 * 
	 * @type String
	 * @param forumName
	 * 
	 * @return List<Forum>
	 */
	public List<Forum> searchForumByForumName(String forumName);

	/**
	 * Method return total count of forums. If forums are not exist return zero.
	 * 
	 * @type int
	 * @return int
	 */
	public int getCountForum();

	/**
	 * Method return list forum with view status. If forums are not exist return
	 * empty list.
	 * 
	 * @type String
	 * @param viewStatus
	 * 
	 * @return List<Forum>
	 */
	public List<Forum> getListForumWithStatus(String viewStatus);

	/**
	 * Method return result of check forum on private view status.
	 * 
	 * @type Long
	 * @type Boolean
	 * @param idForum
	 * 
	 * @return Boolean
	 */
	public Boolean isPrivateForum(Long idForum);
}
