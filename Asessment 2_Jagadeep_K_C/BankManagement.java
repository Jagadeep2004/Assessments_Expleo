package Assessment;

import java.util.*;

class Customer {
	int id;
	String name;
	char gender;

	Customer(int id, String name, char gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

}

class Account {
	int id;
	Customer customer;
	double balance;

	Account(int id, Customer customer, double balance) {
		this.customer = customer;
		this.id = id;
		this.balance = balance;
	}

	Account(int id, Customer customer) {
		this.customer = customer;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double amount) {
		balance = amount;
	}

	public String getCustomerName() {
		return customer.getName();
	}

	public String toString() {
		return customer.getName() + "(" + id + ") Balance = " + balance;
	}

	public void deposit(double amount) {
		balance += amount;
		setBalance(balance);
	}

	public void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			setBalance(balance);
		} else {
			System.out.println("AMOUNT WITHDRAWN EXCEEDS THE CURRENT BALANCE!");
		}
	}
}

public class BankManagement {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Account_Id: ");
		int a_id = sc.nextInt();
		System.out.println("Enter Customer_Id: ");
		int c_id = sc.nextInt();
		System.out.println("Enter Customer_Name: ");
		String c_name = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Customer_Gender: ");
		char c_gender = sc.next().charAt(0);
		System.out.println("Enter Account_Balance: ");
		double a_balance = sc.nextDouble();

		Customer customer = new Customer(c_id,c_name,c_gender);
		Account account = new Account(a_id, customer, a_balance);

		System.out.println("ACCOUNT DETAILS");
		System.out.println("----------------------");
		System.out.println("ACCOUNT_ID: " + account.getId());
		System.out.println("CUSTOMER_ID: " + customer.getId());
		System.out.println("CUSTOMER_NAME: " + customer.getName());
		System.out.println("CUSTOMER_GENDER: " + customer.getGender());
		System.out.println("ACCOUNT_BALANCE: " + account.getBalance());

		System.out.println();
		while (true) {
			System.out.println();
			System.out.println("PLEASE SELECT ONE OPTION FROM BELOW");
			System.out.println("1. WITHDRAW");
            System.out.println("2. DEPOSIt");
            System.out.println("3. CHECK BALANCE");
            System.out.println("4. Exit");

			int choice = sc.nextInt();
			if (choice == 1) {
				System.out.println("Enter Amount to Withdraw: ");
				double amount = sc.nextDouble();
				account.withdraw(amount);
				System.out.println("Amount Successfully Withdrawn!!!");
			} else if (choice == 2) {
				System.out.println("Enter Amount to Deposit: ");
				double amount = sc.nextDouble();

				account.deposit(amount);
				System.out.println("Amount Deposited Successfully!! ");
			} else if (choice == 3) {
				System.out.println("Current Balance: " + account.getBalance());
			} else if (choice == 4) {
				System.out.println("Exited");
				break;
			}
		}
		sc.close();
	}
}