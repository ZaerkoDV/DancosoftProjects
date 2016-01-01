/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.Date;
import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.ForumTopic;

/**
 * @author Zaerko_DV
 *
 */
public interface ForumTopicService extends CommonEntityService {

	public Account getAuthorAccountForumTopic(Long idForumTopic);
	
	public List<ForumTopic> getListForumTopicByIdForum(Long idForum);
	
	public List<ForumTopic> getListForumTopicCreateBetweenDateByIdForum(
			Long idForum, Date minDate, Date maxDate);
	
	public int getCountForumTopic(Long idForum);
}
