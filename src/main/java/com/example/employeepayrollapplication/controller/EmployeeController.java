package com.example.employeepayrollapplication.controller;
import com.example.employeepayrollapplication.dto.EmployeeDTO;
import com.example.employeepayrollapplication.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeePayrollService;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    @PostMapping("/add")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee) {
        return employeePayrollService.addEmployee(employee);
    }

    // Update Employee By Name
    @PutMapping("/update/{name}")
    public EmployeeDTO updateEmployee(@PathVariable String name, @RequestBody EmployeeDTO updatedEmployee) {
        return employeePayrollService.updateEmployeeByName(name, updatedEmployee);
    }

    // Delete Employee By Name
    @DeleteMapping("/delete/{name}")
    public String deleteEmployee(@PathVariable String name) {
        boolean isDeleted = employeePayrollService.deleteEmployeeByName(name);
        return isDeleted ? "Employee deleted successfully" : "Employee not found";
    }

    // Get All Employees
    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    // Get Employees by Name (New Endpoint)
    @GetMapping("/name/{name}")
    public List<EmployeeDTO> getEmployeesByName(@PathVariable String name) {
        return employeePayrollService.getEmployeesByName(name);
    }
}