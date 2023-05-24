package com.sbi.atm;

import com.sbi.customer.Customer;

public interface Atm {

	public Customer withDraw(Customer customer);
	public Customer pinChange(Customer customer);
	public Customer checkBalance(Customer customer);
	
}
