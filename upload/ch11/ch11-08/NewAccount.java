// Java Programming Assignment 11-8
// Inherits class Account and add more features
// Written by 121220130

import java.util.*;

public class NewAccount extends Account {
	private String name;
	private ArrayList<Transaction> transactions;

	public NewAccount(String name, int id, double balance) {
		super(id, balance);
		this.name = name;
		transactions = new ArrayList<Transaction>();
	}

	public String getName() {
		return name;
	}

	@Override public void withdraw(double amount)  {
		super.withdraw(amount);
		transactions.add(
			new Transaction('W', amount, getBalance(), "Withdraw"));
	}

	@Override public void deposit(double amount) {
		super.deposit(amount);
		transactions.add(
			new Transaction('D', amount, getBalance(), "Deposit"));
	}

	public String[] getTransactionInfo() {
		String[] info = new String[transactions.size()];
		for (int i = 0; i < info.length; ++i) {
			info[i] = transactions.get(i).toString();
		}
		return info;
	}

	public static void main( String[] args ) {
		NewAccount test = new NewAccount("George", 1122, 1000);
		test.deposit(30);
		test.deposit(40);
		test.deposit(50);
		test.withdraw(5);
		test.withdraw(4);
		test.withdraw(2);
		System.out.println("Account Name:    " + test.getName());
		System.out.println("Account Id:      " + test.getID());
		System.out.println("Accoutn Balance: " + test.getBalance());
		System.out.println("Transaction Records: ");
		String [] transactionInfo = test.getTransactionInfo();
		for (int i = 0; i < transactionInfo.length; ++i) {
			System.out.println(" * " + transactionInfo[i]);
		}
	}
}
