/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
import java.util.List;

import com.dancosoft.socialcommunity.model.Forum;

/**
 * @author Zaerko_DV
 *
 */
public interface ForumService extends CommonEntityService {

	public List<Forum> getListForumCreatedBetweenDateByIdForum(LocalDateTime minDateLDT,LocalDateTime maxDateLDT); 
	
	public int getCountForum();

	public List<Forum> searchForumByForumName(String forumName);
	
	public List<Forum> getListForumWithStatus(String viewStatus);
	
	public Boolean isPrivateForum(Long idForum);
}
