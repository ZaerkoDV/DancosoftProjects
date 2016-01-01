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
import com.dancosoft.socialcommunity.model.GroupEvent;

/**
 * <p> The interface GroupEventDAO contain methods ads which realize in class
 * GroupEventDAOImpl.Class GroupEventDAOImpl use DAO pattern which describes
 * layer of data access to object. DAO layer perform link between relational and
 * object model. Model for this dao layer describied in class GroupEvent. This
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
public interface GroupEventDAO extends CommonEntityDAO {

	/**
	 * Method return group member account by id group event. Account
	 * ovner create this group event. If member is not exist return null
	 * 
	 * @type Long
	 * @param idGroupEvent
	 * 
	 * @return Account
	 */
	public Account getMemberAccountByIdGroupEvent(Long idGroupEvent);

	/**
	 * Method return list of group event by id account group. If group event is
	 * not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupEvent>
	 */
	public List<GroupEvent> getListGroupEventByIdAccountGroup(
			Long idAccountGroup);

	/**
	 * Method return list of group event which created berween min and max date by id
	 * account group. If group event is not exist return empty list.
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return List<GroupEvent>
	 */
	public List<GroupEvent> getListGroupEventBeetweenDateByIdAccountGroup(
			Long idAccountGroup, Date minDate, Date maxDate);

	/**
	 * Method return count of group event by id account group. If account group
	 * is not contain event return zero
	 * 
	 * @type Long
	 * @param idAccountGroup
	 * 
	 * @return int
	 */
	public int getCountGroupEventByIdAccountGroup(Long idAccountGroup);
}
