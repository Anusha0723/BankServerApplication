package com.bank.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.application.entity.Account;
import com.bank.application.exception.CustomerNotFoundException;
import com.bank.application.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public String add(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
		return "Account created successfully";
	}

	@Override
	public Account update(long accountId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountDetails(long customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
