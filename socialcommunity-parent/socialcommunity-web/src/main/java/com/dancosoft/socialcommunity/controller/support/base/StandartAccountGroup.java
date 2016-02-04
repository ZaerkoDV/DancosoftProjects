package com.dancosoft.socialcommunity.controller.support.base;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dancosoft.socialcommunity.controller.support.constants.BlockStatus;
import com.dancosoft.socialcommunity.controller.support.constants.ViewStatus;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;

public class StandartAccountGroup {

	private static final Logger logger = LoggerFactory.getLogger(StandartAccountGroup.class);
	
	private enum GroupName{
		MyFamily,
		MyFriend,
		MyWork
	}
	
	public AccountGroup createAccountGroupFamily(Account account){
		logger.info("StandartAccountGroup: create base group family for new user account.");
		AccountGroup accountGroupFamily =new AccountGroup();
		accountGroupFamily.setGroupName(GroupName.MyFamily.toString());
		accountGroupFamily.setViewStatus(ViewStatus.PUBLIC.toString());
		accountGroupFamily.setAccountGroupBlockStatus(BlockStatus.UNBLOCK.toString());
		accountGroupFamily.setAccount(account);
		
		return accountGroupFamily;
	}
	
	public AccountGroupHistory createAccountGroupHistoryFamily(AccountGroup accountGroup){
		logger.info("StandartAccountGroup: create history of base group family for new user account.");
		AccountGroupHistory accountGroupHistoryFamily =new AccountGroupHistory();
		accountGroupHistoryFamily.setDateCreateGroup(LocalDateTime.now());
		accountGroupHistoryFamily.setLastVisit(LocalDateTime.now());
		accountGroupHistoryFamily.setAccountGroup(accountGroup);
		
		return accountGroupHistoryFamily;
	}
	
	public AccountGroup createAccountGroupFriend(Account account){	
		logger.info("StandartAccountGroup: create base group friend for new user account.");
		AccountGroup accountGroupFriend =new AccountGroup();
		accountGroupFriend.setGroupName(GroupName.MyFriend.toString());
		accountGroupFriend.setViewStatus(ViewStatus.PUBLIC.toString());
		accountGroupFriend.setAccountGroupBlockStatus(BlockStatus.UNBLOCK.toString());
		accountGroupFriend.setAccount(account);
		
		return accountGroupFriend;
	}
	
	public AccountGroupHistory createAccountGroupHistoryFriend(AccountGroup accountGroup){
		logger.info("StandartAccountGroup: create history of base group friend for new user account.");
		AccountGroupHistory accountGroupHistoryFriend =new AccountGroupHistory();
		accountGroupHistoryFriend.setDateCreateGroup(LocalDateTime.now());
		accountGroupHistoryFriend.setLastVisit(LocalDateTime.now());
		accountGroupHistoryFriend.setAccountGroup(accountGroup);
		
		return accountGroupHistoryFriend;
	}
	
	public AccountGroup createAccountGroupWork(Account account){
		logger.info("StandartAccountGroup: create base group work for new user account.");
		AccountGroup accountGroupWork =new AccountGroup();
		accountGroupWork.setGroupName(GroupName.MyWork.toString());
		accountGroupWork.setViewStatus(ViewStatus.PUBLIC.toString());
		accountGroupWork.setAccountGroupBlockStatus(BlockStatus.UNBLOCK.toString());
		accountGroupWork.setAccount(account);
		
		return accountGroupWork;
	}
	
	public AccountGroupHistory createAccountGroupHistoryWork(AccountGroup accountGroup){
		logger.info("StandartAccountGroup: create history of base group work for new user account.");
		AccountGroupHistory accountGroupHistoryWork =new AccountGroupHistory();
		accountGroupHistoryWork.setDateCreateGroup(LocalDateTime.now());
		accountGroupHistoryWork.setLastVisit(LocalDateTime.now());
		accountGroupHistoryWork.setAccountGroup(accountGroup);
		
		return accountGroupHistoryWork;
	}
}
