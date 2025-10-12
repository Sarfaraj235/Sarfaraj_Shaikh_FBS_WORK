package core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import static exception_utils.ValidationRules.*;

public class Bank {

	public static String branchName;
	public static String branchCode;
	private static ArrayList<Account> accounts;
	public static DateTimeFormatter fdt;
	public static Scanner sc;
	// static block to initialize static members
	static {
		branchName = "Diamond S";
		branchCode = "DS1066";
		accounts = new ArrayList<>();
		fdt = DateTimeFormatter.ofPattern("d/M/yyyy");
		 sc = new Scanner(System.in);
	}

	public static String getBranchName() {
		return branchName;
	}

	public static void setBranchName(String branchName) {
		Bank.branchName = branchName;
	}

	public static String getBranchCode() {
		return branchCode;
	}

	public static void setBranchCode(String branchCode) {
		Bank.branchCode = branchCode;
	}

	public static ArrayList<Account> getAccounts() {
		return accounts;
	}

	public static void setAccounts(ArrayList<Account> accounts) {
		Bank.accounts = accounts;
	}

	// to create new account
	public static void openAccount() {
		try {
			System.out.println("\nMenu\n1.Saving Account\n2.Salary Account\n3.Current Account\n4.Loan Account");

			switch (sc.nextInt()) {
			case 1:
				System.out.println(
						"Enter Account Details - AccountNumber, AccountHolderFirstName, AccountHolderLastName,  Balance , DateOfOpening (d/m/yyyy)");
				Account savingAccount = new SavingAccount(validateAccountNumber(sc.nextInt(), accounts),
						validateName("First ", sc.next()), validateName(" Last ", sc.next()),
						validateBalance(sc.nextDouble()), validateDate(LocalDate.parse(sc.next(), fdt)));
				accounts.add(savingAccount);
				System.out.println("Saving account created successfully!");
				break;

			case 2:
				System.out.println(
						"Enter Account Details - AccountNumber, AccountHolderFirstName, AccountHolderLastName, Balance , DateOfOpening (d/m/yyyy) , Last Transaction Date");
				Account salaryAccount = new SalaryAccount(validateAccountNumber(sc.nextInt(), accounts),
						validateName("First ", sc.next()), validateName(" Last ", sc.next()),
						validateBalance(sc.nextDouble()), validateDate(LocalDate.parse(sc.next(), fdt)),
						LocalDate.parse(sc.next(), fdt));
				accounts.add(salaryAccount);
				System.out.println("Salary account created successfully!");
				break;

			case 3:
				System.out.println(
						"Enter Account Details - AccountNumber, AccountHolderFirstName, AccountHolderLastName, Balance , DateOfOpening (d/m/yyyy) , OverDraftLimit, OverDraftUsed");
				Account currentAccount = new CurrentAccount(validateAccountNumber(sc.nextInt(), accounts),
						validateName("First ", sc.next()), validateName(" Last ", sc.next()),
						validateBalance(sc.nextDouble()), validateDate(LocalDate.parse(sc.next(), fdt)),
						sc.nextDouble(), sc.nextDouble());
				accounts.add(currentAccount);
				System.out.println("Current account created successfully!");
				break;

			case 4:
				System.out.println(
						"Enter Account Details - AccountNumber, AccountHolderFirstName, AccountHolderLastName, Loan Amount , DateOfOpening (d/m/yyyy)");
				Account loanAccount = new LoanAccount(validateAccountNumber(sc.nextInt(), accounts),
						validateName("First ", sc.next()), validateName(" Last ", sc.next()),
						validateBalance(sc.nextDouble()), validateDate(LocalDate.parse(sc.next(), fdt)));
				accounts.add(loanAccount);
				System.out.println("Loan account created successfully!");
				break;

			default:
				System.out.println("Invalid choice !!!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		sc.nextLine();
	}

	public static void closeAccount() {
		try(Scanner sc = new Scanner(System.in)) {
			if (accounts.isEmpty()) {
				System.out.println("No accounts available to close!!!");
				return;
			}

			System.out.println("Enter valid account number to close: ");
			int accNum = sc.nextInt();

			Account tempAcc = new CurrentAccount(accNum);

			int index = accounts.indexOf(tempAcc);

			if (index != -1) {
				Account removed = accounts.remove(index);
				System.out.println("Account closed successfully: " + removed.getAccountNumber());
			} else {
				System.out.println("Account not found!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}


}
