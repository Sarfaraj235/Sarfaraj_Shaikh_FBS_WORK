package sep._12th;

class ElectricityBill
{
	private int custmerBillId;
	private String name;
	private int units;
	private static double ratePerUnit;

	ElectricityBill(int cbi, String name , int units)
	{
		this.custmerBillId = cbi;
		this.name = name;
		this.units = units;
		
	}
	static{

		ratePerUnit = 10;
	}

	static void setratePerUnit(double rpu){

		ratePerUnit = rpu;
	}

	int getcustmerBillId()
	{
		return custmerBillId;
	}
	String getname()
	{
		return name;
	}
	int getunits()
	{
		return units;
	}
	static double ratePerUnit()
	{
		return ratePerUnit;
	}

	double calculateElectricityBill(){

		return (this.units * ratePerUnit);
	}
	
	public String toString()
	{
		return custmerBillId + " " + name + " " + units + " " + "Total Elenctricity Bill is " + calculateElectricityBill();
	}

}

class TestElectricityBill
{

	public static void main(String args[])
	{
		ElectricityBill e1 = new ElectricityBill(101, "khalil shaikh" , 76);

		//System.out.println(e1.toString);

		ElectricityBill.setratePerUnit(12);

		System.out.println(e1.toString());

		ElectricityBill e2 = new ElectricityBill(102, "yusuf shaikh" , 59);

		System.out.println(e2.toString());
	
		
		ElectricityBill e3 = new ElectricityBill(101, "mustafa shaikh" , 81);

		System.out.println(e3.toString());
			
	}

}