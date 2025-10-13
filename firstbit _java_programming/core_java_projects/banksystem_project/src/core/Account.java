package core;
import java.time.LocalDate;
import java.util.ArrayList;

import bank_utils.Transaction;


public abstract class Account{

	private int accountNumber;
	private String accountHolderFirstName;
	private String accountHolderLastName;
	private LocalDate dayOfOpening;
	private double balance;
	public static ArrayList<Transaction> transactions;
	
	static {
		transactions = new ArrayList<>();
	}
	
	public Account(int accountNumber, String accountHolderFirstName,  String accountHolderLastName, LocalDate dayOfOpening, double balance) {
	
		this.accountNumber = accountNumber;
		this.accountHolderFirstName = accountHolderFirstName;
		this.accountHolderLastName = accountHolderLastName;
		this.dayOfOpening = dayOfOpening;
		this.balance = balance;
	}
	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public static ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountHolderFirstName() {
		return accountHolderFirstName;
	}
	public void setAccountHolderFirstName(String accountHolderFirstName) {
		this.accountHolderFirstName = accountHolderFirstName;
	}
	public String getAccountHolderLastName() {
		return accountHolderLastName;
	}
	public void setAccountHolderLastName(String accountHolderLastName) {
		this.accountHolderLastName = accountHolderLastName;
	}
	public LocalDate getDayOfOpening() {
		return dayOfOpening;
	}

	public void setDayOfOpening(LocalDate dayOfOpening) {
		this.dayOfOpening = dayOfOpening;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return " accountNumber= " + accountNumber + ", accountHolderFirstName= " + accountHolderFirstName
				+ ", accountHolderLastName= " + accountHolderLastName +  ", dayOfOpening= " + dayOfOpening + ", balance= " + balance;
	}
	
	public abstract void deposit(double amount) ;
	
	public abstract boolean withdraw(double amount) ;

	public abstract double calculateInterest();

	@Override
	public boolean equals(Object o) {
		if(o instanceof Account) {
			Account newAcc = (Account)o;
			return this.accountNumber == newAcc.accountNumber;
		}
		return false;
	}
	

}
