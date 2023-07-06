package org.zerock.myProject.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.zerock.myProject.aop.LogAdvice;


@SpringBootTest
public class SampleTxServiceTests {

	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	
	@Autowired
	private SampleTxService service;
	
	@Test
	public void testLong() {
		
		String str = "Starry\r\n" +
					 "Starry night\r\n" +
				     "Paint your palette blue and grey\r\n" +
					 "Look out on a summer's day";
		
		log.info(String.valueOf(str.getBytes().length));;
		
		service.addData(str);
	}
}
