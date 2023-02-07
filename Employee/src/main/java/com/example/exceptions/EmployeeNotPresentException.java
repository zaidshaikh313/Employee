package com.example.exceptions;

public class EmployeeNotPresentException extends Throwable{
    public EmployeeNotPresentException(String message){
        super(message);
    }
}
