package core;

import bank_utils.Transaction;
import java.time.LocalDate;

public class CurrentAccount extends Account {

	private double overDraftLimit;
	private double overDraftUsed;

	public CurrentAccount(int accountNumber, String accountHolderFirstName, String accountHolderLastName,
			double balance, LocalDate dayOfOpening, double overDraftLimit, double overDraftUsed) {
		super(accountNumber, accountHolderFirstName, accountHolderLastName, dayOfOpening, balance);
		this.overDraftUsed = overDraftUsed;
		this.overDraftLimit = overDraftLimit;
	}

	public CurrentAccount(int accountNumber) {
		super(accountNumber);
	}

	@Override
	public boolean withdraw(double amount) {

		double totalBalance = getBalance() + (overDraftLimit - overDraftUsed);

		if (amount <= totalBalance) {
			if (amount >= getBalance()) {

				double overDraftRequired = amount - getBalance();
				overDraftUsed = overDraftUsed + overDraftRequired;
				setBalance(0);
			} else {
				setBalance(getBalance() - amount);
				System.out.println("Withdrawal successful !!! Remaining balance: " + getBalance());

				transactions.add(new Transaction(getAccountNumber(), " Withdraw ", amount, getBalance()));
				return true;
			}
		} else {
			System.out.println("Withdrawal failed! Overdraft limit exceeded.");
			return false;
		}

		return true;
	}

	@Override
	public void deposit(double amount) {

		if (overDraftUsed > 0) {
			if (amount >= overDraftUsed) {
				amount = amount - overDraftUsed;
				overDraftUsed = 0;
				setBalance(getBalance() + amount);

			} else {
				overDraftUsed = overDraftUsed - amount;
			}

		} else {
			setBalance(getBalance() + amount);
		}

		System.out.println("Deposit successful !!! Current balance: " + getBalance());
		transactions.add(new Transaction(getAccountNumber(), " Deposit ", amount, getBalance()));

	}

	@Override
	public String toString() {
		return " CurrentAccount : " + super.toString() + " overDraftLimit= " + overDraftLimit + ", overDraftUsed= "
				+ overDraftUsed;
	}

	@Override
	public double calculateInterest() {
		System.out.println("Interest is not applicable for Current Accounts.");
		return 0.0;
	}
}
