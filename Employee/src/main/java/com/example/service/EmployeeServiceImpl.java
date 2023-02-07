package com.example.service;

import com.example.exceptions.EmployeeAlreadyPresent;
import com.example.exceptions.EmployeeNotPresentException;
import com.example.model.AddEmployeeDto;
import com.example.model.Employee;
import com.example.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeRepository employeRepository;

    public String addEmployee(AddEmployeeDto employee) throws EmployeeAlreadyPresent {

        Optional<Employee> optionalEmployee = employeRepository.findByNameAndAddress(employee.getName(),employee.getAddress());
        if (optionalEmployee.isPresent()){
            throw new EmployeeAlreadyPresent( "Employee with same and address already exist");
        }
        employeRepository.save(EmployeeDtoToEmployee(employee));
        return "Employee is added to Database";
    }
    public String updateEmployee(Long empId,AddEmployeeDto employee) throws EmployeeNotPresentException {
        Optional<Employee> optionalEmployee = employeRepository.findById(empId);
        optionalEmployee.orElseThrow(()->new EmployeeNotPresentException("Employee is not present"));
        Employee employee1 = EmployeeDtoToEmployee(employee);
        employee1.setEmpId(empId);
        employeRepository.save(employee1);
        return "Employee record Updated Successfully";

    }

    public  String deleteEmployee(long empId) throws EmployeeNotPresentException {
        Optional<Employee> optionalEmployee = employeRepository.findById(empId);
            optionalEmployee.orElseThrow(()-> new EmployeeNotPresentException("Employee not present"));
            employeRepository.deleteById(empId);
            return "Employee record Deleted Successfully";


    }
    public List<Employee> getEmployees(){
        return employeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(long empId){
        return employeRepository.findById(empId);
    }

    public Employee EmployeeDtoToEmployee(AddEmployeeDto addEmployeeDto){
        return new Employee(addEmployeeDto.getName(),addEmployeeDto.getAddress(),addEmployeeDto.getSalary(),addEmployeeDto.getDomain());
    }

}
