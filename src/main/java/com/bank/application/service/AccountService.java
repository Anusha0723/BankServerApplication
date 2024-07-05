package com.bank.application.service;

import com.bank.application.entity.Account;
import com.bank.application.exception.CustomerNotFoundException;

public interface AccountService {

	String add(Account account);
	
	Account update(long accountId) throws CustomerNotFoundException;
	
	Account getAccountDetails(long customerId) throws CustomerNotFoundException;
}
