package com.company;

public class Department {
    private String name;
    private Employee[] allEmployees;
    private int numOfEmployees;

    public Department(String name, int maxEmployees){
        this.name = name;
        allEmployees = new Employee[maxEmployees];
        numOfEmployees = 0;
    }
    public String getName(){
        return name;
    }
    public boolean addEmployee(Employee theEmployee){
        if(numOfEmployees < allEmployees.length){
            allEmployees[numOfEmployees++] = theEmployee;
            return true;
        }
        return false;
    }
    public String toString(){
        StringBuffer str = new StringBuffer("Department '" + name + "' has " + numOfEmployees + " employee"
                                                + (numOfEmployees > 1 ? "s":"") + ":\n");
        for(int i = 0; i < numOfEmployees; i++){
            str.append((i+1) + ": " + allEmployees[i].toString() + "\n");
        }
        return str.toString();
    }
}
