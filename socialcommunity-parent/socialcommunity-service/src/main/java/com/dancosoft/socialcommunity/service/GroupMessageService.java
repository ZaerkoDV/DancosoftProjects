/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupMessage;

/**
 * @author Zaerko_DV
 *
 */
public interface GroupMessageService extends CommonEntityService {

	public Account getMemberAccountByIdGroupMessage(Long idGroupMessage);

	public List<GroupMessage> getListGroupMessageByIdAccountGroup(
			Long idAccountGroup);

	public List<GroupMessage> getListGroupMessageBeetweenDateByIdAccountGroup(
			Long idAccountGroup, LocalDateTime minDateLDT,
			LocalDateTime maxDateLDT);

	public int getCountGroupMessageByIdAccountGroup(Long idAccountGroup);
}
