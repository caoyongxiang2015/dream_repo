package com.env;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		 "classpath*:/application/applicationContext-datasource.xml",
		 "classpath*:/application/applicationContext.xml",
		 "classpath*:/application/applicationContext-aopTx.xml"})
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Test
	public void testBase() {
	}
}
