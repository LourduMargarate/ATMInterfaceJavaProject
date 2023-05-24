package com.sbi.account;

import com.sbi.bank.Bank;

public class BankAccount extends Bank {
	private long accountNumber;
	private String ifscCode;
	private double balance;

	public BankAccount(String bankName, String branchName, int branchCode, long accountNumber, String ifscCode,
			double balance) {
		super(bankName, branchName, branchCode);
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public double getBalance() {
		return balance;
	}

	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + ", balance=" + balance + "]";
	}

}
