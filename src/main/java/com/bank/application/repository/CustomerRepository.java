package com.bank.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.application.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
}
