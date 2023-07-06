package org.zerock.myProject.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.myProject.aop.LogAdvice;

@SpringBootTest
public class SampleServiceTests {

	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	  @Autowired
	  private SampleService service;
	  
	  
	  @Test
	  public void testClass() {
	    
	    log.info(String.valueOf(service));
	    log.info(service.getClass().getName());    
	    
	  } 
	  
	  @Test
	  public void testAdd() throws Exception{
		  
		  log.info(String.valueOf(service.doAdd("123", "456")));
	  }
	  
	  @Test
	  public void testAddError() throws Exception {
		  
		  log.info(String.valueOf(service.doAdd("123", "ABC")));
	  }
	  

}
