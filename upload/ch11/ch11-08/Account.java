// Java Programming Assingment 11-8
// Implement class Account
// written by 121220130

import java.util.Date;

public class Account {
	private int id = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;

	public Account() {
		this.dateCreated = new Date();
	}

	public Account(int id, double balance) {
		this();
		this.id = id;
		this.balance = (balance >= 0) ? balance : 0;
	}

	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		if (balance >= 0)
			this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double rate) {
		if (rate >= 0 && rate < 100)
			this.annualInterestRate = rate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}

	public void withdraw(double amount) {
		if (balance >= amount)
			balance -= amount;
		else
			System.out.println("your balance is insufficient to withdraw such an amount");
	}
	
	public void deposit(double amount) {
		balance += amount;
	}

	public static void main( String[] args ) {
		System.out.println("**** Class Account: testing ****");
		Account test = new Account(1122, 20000);
		test.setAnnualInterestRate(4.5);
		test.withdraw(2500);
		test.deposit(3000);
		System.out.println(test.getBalance() + " " + test.getMonthlyInterestRate() + " " + test.getDateCreated().toString());
	}
}
