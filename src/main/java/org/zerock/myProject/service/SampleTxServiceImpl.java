package org.zerock.myProject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.myProject.aop.LogAdvice;
import org.zerock.myProject.mapper.Sample1Mapper;
import org.zerock.myProject.mapper.Sample2Mapper;

import lombok.Setter;

@Transactional
@Service
public class SampleTxServiceImpl implements SampleTxService{
	
	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	
	@Setter(onMethod_ = {@Autowired} )
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_ = {@Autowired} )
	private Sample2Mapper mapper2;
	
	@Override
	public void addData(String value) {
		
		log.info("mapper1.....................");
		mapper1.insertCol1(value);
		
		log.info("mapper2.....................");
		mapper2.insertCol2(value);
		
		log.info("end.....................");
		
	}

}
