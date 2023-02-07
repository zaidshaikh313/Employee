package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long empId;

    private String name;

    private String address;
    private long salary;
    private String domain;

    public Employee(String name, String address, long salary, String domain) {

        this.name = name;
        this.address = address;
        this.salary = salary;
        this.domain = domain;
    }

    public Employee() {
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getEmpId() {
        return empId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
