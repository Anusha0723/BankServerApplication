package com.bank.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.application.entity.Transaction;
import com.bank.application.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository repo;

	@Override
	public String add(Transaction transaction) {
		// TODO Auto-generated method stub
		repo.save(transaction);
		return null;
	}

}
