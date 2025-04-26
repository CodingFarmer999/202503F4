package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.OuterService;

@RestController
public class PropagationContoller {

	@Autowired
	private OuterService outerService;
	
	@PostMapping("/requiredPropagation")
	public void requiredPropagation()  {
		outerService.required_required();
	}
	
	@PostMapping("/requiresNewPropagation")
	public void requiresNewPropagation()  {
		outerService.required_requiredNew();
	}
	
	@PostMapping("/supportsPropagation")
	public void supportsopagation()  {
		outerService.required_requiredNew();
	}
	
	@PostMapping(value = "/propagationSupports")
	public void propagationSupports(){
		
		// SUPPORTS：被調用者是否有事務，完全依賴於調用者，調用者有事務則有事務，調用者沒事務則沒事務。
		
		// 情境一：被調用者拋出異常的情況下，如果仍能查詢到數據，說明事務沒有回滾，說明被調用者沒有事務
		outerService.noTransaction_supportsHasException();
		
		// 情境二：調用者拋出異常情況下，結果查不到數據，說明兩個方法是在同一個事務中
		// firstService.hasTransactionHasException_supports();
		
	}

	@PostMapping(value = "/propagationNotSupports")
	public void propagationNotSupports(){
		
		// NOT_SUPPORTED：無論調用者是否有事務，被調用者都不以事務的方法運行
		
		// 情境一：被調用者都不會有事務，那麼在拋異常之後能查到相應的數據
		outerService.noTransaction_notSupportsHasException();
		
		// 情境二：在調用者有事務的情況下，被調用者也會在無事務環境下運行，所以依然能查到數據
		// outerService.hasTransactionHasException_notSupports();

	}

	@PostMapping(value = "/propagationMandatory")
	public void propagationMandatory(){
		
		// MANDATORY：方法必須在一個現存的交易中進行，否則丟出例外		
		// org.springframework.transaction.IllegalTransactionStateException:
		// No existing transaction found for transaction marked with propagation 'mandatory'
		outerService.mandatory();

	}
	
	@PostMapping(value = "/propagationNever")
	public void propagationNever(){
		
		// NEVER：指被調用者不應在事務交易中進行，如果有的話就丟出例外
		// org.springframework.transaction.IllegalTransactionStateException:
		// Existing transaction found for transaction marked with propagation 'never' 
		outerService.hasTransaction_Never();
		
	}
}
