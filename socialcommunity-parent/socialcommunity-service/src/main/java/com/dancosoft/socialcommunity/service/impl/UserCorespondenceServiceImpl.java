/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserCorespondenceDAO;
import com.dancosoft.socialcommunity.model.UserCorespondence;
import com.dancosoft.socialcommunity.service.UserCorespondenceService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userCorespondenceService")
public class UserCorespondenceServiceImpl extends CommonEntityServiceImpl implements UserCorespondenceService {

	private static final Logger logger = LoggerFactory.getLogger(UserCorespondenceServiceImpl.class);
	
	@Autowired
	@Qualifier(value="userCorespondenceDAO")
	private UserCorespondenceDAO userCorespondenceDAO;

	public void setUserCorespondenceDAO(UserCorespondenceDAO userCorespondenceDAO) {
		this.userCorespondenceDAO = userCorespondenceDAO;
	}
	
	public String getCorespondViewStatusByIdUserCorespond(Long idUserCorespondence) {
		logger.info("UserCorespondenceService: User corespondence view status loaded.");
		return userCorespondenceDAO.getCorespondViewStatusByIdUserCorespond(idUserCorespondence);
	}
	
	public List<UserCorespondence> getListUserCorespondenceForBroadcastInfo() {
		logger.info("UserCorespondenceService: List users corespondence loaded.");
		return userCorespondenceDAO.getListUserCorespondenceForBroadcastInfo();
	}
}
