package core;

import java.time.LocalDate;

import bank_utils.Transaction;

public class SavingAccount extends Account {

	public static double minimumBalance;
	private static double interestRate;

	static {
		minimumBalance = 10000;
		interestRate = 3.5;
	}

	public SavingAccount(int accountNumber, String accountHolderFirstName, String accountHolderLastName, double balance,
			LocalDate dayOfOpening) {
		super(accountNumber, accountHolderFirstName, accountHolderLastName, dayOfOpening, balance);
	}

	@Override
	public double calculateInterest() {
		double interest = getBalance() * (interestRate / 100);
		setBalance(getBalance() + interest);
		System.out.println("Interest of " + interest + " added. New balance: " + getBalance());
		return interest;
	}

	public static double getMinimumBalance() {
		return minimumBalance;
	}

	public static double getInterestRate() {
		return interestRate;
	}

	@Override
	public boolean withdraw(double amount) {
		double newBalance = getBalance() - amount;
		if (newBalance >= minimumBalance) {
			setBalance(newBalance);
			System.out.println("Withdrawal of " + amount + " successful... New balance : " + getBalance());
			transactions.add(new Transaction(getAccountNumber(), " Withdraw ", amount, getBalance()));
			return true;
		} else {
			System.out.println("Withdrawal failed! Minimum balance of " + minimumBalance + " must be maintained.");
			return false;
		}
	}

	@Override
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
		transactions.add(new Transaction(getAccountNumber(), " Deposit ", amount, getBalance()));
		System.out.println("Deposit successful !!! Current balance: " + getBalance());
	}

	@Override
	public String toString() {
		return "SavingAccount " + super.toString();
	}
}
