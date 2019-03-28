package com.zhd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHellowordApplicationTests {

	private final static Logger logger = LoggerFactory.getLogger(SpringbootHellowordApplicationTests.class);
	
	@Test
	public void contextLoads() {
		logger.trace("trace级别");
		logger.debug("debug日志级别");
		logger.info("info级别");
		logger.warn("warn日志级别");
		logger.error("error 日志级别");
		
	}

}
