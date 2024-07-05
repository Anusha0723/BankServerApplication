package com.bank.application.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long transactionId;
	
	@NotEmpty
	private String transactionSummary;
	
	@NotNull
	private LocalDateTime dateOfTransaction;
	
	@NotNull
	private String transactionType;
	
	@NotNull
	private double amount;
	
	@NotNull
	private double closingBalance;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public Transaction(@NotEmpty String transactionSummary, @NotNull LocalDateTime dateOfTransaction,
			@NotNull String transactionType, @NotNull double amount, @NotNull double closingBalance) {
		this.transactionSummary = transactionSummary;
		this.dateOfTransaction = dateOfTransaction;
		this.transactionType = transactionType;
		this.amount = amount;
		this.closingBalance = closingBalance;
	}

	public Transaction() {
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionSummary=" + transactionSummary
				+ ", dateOfTransaction=" + dateOfTransaction + ", transactionType=" + transactionType + ", amount="
				+ amount + ", closingBalance=" + closingBalance + "]";
	} 

}
