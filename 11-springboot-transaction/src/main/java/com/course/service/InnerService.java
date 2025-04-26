package com.course.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Account;
import com.course.repository.AccountRepository;

@Service
public class InnerService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccountRepository accountRepository;

	@Transactional(propagation = Propagation.REQUIRED)
	public void required(){
		logger.info("========== InnerService REQUIRED start ==========");
		saveAccount();
		logger.info("========== InnerService REQUIRED end ==========");
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void requiresNew(){
		logger.info("========== InnerService REQUIRES_NEW start ==========");
		saveAccount();
		logger.info("========== InnerService REQUIRES_NEW end ==========");		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void supportsHasException(){
		logger.info("========== InnerService SUPPORTS start ==========");
		saveAccount();
		Integer.parseInt("ABC");
		logger.info("========== InnerService SUPPORTS end ==========");
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void supportsNoException(){
		logger.info("========== InnerService SUPPORTS start ==========");
		saveAccount();		
		logger.info("========== InnerService SUPPORTS end ==========");
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void notSupportsHasException(){
		logger.info("========== InnerService NOT_SUPPORTED start ==========");
		saveAccount();
		Integer.parseInt("ABC");
		logger.info("========== InnerService NOT_SUPPORTED end ==========");
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void notSupportsNoException(){
		logger.info("========== InnerService NOT_SUPPORTED start ==========");
		saveAccount();		
		logger.info("========== InnerService NOT_SUPPORTED end ==========");
	}
	
	@Transactional(propagation = Propagation.NEVER)
	public void never() {
		logger.info("========== InnerService NEVER start ==========");
		saveAccount();		
		logger.info("========== InnerService NEVER end ==========");		
	}
    
    public void saveAccount() {
    	Account account = new Account();
    	account.setName("InnerSaveAccount");
    	accountRepository.save(account);
    }
}
