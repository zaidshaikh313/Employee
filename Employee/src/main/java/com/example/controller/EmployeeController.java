package com.example.controller;

import com.example.exceptions.EmployeeAlreadyPresent;
import com.example.exceptions.EmployeeNotPresentException;
import com.example.model.AddEmployeeDto;
import com.example.model.Employee;
import com.example.model.ServerResponseDto;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

@RestController
@RequestMapping("/emp")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @DeleteMapping("/{empId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("empId") long empId)  {
        try {
            return new ResponseEntity<ServerResponseDto>(new ServerResponseDto(employeeService.deleteEmployee(empId)), HttpStatus.ACCEPTED);
        } catch (EmployeeNotPresentException e) {
            return new ResponseEntity<>(new ServerResponseDto(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<?> saveEmployee(@RequestBody AddEmployeeDto employee){
        try {
            return new ResponseEntity<ServerResponseDto>(new ServerResponseDto(employeeService.addEmployee(employee)), HttpStatus.OK);
        }catch (EmployeeAlreadyPresent exception){
            return new ResponseEntity<>(new ServerResponseDto(exception.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{empId}")
    public ResponseEntity<?> updateEmployee(@PathVariable("empId") Long empId,  @RequestBody AddEmployeeDto employee){
        try {
            return new ResponseEntity<ServerResponseDto>(new ServerResponseDto(employeeService.updateEmployee(empId,employee)), HttpStatus.OK);
        }
         catch (EmployeeNotPresentException exception) {
            return new ResponseEntity<>(new ServerResponseDto(exception.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<?> getEmployees(){
        return new ResponseEntity<>(new ServerResponseDto("", employeeService.getEmployees()),HttpStatus.OK);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("empId") long empId){
        return new ResponseEntity<>(new ServerResponseDto("", employeeService.getEmployeeById(empId)),HttpStatus.OK);
    }


}
