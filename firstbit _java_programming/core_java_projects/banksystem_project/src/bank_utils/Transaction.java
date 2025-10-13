package bank_utils;

import java.time.LocalDateTime;

import static core.Bank.*;

public class Transaction {

	private int transactionId;
	private int accountNumber;
	private String transactionType;
	private double amount;
	private LocalDateTime transactionDate;
	private double balanceAfterTransaction;

	private static int idCounter;

	static {
		idCounter = 0;
	}

	// Constructor
	public Transaction(int accountNumber, String transactionType, double amount, double balanceAfterTransaction) {
		this.transactionId = ++idCounter;
		this.accountNumber = accountNumber;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = LocalDateTime.now();
		this.balanceAfterTransaction = balanceAfterTransaction;
	}

	public Transaction(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	// Getters
	public int getTransactionId() {
		return transactionId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}

	@Override
	public String toString() {

		String formattedDate = transactionDate.format(fdt);
		return "Transaction : transactionId= " + transactionId + ", accountNumber= " + accountNumber
				+ ", transactionType= " + transactionType + ", amount= " + amount + ", transactionDate= "
				+ formattedDate + ", balanceAfterTransaction= " + balanceAfterTransaction;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Transaction) {
			Transaction newAcc = (Transaction) o;
			return this.accountNumber == newAcc.accountNumber;
		}
		return false;
	}

}