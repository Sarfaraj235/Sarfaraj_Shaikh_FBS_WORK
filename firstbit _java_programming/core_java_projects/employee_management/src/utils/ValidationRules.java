package com.app.utils;

import java.text.ParseException;
import java.util.Date;
import com.app.custom_exception.EmpValidationException;
import static com.app.core.Employee.sdf;
import com.app.core.*;
import static com.app.core.Department.*;
import java.util.ArrayList;

public class ValidationRules {

	public static final int MIN_Length;
	public static final int MAX_Length;
	public static Date reqJoinDate;

	static {
		MIN_Length = 4;
		MAX_Length = 15;
		try {
			reqJoinDate = sdf.parse("1/4/2021");
		} catch (ParseException p) {
			System.out.println(p.getMessage());
		}
	}

	public static Employee validateAllInputs(int empId, ArrayList<Employee> employees,  String firstName, String lastName, String email, String depId,
			String joinDate, double salary) throws EmpValidationException, ParseException {
		
		int newEmpId = validateEmpId(empId, employees);
		String newFirstName =validateName(firstName, " First");	
		String newLastName =validateName(lastName, " Last");
		String newEmail = validateEmail(email);
		Department newDepId = validateDepId(depId);
		
		return new Employee(newEmpId, newFirstName, newLastName, newEmail , newDepId, sdf.parse(joinDate), salary);

	}

	public static String validateEmail(String email) throws EmpValidationException {

		if (!email.contains("@") && !email.endsWith(".com")) {
			throw new EmpValidationException("Not a valid email");
		} else {
			return email;
		}
	}

	public static String validateName(String name, String msg) throws EmpValidationException {

		if (name.length() >= MIN_Length && name.length() <= MAX_Length) {
			return name;
		} else {
			throw new EmpValidationException("Invalid " + msg + " Name !!!");
		}
	}

	public static Department validateDepId(String depId) {

		try {
			return valueOf(depId.toUpperCase());
		} catch (IllegalArgumentException i) {

			throw new IllegalArgumentException("Invalid Department Id!!!");
		}
	}

	public static Date parseAndValidateJoinDate(String jn) throws ParseException, EmpValidationException {

		Date joinDate = sdf.parse(jn);
		if (joinDate.after(reqJoinDate)) {
			return joinDate;
		} else {
			throw new EmpValidationException("InValid Joining Date");
		}
	}

	public static int validateEmpId(int empId, ArrayList<Employee> employees) throws EmpValidationException {

		Employee newEmp = new Employee(empId);

			if(employees.contains(newEmp))
				throw new EmpValidationException("duplication of the employee Id is not allowed !!! ");
			
		return empId;

	}
	
	public static Employee getEmpDetails(int empId , ArrayList<Employee> employees) throws EmpValidationException{
		
		Employee newEmp = new Employee(empId);
		
		int index = employees.indexOf(newEmp);
		
		if(index==-1)
			throw new EmpValidationException("invalid employee id !!!");
		
		return employees.get(index);
	
		
	}

}
