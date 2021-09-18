package com.company;

public class Employee {
    private String name;
    private String phone;

    public Employee(String name, String phone){
        setName(name);
        setPhone(phone);
    }
    public Employee(Employee other){
        this(other.name, other.phone);
    }
    public String toString(){
        return "Name: " + name + "\n   Phone: " + phone + "\n--------------";
    }
    public String getName(){
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
