package com.example.exceptions;

public class EmployeeAlreadyPresent extends Throwable{

    public EmployeeAlreadyPresent(String message){
        super(message);
    }

}
