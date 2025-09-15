package sep._4th;

class Date
{

	int day, month , year;
	String dayOfWeek;
  
  void setDetails(int d, int m , int y, String dOW)
  {
	this.day = d;
	this.month = m;
	this.year = y;
	this.dayOfWeek = dOW;  
  }
  String getDetails()
  {
	return day + " " + month +" " + year  + " " + dayOfWeek;
  }
  void display()
  {
	System.out.println("Day is : " + day);
	System.out.println("Month is : " + month);
	System.out.println("Year is : " + year);
	System.out.println("Day Of Week is : " + dayOfWeek);

  }
}

class TestDate
{
  public static void main(String args[])
  {
	Date d1;
	d1 = new Date();

	d1.setDetails(2, 3, 2012, "monday");
  
	//System.out.println(d1.getDetails());

	d1.display();
  }
}