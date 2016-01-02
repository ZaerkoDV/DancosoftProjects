/**
 * 
 */
package com.dancosoft.socialcommunity.service;

import java.util.List;

import com.dancosoft.socialcommunity.model.UserCorespondence;

/**
 * @author Zaerko_DV
 *
 */
public interface UserCorespondenceService extends CommonEntityService {
	
	public String getCorespondViewStatusByIdUserCorespond(Long idUserCorespondence);

	public List<UserCorespondence> getListUserCorespondenceForBroadcastInfo();
}
