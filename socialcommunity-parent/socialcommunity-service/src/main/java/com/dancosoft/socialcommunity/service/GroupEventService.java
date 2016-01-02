/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.time.LocalDateTime;
import java.util.List;

import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.GroupEvent;

/**
 * @author Zaerko_DV
 *
 */
public interface GroupEventService extends CommonEntityService {

	public Account getMemberAccountByIdGroupEvent(Long idGroupEvent);

	public List<GroupEvent> getListGroupEventByIdAccountGroup(
			Long idAccountGroup);

	public List<GroupEvent> getListGroupEventBeetweenDateByIdAccountGroup(
			Long idAccountGroup,LocalDateTime  minDateLDT, LocalDateTime maxDateLDT); 

	public int getCountGroupEventByIdAccountGroup(Long idAccountGroup);
}
