package com.bank.application.service;

import com.bank.application.dto.RegisterRequestDTO;
import com.bank.application.entity.Account;
import com.bank.application.entity.Customer;
import com.bank.application.exception.CustomerNotFoundException;

public interface CustomerService {
	
	String add(RegisterRequestDTO registerRequestDTO);
	
	Customer update(long customerId) throws CustomerNotFoundException;
	
	Account getAccountDetails(long customerId) throws CustomerNotFoundException;
	
	Customer findCustomerByEmail(String email);
	

}
