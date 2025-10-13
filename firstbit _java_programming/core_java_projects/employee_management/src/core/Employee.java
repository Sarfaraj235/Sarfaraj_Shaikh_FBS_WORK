package com.app.core;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

	private int empId;
	private String firstName;
	private String lastName;
	private String emailId;
	private Date joinDate;
	private double salary;
	private Department depId;
	public static SimpleDateFormat sdf;
	private AadharCard card;
	
	
	static {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
				
	}
	
	public Employee(int empId , String firstName, String lastName, String emailId,  Department depId, Date joinDate, double salary ) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.joinDate = joinDate;
		this.salary = salary;
		this.depId = depId;
	}
	
	
	public Employee(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		
		String result = card == null ? " aadhar card not yet linked " : card.toString();
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", joinDate=" + sdf.format(joinDate)+ ", salary=" + salary + " Department Id= " + this.depId +" ] " + result;
	} 
	
	public boolean equals(Object o) {
		
		if(o instanceof Employee)
			return this.empId == ((Employee) o).empId;
		else
			return false;
	}
	
	public void setDepId(Department newDep) {
		this.depId = newDep;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void linkAadharCard(int adharCardNo, Date creationDate , String location) {
		
		card = new AadharCard(adharCardNo,creationDate, location);
		
	}
	
	public class AadharCard{
		
		private int aadharCardNo;
		private Date creationDate;
		private String location;
		
		public AadharCard(int aadharCardNo, Date creationDate, String location ) {
			this.aadharCardNo = aadharCardNo;
			this.creationDate = creationDate;
			this.location = location;
		}

		@Override
		public String toString() {
			return "AadharCard [aadharCardNo=" + aadharCardNo + ", creationDate=" + sdf.format(creationDate) + ", location="
					+ location + "]";
		}
		
		
		
	}
	
	
	
}
