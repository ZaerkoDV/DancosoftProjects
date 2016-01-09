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

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;

import com.dancosoft.socialcommunity.model.Forum;

/**
 * <p>The interface ForumService contain methods ads which realize in class
 * ForumServiceImpl. Class ForumServiceImpl use Service pattern which describes
 * service layer of application. This class contain general operation to all
 * classes.This interface contain ads methods which perform busness logic all
 * application. Interface extend CommonEntityService interface which contain ads
 * base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface ForumService extends CommonEntityService {

	/**
	 * Method return list forum which crated between dates. If forums
	 * are not exist return empty list.
	 * 
	 * @type Date
	 * @param minDate
	 * @param maxDate
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Forum>
	 */
	public List<Forum> getListForumCreatedBetweenDateByIdForum(LocalDateTime minDateLDT,LocalDateTime maxDateLDT); 
	
	/**
	 * Method return total count of forums. If forums are not exist return zero. 
	 * 
	 * @type int
	 * @exception DataAccessException
	 * 
	 * @return int
	 */
	public int getCountForum();

	/**
	 * Method return list forum by forum name. If forums are not
	 * exist return empty list
	 * 
	 * @type String 
	 * @param forumName
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<Forum>
	 */
	public List<Forum> searchForumByForumName(String forumName);
	
	/**
	 * Method return list forum with view status. If forums are not
	 * exist return empty list.
	 * 
	 * @type String 
	 * @param viewStatus
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
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
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return Boolean
	 */
	public Boolean isPrivateForum(Long idForum);
}
