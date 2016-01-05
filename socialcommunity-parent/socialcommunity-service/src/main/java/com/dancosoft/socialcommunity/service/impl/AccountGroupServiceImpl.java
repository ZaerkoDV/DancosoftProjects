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

import com.dancosoft.socialcommunity.dao.AccountGroupDAO;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.service.AccountGroupService;

/**
 * @author Zaerko_DV
 *
 */
@Service(value="accountGroupService")
public class AccountGroupServiceImpl extends CommonEntityServiceImpl implements AccountGroupService {

	private static final Logger logger = LoggerFactory.getLogger(AccountGroupServiceImpl.class);
	
	@Autowired
	@Qualifier(value="accountGroupDAO")
	private AccountGroupDAO accountGroupDAO;

	public void setAccountGroupDAO(AccountGroupDAO accountGroupDAO) {
		this.accountGroupDAO = accountGroupDAO;
	}
	
	public Boolean isBlockAccountGroup(Long idAccountGroup) {
		
		Boolean isBlockAccountGroup=null;
		if (idAccountGroup.equals(null) || idAccountGroup.equals("")) {
			throw new RuntimeException("AccountGroupService:Id account group must not null.");
			
		} else{
			try {
				logger.info("AccountGroupService:Account group block status load by id account group.");
				isBlockAccountGroup=accountGroupDAO.isBlockAccountGroup(idAccountGroup);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService: Account group with id "+ idAccountGroup+" not exist." + rf);
						
			} catch (DataAccessException da) {
				logger.error("AccountGroupService: Exeption connect with data base or other error. "+da);
			}
		}
		return isBlockAccountGroup;
	}
	
	public String getAccountGroupBlockStatus(Long idAccount) {
		
		String blokStatus=null;
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountGroupService:Id account group must not null.");
	
		} else{
			try {
				logger.info("AccountGroupService:Account group status is load.");
				blokStatus=accountGroupDAO.getAccountGroupBlockStatus(idAccount);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService: Block status for account group with id "+ idAccount+" not exist." + rf);
						
			} catch (DataAccessException da) {
				logger.error("AccountGroupService: Exeption connect with data base or other error. "+da);
			}
		}
		return blokStatus;
	}
	
	public List<AccountGroup> getListAccountGroupWithBlockStatusByIdAccount(Long idAccount,String blockStatus) {
		
		List<AccountGroup> list=Collections.emptyList();
		if (idAccount.equals(null) || idAccount.equals("")) {
			throw new RuntimeException("AccountGroupService:Id account must not null.");
	
		} else{
			try {
				logger.info("AccountGroupService:List AccountGroup with block status load by id account");
				list=accountGroupDAO.getListAccountGroupWithBlockStatusByIdAccount(idAccount, blockStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService: List of account group not load becouse list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}
		}
		return list;
	}
	
	public List<AccountGroup> searchAccountGroupByGroupNameAccountName(String groupName, String accountName) {
		
		List<AccountGroup> list=Collections.emptyList();
		if ((groupName.equals(null) || groupName.equals("")) && (accountName.equals(null) || accountName.equals(""))) {
			throw new RuntimeException("AccountGroupService:Account group or account"
					+ " name must not equals null at the same time.");
		}else{
			try {
				logger.info("AccountGroupService:List AccountGroup load by groupName and accountName.");
				list=accountGroupDAO.searchAccountGroupByGroupNameAccountName(groupName, accountName);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService:Operation search account group by group name"
						+ " and by account name completed but list is empty=" + rf);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}		
		}
		return list;
	}
	
	public List<AccountGroup> getListAccountGroupWithViewStatusByIdAccount(Long idAccount,String viewStatus){
		
		List<AccountGroup> list=Collections.emptyList();
		if ((idAccount.equals(null) || idAccount.equals("")) || (viewStatus.equals(null) || viewStatus.equals(""))) {
			throw new RuntimeException("AccountGroupService:Account group id and view status must not null or empty.");
			
		}else{	
			try {
				logger.info("AccountGroupService:List AccountGroup with view status load by id account");
				list=accountGroupDAO.getListAccountGroupWithViewStatusByIdAccount(idAccount, viewStatus);
				
			} catch (DataRetrievalFailureException rf) {
				logger.warn("AccountGroupService:Account group with id="+idAccount+""
						+ " and status "+viewStatus+"not exists" + rf);
				
			}catch (DataAccessException da) {
				logger.error("AccountGroupService:Exeption connect with data base or other error= "+da);
			}	
		}
		return list;
	}
}
