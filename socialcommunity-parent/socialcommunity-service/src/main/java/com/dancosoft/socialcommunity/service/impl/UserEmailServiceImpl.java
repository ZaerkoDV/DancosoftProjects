/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.UserEmailDAO;
import com.dancosoft.socialcommunity.model.UserEmail;
import com.dancosoft.socialcommunity.service.UserEmailService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="userEmailService")
public class UserEmailServiceImpl extends CommonEntityServiceImpl implements UserEmailService {

	private static final Logger logger = LoggerFactory.getLogger(UserEmailServiceImpl.class);	
	
	private Pattern pattern;

	private Matcher matcher;
	
	private static final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Autowired
	@Qualifier(value="userEmailDAO")
	private UserEmailDAO userEmailDAO;

	public void setUserEmailDAO(UserEmailDAO userEmailDAO) {
		this.userEmailDAO = userEmailDAO;
	}
	
	public List<UserEmail> getListEmailWithStatusByIdUser(Long idUser,String viewStatus){
		
		List<UserEmail> list=Collections.emptyList();
		if (idUser.equals(null)) {
			throw new RuntimeException("UserEmailService:Id user must not null");
			
		}else if(viewStatus.equals(null) || viewStatus.equals("")){
			throw new RuntimeException("UserEmailService:View status must not null");
			
		}else{
			try {
				logger.info("UserEmailService:List of user email with status loaded by id user.");
				list= userEmailDAO.getListEmailWithStatusByIdUser(idUser, viewStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserEmailService: List of user email with status loaded by id user.But list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<UserEmail> getListEmailByIdUser(Long idUser){
		
		List<UserEmail> list=Collections.emptyList();
		if (idUser.equals(null)) {
			throw new RuntimeException("UserEmailService:Id user must not null");
			
		}else{
			try {
				logger.info("UserEmailService:List of user email loaded by id user.");
				list= userEmailDAO.getListEmailByIdUser(idUser);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("UserEmailService:List of user email loaded by id user.But list is empty." + rf);
				
			} catch (DataAccessException da) {
				logger.error("UserEmailService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public Boolean isUniqueEmail(String userEmail){
		
		Boolean isUnique=false;
		if (userEmail.equals(null)) {
			throw new RuntimeException("UserEmailService:User email must not null");
		}else{
			try {
				logger.info("UserEmailService:Check user email on unique value.");
				isUnique= userEmailDAO.isUniqueEmail(userEmail);
				
			} catch (NonUniqueResultException nu) {
				logger.error("UserEmailService:Email is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("UserEmailService: Exeption connect with data base or other error= "+da);
			}
		}
		return isUnique; 
	}
	
	public Long getIdUserByEmail(String userEmail){
		
		Long idUser=null;
		if (userEmail.equals(null)) {
			throw new RuntimeException("UserEmailService:User email must not null");
			
		}else{
			try {
				logger.info("UserEmailService:User id load by email");
				idUser= userEmailDAO.getIdUserByEmail(userEmail);
				
			}catch(DataRetrievalFailureException rf){
				logger.warn("UserEmailService:Id user with email not exist." + rf);
				
			} catch (NonUniqueResultException nu) {
				logger.error("UserEmailService:Email is not unique." + nu);
				
			}catch (DataAccessException da) {
				logger.error("UserEmailService: Exeption connect with data base or other error= "+da);
			}
		}
		return idUser;
	}
	
	public Boolean isValidEmail(String email){
		
		logger.info("UserEmailService:Cheack email on valid value is completed.");
		Boolean isValid;
		try {
			pattern = Pattern.compile(emailPattern);
			matcher = pattern.matcher(email);
			isValid=matcher.matches();
			
		} catch (Exception e) {
			isValid=false;
			logger.error("UserEmailService: Email "+email+" is invalid. ");
		}
		return isValid;
	}
}
