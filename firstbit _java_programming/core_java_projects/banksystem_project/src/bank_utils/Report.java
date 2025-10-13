package bank_utils;

import core.*;

import java.util.ArrayList;

public class Report {

	private ArrayList<Account> accounts;

	public Report(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void displayAllAccounts() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts found !!!");
			return;
		}
		System.out.println("\nAccount Details");
		for (Account acc : accounts) {
			System.out.println(acc);
		}
	}
	
	public void displaySpecificAccount(int accNum , Report report) {
		
		Account acc = report.searchAccount(accNum);
		
		if(acc != null) {
			System.out.println(acc);
		}else {
			System.out.println("Account Not Found !!!");
		}
	}

	public void displayInterestReport() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts found !!!");
			return;
		}
		System.out.println("\nInterest Report");
		for (Account acc : accounts) {
			double interest = acc.calculateInterest();
			System.out.println("Account No : " + acc.getAccountNumber() + "  Holder : " + acc.getAccountHolderFirstName() +" " + acc.getAccountHolderLastName()
					+ "  Interest : " + interest);
		}
	}

	public void displayTotalBalance() {
		double total = 0;
		for (Account acc : accounts) {
			total += acc.getBalance();
		}
		System.out.println("\nTotal Bank Balance (all accounts): " + total);
	}

	public void displayLoanAccounts() {
		boolean found = false;
		System.out.println("\n Loan Accounts ");
		for (Account acc : accounts) {
			if (acc instanceof LoanAccount) {
				System.out.println(acc);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No loan accounts found!");
		}
	}

	public void displaySummary() {
		int savingCount = 0, salaryCount = 0, currentCount = 0, loanCount = 0;
		for (Account acc : accounts) {
			if (acc instanceof SavingAccount)
				savingCount++;
			else if (acc instanceof SalaryAccount)
				salaryCount++;
			else if (acc instanceof CurrentAccount)
				currentCount++;
			else if (acc instanceof LoanAccount)
				loanCount++;
		}

		System.out.println("\n Bank Summary : ");
		System.out.println("Total Accounts : " + accounts.size());
		System.out.println("Savings Accounts : " + savingCount);
		System.out.println("Salary Accounts : " + salaryCount);
		System.out.println("Current Accounts : " + currentCount);
		System.out.println("Loan Accounts : " + loanCount);
	}
	
	public Account searchAccount(int accNum) {
		
		Account newAcc = new CurrentAccount(accNum);
		
		for(Account a : accounts) {
			if(a.equals(newAcc)) {
				return a;
			}
		}
		return null;
	}
	
}
