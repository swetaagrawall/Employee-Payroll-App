package com.example.EmployeePayrollApplication.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    @PostMapping("/add")
    public String addEmployee() {
        return "Employee added successfully!";
    }

    @PutMapping("/update")
    public String updateEmployee() {
        return "Employee updated successfully!";
    }

    @DeleteMapping("/delete")
    public String deleteEmployee() {
        return "Employee deleted successfully!";
    }
}

