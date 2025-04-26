package com.course.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.Account;
import com.course.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("/transfer")
	public ResponseEntity<Account> transferMoney(@RequestParam String payerAccountNo, @RequestParam String payeeAccountNo, @RequestParam String amountStr) throws Exception {
		BigDecimal amount = new BigDecimal(amountStr);
		Account payerAccount = accountService.transferMoney(payerAccountNo, payeeAccountNo, amount);
		return ResponseEntity.ok(payerAccount);
	}
	
	@PostMapping("/transferMoneyInnerInvoke")
	public ResponseEntity<Account> transferMoneyInnerInvoke(@RequestParam String payerAccountNo, @RequestParam String payeeAccountNo, @RequestParam String amountStr) throws Exception {
		BigDecimal amount = new BigDecimal(amountStr);
		Account payerAccount = accountService.transferMoneyInnerInvoke(payerAccountNo, payeeAccountNo, amount);
		return ResponseEntity.ok(payerAccount);
	}

}
