package sep._3th;

class Date
{

  int day, month , year;
   String dayOfWeek;
}

class Test
{
  public static void main(String args[])
  {
   Date d1;
   d1 = new Date();

   System.out.println(d1.day + " " + d1.month + " " + d1.year + " "  + d1.dayOfWeek);

  }
}