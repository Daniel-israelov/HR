package com.company;
import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);
    public static void MENU(int maxEmployees, int maxDepartments){
        HR theHR = new HR(maxEmployees, maxDepartments);
        int answer;
        final int EXIT = -1;
        do{
            System.out.println();
            System.out.println("Choose from the following:");
            System.out.println("[1] Add department.");
            System.out.println("[2] Add employees.");
            System.out.println("[3] Show all data.");
            System.out.println("[4] Change employee name.");
            System.out.println("[" + EXIT + "] EXIT.");
            System.out.print("Enter your choice: ");
            answer = s.nextInt();
            s.nextLine();

            switch (answer){
                case 1:
                    readDepartments(theHR);
                    break;
                case 2:
                    readEmployees(theHR);
                    break;
                case 3:
                    System.out.println(theHR.toString());
                    break;
                case 4:
                    changeEmployeeName(theHR);
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }while(answer != EXIT);
    }
    public static void readDepartments(HR theHR){
        boolean fContinue = true;

        do{
            String departmentName;
            int maxEmployees;

            System.out.print("Enter the name of the department: ");
            departmentName = s.nextLine();
            System.out.print("Enter max employees: ");
            maxEmployees = s.nextInt();

            boolean res = theHR.addDepartment(departmentName,maxEmployees);
            if(res){
                System.out.print("Add another department (Y/N)? ");
                char answer = s.next().charAt(0);
                s.nextLine();

                if(answer == 'n' || answer == 'N')
                    fContinue = false;
                else if(answer != 'y' && answer != 'Y')
                    System.out.println("Invalid answer.");
            }
            else {
                System.out.println("Can't add anymore departments.");
                fContinue = false;
            }
        }while(fContinue);
    }
    public static void readEmployees(HR theHR){
        boolean fContinue = true;

        do{
            String employeeName, employeePhone, departmentName;
            System.out.print("Enter employee's name: ");
            employeeName = s.nextLine();
            System.out.print("Enter employee's phone: ");
            employeePhone = s.nextLine();
            System.out.print("Enter employee's department: ");
            departmentName = s.nextLine();

            boolean res = theHR.addEmployee(new Employee(employeeName,employeePhone), departmentName);
            if(res){
                System.out.print("\nAdd another employee (Y/N)? ");
                char answer = s.next().charAt(0);
                s.nextLine();

                if(answer == 'n' || answer =='N')
                    fContinue =false;
                else if(answer != 'y' && answer != 'Y')
                    System.out.println("Invalid answer.");
            }
            else{
                System.out.println("Failed adding the employee.\nFull capacity or department doesn't exist.");
                fContinue= false;
            }
        }while(fContinue);
    }
    public static void changeEmployeeName(HR theHR){
        String name, newName;
        System.out.print("Enter name of employee you with to change: ");
        name = s.nextLine();
        Employee theEmployee = theHR.getEmployeeByName(name);
        if(theEmployee == null){
            System.out.println("There's no employee with that name.");
            return;
        }
        System.out.print("Enter new name: ");
        newName = s.nextLine();
        theEmployee.setName(newName);
        System.out.println("Name changed successfully.");
    }

    public static void main(String[] args) {
        int maxEmployees, maxDepartments;

        System.out.print("Enter maximum employees: ");
        maxEmployees = s.nextInt();

        System.out.print("Enter maximum Departments: ");
        maxDepartments = s.nextInt();

        MENU(maxEmployees,maxDepartments);
    }
}
