package tester;

import core.*;
import bank_utils.*;
import static exception_utils.ValidationRules.validateDepositAndWithdraw;
import java.util.ArrayList;
import java.util.Scanner;
import static core.Bank.*;
import static core.Account.*;

public class BankManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Report report = new Report(getAccounts());
		ArrayList<Transaction> transactions = new ArrayList<>();

		boolean exit = false;

		while (!exit) {

			System.out.println("\nBANK MANAGEMENT MENU\n");
			System.out.println("1.  Create a New Account");
			System.out.println("2.  Close an Existing Account");
			System.out.println("3.  Display All Account Details");
			System.out.println("4.  Display Specific Account Details");
			System.out.println("5.  Deposit Amount");
			System.out.println("6.  Withdraw Amount");
			System.out.println("7.  Generate Interest Report");
			System.out.println("8.  Show Total Balance of All Accounts");
			System.out.println("9.  List All Loan Accounts");
			System.out.println("10. Display Account Summary");
			System.out.println("11. Show All Transaction Details");
			System.out.println("12. Show Specific Transaction Details");
			System.out.println("13. Exit");

			System.out.print("\nEnter your choice : ");
			try {
				switch (sc.nextInt()) {

				case 1:
					openAccount();
					break;

				case 2:
					closeAccount();
					break;

				case 3:
					report.displayAllAccounts();
					break;

				case 4:
					System.out.println("Enter account number to display its account details");
					report.displaySpecificAccount(sc.nextInt(), report);
					break;

				case 5:
					System.out.println("Enter valid account number to deposit: ");

					Account tempAcc = report.searchAccount(sc.nextInt());

					if (tempAcc != null) {
						System.out.print("Enter deposit amount: ");
						tempAcc.deposit(validateDepositAndWithdraw(sc.nextDouble()));
					} else {
						System.out.println("Account not found!");
					}
					break;

				case 6:
					System.out.println("Enter valid account number to withdraw: ");

					tempAcc = report.searchAccount(sc.nextInt());

					if (tempAcc != null) {
						System.out.print("Enter withdrawn amount: ");
						tempAcc.withdraw(validateDepositAndWithdraw(sc.nextDouble()));
					} else {
						System.out.println("Account not found!");
					}
					break;

				case 7:
					report.displayInterestReport();
					break;

				case 8:
					report.displayTotalBalance();
					break;

				case 9:
					report.displayLoanAccounts();
					break;

				case 10:
					report.displaySummary();
					break;

				case 11:
					transactions = getTransactions();
					if(transactions == null) {
						System.out.println("There are no transactions available yet !!!");
					}
					for (Transaction t : transactions) {
						System.out.println(t);
					}
					break;

				case 12:
					System.out.println("Enter a valid account number to view its transaction details: ");

					Transaction newTransaction = new Transaction(sc.nextInt());

					int index = transactions.indexOf(newTransaction);
					if (index != -1) {
						Transaction t = transactions.get(index);
						for(Transaction tr : transactions) {
							if(tr.equals(t)) {
								System.out.println(tr);
							}
						}
					} else {
						System.out.println("Account not found!");
					}
					break;

				case 13:
					exit = true;
					break;

				default:
					System.out.println("Invaild choice !!!");

				}
			}

			catch (Exception e) {
				System.out.println(e);
			}
			sc.nextLine();
		}
		sc.close();
	}

}
