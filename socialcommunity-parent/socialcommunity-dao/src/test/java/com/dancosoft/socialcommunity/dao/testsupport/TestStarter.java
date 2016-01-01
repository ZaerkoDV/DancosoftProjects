/**
 * 
 */
package com.dancosoft.socialcommunity.dao.testsupport;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * @author Zaerko_DV
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:*dao-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public abstract class TestStarter {
}
