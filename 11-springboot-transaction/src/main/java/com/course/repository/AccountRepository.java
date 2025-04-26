package com.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Account findByAccountNo(String accountNo);
}
