package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Create a Payroll object
        System.out.print("Example Employees");
        Payroll employee1 = new Payroll("Jane Doe", 25, 40, 20, 40, 2, 4);
        Payroll employee2 = new Payroll("Jim Bordan", 25, 50, 20, 40, 2, 3);

        System.out.print("\n");

        // Display payroll

        employee1.displayPayroll();
        employee2.displayPayroll();

        //Enter New user

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Employee's name: ");
        String EmployeeName1 = scanner.nextLine();
        
        System.out.print("Enter the Employee's hourly Rate: ");
        double EmployeeRate1 = scanner.nextDouble();

        System.out.print("Enter the Employee's Hours: ");
        double EmployeeHours1 = scanner.nextDouble();

        System.out.print("Enter the Employee's number of dependants: ");
        int EmployeeDependants1 = scanner.nextInt();

        System.out.print("Select Employee Insurance Plan: ");
        System.out.print("(1) no plan\n");
        System.out.print("(2) single plan\n");
        System.out.print("(3) married plan\n");
        System.out.print("(4) married with children plan\n");
        int EmployeeInsureance1 = scanner.nextInt();

        // Create Employee and output payroll file
        Payroll employee3 = new Payroll(EmployeeName1, EmployeeRate1, EmployeeHours1, 20, 40, EmployeeDependants1, EmployeeInsureance1);
        employee3.displayPayroll();
    }
}
