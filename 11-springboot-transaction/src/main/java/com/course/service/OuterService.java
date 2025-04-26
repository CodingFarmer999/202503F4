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
public class OuterService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccountRepository accountRepository;

    @Autowired
    private InnerService innerService;

    
    /**
     * REQUIRED(預設)：延續使用前一個交易，如果沒有的話就建立一個新的交易
	 * 執行結果：交易一、交易二資料一起 commit、rollback 
     */
	@Transactional(propagation = Propagation.REQUIRED)
	public void required_required(){
		logger.info("========== OuterService REQUIRED start ==========");
		saveAccount();
		innerService.required();
		logger.info("========== OuterService REQUIRED end ==========");
	}
	
	/**
	 * REQUIRES_NEW：建立一個新的交易，如果現存一個交易的話就先暫停，並啟始一個新獨立的交易來執行    	
     * 執行結果：交易一資料於交易二資料commit之後commit
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void required_requiredNew(){
		logger.info("========== OuterService REQUIRED start ==========");
		saveAccount();
		innerService.requiresNew();
		logger.info("========== OuterService REQUIRED end ==========");
	}	
	
	/**
	 * SUPPORTS：被調用者是否有事務，完全依賴於調用者，調用者有事務則有事務，調用者沒事務則沒事務。
	 */
	public void noTransaction_supportsHasException(){
		logger.info("========== OuterService No Transaction start ==========");
		innerService.supportsHasException();
		logger.info("========== OuterService No Transaction end ==========");
	}
	
	@Transactional
	public void hasTransactionHasException_supports(){
		logger.info("========== OuterService Has Transaction start ==========");
		saveAccount();
		innerService.supportsNoException();
		Integer.parseInt("ABC");
		logger.info("========== OuterService Has Transaction end ==========");		
	}
	
	public void noTransaction_notSupportsHasException(){
		logger.info("========== OuterService No Transaction start ==========");
		innerService.notSupportsHasException();
		logger.info("========== OuterService No Transaction end ==========");
	}
	
	@Transactional
	public void hasTransactionHasException_notSupports(){
		logger.info("========== OuterService Has Transaction start ==========");
		saveAccount();
		innerService.notSupportsNoException();
		Integer.parseInt("ABC");
		logger.info("========== OuterService Has Transaction end ==========");		
	}
	
	@Transactional(propagation = Propagation.MANDATORY)
	public void mandatory(){
		logger.info("========== OuterService MANDATORY start ==========");
		saveAccount();
		logger.info("========== OuterService MANDATORY end ==========");
	}
	
	@Transactional
	public void hasTransaction_Never() {
		logger.info("========== OuterService Has Transaction start ==========");
		saveAccount();
		innerService.never();
		logger.info("========== OuterService Has Transaction end ==========");	
	}
	
    public void saveAccount() {
    	Account account = new Account();
    	account.setName("OutterSaveAccount");
    	accountRepository.save(account);
    }
}
