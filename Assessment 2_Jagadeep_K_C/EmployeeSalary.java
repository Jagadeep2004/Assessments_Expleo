package Assessment;

import java.util.Scanner;

class Employee {

    
    private int employeeId;
    private String name;
    private String designation;
    private double salary;

   
    public Employee(int employeeId, String name, String designation, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    
    public void displayInfo() {
        System.out.println("\nEmployee Details");
        System.out.println("----------------------");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
    }


    public void increaseSalary(double percentage) {
        salary += (salary * percentage / 100);
        System.out.println("Salary increased by " + percentage + "%");
    }


    public void increaseSalary(double percentage, double bonus) {
        salary += (salary * percentage / 100) + bonus;
        System.out.println("Salary increased by " + percentage + "% and bonus " + bonus);
    }
}

public class EmployeeSalary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Designation: ");
        String designation = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, designation, salary);

        emp.displayInfo();

        while (true) {

            System.out.println("\nMenu");
            System.out.println("1. Increase Salary by Percentage");
            System.out.println("2. Increase Salary by Percentage with Bonus");
            System.out.println("3. Display Employee Details");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter percentage: ");
                double percentage = sc.nextDouble();
                emp.increaseSalary(percentage);
                emp.displayInfo();
            }

            else if (choice == 2) {
                System.out.print("Enter percentage: ");
                double percentage = sc.nextDouble();

                System.out.print("Enter bonus: ");
                double bonus = sc.nextDouble();

                emp.increaseSalary(percentage, bonus);
                emp.displayInfo();
            }

            else if (choice == 3) {
                emp.displayInfo();
            }

            else if (choice == 4) {
                System.out.println("Thank you... Program exited.");
                break;
            }

            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}