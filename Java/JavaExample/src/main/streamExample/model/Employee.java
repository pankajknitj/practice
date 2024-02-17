package main.streamExample.model;

import java.util.List;

public class Employee {
    String name;
    int age;
    String department;
    double salary;
    List<Address> addresses;

    public Employee(String name, int age, String dept, double salary, List<Address> addresses) {
        this.name = name;
        this.age = age;
        this.department = dept;
        this.salary = salary;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
