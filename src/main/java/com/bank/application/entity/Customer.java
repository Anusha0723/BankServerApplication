package com.bank.application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	
	@NotEmpty
	@Size(min = 4,max=30, message = "Name should contain at least 4 characters.")
	private String customerName;
	
	@NotNull
	private long phoneNumber;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotNull
	@OneToOne
	private Account accountNumber;
	
	@NotEmpty
	private String password;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Account accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(@NotEmpty @Size(min = 4, max = 30, message = "Name should contain at least 4 characters.") String customerName,
			@NotNull long phoneNumber, @NotEmpty @Email String email, @NotEmpty String password, Account accountNumber) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", accountNumber=" + accountNumber + ", password=" + password + "]";
	}

	public Customer() {
	}
	
}
