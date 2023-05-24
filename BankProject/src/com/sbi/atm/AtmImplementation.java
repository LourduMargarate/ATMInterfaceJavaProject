package com.sbi.atm;

import java.util.Scanner;

import com.sbi.customer.Customer;

public class AtmImplementation implements Atm {
	static Scanner scan = new Scanner(System.in);

	public Customer withDraw(Customer customer) {
		System.out.println("Enter the amount to withdraw: ");
		double amount = scan.nextDouble();
		if (amount < customer.getBankAccount().getBalance()) {
			double cutomer_balance = customer.getBankAccount().getBalance();
			double new_balance = cutomer_balance - amount;
			customer.getBankAccount().setBalance(new_balance);

		} else {
			System.out.println("---The amount entered by you is higher than your available balance---");
			System.out.println("---So try to enter the amount lesser than your available balance---");
		}
		return customer;
	}

	public Customer pinChange(Customer customer) {
		int pin;
		int oldpin = customer.getPin();
		int useroldpin;
		System.out.println("Enter your old pin");
		useroldpin = scan.nextInt();
		if (oldpin == useroldpin) {
			System.out.println("Enter the new pin to reset your old pin: ");
			pin = scan.nextInt();
			customer.setPin(pin);
			System.out.println("Your pin is changed successully!");
		} else {
			System.out.println("your old pin is wrong!");
		}
		return customer;

	}

	public Customer checkBalance(Customer customer) {
		String option = "";
		System.out.println("Do you want to check the bank balance:[yes/no] ");
		option = scan.next();
		if (option.equals("yes")) {
			System.out.println("Your bank balance is: " + customer.getBankAccount().getBalance());
		}
		return customer;

	}
}
