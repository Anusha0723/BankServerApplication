package com.bank.application.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Account {

	@Id
	private long accountNumber;
	
	@NotEmpty
	private String accountType;
	
	private int totalLinkedCards;
	
	@OneToMany
	private List<Transaction> transactions;
	
	@NotEmpty
	private String branch;
	
	@NotEmpty
	private String ifsc;
	
	private double balance;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getTotalLinkedCards() {
		return totalLinkedCards;
	}

	public void setTotalLinkedCards(int totalLinkedCards) {
		this.totalLinkedCards = totalLinkedCards;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(long accountNumber, @NotEmpty String accountType, int totalLinkedCards,
			List<Transaction> transactions, @NotEmpty String branch, @NotEmpty String ifsc) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.totalLinkedCards = totalLinkedCards;
		this.transactions = transactions;
		this.branch = branch;
		this.ifsc = ifsc;
	}

	public Account() {
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", totalLinkedCards="
				+ totalLinkedCards + ", transactions=" + transactions + ", branch=" + branch + ", ifsc=" + ifsc + ", balance=" + balance + "]";
	}
	
	
}
