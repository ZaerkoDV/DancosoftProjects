/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.Date;
import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumMessage;

/**
 * @author Zaerko_DV
 *
 */
public interface ForumMessageService extends CommonEntityService {

	public Account getAccountAuthorMessageByIdForumMessage(Long idForumMessage);

	public List<ForumMessage> getListForumMessageByIdForumTopic(
			Long idForumTopic);

	public List<ForumMessage> getListForumMessageBetweenDateByIdForumTopic(
			Long idForumTopic, Date minDate, Date maxDate);

	public List<ForumMessage> getListForumMessagetByIdAccount(Long idAccount);
}
