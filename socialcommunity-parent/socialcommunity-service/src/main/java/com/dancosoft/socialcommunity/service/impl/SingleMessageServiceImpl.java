/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dancosoft.socialcommunity.dao.SingleMessageDAO;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.SingleMessage;
import com.dancosoft.socialcommunity.service.SingleMessageService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value = "singleMessageService")
public class SingleMessageServiceImpl extends CommonEntityServiceImpl implements SingleMessageService {

	private static final Logger logger = LoggerFactory.getLogger(SingleMessageServiceImpl.class);

	@Autowired
	@Qualifier(value = "singleMessageDAO")
	private SingleMessageDAO singleMessageDAO;

	public void setSingleMessageDAO(SingleMessageDAO singleMessageDAO) {
		this.singleMessageDAO = singleMessageDAO;
	}

	TimeConverter converter = new TimeConverter();

	public List<SingleMessage> getListSingleMessageBeetweenDateByIdAccount(Long idAccount,
			LocalDateTime minDateLDT, LocalDateTime maxDateLDT) {

		List<SingleMessage> list=Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("SingleMessageService:Id account must not null and empty.");
			
		} else if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("SingleMessageService: Max date must not before min date!");
			
		}else{
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("SingleMessageService: List single account message which create between"
						+ " data load by id account.");
				list = singleMessageDAO.getListSingleMessageBeetweenDateByIdAccount(idAccount, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService: List single account message which create between"
						+ " data load by id account, but list is empty."+ rf);
				
			}catch (DataAccessException da) {
				logger.error("SingleMessageService: Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}

	public List<Account> getListInterlocutorAccountByIdAccount(Long idAccount) {
		
		List<Account> list=Collections.emptyList();
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("SingleMessageService:Id account must not null and empty.");
			
		}else{
			try {
				logger.info("SingleMessageService: List interlocutor account load by id account.");
				list=singleMessageDAO.getListInterlocutorAccountByIdAccount(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService: List interlocutor account load by id account,"
						+ " but list is empty." + rf);
				
			}catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<SingleMessage> getListIntrlocutorSingleMessageBeetweenDateByIdAccount(Long idAccount,
			Long idInterlocutorAccount,LocalDateTime minDateLDT,LocalDateTime maxDateLDT) {
		
		List<SingleMessage> list=Collections.emptyList();
		Date minDateD;
		Date maxDateD;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("SingleMessageService:Id account id  must not null or empty.");
			
		}else if(idInterlocutorAccount.equals(null) || idInterlocutorAccount.equals("")){
			throw new RuntimeException("SingleMessageService:Id account interlocutor must not null or empty.");		
			
		}else if(maxDateLDT.isBefore(minDateLDT)){
			throw new RuntimeException("SingleMessageService: Max date must not before min date!");
			
		}else{
			try {
				minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
				maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
				logger.info("SingleMessageService: List dialog message which create between"
						+ " data load by id account and id interlocutor.");
				list=singleMessageDAO.getListIntrlocutorSingleMessageBeetweenDateByIdAccount(idAccount,
						idInterlocutorAccount, minDateD, maxDateD);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("SingleMessageService:List of single messages load but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("SingleMessageService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
}
