package sep._12th;

class BankAccount
{
	int accountNum;
	String name;
	double balance;
	static double interestRate;

	public BankAccount(int an, String name, double b)
	{
		this.accountNum = an;
		this.name = name;
		this.balance = b;

	}
	public void setDetails(int an, String name, double b)
	{
		this.accountNum = an;
		this.name = name;
		this.balance = b;
		
	}
	static
	{
     		interestRate = 9.7;
	}

	public int getAccountNum()
	{
		return this.accountNum;

	}

	public String getName()
	{
		return this.name;

	}

	public double getBalance()
	{
		return this.balance;

	}

	public double getInterestRate()
	{
		return interestRate;

	}
	void display()
	{
		System.out.println("The account number is : " + accountNum);
		System.out.println("The name is : " + name);
		System.out.println("Total balance in account is : " + balance);
		System.out.println("The interest Rate on account is : " + interestRate);

	}
}

class TestBankAccount
{

	public static void main(String[] args)
	{

		BankAccount a1 = new BankAccount(1022, "sarfaraj Shaikh" , 700000);
	
		System.out.println(a1.getName()); 
		System.out.println(a1.getAccountNum());
		System.out.println(a1.getBalance());
		System.out.println(a1.getInterestRate());

		BankAccount a2 = new BankAccount(3944, "sohel Shaikh" , 98000);
	
		System.out.println(a2.getName()); 
		System.out.println(a2.getAccountNum());
		System.out.println(a2.getBalance());
		System.out.println(a2.getInterestRate());

	
	}

}