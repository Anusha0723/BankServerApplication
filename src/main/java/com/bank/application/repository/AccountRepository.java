package com.bank.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.application.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
