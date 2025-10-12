package core;

import java.time.LocalDate;

public class SalaryAccount extends SavingAccount {

	private LocalDate lastTransactionDate;
	private boolean isFrozen;

	public SalaryAccount(int accountNumber, String accountHolderFirstName, String accountHolderLastName, double balance,
			LocalDate openingDate, LocalDate lastTransactionDate) {

		super(accountNumber, accountHolderFirstName, accountHolderLastName, balance, openingDate);
		this.lastTransactionDate = lastTransactionDate;
		this.isFrozen = false;
	}

	public void freezeIfInactive() {
		LocalDate today = LocalDate.now();
		if (lastTransactionDate != null && lastTransactionDate.isBefore(today.minusMonths(2))) {
			isFrozen = true;
			notifyAccountHolder();
		}
	}

	private void notifyAccountHolder() {
		System.out.println("Notification: " + getAccountHolderFirstName() + " " + getAccountHolderLastName()
				+ ", your salary account " + getAccountNumber() + " has been frozen due to inactivity.");
	}

	public LocalDate getLastTransactionDate() {
		return lastTransactionDate;
	}

	public void setLastTransactionDate(LocalDate lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	public boolean isFrozen() {
		return isFrozen;
	}

	@Override
	public String toString() {
		return "SalaryAccount : accountNumber= " + getAccountNumber() + ", accountHolderFirstName= "
				+ getAccountHolderFirstName() + ", accountHolderLastName= " + getAccountHolderLastName()
				+ ", dayOfOpening= " + getDayOfOpening() + ", lastTransactionDate= " + lastTransactionDate
				+ ", isFrozen= " + isFrozen;
	}
}