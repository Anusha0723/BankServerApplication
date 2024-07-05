package com.bank.application.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.application.dto.RegisterRequestDTO;
import com.bank.application.entity.Account;
import com.bank.application.entity.Customer;
import com.bank.application.exception.CustomerNotFoundException;
import com.bank.application.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountService accountService;
	
	public Customer findCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	@Override
	public String add(RegisterRequestDTO registerDTO) {
		// TODO Auto-generated method stub
		long min = 1_000_000_000_000L;
		long max = 9_999_999_999_999L;
		Random random = new Random();
		Account customerAccount = new Account((min + ((long) (random.nextDouble() * (max - min)))), "Savings", 0, null, "branch1", "1234567");
		accountService.add(customerAccount);
		Customer customer = new Customer(registerDTO.getName(), registerDTO.getPhone(), registerDTO.getEmail(), registerDTO.getPassword(), customerAccount);
		customerRepository.save(customer);
		return "Account created successfully";
	}

	@Override
	public Customer update(long customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountDetails(long customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
