/**
 * 
 */
package com.dancosoft.socialcommunity.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

	public List<SingleMessage> getListSingleMessageBeetweenDateByIdAccount(
			Long idAccount, LocalDateTime minDateLDT, LocalDateTime maxDateLDT) {

		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
		logger.info("SingleMessageService: List single account message"
				+ " which create between data load by id account.");

		return singleMessageDAO.getListSingleMessageBeetweenDateByIdAccount(
				idAccount, minDateD, maxDateD);
	}

	public List<Account> getListInterlocutorAccountByIdAccount(Long idAccount) {
		logger.info("SingleMessageService: List interlocutor account load by id account.");
		return singleMessageDAO.getListInterlocutorAccountByIdAccount(idAccount);
	}
	
	public List<SingleMessage> getListIntrlocutorSingleMessageBeetweenDateByIdAccount(Long idAccount,
			Long idInterlocutorAccount,LocalDateTime minDateLDT,LocalDateTime maxDateLDT) {
		
		Date minDateD = converter.convertLocalDateTimeToDate(minDateLDT);
		Date maxDateD = converter.convertLocalDateTimeToDate(maxDateLDT);
		logger.info("SingleMessageService: List dialog message which create between"
				+ " data load by id account and id interlocutor.");
		
		return singleMessageDAO.getListIntrlocutorSingleMessageBeetweenDateByIdAccount(
				idAccount, idInterlocutorAccount, minDateD, maxDateD);
	}
}
