package com.sbi.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sbi.account.BankAccount;
import com.sbi.atm.AtmImplementation;
import com.sbi.customer.Customer;

public class MainClass {
	static Scanner scan = new Scanner(System.in);
	static AtmImplementation atm=new AtmImplementation();
	static Customer customer ;
	/* User Login Method*/
	public static List<Customer> loginUser(List<Customer>customerList) {
		String user_request="no";
		int setNumber = 1;
		int userPreference;
		String user_name;
		int pin;
		Boolean notFound = false;

		// ALREADY THE DATA OF THE USER IS PRESENT
		do {
			System.out.println("Enter the name of the user: ");
			user_name = scan.next();
			System.out.println("Enter the pin of the user: ");
			pin = scan.nextInt();
			for (Customer c : customerList) {
				if (user_name.toLowerCase().equals(c.getCustomerName().toLowerCase()) && pin == c.getPin()) {
					//System.out.println("Welcome to SBI ATM****************");
					userOperations(user_name, pin, customerList);
					notFound=false;
					break;
				} else {
					notFound = true;

				}
			}
			if (notFound == true) {
				System.out.println("Provided details are incorrect! Try Login again! ");
				System.out.println("Do you want to login again?[yes or no]");

				user_request = scan.next();
			}
			
		} while (user_request.equals("yes"));
		return customerList;
		
	}
	
	/* Main Method*/
	public static void main(String[] args) {
		int setNumber = 1;
		int userPreference;
		String user_name="";
		int pin;
		Boolean notFound = false;
        //Customer list
		List<Customer> customerList = new ArrayList<Customer>();
		while (setNumber < 2) {

			customerList.add(new Customer("Mary", "15/3 north street,Papanasam", 1287378289, 3243,
					new BankAccount("SBI", "Papanasam", 3223, 1232443243, "IFSC0021", 5000.0)));
			customerList.add(new Customer("Caroline", "50 south street,Kabisthalam", 1677765289, 4353,
					new BankAccount("SBI", "kabisthalam", 3221, 1432443543, "IFSC0043", 6000.0)));
			customerList.add(new Customer("Vimala", "34/2 mela veethi,Kumbakonam", 1290378289, 3421,
					new BankAccount("SBI", "Kumbakonam", 3243, 1243243243, "IFSC0034", 9000.50)));
			customerList.add(new Customer("Mario", "56 vallabai street,Papanasam", 1123378289, 5445,
					new BankAccount("SBI", "Papanasam", 3212, 1238933243, "IFSC0045", 90000.50)));
			customerList.add(new Customer("Nithya", "23/15 west street,Krishnagiri", 1232378289, 9454,
					new BankAccount("SBI", "Krishnagiri", 3233, 1232903456, "IFSC0056", 80000.0)));

			setNumber++;
		}

		System.out.println("**********************WELCOME TO SBI ATM********************");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("--------------------------MENU------------------------------");
		System.out.println("-                       1.LOGIN                            -");
		System.out.println("-                       2.SIGNUP                           -");
		System.out.println("------------------------------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Enter your preferance:");
		userPreference = scan.nextInt();
		switch (userPreference) {
		case 1:
			customerList=loginUser(customerList);
			break;
		case 2:
			System.out.println("Enter customer name: ");
			String customer_name = scan.next();

			System.out.println("Enter your address: ");
			String address = scan.nextLine();
			scan.nextLine();
			System.out.println("Enter your adhar number: ");
			long adhar = scan.nextLong();
			System.out.println("Enter your pin number: ");
			int pin_number = scan.nextInt();
			System.out.println("Enter your account number: ");
			long acc_no = scan.nextLong();
			System.out.println("Enter your IFSC code: ");
			String ifsc_code = scan.next();
			System.out.println("enter the bank name: ");
			String bank_name = scan.next();
			System.out.println("Enter the branch name: ");
			String branch_name = scan.next();
			System.out.println("Enter the branch code: ");
			int branch_code = scan.nextInt();
			customerList.add(new Customer(customer_name, address, adhar, pin_number,
					new BankAccount(bank_name, branch_name, branch_code, acc_no, ifsc_code, 500.0)));

			System.out.println("Account Details added successfully!");
			System.out.println("Do you want to login?[yes/no]");
			String input=scan.next();
			if(input.equals("yes")) {
				customerList=loginUser(customerList);
			}
			else {
				break;
			}
			break;
		default:
			System.out.println("**********************WELCOME TO SBI ATM**********************");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("#####################WELCOME AGAIN########################");
	}

	/*userOperations*/
	
	private static void userOperations(String userName, int pin, List<Customer> customerList) {
		String user_req="";
		do {
		int userInput = 0;
		int withdraw_index = 0;
		System.out.println("*************************WELCOME TO SBI ATM********************");
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("--------------------------OPERATIONS------------------------------");
		System.out.println("-                         1.WITHDRAW                             -");
		System.out.println("-                         2.CHECK BALANCE                        -");
		System.out.println("-                         3.PIN CHANGE                           -");
		System.out.println("------------------------------------------------------------------");

		int found=0;
		for (Customer c : customerList) {
			if (c.getCustomerName().toLowerCase().equals(userName.toLowerCase()) && c.getPin() == pin
					) {

				customer = c;
				withdraw_index = customerList.indexOf(customer);
				
				break;
			}
		}
		
		System.out.println("Enter your preferance operations: ");
		userInput = scan.nextInt();
		switch (userInput) {

		case 1:
			Customer customer_object1 = atm.withDraw(customer);
			customerList.set(withdraw_index, customer_object1);

			break;
		case 2:
			Customer customer_object2 = atm.checkBalance(customer);
			customerList.set(withdraw_index, customer_object2);
			break;
		case 3:
			Customer customer_object3 = atm.pinChange(customer);
			customerList.set(withdraw_index, customer_object3);
			break;

		}
		System.out.println("Do you want to continue your operations?[yes/no]");
		user_req=scan.next();
	}while(user_req.equals("yes"));
	}

}
