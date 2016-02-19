/**
 * @package com.dancosoft.socialcommunity.controller.support.base
 * 
 * Package com.dancosoft.socialcommunity.controller.support.base contain set of classes
 * which use for support controller logic in SocialCommunity project. This project is based
 * on MVC architecture.This class is part of controller in MVC architecture. Controller
 * provides communication between the user and the system: controls user input and uses
 * models and views to implement the necessary response. This package contain class which
 * use for creating base set of method for each account in system. 
 * 
 * Please contact with Zaerko Denis or send letter on zaerko1991@gmail.com if you need
 * to use information or have any questions. 
 */
package com.dancosoft.socialcommunity.controller.support.base;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dancosoft.socialcommunity.controller.support.constants.BlockStatus;
import com.dancosoft.socialcommunity.controller.support.constants.FriendStatus;
import com.dancosoft.socialcommunity.controller.support.constants.StandartGroupName;
import com.dancosoft.socialcommunity.controller.support.constants.ViewStatus;
import com.dancosoft.socialcommunity.dao.support.TimeConverter;
import com.dancosoft.socialcommunity.model.Account;
import com.dancosoft.socialcommunity.model.AccountGroup;
import com.dancosoft.socialcommunity.model.AccountGroupHistory;
import com.dancosoft.socialcommunity.model.GroupMember;

/**
 * <p>The class StandartAccountGroup contain method for creating standart account
 * group for each user account. Class methods usees for crating account groups
 * and account group histories. Each method set field value of creating object
 * and return object(but not save).
 * 
 * 
 * @see slf4j framework
 * @see log4j framework
 * 
 * @version 1.0 12.02.2016
 * @author Zaerko Denis
 */
public class StandartAccountGroup {

	private static final Logger logger = LoggerFactory.getLogger(StandartAccountGroup.class);
	
	/**
	 * Method return standart account group family with public view status,
	 * unblock block status.
	 * 
	 * @type Account
	 * @type AccountGroup
	 * @param account
	 * 
	 * @return AccountGroup
	 */
	public AccountGroup createAccountGroupFamily(Account account){
		logger.info("StandartAccountGroup: create base group family for new user account.");
		AccountGroup accountGroupFamily =new AccountGroup();
		accountGroupFamily.setGroupName(StandartGroupName.MyFamily.toString());
		accountGroupFamily.setViewStatus(ViewStatus.PUBLIC.toString());
		accountGroupFamily.setAccountGroupBlockStatus(BlockStatus.UNBLOCK.toString());
		accountGroupFamily.setAccount(account);
		
		return accountGroupFamily;
	}
	
	/**
	 * Method return history of standart account group family.
	 * 
	 * @type AccountGroup
	 * @type AccountGroupHistory
	 * @param accountGroup
	 * 
	 * @return AccountGroupHistory
	 */
	public AccountGroupHistory createAccountGroupHistoryFamily(AccountGroup accountGroup){
		
		TimeConverter converter =new TimeConverter();
		logger.info("StandartAccountGroup: create history of base group family for new user account.");
		AccountGroupHistory accountGroupHistoryFamily =new AccountGroupHistory();
		accountGroupHistoryFamily.setDateCreateGroup(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistoryFamily.setLastVisit(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistoryFamily.setAccountGroup(accountGroup);
		
		return accountGroupHistoryFamily;
	}
	
	/**
	 * Method return standart account group friend with public view status,
	 * unblock block status.
	 * 
	 * @type Account
	 * @type AccountGroup
	 * @param account
	 * 
	 * @return AccountGroup
	 */
	public AccountGroup createAccountGroupFriend(Account account){	
		logger.info("StandartAccountGroup: create base group friend for new user account.");
		AccountGroup accountGroupFriend =new AccountGroup();
		accountGroupFriend.setGroupName(StandartGroupName.MyFriend.toString());
		accountGroupFriend.setViewStatus(ViewStatus.PUBLIC.toString());
		accountGroupFriend.setAccountGroupBlockStatus(BlockStatus.UNBLOCK.toString());
		accountGroupFriend.setAccount(account);
		
		return accountGroupFriend;
	}
	
	/**
	 * Method return history of standart account group friend.
	 * 
	 * @type AccountGroup
	 * @type AccountGroupHistory
	 * @param accountGroup
	 * 
	 * @return AccountGroupHistory
	 */
	public AccountGroupHistory createAccountGroupHistoryFriend(AccountGroup accountGroup){
		
		TimeConverter converter =new TimeConverter();
		
		logger.info("StandartAccountGroup: create history of base group friend for new user account.");
		AccountGroupHistory accountGroupHistoryFriend =new AccountGroupHistory();
		accountGroupHistoryFriend.setDateCreateGroup(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistoryFriend.setLastVisit(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistoryFriend.setAccountGroup(accountGroup);
		
		return accountGroupHistoryFriend;
	}
	
	/**
	 * Method return standart account group work with public view status,
	 * unblock block status.
	 * 
	 * @type Account
	 * @type AccountGroup
	 * @param account
	 * 
	 * @return AccountGroup
	 */
	public AccountGroup createAccountGroupWork(Account account){
		logger.info("StandartAccountGroup: create base group work for new user account.");
		AccountGroup accountGroupWork =new AccountGroup();
		accountGroupWork.setGroupName(StandartGroupName.MyWork.toString());
		accountGroupWork.setViewStatus(ViewStatus.PUBLIC.toString());
		accountGroupWork.setAccountGroupBlockStatus(BlockStatus.UNBLOCK.toString());
		accountGroupWork.setAccount(account);
		
		return accountGroupWork;
	}
	
	/**
	 * Method return history of standart account group work.
	 * 
	 * @type AccountGroup
	 * @type AccountGroupHistory
	 * @param accountGroup
	 * 
	 * @return AccountGroupHistory
	 */
	public AccountGroupHistory createAccountGroupHistoryWork(AccountGroup accountGroup){
		
		TimeConverter converter =new TimeConverter();
		
		logger.info("StandartAccountGroup: create history of base group work for new user account.");
		AccountGroupHistory accountGroupHistoryWork =new AccountGroupHistory();
		accountGroupHistoryWork.setDateCreateGroup(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistoryWork.setLastVisit(converter.convertLocalDateTimeToDate(LocalDateTime.now()));
		accountGroupHistoryWork.setAccountGroup(accountGroup);
		
		return accountGroupHistoryWork;
	}
	
	/**
	 * Method return group member for each standart group.Add youself to each
	 * standart group as member of this group.
	 * 
	 * @type AccountGroup
	 * @type Account
	 * @type GroupMember 
	 * @param accountGroup
	 * @param account
	 * 
	 * @return GroupMember
	 */
	public GroupMember createGroupMemberForGroup(AccountGroup accountGroup,Account account){
		logger.info("StandartAccountGroup: Add user to created group.");
		GroupMember groupMember= new GroupMember();
		groupMember.setAccountGroup(accountGroup);
		groupMember.setGroupMemberStatus(FriendStatus.FRIEND.toString());
		groupMember.setMemberAccount(account);
	
		return groupMember;
	}
	
	
}
