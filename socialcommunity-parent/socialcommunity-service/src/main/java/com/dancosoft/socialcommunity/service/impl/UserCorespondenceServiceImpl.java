/**
 * @package com.dancosoft.socialcommunity.service.impl
 * 
 * Package com.dancosoft.socialcommunity.service.impl contain set of class which description
 * service layer(modul) in SocialCommunity project. This project based on MVC architecture.
 * This class is part of service layer in MVC architecture.This layer defines the boundary
 * of the application and a set of permitted operations. It encapsulates the business logic
 * of the application and controls the answers in the implementation of operations.All classes
 * which contain postfix “Service” provide to work Service for SocialCommunity application.
 * Also this package user support classes: for generate new passworl and login,for sending
 * email to user and other from com.dancosoft.socialcommunity.service.support package.
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions.   
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
 * <p>The class UserCorespondenceServiceImpl use Service pattern which describes
 * business logic SocialCommunity application. Service layer perform link
 * between, presentation layer and DAO layer(UserCorespondenceDAO).This layer is
 * the main role becouse layer contents(set of methods in classes) affect on
 * functionality of all application. This class contain methods which describes
 * specific operation for UserCorespondence.This class perform service layer to
 * UserCorespondence.Class extend base class CommonEntityServiceImpl and
 * implement UserCorespondenceService interface which perform all methods of
 * this class. For logging use fasade slf4j and framework log4j. Class contain
 * also private, static variable logger, which use to call log message. Class
 * use Spring framework anatations to work with service layer.
 * 
 * @see org.springframework.stereotype
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 05.01.2016
 * @author Zaerko Denis
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
	
	/**
	 * Method return status user corespondence by id user corespondence.
	 * 
	 * @type Long
	 * @param idUserCorespondence
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return String
	 */
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
	
	/**
	 * Method return list of users corespondence with view status public. If user
	 * corspondence are not exist return empty list.
	 * 
	 * @exception DataRetrievalFailureException
	 * @exception DataAccessException
	 * 
	 * @return List<UserCorespondence>
	 */
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
