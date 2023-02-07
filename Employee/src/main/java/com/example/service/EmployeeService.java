package com.example.service;

import com.example.exceptions.EmployeeAlreadyPresent;
import com.example.exceptions.EmployeeNotPresentException;
import com.example.model.AddEmployeeDto;
import com.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {

    public String addEmployee(AddEmployeeDto employee) throws EmployeeAlreadyPresent;
    public String updateEmployee(Long empId,AddEmployeeDto employee) throws EmployeeNotPresentException;
    public  String deleteEmployee(long empId) throws EmployeeNotPresentException;
    public List<Employee> getEmployees();
    public Optional<Employee> getEmployeeById(long empId);
}
