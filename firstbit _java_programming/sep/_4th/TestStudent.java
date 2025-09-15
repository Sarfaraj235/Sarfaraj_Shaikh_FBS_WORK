package sep._4th;

class Student
{
	int studentId;
	String studentName;
	double percentage;

  void setDetails(int id, String name, double percentage)
  {

	studentId = id;
	studentName = name;
	this.percentage = percentage;

  }

  String getDetails()
  {
	return "Student Details : " + studentId + " " + studentName + " " + percentage;
  }

  void display()
  {
	System.out.println("Student Id is : " + studentId);
	System.out.println("Student Name is : " + studentName);
	System.out.println("Student Percentage is : " + percentage);
  }

}

class TestStudent
{
  public static void main(String [] args)
  {
	Student s1;
   
	s1 = new Student();
	s1.setDetails(101, "Sameer Pathan", 89.67);

	//System.out.println(s1.getDetails());

	s1.display();
  }
}