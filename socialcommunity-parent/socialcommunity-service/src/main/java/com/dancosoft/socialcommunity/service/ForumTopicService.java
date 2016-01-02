/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
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
			Long idForum, LocalDateTime minDateLDT, LocalDateTime maxDateLDT);
	
	public int getCountForumTopic(Long idForum);
}
