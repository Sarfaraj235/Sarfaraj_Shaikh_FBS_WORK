package exception_utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

import custom_exceptions.*;
import core.Account;
import core.CurrentAccount;

public class ValidationRules {

	public static int validateAccountNumber(int accNum, ArrayList<Account> accounts) throws BankAccountExceptionHandling{
		
		Account tempAcc = new CurrentAccount(accNum);
		
		for(Account a : accounts) {
			if(a.equals(tempAcc)) {
				throw new BankAccountExceptionHandling("Duplicate account numbers are not allowed !!!.");
			}
		}
		return accNum;
			
	}
	public static String validateName( String msg,  String name) throws BankAccountExceptionHandling{
		if(name.length()>=3 && name.length()<=15) {
			return name;
		}
		throw new BankAccountExceptionHandling(
			    "Invalid "+ msg + "name !!! " + msg + " Name must be between 3 and 15 characters long !!!"
			);
	}
	
	public static Double validateBalance(Double balance) throws BankAccountExceptionHandling{
		
		if(balance<=0) {
			throw new BankAccountExceptionHandling("Invalid Balance !!!");
		}
		return balance;
	}
	
	public static LocalDate validateDate(LocalDate date) throws BankAccountExceptionHandling {
		
		if(date.isAfter(LocalDate.now())) {
			throw new BankAccountExceptionHandling("Invalid Date !!!");
		}
		return date;
	}
	public static double validateDepositAndWithdraw(double amount) throws BankAccountExceptionHandling {
		if(amount<=0) {
			throw new BankAccountExceptionHandling("Invalid Amount !!!");
		}
		return amount;
		
	}
	
}