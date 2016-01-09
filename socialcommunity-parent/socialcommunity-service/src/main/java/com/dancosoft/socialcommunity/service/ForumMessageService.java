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

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;

/**
 * <p>The interface ForumMessageService contain methods ads which realize in class
 * ForumMessageServiceImpl. Class ForumMessageServiceImpl use Service pattern
 * which describes service layer of application. This class contain general
 * operation to all classes.This interface contain ads methods which perform
 * busness logic all application. Interface extend CommonEntityService interface
 * which contain ads base operation of any entity.
 * 
 * @version 1.0 08.10.2015
 * @author Zaerko Denis
 */
public interface ForumMessageService extends CommonEntityService {

	/**
	 * Method return Account of author which create message. If account is not
	 * exist return null;
	 * 
	 * @type Long
	 * @param idForumMessage
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException 
	 * 
	 * @return Account
	 */
	public Account getAccountAuthorMessageByIdForumMessage(Long idForumMessage);

	/**
	 * Method return list of forum message by id forum topic. If messages are
	 * not exist return empty list
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumMessage>
	 */
	public List<ForumMessage> getListForumMessageByIdForumTopic(
			Long idForumTopic);

	/**
	 * Method return list of forum message which create between dates by id
	 * forum topic. If messages are not exist return empty list
	 * 
	 * @type Long
	 * @param idForumTopic
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumMessage>
	 */
	public List<ForumMessage> getListForumMessageBetweenDateByIdForumTopic(
			Long idForumTopic,LocalDateTime minDateLDT, LocalDateTime maxDateLDT);

	/**
	 * Method return list of forum message by idAccount(user). If Account not
	 * exist retunr null.
	 * 
	 * @type Long
	 * @param idForumTopic
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<ForumMessage>
	 */
	public List<ForumMessage> getListForumMessagetByIdAccount(Long idAccount);
}
