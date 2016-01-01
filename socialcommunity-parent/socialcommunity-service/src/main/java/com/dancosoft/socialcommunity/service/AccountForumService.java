/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.Forum;

/**
 * @author Zaerko_DV
 *
 */
public interface AccountForumService extends CommonEntityService{

	public List<Account> getListAccountByIdForum(Long idForum); 
	
	public List<Forum> getListForumByIdAccount(Long idAccount); 
}
