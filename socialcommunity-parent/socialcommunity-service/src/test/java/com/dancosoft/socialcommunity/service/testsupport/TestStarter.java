package com.dancosoft.socialcommunity.service.testsupport;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:*service-config.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public abstract class TestStarter {
}
