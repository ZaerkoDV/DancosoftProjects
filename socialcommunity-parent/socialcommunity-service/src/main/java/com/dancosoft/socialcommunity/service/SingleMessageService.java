/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.SingleMessage;

/**
 * @author Zaerko_DV
 *
 */
public interface SingleMessageService extends CommonEntityService {

	public List<SingleMessage> getListSingleMessageBeetweenDateByIdAccount(
			Long idAccount, LocalDateTime minDateLDT, LocalDateTime maxDateLDT);
	
	public List<Account> getListInterlocutorAccountByIdAccount(Long idAccount);
	
	public List<SingleMessage> getListIntrlocutorSingleMessageBeetweenDateByIdAccount(Long idAccount,
			Long idInterlocutorAccount,LocalDateTime minDateLDT,LocalDateTime maxDateLDT);
	
}
