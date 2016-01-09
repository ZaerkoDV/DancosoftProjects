/**
 * @package com.dancosoft.socialcommunity.service
 * 
 * Package com.dancosoft.socialcommunity.service contain set of interfaces which
 * description service layer of SocialCommunity project.Also this package contain
 * realization of interfaces in package com.dancosoft.socialcommunity.service.impl
 * and support classes in com.dancosoft.socialcommunity.service.support.This project
 * is based on MVC architecture.This inerface perform class which is part of service
 * layer in MVC architecture.This layer defines the boundary of the application and
 * a set of permitted operations. It encapsulates the business logic of the application
 * and controls the answers in the implementation of operations. All classes which
 * contain postfix “Service” provide to work Service for SocialCommunity application.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumTopic;

/**
 * <p>The interface ForumTopicService contain methods ads which realize in class
 * ForumTopicServiceImpl. Class ForumTopicServiceImpl use Service pattern which
 * describes service layer of application. This class contain general operation
 * to all classes.This interface contain ads methods which perform busness logic
 * all application. Interface extend CommonEntityService interface which contain
 * ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface ForumTopicService extends CommonEntityService {

	/**
	 * Method return account(author) which create forum topic by id forum topic.
	 * If author not exist return null  
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @exception DataRetrievalFailureException 
	 * @exception NonUniqueResultException
	 * @exception DataAccessException
	 * 
	 * @return Account
	 */
	public Account getAuthorAccountForumTopic(Long idForumTopic);
	
	/**
	 * Method return list of forum topic which belong forum. If forum
	 * topic not exist return empty list.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumTopic>
	 */
	public List<ForumTopic> getListForumTopicByIdForum(Long idForum);
	
	/**
	 * Method return list of forum topic which created between minDate and maxDate by forum id.
	 * If forum topic not exist return empty list.
	 * 
	 * @type Long
	 * @type Date
	 * @param idForum
	 * @param minDate
	 * @param maxDate
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumTopic>
	 */
	public List<ForumTopic> getListForumTopicCreateBetweenDateByIdForum(
			Long idForum, LocalDateTime minDateLDT, LocalDateTime maxDateLDT);
	
	/**
	 * Method return count of forum topic which belong to forum.
	 * 
	 * @type Long
	 * @param idForum
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return int
	 */
	public int getCountForumTopic(Long idForum);
}
