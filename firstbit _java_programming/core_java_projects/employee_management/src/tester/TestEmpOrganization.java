package com.app.tester;

import com.app.core.*;
import com.app.custom_exception.EmpValidationException;
import static com.app.utils.ValidationRules.*;
import java.util.ArrayList;
import java.util.Scanner;
import static com.app.core.Employee.sdf;

public class TestEmpOrganization {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			ArrayList<Employee> employees = new ArrayList<>();

			boolean exit = false;

			while (!exit) {
				System.out.println("Menu");
				System.out.println("1. Hire Employee");
				System.out.println("2. Display All Employee's Details");
				System.out.println("3. Update employee details");
				System.out.println("4. link aadhar card to Employee");
				System.out.println("5. Display specific employee detail");
				System.out.println("6. Delete emp Info");
				try {
					switch (sc.nextInt()) {

					case 1:
						System.out.println(
								"Enter Details of Employee -  empId , firstName, lastName, emailId, department id , joinDate,  salary");

						Employee e = validateAllInputs(sc.nextInt(), employees, sc.next(), sc.next(), sc.next(),
								sc.next(), sc.next(), sc.nextDouble());

						employees.add(e);

						break;

					case 2:
						System.out.println("Employee Details");
						for (Employee e1 : employees) {
							System.out.println(e1);

						}
						break;

					case 3:
						System.out.println("Enter Emp Id, New Department, Salary Increment");

						Employee details = getEmpDetails(sc.nextInt(), employees);

						details.setDepId(validateDepId(sc.next()));

						details.setSalary(details.getSalary() + sc.nextDouble());

						break;

						
					case 4:
						System.out.println("Enter Emp Id , aadhar card number, creation date , location");
						details = getEmpDetails(sc.nextInt(), employees);
						details.linkAadharCard(sc.nextInt(), sdf.parse(sc.next()), sc.next());
						System.out.println("Aadhar card linked successfully !!!");
						break;
						
					case 5:
						System.out.println("Enter emp id of employee");
						
						System.out.println(	getEmpDetails(sc.nextInt(), employees));
		
						break;
						
						
					case 6:
						System.out.println("Enter emp id of employee");
						
						details = getEmpDetails(sc.nextInt(), employees);
						
						int index = employees.indexOf(details);
					
						System.out.println( employees.remove(index)+" deleted successfully !!!");
						
					}
				}

				catch (Exception e) {
					e.printStackTrace();
				}

				sc.nextLine();

			}

		}

	}

}
