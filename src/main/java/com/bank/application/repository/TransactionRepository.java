package com.bank.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.application.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}
