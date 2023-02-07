package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "select * from Employee where name=? and address=?",nativeQuery = true)
    Optional<Employee> findByNameAndAddress(String name, String address);
}
