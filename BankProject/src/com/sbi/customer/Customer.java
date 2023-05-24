package com.sbi.customer;

import com.sbi.account.BankAccount;

public class Customer {

	private String customerName;
	private String address;
	private long adharNumber;
	private int pin;

	private BankAccount bankAccount;

	public Customer(String customerName, String address, long adharNumber, int pin, BankAccount bankAccount) {
		super();
		this.customerName = customerName;
		this.address = address;
		this.adharNumber = adharNumber;
		this.bankAccount = bankAccount;
		this.pin = pin;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getAddress() {
		return address;
	}

	public long getAdharNumber() {
		return adharNumber;
	}

	public int getPin() {
		return pin;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}
	

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAdharNumber(long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", address=" + address + ", adharNumber=" + adharNumber
				+ ", pin=" + pin + ", bankAccount=" + bankAccount + "]";
	}


}
