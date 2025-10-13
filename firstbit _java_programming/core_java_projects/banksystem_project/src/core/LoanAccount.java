package core;

import java.time.LocalDate;

import bank_utils.Transaction;

public class LoanAccount extends Account {

	private static double interestRate;
	private double totalRepaid; // track total amount repaid by customer

	static {
		interestRate = 8.5;
	}

	public LoanAccount(int accountNumber, String accountHolderFirstName, String accountHolderLastName,
			double loanAmount, LocalDate dayOfOpening) {
		super(accountNumber, accountHolderFirstName, accountHolderLastName, dayOfOpening, -loanAmount);
																									
		this.totalRepaid = 0;
	}

	@Override
	public void deposit(double amount) {
	
			double newBalance = getBalance() + amount;
			totalRepaid += amount;
			setBalance(newBalance);
			System.out.println("Payment of " + amount + " successful !! Remaining loan : " + (-getBalance()));
			transactions.add(new Transaction(getAccountNumber(), " Loan ", amount, getBalance()));

	}

	@Override
	public boolean withdraw(double amount) {
		System.out.println("Withdrawals are not allowed from a Loan Account ");
		return false;
	}

	@Override
	public double calculateInterest() {
		double interest = (-getBalance()) * (interestRate / 100);
		System.out.println("Interest on loan : " + interest);
		return interest;
	}

	public double getTotalRepaid() {
		return totalRepaid;
	}

	public static double getInterestRate() {
		return interestRate;
	}

	@Override
	public String toString() {
		return "LoanAccount " + super.toString() + " totalRepaid= " + totalRepaid;
	}
}