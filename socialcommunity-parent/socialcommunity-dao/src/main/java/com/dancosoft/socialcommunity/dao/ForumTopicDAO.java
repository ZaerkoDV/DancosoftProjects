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

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumTopic;

/**
 * <p>
 * The interface ForumTopicDAO contain methods ads which realize in class
 * ForumTopicDAOImpl.Class AccountDAOImpl use DAO pattern which describes layer
 * of data access to object. DAO layer perform link between relational and
 * object model. Model for this dao layer describied in class ForumTopic. This
 * interface contain ads methods which intended to access operation with object.
 * Interface produce special operation with object.Base operation (for any
 * object) include as separate interface CommonEntityDAO which extend to this
 * interface.Class use Spring framework to work with ORM.In particular often use
 * HibernateTemplate for integration Hibernate and Spring technologys. For work
 * with data base use hibernate criteria.
 * 
 * @version 1.0 23.12.2015
 * @author Zaerko Denis
 */
public interface ForumTopicDAO extends CommonEntityDAO {

	/**
	 * Method return account(author) which create forum topic by id forum topic.
	 * If author not exist return null
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @return Account
	 */
	public Account getAuthorAccountForumTopic(Long idForumTopic);

	/**
	 * Method return list of forum topic which belong forum. If forum topic not
	 * exist return empty list.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @return List<ForumTopic>
	 */
	public List<ForumTopic> getListForumTopicByIdForum(Long idForum);

	/**
	 * Method return list of forum topic which created between minDate and
	 * maxDate by forum id. If forum topic not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idForum
	 * @param minDate
	 * @param maxDate
	 * 
	 * @return List<ForumTopic>
	 */
	public List<ForumTopic> getListForumTopicCreateBetweenDateByIdForum(
			Long idForum, Date minDate, Date maxDate);

	/**
	 * Method return count of forum topic which belong to forum.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @return int
	 */
	public int getCountForumTopic(Long idForum);
}
