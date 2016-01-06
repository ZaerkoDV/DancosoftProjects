/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
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
		
		String viewStatus=null;
		if (idUserCorespondence.equals(null)) {
			throw new RuntimeException("ForumMessageService:Id Forum messages must not null");
		} else{			
			try {
				logger.info("UserCorespondenceService: User corespondence view status loaded.");
				viewStatus= userCorespondenceDAO.getCorespondViewStatusByIdUserCorespond(idUserCorespondence);
				
			}  catch (DataRetrievalFailureException rf) {
				logger.error("UserCorespondenceService: View status not load becouse user"
						+ " corespondence with id "+idUserCorespondence+" not exist." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserCorespondenceService:Exeption connect with data base or other error= "+da);
			}
		}
		return viewStatus;
	}
	
	public List<UserCorespondence> getListUserCorespondenceForBroadcastInfo() {
		
		List<UserCorespondence> list=Collections.emptyList();
		try {
			logger.info("UserCorespondenceService: List users corespondence"
					+ " with public view status loaded.");
			list=userCorespondenceDAO.getListUserCorespondenceForBroadcastInfo();
			
		} catch (DataRetrievalFailureException rf) {
			logger.warn("UserCorespondenceService: List users corespondence"
					+ " with public view status load but is empty." + rf);
			
		} catch (DataAccessException da) {
			logger.error("UserCorespondenceService:Exeption connect with data base"
					+ " or other error= "+da);
		}
		return list;
	}
}
