package com.course.service;

import java.io.FileInputStream;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Account;
import com.course.exception.ActionException;
import com.course.repository.AccountRepository;

@Service
public class AccountService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccountRepository accountRepository;

	// 所有異常都需要 Rollback(預設只有RuntimeException會Rollbackk)
	@Transactional(rollbackFor = {Exception.class}, timeout = 10000)
	public Account transferMoney(String payerAccountNo, String payeeAccountNo, BigDecimal amount) throws Exception {
		Account payerAccount = accountRepository.findByAccountNo(payerAccountNo);
		
		if (payerAccount == null) {
			throw new ActionException("帳號錯誤");
		}
		if (payerAccount.getBalance().compareTo(amount) >= 0) {
			// 餘額充足，可以轉帳
			
			Account payeeAccount = accountRepository.findByAccountNo(payeeAccountNo);
			
			payerAccount.setBalance(payerAccount.getBalance().subtract(amount));
			accountRepository.save(payerAccount);
			
			// 觸發 RuntimeException
			// Integer.parseInt("abc");
			// 強制觸發 Checked Exception
			// FileInputStream fileInputStream = new FileInputStream("non_existent_file.txt");
			// 在有可能出錯的時候，總是會出錯
			payeeAccount.setBalance(payeeAccount.getBalance().add(amount));
			accountRepository.save(payeeAccount);
		} else {
			logger.info("餘額不足：" + payerAccountNo);
			throw new ActionException("餘額不足");
		}
		
		return payerAccount;
	}
	
	/**
	 * 內部方法調用
	 * @param payerAccountNo
	 * @param payeeAccountNo
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	public Account transferMoneyInnerInvoke(String payerAccountNo, String payeeAccountNo, BigDecimal amount) throws Exception {
		Account payerAccount = accountRepository.findByAccountNo(payerAccountNo);
		
		Account payeeAccount = accountRepository.findByAccountNo(payeeAccountNo);
		
		if (payerAccount == null || payeeAccount == null) {
			throw new ActionException("帳號錯誤");
		}
		if (payerAccount.getBalance().compareTo(amount) >= 0) {
			// 內部方法調用，不會觸發交易機制
			innerTransferMethod(payerAccount, payeeAccount, amount);
		} else {
			logger.info("餘額不足：" + payerAccountNo);
			throw new ActionException("餘額不足");
		}
		
		return payerAccount;
	}

	@Transactional
	public Account innerTransferMethod(Account payerAccount, Account payeeAccount, BigDecimal amount) throws Exception {

		payerAccount.setBalance(payerAccount.getBalance().subtract(amount));
		accountRepository.save(payerAccount);

		// 觸發 RuntimeException
		// Integer.parseInt("abc");
		payeeAccount.setBalance(payeeAccount.getBalance().add(amount));
		accountRepository.save(payeeAccount);

		return payerAccount;
	}
	
}
